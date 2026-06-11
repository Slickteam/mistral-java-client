package fr.slickteam.mistralai.client.model;

/**
 * Transcription segment.
 * <p>
 * Used in Mistral AI API operations.
 */


public record TranscriptionSegment(
    String text,
    Double start,
    Double end,
    Double score,
    String speaker_id
) {}
