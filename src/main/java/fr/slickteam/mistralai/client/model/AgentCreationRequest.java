package fr.slickteam.mistralai.client.model;

/**
 * Agent creation request.
 * <p>
 * Used in Mistral AI API operations.
 */


import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record AgentCreationRequest(
    String model,
    String name,
    String description,
    String instructions,
    List<Object> tools,
    List<GuardrailConfig> guardrails,
    List<String> handoffs,
    Map<String, Object> metadata,
    String version_message
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String model;
        private String name;
        private String description;
        private String instructions;
        private List<Object> tools;
        private List<GuardrailConfig> guardrails;
        private List<String> handoffs;
        private Map<String, Object> metadata;
        private String version_message;

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder instructions(String instructions) {
            this.instructions = instructions;
            return this;
        }

        public Builder tools(List<Object> tools) {
            this.tools = tools;
            return this;
        }

        public Builder guardrails(List<GuardrailConfig> guardrails) {
            this.guardrails = guardrails;
            return this;
        }

        public Builder handoffs(List<String> handoffs) {
            this.handoffs = handoffs;
            return this;
        }

        public Builder metadata(Map<String, Object> metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder version_message(String version_message) {
            this.version_message = version_message;
            return this;
        }

        public AgentCreationRequest build() {
            return new AgentCreationRequest(model, name, description, instructions, 
                tools, guardrails, handoffs, metadata, version_message);
        }
    }
}
