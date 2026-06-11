package fr.slickteam.mistralai.client.model;

/**
 * Moderation result.
 * <p>
 * Used in moderation responses.
 */
public class ModerationResult {
    public boolean flagged;
    public ModerationCategories categories;
    public ModerationCategoryScores categoryScores;
}
