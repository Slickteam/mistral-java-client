package fr.slickteam.mistralai.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents token usage in an operation, including prompt tokens, completion tokens,
 * and the total number of tokens used.
 */
public class Usage {

    /**
     * Represents the number of tokens used in the input prompt of a specific operation.
     * This field indicates the token count consumed by the initial user input, excluding
     * any tokens generated during the completion or response phase.
     */
    @JsonProperty("prompt_tokens")
    public int promptTokens;

    /**
     * Represents the number of completion tokens used during an operation.
     * Completion tokens typically refer to the tokens generated as a response
     * in a request or process. This value is utilized to measure or track
     * the resource usage or output size in tokenized systems.
     */
    @JsonProperty("completion_tokens")
    public int completionTokens;

    /**
     * Represents the total number of tokens used in a specific operation.
     * This value is the sum of prompt tokens and completion tokens, providing
     * a comprehensive measure of the token consumption for a given process.
     */
    @JsonProperty("total_tokens")
    public int totalTokens;

    @JsonProperty("prompt_audio_seconds")
    private Integer promptAudioSeconds;

    public Usage() {
    }

    public Usage(int promptTokens, int completionTokens, int totalTokens) {
        this.promptTokens = promptTokens;
        this.completionTokens = completionTokens;
        this.totalTokens = totalTokens;
    }

    public Usage(int promptTokens, int completionTokens, int totalTokens, Integer promptAudioSeconds) {
        this.promptTokens = promptTokens;
        this.completionTokens = completionTokens;
        this.totalTokens = totalTokens;
        this.promptAudioSeconds = promptAudioSeconds;
    }

    public int getPromptTokens() {
        return promptTokens;
    }

    public void setPromptTokens(int promptTokens) {
        this.promptTokens = promptTokens;
    }

    public int getCompletionTokens() {
        return completionTokens;
    }

    public void setCompletionTokens(int completionTokens) {
        this.completionTokens = completionTokens;
    }

    public int getTotalTokens() {
        return totalTokens;
    }

    public void setTotalTokens(int totalTokens) {
        this.totalTokens = totalTokens;
    }

    public Integer getPromptAudioSeconds() {
        return promptAudioSeconds;
    }

    public void setPromptAudioSeconds(Integer promptAudioSeconds) {
        this.promptAudioSeconds = promptAudioSeconds;
    }

    @Override
    public String toString() {
        return "Usage{" +
                "promptTokens=" + promptTokens +
                ", completionTokens=" + completionTokens +
                ", totalTokens=" + totalTokens +
                ", promptAudioSeconds=" + promptAudioSeconds +
                '}';
    }
}
