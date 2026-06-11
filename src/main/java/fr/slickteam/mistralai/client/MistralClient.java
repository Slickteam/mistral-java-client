package fr.slickteam.mistralai.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.slickteam.mistralai.client.model.*;
import fr.slickteam.mistralai.client.model.agent.AgentAliasResponse;
import fr.slickteam.mistralai.client.model.conversation.*;
import fr.slickteam.mistralai.client.model.library.*;
import fr.slickteam.mistralai.client.model.ocr.OcrResponse;
import fr.slickteam.mistralai.client.models.OcrRequest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Client for interacting with the Mistral AI API.
 * This client provides methods for accessing various endpoints of the Mistral AI API,
 * including chat completions, embeddings, OCR, models, files, and fine-tuning.
 */
public class MistralClient {
    /**
     * The HTTP client used for making API requests.
     */
    private final HttpClient httpClient;

    /**
     * The object mapper used for JSON serialization/deserialization.
     */
    private final ObjectMapper objectMapper;

    /**
     * The API key used for authentication with the Mistral AI API.
     */
    private final String apiKey;

    /**
     * The base URL of the Mistral AI API.
     */
    private final String baseUrl;

    /**
     * Creates a new MistralClient with the specified API key and the default base URL.
     *
     * @param apiKey the API key for authentication
     */
    public MistralClient(String apiKey) {
        this(apiKey, "https://api.mistral.ai");
    }

    /**
     * Creates a new MistralClient with the specified API key and base URL.
     *
     * @param apiKey  the API key for authentication
     * @param baseUrl the base URL of the Mistral AI API
     */
    public MistralClient(String apiKey, String baseUrl) {
        this.apiKey = apiKey;
        this.baseUrl = baseUrl;
        this.httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(30))
                .build();
        this.objectMapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    // Chat API

    /**
     * Sends a chat completion request to the Mistral AI API with the specified model and messages.
     * This is a convenience method that creates a ChatRequest with the provided parameters.
     *
     * @param model    the model to use for the chat completion
     * @param messages the list of messages in the conversation
     * @return the chat completion response from the API
     */
    public ChatResponse chat(String model, List<ChatMessage> messages) {
        return chat(ChatRequest.builder()
                .model(model)
                .messages(messages)
                .build());
    }

    /**
     * Sends a chat completion request to the Mistral AI API.
     * This method allows for more control over the request parameters through the ChatRequest object.
     *
     * @param request the chat completion request
     * @return the chat completion response from the API
     */
    public ChatResponse chat(ChatRequest request) {
        return sendPostRequest("/v1/chat/completions", request, ChatResponse.class);
    }

    // Embeddings API

    /**
     * Generates embeddings for the specified input texts using the specified model.
     * This is a convenience method that creates an EmbeddingRequest with the provided parameters.
     *
     * @param model the model to use for generating embeddings
     * @param input the list of input texts to generate embeddings for
     * @return the embedding response from the API
     */
    public EmbeddingResponse embeddings(String model, List<String> input) {
        return embeddings(EmbeddingRequest.builder()
                .model(model)
                .input(input)
                .build());
    }

    /**
     * Generates embeddings using the Mistral AI API.
     * This method allows for more control over the request parameters through the EmbeddingRequest object.
     *
     * @param request the embedding request
     * @return the embedding response from the API
     */
    public EmbeddingResponse embeddings(EmbeddingRequest request) {
        return sendPostRequest("/v1/embeddings", request, EmbeddingResponse.class);
    }

    // OCR API

    /**
     * Performs optical character recognition (OCR) on the specified files using the specified model.
     * This is a convenience method that creates an OcrRequest with the provided parameters.
     *
     * @param model the model to use for OCR
     * @param files the list of files to perform OCR on
     * @return the OCR response from the API
     */
    public OcrResponse ocr(String model, List<String> files) {
        return ocr(OcrRequest.builder()
                .model(model)
                .files(files)
                .build());
    }

