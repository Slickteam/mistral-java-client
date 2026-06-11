package fr.slickteam.mistralai.client.model.observability;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * Search request for chat completion events.
 * <p>
 * Contains filter criteria for searching chat completion events in observability API.
 * Used in `POST /v1/observability/chat-completion-events/search`.
 */
public record ChatCompletionEventsSearchRequest(
        @JsonProperty("filters") List<FilterPayload> filters,
        @JsonProperty("extra_fields") List<String> extraFields
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<FilterPayload> filters;
        private List<String> extraFields;

        public Builder filters(List<FilterPayload> filters) {
            this.filters = filters;
            return this;
        }

        public Builder extraFields(List<String> extraFields) {
            this.extraFields = extraFields;
            return this;
        }

        public ChatCompletionEventsSearchRequest build() {
            return new ChatCompletionEventsSearchRequest(filters, extraFields);
        }
    }
}
