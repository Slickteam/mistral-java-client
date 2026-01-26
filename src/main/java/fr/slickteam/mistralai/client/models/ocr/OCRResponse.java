package fr.slickteam.mistralai.client.models.ocr;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * OCR response model based on the updated OpenAPI specification.
 */
public class OCRResponse {

    /**
     * List of OCR info for pages.
     */
    @JsonProperty("pages")
    private List<OCRPageObject> pages;

    /**
     * The model used to generate the OCR.
     */
    @JsonProperty("model")
    private String model;

    /**
     * Formatted response in the request_format if provided in json str.
     */
    @JsonProperty("document_annotation")
    private String documentAnnotation;

    /**
     * Usage info for the OCR request.
     */
    @JsonProperty("usage_info")
    private OCRUsageInfo usageInfo;

    /**
     * Default constructor for Jackson deserialization.
     */
    public OCRResponse() {
    }

    // Getters and setters
    public List<OCRPageObject> getPages() {
        return pages;
    }

    public void setPages(List<OCRPageObject> pages) {
        this.pages = pages;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDocumentAnnotation() {
        return documentAnnotation;
    }

    public void setDocumentAnnotation(String documentAnnotation) {
        this.documentAnnotation = documentAnnotation;
    }

    public OCRUsageInfo getUsageInfo() {
        return usageInfo;
    }

    public void setUsageInfo(OCRUsageInfo usageInfo) {
        this.usageInfo = usageInfo;
    }
}