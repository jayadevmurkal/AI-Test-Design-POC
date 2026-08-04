package ai.framework.generator.framework;

import ai.framework.generator.Generator;
import ai.framework.model.FrameworkProject;
import ai.framework.model.GeneratedFile;

public class WaitUtilGeneratorV3 implements Generator {

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
                "WaitUtil.java",
                code.toString());

        project.addFile(file);

    }

    private void buildPackage(StringBuilder code) {

        code.append("package framework;\n\n");

    }

    private void buildImports(StringBuilder code) {

        code.append("import java.time.Duration;\n\n");

        code.append("import org.openqa.selenium.WebDriver;\n");
        code.append("import org.openqa.selenium.WebElement;\n\n");

        code.append("import org.openqa.selenium.support.ui.ExpectedConditions;\n");
        code.append("import org.openqa.selenium.support.ui.WebDriverWait;\n\n");

    }

    private void buildClassStart(StringBuilder code) {

        code.append("public class WaitUtil {\n\n");

    }

    private void buildFields(StringBuilder code) {

        code.append("    private final WebDriverWait wait;\n\n");

        code.append("    public WaitUtil(WebDriver driver) {\n");
        code.append("        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));\n");
        code.append("    }\n\n");

    }

    private void buildMethods(StringBuilder code) {

        buildWaitForVisibility(code);
        buildWaitForClickable(code);
        buildWaitForTitle(code);

    }

    private void buildWaitForVisibility(StringBuilder code) {

        code.append("    public WebElement waitForVisibility(WebElement element) {\n\n");

        code.append("        return wait.until(ExpectedConditions.visibilityOf(element));\n\n");

        code.append("    }\n\n");

    }

    private void buildWaitForClickable(StringBuilder code) {

        code.append("    public WebElement waitForClickable(WebElement element) {\n\n");

        code.append("        return wait.until(ExpectedConditions.elementToBeClickable(element));\n\n");

        code.append("    }\n\n");

    }

    private void buildWaitForTitle(StringBuilder code) {

        code.append("    public boolean waitForTitle(String title) {\n\n");

        code.append("        return wait.until(ExpectedConditions.titleIs(title));\n\n");

        code.append("    }\n\n");

    }

    private void buildClassEnd(StringBuilder code) {

        code.append("}\n");

    }

}