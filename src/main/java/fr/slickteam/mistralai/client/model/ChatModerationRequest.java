package fr.slickteam.mistralai.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Represents a request to the chat moderations endpoint of the Mistral AI API.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ChatModerationRequest(
    /**
     * Chat to classify.
     */
    Object input,

    /**
     * ID of the model to use.
     */
    String model
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Object input;
        private String model;

        public Builder input(Object input) {
            this.input = input;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public ChatModerationRequest build() {
            return new ChatModerationRequest(input, model);
        }
    }
}
