package fr.slickteam.mistralai.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.slickteam.mistralai.client.model.Usage;

import java.io.IOException;
import java.util.List;

public class FIMCompletionResponse {
    @JsonProperty("id")
    private String id;

    @JsonProperty("object")
    private String object;

    @JsonProperty("created")
    private long created;

    @JsonProperty("model")
    private String model;

    @JsonProperty("choices")
    private List<FIMCompletionChoice> choices;

    @JsonProperty("usage")
    private Usage usage;

    /**
     * Default constructor for Jackson deserialization
     */
    public FIMCompletionResponse() {
    }

    /**
     * Parses a JSON string into a FIMCompletionResponse using Jackson
     *
     * @param json The JSON string to parse
     * @return A FIMCompletionResponse object
     * @throws IOException If there's an error parsing the JSON
     */
    public static FIMCompletionResponse parseResponse(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, FIMCompletionResponse.class);
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<FIMCompletionChoice> getChoices() {
        return choices;
    }

    public void setChoices(List<FIMCompletionChoice> choices) {
        this.choices = choices;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }
}
