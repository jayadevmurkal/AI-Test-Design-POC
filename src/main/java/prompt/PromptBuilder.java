package prompt;

public class PromptBuilder {

    public static String buildPrompt(String requirement) {

        return """
                Act as a Senior QA Architect.

                Analyze the following requirement and generate:

                [POSITIVE]
                List positive test cases.

                [NEGATIVE]
                List negative test cases.

                [EDGE]
                List edge test cases.

                [AUTOMATION]
                List automation candidates.

                [TEST_DATA]

                uniqueuser@example.com
                Password123!
                existinguser@example.com
                Pass1!

                IMPORTANT:

                Under [TEST_DATA]
                return ONLY raw values.

                Example:

                [TEST_DATA]
                uniqueuser@example.com
                Password123!
                existinguser@example.com
                Pass1!

                DO NOT write:
                Unique valid email address
                Valid password
                Existing email address

                IMPORTANT RULES:

                1. Return ONLY these sections.
                2. Do NOT add explanations.
                3. Do NOT add markdown.
                4. Do NOT add bullets.
                5. Every item must start on a new line.
                6. Use the exact section headers:
                [POSITIVE]
                [NEGATIVE]
                [EDGE]
                [AUTOMATION]
                [TEST_DATA]

                Requirement:
                """
                + requirement;
    }
}