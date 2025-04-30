# Mistral Java Client

A Java client for the Mistral AI API.

## Installation

This client requires Java 11 or higher.

## API Key Setup

Before you begin, you will need a Mistral AI API key.

1. Get your own Mistral API Key: https://docs.mistral.ai/#api-access
2. Set your Mistral API Key as an environment variable:

```bash
export MISTRAL_API_KEY=your_api_key_here
```

## Usage

### Creating a Client

```java
import fr.slickteam.mistralai.client.MistralClient;
import fr.slickteam.mistralai.client.Mistral;

// Create a client using your API key
String apiKey = System.getenv("MISTRAL_API_KEY");
Mistral client = MistralClient.create(apiKey);

// Or create a client with debug logging enabled
Mistral clientWithLogging = MistralClient.createWithDebugLogging(apiKey);
```

### Available Resources

The client provides access to the following API resources:

- `client.getModels()`: Access models API
- `client.getChat()`: Access chat API
- `client.getEmbeddings()`: Access embeddings API
- `client.getFiles()`: Access files API
- `client.getFineTuning()`: Access fine-tuning API
- `client.getBatch()`: Access batch operations API
- `client.getFim()`: Access Fill in the Middle (FIM) API
- `client.getAgents()`: Access agents API
- `client.getClassifiers()`: Access classifiers API
- `client.getOcr()`: Access OCR (Optical Character Recognition) API

### Retry Configuration

You can configure retry behavior:

```java
import fr.slickteam.mistralai.client.Config;
import fr.slickteam.mistralai.client.RetryConfig;
import fr.slickteam.mistralai.client.Mistral;

// Configure retry behavior
RetryConfig retryConfig = new RetryConfig()
    .setMaxRetries(3)
    .setInitialBackoffMs(1000)
    .setMaxBackoffMs(30000)
    .setBackoffMultiplier(2.0);

Config.SDKOptions options = new Config.SDKOptions()
    .setApiKey(apiKey)
    .setRetryConfig(retryConfig);

Mistral client = new Mistral(options);
```

## Development

This client is generated using Java's native HttpClient for HTTP requests.