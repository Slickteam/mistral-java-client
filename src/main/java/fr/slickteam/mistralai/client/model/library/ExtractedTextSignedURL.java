package fr.slickteam.mistralai.client.model.library;

/**
 * Signed URL for extracted text from a document.
 */
public record ExtractedTextSignedURL(
    String url,
    Long expiresAt
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String url;
        private Long expiresAt;

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder expiresAt(Long expiresAt) {
            this.expiresAt = expiresAt;
            return this;
        }

        public ExtractedTextSignedURL build() {
            return new ExtractedTextSignedURL(url, expiresAt);
        }
    }
}
