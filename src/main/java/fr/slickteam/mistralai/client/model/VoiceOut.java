package fr.slickteam.mistralai.client.model;

import java.util.UUID;

public record VoiceOut(
    String name,
    UUID id,
    String created_at,
    String user_id
) {}
