package fr.slickteam.mistralai.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response model for delete model operation.
 */
public class DeleteModelResponse {
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("object")
    private String object;
    
    @JsonProperty("deleted")
    private boolean deleted;
    
    /**
     * Default constructor for Jackson deserialization
     */
    public DeleteModelResponse() {
    }
    
    /**
     * Gets the unique identifier of the deleted model.
     *
     * @return The model identifier
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the deleted model.
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
     * Checks if the model was deleted.
     *
     * @return True if the model was deleted, false otherwise
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     * Sets whether the model was deleted.
     *
     * @param deleted True if the model was deleted, false otherwise
     */
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}