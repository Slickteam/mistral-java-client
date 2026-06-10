package fr.slickteam.mistralai.client.model.library;

/**
 * Response for document reprocessing.
 */
public record ReprocessDocumentOut(
    String id,
    String status,
    String object
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String status;
        private String object = "document";

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder object(String object) {
            this.object = object;
            return this;
        }

        public ReprocessDocumentOut build() {
            return new ReprocessDocumentOut(id, status, object);
        }
    }
}
