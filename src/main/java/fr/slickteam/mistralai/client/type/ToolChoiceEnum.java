package fr.slickteam.mistralai.client.type;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ToolChoiceEnum {
    AUTO("auto"),
    NONE("none"),
    ANY("any"),
    REQUIRED("required");

    private final String value;

    ToolChoiceEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
