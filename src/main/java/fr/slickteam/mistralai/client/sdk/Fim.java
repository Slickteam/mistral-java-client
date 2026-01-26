package fr.slickteam.mistralai.client.sdk;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.slickteam.mistralai.client.lib.Config;
import fr.slickteam.mistralai.client.models.CompletionStreamEvent;
import fr.slickteam.mistralai.client.models.FIMCompletionRequest;
import fr.slickteam.mistralai.client.models.FIMCompletionResponse;
import fr.slickteam.mistralai.client.models.FIMCompletionStreamRequest;

import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Consumer;

import static fr.slickteam.mistralai.client.utils.ContentTypes.APPLICATION_JSON;
import static fr.slickteam.mistralai.client.utils.ContentTypes.EVENT_STREAM;

/**
 * API resource for interacting with Fill in the Middle (FIM) functionality.
 */
public class Fim extends ApiResource {
    /**
     * Creates a new FIM API resource with the specified options.
     *
     * @param options The SDK options
     */
    public Fim(Config.SDKOptions options) {
        super(options);
    }

    /**
     * Fim Completion
     *
     * @param request The FIM completion request
     * @return The FIM completion response
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public FIMCompletionResponse complete(FIMCompletionRequest request) throws IOException, InterruptedException {
        // Convert request to JSON
        String requestBody = createFIMCompletionRequestJson(request);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(createURI("/v1/fim/completions"))
                .header("Content-Type", APPLICATION_JSON)
                .header("Accept", APPLICATION_JSON)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = sendRequest(httpRequest);

        if (response.statusCode() == 200) {
            return parseFIMCompletionResponse(response.body());
        } else {
            throw new IOException("Failed to complete FIM request: " + response.statusCode());
        }
    }

    /**
     * Stream fim completion
     * Mistral AI provides the ability to stream responses back to a client in order to allow partial results for certain requests.
     * Tokens will be sent as data-only server-sent events as they become available, with the stream terminated by a data: [DONE] message.
     * Otherwise, the server will hold the request open until the timeout or until completion, with the response containing the full result as JSON.
     *
     * @param request      The FIM completion stream request
     * @param eventHandler The handler for completion events
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public void stream(FIMCompletionStreamRequest request, Consumer<CompletionStreamEvent> eventHandler) throws IOException, InterruptedException {
        // Set stream to true
        request.setStream(true);

        // Convert request to JSON
        String requestBody = createFIMCompletionStreamRequestJson(request);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(createURI("/v1/fim/completions"))
                .header("Content-Type", APPLICATION_JSON)
                .header("Accept", EVENT_STREAM)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<InputStream> response = sendRequestGetResponseAsInputStream(httpRequest);

        if (response.statusCode() == 200) {
            // Process the event stream
            processEventStream(response.body(), eventHandler);
        } else {
            throw new IOException("Failed to stream FIM request: " + response.statusCode());
        }
    }

    // Helper methods
    private String createFIMCompletionRequestJson(FIMCompletionRequest request) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return objectMapper.writeValueAsString(request);
    }

    private String createFIMCompletionStreamRequestJson(FIMCompletionStreamRequest request) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return objectMapper.writeValueAsString(request);
    }

    private FIMCompletionResponse parseFIMCompletionResponse(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return objectMapper.readValue(json, FIMCompletionResponse.class);
    }

    private void processEventStream(InputStream stream, Consumer<CompletionStreamEvent> eventHandler) throws IOException {
        // Simple SSE parser
        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(stream));
        String line;

        while ((line = reader.readLine()) != null) {
            if (line.startsWith("data: ")) {
                String data = line.substring(6);

                // Check if this is the end of the stream
                if ("[DONE]".equals(data.trim())) {
                    break;
                }

                // Parse the event data
                CompletionStreamEvent event = parseCompletionEvent(data);
                if (event != null) {
                    eventHandler.accept(event);
                }
            }
        }
    }

    private CompletionStreamEvent parseCompletionEvent(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return objectMapper.readValue(json, CompletionStreamEvent.class);
    }
}
