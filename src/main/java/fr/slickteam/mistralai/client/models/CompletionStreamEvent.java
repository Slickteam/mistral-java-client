package fr.slickteam.mistralai.client.models;

import java.util.List;

public class CompletionStreamEvent {
    public String id;
    public String object;
    public long created;
    public String model;
    public List<CompletionStreamChoice> choices;
}
