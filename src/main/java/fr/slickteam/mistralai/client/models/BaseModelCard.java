package fr.slickteam.mistralai.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents a base model card with metadata and capabilities.
 */
public class BaseModelCard {

    /**
     * The unique identifier of the model.
     */
    @JsonProperty("id")
    private String id;

    /**
     * The object type.
     */
    @JsonProperty("object")
    private String object;

    /**
     * The timestamp when the model was created.
     */
    @JsonProperty("created")
    private long created;

    /**
     * The owner of the model.
     */
    @JsonProperty("owned_by")
    private String ownedBy;

    /**
     * The capabilities of the model.
     */
    @JsonProperty("capabilities")
    private ModelCapabilities capabilities;

    /**
     * The name of the model.
     */
    @JsonProperty("name")
    private String name;

    /**
     * The description of the model.
     */
    @JsonProperty("description")
    private String description;

    /**
     * The maximum context length supported by the model.
     */
    @JsonProperty("max_context_length")
    private int maxContextLength;

    /**
     * The aliases for the model.
     */
    @JsonProperty("aliases")
    private List<String> aliases;

    /**
     * The deprecation timestamp if the model is deprecated.
     */
    @JsonProperty("deprecation")
    private String deprecation;

    /**
     * The replacement model if this model is deprecated.
     */
    @JsonProperty("deprecation_replacement_model")
    private String deprecationReplacementModel;

    /**
     * The default temperature for the model.
     */
    @JsonProperty("default_model_temperature")
    private Double defaultModelTemperature;

    /**
     * The type of model (always "base" for base models).
     */
    @JsonProperty("type")
    private String type;

    /**
     * Default constructor for Jackson deserialization
     */
    public BaseModelCard() {
    }

    /**
     * Constructor with required fields
     */
    public BaseModelCard(String id, ModelCapabilities capabilities) {
        this.id = id;
        this.capabilities = capabilities;
        this.type = "base";
    }

    // Getters and setters
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

    public String getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(String ownedBy) {
        this.ownedBy = ownedBy;
    }

    public ModelCapabilities getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(ModelCapabilities capabilities) {
        this.capabilities = capabilities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxContextLength() {
        return maxContextLength;
    }

    public void setMaxContextLength(int maxContextLength) {
        this.maxContextLength = maxContextLength;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public String getDeprecation() {
        return deprecation;
    }

    public void setDeprecation(String deprecation) {
        this.deprecation = deprecation;
    }

    public String getDeprecationReplacementModel() {
        return deprecationReplacementModel;
    }

    public void setDeprecationReplacementModel(String deprecationReplacementModel) {
        this.deprecationReplacementModel = deprecationReplacementModel;
    }

    public Double getDefaultModelTemperature() {
        return defaultModelTemperature;
    }

    public void setDefaultModelTemperature(Double defaultModelTemperature) {
        this.defaultModelTemperature = defaultModelTemperature;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}