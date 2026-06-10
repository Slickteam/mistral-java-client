package fr.slickteam.mistralai.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ModerationLLMV1CategoryThresholds(
    Double sexual,
    Double hate_and_discrimination,
    Double violence_and_threats,
    Double dangerous_and_criminal_content,
    Double selfharm,
    Double health,
    Double financial,
    Double law,
    Double pii
) {}
