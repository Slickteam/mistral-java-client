package fr.slickteam.mistralai.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response model for archive model operation.
 */
public class ArchiveModelResponse {

    /**
     * Unique identifier for the archived model.
     * Typically used to reference or track a specific model instance
     * within the context of archival operations.
     */
    @JsonProperty("id")
    private String id;

    /**
     * Specifies the object type related to the archive model operation.
     */
    @JsonProperty("object")
    private String object;

    /**
     * Indicates whether the resource has been archived.
     * A value of {@code true} means the resource is archived,
     * while {@code false} means it is active and not archived.
     */
    @JsonProperty("archived")
    private boolean archived;
    
    /**
     * Default constructor for Jackson deserialization
     */
    public ArchiveModelResponse() {
    }
    
    /**
     * Gets the unique identifier of the archived model.
     *
     * @return The model identifier
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the archived model.
     *
     * @param id The model identifier
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the object type.
     *
     * @return The object type
     */
    public String getObject() {
        return object;
    }

    /**
     * Sets the object type.
     *
     * @param object The object type
     */
    public void setObject(String object) {
        this.object = object;
    }

    /**
     * Checks if the model was archived.
     *
     * @return True if the model was archived, false otherwise
     */
    public boolean isArchived() {
        return archived;
    }

    /**
     * Sets whether the model was archived.
     *
     * @param archived True if the model was archived, false otherwise
     */
    public void setArchived(boolean archived) {
        this.archived = archived;
    }
}