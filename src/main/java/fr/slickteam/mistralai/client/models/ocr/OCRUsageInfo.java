package fr.slickteam.mistralai.client.models.ocr;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * OCR usage information.
 */
public class OCRUsageInfo {

    /**
     * Number of pages processed.
     */
    @JsonProperty("pages_processed")
    private int pagesProcessed;

    /**
     * Document size in bytes.
     */
    @JsonProperty("doc_size_bytes")
    private Integer docSizeBytes;

    /**
     * Default constructor for Jackson deserialization.
     */
    public OCRUsageInfo() {
    }

    /**
     * Constructor with required fields.
     */
    public OCRUsageInfo(int pagesProcessed) {
        this.pagesProcessed = pagesProcessed;
    }

    // Getters and setters
    public int getPagesProcessed() {
        return pagesProcessed;
    }

    public void setPagesProcessed(int pagesProcessed) {
        this.pagesProcessed = pagesProcessed;
    }

    public Integer getDocSizeBytes() {
        return docSizeBytes;
    }

    public void setDocSizeBytes(Integer docSizeBytes) {
        this.docSizeBytes = docSizeBytes;
    }
}