package ai.framework.generator.framework;

import ai.framework.generator.Generator;
import ai.framework.model.FrameworkProject;
import ai.framework.model.GeneratedFile;

public class READMEGeneratorV3 implements Generator {

    @Override
    public void generate(FrameworkProject project) throws Exception {

        StringBuilder code = new StringBuilder();

        buildTitle(code);
        buildOverview(code);
        buildProjectStructure(code);
        buildExecutionSteps(code);

        GeneratedFile file = new GeneratedFile(
                "",
                "README.md",
                code.toString());

        project.addFile(file);
    }

    private void buildTitle(StringBuilder code) {

        code.append("# Selenium Automation Framework\n\n");

    }

    private void buildOverview(StringBuilder code) {

        code.append("## Overview\n\n");

        code.append(
                "This project is a Selenium Test Automation Framework generated using Framework Generator V3.\n\n");

        code.append(
                "The framework follows the Page Object Model (POM) design pattern and includes reusable utilities for browser management, reporting, logging, screenshots, waits, and configuration.\n\n");

    }

    private void buildProjectStructure(StringBuilder code) {

        code.append("## Project Structure\n\n");

        code.append("```text\n");

        code.append("generated-output/\n");
        code.append("|-- config/\n");
        code.append("|   |-- config.properties\n");
        code.append("|   `-- ConfigReader.java\n");
        code.append("|\n");
        code.append("|-- framework/\n");
        code.append("|   |-- BasePage.java\n");
        code.append("|   |-- BaseTest.java\n");
        code.append("|   |-- DriverFactory.java\n");
        code.append("|   |-- ExtentListener.java\n");
        code.append("|   |-- ExtentManager.java\n");
        code.append("|   |-- ExtentTestManager.java\n");
        code.append("|   |-- LoggerUtil.java\n");
        code.append("|   |-- ScreenshotUtil.java\n");
        code.append("|   `-- WaitUtil.java\n");
        code.append("|\n");
        code.append("|-- pages/\n");
        code.append("|   `-- SamplePage.java\n");
        code.append("|\n");
        code.append("|-- tests/\n");
        code.append("|   `-- SampleTest.java\n");
        code.append("|\n");
        code.append("|-- pom.xml\n");
        code.append("|-- testng.xml\n");
        code.append("`-- README.md\n");

        code.append("```\n\n");

    }

    private void buildExecutionSteps(StringBuilder code) {

        code.append("## Execute Tests\n\n");

        code.append("Run the following command from the generated framework directory:\n\n");

        code.append("```bash\n");
        code.append("mvn clean test\n");
        code.append("```\n\n");

        code.append(
                "Extent reports will be generated inside the reports directory after execution.\n");

    }

}