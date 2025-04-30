package fr.slickteam.mistralai.client.lib;

import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * Configuration options for the Mistral AI SDK.
 */
public class Config {

    /**
     * EU Production server
     */
    public static final String SERVER_EU = "eu";

    /**
     * Contains the list of servers available to the SDK
     */
    protected static final Map<String, String> SERVER_LIST = new HashMap<>();

    static {
        SERVER_LIST.put(SERVER_EU, "https://api.mistral.ai");
    }

    private Config() {
        // hidden constructor
    }

    /**
     * SDK metadata
     */
    public static final class SDKMetadata {
        public static final String LANGUAGE = "java";
        public static final String OPENAPI_DOC_VERSION = "0.0.2";
        public static final String SDK_VERSION = "1.6.0";
        public static final String GEN_VERSION = "2.548.6";
        public static final String USER_AGENT =
                "speakeasy-sdk/java 1.6.0 2.548.6 0.0.2 com.mistralai.client";

        private SDKMetadata() {
            // Private constructor to prevent instantiation
        }
    }

    /**
     * Options for configuring the SDK.
     */
    public static class SDKOptions {
        private String apiKey;
        private Supplier<CompletableFuture<String>> apiKeySupplier;
        private String server;
        private String serverURL;
        private RetryConfig retryConfig;
        private Integer timeoutMs;

        /**
         * Creates a new instance of SDKOptions with default values.
         */
        public SDKOptions() {
            this.server = SERVER_EU;
        }

        /**
         * Gets the API key.
         *
         * @return The API key
         */
        public String getApiKey() {
            return apiKey;
        }

        /**
         * Sets the API key.
         *
         * @param apiKey The API key
         * @return This options instance
         */
        public SDKOptions setApiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        /**
         * Gets the API key supplier.
         *
         * @return The API key supplier
         */
        public Supplier<CompletableFuture<String>> getApiKeySupplier() {
            return apiKeySupplier;
        }

        /**
         * Sets the API key supplier.
         *
         * @param apiKeySupplier The API key supplier
         * @return This options instance
         */
        public SDKOptions setApiKeySupplier(Supplier<CompletableFuture<String>> apiKeySupplier) {
            this.apiKeySupplier = apiKeySupplier;
            return this;
        }

        /**
         * Gets the server.
         *
         * @return The server
         */
        public String getServer() {
            return server;
        }

        /**
         * Sets the server.
         *
         * @param server The server
         * @return This options instance
         */
        public SDKOptions setServer(String server) {
            this.server = server;
            return this;
        }

        /**
         * Gets the server URL.
         *
         * @return The server URL
         */
        public String getServerURL() {
            return serverURL;
        }

        /**
         * Sets the server URL.
         *
         * @param serverURL The server URL
         * @return This options instance
         */
        public SDKOptions setServerURL(String serverURL) {
            this.serverURL = serverURL;
            return this;
        }

        /**
         * Gets the retry configuration.
         *
         * @return The retry configuration
         */
        public RetryConfig getRetryConfig() {
            return retryConfig;
        }

        /**
         * Sets the retry configuration.
         *
         * @param retryConfig The retry configuration
         * @return This options instance
         */
        public SDKOptions setRetryConfig(RetryConfig retryConfig) {
            this.retryConfig = retryConfig;
            return this;
        }

        /**
         * Gets the timeout in milliseconds.
         *
         * @return The timeout in milliseconds
         */
        public Integer getTimeoutMs() {
            return timeoutMs;
        }

        /**
         * Sets the timeout in milliseconds.
         *
         * @param timeoutMs The timeout in milliseconds
         * @return This options instance
         */
        public SDKOptions setTimeoutMs(Integer timeoutMs) {
            this.timeoutMs = timeoutMs;
            return this;
        }

    }

    /**
     * Gets the server URL from the options.
     *
     * @param options The SDK options
     * @return The server URL, or null if not specified
     */
    public static URL serverURLFromOptions(SDKOptions options) {
        try {
            String serverURL = options.getServerURL();

            if (serverURL == null) {
                String server = options.getServer();
                if (server == null) {
                    server = SERVER_EU;
                }

                serverURL = SERVER_LIST.get(server);
                if (serverURL == null) {
                    serverURL = "";
                }
            }

            return URI.create(serverURL).toURL();
        } catch (Exception e) {
            return null;
        }
    }
}