    /**
     * Performs optical character recognition (OCR) using the Mistral AI API.
     * This method allows for more control over the request parameters through the OcrRequest object.
     *
     * @param request the OCR request
     * @return the OCR response from the API
     */
    public OcrResponse ocr(OcrRequest request) {
        return sendPostRequest("/v1/ocr", request, OcrResponse.class);
    }

    // FIM API

    /**
     * Sends a FIM completion request to the Mistral AI API.
     *
     * @param request the FIM completion request
     * @return the FIM completion response from the API
     */
    public ChatResponse fim(FIMCompletionRequest request) {
        return sendPostRequest("/v1/fim/completions", request, ChatResponse.class);
    }

    // Agents API

    /**
     * Sends an agents completion request to the Mistral AI API.
     *
     * @param request the agents completion request
     * @return the agents completion response from the API
     */
    public ChatResponse agentsChat(AgentsCompletionRequest request) {
        return sendPostRequest("/v1/agents/completions", request, ChatResponse.class);
    }

    // Conversations API

    /**
     * Creates a new conversation.
     *
     * @param request the conversation creation request
     * @return the conversation response
     */
    public ConversationResponse createConversation(ConversationRequest request) {
        return sendPostRequest("/v1/conversations", request, ConversationResponse.class);
    }

    /**
     * Lists all conversations.
     *
     * @param page     the page number (default: 0)
     * @param pageSize the number of items per page (default: 100)
     * @param metadata optional metadata filter
     * @return a list of conversations (ModelConversation or AgentConversation)
     */
    public List<Object> listConversations(Integer page, Integer pageSize, Map<String, Object> metadata) {
        StringBuilder url = new StringBuilder("/v1/conversations");
        boolean hasParams = false;
        if (page != null) {
            url.append("?page=").append(page);
            hasParams = true;
        }
        if (pageSize != null) {
            url.append(hasParams ? "&" : "?").append("page_size=").append(pageSize);
            hasParams = true;
        }
        if (metadata != null && !metadata.isEmpty()) {
            // Note: metadata is passed as JSON in query param, but for simplicity we'll skip complex serialization
            // In a real implementation, this would need proper JSON encoding
        }
        return sendGetRequest(url.toString(), List.class);
    }

    /**
     * Retrieves a specific conversation.
     *
     * @param conversationId the ID of the conversation to retrieve
     * @return the conversation (ModelConversation or AgentConversation)
     */
    public Object getConversation(String conversationId) {
        return sendGetRequest("/v1/conversations/" + conversationId, Object.class);
    }

    /**
     * Deletes a conversation.
     *
     * @param conversationId the ID of the conversation to delete
     */
    public void deleteConversation(String conversationId) {
        sendDeleteRequestNoResponse("/v1/conversations/" + conversationId);
    }

    /**
     * Appends entries to a conversation.
     *
     * @param conversationId the ID of the conversation
     * @param request        the append request
     * @return the conversation response
     */
    public ConversationResponse appendToConversation(String conversationId, ConversationAppendRequest request) {
        return sendPostRequest("/v1/conversations/" + conversationId, request, ConversationResponse.class);
    }

    /**
     * Retrieves conversation history.
     *
     * @param conversationId the ID of the conversation
     * @return the conversation history
     */
    public ConversationHistory getConversationHistory(String conversationId) {
        return sendGetRequest("/v1/conversations/" + conversationId + "/history", ConversationHistory.class);
    }

    /**
     * Retrieves messages from a conversation.
     *
     * @param conversationId the ID of the conversation
     * @return the conversation messages
     */
    public ConversationMessages getConversationMessages(String conversationId) {
        return sendGetRequest("/v1/conversations/" + conversationId + "/messages", ConversationMessages.class);
    }

    /**
     * Restarts a conversation from a given entry.
     *
     * @param conversationId the ID of the conversation to restart
     * @param request        the restart request
     * @return the conversation response
     */
    public ConversationResponse restartConversation(String conversationId, ConversationRestartRequest request) {
        return sendPostRequest("/v1/conversations/" + conversationId + "/restart", request, ConversationResponse.class);
    }

    // Moderations API

