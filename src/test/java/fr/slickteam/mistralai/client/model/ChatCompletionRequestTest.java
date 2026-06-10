package fr.slickteam.mistralai.client.model;

import fr.slickteam.mistralai.client.model.*;
import fr.slickteam.mistralai.client.type.MistralPromptMode;
import fr.slickteam.mistralai.client.type.ResponseFormats;
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
                "Hello",
                null,
                null,
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
        req.setResponseFormat(new ResponseFormat(ResponseFormats.JSON_OBJECT, null));

        // New fields
        req.setN(1);
        req.setPresencePenalty(0.1);
        req.setFrequencyPenalty(0.1);
        req.setParallelToolCalls(true);
        req.setPromptMode(MistralPromptMode.REASONING);
        req.setMetadata(Map.of("key", "value"));

        Tool tool = new Tool(ToolTypes.FUNCTION, new Function("func", "desc", null, null));
        req.setTools(List.of(tool));
        req.setToolChoice("auto");

        assertEquals("mistral-small-latest", req.getModel());
        assertNotNull(req.getMessages());
        assertEquals(1, req.getMessages().size());
        assertEquals("user", req.getMessages().get(0).role());
        assertEquals("Hello", req.getMessages().get(0).content());
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
        assertEquals(ToolTypes.FUNCTION, req.getTools().get(0).type());
        assertEquals("func", req.getTools().get(0).function().name());
        assertEquals("auto", req.getToolChoice());
    }
}
