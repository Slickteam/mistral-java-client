package fr.slickteam.mistralai.client.model;

/**
 * Batch jobs output.
 * <p>
 * Used in Mistral AI API operations.
 */


import java.util.List;

public record BatchJobsOut(
    List<BatchJobOut> data,
    String object,
    Integer total
) {}
