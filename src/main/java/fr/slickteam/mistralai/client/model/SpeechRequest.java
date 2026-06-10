package fr.slickteam.mistralai.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record SpeechRequest(
    String model,
    Boolean stream,
    String voice_id,
    String ref_audio,
    String input,
    String response_format
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String model;
        private Boolean stream;
        private String voice_id;
        private String ref_audio;
        private String input;
        private String response_format;

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder stream(Boolean stream) {
            this.stream = stream;
            return this;
        }

        public Builder voice_id(String voice_id) {
            this.voice_id = voice_id;
            return this;
        }

        public Builder ref_audio(String ref_audio) {
            this.ref_audio = ref_audio;
            return this;
        }

        public Builder input(String input) {
            this.input = input;
            return this;
        }

        public Builder response_format(String response_format) {
            this.response_format = response_format;
            return this;
        }

        public SpeechRequest build() {
            return new SpeechRequest(model, stream, voice_id, ref_audio, input, response_format);
        }
    }
}
