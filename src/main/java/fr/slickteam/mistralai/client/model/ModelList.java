package fr.slickteam.mistralai.client.model;

import java.util.List;

/**
 * List of models available in the Mistral AI API.
 * <p>
 * Returned by `GET /v1/models` endpoint.
 */
public record ModelList(
    /**
     * The list of model cards containing information about each available model.
     */
    List<BaseModelCard> data) {
    /**
     * Returns a new Builder instance to create a ModelList.
     *
     * @return a new Builder instance
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder class for creating ModelList instances.
     */
    public static class Builder {
        private List<BaseModelCard> data;

        /**
         * Sets the list of model cards.
         *
         * @param data the list of model cards
         * @return this builder instance
         */
        public Builder data(List<BaseModelCard> data) {
            this.data = data;
            return this;
        }

        /**
         * Builds a new ModelList instance with the current builder values.
         *
         * @return a new ModelList instance
         */
        public ModelList build() {
            return new ModelList(data);
        }
    }
}
