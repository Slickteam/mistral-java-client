package fr.slickteam.mistralai.client.model;

import java.util.UUID;

/**
 * Represents a file in the Mistral AI API.
 * This class contains metadata about a file that has been uploaded to the API.
 */
public record FileObject(
    /**
     * The unique identifier of the file.
     */
    UUID id,

    /**
     * The object type, typically "file".
     */
    String object,

    /**
     * The size of the file in bytes.
     */
    Long bytes,

    /**
     * The Unix timestamp (in seconds) of when the file was created.
     */
    Long created_at,

    /**
     * The name of the file.
     */
    String filename,

    /**
     * The purpose of the file, such as "fine-tune".
     */
    String purpose,

    /**
     * The status of the file, such as "processed".
     */
    String status,

    /**
     * Additional details about the file status.
     */
    String status_details
) {
    /**
     * Returns a new Builder instance to create a FileObject.
     *
     * @return a new Builder instance
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder class for creating FileObject instances.
     */
    public static class Builder {
        private UUID id;
        private String object;
        private Long bytes;
        private Long created_at;
        private String filename;
        private String purpose;
        private String status;
        private String status_details;

        /**
         * Sets the unique identifier of the file.
         *
         * @param id the file identifier
         * @return this builder instance
         */
        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the object type.
         *
         * @param object the object type (typically "file")
         * @return this builder instance
         */
        public Builder object(String object) {
            this.object = object;
            return this;
        }

        /**
         * Sets the size of the file in bytes.
         *
         * @param bytes the file size
         * @return this builder instance
         */
        public Builder bytes(Long bytes) {
            this.bytes = bytes;
            return this;
        }

        /**
         * Sets the creation timestamp.
         *
         * @param created_at the Unix timestamp when the file was created
         * @return this builder instance
         */
        public Builder created_at(Long created_at) {
            this.created_at = created_at;
            return this;
        }

        /**
         * Sets the name of the file.
         *
         * @param filename the file name
         * @return this builder instance
         */
        public Builder filename(String filename) {
            this.filename = filename;
            return this;
        }

        /**
         * Sets the purpose of the file.
         *
         * @param purpose the file purpose (e.g., "fine-tune")
         * @return this builder instance
         */
        public Builder purpose(String purpose) {
            this.purpose = purpose;
            return this;
        }

        /**
         * Sets the status of the file.
         *
         * @param status the file status (e.g., "processed")
         * @return this builder instance
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Sets additional details about the file status.
         *
         * @param status_details the status details
         * @return this builder instance
         */
        public Builder status_details(String status_details) {
            this.status_details = status_details;
            return this;
        }

        /**
         * Builds a new FileObject instance with the current builder values.
         *
         * @return a new FileObject instance
         */
        public FileObject build() {
            return new FileObject(id, object, bytes, created_at, filename, purpose, status, status_details);
        }
    }
}
