package fr.slickteam.mistralai.client.model.workflow;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Time series metric data.
 * <p>
 * Represents metric values over time with timestamps and values.
 * Used in workflow metrics responses.
 */
public record TimeSeriesMetric(
        @JsonProperty("timestamps") List<String> timestamps,
        @JsonProperty("values") List<Double> values
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<String> timestamps;
        private List<Double> values;

        public Builder timestamps(List<String> timestamps) {
            this.timestamps = timestamps;
            return this;
        }

        public Builder values(List<Double> values) {
            this.values = values;
            return this;
        }

        public TimeSeriesMetric build() {
            return new TimeSeriesMetric(timestamps, values);
        }
    }
}
