package fr.slickteam.mistralai.client.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the new model structures.
 */
public class ModelTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testBaseModelCardDeserialization() throws Exception {
        String json = "{"
                + "\"id\":\"test-model-id\","
                + "\"object\":\"model\","
                + "\"created\":1234567890,"
                + "\"owned_by\":\"mistralai\","
                + "\"capabilities\":{"
                + "\"completion_chat\":true,"
                + "\"function_calling\":false,"
                + "\"completion_fim\":false,"
                + "\"fine_tuning\":false,"
                + "\"vision\":false,"
                + "\"classification\":false"
                + "},"
                + "\"name\":\"Test Model\","
                + "\"description\":\"A test model\","
                + "\"max_context_length\":32768,"
                + "\"aliases\":[\"alias1\",\"alias2\"],"
                + "\"deprecation\":null,"
                + "\"deprecation_replacement_model\":null,"
                + "\"default_model_temperature\":0.7,"
                + "\"type\":\"base\""
                + "}";

        BaseModelCard model = objectMapper.readValue(json, BaseModelCard.class);

        assertNotNull(model);
        assertEquals("test-model-id", model.getId());
        assertEquals("model", model.getObject());
        assertEquals(1234567890L, model.getCreated());
        assertEquals("mistralai", model.getOwnedBy());
        assertEquals("Test Model", model.getName());
        assertEquals("A test model", model.getDescription());
        assertEquals(32768, model.getMaxContextLength());
        assertEquals(2, model.getAliases().size());
        assertEquals(0.7, model.getDefaultModelTemperature());
        assertEquals("base", model.getType());

        ModelCapabilities capabilities = model.getCapabilities();
        assertNotNull(capabilities);
        assertTrue(capabilities.isCompletionChat());
        assertFalse(capabilities.isFunctionCalling());
        assertFalse(capabilities.isCompletionFim());
        assertFalse(capabilities.isFineTuning());
        assertFalse(capabilities.isVision());
        assertFalse(capabilities.isClassification());
    }

    @Test
    public void testFTModelCardDeserialization() throws Exception {
        String json = "{"
                + "\"id\":\"ft:test-model:12345\","
                + "\"object\":\"model\","
                + "\"created\":1234567890,"
                + "\"owned_by\":\"mistralai\","
                + "\"capabilities\":{"
                + "\"completion_chat\":true,"
                + "\"function_calling\":true,"
                + "\"completion_fim\":false,"
                + "\"fine_tuning\":false,"
                + "\"vision\":false,"
                + "\"classification\":false"
                + "},"
                + "\"name\":\"Fine-tuned Test Model\","
                + "\"description\":\"A fine-tuned test model\","
                + "\"max_context_length\":32768,"
                + "\"aliases\":[],"
                + "\"deprecation\":null,"
                + "\"deprecation_replacement_model\":null,"
                + "\"default_model_temperature\":null,"
                + "\"type\":\"fine-tuned\","
                + "\"job\":\"job-12345\","
                + "\"root\":\"open-mistral-7b\","
                + "\"archived\":false"
                + "}";

        FTModelCard model = objectMapper.readValue(json, FTModelCard.class);

        assertNotNull(model);
        assertEquals("ft:test-model:12345", model.getId());
        assertEquals("model", model.getObject());
        assertEquals(1234567890L, model.getCreated());
        assertEquals("mistralai", model.getOwnedBy());
        assertEquals("Fine-tuned Test Model", model.getName());
        assertEquals("A fine-tuned test model", model.getDescription());
        assertEquals(32768, model.getMaxContextLength());
        assertEquals(0, model.getAliases().size());
        assertNull(model.getDefaultModelTemperature());
        assertEquals("fine-tuned", model.getType());
        assertEquals("job-12345", model.getJob());
        assertEquals("open-mistral-7b", model.getRoot());
        assertFalse(model.isArchived());

        ModelCapabilities capabilities = model.getCapabilities();
        assertNotNull(capabilities);
        assertTrue(capabilities.isCompletionChat());
        assertTrue(capabilities.isFunctionCalling());
        assertFalse(capabilities.isCompletionFim());
        assertFalse(capabilities.isFineTuning());
        assertFalse(capabilities.isVision());
        assertFalse(capabilities.isClassification());
    }

    @Test
    public void testModelListDeserialization() throws Exception {
        String json = "{"
                + "\"object\":\"list\","
                + "\"data\":["
                + "{"
                + "\"id\":\"model-1\","
                + "\"object\":\"model\","
                + "\"created\":1234567890,"
                + "\"owned_by\":\"mistralai\","
                + "\"capabilities\":{"
                + "\"completion_chat\":true,"
                + "\"function_calling\":false,"
                + "\"completion_fim\":false,"
                + "\"fine_tuning\":false,"
                + "\"vision\":false,"
                + "\"classification\":false"
                + "},"
                + "\"name\":\"Model 1\","
                + "\"type\":\"base\""
                + "},"
                + "{"
                + "\"id\":\"ft:model-2:123\","
                + "\"object\":\"model\","
                + "\"created\":1234567891,"
                + "\"owned_by\":\"mistralai\","
                + "\"capabilities\":{"
                + "\"completion_chat\":true,"
                + "\"function_calling\":true,"
                + "\"completion_fim\":false,"
                + "\"fine_tuning\":false,"
                + "\"vision\":false,"
                + "\"classification\":false"
                + "},"
                + "\"name\":\"Fine-tuned Model 2\","
                + "\"type\":\"fine-tuned\","
                + "\"job\":\"job-123\","
                + "\"root\":\"open-mistral-7b\""
                + "}"
                + "]"
                + "}";

        ModelList modelList = objectMapper.readValue(json, ModelList.class);

        assertNotNull(modelList);
        assertEquals("list", modelList.getObject());
        assertNotNull(modelList.getData());
        assertEquals(2, modelList.getData().size());

        // First model should be a BaseModelCard
        BaseModelCard model1 = modelList.getData().get(0);
        assertEquals("model-1", model1.getId());
        assertEquals("base", model1.getType());

        // Second model should be a FTModelCard (but will be deserialized as BaseModelCard in the list)
        BaseModelCard model2 = modelList.getData().get(1);
        assertEquals("ft:model-2:123", model2.getId());
        assertEquals("fine-tuned", model2.getType());
    }

    @Test
    public void testModelCapabilities() {
        ModelCapabilities capabilities = new ModelCapabilities();
        capabilities.setCompletionChat(true);
        capabilities.setFunctionCalling(true);
        capabilities.setCompletionFim(false);
        capabilities.setFineTuning(false);
        capabilities.setVision(false);
        capabilities.setClassification(false);

        assertTrue(capabilities.isCompletionChat());
        assertTrue(capabilities.isFunctionCalling());
        assertFalse(capabilities.isCompletionFim());
        assertFalse(capabilities.isFineTuning());
        assertFalse(capabilities.isVision());
        assertFalse(capabilities.isClassification());
    }
}