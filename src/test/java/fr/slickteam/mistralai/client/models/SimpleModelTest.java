package fr.slickteam.mistralai.client.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Simple test class for the new model structures.
 */
public class SimpleModelTest {

    @Test
    public void testModelCapabilitiesCreation() {
        ModelCapabilities capabilities = new ModelCapabilities();
        
        // Test initial values (should be false by default)
        assertFalse(capabilities.isCompletionChat());
        assertFalse(capabilities.isFunctionCalling());
        assertFalse(capabilities.isCompletionFim());
        assertFalse(capabilities.isFineTuning());
        assertFalse(capabilities.isVision());
        assertFalse(capabilities.isClassification());
        
        // Test setting values
        capabilities.setCompletionChat(true);
        capabilities.setFunctionCalling(true);
        
        assertTrue(capabilities.isCompletionChat());
        assertTrue(capabilities.isFunctionCalling());
        assertFalse(capabilities.isCompletionFim());
    }

    @Test
    public void testBaseModelCardCreation() {
        ModelCapabilities capabilities = new ModelCapabilities();
        capabilities.setCompletionChat(true);
        
        BaseModelCard model = new BaseModelCard("test-id", capabilities);
        
        assertNotNull(model);
        assertEquals("test-id", model.getId());
        assertEquals("base", model.getType());
        assertEquals(capabilities, model.getCapabilities());
        assertTrue(model.getCapabilities().isCompletionChat());
    }

    @Test
    public void testFTModelCardCreation() {
        ModelCapabilities capabilities = new ModelCapabilities();
        capabilities.setCompletionChat(true);
        capabilities.setFunctionCalling(true);
        
        FTModelCard model = new FTModelCard("ft-test-id", capabilities, "job-123", "root-model");
        
        assertNotNull(model);
        assertEquals("ft-test-id", model.getId());
        assertEquals("fine-tuned", model.getType());
        assertEquals("job-123", model.getJob());
        assertEquals("root-model", model.getRoot());
        assertFalse(model.isArchived());
        assertEquals(capabilities, model.getCapabilities());
        assertTrue(model.getCapabilities().isCompletionChat());
        assertTrue(model.getCapabilities().isFunctionCalling());
    }

    @Test
    public void testModelListCreation() {
        ModelList modelList = new ModelList();
        
        assertNotNull(modelList);
        assertNull(modelList.getObject());
        assertNull(modelList.getData());
        
        modelList.setObject("list");
        assertEquals("list", modelList.getObject());
    }
}