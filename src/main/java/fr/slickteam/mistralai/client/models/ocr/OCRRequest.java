package fr.slickteam.mistralai.client.models.ocr;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * OCR request model based on the updated OpenAPI specification.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OCRRequest {

    /**
     * The model to use for OCR processing.
     */
    @JsonProperty("model")
    private String model;

    /**
     * The document ID.
     */
    @JsonProperty("id")
    private String id;

    /**
     * The document to run OCR on.
     */
    @JsonProperty("document")
    private Object document; // Can be FileChunk, DocumentURLChunk, or ImageURLChunk

    /**
     * Specific pages to process.
     */
    @JsonProperty("pages")
    private List<Integer> pages;

    /**
     * Include image URLs in response.
     */
    @JsonProperty("include_image_base64")
    private Boolean includeImageBase64;

    /**
     * Max images to extract.
     */
    @JsonProperty("image_limit")
    private Integer imageLimit;

    /**
     * Minimum height and width of image to extract.
     */
    @JsonProperty("image_min_size")
    private Integer imageMinSize;

    /**
     * Structured output class for extracting useful information from each extracted bounding box.
     */
    @JsonProperty("bbox_annotation_format")
    private ResponseFormat bboxAnnotationFormat;

    /**
     * Document annotation format.
     */
    @JsonProperty("document_annotation_format")
    private ResponseFormat documentAnnotationFormat;

    /**
     * Default constructor for Jackson deserialization.
     */
    public OCRRequest() {
    }

    /**
     * Constructor with required fields.
     */
    public OCRRequest(String id, Object document) {
        this.id = id;
        this.document = document;
    }

    // Getters and setters
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getDocument() {
        return document;
    }

    public void setDocument(Object document) {
        this.document = document;
    }

    public List<Integer> getPages() {
        return pages;
    }

    public void setPages(List<Integer> pages) {
        this.pages = pages;
    }

    public Boolean getIncludeImageBase64() {
        return includeImageBase64;
    }

    public void setIncludeImageBase64(Boolean includeImageBase64) {
        this.includeImageBase64 = includeImageBase64;
    }

    public Integer getImageLimit() {
        return imageLimit;
    }

    public void setImageLimit(Integer imageLimit) {
        this.imageLimit = imageLimit;
    }

    public Integer getImageMinSize() {
        return imageMinSize;
    }

    public void setImageMinSize(Integer imageMinSize) {
        this.imageMinSize = imageMinSize;
    }

    public ResponseFormat getBboxAnnotationFormat() {
        return bboxAnnotationFormat;
    }

    public void setBboxAnnotationFormat(ResponseFormat bboxAnnotationFormat) {
        this.bboxAnnotationFormat = bboxAnnotationFormat;
    }

    public ResponseFormat getDocumentAnnotationFormat() {
        return documentAnnotationFormat;
    }

    public void setDocumentAnnotationFormat(ResponseFormat documentAnnotationFormat) {
        this.documentAnnotationFormat = documentAnnotationFormat;
    }
}