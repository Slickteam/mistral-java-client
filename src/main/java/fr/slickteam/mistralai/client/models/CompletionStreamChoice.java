package fr.slickteam.mistralai.client.models;

/**
 * Represents a single choice within a completion stream.
 * Each choice provides information about the generated text, the index of the choice,
 * and the reason for finishing or stopping the generation process.
 */
public class CompletionStreamChoice {

    /**
     * Represents the index or position of the current choice in the completion process.
     * This value is used to uniquely identify and distinguish between different choices
     * generated within a single completion stream.
     */
    public int index;

    /**
     * Represents the textual content of a completion choice within a stream.
     * This field typically contains the generated or processed text output
     * resulting from a specific choice during a task or model operation.
     */
    public String text;

    /**
     * Describes the reason for the completion process to stop or finish.
     * This field indicates the specific condition that caused the model
     * to terminate text generation. Common reasons can include reaching
     * the maximum token limit, encountering a stop sequence, or any other
     * predefined condition for halting the generation.
     */
    public String finishReason;

}
