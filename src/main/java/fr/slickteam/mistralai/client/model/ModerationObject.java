package fr.slickteam.mistralai.client.model;

/**
 * Moderation object.
 * <p>
 * Used in Mistral AI API operations.
 */


import java.util.Map;

public record ModerationObject(
    Map<String, Boolean> categories,
    Map<String, Double> category_scores
) {}
