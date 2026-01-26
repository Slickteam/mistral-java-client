package fr.slickteam.mistralai.client.models;

public class Prediction {

    private String type = "content";

    private Object content;

    public Prediction() {
    }

    public Prediction(String type, Object content) {
        this.type = type;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Prediction{" +
                "type='" + type + '\'' +
                ", content=" + content +
                '}';
    }
}
