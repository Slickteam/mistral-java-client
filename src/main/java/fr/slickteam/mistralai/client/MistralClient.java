package fr.slickteam.mistralai.client;

import fr.slickteam.mistralai.client.lib.Config;
import fr.slickteam.mistralai.client.sdk.Mistral;

/**
 * Main entry point for the Mistral AI Java client.
 * This class provides examples of how to use the SDK.
 */
public class MistralClient {

    private static final System.Logger log = System.getLogger(MistralClient.class.getName());

    /**
     * Creates a new Mistral client with the specified API key.
     *
     * @param apiKey The API key to use for authentication
     * @return A new Mistral client
     */
    public static Mistral create(String apiKey) {
        Config.SDKOptions options = new Config.SDKOptions()
                .setApiKey(apiKey);
        return new Mistral(options);
    }

    /**
     * Example usage of the Mistral client.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        // Get API key from environment variable
        String apiKey = System.getenv("MISTRAL_API_KEY");
        if (apiKey == null || apiKey.isEmpty()) {
            log.log(System.Logger.Level.ERROR, "MISTRAL_API_KEY environment variable not set");
            System.exit(1);
        }

        // Create a client
        Mistral client = create(apiKey);
        log.log(System.Logger.Level.INFO, "Mistral client created successfully");

        // Example: Access the models API
        // Note: Actual API calls would be implemented in the Models class
        log.log(System.Logger.Level.DEBUG, "Accessing models API...");
        client.getModels();

        // Example: Access the chat API
        // Note: Actual API calls would be implemented in the Chat class
        log.log(System.Logger.Level.DEBUG, "Accessing chat API...");
        client.getChat();

        log.log(System.Logger.Level.DEBUG, "Example completed successfully");
    }
}