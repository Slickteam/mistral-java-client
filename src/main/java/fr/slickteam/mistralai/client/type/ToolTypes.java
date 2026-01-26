package fr.slickteam.mistralai.client.type;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ToolTypes {
    FUNCTION("function");

    private final String value;

    ToolTypes(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
