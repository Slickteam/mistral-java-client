package fr.slickteam.mistralai.client.model;

/**
 * Response model for batch job operations.
 */
public class BatchJobResponse {

    /**
     * Represents the unique identifier for a batch job operation.
     * This identifier is used to track, query, or manage a specific batch job.
     */
    public String id;

    /**
     * Represents the current status of a batch job.
     * The status indicates the job's progress or completion state,
     * such as whether it is queued, running, or completed.
     */
    public String status;

    /**
     * Represents the timestamp when the batch job was created.
     * This field captures the moment the job is initiated and serves as
     * a reference point for tracking the job's lifecycle.
     * It is typically formatted as a string in ISO 8601 format (e.g., "YYYY-MM-DDTHH:MM:SSZ").
     */
    public String createdAt;

    /**
     * The identifier of the model associated with the batch job response.
     *
     * This field represents the unique name or identifier of the model
     * that was used to process the corresponding batch job. It helps
     * to ascertain which model configuration was applied during the
     * operation's execution.
     */
    public String model;
}