package generator.v2;

import config.FrameworkConstants;

public class WaitUtilityGeneratorV2 {

    public static void generate() throws Exception {

        StringBuilder code = new StringBuilder();

        buildPackage(code);
        buildImports(code);
        buildClassStart(code);
        buildFields(code);
        buildConstructor(code);
        buildVisibilityMethod(code);
        buildClickableMethod(code);
        buildTextMethod(code);
        buildInvisibilityMethod(code);
        buildClassEnd(code);

        writeFile(code);

        System.out.println("WaitUtil.java generated successfully.");
    }

    private static void buildPackage(StringBuilder code) {

        code.append("package framework;\n\n");

    }

    private static void buildImports(StringBuilder code) {

        code.append("import java.time.Duration;\n\n");

        code.append("import org.openqa.selenium.WebDriver;\n");
        code.append("import org.openqa.selenium.WebElement;\n");

        code.append("import org.openqa.selenium.support.ui.ExpectedConditions;\n");
        code.append("import org.openqa.selenium.support.ui.WebDriverWait;\n\n");

    }

    private static void buildClassStart(StringBuilder code) {

        code.append("public class WaitUtil {\n\n");

    }

    private static void buildFields(StringBuilder code) {

        code.append("    private WebDriver driver;\n");
        code.append("    private WebDriverWait wait;\n\n");

    }

    private static void buildConstructor(StringBuilder code) {

        code.append("    public WaitUtil(WebDriver driver) {\n\n");

        code.append("        this.driver = driver;\n");

        code.append("        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));\n");

        code.append("    }\n\n");

    }

    private static void buildVisibilityMethod(StringBuilder code) {

        code.append("    public WebElement waitForVisibility(WebElement element) {\n\n");

        code.append("        return wait.until(ExpectedConditions.visibilityOf(element));\n");

        code.append("    }\n\n");

    }

    private static void buildClickableMethod(StringBuilder code) {

        code.append("    public WebElement waitForClickable(WebElement element) {\n\n");

        code.append("        return wait.until(ExpectedConditions.elementToBeClickable(element));\n");

        code.append("    }\n\n");

    }

    private static void buildTextMethod(StringBuilder code) {

        code.append("    public boolean waitForText(WebElement element, String text) {\n\n");

        code.append("        return wait.until(ExpectedConditions.textToBePresentInElement(element, text));\n");

        code.append("    }\n\n");

    }

    private static void buildInvisibilityMethod(StringBuilder code) {

        code.append("    public boolean waitForInvisibility(WebElement element) {\n\n");

        code.append("        return wait.until(ExpectedConditions.invisibilityOf(element));\n");

        code.append("    }\n\n");

    }

    private static void buildClassEnd(StringBuilder code) {

        code.append("}\n");

    }

    private static void writeFile(StringBuilder code) throws Exception {

        GeneratorFileUtil.writeFile(
                "src/main/java/framework",
                "WaitUtil.java",
                code.toString());

    }
}