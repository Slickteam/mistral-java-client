# Mistral Java Client

A lightweight Java client for the Mistral AI API, built on Java HttpClient with simple, modelled request/response types.

## Requirements
- Java 17 or higher (the library is compiled with source/target 17)

## Installation
The artifact is published as:
- Group: `fr.slickteam.mistralai`
- Artifact: `mistral-java-client`
- Version: `0.2.0`

Gradle (Kotlin DSL):
```kotlin
dependencies {
    implementation("fr.slickteam.mistralai:mistral-java-client:0.2.0")
}
```

Maven:
```xml
<dependency>
  <groupId>fr.slickteam.mistralai</groupId>
  <artifactId>mistral-java-client</artifactId>
  <version>0.2.0</version>
</dependency>
```

## API Key Setup
1. Get a Mistral API Key: https://docs.mistral.ai/#api-access
2. Export it as an environment variable:
```bash
export MISTRAL_API_KEY=your_api_key_here
```

## Quick Start
Create a client with your API key and call resources.

```java
import fr.slickteam.mistralai.client.MistralClient;
import fr.slickteam.mistralai.client.sdk.Mistral;

String apiKey = System.getenv("MISTRAL_API_KEY");
Mistral client = MistralClient.create(apiKey);
```

Alternatively, customize options (base URL, timeout, retries):
```java
import fr.slickteam.mistralai.client.lib.Config;
import fr.slickteam.mistralai.client.lib.RetryConfig;
import fr.slickteam.mistralai.client.sdk.Mistral;

String apiKey = System.getenv("MISTRAL_API_KEY");

RetryConfig retry = new RetryConfig()
    .setMaxRetries(3)
    .setInitialBackoffMs(1000)
    .setMaxBackoffMs(30000)
    .setBackoffMultiplier(2.0);

Config.SDKOptions options = new Config.SDKOptions()
    .setApiKey(apiKey)
    // Optional: override default server (defaults to https://api.mistral.ai)
    // .setServerURL("https://api.mistral.ai")
    // Optional: set request timeout (ms)
    .setTimeoutMs(30_000)
    // Optional: retry configuration (note: basic wiring present, actual retry logic may vary per call)
    .setRetryConfig(retry);

Mistral client = new Mistral(options);
```

## Available Resources
The client provides access to the following API resources:
- `client.getModels()` — models API
- `client.getChat()` — chat completions (sync and streaming)
- `client.getEmbeddings()` — embeddings
- `client.getFiles()` — upload, list, retrieve, delete, download, signed URL
- `client.getFineTuning()` — fine-tuning operations
- `client.getBatch()` — batch operations
- `client.getFim()` — Fill in the Middle (FIM) completions (sync and streaming)
- `client.getAgents()` — agents completions (sync and streaming)
- `client.getClassifiers()` — moderation and classification
- `client.getOcr()` — OCR

## Usage Examples

### Chat completion
```java
import fr.slickteam.mistralai.client.models.*;

var request = new ChatCompletionRequest();
request.setModel("mistral-small-latest");
request.setMessages(java.util.List.of(
    new ChatMessage("user", java.util.List.of(new ChatMessageContent("text", "Hello!", null)), null, null)
));

var response = client.getChat().complete(request);
System.out.println(response.getChoices().get(0).getMessage().getContent());
```

Streamed chat completion:
```java
import fr.slickteam.mistralai.client.models.*;

var request = new ChatCompletionRequest();
request.setModel("mistral-small-latest");
request.setMessages(java.util.List.of(
    new ChatMessage("user", java.util.List.of(new ChatMessageContent("text", "Stream this please")), null, null)
));

client.getChat().stream(request, event -> {
    if (event.getChoices() != null && !event.getChoices().isEmpty()) {
        var delta = event.getChoices().get(0).getDelta();
        if (delta != null && delta.getContent() != null) {
            System.out.print(delta.getContent());
        }
    }
});
```

### Embeddings
```java
import fr.slickteam.mistralai.client.models.EmbeddingRequest;

var emb = client.getEmbeddings().create(new EmbeddingRequest(
    "mistral-embed", // choose an embeddings model
    java.util.List.of("text 1", "text 2"),
    "float" // or "base64"
));
System.out.println(emb.getData().size());
```

### Files
Upload a .jsonl for fine-tuning or any file up to 512 MB.
```java
import java.nio.file.Path;

var uploaded = client.getFiles().upload(Path.of("/path/to/file.jsonl"), "fine-tune");
System.out.println(uploaded.getId());

var listed = client.getFiles().list(null);
listed.getData().forEach(f -> System.out.println(f.getId()+" "+f.getFilename()));

var stream = client.getFiles().download(uploaded.getId());
// read stream ...

client.getFiles().delete(uploaded.getId());
```

### OCR
```java
import fr.slickteam.mistralai.client.models.OCRRequest;

UploadFileResponse response = client.getFiles().upload(pdfFile, "ocr");
String url = client.getFiles().getSignedUrl(response.getId()).getUrl();

ChatCompletionRequest chatRequest = new ChatCompletionRequest();
chatRequest.setModel("mistral-small-latest");
List<ChatMessage> messages = new ArrayList<>();
ChatMessage message = new ChatMessage();
message.setRole("user");
ChatMessageContent question = new ChatMessageContent();
question.setType("text");
question.setText("can you summarize this document ?");
ChatMessageContent document = new ChatMessageContent();
document.setType("document_url");
document.setDocumentUrl(url);
message.setContent(List.of(question, document));
messages.add(message);
chatRequest.setMessages(messages);

ChatCompletionResponse chatResponse = client.getChat().complete(chatRequest);
chatResponse.getChoices().forEach(choice -> System.out.println(choice.getMessage().getContent()));
```

### Agents (sync and streaming)
```java
import fr.slickteam.mistralai.client.models.*;

var req = new AgentsCompletionRequest();
req.setAgentId("your-agent-id");
req.setInput("Explain JVM in 3 lines");
var res = client.getAgents().complete(req);
System.out.println(res.getChoices().get(0).getMessage().getContent());
```

## Configuration
- API base URL: by default `https://api.mistral.ai` (EU). Override with `Config.SDKOptions#setServerURL` or `setServer`.
- Timeouts: set per-request timeout on the client via `Config.SDKOptions#setTimeoutMs`.
- Authorization: Bearer token added automatically when `apiKey` is provided.
- User-Agent: Set automatically by the SDK.

## Build & Test
- Build: `./gradlew build`
- Run tests: `./gradlew test`

## Contributing
Issues and PRs are welcome. Please run the test suite before submitting changes.

## License
MIT License. See [LICENSE](LICENSE).