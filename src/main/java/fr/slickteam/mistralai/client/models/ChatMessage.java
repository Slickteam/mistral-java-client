package fr.slickteam.mistralai.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Represents a message in a chat, typically exchanged between a user and a system or among users.
 * Each message includes details about the role of the sender, the message content, and optionally, the sender's name.
 */
public class ChatMessage {

    /**
     * Represents the role of the sender in the context of a chat message.
     * <p>
     * Possible values may include identifiers such as "user", "system", or other
     * role-specific designations that define the sender's purpose or function
     * within the conversation. This field helps in distinguishing the context
     * and source of the message.
     */
    private String role;

    /**
     * Represents the textual content of a chat message.
     * This field contains the primary message body, which is typically the actual
     * user input, response, or any conversational content being exchanged.
     */
    private List<ChatMessageContent> content;

    /**
     * Represents the optional name or identifier of the sender of the chat message.
     * This field is typically used to provide additional context or to identify
     * the specific sender in cases where the role alone is not sufficient.
     * For example, it can be used to display a user's name in a chat interface.
     */
    private String name;

    /**
     * Represents tool interactions or calls associated with a chat message.
     * <p>
     * This field captures any tool-related operations or invocations
     * that are relevant to the content or context of the chat message.
     * It can be used to track or log tool usage within the conversation flow.
     */
    @JsonProperty("tool_calls")
    private String toolCalls;

    public ChatMessage() {
    }

    public ChatMessage(String role, List<ChatMessageContent> content, String name, String toolCalls) {
        this.role = role;
        this.content = content;
        this.name = name;
        this.toolCalls = toolCalls;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<ChatMessageContent> getContent() {
        return content;
    }

    public void setContent(List<ChatMessageContent> content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToolCalls() {
        return toolCalls;
    }

    public void setToolCalls(String toolCalls) {
        this.toolCalls = toolCalls;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "role='" + role + '\'' +
                ", content='" + content + '\'' +
                ", name='" + name + '\'' +
                ", tool_calls='" + toolCalls + '\'' +
                '}';
    }
}
