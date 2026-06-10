package fr.slickteam.mistralai.client.type;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EmbeddingDtype {
    FLOAT("float"),
    INT8("int8"),
    UINT8("uint8"),
    BINARY("binary"),
    UBINARY("ubinary");

    private final String value;

    EmbeddingDtype(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
