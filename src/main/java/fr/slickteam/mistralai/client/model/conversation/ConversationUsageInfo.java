package fr.slickteam.mistralai.client.model.conversation;

/**
 * Usage information for a conversation.
 */
public record ConversationUsageInfo(
    Integer promptTokens,
    Integer completionTokens,
    Integer totalTokens
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer promptTokens;
        private Integer completionTokens;
        private Integer totalTokens;

        public Builder promptTokens(Integer promptTokens) {
            this.promptTokens = promptTokens;
            return this;
        }

        public Builder completionTokens(Integer completionTokens) {
            this.completionTokens = completionTokens;
            return this;
        }

        public Builder totalTokens(Integer totalTokens) {
            this.totalTokens = totalTokens;
            return this;
        }

        public ConversationUsageInfo build() {
            return new ConversationUsageInfo(promptTokens, completionTokens, totalTokens);
        }
    }
}
