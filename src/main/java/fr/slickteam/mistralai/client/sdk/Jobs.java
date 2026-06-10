package fr.slickteam.mistralai.client.sdk;

import fr.slickteam.mistralai.client.lib.Config;
import fr.slickteam.mistralai.client.model.Hyperparameters;
import fr.slickteam.mistralai.client.model.JobRequest;
import fr.slickteam.mistralai.client.model.JobResponse;
import fr.slickteam.mistralai.client.model.JobResult;
import fr.slickteam.mistralai.client.model.JobsResponse;
import fr.slickteam.mistralai.client.utils.JSONUtils;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import static fr.slickteam.mistralai.client.utils.ContentTypes.APPLICATION_JSON;

/**
 * API resource for interacting with fine-tuning jobs.
 */
public class Jobs extends ApiResource {
    /**
     * Creates a new jobs API resource with the specified options.
     *
     * @param options The SDK options
     */
    public Jobs(Config.SDKOptions options) {
        super(options);
    }

    /**
     * Get Fine Tuning Jobs
     *
     * @param limit  Optional limit on the number of jobs to return
     * @param offset Optional offset for pagination
     * @return A list of fine-tuning jobs
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public JobsResponse list(Integer limit, Integer offset) throws IOException, InterruptedException {
        StringBuilder path = new StringBuilder("/v1/fine_tuning/jobs");
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
            return parseJobsResponse(response.body());
        } else {
            throw new IOException("Failed to list fine-tuning jobs: " + response.statusCode());
        }
    }

    /**
     * Create Fine Tuning Job
     *
     * @param request The fine-tuning job creation request
     * @return The created fine-tuning job
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public JobResponse create(JobRequest request) throws IOException, InterruptedException {
        // Convert request to JSON
        String requestBody = createJobRequestJson(request);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(createURI("/v1/fine_tuning/jobs"))
                .header("Content-Type", APPLICATION_JSON)
                .header("Accept", APPLICATION_JSON)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = sendRequest(httpRequest);

        if (response.statusCode() == 200) {
            return parseJobResponse(response.body());
        } else {
            throw new IOException("Failed to create fine-tuning job: " + response.statusCode());
        }
    }

    /**
     * Get Fine Tuning Job
     *
     * @param jobId The UUID of the fine-tuning job
     * @return The fine-tuning job details
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public JobResponse get(String jobId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(createURI("/v1/fine_tuning/jobs/" + jobId))
                .header("Accept", APPLICATION_JSON)
                .GET()
                .build();

        HttpResponse<String> response = sendRequest(request);

        if (response.statusCode() == 200) {
            return parseJobResponse(response.body());
        } else {
            throw new IOException("Failed to get fine-tuning job: " + response.statusCode());
        }
    }

    /**
     * Cancel Fine Tuning Job
     *
     * @param jobId The UUID of the fine-tuning job to cancel
     * @return The updated fine-tuning job
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public JobResponse cancel(String jobId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(createURI("/v1/fine_tuning/jobs/" + jobId + "/cancel"))
                .header("Accept", APPLICATION_JSON)
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = sendRequest(request);

        if (response.statusCode() == 200) {
            return parseJobResponse(response.body());
        } else {
            throw new IOException("Failed to cancel fine-tuning job: " + response.statusCode());
        }
    }

    /**
     * Start Fine Tuning Job
     *
     * @param jobId The UUID of the fine-tuning job to start
     * @return The updated fine-tuning job
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public JobResponse start(String jobId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(createURI("/v1/fine_tuning/jobs/" + jobId + "/start"))
                .header("Accept", APPLICATION_JSON)
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = sendRequest(request);

        if (response.statusCode() == 200) {
            return parseJobResponse(response.body());
        } else {
            throw new IOException("Failed to start fine-tuning job: " + response.statusCode());
        }
    }

    // Helper methods
    private String createJobRequestJson(JobRequest request) {
        StringBuilder json = new StringBuilder();
        json.append("{");

        // Add required fields
        json.append("\"model\":\"").append(request.model).append("\"");
        json.append(",\"training_file\":\"").append(request.trainingFile).append("\"");

        // Add optional fields
        if (request.validationFile != null && !request.validationFile.isEmpty()) {
            json.append(",\"validation_file\":\"").append(request.validationFile).append("\"");
        }

        if (request.hyperparameters != null) {
            json.append(",\"hyperparameters\":{");
            boolean first = true;

            if (request.hyperparameters.nEpochs != null) {
                json.append("\"n_epochs\":").append(request.hyperparameters.nEpochs);
                first = false;
            }

            if (request.hyperparameters.batchSize != null) {
                if (!first) json.append(",");
                json.append("\"batch_size\":").append(request.hyperparameters.batchSize);
                first = false;
            }

            if (request.hyperparameters.learningRateMultiplier != null) {
                if (!first) json.append(",");
                json.append("\"learning_rate_multiplier\":").append(request.hyperparameters.learningRateMultiplier);
            }

            json.append("}");
        }

        if (request.suffix != null && !request.suffix.isEmpty()) {
            json.append(",\"suffix\":\"").append(request.suffix).append("\"");
        }

        json.append("}");
        return json.toString();
    }

    private JobsResponse parseJobsResponse(String json) {
        JobsResponse response = new JobsResponse();

        // Parse the list of jobs
        List<JobResponse> jobs = new ArrayList<>();
        // This is a very simplified parsing approach - use a proper JSON library in production
        String[] jobEntries = json.split("\\{\"id\":");
        for (int i = 1; i < jobEntries.length; i++) {
            String jobJson = "{\"id\":" + jobEntries[i];
            int endIndex = jobJson.lastIndexOf("}");
            if (endIndex > 0) {
                jobJson = jobJson.substring(0, endIndex + 1);
                jobs.add(parseJobResponse(jobJson));
            }
        }

        response.data = jobs;
        response.object = JSONUtils.extractValue(json, "object");

        return response;
    }

    private JobResponse parseJobResponse(String json) {
        JobResponse job = new JobResponse();
        job.id = JSONUtils.extractValue(json, "id");
        job.object = JSONUtils.extractValue(json, "object");
        job.model = JSONUtils.extractValue(json, "model");
        job.createdAt = Long.parseLong(JSONUtils.extractValue(json, "created_at"));
        job.finishedAt = JSONUtils.extractValue(json, "finished_at").isEmpty() ? null : Long.parseLong(JSONUtils.extractValue(json, "finished_at"));
        job.status = JSONUtils.extractValue(json, "status");
        job.trainingFile = JSONUtils.extractValue(json, "training_file");
        job.validationFile = JSONUtils.extractValue(json, "validation_file");

        // Parse hyperparameters
        String hyperparametersJson = JSONUtils.extractObject(json, "hyperparameters");
        if (hyperparametersJson != null && !hyperparametersJson.isEmpty()) {
            Hyperparameters hyperparameters = new Hyperparameters();
            hyperparameters.nEpochs = Integer.parseInt(JSONUtils.extractValue(hyperparametersJson, "n_epochs"));
            hyperparameters.batchSize = Integer.parseInt(JSONUtils.extractValue(hyperparametersJson, "batch_size"));
            hyperparameters.learningRateMultiplier = Double.parseDouble(JSONUtils.extractValue(hyperparametersJson, "learning_rate_multiplier"));
            job.hyperparameters = hyperparameters;
        }

        // Parse result metrics if present
        String resultJson = JSONUtils.extractObject(json, "result");
        if (resultJson != null && !resultJson.isEmpty()) {
            JobResult result = new JobResult();
            result.trainLoss = Double.parseDouble(JSONUtils.extractValue(resultJson, "train_loss"));
            result.trainAccuracy = Double.parseDouble(JSONUtils.extractValue(resultJson, "train_accuracy"));
            result.validationLoss = Double.parseDouble(JSONUtils.extractValue(resultJson, "validation_loss"));
            result.validationAccuracy = Double.parseDouble(JSONUtils.extractValue(resultJson, "validation_accuracy"));
            job.result = result;
        }

        return job;
    }


}
