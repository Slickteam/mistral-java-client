package fr.slickteam.mistralai.client.model;

import java.util.Map;

/**
 * Represents a function definition for a tool.
 */
public record Function(
    /**
     * The name of the function.
     */
    String name,

    /**
     * A description of what the function does.
     */
    String description,

    /**
     * Whether to use strict mode or not.
     */
    Boolean strict,

    /**
     * The parameters the functions accepts, described as a JSON Schema object.
     */
    Map<String, Object> parameters
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String description;
        private Boolean strict;
        private Map<String, Object> parameters;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder strict(Boolean strict) {
            this.strict = strict;
            return this;
        }

        public Builder parameters(Map<String, Object> parameters) {
            this.parameters = parameters;
            return this;
        }

        public Function build() {
            return new Function(name, description, strict, parameters);
        }
    }
}
