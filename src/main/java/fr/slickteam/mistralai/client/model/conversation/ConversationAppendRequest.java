package fr.slickteam.mistralai.client.model.conversation;

import java.util.List;

/**
 * Request to append entries to an existing conversation.
 */
public record ConversationAppendRequest(
    Object inputs,
    Boolean stream,
    Boolean store,
    String handoffExecution,
    CompletionArgs completionArgs,
    List<Object> toolConfirmations
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Object inputs;
        private Boolean stream = false;
        private Boolean store = true;
        private String handoffExecution = "server";
        private CompletionArgs completionArgs;
        private List<Object> toolConfirmations;

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

        public Builder completionArgs(CompletionArgs completionArgs) {
            this.completionArgs = completionArgs;
            return this;
        }

        public Builder toolConfirmations(List<Object> toolConfirmations) {
            this.toolConfirmations = toolConfirmations;
            return this;
        }

        public ConversationAppendRequest build() {
            return new ConversationAppendRequest(inputs, stream, store, handoffExecution, completionArgs, toolConfirmations);
        }
    }
}
