package fr.slickteam.mistralai.client.model;

/**
 * Document output.
 * <p>
 * Used in Mistral AI API operations.
 */


import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record DocumentOut(
    UUID id,
    UUID library_id,
    String hash,
    String mime_type,
    String extension,
    Long size,
    String name,
    String summary,
    String created_at,
    String last_processed_at,
    Integer number_of_pages,
    String process_status,
    UUID uploaded_by_id,
    String uploaded_by_type,
    Integer tokens_processing_main_content,
    Integer tokens_processing_summary,
    String url,
    Map<String, Object> attributes,
    String processing_status,
    Integer tokens_processing_total
) {}
