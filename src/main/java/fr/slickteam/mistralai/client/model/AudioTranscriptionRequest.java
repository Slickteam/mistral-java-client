package fr.slickteam.mistralai.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 * Represents a request for audio transcription.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AudioTranscriptionRequest(
    String model,
    String file_url,
    String file_id,
    String language,
    Double temperature,
    Boolean diarize,
    List<String> context_bias,
    List<String> timestamp_granularities
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String model;
        private String file_url;
        private String file_id;
        private String language;
        private Double temperature;
        private Boolean diarize;
        private List<String> context_bias;
        private List<String> timestamp_granularities;

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder file_url(String file_url) {
            this.file_url = file_url;
            return this;
        }

        public Builder file_id(String file_id) {
            this.file_id = file_id;
            return this;
        }

        public Builder language(String language) {
            this.language = language;
            return this;
        }

        public Builder temperature(Double temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder diarize(Boolean diarize) {
            this.diarize = diarize;
            return this;
        }

        public Builder context_bias(List<String> context_bias) {
            this.context_bias = context_bias;
            return this;
        }

        public Builder timestamp_granularities(List<String> timestamp_granularities) {
            this.timestamp_granularities = timestamp_granularities;
            return this;
        }

        public AudioTranscriptionRequest build() {
            return new AudioTranscriptionRequest(model, file_url, file_id, language, 
                temperature, diarize, context_bias, timestamp_granularities);
        }
    }
}
