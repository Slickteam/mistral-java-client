package fr.slickteam.mistralai.client.models;

import java.util.List;

/**
 * Response model for listing batch jobs.
 */
public class BatchJobsResponse {

    /**
     * A list containing batch job responses.
     *
     * This collection holds the responses for individual batch job operations,
     * where each item in the list represents the details of a specific batch job.
     * These responses provide information such as the unique identifier,
     * status, creation timestamp, and the model associated with the job.
     */
    public List<BatchJobResponse> jobs;

    /**
     * Represents the total number of batch jobs listed in the response.
     *
     * This variable specifies the aggregate count of batch jobs included
     * in the response data. It provides an overall view of the number of
     * batch job entries available, which may be used for pagination or
     * summary purposes.
     */
    public int total;

}