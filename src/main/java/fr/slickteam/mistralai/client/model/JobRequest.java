package fr.slickteam.mistralai.client.model;

/**
 * Request model for job creation.
 */
public class JobRequest {
    public String model;
    public String trainingFile;
    public String validationFile;
    public Hyperparameters hyperparameters;
    public String suffix;
}