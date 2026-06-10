package fr.slickteam.mistralai.client.model;

/**
 * Response for archiving a fine-tuned model.
 */
public record ArchiveFTModelOut(
    String id,
    String object,
    Boolean archived
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String object = "model";
        private Boolean archived = true;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder object(String object) {
            this.object = object;
            return this;
        }

        public Builder archived(Boolean archived) {
            this.archived = archived;
            return this;
        }

        public ArchiveFTModelOut build() {
            return new ArchiveFTModelOut(id, object, archived);
        }
    }
}
