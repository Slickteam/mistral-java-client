package fr.slickteam.mistralai.client.model;

import fr.slickteam.mistralai.client.type.ToolTypes;

/**
 * Represents a tool the model may call.
 */
public record Tool(
    /**
     * The type of the tool. Currently only "function" is supported.
     */
    ToolTypes type,

    /**
     * The function definition.
     */
    Function function
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ToolTypes type = ToolTypes.FUNCTION;
        private Function function;

        public Builder type(ToolTypes type) {
            this.type = type;
            return this;
        }

        public Builder function(Function function) {
            this.function = function;
            return this;
        }

        public Tool build() {
            return new Tool(type, function);
        }
    }
}
