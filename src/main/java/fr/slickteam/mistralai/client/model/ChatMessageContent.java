package fr.slickteam.mistralai.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChatMessageContent {

    private String type;

    private String text;

    @JsonProperty("document_url")
    private String documentUrl;

    public ChatMessageContent() {
    }

    public ChatMessageContent(String type, String text, String documentUrl) {
        this.type = type;
        this.text = text;
        this.documentUrl = documentUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDocumentUrl() {
        return documentUrl;
    }

    public void setDocumentUrl(String documentUrl) {
        this.documentUrl = documentUrl;
    }

    @Override
    public String toString() {
        return "ChatMessageContent{" +
                "type='" + type + '\'' +
                ", text='" + text + '\'' +
                ", documentUrl='" + documentUrl + '\'' +
                '}';
    }
}
