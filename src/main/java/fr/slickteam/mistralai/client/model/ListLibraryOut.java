package fr.slickteam.mistralai.client.model;

/**
 * List of libraries output.
 * <p>
 * Used in Mistral AI API operations.
 */


import java.util.List;

public record ListLibraryOut(
    List<LibraryOut> data
) {}
