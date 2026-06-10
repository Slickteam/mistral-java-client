package fr.slickteam.mistralai.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Permission model for model access control.
 */
public class Permission {
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("object")
    private String object;
    
    @JsonProperty("created")
    private long created;
    
    @JsonProperty("allow_create_engine")
    private boolean allowCreateEngine;
    
    @JsonProperty("allow_sampling")
    private boolean allowSampling;
    
    @JsonProperty("allow_logprobs")
    private boolean allowLogprobs;
    
    @JsonProperty("allow_search_indices")
    private boolean allowSearchIndices;
    
    @JsonProperty("allow_view")
    private boolean allowView;
    
    @JsonProperty("allow_fine_tuning")
    private boolean allowFineTuning;
    
    @JsonProperty("organization")
    private String organization;
    
    @JsonProperty("group")
    private String group;
    
    @JsonProperty("is_blocking")
    private boolean isBlocking;
    
    /**
     * Default constructor for Jackson deserialization
     */
    public Permission() {
    }
    
    /**
     * Gets the unique identifier of the permission.
     *
     * @return The permission identifier
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the permission.
     *
     * @param id The permission identifier
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the object type.
     *
     * @return The object type
     */
    public String getObject() {
        return object;
    }

    /**
     * Sets the object type.
     *
     * @param object The object type
     */
    public void setObject(String object) {
        this.object = object;
    }

    /**
     * Gets the creation timestamp.
     *
     * @return The creation timestamp
     */
    public long getCreated() {
        return created;
    }

    /**
     * Sets the creation timestamp.
     *
     * @param created The creation timestamp
     */
    public void setCreated(long created) {
        this.created = created;
    }

    /**
     * Checks if engine creation is allowed.
     *
     * @return True if engine creation is allowed, false otherwise
     */
    public boolean isAllowCreateEngine() {
        return allowCreateEngine;
    }

    /**
     * Sets whether engine creation is allowed.
     *
     * @param allowCreateEngine True if engine creation is allowed, false otherwise
     */
    public void setAllowCreateEngine(boolean allowCreateEngine) {
        this.allowCreateEngine = allowCreateEngine;
    }

    /**
     * Checks if sampling is allowed.
     *
     * @return True if sampling is allowed, false otherwise
     */
    public boolean isAllowSampling() {
        return allowSampling;
    }

    /**
     * Sets whether sampling is allowed.
     *
     * @param allowSampling True if sampling is allowed, false otherwise
     */
    public void setAllowSampling(boolean allowSampling) {
        this.allowSampling = allowSampling;
    }

    /**
     * Checks if log probabilities are allowed.
     *
     * @return True if log probabilities are allowed, false otherwise
     */
    public boolean isAllowLogprobs() {
        return allowLogprobs;
    }

    /**
     * Sets whether log probabilities are allowed.
     *
     * @param allowLogprobs True if log probabilities are allowed, false otherwise
     */
    public void setAllowLogprobs(boolean allowLogprobs) {
        this.allowLogprobs = allowLogprobs;
    }

    /**
     * Checks if search indices are allowed.
     *
     * @return True if search indices are allowed, false otherwise
     */
    public boolean isAllowSearchIndices() {
        return allowSearchIndices;
    }

    /**
     * Sets whether search indices are allowed.
     *
     * @param allowSearchIndices True if search indices are allowed, false otherwise
     */
    public void setAllowSearchIndices(boolean allowSearchIndices) {
        this.allowSearchIndices = allowSearchIndices;
    }

    /**
     * Checks if viewing is allowed.
     *
     * @return True if viewing is allowed, false otherwise
     */
    public boolean isAllowView() {
        return allowView;
    }

    /**
     * Sets whether viewing is allowed.
     *
     * @param allowView True if viewing is allowed, false otherwise
     */
    public void setAllowView(boolean allowView) {
        this.allowView = allowView;
    }

    /**
     * Checks if fine-tuning is allowed.
     *
     * @return True if fine-tuning is allowed, false otherwise
     */
    public boolean isAllowFineTuning() {
        return allowFineTuning;
    }

    /**
     * Sets whether fine-tuning is allowed.
     *
     * @param allowFineTuning True if fine-tuning is allowed, false otherwise
     */
    public void setAllowFineTuning(boolean allowFineTuning) {
        this.allowFineTuning = allowFineTuning;
    }

    /**
     * Gets the organization associated with the permission.
     *
     * @return The organization identifier
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * Sets the organization associated with the permission.
     *
     * @param organization The organization identifier
     */
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    /**
     * Gets the group associated with the permission.
     *
     * @return The group identifier
     */
    public String getGroup() {
        return group;
    }

    /**
     * Sets the group associated with the permission.
     *
     * @param group The group identifier
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * Checks if the permission is blocking.
     *
     * @return True if the permission is blocking, false otherwise
     */
    public boolean isBlocking() {
        return isBlocking;
    }

    /**
     * Sets whether the permission is blocking.
     *
     * @param isBlocking True if the permission is blocking, false otherwise
     */
    public void setBlocking(boolean isBlocking) {
        this.isBlocking = isBlocking;
    }
}