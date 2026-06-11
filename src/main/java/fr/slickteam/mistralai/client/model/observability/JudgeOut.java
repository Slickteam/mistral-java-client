package fr.slickteam.mistralai.client.model.observability;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Judge information from observability API.
 * <p>
 * Represents a judge entity with type, model, and configuration.
 * Used in `/v1/observability/judges` operations.
 */
public record JudgeOut(
        @JsonProperty("id") UUID id,
        @JsonProperty("created_at") OffsetDateTime createdAt,
        @JsonProperty("updated_at") OffsetDateTime updatedAt,
        @JsonProperty("deleted_at") OffsetDateTime deletedAt,
        @JsonProperty("owner_id") UUID ownerId,
        @JsonProperty("workspace_id") UUID workspaceId,
        @JsonProperty("name") String name,
        @JsonProperty("description") String description,
        @JsonProperty("model_name") String modelName,
        @JsonProperty("instructions") String instructions,
        @JsonProperty("tools") List<String> tools
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private UUID id;
        private OffsetDateTime createdAt;
        private OffsetDateTime updatedAt;
        private OffsetDateTime deletedAt;
        private UUID ownerId;
        private UUID workspaceId;
        private String name;
        private String description;
        private String modelName;
        private String instructions;
        private List<String> tools;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(OffsetDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder deletedAt(OffsetDateTime deletedAt) {
            this.deletedAt = deletedAt;
            return this;
        }

        public Builder ownerId(UUID ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        public Builder workspaceId(UUID workspaceId) {
            this.workspaceId = workspaceId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder modelName(String modelName) {
            this.modelName = modelName;
            return this;
        }

        public Builder instructions(String instructions) {
            this.instructions = instructions;
            return this;
        }

        public Builder tools(List<String> tools) {
            this.tools = tools;
            return this;
        }

        public JudgeOut build() {
            return new JudgeOut(id, createdAt, updatedAt, deletedAt, ownerId, workspaceId, name, description, modelName, instructions, tools);
        }
    }
}
