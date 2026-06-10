package fr.slickteam.mistralai.client.sdk;

import fr.slickteam.mistralai.client.lib.Config;
import fr.slickteam.mistralai.client.model.BatchJobRequest;
import fr.slickteam.mistralai.client.model.BatchJobResponse;
import fr.slickteam.mistralai.client.model.BatchJobsResponse;
import fr.slickteam.mistralai.client.utils.JSONUtils;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import static fr.slickteam.mistralai.client.utils.ContentTypes.APPLICATION_JSON;
import static fr.slickteam.mistralai.client.utils.JSONUtils.escapeJsonString;

/**
 * API resource for interacting with batch jobs.
 */
public class MistralJobs extends ApiResource {
    /**
     * Creates a new batch jobs API resource with the specified options.
     *
     * @param options The SDK options
     */
    public MistralJobs(Config.SDKOptions options) {
        super(options);
    }

    /**
     * Get Batch Jobs
     *
     * @param limit  Optional limit on the number of jobs to return
     * @param offset Optional offset for pagination
     * @return A list of batch jobs
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public BatchJobsResponse list(Integer limit, Integer offset) throws IOException, InterruptedException {
        StringBuilder path = new StringBuilder("/v1/batch/jobs");
        boolean hasQueryParam = false;

        if (limit != null) {
            path.append(hasQueryParam ? "&" : "?").append("limit=").append(limit);
            hasQueryParam = true;
        }

        if (offset != null) {
            path.append(hasQueryParam ? "&" : "?").append("offset=").append(offset);
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(createURI(path.toString()))
                .header("Accept", APPLICATION_JSON)
                .GET()
                .build();

        HttpResponse<String> response = sendRequest(request);

        if (response.statusCode() == 200) {
            return parseBatchJobsResponse(response.body());
        } else {
            throw new IOException("Failed to list batch jobs: " + response.statusCode());
        }
    }

    /**
     * Create Batch Job
     *
     * @param request The batch job creation request
     * @return The created batch job
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public BatchJobResponse create(BatchJobRequest request) throws IOException, InterruptedException {
        // Convert request to JSON
        String requestBody = createBatchJobRequestJson(request);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(createURI("/v1/batch/jobs"))
                .header("Content-Type", APPLICATION_JSON)
                .header("Accept", APPLICATION_JSON)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = sendRequest(httpRequest);

        if (response.statusCode() == 200) {
            return parseBatchJobResponse(response.body());
        } else {
            throw new IOException("Failed to create batch job: " + response.statusCode());
        }
    }

    /**
     * Get Batch Job
     *
     * @param jobId The UUID of the batch job
     * @return The batch job details
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public BatchJobResponse get(String jobId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(createURI("/v1/batch/jobs/" + jobId))
                .header("Accept", APPLICATION_JSON)
                .GET()
                .build();

        HttpResponse<String> response = sendRequest(request);

        if (response.statusCode() == 200) {
            return parseBatchJobResponse(response.body());
        } else {
            throw new IOException("Failed to get batch job: " + response.statusCode());
        }
    }

    /**
     * Cancel Batch Job
     *
     * @param jobId The UUID of the batch job to cancel
     * @return The updated batch job
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public BatchJobResponse cancel(String jobId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(createURI("/v1/batch/jobs/" + jobId + "/cancel"))
                .header("Accept", APPLICATION_JSON)
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = sendRequest(request);

        if (response.statusCode() == 200) {
            return parseBatchJobResponse(response.body());
        } else {
            throw new IOException("Failed to cancel batch job: " + response.statusCode());
        }
    }

    // Helper methods
    private String createBatchJobRequestJson(BatchJobRequest request) {
        StringBuilder json = new StringBuilder();
        json.append("{");

        // Add required fields
        json.append("\"model\":\"").append(request.model).append("\"");

        // Add inputs
        if (request.inputs != null && !request.inputs.isEmpty()) {
            json.append(",\"inputs\":[");
            for (int i = 0; i < request.inputs.size(); i++) {
                String input = request.inputs.get(i);
                json.append("\"").append(escapeJsonString(input)).append("\"");
                if (i < request.inputs.size() - 1) {
                    json.append(",");
                }
            }
            json.append("]");
        }

        // Add optional parameters
        if (request.temperature != null) {
            json.append(",\"temperature\":").append(request.temperature);
        }

        if (request.maxTokens != null) {
            json.append(",\"max_tokens\":").append(request.maxTokens);
        }

        if (request.topP != null) {
            json.append(",\"top_p\":").append(request.topP);
        }

        if (request.safePrompt != null) {
            json.append(",\"safe_prompt\":").append(request.safePrompt);
        }

        if (request.randomSeed != null) {
            json.append(",\"random_seed\":").append(request.randomSeed);
        }

        json.append("}");
        return json.toString();
    }

    private BatchJobsResponse parseBatchJobsResponse(String json) {
        BatchJobsResponse response = new BatchJobsResponse();

        // Parse the list of batch jobs
        List<BatchJobResponse> jobs = new ArrayList<>();
        // This is a very simplified parsing approach - use a proper JSON library in production
        String[] jobEntries = json.split("\\{\"id\":");
        for (int i = 1; i < jobEntries.length; i++) {
            String jobJson = "{\"id\":" + jobEntries[i];
            int endIndex = jobJson.lastIndexOf("}");
            if (endIndex > 0) {
                jobJson = jobJson.substring(0, endIndex + 1);
                jobs.add(parseBatchJobResponse(jobJson));
            }
        }

        response.jobs = jobs;
        response.total = jobs.size();

        return response;
    }

    private BatchJobResponse parseBatchJobResponse(String json) {
        BatchJobResponse job = new BatchJobResponse();
        job.id = JSONUtils.extractValue(json, "id");
        job.status = JSONUtils.extractValue(json, "status");
        job.createdAt = JSONUtils.extractValue(json, "created_at");
        job.model = JSONUtils.extractValue(json, "model");

        // Parse other fields as needed

        return job;
    }


}
