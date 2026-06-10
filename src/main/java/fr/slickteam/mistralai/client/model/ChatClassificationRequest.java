package fr.slickteam.mistralai.client.model;

import java.util.List;

/**
 * Represents a request object for performing chat classification using a specified model.
 * This class encapsulates the messages to be classified and the model to be used for classification.
 * <p>
 * Fields:
 * - `messages`: A list of chat messages that serve as input for classification.
 * Each message contains information such as the role, content, and optionally the name
 * associated with the message.
 * - `model`: The identifier of the classification model to be used.
 * This specifies which underlying model configuration and parameters will process the messages.
 */
public class ChatClassificationRequest {

    /**
     * A list of chat messages that serve as input for classification.
     * Each message is represented by a `ChatMessage` object, which contains details
     * such as the role of the sender, the content of the message, and an optional name.
     * <p>
     * This field is essential for providing the textual data to be processed and
     * classified by the specified model in the request.
     */
    private List<ChatMessage> messages;

    /**
     * Identifier of the classification model to be used.
     * This specifies the model configuration and parameters that
     * will process the chat messages in the classification request.
     */
    private String model;
    /**
     * List of categories to classify the messages into.
     */
    private List<String> categories;

    public ChatClassificationRequest() {
    }

    public ChatClassificationRequest(List<ChatMessage> messages, String model) {
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

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "ChatClassificationRequest{" +
                "messages=" + messages +
                ", model='" + model + '\'' +
                ", categories=" + categories +
                '}';
    }

}
