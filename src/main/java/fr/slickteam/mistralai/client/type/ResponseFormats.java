package fr.slickteam.mistralai.client.type;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The format that the model must output.
 */
public enum ResponseFormats {
    TEXT("text"),
    JSON_OBJECT("json_object"),
    JSON_SCHEMA("json_schema");

    private final String value;

    ResponseFormats(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
