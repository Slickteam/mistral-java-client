package fr.slickteam.mistralai.client.model;

import fr.slickteam.mistralai.client.type.ToolChoiceEnum;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

class ChatRequestTest {

    @Test
    void testBuilder() {
        ChatMessage message = ChatMessage.builder()
                .role("user")
                .content("Hello")
                .build();
        
        ChatRequest request = ChatRequest.builder()
                .model("mistral-small")
                .messages(List.of(message))
                .temperature(0.7)
                .safe_prompt(true)
                .random_seed(42)
                .build();

        assertEquals("mistral-small", request.model());
        assertEquals(1, request.messages().size());
        assertEquals("user", request.messages().get(0).role());
        assertEquals("Hello", request.messages().get(0).content());
        assertEquals(0.7, request.temperature());
        assertTrue(request.safe_prompt());
        assertEquals(42, request.random_seed());
    }

    @Test
    void testToolChoiceBuilder() {
        ChatMessage message = ChatMessage.builder()
                .role("user")
                .content("What is the weather?")
                .build();

        Tool tool = Tool.builder()
                .function(Function.builder()
                        .name("get_weather")
                        .parameters(Map.of("type", "object"))
                        .build())
                .build();

        ChatRequest request = ChatRequest.builder()
                .model("mistral-large")
                .messages(List.of(message))
                .tools(List.of(tool))
                .tool_choice(ToolChoiceEnum.AUTO)
                .build();

        assertEquals(1, request.tools().size());
        assertEquals("get_weather", request.tools().get(0).function().name());
        assertEquals(ToolChoiceEnum.AUTO, request.tool_choice());
    }
}
