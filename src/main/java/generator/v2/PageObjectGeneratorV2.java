package generator.v2;

import model.v2.GeneratedTestCase;
import model.v2.GeneratedTestSuite;
import java.util.LinkedHashMap;
import java.util.Map;

import config.FrameworkConstants;

public class PageObjectGeneratorV2 {

    public static void generate(GeneratedTestSuite suite) throws Exception {

        if (suite.getTestCases() == null || suite.getTestCases().isEmpty()) {
            System.out.println("No test cases found.");
            return;
        }

        Map<String, String> allLocators = collectAllLocators(suite);

        StringBuilder code = new StringBuilder();

        buildPackage(code);
        buildImports(code);
        buildClassStart(code);
        buildDriver(code);
        buildFindByFields(code, allLocators);
        buildConstructor(code);
        buildPageMethods(code, allLocators);
        buildClassEnd(code);

        GeneratorFileUtil.writeJavaFile(
                FrameworkConstants.PAGE_PACKAGE,
                FrameworkConstants.PAGE_CLASS + ".java",
                code.toString());
    }

    private static void buildPackage(StringBuilder code) {

        code.append("package ")
                .append(FrameworkConstants.PAGE_PACKAGE)
                .append(";\n\n");

    }

    private static void buildImports(StringBuilder code) {

        code.append("import framework.BasePage;\n");

        code.append("import org.openqa.selenium.WebDriver;\n");
        code.append("import org.openqa.selenium.WebElement;\n");
        code.append("import org.openqa.selenium.support.FindBy;\n");
        code.append("import org.openqa.selenium.support.PageFactory;\n\n");

    }

    private static void buildClassStart(StringBuilder code) {

        code.append("public class ")
                .append(FrameworkConstants.PAGE_CLASS)
                .append(" extends BasePage {\n\n");

    }

    private static void buildDriver(StringBuilder code) {
        // Driver is inherited from BasePage
    }

    private static void buildFindByFields(
            StringBuilder code,
            Map<String, String> locators) {

        locators.forEach((fieldName, locator) -> {

            String[] parts = locator.split("=", 2);

            if (parts.length == 2) {

                String strategy = parts[0].trim();
                String value = parts[1].trim();

                switch (strategy) {

                    case "id":
                        code.append("    @FindBy(id = \"")
                                .append(value)
                                .append("\")\n");
                        break;

                    case "name":
                        code.append("    @FindBy(name = \"")
                                .append(value)
                                .append("\")\n");
                        break;

                    case "xpath":
                        code.append("    @FindBy(xpath = \"")
                                .append(value)
                                .append("\")\n");
                        break;

                    case "css":
                    case "cssSelector":
                        code.append("    @FindBy(css = \"")
                                .append(value)
                                .append("\")\n");
                        break;

                    case "className":
                        code.append("    @FindBy(className = \"")
                                .append(value)
                                .append("\")\n");
                        break;

                    case "linkText":
                        code.append("    @FindBy(linkText = \"")
                                .append(value)
                                .append("\")\n");
                        break;

                    default:
                        code.append("    @FindBy(id = \"")
                                .append(value)
                                .append("\")\n");
                }

                code.append("    private WebElement ")
                        .append(fieldName)
                        .append(";\n\n");
            }

        });

    }

    private static void buildConstructor(StringBuilder code) {

        code.append("    public ")
                .append(FrameworkConstants.PAGE_CLASS)
                .append("(WebDriver driver) {\n");
        code.append("        super(driver);\n");
        code.append("        PageFactory.initElements(driver, this);\n");
        code.append("    }\n\n");

    }

    private static void buildPageMethods(
            StringBuilder code,
            Map<String, String> locators) {
        locators.forEach((fieldName, locator) -> {

            String lower = fieldName.toLowerCase();

            if (lower.contains("button")) {

                code.append("    public void click")
                        .append(GeneratorStringUtil.removeSuffix(
                                GeneratorStringUtil.capitalize(fieldName),
                                "Button"))
                        .append("Button() {\n");

                code.append("        click(")
                        .append(fieldName)
                        .append(");\n");

                code.append("    }\n\n");

            }

            else if (lower.contains("message") || lower.contains("error")) {

                code.append("    public String get")
                        .append(GeneratorStringUtil.capitalize(fieldName))
                        .append("() {\n");

                code.append("        return getText(")
                        .append(fieldName)
                        .append(");\n");

                code.append("    }\n\n");

            }

            else {

                code.append("    public void enter")
                        .append(GeneratorStringUtil.capitalize(fieldName))
                        .append("(String value) {\n");

                code.append("        type(")
                        .append(fieldName)
                        .append(", value);\n");

                code.append("    }\n\n");

            }

        });

    }

    private static void buildClassEnd(StringBuilder code) {

        code.append("}\n");

    }

    private static Map<String, String> collectAllLocators(
            GeneratedTestSuite suite) {

        Map<String, String> locators = new LinkedHashMap<>();

        for (GeneratedTestCase tc : suite.getTestCases()) {

            if (tc.getLocators() != null) {

                locators.putAll(tc.getLocators());

            }
        }

        return locators;
    }

}