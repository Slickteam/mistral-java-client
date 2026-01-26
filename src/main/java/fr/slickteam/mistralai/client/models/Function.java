package fr.slickteam.mistralai.client.models;

import java.util.Map;

public class Function {

    private String name;

    private String description = "";

    private Boolean strict = false;

    private Map<String, Object> parameters;

    public Function() {
    }

    public Function(String name, String description, Map<String, Object> parameters) {
        this.name = name;
        this.description = description;
        this.parameters = parameters;
    }

    public Function(String name, String description, Boolean strict, Map<String, Object> parameters) {
        this.name = name;
        this.description = description;
        this.strict = strict;
        this.parameters = parameters;
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

    public Boolean getStrict() {
        return strict;
    }

    public void setStrict(Boolean strict) {
        this.strict = strict;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "Function{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", strict=" + strict +
                ", parameters=" + parameters +
                '}';
    }

}
