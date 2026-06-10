package fr.slickteam.mistralai.client.model.conversation;

import java.util.Map;

/**
 * A conversation using an agent.
 */
public record AgentConversation(
    String name,
    String description,
    Map<String, Object> metadata,
    String object,
    String id,
    String createdAt,
    String updatedAt,
    String agentId,
    Object agentVersion
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String description;
        private Map<String, Object> metadata;
        private String object = "conversation";
        private String id;
        private String createdAt;
        private String updatedAt;
        private String agentId;
        private Object agentVersion;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder metadata(Map<String, Object> metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder object(String object) {
            this.object = object;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder agentId(String agentId) {
            this.agentId = agentId;
            return this;
        }

        public Builder agentVersion(Object agentVersion) {
            this.agentVersion = agentVersion;
            return this;
        }

        public AgentConversation build() {
            return new AgentConversation(
                name, description, metadata, object, id, createdAt, updatedAt, agentId, agentVersion
            );
        }
    }
}
