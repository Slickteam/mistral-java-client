package fr.slickteam.mistralai.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

/**
 * Represents a request to the moderations endpoint of the Mistral AI API.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ClassificationRequest(
    /**
     * ID of the model to use.
     */
    String model,

    /**
     * Additional metadata for the request.
     */
    Map<String, String> metadata,

    /**
     * Text to classify. Can be a string or a list of strings.
     */
    Object input
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String model;
        private Map<String, String> metadata;
        private Object input;

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder metadata(Map<String, String> metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder input(Object input) {
            this.input = input;
            return this;
        }

        public ClassificationRequest build() {
            return new ClassificationRequest(model, metadata, input);
        }
    }
}
