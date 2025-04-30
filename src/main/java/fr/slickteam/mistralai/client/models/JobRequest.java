package fr.slickteam.mistralai.client.models;

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