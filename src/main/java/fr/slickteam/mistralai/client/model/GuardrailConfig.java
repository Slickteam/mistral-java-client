package fr.slickteam.mistralai.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Guardrail configuration.
 * <p>
 * Used to configure moderation and safety guardrails.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record GuardrailConfig(
    Boolean block_on_error,
    ModerationLLMV1Config moderation_llm_v1,
    ModerationLLMV2Config moderation_llm_v2
) {}
