package fr.slickteam.mistralai.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * List of models.
 */
public class ModelList {
    @JsonProperty("object")
    private String object;
    
    @JsonProperty("data")
    private List<Model> data;
    
    /**
     * Default constructor for Jackson deserialization
     */
    public ModelList() {
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
     * Gets the list of models.
     *
     * @return The list of models
     */
    public List<Model> getData() {
        return data;
    }

    /**
     * Sets the list of models.
     *
     * @param data The list of models
     */
    public void setData(List<Model> data) {
        this.data = data;
    }
}