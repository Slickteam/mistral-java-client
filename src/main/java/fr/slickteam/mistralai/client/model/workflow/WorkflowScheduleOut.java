package fr.slickteam.mistralai.client.model.workflow;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Workflow schedule information.
 * <p>
 * Represents a scheduled workflow with timing, status, and configuration.
 * Used in `/v1/workflows/schedules` operations.
 */
public record WorkflowScheduleOut(
        @JsonProperty("schedule_id") String scheduleId,
        @JsonProperty("workflow_registration_id") UUID workflowRegistrationId,
        @JsonProperty("workflow_name") String workflowName,
        @JsonProperty("created_at") OffsetDateTime createdAt,
        @JsonProperty("updated_at") OffsetDateTime updatedAt,
        @JsonProperty("input") Map<String, Object> input,
        @JsonProperty("calendars") List<Map<String, Object>> calendars,
        @JsonProperty("intervals") List<Map<String, Object>> intervals,
        @JsonProperty("cron_expressions") List<String> cronExpressions,
        @JsonProperty("start_at") OffsetDateTime startAt,
        @JsonProperty("end_at") OffsetDateTime endAt,
        @JsonProperty("time_zone_name") String timeZoneName,
        @JsonProperty("policy") Map<String, Object> policy
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String scheduleId;
        private UUID workflowRegistrationId;
        private String workflowName;
        private OffsetDateTime createdAt;
        private OffsetDateTime updatedAt;
        private Map<String, Object> input;
        private List<Map<String, Object>> calendars;
        private List<Map<String, Object>> intervals;
        private List<String> cronExpressions;
        private OffsetDateTime startAt;
        private OffsetDateTime endAt;
        private String timeZoneName;
        private Map<String, Object> policy;

        public Builder scheduleId(String scheduleId) {
            this.scheduleId = scheduleId;
            return this;
        }

        public Builder workflowRegistrationId(UUID workflowRegistrationId) {
            this.workflowRegistrationId = workflowRegistrationId;
            return this;
        }

        public Builder workflowName(String workflowName) {
            this.workflowName = workflowName;
            return this;
        }

        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(OffsetDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder input(Map<String, Object> input) {
            this.input = input;
            return this;
        }

        public Builder calendars(List<Map<String, Object>> calendars) {
            this.calendars = calendars;
            return this;
        }

        public Builder intervals(List<Map<String, Object>> intervals) {
            this.intervals = intervals;
            return this;
        }

        public Builder cronExpressions(List<String> cronExpressions) {
            this.cronExpressions = cronExpressions;
            return this;
        }

        public Builder startAt(OffsetDateTime startAt) {
            this.startAt = startAt;
            return this;
        }

        public Builder endAt(OffsetDateTime endAt) {
            this.endAt = endAt;
            return this;
        }

        public Builder timeZoneName(String timeZoneName) {
            this.timeZoneName = timeZoneName;
            return this;
        }

        public Builder policy(Map<String, Object> policy) {
            this.policy = policy;
            return this;
        }

        public WorkflowScheduleOut build() {
            return new WorkflowScheduleOut(scheduleId, workflowRegistrationId, workflowName, createdAt, updatedAt, input, calendars, intervals, cronExpressions, startAt, endAt, timeZoneName, policy);
        }
    }
}
