package fr.slickteam.mistralai.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Represents a message in a chat, typically exchanged between a user and a system or among users.
 * Each message includes details about the role of the sender, the message content, and optionally, the sender's name.
 */
public class ChatMessageResponse {

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
    private String content;

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
    private List<ToolCall> toolCalls;

    public ChatMessageResponse() {
    }

    public ChatMessageResponse(String role, String content, String name, List<ToolCall> toolCalls) {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ToolCall> getToolCalls() {
        return toolCalls;
    }

    public void setToolCalls(List<ToolCall> toolCalls) {
        this.toolCalls = toolCalls;
    }

    @Override
    public String toString() {
        return "ChatMessageResponse{" +
                "role='" + role + '\'' +
                ", content='" + content + '\'' +
                ", name='" + name + '\'' +
                ", toolCalls=" + toolCalls +
                '}';
    }
}
