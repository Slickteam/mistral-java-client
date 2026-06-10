package fr.slickteam.mistralai.client.model;

import java.util.List;

public record ListAgentsOut(
    List<Agent> data,
    String object
) {}
