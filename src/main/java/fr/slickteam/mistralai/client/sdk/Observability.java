package fr.slickteam.mistralai.client.sdk;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.slickteam.mistralai.client.lib.Config;
import fr.slickteam.mistralai.client.model.observability.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.UUID;

import static fr.slickteam.mistralai.client.utils.ContentTypes.APPLICATION_JSON;

/**
 * # Observability API
 * 
 * API resource for accessing observability data including chat completion events, judges, campaigns, and datasets.
 * 
 * ## Endpoints
 * - `POST /v1/observability/chat-completion-events/search` - [Search chat completion events](#searchChatCompletionEvents)
 * - `GET /v1/observability/chat-completion-events/{event_id}` - [Get chat completion event](#getChatCompletionEvent)
 * - `GET /v1/observability/judges` - [List judges](#getJudges)
 * - `GET /v1/observability/campaigns` - [List campaigns](#getCampaigns)
 * - `GET /v1/observability/datasets` - [List datasets](#getDatasets)
 */
public class Observability extends ApiResource {

    private static final System.Logger log = System.getLogger(Observability.class.getName());

    public Observability(Config.SDKOptions options) {
        super(options);
    }

    /**
     * Search chat completion events.
     * <p>
     * `POST /v1/observability/chat-completion-events/search`
     *
     * @param request The search request
     * @return Chat completion events matching the search criteria
     * @throws IOException If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public ChatCompletionEvents searchChatCompletionEvents(ChatCompletionEventsSearchRequest request) throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        String requestBody = objectMapper.writeValueAsString(request);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(createURI("/v1/observability/chat-completion-events/search"))
                .header("Content-Type", APPLICATION_JSON)
                .header("Accept", APPLICATION_JSON)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = sendRequest(httpRequest);

        if (response.statusCode() == 200) {
            return objectMapper.readValue(response.body(), ChatCompletionEvents.class);
        } else {
            throw new IOException("Failed to search chat completion events: " + response.statusCode());
        }
    }

    /**
     * Get a specific chat completion event.
     * <p>
     * `GET /v1/observability/chat-completion-events/{event_id}`
     *
     * @param eventId The ID of the event to retrieve
     * @return The chat completion event
     * @throws IOException If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public ChatCompletionEventOut getChatCompletionEvent(String eventId) throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        URI uri = createURI("/v1/observability/chat-completion-events/" + eventId);
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", APPLICATION_JSON)
                .GET()
                .build();

        HttpResponse<String> response = sendRequest(httpRequest);

        if (response.statusCode() == 200) {
            return objectMapper.readValue(response.body(), ChatCompletionEventOut.class);
        } else {
            throw new IOException("Failed to get chat completion event: " + response.statusCode());
        }
    }

    /**
     * List all judges.
     * <p>
     * `GET /v1/observability/judges`
     *
     * @return List of all judges
     * @throws IOException If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public ListJudgesOut getJudges() throws IOException, InterruptedException {
        return getJudges(null, null, null, null);
    }

    /**
     * List judges with filters.
     * <p>
     * `GET /v1/observability/judges`
     *
     * @param typeFilter Filter by judge type
     * @param modelFilter Filter by model
     * @param pageSize Number of items per page
     * @param page Page number
     * @return List of judges matching the filters
     * @throws IOException If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public ListJudgesOut getJudges(List<String> typeFilter, List<String> modelFilter, Integer pageSize, Integer page) throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        String url = "/v1/observability/judges";
        if (typeFilter != null && !typeFilter.isEmpty()) {
            url += "?type_filter=" + String.join(",", typeFilter);
        }
        if (modelFilter != null && !modelFilter.isEmpty()) {
            url += (url.contains("?") ? "&" : "?") + "model_filter=" + String.join(",", modelFilter);
        }
        if (pageSize != null) {
            url += (url.contains("?") ? "&" : "?") + "page_size=" + pageSize;
        }
        if (page != null) {
            url += (url.contains("?") ? "&" : "?") + "page=" + page;
        }

        URI uri = createURI(url);
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", APPLICATION_JSON)
                .GET()
                .build();

        HttpResponse<String> response = sendRequest(httpRequest);

        if (response.statusCode() == 200) {
            return objectMapper.readValue(response.body(), ListJudgesOut.class);
        } else {
            throw new IOException("Failed to get judges: " + response.statusCode());
        }
    }

    /**
     * List all campaigns.
     * <p>
     * `GET /v1/observability/campaigns`
     *
     * @return List of all campaigns
     * @throws IOException If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public ListCampaignsOut getCampaigns() throws IOException, InterruptedException {
        return getCampaigns(null, null, null);
    }

    /**
     * List campaigns with pagination and search.
     * <p>
     * `GET /v1/observability/campaigns`
     *
     * @param pageSize Number of items per page
     * @param page Page number
     * @param q Search query
     * @return List of campaigns matching the criteria
     * @throws IOException If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public ListCampaignsOut getCampaigns(Integer pageSize, Integer page, String q) throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        String url = "/v1/observability/campaigns";
        if (pageSize != null) {
            url += "?page_size=" + pageSize;
        }
        if (page != null) {
            url += (url.contains("?") ? "&" : "?") + "page=" + page;
        }
        if (q != null && !q.isEmpty()) {
            url += (url.contains("?") ? "&" : "?") + "q=" + q;
        }

        URI uri = createURI(url);
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", APPLICATION_JSON)
                .GET()
                .build();

        HttpResponse<String> response = sendRequest(httpRequest);

        if (response.statusCode() == 200) {
            return objectMapper.readValue(response.body(), ListCampaignsOut.class);
        } else {
            throw new IOException("Failed to get campaigns: " + response.statusCode());
        }
    }

    /**
     * List all datasets.
     * <p>
     * `GET /v1/observability/datasets`
     *
     * @return List of all datasets
     * @throws IOException If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public ListDatasetsOut getDatasets() throws IOException, InterruptedException {
        return getDatasets(null, null, null);
    }

    /**
     * List datasets with pagination and search.
     * <p>
     * `GET /v1/observability/datasets`
     *
     * @param pageSize Number of items per page
     * @param page Page number
     * @param q Search query
     * @return List of datasets matching the criteria
     * @throws IOException If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public ListDatasetsOut getDatasets(Integer pageSize, Integer page, String q) throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        String url = "/v1/observability/datasets";
        if (pageSize != null) {
            url += "?page_size=" + pageSize;
        }
        if (page != null) {
            url += (url.contains("?") ? "&" : "?") + "page=" + page;
        }
        if (q != null && !q.isEmpty()) {
            url += (url.contains("?") ? "&" : "?") + "q=" + q;
        }

        URI uri = createURI(url);
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", APPLICATION_JSON)
                .GET()
                .build();

        HttpResponse<String> response = sendRequest(httpRequest);

        if (response.statusCode() == 200) {
            return objectMapper.readValue(response.body(), ListDatasetsOut.class);
        } else {
            throw new IOException("Failed to get datasets: " + response.statusCode());
        }
    }
}
