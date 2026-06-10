package fr.slickteam.mistralai.client.model;

/**
 * Represents a signed URL for accessing a file in the Mistral AI API.
 * This class contains a pre-signed URL that can be used to download a file without authentication.
 */
public record FileSignedURL(
    /**
     * The pre-signed URL that can be used to download the file.
     * This URL is temporary and will expire after a certain period.
     */
    String url
) {
    /**
     * Returns a new Builder instance to create a FileSignedURL.
     *
     * @return a new Builder instance
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder class for creating FileSignedURL instances.
     */
    public static class Builder {
        private String url;

        /**
         * Sets the pre-signed URL for downloading the file.
         *
         * @param url the pre-signed URL
         * @return this builder instance
         */
        public Builder url(String url) {
            this.url = url;
            return this;
        }

        /**
         * Builds a new FileSignedURL instance with the current builder values.
         *
         * @return a new FileSignedURL instance
         */
        public FileSignedURL build() {
            return new FileSignedURL(url);
        }
    }
}
