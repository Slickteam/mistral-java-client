package fr.slickteam.mistralai.client.models.ocr;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

/**
 * Test class for the new OCR models.
 */
public class OCRTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testOCRRequestCreation() {
        OCRRequest request = new OCRRequest();
        request.setId("test-doc-id");
        request.setModel("ocr-model-v2");
        request.setPages(Arrays.asList(0, 1, 2));
        request.setIncludeImageBase64(true);
        request.setImageLimit(10);
        request.setImageMinSize(100);

        assertNotNull(request);
        assertEquals("test-doc-id", request.getId());
        assertEquals("ocr-model-v2", request.getModel());
        assertEquals(3, request.getPages().size());
        assertTrue(request.getIncludeImageBase64());
        assertEquals(10, request.getImageLimit());
        assertEquals(100, request.getImageMinSize());
    }

    @Test
    public void testOCRResponseCreation() {
        OCRResponse response = new OCRResponse();
        response.setModel("ocr-model-v2");
        response.setDocumentAnnotation("{\"format\":\"json\"}");

        OCRUsageInfo usageInfo = new OCRUsageInfo(2);
        usageInfo.setDocSizeBytes(1024);
        response.setUsageInfo(usageInfo);

        assertNotNull(response);
        assertEquals("ocr-model-v2", response.getModel());
        assertEquals("{\"format\":\"json\"}", response.getDocumentAnnotation());
        assertNotNull(response.getUsageInfo());
        assertEquals(2, response.getUsageInfo().getPagesProcessed());
        assertEquals(1024, response.getUsageInfo().getDocSizeBytes());
    }

    @Test
    public void testOCRPageObjectCreation() {
        OCRPageObject page = new OCRPageObject(0, "# Page Title\n\nThis is page content.");
        
        OCRPageDimensions dimensions = new OCRPageDimensions(300);
        dimensions.setWidth(800);
        dimensions.setHeight(1100);
        page.setDimensions(dimensions);
        
        page.setHeader("Document Header");
        page.setFooter("Document Footer");
        page.setHyperlinks(Arrays.asList("https://example.com", "https://mistral.ai"));

        assertNotNull(page);
        assertEquals(0, page.getIndex());
        assertEquals("# Page Title\n\nThis is page content.", page.getMarkdown());
        assertNotNull(page.getDimensions());
        assertEquals(300, page.getDimensions().getDpi());
        assertEquals(800, page.getDimensions().getWidth());
        assertEquals(1100, page.getDimensions().getHeight());
        assertEquals("Document Header", page.getHeader());
        assertEquals("Document Footer", page.getFooter());
        assertEquals(2, page.getHyperlinks().size());
    }

    @Test
    public void testOCRImageObjectCreation() {
        OCRImageObject image = new OCRImageObject("img-001", 100);
        image.setTopLeftY(200);
        image.setBottomRightX(500);
        image.setBottomRightY(600);
        image.setImageBase64("base64-encoded-image-data");
        image.setImageAnnotation("{\"format\":\"json\",\"type\":\"image\"}");

        assertNotNull(image);
        assertEquals("img-001", image.getId());
        assertEquals(100, image.getTopLeftX());
        assertEquals(200, image.getTopLeftY());
        assertEquals(500, image.getBottomRightX());
        assertEquals(600, image.getBottomRightY());
        assertEquals("base64-encoded-image-data", image.getImageBase64());
        assertEquals("{\"format\":\"json\",\"type\":\"image\"}", image.getImageAnnotation());
    }

    @Test
    public void testOCRTableObjectCreation() {
        OCRTableObject table = new OCRTableObject("table-001", "| Column 1 | Column 2 |\n|----------|----------|\n| Data 1 | Data 2 |", "markdown");

        assertNotNull(table);
        assertEquals("table-001", table.getId());
        assertEquals("| Column 1 | Column 2 |\n|----------|----------|\n| Data 1 | Data 2 |", table.getContent());
        assertEquals("markdown", table.getFormat());
    }

    @Test
    public void testResponseFormatCreation() {
        ResponseFormat format = new ResponseFormat("json_schema");
        format.setSchema("{\"type\":\"object\",\"properties\":{\"text\":{\"type\":\"string\"}}}");

        assertNotNull(format);
        assertEquals("json_schema", format.getType());
        assertEquals("{\"type\":\"object\",\"properties\":{\"text\":{\"type\":\"string\"}}}", format.getSchema());
    }

    @Test
    public void testOCRRequestSerialization() throws Exception {
        OCRRequest request = new OCRRequest("test-doc-123", "document-content");
        request.setModel("ocr-v2");
        request.setPages(Arrays.asList(0, 1));
        request.setIncludeImageBase64(true);

        String json = objectMapper.writeValueAsString(request);
        
        assertNotNull(json);
        assertTrue(json.contains("\"id\":\"test-doc-123\""));
        assertTrue(json.contains("\"model\":\"ocr-v2\""));
        assertTrue(json.contains("\"pages\":[0,1]"));
        assertTrue(json.contains("\"include_image_base64\":true"));
    }

    @Test
    public void testOCRResponseDeserialization() throws Exception {
        String json = "{"
                + "\"pages\":["
                + "{"
                + "\"index\":0,"
                + "\"markdown\":\"# Test Page\\n\\nContent here.\","
                + "\"images\":[],"
                + "\"tables\":[],"
                + "\"hyperlinks\":[\"https://example.com\"],"
                + "\"header\":\"Header\","
                + "\"footer\":\"Footer\","
                + "\"dimensions\":{\"dpi\":300,\"width\":800,\"height\":1100}"
                + "}"
                + "],"
                + "\"model\":\"ocr-v2\","
                + "\"document_annotation\":\"{\\\"format\\\":\\\"json\\\"}\","
                + "\"usage_info\":{\"pages_processed\":1,\"doc_size_bytes\":1024}"
                + "}";

        OCRResponse response = objectMapper.readValue(json, OCRResponse.class);
        
        assertNotNull(response);
        assertEquals("ocr-v2", response.getModel());
        assertEquals(1, response.getPages().size());
        assertEquals(0, response.getPages().get(0).getIndex());
        assertEquals("# Test Page\n\nContent here.", response.getPages().get(0).getMarkdown());
        assertEquals(1, response.getPages().get(0).getHyperlinks().size());
        assertNotNull(response.getUsageInfo());
        assertEquals(1, response.getUsageInfo().getPagesProcessed());
        assertEquals(1024, response.getUsageInfo().getDocSizeBytes());
    }
}