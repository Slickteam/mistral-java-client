package fr.slickteam.mistralai.client.model.workflow;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.Map;

/**
 * Workflow execution information.
 * <p>
 * Represents a workflow execution with status, timing, and result information.
 * Used in `/v1/workflows/executions/{execution_id}` operations.
 */
public record WorkflowExecutionOut(
        @JsonProperty("workflow_name") String workflowName,
        @JsonProperty("execution_id") String executionId,
        @JsonProperty("parent_execution_id") String parentExecutionId,
        @JsonProperty("root_execution_id") String rootExecutionId,
        @JsonProperty("status") String status,
        @JsonProperty("start_time") OffsetDateTime startTime,
        @JsonProperty("end_time") OffsetDateTime endTime,
        @JsonProperty("total_duration_ms") Long totalDurationMs,
        @JsonProperty("result") Map<String, Object> result
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String workflowName;
        private String executionId;
        private String parentExecutionId;
        private String rootExecutionId;
        private String status;
        private OffsetDateTime startTime;
        private OffsetDateTime endTime;
        private Long totalDurationMs;
        private Map<String, Object> result;

        public Builder workflowName(String workflowName) {
            this.workflowName = workflowName;
            return this;
        }

        public Builder executionId(String executionId) {
            this.executionId = executionId;
            return this;
        }

        public Builder parentExecutionId(String parentExecutionId) {
            this.parentExecutionId = parentExecutionId;
            return this;
        }

        public Builder rootExecutionId(String rootExecutionId) {
            this.rootExecutionId = rootExecutionId;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder startTime(OffsetDateTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder endTime(OffsetDateTime endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder totalDurationMs(Long totalDurationMs) {
            this.totalDurationMs = totalDurationMs;
            return this;
        }

        public Builder result(Map<String, Object> result) {
            this.result = result;
            return this;
        }

        public WorkflowExecutionOut build() {
            return new WorkflowExecutionOut(workflowName, executionId, parentExecutionId, rootExecutionId, status, startTime, endTime, totalDurationMs, result);
        }
    }
}
