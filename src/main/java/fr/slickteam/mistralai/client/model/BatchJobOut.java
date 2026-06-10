package fr.slickteam.mistralai.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BatchJobOut(
    String id,
    String object,
    List<UUID> input_files,
    Map<String, Object> metadata,
    String endpoint,
    String model,
    String agent_id,
    UUID output_file,
    UUID error_file,
    List<Object> errors,
    List<Map<String, Object>> outputs,
    String status,
    Long created_at,
    Integer total_requests,
    Integer completed_requests,
    Integer succeeded_requests,
    Integer failed_requests,
    Long started_at,
    Long completed_at
) {}
