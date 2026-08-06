package ai.framework.generator.framework;

import ai.framework.generator.Generator;
import ai.framework.model.FrameworkProject;
import ai.framework.model.GeneratedFile;

public class PageGeneratorV3 implements Generator {

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

        GeneratedFile file = new GeneratedFile(
                "pages",
                "SamplePage.java",
                code.toString());

        project.addFile(file);
    }

    private void buildPackage(StringBuilder code) {

        code.append("package pages;\n\n");

    }

    private void buildImports(StringBuilder code) {

        code.append("import org.openqa.selenium.By;\n");
        code.append("import org.openqa.selenium.WebDriver;\n\n");

        code.append("import framework.BasePage;\n\n");

    }

    private void buildClassStart(StringBuilder code) {

        code.append("public class SamplePage extends BasePage {\n\n");

    }

    private void buildLocators(StringBuilder code) {

        code.append("    private final By pageHeading = By.tagName(\"h1\");\n\n");

    }

    private void buildConstructor(StringBuilder code) {

        code.append("    public SamplePage(WebDriver driver) {\n");
        code.append("        super(driver);\n");
        code.append("    }\n\n");

    }

    private void buildActions(StringBuilder code) {

        code.append("    public String getPageHeading() {\n\n");
        code.append("        return getText(pageHeading);\n\n");
        code.append("    }\n\n");

    }

    private void buildClassEnd(StringBuilder code) {

        code.append("}\n");

    }

}