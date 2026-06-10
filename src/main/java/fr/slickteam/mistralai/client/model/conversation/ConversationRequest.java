package fr.slickteam.mistralai.client.model.conversation;

import java.util.List;
import java.util.Map;

/**
 * Request to create a new conversation.
 */
public record ConversationRequest(
    Object inputs,
    Boolean stream,
    Boolean store,
    String handoffExecution,
    String instructions,
    List<Object> tools,
    CompletionArgs completionArgs,
    List<Object> guardrails,
    String name,
    String description,
    Map<String, Object> metadata,
    String agentId,
    Object agentVersion,
    String model
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Object inputs;
        private Boolean stream = false;
        private Boolean store;
        private String handoffExecution;
        private String instructions;
        private List<Object> tools;
        private CompletionArgs completionArgs;
        private List<Object> guardrails;
        private String name;
        private String description;
        private Map<String, Object> metadata;
        private String agentId;
        private Object agentVersion;
        private String model;

        public Builder inputs(Object inputs) {
            this.inputs = inputs;
            return this;
        }

        public Builder stream(Boolean stream) {
            this.stream = stream;
            return this;
        }

        public Builder store(Boolean store) {
            this.store = store;
            return this;
        }

        public Builder handoffExecution(String handoffExecution) {
            this.handoffExecution = handoffExecution;
            return this;
        }

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

        public Builder guardrails(List<Object> guardrails) {
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

        public Builder agentId(String agentId) {
            this.agentId = agentId;
            return this;
        }

        public Builder agentVersion(Object agentVersion) {
            this.agentVersion = agentVersion;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public ConversationRequest build() {
            return new ConversationRequest(
                inputs, stream, store, handoffExecution, instructions, tools,
                completionArgs, guardrails, name, description, metadata, agentId, agentVersion, model
            );
        }
    }
}
