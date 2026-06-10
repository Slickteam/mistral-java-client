package fr.slickteam.mistralai.client.model.ocr;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * OCR image object containing information about an extracted image.
 */
public class OCRImageObject {

    /**
     * Image ID for extracted image in a page.
     */
    @JsonProperty("id")
    private String id;

    /**
     * X coordinate of top-left corner of the extracted image.
     */
    @JsonProperty("top_left_x")
    private Integer topLeftX;

    /**
     * Y coordinate of top-left corner of the extracted image.
     */
    @JsonProperty("top_left_y")
    private Integer topLeftY;

    /**
     * X coordinate of bottom-right corner of the extracted image.
     */
    @JsonProperty("bottom_right_x")
    private Integer bottomRightX;

    /**
     * Y coordinate of bottom-right corner of the extracted image.
     */
    @JsonProperty("bottom_right_y")
    private Integer bottomRightY;

    /**
     * Base64 string of the extracted image.
     */
    @JsonProperty("image_base64")
    private String imageBase64;

    /**
     * Annotation of the extracted image in json str.
     */
    @JsonProperty("image_annotation")
    private String imageAnnotation;

    /**
     * Default constructor for Jackson deserialization.
     */
    public OCRImageObject() {
    }

    /**
     * Constructor with required fields.
     */
    public OCRImageObject(String id, Integer topLeftX) {
        this.id = id;
        this.topLeftX = topLeftX;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTopLeftX() {
        return topLeftX;
    }

    public void setTopLeftX(Integer topLeftX) {
        this.topLeftX = topLeftX;
    }

    public Integer getTopLeftY() {
        return topLeftY;
    }

    public void setTopLeftY(Integer topLeftY) {
        this.topLeftY = topLeftY;
    }

    public Integer getBottomRightX() {
        return bottomRightX;
    }

    public void setBottomRightX(Integer bottomRightX) {
        this.bottomRightX = bottomRightX;
    }

    public Integer getBottomRightY() {
        return bottomRightY;
    }

    public void setBottomRightY(Integer bottomRightY) {
        this.bottomRightY = bottomRightY;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public String getImageAnnotation() {
        return imageAnnotation;
    }

    public void setImageAnnotation(String imageAnnotation) {
        this.imageAnnotation = imageAnnotation;
    }
}