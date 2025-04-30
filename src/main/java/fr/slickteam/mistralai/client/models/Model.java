package fr.slickteam.mistralai.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents a model with metadata and associated permissions.
 *
 */
public class Model {

    /**
     * Represents the unique identifier of the model instance.
     * This field is used for differentiating and uniquely identifying individual
     * model objects in the system.
     */
    @JsonProperty("id")
    private String id;

    /**
     * Represents the type or category of the model.
     * This field typically indicates the specific nature or classification
     * of the model object, such as its function, purpose, or role within
     * a broader system.
     */
    @JsonProperty("object")
    private String object;

    /**
     * Represents the timestamp when the Model was created.
     * This value is captured as the number of seconds since the epoch (1970-01-01T00:00:00Z),
     * commonly used to track the creation time of the model.
     */
    @JsonProperty("created")
    private long created;

    /**
     * Indicates the owner of the model.
     *
     * This field typically contains the identifier of the entity
     * (e.g., user, organization, or system) that owns or is responsible
     * for the associated model. It is used for determining permissions,
     * access control, and ownership metadata.
     */
    @JsonProperty("owned_by")
    private String ownedBy;

    /**
     * Represents the list of permissions associated with the model.
     *
     * Each permission defines specific access control rules and capabilities
     * for the model, such as the ability to create engines, perform sampling,
     * enable fine-tuning, and other operations.
     *
     * This list may include multiple `Permission` objects, each encapsulating
     * the access settings and attributes like creation time, organization,
     * and whether the permission is blocking.
     *
     * Permissions are used to manage and enforce security and access policies
     * at a granular level for different users, groups, or organizations.
     */
    @JsonProperty("permission")
    private List<Permission> permission;

    /**
     * Represents the root model associated with this instance.
     * This field is used to specify the name or identifier of the originating model,
     * providing a reference to its foundational or parent model structure.
     */
    @JsonProperty("root")
    private String root;

    /**
     * Represents the identifier of the parent model associated with the current model.
     * This field is used to link the current model with its parent in a hierarchical
     * structure or lineage, where applicable.
     */
    @JsonProperty("parent")
    private String parent;
    
    /**
     * Default constructor for Jackson deserialization
     */
    public Model() {
    }
    
    /**
     * Gets the unique identifier of the model instance.
     *
     * @return The model identifier
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the model instance.
     *
     * @param id The model identifier
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the type or category of the model.
     *
     * @return The object type
     */
    public String getObject() {
        return object;
    }

    /**
     * Sets the type or category of the model.
     *
     * @param object The object type
     */
    public void setObject(String object) {
        this.object = object;
    }

    /**
     * Gets the timestamp when the model was created.
     *
     * @return The creation timestamp
     */
    public long getCreated() {
        return created;
    }

    /**
     * Sets the timestamp when the model was created.
     *
     * @param created The creation timestamp
     */
    public void setCreated(long created) {
        this.created = created;
    }

    /**
     * Gets the owner of the model.
     *
     * @return The owner identifier
     */
    public String getOwnedBy() {
        return ownedBy;
    }

    /**
     * Sets the owner of the model.
     *
     * @param ownedBy The owner identifier
     */
    public void setOwnedBy(String ownedBy) {
        this.ownedBy = ownedBy;
    }

    /**
     * Gets the list of permissions associated with the model.
     *
     * @return The list of permissions
     */
    public List<Permission> getPermission() {
        return permission;
    }

    /**
     * Sets the list of permissions associated with the model.
     *
     * @param permission The list of permissions
     */
    public void setPermission(List<Permission> permission) {
        this.permission = permission;
    }

    /**
     * Gets the root model associated with this instance.
     *
     * @return The root model identifier
     */
    public String getRoot() {
        return root;
    }

    /**
     * Sets the root model associated with this instance.
     *
     * @param root The root model identifier
     */
    public void setRoot(String root) {
        this.root = root;
    }

    /**
     * Gets the identifier of the parent model associated with the current model.
     *
     * @return The parent model identifier
     */
    public String getParent() {
        return parent;
    }

    /**
     * Sets the identifier of the parent model associated with the current model.
     *
     * @param parent The parent model identifier
     */
    public void setParent(String parent) {
        this.parent = parent;
    }
}