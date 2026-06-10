package fr.slickteam.mistralai.client.model;

import java.util.Map;

public record ModerationObject(
    Map<String, Boolean> categories,
    Map<String, Double> category_scores
) {}
