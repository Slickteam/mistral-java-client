package fr.slickteam.mistralai.client.model.conversation;

import fr.slickteam.mistralai.client.model.Prediction;
import fr.slickteam.mistralai.client.model.ResponseFormat;

/**
 * Arguments for completion in a conversation.
 */
public record CompletionArgs(
    Object stop,
    Double presencePenalty,
    Double frequencyPenalty,
    Double temperature,
    Double topP,
    Integer maxTokens,
    Integer randomSeed,
    Prediction prediction,
    ResponseFormat responseFormat,
    String toolChoice
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Object stop;
        private Double presencePenalty;
        private Double frequencyPenalty;
        private Double temperature;
        private Double topP;
        private Integer maxTokens;
        private Integer randomSeed;
        private Prediction prediction;
        private ResponseFormat responseFormat;
        private String toolChoice;

        public Builder stop(Object stop) {
            this.stop = stop;
            return this;
        }

        public Builder presencePenalty(Double presencePenalty) {
            this.presencePenalty = presencePenalty;
            return this;
        }

        public Builder frequencyPenalty(Double frequencyPenalty) {
            this.frequencyPenalty = frequencyPenalty;
            return this;
        }

        public Builder temperature(Double temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder topP(Double topP) {
            this.topP = topP;
            return this;
        }

        public Builder maxTokens(Integer maxTokens) {
            this.maxTokens = maxTokens;
            return this;
        }

        public Builder randomSeed(Integer randomSeed) {
            this.randomSeed = randomSeed;
            return this;
        }

        public Builder prediction(Prediction prediction) {
            this.prediction = prediction;
            return this;
        }

        public Builder responseFormat(ResponseFormat responseFormat) {
            this.responseFormat = responseFormat;
            return this;
        }

        public Builder toolChoice(String toolChoice) {
            this.toolChoice = toolChoice;
            return this;
        }

        public CompletionArgs build() {
            return new CompletionArgs(stop, presencePenalty, frequencyPenalty, temperature, topP, maxTokens, randomSeed, prediction, responseFormat, toolChoice);
        }
    }
}
