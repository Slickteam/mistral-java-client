package fr.slickteam.mistralai.client.model;

import java.util.UUID;

/**
 * Represents a fine-tuning job in the Mistral AI API.
 * This class contains information about a fine-tuning job, including its status, files, and related metadata.
 */
public record JobOut(
    /**
     * The unique identifier of the fine-tuning job.
     */
    UUID id,

    /**
     * The object type, typically "fine_tuning.job".
     */
    String object,

    /**
     * The base model being fine-tuned.
     */
    String model,

    /**
     * The current status of the fine-tuning job.
     * Possible values include "validating", "queued", "running", "succeeded", "failed", "cancelled".
     */
    String status,

    /**
     * Additional details about the job status.
     */
    String status_details,

    /**
     * The Unix timestamp (in seconds) of when the job was created.
     */
    Long created_at,

    /**
     * The identifier of the file used for training.
     */
    UUID training_file,

    /**
     * The identifier of the file used for validation.
     */
    UUID validation_file,

    /**
     * The Weights & Biases project associated with this job, if any.
     */
    String wandb_project,

    /**
     * The Weights & Biases run associated with this job, if any.
     */
    String wandb_run
) {
    /**
     * Returns a new Builder instance to create a JobOut.
     *
     * @return a new Builder instance
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder class for creating JobOut instances.
     */
    public static class Builder {
        private UUID id;
        private String object;
        private String model;
        private String status;
        private String status_details;
        private Long created_at;
        private UUID training_file;
        private UUID validation_file;
        private String wandb_project;
        private String wandb_run;

        /**
         * Sets the unique identifier of the fine-tuning job.
         *
         * @param id the job identifier
         * @return this builder instance
         */
        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the object type.
         *
         * @param object the object type (typically "fine_tuning.job")
         * @return this builder instance
         */
        public Builder object(String object) {
            this.object = object;
            return this;
        }

        /**
         * Sets the base model being fine-tuned.
         *
         * @param model the model identifier
         * @return this builder instance
         */
        public Builder model(String model) {
            this.model = model;
            return this;
        }

        /**
         * Sets the current status of the fine-tuning job.
         *
         * @param status the job status (e.g., "running", "succeeded")
         * @return this builder instance
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Sets additional details about the job status.
         *
         * @param status_details the status details
         * @return this builder instance
         */
        public Builder status_details(String status_details) {
            this.status_details = status_details;
            return this;
        }

        /**
         * Sets the creation timestamp.
         *
         * @param created_at the Unix timestamp when the job was created
         * @return this builder instance
         */
        public Builder created_at(Long created_at) {
            this.created_at = created_at;
            return this;
        }

        /**
         * Sets the identifier of the file used for training.
         *
         * @param training_file the training file identifier
         * @return this builder instance
         */
        public Builder training_file(UUID training_file) {
            this.training_file = training_file;
            return this;
        }

        /**
         * Sets the identifier of the file used for validation.
         *
         * @param validation_file the validation file identifier
         * @return this builder instance
         */
        public Builder validation_file(UUID validation_file) {
            this.validation_file = validation_file;
            return this;
        }

        /**
         * Sets the Weights and Biases project associated with this job.
         *
         * @param wandb_project the W and B project name
         * @return this builder instance
         */
        public Builder wandb_project(String wandb_project) {
            this.wandb_project = wandb_project;
            return this;
        }

        /**
         * Sets the Weights and Biases run associated with this job.
         *
         * @param wandb_run the W and B run name
         * @return this builder instance
         */
        public Builder wandb_run(String wandb_run) {
            this.wandb_run = wandb_run;
            return this;
        }

        /**
         * Builds a new JobOut instance with the current builder values.
         *
         * @return a new JobOut instance
         */
        public JobOut build() {
            return new JobOut(id, object, model, status, status_details, created_at,
                training_file, validation_file, wandb_project, wandb_run);
        }
    }
}
