package fr.slickteam.mistralai.client.model;

import fr.slickteam.mistralai.client.type.ToolTypes;

/**
 * Represents a specific tool to be called by the model.
 */
public record ToolChoice(
    /**
     * The type of the tool. Currently only "function" is supported.
     */
    ToolTypes type,

    /**
     * The function to be called.
     */
    FunctionName function
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ToolTypes type = ToolTypes.FUNCTION;
        private FunctionName function;

        public Builder type(ToolTypes type) {
            this.type = type;
            return this;
        }

        public Builder function(FunctionName function) {
            this.function = function;
            return this;
        }

        public ToolChoice build() {
            return new ToolChoice(type, function);
        }
    }
}