    /**
     * Sends a moderation request to the Mistral AI API.
     *
     * @param request the classification request
     * @return the moderation response from the API
     */
    public ModerationResponse moderations(ClassificationRequest request) {
        return sendPostRequest("/v1/moderations", request, ModerationResponse.class);
    }

    /**
     * Sends a chat moderation request to the Mistral AI API.
     *
     * @param request the chat moderation request
     * @return the moderation response from the API
     */
    public ModerationResponse chatModerations(ChatModerationRequest request) {
        return sendPostRequest("/v1/chat/moderations", request, ModerationResponse.class);
    }

    // Models API

    /**
     * Lists all models available to the user.
     *
     * @return a list of available models
     */
    public ModelList listModels() {
        return sendGetRequest("/v1/models", ModelList.class);
    }

    /**
     * Retrieves information about a specific model.
     *
     * @param modelId the ID of the model to retrieve
     * @return information about the specified model
     */
    public BaseModelCard retrieveModel(String modelId) {
        return sendGetRequest("/v1/models/" + modelId, BaseModelCard.class);
    }

    // Files API

    /**
     * Lists files that belong to the user's organization.
     *
     * @param page     the page number (0-based) for pagination
     * @param pageSize the number of items per page
     * @param purpose  filter files by purpose
     * @return a list of files
     */
    public ListFilesOut listFiles(Integer page, Integer pageSize, String purpose) {
        String url = String.format("/v1/files?page=%d&page_size=%d",
                page != null ? page : 0,
                pageSize != null ? pageSize : 100);
        if (purpose != null) {
            url += "&purpose=" + purpose;
        }
        return sendGetRequest(url, ListFilesOut.class);
    }

    /**
     * Retrieves information about a specific file.
     *
     * @param fileId the ID of the file to retrieve
     * @return information about the specified file
     */
    public RetrieveFileOut retrieveFile(UUID fileId) {
        return sendGetRequest("/v1/files/" + fileId, RetrieveFileOut.class);
    }

    /**
     * Deletes a file.
     *
     * @param fileId the ID of the file to delete
     * @return the result of the delete operation
     */
    public DeleteFileOut deleteFile(UUID fileId) {
        return sendDeleteRequest("/v1/files/" + fileId, DeleteFileOut.class);
    }

    /**
     * Downloads the content of a file.
     *
     * @param fileId the ID of the file to download
     * @return the file content as a byte array
     */
    public byte[] downloadFile(UUID fileId) {
        return sendGetRequestBytes("/v1/files/" + fileId + "/content");
    }

    /**
     * Gets a signed URL for a file that can be used to download the file.
     *
     * @param fileId the ID of the file
     * @param expiry the number of hours before the URL becomes invalid (defaults to 24 if null)
     * @return a signed URL for the file
     */
    public FileSignedURL getSignedUrl(UUID fileId, Integer expiry) {
        String url = "/v1/files/" + fileId + "/url";
        if (expiry != null) {
            url += "?expiry=" + expiry;
        }
        return sendGetRequest(url, FileSignedURL.class);
    }

    /**
     * Sends a chat classification request to the Mistral AI API.
     *
     * @param request the chat classification request
     * @return the classification response
     */
    public ClassificationResponse chatClassifications(ChatClassificationRequest request) {
        return sendPostRequest("/v1/chat/classifications", request, ClassificationResponse.class);
    }

    /**
     * Creates a streaming transcription for the specified audio file.
     *
     * @param request the transcription request
     * @return the streaming transcription response
     */
    public AudioTranscriptionsStreamOut createTranscriptionStream(AudioTranscriptionRequest request) {
        return sendPostRequest("/v1/audio/transcriptions#stream", request, AudioTranscriptionsStreamOut.class);
    }

    /**
     * Gets a sample of a specific voice.
     *
     * @param voiceId the ID of the voice
     * @return the voice sample
     */
    public VoiceSampleOut getVoiceSample(String voiceId) {
        return sendGetRequest("/v1/audio/voices/" + voiceId + "/sample", VoiceSampleOut.class);
    }

