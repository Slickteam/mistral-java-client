package fr.slickteam.mistralai.client.model;

/**
 * FIM completion choice.
 * <p>
 * Used in Mistral AI API operations.
 */


import com.fasterxml.jackson.annotation.JsonProperty;

public class FIMCompletionChoice {
    @JsonProperty("index")
    private int index;

    @JsonProperty("text")
    private String text;

    @JsonProperty("finish_reason")
    private String finishReason;

    /**
     * Default constructor for Jackson deserialization
     */
    public FIMCompletionChoice() {
    }

    /**
     * Constructs a new FIMCompletionChoice with the given parameters.
     *
     * @param index The index of the choice
     * @param text The generated text
     * @param finishReason The reason for finishing the generation
     */
    public FIMCompletionChoice(int index, String text, String finishReason) {
        this.index = index;
        this.text = text;
        this.finishReason = finishReason;
    }

    // Getters and Setters

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFinishReason() {
        return finishReason;
    }

    public void setFinishReason(String finishReason) {
        this.finishReason = finishReason;
    }
}
