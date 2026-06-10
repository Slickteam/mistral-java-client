package fr.slickteam.mistralai.client.model.conversation;

import java.util.List;

/**
 * History of a conversation with all entries.
 */
public record ConversationHistory(
    String object,
    String conversationId,
    List<Object> entries
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String object = "conversation.history";
        private String conversationId;
        private List<Object> entries;

        public Builder object(String object) {
            this.object = object;
            return this;
        }

        public Builder conversationId(String conversationId) {
            this.conversationId = conversationId;
            return this;
        }

        public Builder entries(List<Object> entries) {
            this.entries = entries;
            return this;
        }

        public ConversationHistory build() {
            return new ConversationHistory(object, conversationId, entries);
        }
    }
}
