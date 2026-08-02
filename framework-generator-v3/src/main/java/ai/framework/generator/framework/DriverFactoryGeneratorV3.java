package ai.framework.generator.framework;

import ai.framework.generator.Generator;
import ai.framework.model.FrameworkProject;
import ai.framework.model.GeneratedFile;

public class DriverFactoryGeneratorV3 implements Generator {

    @Override
    public void generate(FrameworkProject project) throws Exception {

        StringBuilder code = new StringBuilder();

        buildPackage(code);
        buildImports(code);
        buildClassStart(code);
        buildMethods(code);
        buildClassEnd(code);

        GeneratedFile file = new GeneratedFile(
                "framework",
                "DriverFactory.java",
                code.toString());

        project.addFile(file);
    }

    private void buildPackage(StringBuilder code) {

        code.append("package framework;\n\n");

    }

    private void buildImports(StringBuilder code) {

        code.append("import org.openqa.selenium.WebDriver;\n");

        code.append("import org.openqa.selenium.chrome.ChromeDriver;\n");
        code.append("import org.openqa.selenium.edge.EdgeDriver;\n");
        code.append("import org.openqa.selenium.firefox.FirefoxDriver;\n\n");

        code.append("import io.github.bonigarcia.wdm.WebDriverManager;\n\n");

        code.append("import config.ConfigReader;\n\n");

    }

    private void buildClassStart(StringBuilder code) {

        code.append("public class DriverFactory {\n\n");

        code.append("    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();\n\n");

    }

    private void buildMethods(StringBuilder code) {

        buildInitDriver(code);
        buildGetDriver(code);
        buildQuitDriver(code);

    }

    private void buildInitDriver(StringBuilder code) {

        code.append("    public static void initDriver() {\n\n");

        code.append("        String browser = ConfigReader.get(\"browser\");\n\n");

        code.append("        switch (browser.toLowerCase()) {\n\n");

        // Chrome
        code.append("            case \"chrome\":\n");
        code.append("                WebDriverManager.chromedriver().setup();\n");
        code.append("                driver.set(new ChromeDriver());\n");
        code.append("                break;\n\n");

        // Firefox
        code.append("            case \"firefox\":\n");
        code.append("                WebDriverManager.firefoxdriver().setup();\n");
        code.append("                driver.set(new FirefoxDriver());\n");
        code.append("                break;\n\n");

        // Edge
        code.append("            case \"edge\":\n");
        code.append("                WebDriverManager.edgedriver().setup();\n");
        code.append("                driver.set(new EdgeDriver());\n");
        code.append("                break;\n\n");

        // Default
        code.append("            default:\n");
        code.append("                throw new RuntimeException(\"Unsupported browser : \" + browser);\n");

        code.append("        }\n\n");

        code.append("        getDriver().manage().window().maximize();\n");

        code.append("    }\n\n");

    }

    private void buildGetDriver(StringBuilder code) {

        code.append("    public static WebDriver getDriver() {\n\n");

        code.append("        return driver.get();\n\n");

        code.append("    }\n\n");

    }

    private void buildQuitDriver(StringBuilder code) {

        code.append("    public static void quitDriver() {\n\n");

        code.append("        if (driver.get() != null) {\n\n");

        code.append("            driver.get().quit();\n");
        code.append("            driver.remove();\n");

        code.append("        }\n\n");

        code.append("    }\n\n");

    }

    private void buildClassEnd(StringBuilder code) {

        code.append("}\n");

    }
}