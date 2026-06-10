package fr.slickteam.mistralai.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record LibraryOut(
    UUID id,
    String name,
    String created_at,
    String updated_at,
    UUID owner_id,
    String owner_type,
    Long total_size,
    Integer nb_documents,
    Integer chunk_size,
    String emoji,
    String description,
    String generated_description,
    Integer explicit_user_members_count,
    Integer explicit_workspace_members_count,
    String org_sharing_role,
    String generated_name
) {}
