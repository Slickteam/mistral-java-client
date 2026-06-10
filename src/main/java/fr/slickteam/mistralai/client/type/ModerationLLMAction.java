package fr.slickteam.mistralai.client.type;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ModerationLLMAction {
    NONE("none"),
    BLOCK("block");

    private final String value;

    ModerationLLMAction(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
