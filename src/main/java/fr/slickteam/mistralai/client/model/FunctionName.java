package fr.slickteam.mistralai.client.model;

/**
 * Represents a function name for tool choice.
 */
public record FunctionName(
    /**
     * The name of the function.
     */
    String name
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public FunctionName build() {
            return new FunctionName(name);
        }
    }
}
