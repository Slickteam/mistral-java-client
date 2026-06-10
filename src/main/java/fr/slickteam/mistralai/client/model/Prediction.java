package fr.slickteam.mistralai.client.model;

/**
 * Enable users to specify an expected completion.
 */
public record Prediction(
    /**
     * The type of prediction. Currently only "content" is supported.
     */
    String type,

    /**
     * The expected content.
     */
    Object content
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String type = "content";
        private Object content;

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder content(Object content) {
            this.content = content;
            return this;
        }

        public Prediction build() {
            return new Prediction(type, content);
        }
    }
}
