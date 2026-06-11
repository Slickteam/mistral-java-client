package fr.slickteam.mistralai.client.model.observability;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Campaign information from observability API.
 * <p>
 * Represents a campaign entity with name, owner, and configuration.
 * Used in `/v1/observability/campaigns` operations.
 */
public record CampaignOut(
        @JsonProperty("id") UUID id,
        @JsonProperty("created_at") OffsetDateTime createdAt,
        @JsonProperty("updated_at") OffsetDateTime updatedAt,
        @JsonProperty("deleted_at") OffsetDateTime deletedAt,
        @JsonProperty("name") String name,
        @JsonProperty("owner_id") UUID ownerId,
        @JsonProperty("workspace_id") UUID workspaceId,
        @JsonProperty("description") String description,
        @JsonProperty("max_nb_events") Integer maxNbEvents
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private UUID id;
        private OffsetDateTime createdAt;
        private OffsetDateTime updatedAt;
        private OffsetDateTime deletedAt;
        private String name;
        private UUID ownerId;
        private UUID workspaceId;
        private String description;
        private Integer maxNbEvents;

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

        public Builder name(String name) {
            this.name = name;
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

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder maxNbEvents(Integer maxNbEvents) {
            this.maxNbEvents = maxNbEvents;
            return this;
        }

        public CampaignOut build() {
            return new CampaignOut(id, createdAt, updatedAt, deletedAt, name, ownerId, workspaceId, description, maxNbEvents);
        }
    }
}
