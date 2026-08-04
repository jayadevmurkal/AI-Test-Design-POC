package ai.framework.generator.framework;

import ai.framework.generator.Generator;
import ai.framework.model.FrameworkProject;
import ai.framework.model.GeneratedFile;

public class PageGeneratorV3 implements Generator {

    private GeneratedFile generatedFile;

    @Override
    public void generate(FrameworkProject project) throws Exception {

        StringBuilder code = new StringBuilder();

        buildPackage(code);
        buildImports(code);
        buildClassStart(code);
        buildLocators(code);
        buildConstructor(code);
        buildActions(code);
        buildClassEnd(code);

        generatedFile = new GeneratedFile(
                "framework",
                "SamplePage.java",
                code.toString());
    }

    public GeneratedFile getGeneratedFile() {
        return generatedFile;
    }

    private void buildPackage(StringBuilder code) {

        code.append("package pages;\n\n");

    }

    private void buildImports(StringBuilder code) {

        code.append("import org.openqa.selenium.By;\n");
        code.append("import org.openqa.selenium.WebDriver;\n\n");

        code.append("import framework.BasePage;\n");
        code.append("import framework.WaitUtil;\n");
        code.append("import framework.LoggerUtil;\n\n");

    }

    private void buildClassStart(StringBuilder code) {

        code.append("public class SamplePage extends BasePage {\n\n");

    }

    private void buildLocators(StringBuilder code) {

        code.append("    // Page Locators\n\n");

        code.append("    private By sampleLocator = By.id(\"sample\");\n\n");

    }

    private void buildConstructor(StringBuilder code) {

        code.append("    public SamplePage(WebDriver driver) {\n");

        code.append("        super(driver);\n");

        code.append("    }\n\n");

    }

    private void buildActions(StringBuilder code) {

        code.append("    public void sampleAction() {\n\n");

        code.append("        click(sampleLocator);\n\n");

        code.append("    }\n\n");

    }

    private void buildClassEnd(StringBuilder code) {

        code.append("}\n");

    }

}