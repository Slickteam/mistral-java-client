package fr.slickteam.mistralai.client.model.workflow;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Scalar metric value.
 * <p>
 * Represents a single numeric metric with value and unit.
 * Used in workflow metrics responses.
 */
public record ScalarMetric(
        @JsonProperty("value") Double value,
        @JsonProperty("unit") String unit
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Double value;
        private String unit;

        public Builder value(Double value) {
            this.value = value;
            return this;
        }

        public Builder unit(String unit) {
            this.unit = unit;
            return this;
        }

        public ScalarMetric build() {
            return new ScalarMetric(value, unit);
        }
    }
}
