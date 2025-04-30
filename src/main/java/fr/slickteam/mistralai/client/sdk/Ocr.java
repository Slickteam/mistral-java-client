package fr.slickteam.mistralai.client.sdk;

import fr.slickteam.mistralai.client.lib.Config;
import fr.slickteam.mistralai.client.models.OCRBlock;
import fr.slickteam.mistralai.client.models.OCRRequest;
import fr.slickteam.mistralai.client.models.OCRResponse;
import fr.slickteam.mistralai.client.utils.JSONUtils;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static fr.slickteam.mistralai.client.utils.ContentTypes.APPLICATION_JSON;

/**
 * API resource for interacting with OCR (Optical Character Recognition) functionality.
 */
public class Ocr extends ApiResource {
    /**
     * Creates a new OCR API resource with the specified options.
     *
     * @param options The SDK options
     */
    public Ocr(Config.SDKOptions options) {
        super(options);
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
        // Convert request to JSON
        String requestBody = createOCRRequestJson(request);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(createURI("/v1/ocr"))
                .header("Content-Type", APPLICATION_JSON)
                .header("Accept", APPLICATION_JSON)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = sendRequest(httpRequest);

        if (response.statusCode() == 200) {
            return parseOCRResponse(response.body());
        } else {
            throw new IOException("Failed to process OCR request: " + response.statusCode());
        }
    }

    // Helper methods
    private String createOCRRequestJson(OCRRequest request) throws IOException {
        StringBuilder json = new StringBuilder();
        json.append("{");

        // Add model if present
        if (request.model != null && !request.model.isEmpty()) {
            json.append("\"model\":\"").append(request.model).append("\"");
        }

        // Add image
        if (json.length() > 1) {
            json.append(",");
        }

        if (request.image != null) {
            if (request.image instanceof File) {
                // If image is a File, read it and encode as base64
                File file = (File) request.image;
                byte[] fileContent = Files.readAllBytes(file.toPath());
                String base64Image = Base64.getEncoder().encodeToString(fileContent);
                json.append("\"image\":\"").append(base64Image).append("\"");
            } else if (request.image instanceof String) {
                // If image is already a base64 string
                json.append("\"image\":\"").append(request.image).append("\"");
            } else if (request.image instanceof byte[]) {
                // If image is a byte array
                String base64Image = Base64.getEncoder().encodeToString((byte[]) request.image);
                json.append("\"image\":\"").append(base64Image).append("\"");
            }
        }

        json.append("}");
        return json.toString();
    }

    private OCRResponse parseOCRResponse(String json) {
        OCRResponse response = new OCRResponse();
        response.id = JSONUtils.extractValue(json, "id");
        response.model = JSONUtils.extractValue(json, "model");
        response.text = JSONUtils.extractValue(json, "text");

        // Parse blocks if present
        List<OCRBlock> blocks = new ArrayList<>();
        String blocksJson = JSONUtils.extractArray(json, "blocks");
        if (blocksJson != null && !blocksJson.isEmpty()) {
            String[] blockEntries = blocksJson.split("\\{");
            for (int i = 1; i < blockEntries.length; i++) {
                String blockJson = "{" + blockEntries[i];
                int endIndex = blockJson.lastIndexOf("}");
                if (endIndex > 0) {
                    blockJson = blockJson.substring(0, endIndex + 1);
                    OCRBlock block = new OCRBlock();
                    block.text = JSONUtils.extractValue(blockJson, "text");

                    // Parse bounding box
                    String bboxJson = JSONUtils.extractArray(blockJson, "bbox");
                    if (bboxJson != null && !bboxJson.isEmpty()) {
                        String[] values = bboxJson.replaceAll("[\\[\\]]", "").split(",");
                        if (values.length == 4) {
                            block.bbox = new int[4];
                            for (int j = 0; j < 4; j++) {
                                block.bbox[j] = Integer.parseInt(values[j].trim());
                            }
                        }
                    }

                    blocks.add(block);
                }
            }
        }
        response.blocks = blocks;

        return response;
    }


}
