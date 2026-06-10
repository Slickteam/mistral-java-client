package fr.slickteam.mistralai.client.model;

/**
 * Response for streaming audio transcriptions.
 */
public record AudioTranscriptionsStreamOut(
    String id,
    String object,
    String created,
    String model,
    String text
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String object;
        private String created;
        private String model;
        private String text;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder object(String object) {
            this.object = object;
            return this;
        }

        public Builder created(String created) {
            this.created = created;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public AudioTranscriptionsStreamOut build() {
            return new AudioTranscriptionsStreamOut(id, object, created, model, text);
        }
    }
}
