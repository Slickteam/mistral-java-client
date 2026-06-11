package fr.slickteam.mistralai.client.model.workflow;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

/**
 * Workflow execution information without result.
 * <p>
 * Represents a workflow execution with status and timing but no result data.
 * Used in workflow operations.
 */
public record WorkflowExecutionWithoutResultOut(
        @JsonProperty("workflow_name") String workflowName,
        @JsonProperty("execution_id") String executionId,
        @JsonProperty("parent_execution_id") String parentExecutionId,
        @JsonProperty("root_execution_id") String rootExecutionId,
        @JsonProperty("status") String status,
        @JsonProperty("start_time") OffsetDateTime startTime,
        @JsonProperty("end_time") OffsetDateTime endTime,
        @JsonProperty("total_duration_ms") Long totalDurationMs
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

        public WorkflowExecutionWithoutResultOut build() {
            return new WorkflowExecutionWithoutResultOut(workflowName, executionId, parentExecutionId, rootExecutionId, status, startTime, endTime, totalDurationMs);
        }
    }
}
