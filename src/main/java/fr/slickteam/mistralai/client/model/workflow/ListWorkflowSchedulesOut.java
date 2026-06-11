package fr.slickteam.mistralai.client.model.workflow;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * List of workflow schedules.
 * <p>
 * Container for workflow schedule results.
 * Used in `/v1/workflows/schedules` operations.
 */
public record ListWorkflowSchedulesOut(
        @JsonProperty("schedules") List<WorkflowScheduleOut> schedules
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<WorkflowScheduleOut> schedules;

        public Builder schedules(List<WorkflowScheduleOut> schedules) {
            this.schedules = schedules;
            return this;
        }

        public ListWorkflowSchedulesOut build() {
            return new ListWorkflowSchedulesOut(schedules);
        }
    }
}
