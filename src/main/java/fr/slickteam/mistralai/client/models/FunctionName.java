package fr.slickteam.mistralai.client.models;

public class FunctionName {

    private String name;

    public FunctionName() {
    }

    public FunctionName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FunctionName{" +
                "name='" + name + '\'' +
                '}';
    }
}
