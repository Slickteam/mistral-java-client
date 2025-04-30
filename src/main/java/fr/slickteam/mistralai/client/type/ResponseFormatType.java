package fr.slickteam.mistralai.client.type;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ResponseFormatType {
    TEXT("text"),
    JSON_OBJECT("json_object"),
    JSON_SCHEMA("json_schema");

    @JsonValue
    private final String value;

    ResponseFormatType(String value) {
        this.value = value;
    }
}
