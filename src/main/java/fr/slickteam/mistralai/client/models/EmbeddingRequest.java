package fr.slickteam.mistralai.client.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request object for creating embeddings.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmbeddingRequest {
    /**
     * The model to use for generating embeddings.
     */
    @JsonProperty("model")
    private String model;

    /**
     * The input text to generate embeddings for.
     * Can be a String or List<String>.
     */
    @JsonProperty("input")
    private Object input;

    /**
     * The format to return the embeddings in.
     * Defaults to float if not specified.
     */
    @JsonProperty("encoding_format")
    private String encodingFormat;

    public EmbeddingRequest() {
    }

    public EmbeddingRequest(String model, Object input) {
        this.model = model;
        this.input = input;
    }

    public EmbeddingRequest(String model, Object input, String encodingFormat) {
        this.model = model;
        this.input = input;
        this.encodingFormat = encodingFormat;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Object getInput() {
        return input;
    }

    public void setInput(Object input) {
        this.input = input;
    }

    public String getEncodingFormat() {
        return encodingFormat;
    }

    public void setEncodingFormat(String encodingFormat) {
        this.encodingFormat = encodingFormat;
    }

    @Override
    public String toString() {
        return "EmbeddingRequest{" +
                "model='" + model + '\'' +
                ", input=" + input +
                ", encodingFormat='" + encodingFormat + '\'' +
                '}';
    }
}
