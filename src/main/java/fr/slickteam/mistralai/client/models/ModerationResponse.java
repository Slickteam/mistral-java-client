package fr.slickteam.mistralai.client.models;

import java.util.ArrayList;
import java.util.List;

import static fr.slickteam.mistralai.client.utils.JSONUtils.*;
import static fr.slickteam.mistralai.client.utils.JSONUtils.extractObject;
import static fr.slickteam.mistralai.client.utils.JSONUtils.extractValue;

public class ModerationResponse {
    public String id;
    public String model;
    public List<ModerationResult> results;

    public static ModerationResponse parseModerationResponse(String json) {
        ModerationResponse response = new ModerationResponse();
        response.id = extractValue(json, "id");
        response.model = extractValue(json, "model");

        // Parse results
        String resultsJson = extractArray(json, "results");
        if (resultsJson != null && !resultsJson.isEmpty()) {
            List<ModerationResult> results = new ArrayList<>();
            String[] resultEntries = resultsJson.split("\\{");
            for (int i = 1; i < resultEntries.length; i++) {
                String resultJson = "{" + resultEntries[i];
                int endIndex = resultJson.lastIndexOf("}");
                if (endIndex > 0) {
                    resultJson = resultJson.substring(0, endIndex + 1);
                    ModerationResult result = new ModerationResult();
                    result.flagged = Boolean.parseBoolean(extractValue(resultJson, "flagged"));

                    // Parse categories
                    String categoriesJson = extractObject(resultJson, "categories");
                    if (categoriesJson != null && !categoriesJson.isEmpty()) {
                        ModerationCategories categories = new ModerationCategories();
                        categories.sexual = Boolean.parseBoolean(extractValue(categoriesJson, "sexual"));
                        categories.hate = Boolean.parseBoolean(extractValue(categoriesJson, "hate"));
                        categories.harassment = Boolean.parseBoolean(extractValue(categoriesJson, "harassment"));
                        categories.selfHarm = Boolean.parseBoolean(extractValue(categoriesJson, "self-harm"));
                        categories.sexualMinors = Boolean.parseBoolean(extractValue(categoriesJson, "sexual/minors"));
                        categories.hateThreatening = Boolean.parseBoolean(extractValue(categoriesJson, "hate/threatening"));
                        categories.violenceGraphic = Boolean.parseBoolean(extractValue(categoriesJson, "violence/graphic"));
                        categories.selfHarmIntent = Boolean.parseBoolean(extractValue(categoriesJson, "self-harm/intent"));
                        categories.selfHarmInstructions = Boolean.parseBoolean(extractValue(categoriesJson, "self-harm/instructions"));
                        categories.harassmentThreatening = Boolean.parseBoolean(extractValue(categoriesJson, "harassment/threatening"));
                        categories.violence = Boolean.parseBoolean(extractValue(categoriesJson, "violence"));
                        result.categories = categories;
                    }

                    // Parse category scores
                    String scoresJson = extractObject(resultJson, "category_scores");
                    if (scoresJson != null && !scoresJson.isEmpty()) {
                        ModerationCategoryScores scores = new ModerationCategoryScores();
                        scores.sexual = Double.parseDouble(extractValue(scoresJson, "sexual"));
                        scores.hate = Double.parseDouble(extractValue(scoresJson, "hate"));
                        scores.harassment = Double.parseDouble(extractValue(scoresJson, "harassment"));
                        scores.selfHarm = Double.parseDouble(extractValue(scoresJson, "self-harm"));
                        scores.sexualMinors = Double.parseDouble(extractValue(scoresJson, "sexual/minors"));
                        scores.hateThreatening = Double.parseDouble(extractValue(scoresJson, "hate/threatening"));
                        scores.violenceGraphic = Double.parseDouble(extractValue(scoresJson, "violence/graphic"));
                        scores.selfHarmIntent = Double.parseDouble(extractValue(scoresJson, "self-harm/intent"));
                        scores.selfHarmInstructions = Double.parseDouble(extractValue(scoresJson, "self-harm/instructions"));
                        scores.harassmentThreatening = Double.parseDouble(extractValue(scoresJson, "harassment/threatening"));
                        scores.violence = Double.parseDouble(extractValue(scoresJson, "violence"));
                        result.categoryScores = scores;
                    }

                    results.add(result);
                }
            }
            response.results = results;
        }

        return response;
    }
}
