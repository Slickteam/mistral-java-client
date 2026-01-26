package fr.slickteam.mistralai.client.models.ocr;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * OCR table object containing information about an extracted table.
 */
public class OCRTableObject {

    /**
     * Table ID for extracted table in a page.
     */
    @JsonProperty("id")
    private String id;

    /**
     * Content of the table in the given format.
     */
    @JsonProperty("content")
    private String content;

    /**
     * Format of the table (markdown or html).
     */
    @JsonProperty("format")
    private String format;

    /**
     * Default constructor for Jackson deserialization.
     */
    public OCRTableObject() {
    }

    /**
     * Constructor with required fields.
     */
    public OCRTableObject(String id, String content, String format) {
        this.id = id;
        this.content = content;
        this.format = format;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}