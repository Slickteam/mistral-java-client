package fr.slickteam.mistralai.client.model.ocr;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response format for OCR annotations.
 */
public class ResponseFormat {

    /**
     * The format type (e.g., "json_schema").
     */
    @JsonProperty("type")
    private String type;

    /**
     * The schema definition.
     */
    @JsonProperty("schema")
    private Object schema;

    /**
     * Default constructor for Jackson deserialization.
     */
    public ResponseFormat() {
    }

    /**
     * Constructor with type.
     */
    public ResponseFormat(String type) {
        this.type = type;
    }

    // Getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getSchema() {
        return schema;
    }

    public void setSchema(Object schema) {
        this.schema = schema;
    }
}