    /**
     * Uploads a file that can be used across various endpoints.
     *
     * @param filePath the path to the file to upload
     * @param purpose  the purpose of the file
     * @return information about the uploaded file
     */
    public FileObject uploadFile(String filePath, String purpose) {
        return sendUploadRequest("/v1/files", filePath, Map.of("purpose", purpose), FileObject.class);
    }

    // Libraries API

    /**
     * Lists libraries.
     *
     * @return a list of libraries
     */
    public ListLibraryOut listLibraries() {
        return sendGetRequest("/v1/libraries", ListLibraryOut.class);
    }

    /**
     * Creates a new library.
     *
     * @param request the library creation request
     * @return information about the created library
     */
    public LibraryOut createLibrary(LibraryIn request) {
        return sendPostRequest("/v1/libraries", request, LibraryOut.class);
    }

    /**
     * Retrieves information about a specific library.
     *
     * @param libraryId the ID of the library to retrieve
     * @return information about the specified library
     */
    public LibraryOut getLibrary(UUID libraryId) {
        return sendGetRequest("/v1/libraries/" + libraryId, LibraryOut.class);
    }

    /**
     * Updates an existing library.
     *
     * @param libraryId the ID of the library to update
     * @param request   the update request
     * @return information about the updated library
     */
    public LibraryOut updateLibrary(UUID libraryId, LibraryIn request) {
        return sendPostRequest("/v1/libraries/" + libraryId, request, LibraryOut.class);
    }

    /**
     * Deletes a library.
     *
     * @param libraryId the ID of the library to delete
     * @return the result of the delete operation
     */
    public DeleteFileOut deleteLibrary(UUID libraryId) {
        return sendDeleteRequest("/v1/libraries/" + libraryId, DeleteFileOut.class);
    }

    /**
     * Lists documents in a specific library.
     *
     * @param libraryId the ID of the library
     * @param page      the page number
     * @param pageSize  the number of items per page
     * @return a list of documents
     */
    public ListDocumentOut listLibraryDocuments(UUID libraryId, Integer page, Integer pageSize) {
        String url = String.format("/v1/libraries/%s/documents?page=%d&page_size=%d",
                libraryId,
                page != null ? page : 0,
                pageSize != null ? pageSize : 100);
        return sendGetRequest(url, ListDocumentOut.class);
    }

    /**
     * Uploads a document to a library.
     *
     * @param libraryId the ID of the library
     * @param filePath  the path to the file to upload
     * @return information about the uploaded document
     */
    public DocumentOut uploadLibraryDocument(UUID libraryId, String filePath) {
        return sendUploadRequest("/v1/libraries/" + libraryId + "/documents", filePath, Map.of(), DocumentOut.class);
    }

    /**
     * Gets the status of a document in a library.
     *
     * @param libraryId  the ID of the library
     * @param documentId the ID of the document
     * @return the document status
     */
    public DocumentStatusOut getDocumentStatus(UUID libraryId, String documentId) {
        return sendGetRequest("/v1/libraries/" + libraryId + "/documents/" + documentId + "/status", DocumentStatusOut.class);
    }

    /**
     * Gets a signed URL for a document in a library.
     *
     * @param libraryId  the ID of the library
     * @param documentId the ID of the document
     * @return the signed URL for the document
     */
    public DocumentSignedURL getDocumentSignedURL(UUID libraryId, String documentId) {
        return sendGetRequest("/v1/libraries/" + libraryId + "/documents/" + documentId + "/signed-url", DocumentSignedURL.class);
    }

    /**
     * Gets a signed URL for extracted text from a document.
     *
     * @param libraryId  the ID of the library
     * @param documentId the ID of the document
     * @return the signed URL for extracted text
     */
    public ExtractedTextSignedURL getExtractedTextSignedURL(UUID libraryId, String documentId) {
        return sendGetRequest("/v1/libraries/" + libraryId + "/documents/" + documentId + "/extracted-text-signed-url", ExtractedTextSignedURL.class);
    }

