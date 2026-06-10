package fr.slickteam.mistralai.client.model.conversation;

import fr.slickteam.mistralai.client.model.GuardrailConfig;
import fr.slickteam.mistralai.client.model.conversation.CompletionArgs;
import java.util.List;
import java.util.Map;

/**
 * A conversation using a model.
 */
public record ModelConversation(
    String instructions,
    List<Object> tools,
    CompletionArgs completionArgs,
    List<GuardrailConfig> guardrails,
    String name,
    String description,
    Map<String, Object> metadata,
    String object,
    String id,
    String createdAt,
    String updatedAt,
    String model
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String instructions;
        private List<Object> tools;
        private CompletionArgs completionArgs;
        private List<GuardrailConfig> guardrails;
        private String name;
        private String description;
        private Map<String, Object> metadata;
        private String object = "conversation";
        private String id;
        private String createdAt;
        private String updatedAt;
        private String model;

        public Builder instructions(String instructions) {
            this.instructions = instructions;
            return this;
        }

        public Builder tools(List<Object> tools) {
            this.tools = tools;
            return this;
        }

        public Builder completionArgs(CompletionArgs completionArgs) {
            this.completionArgs = completionArgs;
            return this;
        }

        public Builder guardrails(List<GuardrailConfig> guardrails) {
            this.guardrails = guardrails;
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

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public ModelConversation build() {
            return new ModelConversation(
                instructions, tools, completionArgs, guardrails, name, description,
                metadata, object, id, createdAt, updatedAt, model
            );
        }
    }
}
