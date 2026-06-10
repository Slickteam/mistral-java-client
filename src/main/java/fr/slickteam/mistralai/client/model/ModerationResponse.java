package fr.slickteam.mistralai.client.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public record ModerationResponse(
    String id,
    String model,
    List<ModerationObject> results
) {
    public static ModerationResponse parseModerationResponse(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, ModerationResponse.class);
    }
}
