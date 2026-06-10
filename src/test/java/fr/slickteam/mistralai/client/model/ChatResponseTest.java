package fr.slickteam.mistralai.client.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import fr.slickteam.mistralai.client.type.FinishReason;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ChatResponseTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testDeserialization() throws JsonProcessingException {
        String json = """
                {
                  "id": "cf79f7daaee244b1a0ae5c7b1444424a",
                  "object": "chat.completion",
                  "model": "mistral-medium-latest",
                  "usage": {
                    "prompt_tokens": 24,
                    "completion_tokens": 27,
                    "total_tokens": 51,
                    "prompt_audio_seconds": 10
                  },
                  "created": 1759500534,
                  "choices": [
                    {
                      "index": 0,
                      "message": {
                        "role": "assistant",
                        "content": "Hello!"
                      },
                      "finish_reason": "stop"
                    }
                  ]
                }
                """;

        ChatResponse response = objectMapper.readValue(json, ChatResponse.class);

        assertEquals("cf79f7daaee244b1a0ae5c7b1444424a", response.id());
        assertEquals("chat.completion", response.object());
        assertEquals("mistral-medium-latest", response.model());
        assertEquals(1759500534L, response.created());
        
        assertNotNull(response.usage());
        assertEquals(24, response.usage().prompt_tokens());
        assertEquals(27, response.usage().completion_tokens());
        assertEquals(51, response.usage().total_tokens());
        assertEquals(10, response.usage().prompt_audio_seconds());

        assertNotNull(response.choices());
        assertEquals(1, response.choices().size());
        ChatChoice choice = response.choices().get(0);
        assertEquals(0, choice.index());
        assertEquals("assistant", choice.message().role());
        assertEquals("Hello!", choice.message().content());
        assertEquals(FinishReason.STOP, choice.finish_reason());
    }

    @Test
    void testBuilder() {
        Usage usage = Usage.builder()
                .prompt_tokens(10)
                .completion_tokens(20)
                .total_tokens(30)
                .prompt_audio_seconds(5)
                .build();

        ChatMessage message = ChatMessage.builder()
                .role("assistant")
                .content("Hi")
                .build();

        ChatChoice choice = ChatChoice.builder()
                .index(0)
                .message(message)
                .finish_reason(FinishReason.STOP)
                .build();

        ChatResponse response = ChatResponse.builder()
                .id("test-id")
                .object("chat.completion")
                .model("test-model")
                .created(123456789L)
                .usage(usage)
                .choices(List.of(choice))
                .build();

        assertEquals("test-id", response.id());
        assertEquals(5, response.usage().prompt_audio_seconds());
        assertEquals(FinishReason.STOP, response.choices().get(0).finish_reason());
    }
}
