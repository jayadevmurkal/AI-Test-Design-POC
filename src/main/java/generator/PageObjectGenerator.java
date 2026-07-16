package generator;

import java.io.FileWriter;
import model.TestDesignData;
import java.util.Map;

public class PageObjectGenerator {

        public static void generate(String pageName, TestDesignData data)
                        throws Exception {

                String className = pageName + "Page";

                StringBuilder code = new StringBuilder();

                code.append("package pages;\n\n");

                code.append("import org.openqa.selenium.WebDriver;\n");
                code.append("import org.openqa.selenium.WebElement;\n");
                code.append("import org.openqa.selenium.support.FindBy;\n");
                code.append("import org.openqa.selenium.support.PageFactory;\n\n");

                code.append("public class ");
                code.append(className);
                code.append(" {\n\n");

                code.append("    private WebDriver driver;\n\n");

                for (Map.Entry<String, String> locator : data.getLocators().entrySet()) {

                        String fieldName = locator.getKey();

                        String lower = fieldName.toLowerCase();

                        String[] locatorParts = locator.getValue().split("=");

                        String locatorType = locatorParts[0];

                        String locatorValue = locatorParts[1];

                        code.append("    @FindBy(")
                                        .append(locatorType)
                                        .append("=\"")
                                        .append(locatorValue)
                                        .append("\")\n");

                        code.append("    private WebElement ")
                                        .append(fieldName)
                                        .append(";\n\n");
                }

                code.append("    public ");
                code.append(className);
                code.append("(WebDriver driver) {\n");
                code.append("        this.driver = driver;\n");
                code.append("        PageFactory.initElements(driver, this);\n");
                code.append("    }\n\n");

                for (Map.Entry<String, String> locator : data.getLocators().entrySet()) {

                        String fieldName = locator.getKey();

                        String lower = fieldName.toLowerCase();

                        if (lower.contains("button")) {

                                code.append("    public void click")
                                                .append(capitalize(fieldName))
                                                .append("() {\n");

                                code.append("        ")
                                                .append(fieldName)
                                                .append(".click();\n");

                                code.append("    }\n\n");

                        }

                        else if (lower.contains("message") || lower.contains("error")) {

                                code.append("    public String get")
                                                .append(capitalize(fieldName))
                                                .append("() {\n");

                                code.append("        return ")
                                                .append(fieldName)
                                                .append(".getText();\n");

                                code.append("    }\n\n");

                        }

                        else {

                                code.append("    public void enter")
                                                .append(capitalize(fieldName))
                                                .append("(String value) {\n");

                                code.append("        ")
                                                .append(fieldName)
                                                .append(".sendKeys(value);\n");

                                code.append("    }\n\n");

                        }
                }

                code.append("}\n");

                FileWriter writer = new FileWriter(
                                "src/main/java/pages/" + className + ".java");

                writer.write(code.toString());

                writer.close();

                System.out.println(className + " generated successfully.");
        }

        private static String capitalize(String text) {

                return Character.toUpperCase(text.charAt(0))
                                + text.substring(1);
        }
}