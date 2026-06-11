package fr.slickteam.mistralai.client.model.workflow;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Workflow metrics information.
 * <p>
 * Contains execution count, success/error rates, latency metrics, and retry information.
 * Used in `/v1/workflows/{workflow_name}/metrics` operations.
 */
public record WorkflowMetricsOut(
        @JsonProperty("execution_count") ScalarMetric executionCount,
        @JsonProperty("success_count") ScalarMetric successCount,
        @JsonProperty("error_count") ScalarMetric errorCount,
        @JsonProperty("average_latency_ms") ScalarMetric averageLatencyMs,
        @JsonProperty("latency_over_time") TimeSeriesMetric latencyOverTime,
        @JsonProperty("retry_rate") ScalarMetric retryRate
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ScalarMetric executionCount;
        private ScalarMetric successCount;
        private ScalarMetric errorCount;
        private ScalarMetric averageLatencyMs;
        private TimeSeriesMetric latencyOverTime;
        private ScalarMetric retryRate;

        public Builder executionCount(ScalarMetric executionCount) {
            this.executionCount = executionCount;
            return this;
        }

        public Builder successCount(ScalarMetric successCount) {
            this.successCount = successCount;
            return this;
        }

        public Builder errorCount(ScalarMetric errorCount) {
            this.errorCount = errorCount;
            return this;
        }

        public Builder averageLatencyMs(ScalarMetric averageLatencyMs) {
            this.averageLatencyMs = averageLatencyMs;
            return this;
        }

        public Builder latencyOverTime(TimeSeriesMetric latencyOverTime) {
            this.latencyOverTime = latencyOverTime;
            return this;
        }

        public Builder retryRate(ScalarMetric retryRate) {
            this.retryRate = retryRate;
            return this;
        }

        public WorkflowMetricsOut build() {
            return new WorkflowMetricsOut(executionCount, successCount, errorCount, averageLatencyMs, latencyOverTime, retryRate);
        }
    }
}
