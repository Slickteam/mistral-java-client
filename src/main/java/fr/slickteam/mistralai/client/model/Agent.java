package fr.slickteam.mistralai.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Agent(
    String id,
    String name,
    String description,
    String model,
    String instructions,
    List<Object> tools,
    List<GuardrailConfig> guardrails,
    Map<String, Object> metadata,
    String object,
    Integer version,
    List<Integer> versions,
    String created_at,
    String updated_at,
    Boolean deployment_chat,
    String source,
    String version_message
) {}
