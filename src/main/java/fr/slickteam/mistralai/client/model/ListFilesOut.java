package fr.slickteam.mistralai.client.model;

import java.util.List;

/**
 * Represents a list of files in the Mistral AI API.
 * This class is returned by the list files endpoint and contains information about all available files.
 */
public record ListFilesOut(
    /**
     * The list of files.
     */
    List<FileObject> data,

    /**
     * The object type, typically "list".
     */
    String object
) {
    /**
     * Returns a new Builder instance to create a ListFilesOut.
     *
     * @return a new Builder instance
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder class for creating ListFilesOut instances.
     */
    public static class Builder {
        private List<FileObject> data;
        private String object;

        /**
         * Sets the list of files.
         *
         * @param data the list of files
         * @return this builder instance
         */
        public Builder data(List<FileObject> data) {
            this.data = data;
            return this;
        }

        /**
         * Sets the object type.
         *
         * @param object the object type (typically "list")
         * @return this builder instance
         */
        public Builder object(String object) {
            this.object = object;
            return this;
        }

        /**
         * Builds a new ListFilesOut instance with the current builder values.
         *
         * @return a new ListFilesOut instance
         */
        public ListFilesOut build() {
            return new ListFilesOut(data, object);
        }
    }
}
