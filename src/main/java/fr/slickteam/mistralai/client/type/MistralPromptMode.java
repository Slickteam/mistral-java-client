package fr.slickteam.mistralai.client.type;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The prompt mode to use for the request.
 */
public enum MistralPromptMode {
    INSTRUCT("instruct"),
    CHAT("chat"),
    REASONING("reasoning");

    private final String value;

    MistralPromptMode(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
