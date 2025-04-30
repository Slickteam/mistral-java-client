package fr.slickteam.mistralai.client.models;

import java.util.List;

/**
 * Represents a streaming event response for a chat completion process.
 * This class is utilized to parse and store the response data returned from a
 * streaming chat API, including metadata about the event, the model producing
 * the response, and the list of choices provided in the completion result.
 */
public class ChatCompletionStreamEvent {

    /**
     * Unique identifier for the streaming chat completion event.
     * This ID is primarily used to trace and reference specific
     * events during the completion process and is typically
     * provided by the streaming chat API.
     */
    private String id;

    /**
     * Represents the type of this object or entity.
     * Typically used to identify the category or kind of response/data
     * within the context of streaming chat completion events.
     */
    private String object;

    /**
     * Timestamp indicating when the chat completion streaming event was created.
     * Represented as the number of seconds since the Unix epoch (January 1, 1970, 00:00:00 UTC).
     */
    private long created;

    /**
     * The identifier of the machine learning model used to generate the chat completion results.
     * This field represents the name or version of the model being utilized in the process.
     */
    private String model;

    /**
     * Represents a list of choices or responses generated during a streaming chat completion process.
     * Each choice corresponds to a partial or complete response from the chat model, providing details
     * such as text content, finish reason, and incremental updates in a streaming session.
     */
    private List<ChatCompletionStreamChoice> choices;

    public ChatCompletionStreamEvent() {
    }

    public ChatCompletionStreamEvent(String id, String object, long created, String model, List<ChatCompletionStreamChoice> choices) {
        this.id = id;
        this.object = object;
        this.created = created;
        this.model = model;
        this.choices = choices;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<ChatCompletionStreamChoice> getChoices() {
        return choices;
    }

    public void setChoices(List<ChatCompletionStreamChoice> choices) {
        this.choices = choices;
    }

    @Override
    public String toString() {
        return "ChatCompletionStreamEvent{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", created=" + created +
                ", model='" + model + '\'' +
                ", choices=" + choices +
                '}';
    }

}
