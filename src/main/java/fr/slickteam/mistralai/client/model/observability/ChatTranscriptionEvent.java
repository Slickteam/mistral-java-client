package fr.slickteam.mistralai.client.model.observability;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

/**
 * Chat transcription event.
 * <p>
 * Represents a transcription event within a chat completion.
 * Used in chat completion event details.
 */
public record ChatTranscriptionEvent(
        @JsonProperty("type") String type,
        @JsonProperty("transcription_id") String transcriptionId,
        @JsonProperty("created_at") OffsetDateTime createdAt,
        @JsonProperty("model") String model,
        @JsonProperty("audio_duration") Double audioDuration
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String type;
        private String transcriptionId;
        private OffsetDateTime createdAt;
        private String model;
        private Double audioDuration;

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder transcriptionId(String transcriptionId) {
            this.transcriptionId = transcriptionId;
            return this;
        }

        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder audioDuration(Double audioDuration) {
            this.audioDuration = audioDuration;
            return this;
        }

        public ChatTranscriptionEvent build() {
            return new ChatTranscriptionEvent(type, transcriptionId, createdAt, model, audioDuration);
        }
    }
}
