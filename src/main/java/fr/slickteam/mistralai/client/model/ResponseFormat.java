package fr.slickteam.mistralai.client.model;

import fr.slickteam.mistralai.client.type.ResponseFormats;

/**
 * Represents the format that the model must output.
 */
public record ResponseFormat(
    /**
     * The type of response format.
     */
    ResponseFormats type,

    /**
     * The JSON schema to use if type is json_schema.
     */
    JsonSchema json_schema
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ResponseFormats type;
        private JsonSchema json_schema;

        public Builder type(ResponseFormats type) {
            this.type = type;
            return this;
        }

        public Builder json_schema(JsonSchema json_schema) {
            this.json_schema = json_schema;
            return this;
        }

        public ResponseFormat build() {
            return new ResponseFormat(type, json_schema);
        }
    }
}
