package generator.v2;

public class GeneratorStringUtil {

    private GeneratorStringUtil() {
        // Utility class
    }

    public static String capitalize(String text) {

        if (text == null || text.isEmpty()) {
            return text;
        }

        return Character.toUpperCase(text.charAt(0))
                + text.substring(1);
    }

    public static String removeSuffix(String value, String suffix) {

        if (value.endsWith(suffix)) {
            return value.substring(0, value.length() - suffix.length());
        }

        return value;
    }

    public static String toMethodName(String scenario) {

        String cleaned = scenario
                .replaceAll("[^a-zA-Z0-9 ]", "")
                .trim();

        String[] words = cleaned.split("\\s+");

        StringBuilder method = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            if (i == 0) {

                method.append(word.substring(0, 1).toLowerCase())
                        .append(word.substring(1));

            } else {

                method.append(word.substring(0, 1).toUpperCase())
                        .append(word.substring(1));

            }
        }

        return method.toString();
    }
}