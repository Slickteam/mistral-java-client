package fr.slickteam.mistralai.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response object for file deletion operations.
 */
public class DeleteFileResponse {
    /**
     * The ID of the deleted file.
     */
    @JsonProperty("id")
    private String id;

    /**
     * The object type, which is 'file'.
     */
    @JsonProperty("object")
    private String object;

    /**
     * Whether the file was successfully deleted.
     */
    @JsonProperty("deleted")
    private boolean deleted;

    public DeleteFileResponse() {
    }

    public DeleteFileResponse(String id, String object, boolean deleted) {
        this.id = id;
        this.object = object;
        this.deleted = deleted;
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "DeleteFileResponse{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
