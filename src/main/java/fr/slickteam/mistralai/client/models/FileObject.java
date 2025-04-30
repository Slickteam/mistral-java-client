package fr.slickteam.mistralai.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a file object in the Mistral API.
 */
public class FileObject {
    /**
     * The unique identifier for the file.
     */
    @JsonProperty("id")
    private String id;

    /**
     * The object type, which is 'file'.
     */
    @JsonProperty("object")
    private String object;

    /**
     * The size of the file in bytes.
     */
    @JsonProperty("bytes")
    private int bytes;

    /**
     * The Unix timestamp (in seconds) for when the file was created.
     */
    @JsonProperty("created_at")
    private long createdAt;

    /**
     * The name of the file.
     */
    @JsonProperty("filename")
    private String filename;

    /**
     * The purpose of the file, e.g., 'fine-tune'.
     */
    @JsonProperty("purpose")
    private String purpose;

    /**
     * The sample type of the file, e.g., 'pretrain', 'instruct', 'batch_request', 'batch_result', 'batch_error'.
     */
    @JsonProperty("sample_type")
    private String sampleType;

    /**
     * The number of lines in the file.
     */
    @JsonProperty("num_lines")
    private Integer numLines;

    /**
     * The source of the file, e.g., 'upload', 'repository', 'mistral'.
     */
    @JsonProperty("source")
    private String source;

    public FileObject() {
    }

    public FileObject(String id, String object, int bytes, long createdAt, String filename, String purpose) {
        this.id = id;
        this.object = object;
        this.bytes = bytes;
        this.createdAt = createdAt;
        this.filename = filename;
        this.purpose = purpose;
    }

    public FileObject(String id, String object, int bytes, long createdAt, String filename, 
                      String purpose, String sampleType, Integer numLines, String source) {
        this.id = id;
        this.object = object;
        this.bytes = bytes;
        this.createdAt = createdAt;
        this.filename = filename;
        this.purpose = purpose;
        this.sampleType = sampleType;
        this.numLines = numLines;
        this.source = source;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public int getBytes() {
        return bytes;
    }

    public void setBytes(int bytes) {
        this.bytes = bytes;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getSampleType() {
        return sampleType;
    }

    public void setSampleType(String sampleType) {
        this.sampleType = sampleType;
    }

    public Integer getNumLines() {
        return numLines;
    }

    public void setNumLines(Integer numLines) {
        this.numLines = numLines;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "FileObject{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", bytes=" + bytes +
                ", createdAt=" + createdAt +
                ", filename='" + filename + '\'' +
                ", purpose='" + purpose + '\'' +
                ", sampleType='" + sampleType + '\'' +
                ", numLines=" + numLines +
                ", source='" + source + '\'' +
                '}';
    }
}
