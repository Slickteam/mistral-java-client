package fr.slickteam.mistralai.client.model;

import java.util.Map;

/**
 * Represents usage statistics for a request to the Mistral AI API.
 * This class contains information about the number of tokens used in the request and response.
 */
public record Usage(
    /**
     * The number of tokens used in the prompt/input.
     */
    Integer prompt_tokens,

    /**
     * The number of tokens used in the completion/output.
     */
    Integer completion_tokens,

    /**
     * The total number of tokens used (prompt + completion).
     */
    Integer total_tokens,

    /**
     * The number of seconds of audio in the prompt.
     */
    Integer prompt_audio_seconds,

    /**
     * Number of cached tokens.
     */
    Integer num_cached_tokens,

    /**
     * Token usage details for the prompt.
     */
    Map<String, Object> prompt_tokens_details
) {
    /**
     * Returns a new Builder instance to create a Usage.
     *
     * @return a new Builder instance
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder class for creating Usage instances.
     */
    public static class Builder {
        private Integer prompt_tokens;
        private Integer completion_tokens;
        private Integer total_tokens;
        private Integer prompt_audio_seconds;
        private Integer num_cached_tokens;
        private Map<String, Object> prompt_tokens_details;

        /**
         * Sets the number of tokens used in the prompt/input.
         *
         * @param prompt_tokens the number of prompt tokens
         * @return this builder instance
         */
        public Builder prompt_tokens(Integer prompt_tokens) {
            this.prompt_tokens = prompt_tokens;
            return this;
        }

        /**
         * Sets the number of tokens used in the completion/output.
         *
         * @param completion_tokens the number of completion tokens
         * @return this builder instance
         */
        public Builder completion_tokens(Integer completion_tokens) {
            this.completion_tokens = completion_tokens;
            return this;
        }

        /**
         * Sets the total number of tokens used.
         *
         * @param total_tokens the total number of tokens
         * @return this builder instance
         */
        public Builder total_tokens(Integer total_tokens) {
            this.total_tokens = total_tokens;
            return this;
        }

        /**
         * Sets the number of seconds of audio in the prompt.
         *
         * @param prompt_audio_seconds the number of prompt audio seconds
         * @return this builder instance
         */
        public Builder prompt_audio_seconds(Integer prompt_audio_seconds) {
            this.prompt_audio_seconds = prompt_audio_seconds;
            return this;
        }

        public Builder num_cached_tokens(Integer num_cached_tokens) {
            this.num_cached_tokens = num_cached_tokens;
            return this;
        }

        public Builder prompt_tokens_details(Map<String, Object> prompt_tokens_details) {
            this.prompt_tokens_details = prompt_tokens_details;
            return this;
        }

        /**
         * Builds a new Usage instance with the current builder values.
         *
         * @return a new Usage instance
         */
        public Usage build() {
            return new Usage(prompt_tokens, completion_tokens, total_tokens, prompt_audio_seconds, 
                num_cached_tokens, prompt_tokens_details);
        }
    }
}
