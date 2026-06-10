package fr.slickteam.mistralai.client.model.library;

/**
 * Status of a document in a library.
 */
public record DocumentStatusOut(
    String id,
    String status,
    String errorMessage
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String status;
        private String errorMessage;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder errorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        public DocumentStatusOut build() {
            return new DocumentStatusOut(id, status, errorMessage);
        }
    }
}
