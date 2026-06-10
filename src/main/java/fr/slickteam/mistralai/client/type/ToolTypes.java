package fr.slickteam.mistralai.client.type;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The types of tools available.
 */
public enum ToolTypes {
    FUNCTION("function"),
    CODE_INTERPRETER("code_interpreter"),
    WEB_SEARCH("web_search"),
    WEB_SEARCH_PREMIUM("web_search_premium"),
    DOCUMENT_LIBRARY("document_library"),
    CONNECTOR("connector"),
    IMAGE_GENERATION("image_generation");

    private final String value;

    ToolTypes(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
