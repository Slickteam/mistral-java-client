package fr.slickteam.mistralai.client.models;

public class FunctionCall {

    private String name;

    private Object arguments;

    public FunctionCall() {
    }

    public FunctionCall(String name, Object arguments) {
        this.name = name;
        this.arguments = arguments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getArguments() {
        return arguments;
    }

    public void setArguments(Object arguments) {
        this.arguments = arguments;
    }

    @Override
    public String toString() {
        return "FunctionCall{" +
                "name='" + name + '\'' +
                ", arguments=" + arguments +
                '}';
    }
}
