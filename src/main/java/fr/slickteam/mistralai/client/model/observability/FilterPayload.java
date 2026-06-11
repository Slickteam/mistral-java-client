package fr.slickteam.mistralai.client.model.observability;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * Filter payload for observability search requests.
 * <p>
 * Defines a filter condition with field, operator, and value.
 * Used in chat completion events search requests.
 */
public record FilterPayload(
        @JsonProperty("field") String field,
        @JsonProperty("operator") String operator,
        @JsonProperty("value") Object value
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String field;
        private String operator;
        private Object value;

        public Builder field(String field) {
            this.field = field;
            return this;
        }

        public Builder operator(String operator) {
            this.operator = operator;
            return this;
        }

        public Builder value(Object value) {
            this.value = value;
            return this;
        }

        public FilterPayload build() {
            return new FilterPayload(field, operator, value);
        }
    }
}
