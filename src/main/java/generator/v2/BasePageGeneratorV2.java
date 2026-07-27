package generator.v2;

import config.FrameworkConstants;

import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.support.ui.WebDriverWait;
import generator.v2.GeneratorFileUtil;

public class BasePageGeneratorV2 {

    public static void generate() throws Exception {

        StringBuilder code = new StringBuilder();

        code.append("package framework;\n\n");

        code.append("import org.openqa.selenium.WebDriver;\n");
        code.append("import org.openqa.selenium.WebElement;\n\n");

        code.append("import framework.WaitUtil;\n\n");
        code.append("public class BasePage {\n\n");

        code.append("    protected WebDriver driver;\n");
        code.append("    protected WaitUtil waitUtil;\n\n");

        code.append("    public BasePage(WebDriver driver) {\n");
        code.append("        this.driver = driver;\n");

        code.append("        this.waitUtil = new WaitUtil(driver);\n");
        code.append("    }\n\n");

        code.append("    protected void type(WebElement element, String text) {\n");

        code.append("        waitUtil.waitForVisibility(element);\n");

        code.append("        element.clear();\n");

        code.append("        element.sendKeys(text);\n");

        code.append("    }\n\n");

        code.append("    protected void click(WebElement element) {\n");

        code.append("        waitUtil.waitForClickable(element);\n");

        code.append("        element.click();\n");

        code.append("    }\n\n");

        code.append("    protected String getText(WebElement element) {\n");

        code.append("        waitUtil.waitForVisibility(element);\n");

        code.append("        return element.getText();\n");

        code.append("    }\n\n");

        code.append("    protected boolean isDisplayed(WebElement element) {\n");
        code.append("        return element.isDisplayed();\n");
        code.append("    }\n\n");

        code.append("}\n");

        GeneratorFileUtil.writeFile(
                "framework",
                "BasePage.java",
                code.toString());

    }

}