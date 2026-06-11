package fr.slickteam.mistralai.client.models;

import java.util.List;

/**
 * Represents a request to the OCR (Optical Character Recognition) endpoint of the Mistral AI API.
 * This class contains all parameters needed to extract text from images.
 */
public record OcrRequest(
    /**
     * The model to use for OCR.
     */
    String model,

    /**
     * The list of file identifiers to perform OCR on.
     * These should be files that have been previously uploaded to the API.
     */
    List<String> files,

    /**
     * The format in which the OCR response should be returned.
     * Possible values include "text", "json", etc.
     */
    String response_format,

    /**
     * Whether to use safe mode or not.
     * Safe mode provides additional safety guardrails.
     */
    Boolean safe_mode
) {
    /**
     * Returns a new Builder instance to create an OcrRequest.
     *
     * @return a new Builder instance
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder class for creating OcrRequest instances.
     */
    public static class Builder {
        private String model;
        private List<String> files;
        private String response_format;
        private Boolean safe_mode;

        /**
         * Sets the model to use for OCR.
         *
         * @param model the model identifier
         * @return this builder instance
         */
        public Builder model(String model) {
            this.model = model;
            return this;
        }

        /**
         * Sets the list of file identifiers to perform OCR on.
         *
         * @param files the list of file identifiers
         * @return this builder instance
         */
        public Builder files(List<String> files) {
            this.files = files;
            return this;
        }

        /**
         * Sets the format in which the OCR response should be returned.
         *
         * @param response_format the response format (e.g., "text", "json")
         * @return this builder instance
         */
        public Builder response_format(String response_format) {
            this.response_format = response_format;
            return this;
        }

        /**
         * Sets whether to use safe mode or not.
         *
         * @param safe_mode true to enable safe mode, false otherwise
         * @return this builder instance
         */
        public Builder safe_mode(Boolean safe_mode) {
            this.safe_mode = safe_mode;
            return this;
        }

        /**
         * Builds a new OcrRequest instance with the current builder values.
         *
         * @return a new OcrRequest instance
         */
        public OcrRequest build() {
            return new OcrRequest(model, files, response_format, safe_mode);
        }
    }
}
