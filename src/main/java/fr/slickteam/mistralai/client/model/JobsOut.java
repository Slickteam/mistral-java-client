package fr.slickteam.mistralai.client.model;

import java.util.List;

/**
 * Represents a list of fine-tuning jobs in the Mistral AI API.
 * This class is returned by the list fine-tuning jobs endpoint and contains information about all available jobs.
 */
public record JobsOut(
    /**
     * The list of fine-tuning jobs.
     */
    List<JobOut> data,

    /**
     * The object type, typically "list".
     */
    String object
) {
    /**
     * Returns a new Builder instance to create a JobsOut.
     *
     * @return a new Builder instance
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder class for creating JobsOut instances.
     */
    public static class Builder {
        private List<JobOut> data;
        private String object;

        /**
         * Sets the list of fine-tuning jobs.
         *
         * @param data the list of jobs
         * @return this builder instance
         */
        public Builder data(List<JobOut> data) {
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
         * Builds a new JobsOut instance with the current builder values.
         *
         * @return a new JobsOut instance
         */
        public JobsOut build() {
            return new JobsOut(data, object);
        }
    }
}
