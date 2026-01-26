package fr.slickteam.mistralai.client.sdk;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.slickteam.mistralai.client.lib.Config;
import fr.slickteam.mistralai.client.models.ArchiveModelResponse;
import fr.slickteam.mistralai.client.models.BaseModelCard;
import fr.slickteam.mistralai.client.models.DeleteModelResponse;
import fr.slickteam.mistralai.client.models.FTModelCard;
import fr.slickteam.mistralai.client.models.ModelList;
import fr.slickteam.mistralai.client.models.UnarchiveModelResponse;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static fr.slickteam.mistralai.client.utils.ContentTypes.APPLICATION_JSON;

/**
 * API resource for interacting with models.
 */
public class Models extends ApiResource {
    private final ObjectMapper objectMapper;

    /**
     * Creates a new models API resource with the specified options.
     *
     * @param options The SDK options
     */
    public Models(Config.SDKOptions options) {
        super(options);
        this.objectMapper = new ObjectMapper();
        this.objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        this.objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    /**
     * List Models
     *
     * @return A list of available models
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public ModelList list() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(createURI("/v1/models"))
                .header("Accept", APPLICATION_JSON)
                .GET()
                .build();

        HttpResponse<String> response = sendRequest(request);

        if (response.statusCode() == 200) {
            return parseModelList(response.body());
        } else {
            throw new IOException("Failed to list models: " + response.statusCode());
        }
    }

    /**
     * Retrieve Model
     *
     * @param modelId The ID of the model to retrieve
     * @return Information about the model (BaseModelCard or FTModelCard)
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public BaseModelCard retrieve(String modelId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(createURI("/v1/models/" + modelId))
                .header("Accept", APPLICATION_JSON)
                .GET()
                .build();

        HttpResponse<String> response = sendRequest(request);

        if (response.statusCode() == 200) {
            return parseModel(response.body());
        } else {
            throw new IOException("Failed to retrieve model: " + response.statusCode());
        }
    }

    /**
     * Delete Model
     *
     * @param modelId The ID of the model to delete
     * @return The deletion status
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public DeleteModelResponse delete(String modelId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(createURI("/v1/models/" + modelId))
                .header("Accept", APPLICATION_JSON)
                .DELETE()
                .build();

        HttpResponse<String> response = sendRequest(request);

        if (response.statusCode() == 200) {
            return parseDeleteModelResponse(response.body());
        } else {
            throw new IOException("Failed to delete model: " + response.statusCode());
        }
    }

    /**
     * Update Fine Tuned Model
     *
     * @param modelId     The ID of the model to update
     * @param name        The new name for the model
     * @param description The new description for the model
     * @return The updated model information
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public BaseModelCard update(String modelId, String name, String description) throws IOException, InterruptedException {
        // Create JSON request body using Jackson
        class UpdateRequest {
            private String name;
            private String description;
            
            public UpdateRequest(String name, String description) {
                this.name = name;
                this.description = description;
            }
            
            public String getName() {
                return name;
            }
            
            public String getDescription() {
                return description;
            }
        }
        
        UpdateRequest updateRequest = new UpdateRequest(name, description);
        String requestBody = objectMapper.writeValueAsString(updateRequest);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(createURI("/v1/models/" + modelId))
                .header("Content-Type", APPLICATION_JSON)
                .header("Accept", APPLICATION_JSON)
                .method("PATCH", HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = sendRequest(request);

        if (response.statusCode() == 200) {
            return parseModel(response.body());
        } else {
            throw new IOException("Failed to update model: " + response.statusCode());
        }
    }

    /**
     * Archive Fine Tuned Model
     *
     * @param modelId The ID of the model to archive
     * @return The archive status
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public ArchiveModelResponse archive(String modelId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(createURI("/v1/models/" + modelId + "/archive"))
                .header("Accept", APPLICATION_JSON)
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = sendRequest(request);

        if (response.statusCode() == 200) {
            return parseArchiveModelResponse(response.body());
        } else {
            throw new IOException("Failed to archive model: " + response.statusCode());
        }
    }

    /**
     * Unarchive Fine Tuned Model
     *
     * @param modelId The ID of the model to unarchive
     * @return The unarchive status
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public UnarchiveModelResponse unarchive(String modelId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(createURI("/v1/models/" + modelId + "/unarchive"))
                .header("Accept", APPLICATION_JSON)
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = sendRequest(request);

        if (response.statusCode() == 200) {
            return parseUnarchiveModelResponse(response.body());
        } else {
            throw new IOException("Failed to unarchive model: " + response.statusCode());
        }
    }

    // Helper methods for parsing responses
    private ModelList parseModelList(String json) {
        try {
            return objectMapper.readValue(json, ModelList.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse model list response", e);
        }
    }

    private BaseModelCard parseModel(String json) {
        try {
            // Try to parse as FTModelCard first, fall back to BaseModelCard
            try {
                return objectMapper.readValue(json, FTModelCard.class);
            } catch (IOException e) {
                return objectMapper.readValue(json, BaseModelCard.class);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse model response", e);
        }
    }

    private DeleteModelResponse parseDeleteModelResponse(String json) {
        try {
            return objectMapper.readValue(json, DeleteModelResponse.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse delete model response", e);
        }
    }

    private ArchiveModelResponse parseArchiveModelResponse(String json) {
        try {
            return objectMapper.readValue(json, ArchiveModelResponse.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse archive model response", e);
        }
    }

    private UnarchiveModelResponse parseUnarchiveModelResponse(String json) {
        try {
            return objectMapper.readValue(json, UnarchiveModelResponse.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse unarchive model response", e);
        }
    }


}
