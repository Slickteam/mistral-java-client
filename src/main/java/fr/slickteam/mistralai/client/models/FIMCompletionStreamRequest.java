package fr.slickteam.mistralai.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import static fr.slickteam.mistralai.client.utils.JSONUtils.escapeJsonString;

public class FIMCompletionStreamRequest {
    @JsonProperty("model")
    private String model;

    @JsonProperty("suffix")
    private String suffix;

    @JsonProperty("temperature")
    private Double temperature;

    @JsonProperty("max_tokens")
    private Integer maxTokens;

    @JsonProperty("top_p")
    private Double topP;

    @JsonProperty("random_seed")
    private Integer randomSeed;

    @JsonProperty("stream")
    private Boolean stream;

    @JsonProperty("stop")
    private Object stop;

    @JsonProperty("prompt")
    private String prompt;

    @JsonProperty("min_tokens")
    private Integer minTokens;

    /**
     * Default constructor for Jackson deserialization
     */
    public FIMCompletionStreamRequest() {
    }

    /**
     * Constructs a new FIMCompletionStreamRequest with the given parameters, including the new properties.
     *
     * @param model       The model to use
     * @param suffix      Optional text/code that adds more context for the model. When given a prompt and a suffix the model will fill what is between them. When suffix is not provided, the model will simply execute completion starting with prompt.
     * @param temperature The sampling temperature
     * @param maxTokens   The maximum number of tokens to generate
     * @param topP        The cumulative probability threshold
     * @param randomSeed  The random seed for reproducibility
     * @param stream      Whether to stream the response
     * @param stop        Stop generation if this token is detected
     * @param prompt      The text/code to complete
     * @param minTokens   The minimum number of tokens to generate
     */
    public FIMCompletionStreamRequest(String model, String prefix, String suffix, String middle,
                                      Double temperature, Integer maxTokens, Double topP,
                                      Integer randomSeed, Boolean stream, Object stop,
                                      String prompt, Integer minTokens) {
        this.model = model;
        this.suffix = escapeJsonString(suffix);
        this.temperature = temperature;
        this.maxTokens = maxTokens;
        this.topP = topP;
        this.randomSeed = randomSeed;
        this.stream = stream;
        this.stop = stop;
        this.prompt = escapeJsonString(prompt);
        this.minTokens = minTokens;
    }

    // Getters and Setters

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = escapeJsonString(suffix);
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

    public Object getStop() {
        return stop;
    }

    public void setStop(Object stop) {
        this.stop = stop;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = escapeJsonString(prompt);
    }

    public Integer getMinTokens() {
        return minTokens;
    }

    public void setMinTokens(Integer minTokens) {
        this.minTokens = minTokens;
    }

    @Override
    public String toString() {
        return "FIMCompletionStreamRequest{" +
                "model='" + model + '\'' +
                ", suffix='" + suffix + '\'' +
                ", temperature=" + temperature +
                ", maxTokens=" + maxTokens +
                ", topP=" + topP +
                ", randomSeed=" + randomSeed +
                ", stream=" + stream +
                ", stop=" + stop +
                ", prompt='" + prompt + '\'' +
                ", minTokens=" + minTokens +
                '}';
    }
}
