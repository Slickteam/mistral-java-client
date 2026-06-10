package fr.slickteam.mistralai.client.model.conversation;

/**
 * Messages from a conversation.
 */
public record ConversationMessages(
    String object,
    String conversationId,
    Object messages
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String object = "conversation.messages";
        private String conversationId;
        private Object messages;

        public Builder object(String object) {
            this.object = object;
            return this;
        }

        public Builder conversationId(String conversationId) {
            this.conversationId = conversationId;
            return this;
        }

        public Builder messages(Object messages) {
            this.messages = messages;
            return this;
        }

        public ConversationMessages build() {
            return new ConversationMessages(object, conversationId, messages);
        }
    }
}
