package fr.slickteam.mistralai.client.model.observability;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * List of datasets from observability API.
 * <p>
 * Container for paginated dataset results.
 * Used in `/v1/observability/datasets` response.
 */
public record ListDatasetsOut(
        @JsonProperty("datasets") List<DatasetOut> datasets
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<DatasetOut> datasets;

        public Builder datasets(List<DatasetOut> datasets) {
            this.datasets = datasets;
            return this;
        }

        public ListDatasetsOut build() {
            return new ListDatasetsOut(datasets);
        }
    }
}
