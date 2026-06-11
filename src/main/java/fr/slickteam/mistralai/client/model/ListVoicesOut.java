package fr.slickteam.mistralai.client.model;

/**
 * List of voices output.
 * <p>
 * Used in Mistral AI API operations.
 */


import java.util.List;

public record ListVoicesOut(
    List<VoiceOut> voices
) {}
