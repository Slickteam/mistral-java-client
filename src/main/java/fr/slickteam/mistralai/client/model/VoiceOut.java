package fr.slickteam.mistralai.client.model;

/**
 * Voice output.
 * <p>
 * Used in Mistral AI API operations.
 */


import java.util.UUID;

public record VoiceOut(
    String name,
    UUID id,
    String created_at,
    String user_id
) {}
