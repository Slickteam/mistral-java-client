package fr.slickteam.mistralai.client.sdk;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.slickteam.mistralai.client.lib.Config;
import fr.slickteam.mistralai.client.models.EmbeddingRequest;
import fr.slickteam.mistralai.client.models.EmbeddingResponse;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static fr.slickteam.mistralai.client.utils.ContentTypes.APPLICATION_JSON;

/**
 * API resource for interacting with embeddings.
 */
public class Embeddings extends ApiResource {

    private static final System.Logger log = System.getLogger(Embeddings.class.getName());

    /**
     * Creates a new embeddings API resource with the specified options.
     *
     * @param options The SDK options
     */
    public Embeddings(Config.SDKOptions options) {
        super(options);
    }

    /**
     * Embeddings
     * Creates embeddings for the given input.
     *
     * @param request The embedding request
     * @return The embedding response
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public EmbeddingResponse create(EmbeddingRequest request) throws IOException, InterruptedException {
        log.log(System.Logger.Level.DEBUG, "Embeddings create : Request: " + request);

        // Convert request to JSON using Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        String requestBody = objectMapper.writeValueAsString(request);

        log.log(System.Logger.Level.TRACE, "Request body: " + requestBody);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(createURI("/v1/embeddings"))
                .header("Content-Type", APPLICATION_JSON)
                .header("Accept", APPLICATION_JSON)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = sendRequest(httpRequest);
        log.log(System.Logger.Level.TRACE, "Response body: " + response.body());

        if (response.statusCode() == 200) {
            return objectMapper.readValue(response.body(), EmbeddingResponse.class);
        } else {
            throw new IOException("Failed to create embeddings: " + response.statusCode());
        }
    }
}
