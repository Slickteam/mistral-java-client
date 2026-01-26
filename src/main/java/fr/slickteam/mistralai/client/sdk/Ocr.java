package fr.slickteam.mistralai.client.sdk;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.slickteam.mistralai.client.lib.Config;
import fr.slickteam.mistralai.client.models.ocr.OCRRequest;
import fr.slickteam.mistralai.client.models.ocr.OCRResponse;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static fr.slickteam.mistralai.client.utils.ContentTypes.APPLICATION_JSON;

/**
 * API resource for interacting with OCR (Optical Character Recognition) functionality.
 * This implementation is based on the updated OpenAPI specification.
 */
public class Ocr extends ApiResource {
    
    private final ObjectMapper objectMapper;

    /**
     * Creates a new OCR API resource with the specified options.
     *
     * @param options The SDK options
     */
    public Ocr(Config.SDKOptions options) {
        super(options);
        this.objectMapper = new ObjectMapper();
    }

    /**
     * OCR Process
     *
     * @param request The OCR request
     * @return The OCR response
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public OCRResponse process(OCRRequest request) throws IOException, InterruptedException {
        // Convert request to JSON using Jackson
        String requestBody = objectMapper.writeValueAsString(request);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(createURI("/v1/ocr"))
                .header("Content-Type", APPLICATION_JSON)
                .header("Accept", APPLICATION_JSON)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = sendRequest(httpRequest);

        if (response.statusCode() == 200) {
            return objectMapper.readValue(response.body(), OCRResponse.class);
        } else {
            throw new IOException("Failed to process OCR request: " + response.statusCode() + " - " + response.body());
        }
    }
}