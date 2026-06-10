package fr.slickteam.mistralai.client.type;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Control which (if any) tool is called by the model.
 */
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
