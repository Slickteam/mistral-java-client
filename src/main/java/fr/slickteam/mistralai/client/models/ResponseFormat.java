package fr.slickteam.mistralai.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.slickteam.mistralai.client.type.ResponseFormatType;

public class ResponseFormat {

    /**
     * Default: "text"
     * Enum: "text" "json_object" "json_schema"
     * <p>
     * An object specifying the format that the model must output. Setting to { "type": "json_object" } enables JSON mode,
     * which guarantees the message the model generates is in JSON.
     * When using JSON mode you MUST also instruct the model to produce JSON yourself with a system or a user message.
     * </p>
     */
    private ResponseFormatType type;

    @JsonProperty("json_schema")
    private JsonSchema jsonSchema;

    public ResponseFormat() {
    }

    public ResponseFormat(ResponseFormatType type, JsonSchema jsonSchema) {
        this.type = type;
        this.jsonSchema = jsonSchema;
    }

    public ResponseFormatType getType() {
        return type;
    }

    public void setType(ResponseFormatType type) {
        this.type = type;
    }

    public JsonSchema getJsonSchema() {
        return jsonSchema;
    }

    public void setJsonSchema(JsonSchema jsonSchema) {
        this.jsonSchema = jsonSchema;
    }

    @Override
    public String toString() {
        return "ResponseFormat{" +
                "type='" + type + '\'' +
                ", jsonSchema=" + jsonSchema +
                '}';
    }

}
