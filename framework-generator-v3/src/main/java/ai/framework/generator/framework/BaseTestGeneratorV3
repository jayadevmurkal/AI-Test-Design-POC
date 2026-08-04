package ai.framework.generator.framework;

import ai.framework.generator.Generator;
import ai.framework.model.FrameworkProject;
import ai.framework.model.GeneratedFile;

public class BaseTestGeneratorV3 implements Generator {

    @Override
    public void generate(FrameworkProject project) throws Exception {

        StringBuilder code = new StringBuilder();

        buildPackage(code);
        buildImports(code);
        buildClassStart(code);
        buildFields(code);
        buildMethods(code);
        buildClassEnd(code);

        GeneratedFile file = new GeneratedFile(
                "framework",
                "BaseTest.java",
                code.toString());

        project.addFile(file);
    }

    private void buildPackage(StringBuilder code) {

    code.append("package framework;\n\n");

    }

    private void buildImports(StringBuilder code) {

    code.append("import org.openqa.selenium.WebDriver;\n");

    code.append("import org.testng.annotations.AfterMethod;\n");
    code.append("import org.testng.annotations.BeforeMethod;\n\n");

    code.append("import config.ConfigReader;\n\n");

    }

    private void buildClassStart(StringBuilder code) {

    code.append("public class BaseTest {\n\n");

    }

    private void buildFields(StringBuilder code) {

    code.append("    protected WebDriver driver;\n");

    code.append("    protected WaitUtil waitUtil;\n\n");

    }

    private void buildMethods(StringBuilder code) {

        buildSetUp(code);
        buildTearDown(code);

    }

    private void buildSetUp(StringBuilder code) {

    code.append("    @BeforeMethod\n");

    code.append("    public void setUp() {\n\n");

    code.append("        DriverFactory.initDriver();\n\n");

    code.append("        driver = DriverFactory.getDriver();\n\n");

    code.append("        waitUtil = new WaitUtil(driver);\n\n");

    code.append("        driver.get(ConfigReader.get(\"url\"));\n\n");

    code.append("    }\n\n");

    }

    private void buildTearDown(StringBuilder code) {

    code.append("    @AfterMethod\n");

    code.append("    public void tearDown() {\n\n");

    code.append("        DriverFactory.quitDriver();\n\n");

    code.append("    }\n\n");

    }

    private void buildClassEnd(StringBuilder code) {

    code.append("}\n");

    }

}