package fr.slickteam.mistralai.client.model;

import java.util.List;

/**
 * Completion stream event.
 * <p>
 * Used in streaming completion responses.
 */
public class CompletionStreamEvent {
    public String id;
    public String object;
    public long created;
    public String model;
    public List<CompletionStreamChoice> choices;
}
