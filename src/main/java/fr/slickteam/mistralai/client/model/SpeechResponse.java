package fr.slickteam.mistralai.client.model;

/**
 * Speech response.
 * <p>
 * Used in Mistral AI API operations.
 */


public record SpeechResponse(
    String audio_data
) {}
