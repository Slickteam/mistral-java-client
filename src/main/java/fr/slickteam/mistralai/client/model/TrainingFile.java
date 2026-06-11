package fr.slickteam.mistralai.client.model;

/**
 * Training file.
 * <p>
 * Used in Mistral AI API operations.
 */


import java.util.UUID;

public record TrainingFile(
    UUID file_id,
    Double weight
) {}
