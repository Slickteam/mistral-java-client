package fr.slickteam.mistralai.client.model;

import java.util.UUID;

public record TrainingFile(
    UUID file_id,
    Double weight
) {}
