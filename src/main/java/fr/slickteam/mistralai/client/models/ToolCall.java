package fr.slickteam.mistralai.client.models;

import fr.slickteam.mistralai.client.type.ToolTypes;

public class ToolCall {

    private String id;

    private ToolTypes type = ToolTypes.FUNCTION;

    private FunctionCall function;

    private Integer index = 0;

    public ToolCall() {
    }

    public ToolCall(String id, ToolTypes type, FunctionCall function, Integer index) {
        this.id = id;
        this.type = type;
        this.function = function;
        this.index = index;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ToolTypes getType() {
        return type;
    }

    public void setType(ToolTypes type) {
        this.type = type;
    }

    public FunctionCall getFunction() {
        return function;
    }

    public void setFunction(FunctionCall function) {
        this.function = function;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "ToolCall{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", function=" + function +
                ", index=" + index +
                '}';
    }
}
