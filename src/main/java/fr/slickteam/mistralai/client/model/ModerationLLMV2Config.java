package fr.slickteam.mistralai.client.model;

/**
 * Moderation LLM v2 configuration.
 * <p>
 * Used in Mistral AI API operations.
 */


import com.fasterxml.jackson.annotation.JsonInclude;
import fr.slickteam.mistralai.client.type.ModerationLLMAction;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ModerationLLMV2Config(
    String model_name,
    ModerationLLMV2CategoryThresholds custom_category_thresholds,
    Boolean ignore_other_categories,
    ModerationLLMAction action
) {}
