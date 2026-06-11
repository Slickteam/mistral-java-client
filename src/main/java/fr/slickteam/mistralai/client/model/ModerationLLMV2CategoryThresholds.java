package fr.slickteam.mistralai.client.model;

/**
 * Moderation LLM v2 category thresholds.
 * <p>
 * Used in Mistral AI API operations.
 */


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ModerationLLMV2CategoryThresholds(
    Double sexual,
    Double hate_and_discrimination,
    Double violence_and_threats,
    Double dangerous,
    Double criminal,
    Double selfharm,
    Double health,
    Double financial,
    Double law,
    Double pii,
    Double jailbreaking
) {}
