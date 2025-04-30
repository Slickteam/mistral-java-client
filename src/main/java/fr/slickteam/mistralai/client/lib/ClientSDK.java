package fr.slickteam.mistralai.client.lib;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

/**
 * Base class for SDK clients.
 */
public class ClientSDK {

    private static final System.Logger log = System.getLogger(ClientSDK.class.getName());

    protected final Config.SDKOptions options;
    protected final HttpClient client;

    /**
     * Creates a new SDK client with the specified options.
     *
     * @param options The SDK options
     */
    public ClientSDK(Config.SDKOptions options) {
        this.options = options != null ? options : new Config.SDKOptions();

        client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(30))
                .build();
    }

    /**
     * Creates a new SDK client with default options.
     */
    public ClientSDK() {
        this(new Config.SDKOptions());
    }

    /**
     * Gets the SDK options.
     *
     * @return The SDK options
     */
    public Config.SDKOptions getOptions() {
        return options;
    }

    /**
     * Sends an HTTP request.
     *
     * @param request The HTTP request to send
     * @return The HTTP response
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    protected HttpResponse<String> sendRequest(HttpRequest request) throws IOException, InterruptedException {
        log.log(System.Logger.Level.DEBUG, "Sending request to " + request.uri());

        HttpRequest finalRequest = buildHttpRequest(request);
        HttpResponse<String> response = client.send(finalRequest, HttpResponse.BodyHandlers.ofString());

        log.log(System.Logger.Level.DEBUG, "Received response with status code " + response.statusCode());
        return response;
    }

    /**
     * Sends an HTTP request.
     *
     * @param request The HTTP request to send
     * @return The HTTP response
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    protected HttpResponse<InputStream> sendRequestGetResponseAsInputStream(HttpRequest request) throws IOException, InterruptedException {
        log.log(System.Logger.Level.DEBUG, "Sending request to " + request.uri());

        HttpRequest finalRequest = buildHttpRequest(request);
        HttpResponse<InputStream> response = client.send(finalRequest, HttpResponse.BodyHandlers.ofInputStream());

        log.log(System.Logger.Level.DEBUG, "Received response with status code " + response.statusCode());
        return response;
    }

    /**
     * Sends an HTTP request.
     *
     * @param request The HTTP request to send
     * @return The HTTP response
     * @throws IOException          If an I/O error occurs
     * @throws InterruptedException If the operation is interrupted
     */
    protected HttpResponse<byte[]> sendRequestGetResponseAsBytes(HttpRequest request) throws IOException, InterruptedException {
        log.log(System.Logger.Level.DEBUG, "Sending request to " + request.uri());

        HttpRequest finalRequest = buildHttpRequest(request);
        HttpResponse<byte[]> response = client.send(finalRequest, HttpResponse.BodyHandlers.ofByteArray());

        log.log(System.Logger.Level.DEBUG, "Received response with status code " + response.statusCode());
        return response;
    }

    /**
     * Sends an HTTP request asynchronously.
     *
     * @param request The HTTP request to send
     * @return A CompletableFuture for the HTTP response
     */
    protected CompletableFuture<HttpResponse<byte[]>> sendRequestAsync(HttpRequest request) {
        log.log(System.Logger.Level.DEBUG, "Sending async request to " + request.uri());

        HttpRequest finalRequest = buildHttpRequest(request);

        return client.sendAsync(finalRequest, HttpResponse.BodyHandlers.ofByteArray())
                .thenApply(response -> {
                    log.log(System.Logger.Level.DEBUG, "Received async response with status code " + response.statusCode());
                    return response;
                });
    }

    /**
     * Creates a base URL for API requests.
     *
     * @return The base URL
     */
    protected URL getBaseURL() {
        return Config.serverURLFromOptions(options);
    }

    /**
     * Creates a URI for an API endpoint.
     *
     * @param path The endpoint path
     * @return The URI
     */
    protected URI createURI(String path) {
        try {
            URL baseURL = getBaseURL();
            return URI.create(baseURL + path);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create URI", e);
        }
    }

    /**
     * Builds an HTTP request by copying properties from the provided request and
     * applying additional configurations such as headers, authorization, timeout, and
     * user agent.
     *
     * @param request The HTTP request to use as a base for building the new request.
     * @return A new HttpRequest instance with the applied configurations.
     */
    private HttpRequest buildHttpRequest(HttpRequest request) {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(request.uri())
                .method(request.method(), request.bodyPublisher().orElse(HttpRequest.BodyPublishers.noBody()));

        // Copy headers
        request.headers().map().forEach((name, values) -> {
            values.forEach(value -> requestBuilder.header(name, value));
        });

        // Add authorization header if API key is provided
        if (options.getApiKey() != null && !options.getApiKey().isEmpty()) {
            requestBuilder.header("Authorization", "Bearer " + options.getApiKey());
        }

        // Add timeout if specified
        if (options.getTimeoutMs() != null) {
            requestBuilder.timeout(Duration.ofMillis(options.getTimeoutMs()));
        }

        // Add user agent
        requestBuilder.header("User-Agent", Config.SDKMetadata.USER_AGENT);

        return requestBuilder.build();
    }
}