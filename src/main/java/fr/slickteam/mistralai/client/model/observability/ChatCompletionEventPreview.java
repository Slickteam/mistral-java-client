package fr.slickteam.mistralai.client.model.observability;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.Map;

/**
 * Preview of a chat completion event.
 * <p>
 * Contains summary information about a chat completion event for listing/preview purposes.
 * Used in `/v1/observability/chat-completion-events/search` response.
 */
public record ChatCompletionEventPreview(
        @JsonProperty("event_id") String eventId,
        @JsonProperty("correlation_id") String correlationId,
        @JsonProperty("created_at") OffsetDateTime createdAt,
        @JsonProperty("extra_fields") Map<String, Object> extraFields,
        @JsonProperty("nb_input_tokens") Integer nbInputTokens,
        @JsonProperty("nb_output_tokens") Integer nbOutputTokens
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String eventId;
        private String correlationId;
        private OffsetDateTime createdAt;
        private Map<String, Object> extraFields;
        private Integer nbInputTokens;
        private Integer nbOutputTokens;

        public Builder eventId(String eventId) {
            this.eventId = eventId;
            return this;
        }

        public Builder correlationId(String correlationId) {
            this.correlationId = correlationId;
            return this;
        }

        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder extraFields(Map<String, Object> extraFields) {
            this.extraFields = extraFields;
            return this;
        }

        public Builder nbInputTokens(Integer nbInputTokens) {
            this.nbInputTokens = nbInputTokens;
            return this;
        }

        public Builder nbOutputTokens(Integer nbOutputTokens) {
            this.nbOutputTokens = nbOutputTokens;
            return this;
        }

        public ChatCompletionEventPreview build() {
            return new ChatCompletionEventPreview(eventId, correlationId, createdAt, extraFields, nbInputTokens, nbOutputTokens);
        }
    }
}
