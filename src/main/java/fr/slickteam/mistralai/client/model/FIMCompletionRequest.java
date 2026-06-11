package fr.slickteam.mistralai.client.model;

/**
 * FIM completion request.
 * <p>
 * Used in Mistral AI API operations.
 */


import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

/**
 * Represents a request to the FIM completions endpoint of the Mistral AI API.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FIMCompletionRequest(
    /**
     * ID of the model with FIM to use.
     */
    String model,

    /**
     * The text/code to complete.
     */
    String prompt,

    /**
     * Optional text/code that adds more context for the model.
     */
    String suffix,

    /**
     * What sampling temperature to use.
     */
    Double temperature,

    /**
     * Nucleus sampling parameter.
     */
    Double top_p,

    /**
     * The maximum number of tokens to generate.
     */
    Integer max_tokens,

    /**
     * The minimum number of tokens to generate.
     */
    Integer min_tokens,

    /**
     * Whether to stream the response or not.
     */
    Boolean stream,

    /**
     * Stop sequence(s) to use.
     */
    Object stop,

    /**
     * A random seed for deterministic results.
     */
    Integer random_seed,

    /**
     * A cache key to enable prompt caching.
     */
    String prompt_cache_key,

    /**
     * Additional metadata for the request.
     */
    Map<String, String> metadata
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String model;
        private String prompt;
        private String suffix;
        private Double temperature;
        private Double top_p;
        private Integer max_tokens;
        private Integer min_tokens;
        private Boolean stream;
        private Object stop;
        private Integer random_seed;
        private String prompt_cache_key;
        private Map<String, String> metadata;

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder prompt(String prompt) {
            this.prompt = prompt;
            return this;
        }

        public Builder suffix(String suffix) {
            this.suffix = suffix;
            return this;
        }

        public Builder temperature(Double temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder top_p(Double top_p) {
            this.top_p = top_p;
            return this;
        }

        public Builder max_tokens(Integer max_tokens) {
            this.max_tokens = max_tokens;
            return this;
        }

        public Builder min_tokens(Integer min_tokens) {
            this.min_tokens = min_tokens;
            return this;
        }

        public Builder stream(Boolean stream) {
            this.stream = stream;
            return this;
        }

        public Builder stop(Object stop) {
            this.stop = stop;
            return this;
        }

        public Builder random_seed(Integer random_seed) {
            this.random_seed = random_seed;
            return this;
        }

        public Builder prompt_cache_key(String prompt_cache_key) {
            this.prompt_cache_key = prompt_cache_key;
            return this;
        }

        public Builder metadata(Map<String, String> metadata) {
            this.metadata = metadata;
            return this;
        }

        public FIMCompletionRequest build() {
            return new FIMCompletionRequest(model, prompt, suffix, temperature, top_p, 
                max_tokens, min_tokens, stream, stop, random_seed, prompt_cache_key, metadata);
        }
    }
}
