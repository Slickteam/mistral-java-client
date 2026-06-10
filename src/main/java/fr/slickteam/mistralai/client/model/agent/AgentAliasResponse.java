package fr.slickteam.mistralai.client.model.agent;

/**
 * Response for agent alias operations.
 */
public record AgentAliasResponse(
    String alias,
    Integer version,
    String createdAt,
    String updatedAt
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String alias;
        private Integer version;
        private String createdAt;
        private String updatedAt;

        public Builder alias(String alias) {
            this.alias = alias;
            return this;
        }

        public Builder version(Integer version) {
            this.version = version;
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

        public AgentAliasResponse build() {
            return new AgentAliasResponse(alias, version, createdAt, updatedAt);
        }
    }
}