    /**
     * Reprocesses a document in a library.
     *
     * @param libraryId  the ID of the library
     * @param documentId the ID of the document
     * @return the reprocess response
     */
    public ReprocessDocumentOut reprocessDocument(UUID libraryId, String documentId) {
        return sendPostRequest("/v1/libraries/" + libraryId + "/documents/" + documentId + "/reprocess", null, ReprocessDocumentOut.class);
    }

    /**
     * Shares a library.
     *
     * @param libraryId the ID of the library
     * @return the share response
     */
    public LibraryShareOut shareLibrary(UUID libraryId) {
        return sendPostRequest("/v1/libraries/" + libraryId + "/share", null, LibraryShareOut.class);
    }

    // Audio API

    /**
     * Creates a transcription for the specified audio file.
     *
     * @param request  the transcription request
     * @param filePath the path to the audio file (optional if file_id or file_url is provided)
     * @return the transcription response from the API
     */
    public TranscriptionResponse createTranscription(AudioTranscriptionRequest request, String filePath) {
        if (filePath != null) {
            Map<String, String> fields = new java.util.HashMap<>();
            if (request.model() != null) fields.put("model", request.model());
            if (request.language() != null) fields.put("language", request.language());
            // Other fields could be added here
            return sendUploadRequest("/v1/audio/transcriptions", filePath, fields, TranscriptionResponse.class);
        } else {
            return sendPostRequest("/v1/audio/transcriptions", request, TranscriptionResponse.class);
        }
    }

    /**
     * Generates speech from text.
     *
     * @param request the speech request
     * @return the speech response containing the audio data
     */
    public SpeechResponse createSpeech(SpeechRequest request) {
        return sendPostRequest("/v1/audio/speech", request, SpeechResponse.class);
    }

    /**
     * Lists all available voices.
     *
     * @return a list of voices
     */
    public ListVoicesOut listVoices() {
        return sendGetRequest("/v1/audio/voices", ListVoicesOut.class);
    }

    /**
     * Lists agents.
     *
     * @param page     the page number
     * @param pageSize the number of items per page
     * @return a list of agents
     */
    public ListAgentsOut listAgents(Integer page, Integer pageSize) {
        String url = String.format("/v1/agents?page=%d&page_size=%d",
                page != null ? page : 0,
                pageSize != null ? pageSize : 20);
        return sendGetRequest(url, ListAgentsOut.class);
    }

    /**
     * Creates a new agent.
     *
     * @param request the agent creation request
     * @return information about the created agent
     */
    public Agent createAgent(AgentCreationRequest request) {
        return sendPostRequest("/v1/agents", request, Agent.class);
    }

    /**
     * Retrieves information about a specific agent.
     *
     * @param agentId the ID of the agent to retrieve
     * @return information about the specified agent
     */
    public Agent getAgent(String agentId) {
        return sendGetRequest("/v1/agents/" + agentId, Agent.class);
    }

    /**
     * Updates an existing agent.
     *
     * @param agentId the ID of the agent to update
     * @param request the update request
     * @return information about the updated agent
     */
    public Agent updateAgent(String agentId, AgentCreationRequest request) {
        return sendPostRequest("/v1/agents/" + agentId, request, Agent.class);
    }

    /**
     * Deletes an agent.
     *
     * @param agentId the ID of the agent to delete
     * @return information about the deleted agent
     */
    public Agent deleteAgent(String agentId) {
        return sendDeleteRequest("/v1/agents/" + agentId, Agent.class);
    }

    /**
     * Updates an agent version.
     *
     * @param agentId the ID of the agent
     * @param version the version number to switch to
     * @return the updated agent
     */
    public Agent updateAgentVersion(String agentId, Integer version) {
        return sendPatchRequest("/v1/agents/" + agentId + "/version?version=" + version, Agent.class);
    }

    /**
     * Lists all versions of an agent.
     *
     * @param agentId  the ID of the agent
     * @param page     the page number (default: 0)
     * @param pageSize the number of versions per page (default: 20)
     * @return a list of agent versions
     */
    public List<Agent> listAgentVersions(String agentId, Integer page, Integer pageSize) {
        StringBuilder url = new StringBuilder("/v1/agents/" + agentId + "/versions");
        boolean hasParams = false;
        if (page != null) {
            url.append("?page=").append(page);
            hasParams = true;
        }
        if (pageSize != null) {
            url.append(hasParams ? "&" : "?").append("page_size=").append(pageSize);
        }
        return sendGetRequest(url.toString(), List.class);
    }

