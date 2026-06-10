package fr.slickteam.mistralai.client.model;

/**
 * Represents the properties of a model in the Mistral AI API.
 * This class contains information about the model's capabilities, such as context length and maximum tokens.
 */
public record ModelProperties(
    /**
     * The maximum number of tokens that can be processed in a single request.
     */
    String context_length,

    /**
     * The maximum number of tokens that can be generated in a response.
     */
    String max_tokens
) {
    /**
     * Returns a new Builder instance to create a ModelProperties.
     *
     * @return a new Builder instance
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder class for creating ModelProperties instances.
     */
    public static class Builder {
        private String context_length;
        private String max_tokens;

        /**
         * Sets the maximum number of tokens that can be processed in a single request.
         *
         * @param context_length the context length
         * @return this builder instance
         */
        public Builder context_length(String context_length) {
            this.context_length = context_length;
            return this;
        }

        /**
         * Sets the maximum number of tokens that can be generated in a response.
         *
         * @param max_tokens the maximum tokens
         * @return this builder instance
         */
        public Builder max_tokens(String max_tokens) {
            this.max_tokens = max_tokens;
            return this;
        }

        /**
         * Builds a new ModelProperties instance with the current builder values.
         *
         * @return a new ModelProperties instance
         */
        public ModelProperties build() {
            return new ModelProperties(context_length, max_tokens);
        }
    }
}
