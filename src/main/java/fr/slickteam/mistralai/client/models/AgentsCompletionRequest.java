package fr.slickteam.mistralai.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Represents a request for generating completions with agents.
 * This class contains various parameters used to configure the behavior
 * of the completion request.
 */
public class AgentsCompletionRequest {

    /**
     * The identifier of the model used for generating completions or performing tasks.
     * It specifies which pre-trained or fine-tuned model will be utilized for processing
     * the request. The value should match the ID of an available model.
     */
    private String model;

    /**
     * Specifies the agent responsible for processing the completion request.
     * This can be used to define or select a particular agent configuration
     * or behavior during the generation process.
     */
    private String agent;

    /**
     * A list of chat messages representing the conversation between users and agents.
     * Each message includes details such as the sender's role, the content of the message,
     * and an optional name for additional context.
     */
    private List<ChatMessage> messages;

    /**
     * Represents the sampling temperature used to control the randomness of the output.
     * Higher values increase randomness, making the model's output more diverse.
     * Lower values make the output more focused and deterministic.
     */
    private Double temperature;

    /**
     * Specifies the maximum number of tokens to generate in the completion output.
     *
     * This parameter controls the length of the generated text. Increasing the value allows
     * for longer outputs, while lower values constrain the response length.
     *
     * If not set, the default behavior or value defined by the associated model may be used.
     */
    @JsonProperty("max_tokens")
    private Integer maxTokens;

    /**
     * Represents the nucleus sampling parameter, also known as top-p sampling.
     * This parameter determines the cumulative probability threshold for token selection.
     * During text generation, the model considers tokens with the highest probabilities
     * that sum up to the value of `topP`. Lower values result in more focused and deterministic
     * outputs, while higher values include more diverse tokens.
     *
     * For example:
     * - A value of 1.0 includes all possible tokens (no filtering).
     * - A value of 0.9 includes only the most probable tokens whose cumulative probability is 90%.
     *
     * Typical values range between 0.1 and 1.0.
     */
    @JsonProperty("top_p")
    private Double topP;

    /**
     * Determines the random seed value used for generating deterministic behaviors in algorithms
     * or models. This ensures reproducibility by consistently producing the same output for
     * identical inputs when set to the same seed value.
     */
    @JsonProperty("random_seed")
    private Integer randomSeed;

    /**
     * Indicates whether the response from the agent should be streamed.
     * If true, the response is delivered in a streaming manner as it's generated.
     * If false, the response is delivered as a complete result after it has been fully generated.
     */
    private Boolean stream;

    /**
     * List of tools available for the completion request.
     * Each tool provides a specific functionality that can be utilized
     * during the completion generation process.
     */
    private List<Tool> tools;

    /**
     * Specifies the name of the tool to be used for the completion request.
     *
     * This variable allows the user to select a specific tool from the list
     * of available tools defined in the {@code tools} field of the
     * {@code AgentsCompletionRequest} class. The chosen tool may affect the
     * behavior or capabilities of the completion results.
     *
     * For example, this might correspond to a tool meant for specific tasks
     * such as language translation, mathematical computations, or data summarization.
     */
    @JsonProperty("tool_choice")
    private String toolChoice;

    public AgentsCompletionRequest() {
    }

    public AgentsCompletionRequest(String model, String agent, List<ChatMessage> messages, Double temperature,
                                   Integer maxTokens, Double topP, Integer randomSeed, Boolean stream,
                                   List<Tool> tools, String toolChoice) {
        this.model = model;
        this.agent = agent;
        this.messages = messages;
        this.temperature = temperature;
        this.maxTokens = maxTokens;
        this.topP = topP;
        this.randomSeed = randomSeed;
        this.stream = stream;
        this.tools = tools;
        this.toolChoice = toolChoice;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatMessage> messages) {
        this.messages = messages;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(Integer maxTokens) {
        this.maxTokens = maxTokens;
    }

    public Double getTopP() {
        return topP;
    }

    public void setTopP(Double topP) {
        this.topP = topP;
    }

    public Integer getRandomSeed() {
        return randomSeed;
    }

    public void setRandomSeed(Integer randomSeed) {
        this.randomSeed = randomSeed;
    }

    public Boolean getStream() {
        return stream;
    }

    public void setStream(Boolean stream) {
        this.stream = stream;
    }

    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }

    public String getToolChoice() {
        return toolChoice;
    }

    public void setToolChoice(String toolChoice) {
        this.toolChoice = toolChoice;
    }

    @Override
    public String toString() {
        return "AgentsCompletionRequest{" +
                "model='" + model + '\'' +
                ", agent='" + agent + '\'' +
                ", messages=" + messages +
                ", temperature=" + temperature +
                ", maxTokens=" + maxTokens +
                ", topP=" + topP +
                ", randomSeed=" + randomSeed +
                ", stream=" + stream +
                ", tools=" + tools +
                ", toolChoice='" + toolChoice + '\'' +
                '}';
    }

}
