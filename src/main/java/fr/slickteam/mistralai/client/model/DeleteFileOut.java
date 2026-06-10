package fr.slickteam.mistralai.client.model;

import java.util.UUID;

/**
 * Represents the response from a file deletion operation in the Mistral AI API.
 * This class contains information about the deleted file and the status of the deletion.
 */
public record DeleteFileOut(
    /**
     * The unique identifier of the deleted file.
     */
    UUID id,

    /**
     * The object type, typically "file_deleted".
     */
    String object,

    /**
     * Whether the file was successfully deleted.
     */
    Boolean deleted
) {
    /**
     * Returns a new Builder instance to create a DeleteFileOut.
     *
     * @return a new Builder instance
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder class for creating DeleteFileOut instances.
     */
    public static class Builder {
        private UUID id;
        private String object;
        private Boolean deleted;

        /**
         * Sets the unique identifier of the deleted file.
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
         * @param object the object type (typically "file_deleted")
         * @return this builder instance
         */
        public Builder object(String object) {
            this.object = object;
            return this;
        }

        /**
         * Sets whether the file was successfully deleted.
         *
         * @param deleted true if the file was deleted, false otherwise
         * @return this builder instance
         */
        public Builder deleted(Boolean deleted) {
            this.deleted = deleted;
            return this;
        }

        /**
         * Builds a new DeleteFileOut instance with the current builder values.
         *
         * @return a new DeleteFileOut instance
         */
        public DeleteFileOut build() {
            return new DeleteFileOut(id, object, deleted);
        }
    }
}
