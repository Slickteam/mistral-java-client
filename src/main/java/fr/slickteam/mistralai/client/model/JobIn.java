package fr.slickteam.mistralai.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record JobIn(
    String model,
    List<TrainingFile> training_files,
    List<UUID> validation_files,
    String suffix,
    List<WandbIntegration> integrations,
    Boolean auto_start,
    Double invalid_sample_skip_percentage,
    Object hyperparameters
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String model;
        private List<TrainingFile> training_files;
        private List<UUID> validation_files;
        private String suffix;
        private List<WandbIntegration> integrations;
        private Boolean auto_start;
        private Double invalid_sample_skip_percentage;
        private Object hyperparameters;

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder training_files(List<TrainingFile> training_files) {
            this.training_files = training_files;
            return this;
        }

        public Builder validation_files(List<UUID> validation_files) {
            this.validation_files = validation_files;
            return this;
        }

        public Builder suffix(String suffix) {
            this.suffix = suffix;
            return this;
        }

        public Builder integrations(List<WandbIntegration> integrations) {
            this.integrations = integrations;
            return this;
        }

        public Builder auto_start(Boolean auto_start) {
            this.auto_start = auto_start;
            return this;
        }

        public Builder invalid_sample_skip_percentage(Double invalid_sample_skip_percentage) {
            this.invalid_sample_skip_percentage = invalid_sample_skip_percentage;
            return this;
        }

        public Builder hyperparameters(Object hyperparameters) {
            this.hyperparameters = hyperparameters;
            return this;
        }

        public JobIn build() {
            return new JobIn(model, training_files, validation_files, suffix, 
                integrations, auto_start, invalid_sample_skip_percentage, hyperparameters);
        }
    }
}
