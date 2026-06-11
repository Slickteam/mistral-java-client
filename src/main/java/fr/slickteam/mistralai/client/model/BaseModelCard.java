package fr.slickteam.mistralai.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Base model information.
 * <p>
 * Returned by `GET /v1/models/{model_id}` for base models.
 */
public class BaseModelCard {

    /**
     * The unique identifier of the model.
     */
    private String id;

    /**
     * The object type, typically "model".
     */
    private String object;

    /**
     * The type of the model, typically "base".
     */
    private String type;

    /**
     * The timestamp when the model was created, in ISO 8601 format.
     */
    private String created;

    /**
     * The owner of the model.
     */
    private String owner;

    /**
     * The properties of the model, such as context length and maximum tokens.
     */
    private ModelProperties properties;

    /**
     * Default constructor for Jackson deserialization
     */
    public BaseModelCard() {
    }

    /**
     * Constructor with all fields
     */
    public BaseModelCard(String id, String object, String type, String created, String owner, ModelProperties properties) {
        this.id = id;
        this.object = object;
        this.type = type;
        this.created = created;
        this.owner = owner;
        this.properties = properties;
    }

    /**
     * Returns a new Builder instance to create a BaseModelCard.
     *
     * @return a new Builder instance
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder class for creating BaseModelCard instances.
     */
    public static class Builder {
        private String id;
        private String object;
        private String type;
        private String created;
        private String owner;
        private ModelProperties properties;

        /**
         * Sets the unique identifier of the model.
         *
         * @param id the model identifier
         * @return this builder instance
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the object type, typically "model".
         *
         * @param object the object type
         * @return this builder instance
         */
        public Builder object(String object) {
            this.object = object;
            return this;
        }

        /**
         * Sets the type of the model, typically "base".
         *
         * @param type the model type
         * @return this builder instance
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Sets the timestamp when the model was created, in ISO 8601 format.
         *
         * @param created the creation timestamp
         * @return this builder instance
         */
        public Builder created(String created) {
            this.created = created;
            return this;
        }

        /**
         * Sets the owner of the model.
         *
         * @param owner the model owner
         * @return this builder instance
         */
        public Builder owner(String owner) {
            this.owner = owner;
            return this;
        }

        /**
         * Sets the properties of the model, such as context length and maximum tokens.
         *
         * @param properties the model properties
         * @return this builder instance
         */
        public Builder properties(ModelProperties properties) {
            this.properties = properties;
            return this;
        }

        /**
         * Builds a new BaseModelCard instance with the current builder values.
         *
         * @return a new BaseModelCard instance
         */
        public BaseModelCard build() {
            return new BaseModelCard(id, object, type, created, owner, properties);
        }
    }

    // Getters and setters

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public ModelProperties getProperties() {
        return properties;
    }

    public void setProperties(ModelProperties properties) {
        this.properties = properties;
    }
}
