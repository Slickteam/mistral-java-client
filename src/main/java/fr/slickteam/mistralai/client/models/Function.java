package fr.slickteam.mistralai.client.models;

public class Function {

    public String name;

    public String description;

    public String parameters;

    public Function() {
    }

    public Function(String name, String description, String parameters) {
        this.name = name;
        this.description = description;
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

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "Function{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", parameters='" + parameters + '\'' +
                '}';
    }

}
