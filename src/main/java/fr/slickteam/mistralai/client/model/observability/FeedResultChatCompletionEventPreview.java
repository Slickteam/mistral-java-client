package fr.slickteam.mistralai.client.model.observability;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Paginated result of chat completion event previews.
 * <p>
 * Contains preview data for chat completion events with pagination.
 * Used in `/v1/observability/chat-completion-events/search` response.
 */
public record FeedResultChatCompletionEventPreview(
        @JsonProperty("results") List<ChatCompletionEventPreview> results,
        @JsonProperty("count") Integer count,
        @JsonProperty("next") String next,
        @JsonProperty("previous") String previous
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<ChatCompletionEventPreview> results;
        private Integer count;
        private String next;
        private String previous;

        public Builder results(List<ChatCompletionEventPreview> results) {
            this.results = results;
            return this;
        }

        public Builder count(Integer count) {
            this.count = count;
            return this;
        }

        public Builder next(String next) {
            this.next = next;
            return this;
        }

        public Builder previous(String previous) {
            this.previous = previous;
            return this;
        }

        public FeedResultChatCompletionEventPreview build() {
            return new FeedResultChatCompletionEventPreview(results, count, next, previous);
        }
    }
}
