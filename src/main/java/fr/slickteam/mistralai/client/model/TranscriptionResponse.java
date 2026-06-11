package fr.slickteam.mistralai.client.model;

/**
 * Transcription response.
 * <p>
 * Used in Mistral AI API operations.
 */


import java.util.List;

public record TranscriptionResponse(
    String model,
    String text,
    String language,
    List<TranscriptionSegment> segments,
    Usage usage
) {}
