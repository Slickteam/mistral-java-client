package fr.slickteam.mistralai.client.model;

import java.util.List;

public record BatchJobsOut(
    List<BatchJobOut> data,
    String object,
    Integer total
) {}
