package fr.slickteam.mistralai.client.models;

import fr.slickteam.mistralai.client.type.ToolTypes;

public class ToolChoice {

    private ToolTypes type = ToolTypes.FUNCTION;

    private FunctionName function;

    public ToolChoice() {
    }

    public ToolChoice(ToolTypes type, FunctionName function) {
        this.type = type;
        this.function = function;
    }

    public ToolTypes getType() {
        return type;
    }

    public void setType(ToolTypes type) {
        this.type = type;
    }

    public FunctionName getFunction() {
        return function;
    }

    public void setFunction(FunctionName function) {
        this.function = function;
    }

    @Override
    public String toString() {
        return "ToolChoice{" +
                "type=" + type +
                ", function=" + function +
                '}';
    }
}
