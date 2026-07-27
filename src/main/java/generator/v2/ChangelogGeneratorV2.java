package generator.v2;

public class ChangelogGeneratorV2 {

    public static void generate() throws Exception {

        StringBuilder code = new StringBuilder();

        code.append("# Changelog\n\n");

        code.append("All notable changes to this project will be documented here.\n\n");

        code.append("---\n\n");

        code.append("## Version 2.0\n\n");

        code.append("### Added\n\n");

        code.append("- AI JSON Reader\n");
        code.append("- Selenium Test Generator\n");
        code.append("- Page Object Generator\n");
        code.append("- Project Structure Generator\n");
        code.append("- Base Framework\n");
        code.append("- Driver Factory\n");
        code.append("- Wait Utility\n");
        code.append("- Screenshot Utility\n");
        code.append("- Logger Utility\n");
        code.append("- Config Reader\n");
        code.append("- Framework Version Generator\n");
        code.append("- README Generator\n");
        code.append("- Framework Architecture Generator\n");
        code.append("- GitIgnore Generator\n");
        code.append("- Maven Project Generator\n");
        code.append("- TestNG Generator\n");
        code.append("- Extent Report Integration\n");

        code.append("\n");

        code.append("### Status\n\n");

        code.append("- Stable Release\n");
        code.append("- Ready for GitHub\n");
        code.append("- Ready for Interview Demonstration\n");

        GeneratorFileUtil.writeFile(
                "",
                "FrameworkConstants.CHANGELOG_FILE",
                code.toString());
    }
}