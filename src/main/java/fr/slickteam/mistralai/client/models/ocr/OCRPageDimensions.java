package fr.slickteam.mistralai.client.models.ocr;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * OCR page dimensions.
 */
public class OCRPageDimensions {

    /**
     * Dots per inch of the page-image.
     */
    @JsonProperty("dpi")
    private int dpi;

    /**
     * Height of the image in pixels.
     */
    @JsonProperty("height")
    private Integer height;

    /**
     * Width of the image in pixels.
     */
    @JsonProperty("width")
    private Integer width;

    /**
     * Default constructor for Jackson deserialization.
     */
    public OCRPageDimensions() {
    }

    /**
     * Constructor with required fields.
     */
    public OCRPageDimensions(int dpi) {
        this.dpi = dpi;
    }

    // Getters and setters
    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
}