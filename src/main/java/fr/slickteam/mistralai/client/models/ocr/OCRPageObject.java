package fr.slickteam.mistralai.client.models.ocr;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * OCR page object containing information about a single page.
 */
public class OCRPageObject {

    /**
     * The page index in a pdf document starting from 0.
     */
    @JsonProperty("index")
    private int index;

    /**
     * The markdown string response of the page.
     */
    @JsonProperty("markdown")
    private String markdown;

    /**
     * List of all extracted images in the page.
     */
    @JsonProperty("images")
    private List<OCRImageObject> images;

    /**
     * List of all extracted tables in the page.
     */
    @JsonProperty("tables")
    private List<OCRTableObject> tables;

    /**
     * List of all hyperlinks in the page.
     */
    @JsonProperty("hyperlinks")
    private List<String> hyperlinks;

    /**
     * Header of the page.
     */
    @JsonProperty("header")
    private String header;

    /**
     * Footer of the page.
     */
    @JsonProperty("footer")
    private String footer;

    /**
     * The dimensions of the PDF Page's screenshot image.
     */
    @JsonProperty("dimensions")
    private OCRPageDimensions dimensions;

    /**
     * Default constructor for Jackson deserialization.
     */
    public OCRPageObject() {
    }

    /**
     * Constructor with required fields.
     */
    public OCRPageObject(int index, String markdown) {
        this.index = index;
        this.markdown = markdown;
    }

    // Getters and setters
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getMarkdown() {
        return markdown;
    }

    public void setMarkdown(String markdown) {
        this.markdown = markdown;
    }

    public List<OCRImageObject> getImages() {
        return images;
    }

    public void setImages(List<OCRImageObject> images) {
        this.images = images;
    }

    public List<OCRTableObject> getTables() {
        return tables;
    }

    public void setTables(List<OCRTableObject> tables) {
        this.tables = tables;
    }

    public List<String> getHyperlinks() {
        return hyperlinks;
    }

    public void setHyperlinks(List<String> hyperlinks) {
        this.hyperlinks = hyperlinks;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public OCRPageDimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(OCRPageDimensions dimensions) {
        this.dimensions = dimensions;
    }
}