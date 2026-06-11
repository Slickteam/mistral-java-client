package fr.slickteam.mistralai.client.model;

/**
 * Weights and Biases integration.
 * <p>
 * Used in Mistral AI API operations.
 */


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record WandbIntegration(
    String type,
    String project,
    String name,
    String api_key,
    String run_name
) {}
