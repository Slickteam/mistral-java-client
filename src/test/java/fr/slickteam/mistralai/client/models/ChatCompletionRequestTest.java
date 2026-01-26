package fr.slickteam.mistralai.client.models;

import fr.slickteam.mistralai.client.type.MistralPromptMode;
import fr.slickteam.mistralai.client.type.ResponseFormatType;
import fr.slickteam.mistralai.client.type.ToolTypes;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ChatCompletionRequestTest {
    @Test
    void settersAndGetters_shouldRoundTrip() {
        ChatCompletionRequest req = new ChatCompletionRequest();
        req.setModel("mistral-small-latest");
        req.setMessages(List.of(new ChatMessage(
                "user",
                List.of(new ChatMessageContent("text", "Hello", null)),
                null,
                null
        )));
        req.setTemperature(0.2);
        req.setMaxTokens(128);
        req.setTopP(0.9);
        req.setRandomSeed(42);
        req.setStream(false);
        req.setSafePrompt(true);
        req.setStop(List.of("\n\n"));
        req.setResponseFormat(new ResponseFormat(ResponseFormatType.JSON_OBJECT, null));

        // New fields
        req.setN(1);
        req.setPresencePenalty(0.1);
        req.setFrequencyPenalty(0.1);
        req.setParallelToolCalls(true);
        req.setPromptMode(MistralPromptMode.REASONING);
        req.setMetadata(Map.of("key", "value"));
        
        Tool tool = new Tool(ToolTypes.FUNCTION.getValue(), new Function("func", "desc", Map.of("p", "v")));
        req.setTools(List.of(tool));
        req.setToolChoice("auto");

        assertEquals("mistral-small-latest", req.getModel());
        assertNotNull(req.getMessages());
        assertEquals(1, req.getMessages().size());
        assertEquals(0.2, req.getTemperature());
        assertEquals(128, req.getMaxTokens());
        assertEquals(0.9, req.getTopP());
        assertEquals(42, req.getRandomSeed());
        assertFalse(req.getStream());
        assertTrue(req.getSafePrompt());
        assertEquals(List.of("\n\n"), req.getStop());
        assertNotNull(req.getResponseFormat());
        
        assertEquals(1, req.getN());
        assertEquals(0.1, req.getPresencePenalty());
        assertEquals(0.1, req.getFrequencyPenalty());
        assertTrue(req.getParallelToolCalls());
        assertEquals(MistralPromptMode.REASONING, req.getPromptMode());
        assertEquals("value", req.getMetadata().get("key"));
        assertEquals(1, req.getTools().size());
        assertEquals("auto", req.getToolChoice());
    }
}
