package fr.slickteam.mistralai.client.models;

public class JsonSchema {

    private String name;

    private String description;

    private Object schema;

    private boolean strict;

    public JsonSchema() {
    }

    public JsonSchema(String name, String description, Object schema, boolean strict) {
        this.name = name;
        this.description = description;
        this.schema = schema;
        this.strict = strict;
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

    public Object getSchema() {
        return schema;
    }

    public void setSchema(Object schema) {
        this.schema = schema;
    }

    public boolean isStrict() {
        return strict;
    }

    public void setStrict(boolean strict) {
        this.strict = strict;
    }

    @Override
    public String toString() {
        return "JsonSchema{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", schema=" + schema +
                ", strict=" + strict +
                '}';
    }
}