    /**
     * Retrieves a specific version of an agent.
     *
     * @param agentId the ID of the agent
     * @param version the version number
     * @return the agent at the specified version
     */
    public Agent getAgentVersion(String agentId, String version) {
        return sendGetRequest("/v1/agents/" + agentId + "/versions/" + version, Agent.class);
    }

    /**
     * Creates or updates an agent alias.
     *
     * @param agentId the ID of the agent
     * @param alias   the alias name
     * @param version the version number to point to
     * @return the alias response
     */
    public AgentAliasResponse createOrUpdateAgentAlias(String agentId, String alias, Integer version) {
        return sendPutRequest("/v1/agents/" + agentId + "/aliases?alias=" + alias + "&version=" + version, AgentAliasResponse.class);
    }

    /**
     * Lists all aliases for an agent.
     *
     * @param agentId the ID of the agent
     * @return a list of agent aliases
     */
    public List<AgentAliasResponse> listAgentAliases(String agentId) {
        return sendGetRequest("/v1/agents/" + agentId + "/aliases", List.class);
    }

    /**
     * Deletes an agent alias.
     *
     * @param agentId the ID of the agent
     * @param alias   the alias name to delete
     */
    public void deleteAgentAlias(String agentId, String alias) {
        sendDeleteRequestNoResponse("/v1/agents/" + agentId + "/aliases?alias=" + alias);
    }

    // Fine-tuning API

    /**
     * Lists fine-tuning jobs.
     *
     * @param page        the page number (0-based) for pagination
     * @param pageSize    the number of items per page
     * @param model       filter jobs by model name
     * @param createdByMe when true, only return jobs created by the API caller
     * @param status      filter jobs by status
     * @return a list of fine-tuning jobs
     */
    public JobsOut listFineTuningJobs(Integer page, Integer pageSize, String model,
                                      Boolean createdByMe, String status) {
        StringBuilder url = new StringBuilder(String.format("/v1/fine_tuning/jobs?page=%d&page_size=%d",
                page != null ? page : 0,
                pageSize != null ? pageSize : 100));

        if (model != null) url.append("&model=").append(model);
        if (createdByMe != null) url.append("&created_by_me=").append(createdByMe);
        if (status != null) url.append("&status=").append(status);

        return sendGetRequest(url.toString(), JobsOut.class);
    }

    /**
     * Creates a fine-tuning job.
     *
     * @param request the job creation request
     * @return information about the created job
     */
    public JobOut createFineTuningJob(JobIn request) {
        return sendPostRequest("/v1/fine_tuning/jobs", request, JobOut.class);
    }

    /**
     * Retrieves information about a specific fine-tuning job.
     *
     * @param jobId the ID of the job to retrieve
     * @return information about the specified job
     */
    public JobOut getFineTuningJob(UUID jobId) {
        return sendGetRequest("/v1/fine_tuning/jobs/" + jobId, JobOut.class);
    }

    /**
     * Cancels a fine-tuning job.
     *
     * @param jobId the ID of the job to cancel
     * @return information about the cancelled job
     */
    public JobOut cancelFineTuningJob(UUID jobId) {
        return sendPostRequest("/v1/fine_tuning/jobs/" + jobId + "/cancel", null, JobOut.class);
    }

    /**
     * Starts a fine-tuning job.
     *
     * @param jobId the ID of the job to start
     * @return information about the started job
     */
    public JobOut startFineTuningJob(UUID jobId) {
        return sendPostRequest("/v1/fine_tuning/jobs/" + jobId + "/start", null, JobOut.class);
    }

    /**
     * Archives a fine-tuned model.
     *
     * @param modelId the ID of the model to archive
     * @return the archive response
     */
    public ArchiveFTModelOut archiveModel(String modelId) {
        return sendPostRequest("/v1/fine_tuning/models/" + modelId + "/archive", null, ArchiveFTModelOut.class);
    }

