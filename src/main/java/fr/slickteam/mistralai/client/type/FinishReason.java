package fr.slickteam.mistralai.client.type;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The reason why the model stopped generating text.
 */
public enum FinishReason {
    STOP("stop"),
    LENGTH("length"),
    MODEL_LENGTH("model_length"),
    ERROR("error"),
    TOOL_CALLS("tool_calls");

    private final String value;

    FinishReason(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
