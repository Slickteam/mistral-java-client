package fr.slickteam.mistralai.client.model;

/**
 * Batch job input.
 * <p>
 * Used in Mistral AI API operations.
 */


import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BatchJobIn(
    String endpoint,
    List<UUID> input_files,
    String model,
    Map<String, String> metadata,
    Integer timeout_hours
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String endpoint;
        private List<UUID> input_files;
        private String model;
        private Map<String, String> metadata;
        private Integer timeout_hours;

        public Builder endpoint(String endpoint) {
            this.endpoint = endpoint;
            return this;
        }

        public Builder input_files(List<UUID> input_files) {
            this.input_files = input_files;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder metadata(Map<String, String> metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder timeout_hours(Integer timeout_hours) {
            this.timeout_hours = timeout_hours;
            return this;
        }

        public BatchJobIn build() {
            return new BatchJobIn(endpoint, input_files, model, metadata, timeout_hours);
        }
    }
}
