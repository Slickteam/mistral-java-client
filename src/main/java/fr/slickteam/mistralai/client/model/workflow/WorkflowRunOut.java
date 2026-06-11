package fr.slickteam.mistralai.client.model.workflow;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.UUID;

/**
 * Workflow run information.
 * <p>
 * Represents a workflow run with status, timing, and execution details.
 * Used in `/v1/workflows/runs` operations.
 */
public record WorkflowRunOut(
        @JsonProperty("workflow_registration_id") UUID workflowRegistrationId,
        @JsonProperty("run_id") UUID runId,
        @JsonProperty("workflow_name") String workflowName,
        @JsonProperty("status") String status,
        @JsonProperty("start_time") OffsetDateTime startTime,
        @JsonProperty("end_time") OffsetDateTime endTime
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private UUID workflowRegistrationId;
        private UUID runId;
        private String workflowName;
        private String status;
        private OffsetDateTime startTime;
        private OffsetDateTime endTime;

        public Builder workflowRegistrationId(UUID workflowRegistrationId) {
            this.workflowRegistrationId = workflowRegistrationId;
            return this;
        }

        public Builder runId(UUID runId) {
            this.runId = runId;
            return this;
        }

        public Builder workflowName(String workflowName) {
            this.workflowName = workflowName;
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

        public WorkflowRunOut build() {
            return new WorkflowRunOut(workflowRegistrationId, runId, workflowName, status, startTime, endTime);
        }
    }
}
