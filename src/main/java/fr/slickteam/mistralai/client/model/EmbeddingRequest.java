package fr.slickteam.mistralai.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.slickteam.mistralai.client.type.EmbeddingDtype;
import java.util.List;
import java.util.Map;

/**
 * Represents a request to the embeddings endpoint of the Mistral AI API.
 * This class contains all parameters needed to generate embeddings for input texts.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EmbeddingRequest(
    /**
     * The model to use for generating embeddings.
     */
    String model,

    /**
     * The list of input texts to generate embeddings for.
     * Each string in the list will be converted to an embedding vector.
     */
    List<String> input,

    /**
     * Additional metadata for the request.
     */
    Map<String, String> metadata,

    /**
     * The dimension of the output embeddings when feature available.
     */
    Integer output_dimension,

    /**
     * The data type of the output embeddings when feature available.
     */
    EmbeddingDtype output_dtype,

    /**
     * The format in which the embeddings should be encoded.
     */
    String encoding_format
) {
    /**
     * Returns a new Builder instance to create an EmbeddingRequest.
     *
     * @return a new Builder instance
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder class for creating EmbeddingRequest instances.
     */
    public static class Builder {
        private String model;
        private List<String> input;
        private Map<String, String> metadata;
        private Integer output_dimension;
        private EmbeddingDtype output_dtype;
        private String encoding_format;

        /**
         * Sets the model to use for generating embeddings.
         *
         * @param model the model identifier
         * @return this builder instance
         */
        public Builder model(String model) {
            this.model = model;
            return this;
        }

        /**
         * Sets the list of input texts to generate embeddings for.
         *
         * @param input the list of input texts
         * @return this builder instance
         */
        public Builder input(List<String> input) {
            this.input = input;
            return this;
        }

        public Builder metadata(Map<String, String> metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder output_dimension(Integer output_dimension) {
            this.output_dimension = output_dimension;
            return this;
        }

        public Builder output_dtype(EmbeddingDtype output_dtype) {
            this.output_dtype = output_dtype;
            return this;
        }

        /**
         * Sets the encoding format for the embeddings.
         *
         * @param encoding_format the encoding format (typically "float")
         * @return this builder instance
         */
        public Builder encoding_format(String encoding_format) {
            this.encoding_format = encoding_format;
            return this;
        }

        /**
         * Builds a new EmbeddingRequest instance with the current builder values.
         *
         * @return a new EmbeddingRequest instance
         */
        public EmbeddingRequest build() {
            return new EmbeddingRequest(model, input, metadata, output_dimension, output_dtype, encoding_format);
        }
    }
}
