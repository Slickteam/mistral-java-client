package fr.slickteam.mistralai.client.model.workflow;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * List of workflow runs.
 * <p>
 * Container for paginated workflow run results.
 * Used in `/v1/workflows/runs` operations.
 */
public record ListWorkflowRunsOut(
        @JsonProperty("runs") List<WorkflowRunOut> runs,
        @JsonProperty("next_page_token") String nextPageToken
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<WorkflowRunOut> runs;
        private String nextPageToken;

        public Builder runs(List<WorkflowRunOut> runs) {
            this.runs = runs;
            return this;
        }

        public Builder nextPageToken(String nextPageToken) {
            this.nextPageToken = nextPageToken;
            return this;
        }

        public ListWorkflowRunsOut build() {
            return new ListWorkflowRunsOut(runs, nextPageToken);
        }
    }
}
