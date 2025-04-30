package fr.slickteam.mistralai.client.utils;

/**
 * Utility class for JSON operations.
 */
public class JSONUtils {

    /**
     * Extracts a value from a JSON string.
     *
     * @param json The JSON string
     * @param key The key to extract
     * @return The extracted value or empty string if not found
     */
    public static String extractValue(String json, String key) {
        // Very simple JSON extraction - use a proper JSON library in production
        String pattern = "\"" + key + "\"\\s*:\\s*\"?([^\",}]*)\"?";
        java.util.regex.Pattern r = java.util.regex.Pattern.compile(pattern);
        java.util.regex.Matcher m = r.matcher(json);
        if (m.find()) {
            return m.group(1);
        }
        return "";
    }

    /**
     * Extracts an array from a JSON string.
     *
     * @param json The JSON string
     * @param key The key to extract
     * @return The extracted array as a string or empty string if not found
     */
    public static String extractArray(String json, String key) {
        // Very simple JSON array extraction - use a proper JSON library in production
        String pattern = "\"" + key + "\"\\s*:\\s*(\\[.*?\\])";
        java.util.regex.Pattern r = java.util.regex.Pattern.compile(pattern, java.util.regex.Pattern.DOTALL);
        java.util.regex.Matcher m = r.matcher(json);
        if (m.find()) {
            return m.group(1);
        }
        return "";
    }

    /**
     * Extracts an object from a JSON string.
     *
     * @param json The JSON string
     * @param key The key to extract
     * @return The extracted object as a string or empty string if not found
     */
    public static String extractObject(String json, String key) {
        // Very simple JSON object extraction - use a proper JSON library in production
        String pattern = "\"" + key + "\"\\s*:\\s*(\\{.*?\\})";
        java.util.regex.Pattern r = java.util.regex.Pattern.compile(pattern, java.util.regex.Pattern.DOTALL);
        java.util.regex.Matcher m = r.matcher(json);
        if (m.find()) {
            return m.group(1);
        }
        return "";
    }

    public static String escapeJsonString(String input) {
        if (input == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (c) {
                case '\\':
                    result.append("\\\\");
                    break;
                case '\"':
                    result.append("\\\"");
                    break;
                case '\b':
                    result.append("\\b");
                    break;
                case '\f':
                    result.append("\\f");
                    break;
                case '\n':
                    result.append("\\n");
                    break;
                case '\r':
                    result.append("\\r");
                    break;
                case '\t':
                    result.append("\\t");
                    break;
                default:
                    result.append(c);
            }
        }
        return result.toString();
    }
}