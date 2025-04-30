package fr.slickteam.mistralai.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classification request model used to classify input data using a specified model.
 *
 * This class encapsulates the input text to be classified and the identifier of the
 * model to be used for the classification task. The model ID serves as a reference
 * to the underlying model configuration and defines the behavior of the classification.
 *
 * Fields:
 * - input: The text or data that needs to be classified.
 * - model: The unique identifier of the model to be used for classification.
 */
public class ClassificationRequest {

    /**
     * Represents the input text or data that needs to be classified by the model.
     *
     * This field captures the content to be analyzed or processed during the classification
     * task. The input can consist of text or other data formats supported by the model.
     */
    @JsonProperty("input")
    private String input;

    /**
     * Represents the unique identifier of the classification model to be used.
     *
     * This field specifies the model configuration and determines the behavior
     * of the classification task. The value should correspond to a valid
     * model identifier known to the system.
     */
    @JsonProperty("model")
    private String model;

    /**
     * Default constructor for Jackson deserialization
     */
    public ClassificationRequest() {
    }

    /**
     * Constructs a new ClassificationRequest with the given input and model.
     *
     * @param input The text or data to be classified
     * @param model The identifier of the model to use for classification
     */
    public ClassificationRequest(String input, String model) {
        this.input = input;
        this.model = model;
    }

    /**
     * Gets the input text or data to be classified.
     *
     * @return The input text or data
     */
    public String getInput() {
        return input;
    }

    /**
     * Sets the input text or data to be classified.
     *
     * @param input The input text or data
     */
    public void setInput(String input) {
        this.input = input;
    }

    /**
     * Gets the model identifier for classification.
     *
     * @return The model identifier
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model identifier for classification.
     *
     * @param model The model identifier
     */
    public void setModel(String model) {
        this.model = model;
    }
}
