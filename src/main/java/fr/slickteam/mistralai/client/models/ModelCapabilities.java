package fr.slickteam.mistralai.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the capabilities of a model.
 */
public class ModelCapabilities {

    /**
     * Indicates if the model supports chat completion.
     */
    @JsonProperty("completion_chat")
    private boolean completionChat;

    /**
     * Indicates if the model supports function calling.
     */
    @JsonProperty("function_calling")
    private boolean functionCalling;

    /**
     * Indicates if the model supports FIM (Fill-in-the-Middle) completion.
     */
    @JsonProperty("completion_fim")
    private boolean completionFim;

    /**
     * Indicates if the model supports fine-tuning.
     */
    @JsonProperty("fine_tuning")
    private boolean fineTuning;

    /**
     * Indicates if the model supports vision capabilities.
     */
    @JsonProperty("vision")
    private boolean vision;

    /**
     * Indicates if the model supports classification.
     */
    @JsonProperty("classification")
    private boolean classification;

    /**
     * Default constructor for Jackson deserialization
     */
    public ModelCapabilities() {
    }

    /**
     * Constructor with all capabilities
     */
    public ModelCapabilities(boolean completionChat, boolean functionCalling, boolean completionFim, 
                          boolean fineTuning, boolean vision, boolean classification) {
        this.completionChat = completionChat;
        this.functionCalling = functionCalling;
        this.completionFim = completionFim;
        this.fineTuning = fineTuning;
        this.vision = vision;
        this.classification = classification;
    }

    // Getters and setters
    public boolean isCompletionChat() {
        return completionChat;
    }

    public void setCompletionChat(boolean completionChat) {
        this.completionChat = completionChat;
    }

    public boolean isFunctionCalling() {
        return functionCalling;
    }

    public void setFunctionCalling(boolean functionCalling) {
        this.functionCalling = functionCalling;
    }

    public boolean isCompletionFim() {
        return completionFim;
    }

    public void setCompletionFim(boolean completionFim) {
        this.completionFim = completionFim;
    }

    public boolean isFineTuning() {
        return fineTuning;
    }

    public void setFineTuning(boolean fineTuning) {
        this.fineTuning = fineTuning;
    }

    public boolean isVision() {
        return vision;
    }

    public void setVision(boolean vision) {
        this.vision = vision;
    }

    public boolean isClassification() {
        return classification;
    }

    public void setClassification(boolean classification) {
        this.classification = classification;
    }
}