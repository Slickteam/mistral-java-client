package fr.slickteam.mistralai.client.model;

import java.util.List;

/**
 * Represents a response from the embeddings endpoint of the Mistral AI API.
 * This class contains the generated embeddings and metadata about the request.
 */
public record EmbeddingResponse(
    /**
     * The unique identifier for the embedding generation.
     */
    String id,

    /**
     * The object type, typically "list".
     */
    String object,

    /**
     * The list of embeddings generated for the input texts.
     */
    List<Embedding> data,

    /**
     * The model used for generating the embeddings.
     */
    String model,

    /**
     * Usage statistics for the request.
     */
    Usage usage
) {
    /**
     * Returns a new Builder instance to create an EmbeddingResponse.
     *
     * @return a new Builder instance
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder class for creating EmbeddingResponse instances.
     */
    public static class Builder {
        private String id;
        private String object;
        private List<Embedding> data;
        private String model;
        private Usage usage;

        /**
         * Sets the unique identifier for the embedding generation.
         *
         * @param id the embedding generation identifier
         * @return this builder instance
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the object type.
         *
         * @param object the object type (typically "list")
         * @return this builder instance
         */
        public Builder object(String object) {
            this.object = object;
            return this;
        }

        /**
         * Sets the list of generated embeddings.
         *
         * @param data the list of embeddings
         * @return this builder instance
         */
        public Builder data(List<Embedding> data) {
            this.data = data;
            return this;
        }

        /**
         * Sets the model used for generating the embeddings.
         *
         * @param model the model identifier
         * @return this builder instance
         */
        public Builder model(String model) {
            this.model = model;
            return this;
        }

        /**
         * Sets the usage statistics.
         *
         * @param usage the usage statistics
         * @return this builder instance
         */
        public Builder usage(Usage usage) {
            this.usage = usage;
            return this;
        }

        /**
         * Builds a new EmbeddingResponse instance with the current builder values.
         *
         * @return a new EmbeddingResponse instance
         */
        public EmbeddingResponse build() {
            return new EmbeddingResponse(id, object, data, model, usage);
        }
    }
}
