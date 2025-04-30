package fr.slickteam.mistralai.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Response object for embedding requests.
 */
public class EmbeddingResponse {
    /**
     * The unique identifier for this embedding response.
     */
    @JsonProperty("id")
    private String id;

    /**
     * The type of object returned, which is 'list'.
     */
    @JsonProperty("object")
    private String object;

    /**
     * The model used to generate the embeddings.
     */
    @JsonProperty("model")
    private String model;

    /**
     * The list of embeddings generated from the input.
     */
    @JsonProperty("data")
    private List<Embedding> data;

    /**
     * Token usage information for this request.
     */
    @JsonProperty("usage")
    private Usage usage;

    public EmbeddingResponse() {
    }

    public EmbeddingResponse(String id, String object, String model, List<Embedding> data, Usage usage) {
        this.id = id;
        this.object = object;
        this.model = model;
        this.data = data;
        this.usage = usage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Embedding> getData() {
        return data;
    }

    public void setData(List<Embedding> data) {
        this.data = data;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    @Override
    public String toString() {
        return "EmbeddingResponse{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", model='" + model + '\'' +
                ", data.size=" + (data != null ? data.size() : "null") +
                ", usage=" + usage +
                '}';
    }
}
