package fr.slickteam.mistralai.client.model.ocr;

import fr.slickteam.mistralai.client.model.Usage;
import java.util.List;

/**
 * Represents a response from the OCR (Optical Character Recognition) endpoint of the Mistral AI API.
 * This class contains the extracted text from images and metadata about the request.
 */
public record OcrResponse(
    /**
     * The unique identifier for the OCR operation.
     */
    String id,

    /**
     * The object type, typically "ocr.result".
     */
    String object,

    /**
     * The Unix timestamp (in seconds) of when the OCR operation was created.
     */
    Long created,

    /**
     * The model used for the OCR operation.
     */
    String model,

    /**
     * The list of extracted text strings, one for each file processed.
     */
    List<String> text,

    /**
     * Usage statistics for the request.
     */
    Usage usage
) {
    /**
     * Returns a new Builder instance to create an OcrResponse.
     *
     * @return a new Builder instance
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder class for creating OcrResponse instances.
     */
    public static class Builder {
        private String id;
        private String object;
        private Long created;
        private String model;
        private List<String> text;
        private Usage usage;

        /**
         * Sets the unique identifier for the OCR operation.
         *
         * @param id the operation identifier
         * @return this builder instance
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the object type.
         *
         * @param object the object type (typically "ocr.result")
         * @return this builder instance
         */
        public Builder object(String object) {
            this.object = object;
            return this;
        }

        /**
         * Sets the creation timestamp.
         *
         * @param created the Unix timestamp when the OCR operation was created
         * @return this builder instance
         */
        public Builder created(Long created) {
            this.created = created;
            return this;
        }

        /**
         * Sets the model used for the OCR operation.
         *
         * @param model the model identifier
         * @return this builder instance
         */
        public Builder model(String model) {
            this.model = model;
            return this;
        }

        /**
         * Sets the list of extracted text strings.
         *
         * @param text the list of extracted text
         * @return this builder instance
         */
        public Builder text(List<String> text) {
            this.text = text;
            return this;
        }

        /**
         * Sets the usage statistics.
         *
         * @param usage the usage statistics
         * @return this builder instance
         */
        public Builder usage(Usage usage) {
            this.usage = usage;
            return this;
        }

        /**
         * Builds a new OcrResponse instance with the current builder values.
         *
         * @return a new OcrResponse instance
         */
        public OcrResponse build() {
            return new OcrResponse(id, object, created, model, text, usage);
        }
    }
}
