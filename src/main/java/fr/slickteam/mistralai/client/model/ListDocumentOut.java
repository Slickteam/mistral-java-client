package fr.slickteam.mistralai.client.model;

import java.util.List;

public record ListDocumentOut(
    PaginationInfo pagination,
    List<DocumentOut> data
) {}
