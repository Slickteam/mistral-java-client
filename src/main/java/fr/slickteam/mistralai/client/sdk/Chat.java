package fr.slickteam.mistralai.client.sdk;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import fr.slickteam.mistralai.client.lib.Config;
import fr.slickteam.mistralai.client.models.ChatCompletionRequest;
import fr.slickteam.mistralai.client.models.ChatCompletionResponse;
import fr.slickteam.mistralai.client.models.ChatCompletionStreamEvent;

import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Consumer;

import static fr.slickteam.mistralai.client.utils.ContentTypes.APPLICATION_JSON;
import static fr.slickteam.mistralai.client.utils.ContentTypes.EVENT_STREAM;

/**
 * API resource for interacting with chat functionality.
 */
public class Chat extends ApiResource {

    private static final System.Logger log = System.getLogger(Chat.class.getName());

    /**
     * Creates a new chat API resource with the specified options.
     *
     * @param options The SDK options
     */
    public Chat(Config.SDKOptions options) {
        super(options);
    }

    /**
     * Chat Completion
     *
     * @param request The chat completion request
     * @return The chat completion response
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public ChatCompletionResponse complete(ChatCompletionRequest request) throws IOException, InterruptedException {
        log.log(System.Logger.Level.DEBUG, "Chat complete : Request: " + request);
        System.out.println( "Chat complete : Request: " + request);

        // Convert request to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.registerModule(new JavaTimeModule());
        String requestBody = objectMapper.writeValueAsString(request);

        log.log(System.Logger.Level.TRACE, "Request body: " + requestBody);
        System.out.println( "Request body: " + requestBody);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(createURI("/v1/chat/completions"))
                .header("Content-Type", APPLICATION_JSON)
                .header("Accept", APPLICATION_JSON)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = sendRequest(httpRequest);
        log.log(System.Logger.Level.TRACE, "Response body: " + response.body());
        System.out.println("Response body: " + response.body());

        if (response.statusCode() == 200) {
            return objectMapper.readValue(response.body(), ChatCompletionResponse.class);
        } else {
            throw new IOException("Failed to complete chat: " + response.statusCode());
        }
    }

    /**
     * Stream chat completion
     * Mistral AI provides the ability to stream responses back to a client in order to allow partial results for certain requests.
     * Tokens will be sent as data-only server-sent events as they become available, with the stream terminated by a data: [DONE] message.
     * Otherwise, the server will hold the request open until the timeout or until completion, with the response containing the full result as JSON.
     *
     * @param request      The chat completion stream request
     * @param eventHandler The handler for completion events
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public void stream(ChatCompletionRequest request, Consumer<ChatCompletionStreamEvent> eventHandler) throws IOException, InterruptedException {
        // Set stream to true
        request.setStream(true);

        // Convert request to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String requestBody = objectMapper.writeValueAsString(request);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(createURI("/v1/chat/completions"))
                .header("Content-Type", APPLICATION_JSON)
                .header("Accept", EVENT_STREAM)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<InputStream> response = sendRequestGetResponseAsInputStream(httpRequest);

        if (response.statusCode() == 200) {
            // Process the event stream
            processEventStream(response.body(), eventHandler);
        } else {
            throw new IOException("Failed to stream chat: " + response.statusCode());
        }
    }

    private void processEventStream(InputStream stream, Consumer<ChatCompletionStreamEvent> eventHandler) throws IOException {
        // Simple SSE parser
        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(stream));
        StringBuilder eventData = new StringBuilder();
        String line;
        ObjectMapper objectMapper = new ObjectMapper();

        while ((line = reader.readLine()) != null) {
            if (line.startsWith("data: ")) {
                String data = line.substring(6);

                // Check if this is the end of the stream
                if ("[DONE]".equals(data.trim())) {
                    break;
                }

                // Parse the event data
                ChatCompletionStreamEvent event = objectMapper.readValue(data, ChatCompletionStreamEvent.class);
                if (event != null) {
                    eventHandler.accept(event);
                }
            }
        }
    }

}
