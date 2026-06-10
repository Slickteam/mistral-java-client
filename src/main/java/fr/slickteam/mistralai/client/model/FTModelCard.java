package fr.slickteam.mistralai.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a fine-tuned model card with metadata and capabilities.
 * Extends BaseModelCard with additional fine-tuning specific fields.
 */
public class FTModelCard extends BaseModelCard {

    /**
     * The job identifier associated with the fine-tuning process.
     */
    @JsonProperty("job")
    private String job;

    /**
     * The root model that was fine-tuned.
     */
    @JsonProperty("root")
    private String root;

    /**
     * Indicates if the model is archived.
     */
    @JsonProperty("archived")
    private boolean archived;

    /**
     * Default constructor for Jackson deserialization
     */
    public FTModelCard() {
        super();
    }

    /**
     * Constructor with required fields for fine-tuned models
     */
    public FTModelCard(String id, String object, String type, String created, String owner, ModelProperties properties, String job, String root) {
        super(id, object, type, created, owner, properties);
        this.job = job;
        this.root = root;
        this.setType("fine-tuned");
    }

    // Getters and setters
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }
}
