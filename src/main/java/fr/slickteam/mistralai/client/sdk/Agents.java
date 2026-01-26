package fr.slickteam.mistralai.client.sdk;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.slickteam.mistralai.client.lib.Config;
import fr.slickteam.mistralai.client.models.AgentsCompletionRequest;
import fr.slickteam.mistralai.client.models.AgentsCompletionStreamRequest;
import fr.slickteam.mistralai.client.models.ChatCompletionResponse;
import fr.slickteam.mistralai.client.models.ChatCompletionStreamEvent;
import fr.slickteam.mistralai.client.utils.ContentTypes;

import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Consumer;

import static fr.slickteam.mistralai.client.utils.ContentTypes.APPLICATION_JSON;
import static fr.slickteam.mistralai.client.utils.ContentTypes.EVENT_STREAM;

/**
 * API resource for interacting with agents.
 */
public class Agents extends ApiResource {
    /**
     * Creates a new agents API resource with the specified options.
     *
     * @param options The SDK options
     */
    public Agents(Config.SDKOptions options) {
        super(options);
    }

    /**
     * Agents Completion
     *
     * @param request The agents completion request
     * @return The chat completion response
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public ChatCompletionResponse complete(AgentsCompletionRequest request) throws IOException, InterruptedException {
        // Convert request to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        String requestBody = objectMapper.writeValueAsString(request);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(createURI("/v1/agents/completions"))
                .header("Content-Type", APPLICATION_JSON)
                .header("Accept", APPLICATION_JSON)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = sendRequest(httpRequest);

        if (response.statusCode() == 200) {
            return objectMapper.readValue(response.body(), ChatCompletionResponse.class);
        } else {
            throw new IOException("Failed to complete agents request: " + response.statusCode());
        }
    }

    /**
     * Stream Agents completion
     *
     * @param request      The agents completion stream request
     * @param eventHandler The handler for completion events
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     *                              Tokens will be sent as data-only server-sent events as they become available, with the stream terminated by a data: [DONE] message.
     *                              Otherwise, the server will hold the request open until the timeout or until completion, with the response containing the full result as JSON.
     */
    public void stream(AgentsCompletionStreamRequest request, Consumer<ChatCompletionStreamEvent> eventHandler) throws IOException, InterruptedException {
        // Set stream to true
        request.setStream(true);

        // Convert request to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        String requestBody = objectMapper.writeValueAsString(request);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(createURI("/v1/agents/completions"))
                .header("Content-Type", APPLICATION_JSON)
                .header("Accept", EVENT_STREAM)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<InputStream> response = sendRequestGetResponseAsInputStream(httpRequest);

        if (response.statusCode() == 200) {
            // Process the event stream
            processEventStream(response.body(), eventHandler);
        } else {
            throw new IOException("Failed to stream agents request: " + response.statusCode());
        }
    }

    // Helper methods
    private void processEventStream(InputStream stream, Consumer<ChatCompletionStreamEvent> eventHandler) throws IOException {
        // Simple SSE parser
        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(stream));
        StringBuilder eventData = new StringBuilder();
        String line;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

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
