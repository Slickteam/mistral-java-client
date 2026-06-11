package fr.slickteam.mistralai.client.model;

/**
 * Agents completion request.
 * <p>
 * Used in Mistral AI API operations.
 */


import com.fasterxml.jackson.annotation.JsonInclude;
import fr.slickteam.mistralai.client.type.MistralPromptMode;
import java.util.List;
import java.util.Map;

/**
 * Represents a request to the agents completions endpoint of the Mistral AI API.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AgentsCompletionRequest(
    /**
     * The ID of the agent to use for this completion.
     */
    String agent_id,

    /**
     * The list of messages in the conversation.
     */
    List<ChatMessage> messages,

    /**
     * The sampling temperature to use.
     */
    Double temperature,

    /**
     * The nucleus sampling parameter.
     */
    Double top_p,

    /**
     * The maximum number of tokens to generate.
     */
    Integer max_tokens,

    /**
     * Whether to stream the response or not.
     */
    Boolean stream,

    /**
     * The stop sequence(s) to use.
     */
    Object stop,

    /**
     * A random seed for deterministic results.
     */
    Integer random_seed,

    /**
     * The format of the response.
     */
    ResponseFormat response_format,

    /**
     * A list of tools the model may call.
     */
    List<Tool> tools,

    /**
     * Control which (if any) tool is called by the model.
     */
    Object tool_choice,

    /**
     * Presence penalty parameter.
     */
    Double presence_penalty,

    /**
     * Frequency penalty parameter.
     */
    Double frequency_penalty,

    /**
     * Number of completions to generate.
     */
    Integer n,

    /**
     * Prediction configuration.
     */
    Prediction prediction,

    /**
     * Whether to allow parallel tool calls.
     */
    Boolean parallel_tool_calls,

    /**
     * The reasoning effort level for reasoning models.
     */
    String reasoning_effort,

    /**
     * A cache key to enable prompt caching.
     */
    String prompt_cache_key,

    /**
     * The prompt mode to use.
     */
    MistralPromptMode prompt_mode,

    /**
     * Additional metadata for the request.
     */
    Map<String, String> metadata
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String agent_id;
        private List<ChatMessage> messages;
        private Double temperature;
        private Double top_p;
        private Integer max_tokens;
        private Boolean stream;
        private Object stop;
        private Integer random_seed;
        private ResponseFormat response_format;
        private List<Tool> tools;
        private Object tool_choice;
        private Double presence_penalty;
        private Double frequency_penalty;
        private Integer n;
        private Prediction prediction;
        private Boolean parallel_tool_calls;
        private String reasoning_effort;
        private String prompt_cache_key;
        private MistralPromptMode prompt_mode;
        private Map<String, String> metadata;

        public Builder agent_id(String agent_id) {
            this.agent_id = agent_id;
            return this;
        }

        public Builder messages(List<ChatMessage> messages) {
            this.messages = messages;
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

        public Builder response_format(ResponseFormat response_format) {
            this.response_format = response_format;
            return this;
        }

        public Builder tools(List<Tool> tools) {
            this.tools = tools;
            return this;
        }

        public Builder tool_choice(Object tool_choice) {
            this.tool_choice = tool_choice;
            return this;
        }

        public Builder presence_penalty(Double presence_penalty) {
            this.presence_penalty = presence_penalty;
            return this;
        }

        public Builder frequency_penalty(Double frequency_penalty) {
            this.frequency_penalty = frequency_penalty;
            return this;
        }

        public Builder n(Integer n) {
            this.n = n;
            return this;
        }

        public Builder prediction(Prediction prediction) {
            this.prediction = prediction;
            return this;
        }

        public Builder parallel_tool_calls(Boolean parallel_tool_calls) {
            this.parallel_tool_calls = parallel_tool_calls;
            return this;
        }

        public Builder reasoning_effort(String reasoning_effort) {
            this.reasoning_effort = reasoning_effort;
            return this;
        }

        public Builder prompt_cache_key(String prompt_cache_key) {
            this.prompt_cache_key = prompt_cache_key;
            return this;
        }

        public Builder prompt_mode(MistralPromptMode prompt_mode) {
            this.prompt_mode = prompt_mode;
            return this;
        }

        public Builder metadata(Map<String, String> metadata) {
            this.metadata = metadata;
            return this;
        }

        public AgentsCompletionRequest build() {
            return new AgentsCompletionRequest(agent_id, messages, temperature, top_p, 
                max_tokens, stream, stop, random_seed, response_format, tools, 
                tool_choice, presence_penalty, frequency_penalty, n, prediction, 
                parallel_tool_calls, reasoning_effort, prompt_cache_key, 
                prompt_mode, metadata);
        }
    }
}
