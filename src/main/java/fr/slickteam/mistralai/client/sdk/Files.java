package fr.slickteam.mistralai.client.sdk;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import fr.slickteam.mistralai.client.lib.Config;
import fr.slickteam.mistralai.client.model.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

import static fr.slickteam.mistralai.client.utils.ContentTypes.APPLICATION_JSON;
import static fr.slickteam.mistralai.client.utils.ContentTypes.OCTET_STREAM;

/**
 * API resource for interacting with files.
 */
public class Files extends ApiResource {
    private final ObjectMapper objectMapper;

    /**
     * Creates a new files API resource with the specified options.
     *
     * @param options The SDK options
     */
    public Files(Config.SDKOptions options) {
        super(options);
        this.objectMapper = new ObjectMapper();
        this.objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    /**
     * Upload File
     * <p>
     * The size of individual files can be a maximum of 512 MB. The Fine-tuning API only supports .jsonl files.
     *
     * @param file    The file to upload
     * @param purpose The purpose of the file
     * @return The uploaded file information
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public UploadFileResponse upload(Path file, String purpose) throws IOException, InterruptedException {
        String boundary = "----WebKitFormBoundary" + System.currentTimeMillis();
        String contentType = "multipart/form-data; boundary=" + boundary;

        byte[] fileContent = java.nio.file.Files.readAllBytes(file);
        String fileName = file.getFileName().toString();

        // Create multipart form data
        String formData = "--" + boundary + "\r\n" +
                "Content-Disposition: form-data; name=\"file\"; filename=\"" + fileName + "\"\r\n" +
                "Content-Type: application/octet-stream\r\n\r\n";

        String endFormData = "\r\n--" + boundary + "\r\n" +
                "Content-Disposition: form-data; name=\"purpose\"\r\n\r\n" +
                purpose + "\r\n--" + boundary + "--\r\n";

        byte[] formDataBytes = formData.getBytes();
        byte[] endFormDataBytes = endFormData.getBytes();

        byte[] requestBody = new byte[formDataBytes.length + fileContent.length + endFormDataBytes.length];
        System.arraycopy(formDataBytes, 0, requestBody, 0, formDataBytes.length);
        System.arraycopy(fileContent, 0, requestBody, formDataBytes.length, fileContent.length);
        System.arraycopy(endFormDataBytes, 0, requestBody, formDataBytes.length + fileContent.length, endFormDataBytes.length);

        // Create request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(createURI("/v1/files"))
                .header("Content-Type", contentType)
                .header("Accept", APPLICATION_JSON)
                .POST(HttpRequest.BodyPublishers.ofByteArray(requestBody))
                .build();

        // Send request
        HttpResponse<String> response = sendRequest(request);

        // Parse response
        if (response.statusCode() == 200) {
            return parseUploadFileResponse(response.body());
        } else {
            throw new IOException("Failed to upload file: " + response.statusCode());
        }
    }

    /**
     * List Files
     * Returns a list of files that belong to the user's organization.
     *
     * @param purpose Optional filter by purpose
     * @return A list of files
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public ListFilesResponse list(String purpose) throws IOException, InterruptedException {
        String path = "/v1/files";
        if (purpose != null && !purpose.isEmpty()) {
            path += "?purpose=" + purpose;
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(createURI(path))
                .header("Accept", APPLICATION_JSON)
                .GET()
                .build();

        HttpResponse<String> response = sendRequest(request);

        if (response.statusCode() == 200) {
            return parseListFilesResponse(response.body());
        } else {
            throw new IOException("Failed to list files: " + response.statusCode());
        }
    }

    /**
     * Retrieve File
     * Returns information about a specific file.
     *
     * @param fileId The ID of the file to retrieve
     * @return Information about the file
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public FileObject retrieve(String fileId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(createURI("/v1/files/" + fileId))
                .header("Accept", APPLICATION_JSON)
                .GET()
                .build();

        HttpResponse<String> response = sendRequest(request);

        if (response.statusCode() == 200) {
            return parseFileObject(response.body());
        } else {
            throw new IOException("Failed to retrieve file: " + response.statusCode());
        }
    }

    /**
     * Delete File
     *
     * @param fileId The ID of the file to delete
     * @return The deletion status
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public DeleteFileResponse delete(String fileId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(createURI("/v1/files/" + fileId))
                .header("Accept", APPLICATION_JSON)
                .DELETE()
                .build();

        HttpResponse<String> response = sendRequest(request);

        if (response.statusCode() == 200) {
            return parseDeleteFileResponse(response.body());
        } else {
            throw new IOException("Failed to delete file: " + response.statusCode());
        }
    }

    /**
     * Download File
     *
     * @param fileId The ID of the file to download
     * @return The file content as an input stream
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public InputStream download(String fileId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(createURI("/v1/files/" + fileId + "/content"))
                .header("Accept", OCTET_STREAM)
                .GET()
                .build();

        HttpResponse<InputStream> response = sendRequestGetResponseAsInputStream(request);

        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new IOException("Failed to download file: " + response.statusCode());
        }
    }

    /**
     * Get Signed Url
     *
     * @param fileId The ID of the file to get a signed URL for
     * @return The signed URL
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    public FileSignedURLResponse getSignedUrl(String fileId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(createURI("/v1/files/" + fileId + "/url"))
                .header("Accept", APPLICATION_JSON)
                .GET()
                .build();

        HttpResponse<String> response = sendRequest(request);

        if (response.statusCode() == 200) {
            return parseFileSignedURLResponse(response.body());
        } else {
            throw new IOException("Failed to get signed URL: " + response.statusCode());
        }
    }

    // Helper methods for parsing responses
    private UploadFileResponse parseUploadFileResponse(String json) {
        try {
            return objectMapper.readValue(json, UploadFileResponse.class);
        } catch (UnrecognizedPropertyException e) {
            throw new RuntimeException("Failed to parse upload file response: " + json, e);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse upload file response", e);
        }
    }

    private ListFilesResponse parseListFilesResponse(String json) {
        try {
            return objectMapper.readValue(json, ListFilesResponse.class);
        } catch (UnrecognizedPropertyException e) {
            throw new RuntimeException("Failed to parse list files response: " + json, e);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse list files response", e);
        }
    }

    private FileObject parseFileObject(String json) {
        try {
            return objectMapper.readValue(json, FileObject.class);
        } catch (UnrecognizedPropertyException e) {
            throw new RuntimeException("Failed to parse file object: " + json, e);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse file object", e);
        }
    }

    private DeleteFileResponse parseDeleteFileResponse(String json) {
        try {
            return objectMapper.readValue(json, DeleteFileResponse.class);
        } catch (UnrecognizedPropertyException e) {
            throw new RuntimeException("Failed to parse delete file response: " + json, e);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse delete file response", e);
        }
    }

    private FileSignedURLResponse parseFileSignedURLResponse(String json) {
        try {
            return objectMapper.readValue(json, FileSignedURLResponse.class);
        } catch (UnrecognizedPropertyException e) {
            throw new RuntimeException("Failed to parse file signed URL response: " + json, e);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse file signed URL response", e);
        }
    }

}
