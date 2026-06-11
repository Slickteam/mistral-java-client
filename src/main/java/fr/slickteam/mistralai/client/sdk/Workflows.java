package fr.slickteam.mistralai.client.sdk;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.slickteam.mistralai.client.lib.Config;
import fr.slickteam.mistralai.client.model.workflow.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.OffsetDateTime;

import static fr.slickteam.mistralai.client.utils.ContentTypes.APPLICATION_JSON;

/**
 * # Workflows API
 * 
 * API resource for managing workflow executions, runs, schedules, and metrics.
 * 
 * ## Endpoints
 * - `GET /v1/workflows/executions/{execution_id}` - [Get workflow execution](#getWorkflowExecution)
 * - `GET /v1/workflows/executions` - [List workflow executions](#getWorkflowExecutions)
 * - `GET /v1/workflows/{workflow_name}/metrics` - [Get workflow metrics](#getWorkflowMetrics)
 * - `GET /v1/workflows/runs` - [List workflow runs](#getWorkflowRuns)
 * - `GET /v1/workflows/schedules` - [List workflow schedules](#getWorkflowSchedules)
 */
public class Workflows extends ApiResource {

    public Workflows(Config.SDKOptions options) {
        super(options);
    }

    /**
     * Get a specific workflow execution.
     * <p>
     * `GET /v1/workflows/executions/{execution_id}`
     *
     * @param executionId The ID of the execution to retrieve
     * @return The workflow execution details
     * @throws IOException If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public WorkflowExecutionOut getWorkflowExecution(String executionId) throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        URI uri = createURI("/v1/workflows/executions/" + executionId);
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", APPLICATION_JSON)
                .GET()
                .build();

        HttpResponse<String> response = sendRequest(httpRequest);

        if (response.statusCode() == 200) {
            return objectMapper.readValue(response.body(), WorkflowExecutionOut.class);
        } else {
            throw new IOException("Failed to get workflow execution: " + response.statusCode());
        }
    }

    /**
     * List all workflow executions.
     * <p>
     * `GET /v1/workflows/executions`
     *
     * @return List of all workflow executions
     * @throws IOException If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public ListWorkflowExecutionsOut getWorkflowExecutions() throws IOException, InterruptedException {
        return getWorkflowExecutions(null, null, null, null, null);
    }

    /**
     * List workflow executions with filters.
     * <p>
     * `GET /v1/workflows/executions`
     *
     * @param workflowIdentifier Filter by workflow identifier
     * @param search Search query
     * @param status Filter by status
     * @param pageSize Number of items per page
     * @param nextPageToken Token for pagination
     * @return List of workflow executions matching the criteria
     * @throws IOException If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public ListWorkflowExecutionsOut getWorkflowExecutions(String workflowIdentifier, String search, String status, Integer pageSize, String nextPageToken) throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        String url = "/v1/workflows/executions";
        if (workflowIdentifier != null && !workflowIdentifier.isEmpty()) {
            url += "?workflow_identifier=" + workflowIdentifier;
        }
        if (search != null && !search.isEmpty()) {
            url += (url.contains("?") ? "&" : "?") + "search=" + search;
        }
        if (status != null && !status.isEmpty()) {
            url += (url.contains("?") ? "&" : "?") + "status=" + status;
        }
        if (pageSize != null) {
            url += (url.contains("?") ? "&" : "?") + "page_size=" + pageSize;
        }
        if (nextPageToken != null && !nextPageToken.isEmpty()) {
            url += (url.contains("?") ? "&" : "?") + "next_page_token=" + nextPageToken;
        }

        URI uri = createURI(url);
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", APPLICATION_JSON)
                .GET()
                .build();

        HttpResponse<String> response = sendRequest(httpRequest);

        if (response.statusCode() == 200) {
            return objectMapper.readValue(response.body(), ListWorkflowExecutionsOut.class);
        } else {
            throw new IOException("Failed to get workflow executions: " + response.statusCode());
        }
    }

    /**
     * Get workflow metrics.
     * <p>
     * `GET /v1/workflows/{workflow_name}/metrics`
     *
     * @param workflowName The name of the workflow
     * @param startTime Start time for metrics
     * @param endTime End time for metrics
     * @return Workflow metrics
     * @throws IOException If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public WorkflowMetricsOut getWorkflowMetrics(String workflowName, OffsetDateTime startTime, OffsetDateTime endTime) throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        String url = "/v1/workflows/" + workflowName + "/metrics";
        if (startTime != null) {
            url += "?start_time=" + startTime.toString();
        }
        if (endTime != null) {
            url += (url.contains("?") ? "&" : "?") + "end_time=" + endTime.toString();
        }

        URI uri = createURI(url);
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", APPLICATION_JSON)
                .GET()
                .build();

        HttpResponse<String> response = sendRequest(httpRequest);

        if (response.statusCode() == 200) {
            return objectMapper.readValue(response.body(), WorkflowMetricsOut.class);
        } else {
            throw new IOException("Failed to get workflow metrics: " + response.statusCode());
        }
    }

    /**
     * List all workflow runs.
     * <p>
     * `GET /v1/workflows/runs`
     *
     * @return List of all workflow runs
     * @throws IOException If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public ListWorkflowRunsOut getWorkflowRuns() throws IOException, InterruptedException {
        return getWorkflowRuns(null, null, null, null, null);
    }

    /**
     * List workflow runs with filters.
     * <p>
     * `GET /v1/workflows/runs`
     *
     * @param workflowIdentifier Filter by workflow identifier
     * @param search Search query
     * @param status Filter by status
     * @param pageSize Number of items per page
     * @param nextPageToken Token for pagination
     * @return List of workflow runs matching the criteria
     * @throws IOException If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public ListWorkflowRunsOut getWorkflowRuns(String workflowIdentifier, String search, String status, Integer pageSize, String nextPageToken) throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        String url = "/v1/workflows/runs";
        if (workflowIdentifier != null && !workflowIdentifier.isEmpty()) {
            url += "?workflow_identifier=" + workflowIdentifier;
        }
        if (search != null && !search.isEmpty()) {
            url += (url.contains("?") ? "&" : "?") + "search=" + search;
        }
        if (status != null && !status.isEmpty()) {
            url += (url.contains("?") ? "&" : "?") + "status=" + status;
        }
        if (pageSize != null) {
            url += (url.contains("?") ? "&" : "?") + "page_size=" + pageSize;
        }
        if (nextPageToken != null && !nextPageToken.isEmpty()) {
            url += (url.contains("?") ? "&" : "?") + "next_page_token=" + nextPageToken;
        }

        URI uri = createURI(url);
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", APPLICATION_JSON)
                .GET()
                .build();

        HttpResponse<String> response = sendRequest(httpRequest);

        if (response.statusCode() == 200) {
            return objectMapper.readValue(response.body(), ListWorkflowRunsOut.class);
        } else {
            throw new IOException("Failed to get workflow runs: " + response.statusCode());
        }
    }

    /**
     * List all workflow schedules.
     * <p>
     * `GET /v1/workflows/schedules`
     *
     * @return List of all workflow schedules
     * @throws IOException If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public ListWorkflowSchedulesOut getWorkflowSchedules() throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        URI uri = createURI("/v1/workflows/schedules");
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", APPLICATION_JSON)
                .GET()
                .build();

        HttpResponse<String> response = sendRequest(httpRequest);

        if (response.statusCode() == 200) {
            return objectMapper.readValue(response.body(), ListWorkflowSchedulesOut.class);
        } else {
            throw new IOException("Failed to get workflow schedules: " + response.statusCode());
        }
    }
}
