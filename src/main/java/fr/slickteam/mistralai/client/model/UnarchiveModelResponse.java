package fr.slickteam.mistralai.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response model for unarchive model operation.
 */
public class UnarchiveModelResponse {
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("object")
    private String object;
    
    @JsonProperty("unarchived")
    private boolean unarchived;
    
    /**
     * Default constructor for Jackson deserialization
     */
    public UnarchiveModelResponse() {
    }
    
    /**
     * Gets the unique identifier of the unarchived model.
     *
     * @return The model identifier
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the unarchived model.
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
     * Checks if the model was unarchived.
     *
     * @return True if the model was unarchived, false otherwise
     */
    public boolean isUnarchived() {
        return unarchived;
    }

    /**
     * Sets whether the model was unarchived.
     *
     * @param unarchived True if the model was unarchived, false otherwise
     */
    public void setUnarchived(boolean unarchived) {
        this.unarchived = unarchived;
    }
}