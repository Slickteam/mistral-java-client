package fr.slickteam.mistralai.client.model;

import java.util.Map;

/**
 * Represents a JSON schema to be used in response format.
 */
public record JsonSchema(
    /**
     * The name of the schema.
     */
    String name,

    /**
     * A description of what the response should contain.
     */
    String description,

    /**
     * The schema itself as a Map.
     */
    Map<String, Object> schema,

    /**
     * Whether to use strict mode or not.
     */
    Boolean strict
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String description;
        private Map<String, Object> schema;
        private Boolean strict;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder schema(Map<String, Object> schema) {
            this.schema = schema;
            return this;
        }

        public Builder strict(Boolean strict) {
            this.strict = strict;
            return this;
        }

        public JsonSchema build() {
            return new JsonSchema(name, description, schema, strict);
        }
    }
}
