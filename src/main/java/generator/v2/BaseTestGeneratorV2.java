package generator.v2;

import config.FrameworkConstants;

import java.io.File;
import java.io.FileWriter;

public class BaseTestGeneratorV2 {

    public static void generate() throws Exception {

        StringBuilder code = new StringBuilder();

        code.append("package framework;\n\n");

        code.append("import org.openqa.selenium.WebDriver;\n");
        code.append("import org.testng.annotations.AfterMethod;\n");
        code.append("import org.testng.annotations.BeforeMethod;\n\n");

        code.append("public class BaseTest {\n\n");

        code.append("    protected WebDriver driver;\n\n");

        code.append("    @BeforeMethod\n");
        code.append("    public void setup() {\n");
        code.append("        driver = DriverFactory.getDriver();\n");
        code.append("    }\n\n");

        code.append("    @AfterMethod\n");
        code.append("    public void tearDown() {\n");
        code.append("        DriverFactory.quitDriver();\n");
        code.append("    }\n\n");

        // Generate getDriver()
        code.append("    public WebDriver getDriver() {\n");
        code.append("        return driver;\n");
        code.append("    }\n\n");

        code.append("}\n");

        GeneratorFileUtil.writeFile(
                "framework",
                "BaseTest.java",
                code.toString());
    }
}