    /**
     * Unarchives a fine-tuned model.
     *
     * @param modelId the ID of the model to unarchive
     * @return the unarchive response
     */
    public UnarchiveFTModelOut unarchiveModel(String modelId) {
        return sendDeleteRequest("/v1/fine_tuning/models/" + modelId + "/archive", UnarchiveFTModelOut.class);
    }

    // Batch API

    /**
     * Creates a batch job.
     *
     * @param request the batch job creation request
     * @return information about the created batch job
     */
    public BatchJobOut createBatchJob(BatchJobIn request) {
        return sendPostRequest("/v1/batch/jobs", request, BatchJobOut.class);
    }

    /**
     * Lists batch jobs.
     *
     * @param cursor   the cursor for pagination
     * @param pageSize the number of items per page
     * @return a list of batch jobs
     */
    public BatchJobsOut listBatchJobs(String cursor, Integer pageSize) {
        String url = String.format("/v1/batch/jobs?page_size=%d", pageSize != null ? pageSize : 100);
        if (cursor != null) {
            url += "&cursor=" + cursor;
        }
        return sendGetRequest(url, BatchJobsOut.class);
    }

    /**
     * Retrieves information about a specific batch job.
     *
     * @param jobId the ID of the job to retrieve
     * @return information about the specified batch job
     */
    public BatchJobOut getBatchJob(String jobId) {
        return sendGetRequest("/v1/batch/jobs/" + jobId, BatchJobOut.class);
    }

    /**
     * Cancels a batch job.
     *
     * @param jobId the ID of the job to cancel
     * @return information about the cancelled batch job
     */
    public BatchJobOut cancelBatchJob(String jobId) {
        return sendPostRequest("/v1/batch/jobs/" + jobId + "/cancel", null, BatchJobOut.class);
    }

    // Helper methods for HTTP requests

