package ai.framework.generator.framework;

import ai.framework.generator.Generator;
import ai.framework.model.FrameworkProject;
import ai.framework.model.GeneratedFile;

public class BasePageGeneratorV3 implements Generator {

    @Override
    public void generate(FrameworkProject project) throws Exception {

        StringBuilder code = new StringBuilder();

        code.append("package framework;\n\n");

        code.append("import org.openqa.selenium.WebDriver;\n");
        code.append("import org.openqa.selenium.WebElement;\n\n");

        code.append("public class BasePage {\n\n");

        code.append("    protected WebDriver driver;\n\n");

        code.append("    public BasePage(WebDriver driver) {\n");
        code.append("        this.driver = driver;\n");
        code.append("    }\n\n");

        code.append("    protected void type(WebElement element, String value) {\n");
        code.append("        element.clear();\n");
        code.append("        element.sendKeys(value);\n");
        code.append("    }\n\n");

        code.append("}\n");

        GeneratedFile file = new GeneratedFile(
                "framework",
                "BasePage.java",
                code.toString());

        project.addFile(file);

    }

}