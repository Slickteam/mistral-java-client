package fr.slickteam.mistralai.client.model.observability;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Container for chat completion events search results.
 * <p>
 * Contains the list of events matching the search criteria and pagination information.
 * Used in `POST /v1/observability/chat-completion-events/search` response.
 */
public record ChatCompletionEvents(
        @JsonProperty("completion_events") FeedResultChatCompletionEventPreview completionEvents
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private FeedResultChatCompletionEventPreview completionEvents;

        public Builder completionEvents(FeedResultChatCompletionEventPreview completionEvents) {
            this.completionEvents = completionEvents;
            return this;
        }

        public ChatCompletionEvents build() {
            return new ChatCompletionEvents(completionEvents);
        }
    }
}
