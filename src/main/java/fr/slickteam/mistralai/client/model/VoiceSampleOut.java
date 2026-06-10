package fr.slickteam.mistralai.client.model;

/**
 * Response for voice sample.
 */
public record VoiceSampleOut(
    String id,
    String object,
    String created,
    String voiceId,
    String audioData
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String object;
        private String created;
        private String voiceId;
        private String audioData;

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

        public Builder voiceId(String voiceId) {
            this.voiceId = voiceId;
            return this;
        }

        public Builder audioData(String audioData) {
            this.audioData = audioData;
            return this;
        }

        public VoiceSampleOut build() {
            return new VoiceSampleOut(id, object, created, voiceId, audioData);
        }
    }
}
