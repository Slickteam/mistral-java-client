package fr.slickteam.mistralai.client.models;

import java.util.List;

/**
 * Represents a request for chat moderation, which typically includes a list of chat messages
 * and the specific model to be used for processing the moderation task.
 */
public class ChatModerationRequest {

    /**
     * Represents a list of chat messages exchanged in a conversation.
     * Each message is represented by an instance of the ChatMessage class,
     * which includes details such as the sender's role, the message content,
     * and optionally, the sender's name.
     *
     * This field is typically used to provide a sequence of messages for
     * processing or moderation tasks, where the context of the conversation
     * is important for the application or system behavior.
     */
    private List<ChatMessage> messages;

    /**
     * Specifies the unique identifier of the model to be used for processing chat moderation requests.
     *
     * This field determines the configuration and behavior of the model that processes
     * the moderation task, which typically involves analyzing and filtering chat messages.
     */
    private String model;

    public ChatModerationRequest() {
    }

    public ChatModerationRequest(List<ChatMessage> messages, String model) {
        this.messages = messages;
        this.model = model;
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatMessage> messages) {
        this.messages = messages;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "ChatModerationRequest{" +
                "messages=" + messages +
                ", model='" + model + '\'' +
                '}';
    }

}
