package fr.slickteam.mistralai.client.sdk;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.slickteam.mistralai.client.lib.Config;
import fr.slickteam.mistralai.client.models.*;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static fr.slickteam.mistralai.client.models.ClassificationResponse.parseClassificationResponse;
import static fr.slickteam.mistralai.client.models.ModerationResponse.parseModerationResponse;
import static fr.slickteam.mistralai.client.utils.ContentTypes.APPLICATION_JSON;

/**
 * API resource for interacting with classifiers.
 */
public class Classifiers extends ApiResource {
    /**
     * ObjectMapper for JSON serialization/deserialization
     */
    private final ObjectMapper objectMapper;

    /**
     * Creates a new classifiers API resource with the specified options.
     *
     * @param options The SDK options
     */
    public Classifiers(Config.SDKOptions options) {
        super(options);
        this.objectMapper = new ObjectMapper();
    }

    /**
     * Moderations
     *
     * @param request The moderation request
     * @return The moderation response
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public ModerationResponse moderate(ClassificationRequest request) throws IOException, InterruptedException {
        // Convert request to JSON
        String requestBody = objectMapper.writeValueAsString(request);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(createURI("/v1/classifiers/moderate"))
                .header("Content-Type", APPLICATION_JSON)
                .header("Accept", APPLICATION_JSON)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = sendRequest(httpRequest);

        if (response.statusCode() == 200) {
            return parseModerationResponse(response.body());
        } else {
            throw new IOException("Failed to moderate content: " + response.statusCode());
        }
    }

    /**
     * Chat Moderations
     *
     * @param request The chat moderation request
     * @return The moderation response
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public ModerationResponse moderateChat(ChatModerationRequest request) throws IOException, InterruptedException {
        // Convert request to JSON
        String requestBody = objectMapper.writeValueAsString(request);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(createURI("/v1/classifiers/moderate/chat"))
                .header("Content-Type", APPLICATION_JSON)
                .header("Accept", APPLICATION_JSON)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = sendRequest(httpRequest);

        if (response.statusCode() == 200) {
            return parseModerationResponse(response.body());
        } else {
            throw new IOException("Failed to moderate chat: " + response.statusCode());
        }
    }

    /**
     * Classifications
     *
     * @param request The classification request
     * @return The classification response
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public ClassificationResponse classify(ClassificationRequest request) throws IOException, InterruptedException {
        // Convert request to JSON
        String requestBody = objectMapper.writeValueAsString(request);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(createURI("/v1/classifiers/classify"))
                .header("Content-Type", APPLICATION_JSON)
                .header("Accept", APPLICATION_JSON)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = sendRequest(httpRequest);

        if (response.statusCode() == 200) {
            return parseClassificationResponse(response.body());
        } else {
            throw new IOException("Failed to classify content: " + response.statusCode());
        }
    }

    /**
     * Chat Classifications
     *
     * @param request The chat classification request
     * @return The classification response
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public ClassificationResponse classifyChat(ChatClassificationRequest request) throws IOException, InterruptedException {
        // Convert request to JSON
        String requestBody = objectMapper.writeValueAsString(request);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(createURI("/v1/classifiers/classify/chat"))
                .header("Content-Type", APPLICATION_JSON)
                .header("Accept", APPLICATION_JSON)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = sendRequest(httpRequest);

        if (response.statusCode() == 200) {
            return parseClassificationResponse(response.body());
        } else {
            throw new IOException("Failed to classify chat: " + response.statusCode());
        }
    }
}
