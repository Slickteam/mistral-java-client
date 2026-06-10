package fr.slickteam.mistralai.client.model;

import java.util.List;

public record TranscriptionResponse(
    String model,
    String text,
    String language,
    List<TranscriptionSegment> segments,
    Usage usage
) {}
