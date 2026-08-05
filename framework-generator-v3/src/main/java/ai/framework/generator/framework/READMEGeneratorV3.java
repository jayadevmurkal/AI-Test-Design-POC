package ai.framework.generator.framework;

import ai.framework.generator.Generator;
import ai.framework.model.FrameworkProject;
import ai.framework.model.GeneratedFile;

public class READMEGeneratorV3 implements Generator {

    private GeneratedFile generatedFile;

    @Override
    public void generate(FrameworkProject project) throws Exception {

        StringBuilder code = new StringBuilder();

        buildTitle(code);
        buildOverview(code);
        buildProjectStructure(code);
        buildExecutionSteps(code);

        generatedFile = new GeneratedFile(
                "",
                "README.md",
                code.toString());

    }

    public GeneratedFile getGeneratedFile() {
        return generatedFile;
    }

    private void buildTitle(StringBuilder code) {

        code.append("# Selenium Automation Framework\n\n");

    }

    private void buildOverview(StringBuilder code) {

        code.append("## Overview\n\n");

        code.append("This project is a Selenium Test Automation Framework generated using Framework Generator V3.\n\n");

        code.append(
                "The framework follows the Page Object Model (POM) design pattern and includes reusable utilities for browser management, reporting, logging, screenshots, waits, and configuration.\n\n");

    }

    private void buildProjectStructure(StringBuilder code) {

        code.append("## Project Structure\n\n");

        code.append("```text\n");

        code.append("src\n");
        code.append(" ├── framework\n");
        code.append(" ├── pages\n");
        code.append(" ├── tests\n");
        code.append(" ├── config\n");
        code.append(" └── resources\n");

        code.append("```\n\n");

    }

    private void buildExecutionSteps(StringBuilder code) {

        code.append("## Execute Tests\n\n");

        code.append("Run the following command:\n\n");

        code.append("```bash\n");

        code.append("mvn clean test\n");

        code.append("```\n\n");

        code.append("Reports will be generated automatically after execution.\n");

    }

}