package fr.slickteam.mistralai.client.model;

/**
 * List of documents output.
 * <p>
 * Used in Mistral AI API operations.
 */


import java.util.List;

public record ListDocumentOut(
    PaginationInfo pagination,
    List<DocumentOut> data
) {}
