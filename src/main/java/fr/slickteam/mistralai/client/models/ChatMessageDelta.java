package fr.slickteam.mistralai.client.models;

/**
 * Represents a delta in a chat message, which encapsulates any changes or updates
 * made to a chat message. A delta typically includes the role of the sender
 * and the content of the message update.
 */
public class ChatMessageDelta {

    /**
     * Represents the role of the sender in the context of a chat message delta.
     * <p>
     * This field indicates the sender's type or responsibility in the chat,
     * such as "user" or "system." It is used to differentiate the origin
     * and purpose of the message within the chat flow. The role helps to
     * establish the context and enables appropriate handling or interpretation
     * of the message delta.
     */
    private String role;

    /**
     * Represents the textual content of a chat message.
     * This field contains the main message text, which typically includes user input,
     * system responses, or any other conversational updates or exchanges.
     */
    private String content;

    public ChatMessageDelta() {
    }

    public ChatMessageDelta(String role, String content) {
        this.role = role;
        this.content = content;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ChatMessageDelta{" +
                "role='" + role + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
