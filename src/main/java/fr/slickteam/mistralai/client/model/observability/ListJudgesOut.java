package fr.slickteam.mistralai.client.model.observability;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * List of judges from observability API.
 * <p>
 * Container for paginated judge results.
 * Used in `/v1/observability/judges` response.
 */
public record ListJudgesOut(
        @JsonProperty("judges") List<JudgeOut> judges
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<JudgeOut> judges;

        public Builder judges(List<JudgeOut> judges) {
            this.judges = judges;
            return this;
        }

        public ListJudgesOut build() {
            return new ListJudgesOut(judges);
        }
    }
}
