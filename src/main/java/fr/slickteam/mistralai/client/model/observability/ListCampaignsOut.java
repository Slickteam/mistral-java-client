package fr.slickteam.mistralai.client.model.observability;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * List of campaigns from observability API.
 * <p>
 * Container for paginated campaign results.
 * Used in `/v1/observability/campaigns` response.
 */
public record ListCampaignsOut(
        @JsonProperty("campaigns") List<CampaignOut> campaigns
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<CampaignOut> campaigns;

        public Builder campaigns(List<CampaignOut> campaigns) {
            this.campaigns = campaigns;
            return this;
        }

        public ListCampaignsOut build() {
            return new ListCampaignsOut(campaigns);
        }
    }
}
