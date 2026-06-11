package fr.slickteam.mistralai.client.model.workflow;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * List of workflow executions.
 * <p>
 * Container for paginated workflow execution results.
 * Used in `/v1/workflows/executions` operations.
 */
public record ListWorkflowExecutionsOut(
        @JsonProperty("executions") List<WorkflowExecutionWithoutResultOut> executions,
        @JsonProperty("next_page_token") String nextPageToken
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<WorkflowExecutionWithoutResultOut> executions;
        private String nextPageToken;

        public Builder executions(List<WorkflowExecutionWithoutResultOut> executions) {
            this.executions = executions;
            return this;
        }

        public Builder nextPageToken(String nextPageToken) {
            this.nextPageToken = nextPageToken;
            return this;
        }

        public ListWorkflowExecutionsOut build() {
            return new ListWorkflowExecutionsOut(executions, nextPageToken);
        }
    }
}