    /**
     * Sends a GET request to the specified path and deserializes the response to the specified type.
     *
     * @param path         the API endpoint path
     * @param responseType the class to deserialize the response to
     * @param <T>          the type of the response
     * @return the deserialized response
     * @throws MistralApiException if the request fails or the response cannot be deserialized
     */
    private <T> T sendGetRequest(String path, Class<T> responseType) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + path))
                .header("Authorization", "Bearer " + apiKey)
                .header("Accept", "application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            validateResponse(response);
            return deserialize(response.body(), responseType);
        } catch (IOException | InterruptedException e) {
            throw new MistralApiException("Failed to execute request", e);
        }
    }

    /**
     * Sends a GET request to the specified path and returns the response as a byte array.
     *
     * @param path the API endpoint path
     * @return the response body as a byte array
     * @throws MistralApiException if the request fails
     */
    private byte[] sendGetRequestBytes(String path) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + path))
                .header("Authorization", "Bearer " + apiKey)
                .GET()
                .build();

        try {
            HttpResponse<byte[]> response = httpClient.send(request, HttpResponse.BodyHandlers.ofByteArray());
            validateResponse(response);
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new MistralApiException("Failed to execute request", e);
        }
    }

    /**
     * Sends a POST request with a JSON body to the specified path and deserializes the response to the specified type.
     *
     * @param path         the API endpoint path
     * @param body         the request body to serialize to JSON
     * @param responseType the class to deserialize the response to
     * @param <T>          the type of the response
     * @return the deserialized response
     * @throws MistralApiException if the request fails or the response cannot be deserialized
     */
    private <T> T sendPostRequest(String path, Object body, Class<T> responseType) {
        try {
            String jsonBody = objectMapper.writeValueAsString(body);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + path))
                    .header("Authorization", "Bearer " + apiKey)
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            validateResponse(response);
            return deserialize(response.body(), responseType);
        } catch (IOException | InterruptedException e) {
            throw new MistralApiException("Failed to execute request", e);
        }
    }

    /**
     * Sends a multipart/form-data POST request to upload a file.
     *
     * @param path         the API endpoint path
     * @param filePath     the path to the file to upload
     * @param fields       additional form fields to include in the request
     * @param responseType the class to deserialize the response to
     * @param <T>          the type of the response
     * @return the deserialized response
     * @throws MistralApiException if the request fails or the response cannot be deserialized
     */
    private <T> T sendUploadRequest(String path, String filePath, Map<String, String> fields, Class<T> responseType) {
        try {
            // TODO: Implement multipart form data upload
            // This requires implementing a proper multipart/form-data request builder
            throw new UnsupportedOperationException("File upload not yet implemented");
        } catch (Exception e) {
            throw new MistralApiException("Failed to upload file", e);
        }
    }

    /**
     * Sends a DELETE request to the specified path and deserializes the response to the specified type.
     *
     * @param path         the API endpoint path
     * @param responseType the class to deserialize the response to
     * @param <T>          the type of the response
     * @return the deserialized response
     * @throws MistralApiException if the request fails or the response cannot be deserialized
     */
    private <T> T sendDeleteRequest(String path, Class<T> responseType) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + path))
                .header("Authorization", "Bearer " + apiKey)
                .header("Accept", "application/json")
                .DELETE()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            validateResponse(response);
            return deserialize(response.body(), responseType);
        } catch (IOException | InterruptedException e) {
            throw new MistralApiException("Failed to execute request", e);
        }
    }

    /**
     * Sends a DELETE request to the specified path without expecting a response body.
     *
     * @param path the API endpoint path
     * @throws MistralApiException if the request fails
     */
    private void sendDeleteRequestNoResponse(String path) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + path))
                .header("Authorization", "Bearer " + apiKey)
                .header("Accept", "application/json")
                .DELETE()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            validateResponse(response);
        } catch (IOException | InterruptedException e) {
            throw new MistralApiException("Failed to execute request", e);
        }
    }

    /**
     * Sends a PATCH request to the specified path and deserializes the response.
     *
     * @param path         the API endpoint path
     * @param responseType the class to deserialize the response to
     * @param <T>          the type of the response
     * @return the deserialized response
     * @throws MistralApiException if the request fails
     */
    private <T> T sendPatchRequest(String path, Class<T> responseType) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + path))
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .method("PATCH", HttpRequest.BodyPublishers.noBody())
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            validateResponse(response);
            return deserialize(response.body(), responseType);
        } catch (IOException | InterruptedException e) {
            throw new MistralApiException("Failed to execute request", e);
        }
    }

    /**
     * Sends a PUT request to the specified path and deserializes the response.
     *
     * @param path         the API endpoint path
     * @param responseType the class to deserialize the response to
     * @param <T>          the type of the response
     * @return the deserialized response
     * @throws MistralApiException if the request fails
     */
    private <T> T sendPutRequest(String path, Class<T> responseType) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + path))
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .PUT(HttpRequest.BodyPublishers.noBody())
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            validateResponse(response);
            return deserialize(response.body(), responseType);
        } catch (IOException | InterruptedException e) {
            throw new MistralApiException("Failed to execute request", e);
        }
    }

    /**
     * Validates the HTTP response and throws an exception if the status code indicates an error.
     *
     * @param response the HTTP response to validate
     * @param <T>      the type of the response body
     * @throws MistralApiException if the status code is 400 or higher
     */
    private <T> void validateResponse(HttpResponse<T> response) {
        int statusCode = response.statusCode();
        if (statusCode >= 400) {
            throw new MistralApiException("API request failed with status code: " + statusCode);
        }
    }

    /**
     * Deserializes a JSON string to the specified type.
     *
     * @param json the JSON string to deserialize
     * @param type the class to deserialize to
     * @param <T>  the type to deserialize to
     * @return the deserialized object
     * @throws MistralApiException if the JSON cannot be deserialized
     */
    private <T> T deserialize(String json, Class<T> type) {
        try {
            return objectMapper.readValue(json, type);
        } catch (Exception e) {
            throw new MistralApiException("Failed to deserialize response", e);
        }
    }
}
