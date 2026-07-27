package generator.v2;

public class GitIgnoreGeneratorV2 {

    public static void generate() throws Exception {

        StringBuilder code = new StringBuilder();

        code.append("# Maven\n");
        code.append("target/\n\n");

        code.append("# IntelliJ\n");
        code.append(".idea/\n");
        code.append("*.iml\n\n");

        code.append("# Eclipse\n");
        code.append(".classpath\n");
        code.append(".project\n");
        code.append(".settings/\n\n");

        code.append("# VS Code\n");
        code.append(".vscode/\n\n");

        code.append("# Reports\n");
        code.append("reports/\n");
        code.append("logs/\n");
        code.append("test-output/\n");
        code.append("screenshots/\n\n");

        code.append("# OS Files\n");
        code.append(".DS_Store\n");
        code.append("Thumbs.db\n");

        GeneratorFileUtil.writeFile(
                "",
                ".gitignore",
                code.toString());
    }
}