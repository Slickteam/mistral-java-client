package fr.slickteam.mistralai.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record WandbIntegration(
    String type,
    String project,
    String name,
    String api_key,
    String run_name
) {}
