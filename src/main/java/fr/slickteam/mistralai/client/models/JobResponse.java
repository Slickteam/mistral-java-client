package fr.slickteam.mistralai.client.models;

/**
 * Response model for job operations.
 */
public class JobResponse {
    public String id;
    public String object;
    public String model;
    public long createdAt;
    public Long finishedAt;
    public String status;
    public String trainingFile;
    public String validationFile;
    public Hyperparameters hyperparameters;
    public JobResult result;
}