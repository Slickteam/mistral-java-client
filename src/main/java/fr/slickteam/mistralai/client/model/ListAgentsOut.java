package fr.slickteam.mistralai.client.model;

/**
 * List of agents output.
 * <p>
 * Used in Mistral AI API operations.
 */


import java.util.List;

public record ListAgentsOut(
    List<Agent> data,
    String object
) {}
