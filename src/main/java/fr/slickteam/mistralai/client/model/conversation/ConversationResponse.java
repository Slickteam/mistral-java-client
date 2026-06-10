package fr.slickteam.mistralai.client.model.conversation;

import java.util.List;

/**
 * Response from a conversation operation.
 */
public record ConversationResponse(
    String object,
    String conversationId,
    List<Object> outputs,
    ConversationUsageInfo usage,
    List<Object> guardrails
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String object = "conversation.response";
        private String conversationId;
        private List<Object> outputs;
        private ConversationUsageInfo usage;
        private List<Object> guardrails;

        public Builder object(String object) {
            this.object = object;
            return this;
        }

        public Builder conversationId(String conversationId) {
            this.conversationId = conversationId;
            return this;
        }

        public Builder outputs(List<Object> outputs) {
            this.outputs = outputs;
            return this;
        }

        public Builder usage(ConversationUsageInfo usage) {
            this.usage = usage;
            return this;
        }

        public Builder guardrails(List<Object> guardrails) {
            this.guardrails = guardrails;
            return this;
        }

        public ConversationResponse build() {
            return new ConversationResponse(object, conversationId, outputs, usage, guardrails);
        }
    }
}
