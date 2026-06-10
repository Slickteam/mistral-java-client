package fr.slickteam.mistralai.client.model;

/**
 * Result metrics for a fine-tuning job.
 */
public class JobResult {
    public double trainLoss;
    public double trainAccuracy;
    public double validationLoss;
    public double validationAccuracy;
}