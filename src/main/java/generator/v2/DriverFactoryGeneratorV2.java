package generator.v2;

public class DriverFactoryGeneratorV2 {

    public static void generate() throws Exception {

        StringBuilder code = new StringBuilder();

        buildPackage(code);
        buildImports(code);
        buildClassStart(code);
        buildDriverField(code);
        buildGetDriverMethod(code);
        buildQuitDriverMethod(code);
        buildClassEnd(code);

        writeFile(code);
    }

    private static void buildPackage(StringBuilder code) {

        code.append("package framework;\n\n");

    }

    private static void buildImports(StringBuilder code) {

        code.append("import org.openqa.selenium.WebDriver;\n");

        code.append("import org.openqa.selenium.chrome.ChromeDriver;\n");
        code.append("import org.openqa.selenium.edge.EdgeDriver;\n");
        code.append("import org.openqa.selenium.firefox.FirefoxDriver;\n");

        code.append("import io.github.bonigarcia.wdm.WebDriverManager;\n\n");
        code.append("import config.ConfigReader;\n");

    }

    private static void buildClassStart(StringBuilder code) {

        code.append("public class DriverFactory {\n\n");

    }

    private static void buildDriverField(StringBuilder code) {

        code.append("    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();\n\n");

    }

    private static void buildGetDriverMethod(StringBuilder code) {

        code.append("    public static WebDriver getDriver() {\n\n");

        code.append("        if(threadDriver.get() == null) {\n\n");

        code.append("            String browser = ConfigReader.get(\"browser\");\n\n");

        code.append("            switch(browser.toLowerCase()) {\n\n");

        code.append("                case \"chrome\":\n");
        code.append("                    WebDriverManager.chromedriver().setup();\n");
        code.append("                    threadDriver.set(new ChromeDriver());\n");
        code.append("                    break;\n\n");

        code.append("                case \"edge\":\n");
        code.append("                    WebDriverManager.edgedriver().setup();\n");
        code.append("                    threadDriver.set(new EdgeDriver());\n");
        code.append("                    break;\n\n");

        code.append("                case \"firefox\":\n");
        code.append("                WebDriverManager.firefoxdriver().setup();\n");
        code.append("                    threadDriver.set(new FirefoxDriver());\n");
        code.append("                    break;\n\n");

        code.append("                default:\n");
        code.append("                WebDriverManager.chromedriver().setup();\n");
        code.append("                    threadDriver.set(new ChromeDriver());\n");

        code.append("            }\n\n");

        code.append("            threadDriver.get().manage().window().maximize();\n");

        code.append("        }\n\n");

        code.append("        return threadDriver.get();\n");

        code.append("    }\n\n");

    }

    private static void buildQuitDriverMethod(StringBuilder code) {

        code.append("    public static void quitDriver() {\n\n");

        code.append("        if(threadDriver.get() != null) {\n");

        code.append("            threadDriver.get().quit();\n");

        code.append("            threadDriver.remove();\n");

        code.append("        }\n");

        code.append("    }\n\n");

    }

    private static void buildClassEnd(StringBuilder code) {

        code.append("}\n");

    }

    private static void writeFile(StringBuilder code) throws Exception {

        GeneratorFileUtil.writeJavaFile(
                "framework",
                "DriverFactory.java",
                code.toString());
    }

}