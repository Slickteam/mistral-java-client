package fr.slickteam.mistralai.client.model;

/**
 * Moderation category scores.
 * <p>
 * Used in moderation responses to indicate severity scores per category.
 */
public class ModerationCategoryScores {
    public double sexual;
    public double hate;
    public double harassment;
    public double selfHarm;
    public double sexualMinors;
    public double hateThreatening;
    public double violenceGraphic;
    public double selfHarmIntent;
    public double selfHarmInstructions;
    public double harassmentThreatening;
    public double violence;
}
