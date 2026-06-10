package fr.slickteam.mistralai.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.slickteam.mistralai.client.model.Tool;

import java.util.List;

/**
 * Represents a request for generating completion streams using an agent.
 * This class contains configuration parameters needed for processing the request,
 * including the model, agent, input messages, and various hyperparameters for fine-tuning the generation behavior.
 */
public class AgentsCompletionStreamRequest {

    /**
     * Specifies the name or identifier of the machine learning model used for processing the request.
     * This value determines which model will be employed for task execution, such as generating text
     * or processing inputs according to the specified parameters.
     */
    private String model;

    /**
     * Specifies the agent to be used for generating completion streams.
     * The agent determines the contextual behavior and actions of the system during the process.
     */
    private String agent;

    /**
     * A list of chat messages exchanged in the context of the request.
     * Each message is represented by an instance of the ChatMessage class, which encapsulates
     * attributes such as the role of the sender, the content of the message, and optionally the name of the sender.
     */
    private List<ChatMessage> messages;

    /**
     * The temperature parameter used to control the randomness or diversity of the generated output.
     * A higher value (e.g., 1.0) produces more random results, while a lower value (e.g., 0.2) steers the model towards more predictable and deterministic results.
     * Value is typically between 0.0 and 1.0.
     */
    private Double temperature;

    /**
     * Specifies the maximum number of tokens to generate in the completion.
     * This parameter sets an upper limit for the length of the generated text.
     * It helps control the computational cost and output size of the completion operation.
     */
    @JsonProperty("max_tokens")
    private Integer maxTokens;

    /**
     * A parameter that specifies the nucleus sampling probability (top-p) during the AI-generated text completion process.
     * It determines the cumulative probability for including tokens in the sampling pool.
     * Adjusting this value allows control over the diversity of generated text, ranging from deterministic output (lower values)
     * to more creative and diverse responses (higher values).
     */
    @JsonProperty("top_p")
    private Double topP;

    /**
     * Specifies a random seed for stochastic processes during generation.
     * This value can be used to ensure deterministic outputs for the same input
     * by seeding the underlying random number generator. If not specified,
     * the behavior will be non-deterministic.
     */
    @JsonProperty("random_seed")
    private Integer randomSeed;

    /**
     * Indicates whether the completion response should be streamed in real-time.
     * When set to true, the response is provided incrementally as it is generated.
     */
    private Boolean stream;

    /**
     * A list of tools that can be utilized by the agent in various operations.
     * Each tool in the list specifies a type and an associated function that defines its behavior.
     */
    private List<Tool> tools;

    /**
     * Represents the identifier or name of the tool chosen by the agent for handling the request.
     * This value is used to specify which tool, from the list of available tools, will be utilized
     * during the agent's execution or task processing.
     */
    private String toolChoice;

    public AgentsCompletionStreamRequest() {
    }

    public AgentsCompletionStreamRequest(String model, String agent, List<ChatMessage> messages, Double temperature,
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
        return "AgentsCompletionStreamRequest{" +
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
