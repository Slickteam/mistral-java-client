package fr.slickteam.mistralai.client.model.observability;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/**
 * Chat completion event from observability API.
 * <p>
 * Represents a completed chat interaction event with metadata, token counts, and message information.
 * Used in `/v1/observability/chat-completion-events/{event_id}` and search operations.
 */
public record ChatCompletionEventOut(
        @JsonProperty("event_id") String eventId,
        @JsonProperty("correlation_id") String correlationId,
        @JsonProperty("created_at") OffsetDateTime createdAt,
        @JsonProperty("extra_fields") Map<String, Object> extraFields,
        @JsonProperty("nb_input_tokens") Integer nbInputTokens,
        @JsonProperty("nb_output_tokens") Integer nbOutputTokens,
        @JsonProperty("enabled_tools") List<Map<String, Object>> enabledTools,
        @JsonProperty("request_messages") List<Map<String, Object>> requestMessages,
        @JsonProperty("response_messages") List<Map<String, Object>> responseMessages,
        @JsonProperty("nb_messages") Integer nbMessages,
        @JsonProperty("chat_transcription_events") List<ChatTranscriptionEvent> chatTranscriptionEvents
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
        private List<Map<String, Object>> enabledTools;
        private List<Map<String, Object>> requestMessages;
        private List<Map<String, Object>> responseMessages;
        private Integer nbMessages;
        private List<ChatTranscriptionEvent> chatTranscriptionEvents;

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

        public Builder enabledTools(List<Map<String, Object>> enabledTools) {
            this.enabledTools = enabledTools;
            return this;
        }

        public Builder requestMessages(List<Map<String, Object>> requestMessages) {
            this.requestMessages = requestMessages;
            return this;
        }

        public Builder responseMessages(List<Map<String, Object>> responseMessages) {
            this.responseMessages = responseMessages;
            return this;
        }

        public Builder nbMessages(Integer nbMessages) {
            this.nbMessages = nbMessages;
            return this;
        }

        public Builder chatTranscriptionEvents(List<ChatTranscriptionEvent> chatTranscriptionEvents) {
            this.chatTranscriptionEvents = chatTranscriptionEvents;
            return this;
        }

        public ChatCompletionEventOut build() {
            return new ChatCompletionEventOut(eventId, correlationId, createdAt, extraFields, nbInputTokens, nbOutputTokens, enabledTools, requestMessages, responseMessages, nbMessages, chatTranscriptionEvents);
        }
    }
}
