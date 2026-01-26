package fr.slickteam.mistralai.client.type;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MistralPromptMode {
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
