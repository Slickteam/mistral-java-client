package fr.slickteam.mistralai.client.model;

public record TranscriptionSegment(
    String text,
    Double start,
    Double end,
    Double score,
    String speaker_id
) {}
