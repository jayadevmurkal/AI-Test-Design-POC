package generator.v2;

import java.io.File;

import java.io.FileWriter;

import config.FrameworkConstants;

import model.v2.GeneratedTestSuite;

public class PageObjectGeneratorV2 {

    public static void generate(GeneratedTestSuite suite) throws Exception {

        StringBuilder code = new StringBuilder();

        code.append("package pages;\n\n");

        code.append("import org.openqa.selenium.WebDriver;\n");

        code.append("import org.openqa.selenium.WebElement;\n");

        code.append("import org.openqa.selenium.support.FindBy;\n");

        code.append("import org.openqa.selenium.support.PageFactory;\n\n");

        code.append("public class RegistrationPage {\n\n");

        code.append("    private WebDriver driver;\n\n");

        code.append("    public RegistrationPage(WebDriver driver) {\n");

        code.append("        this.driver = driver;\n");

        code.append("        PageFactory.initElements(driver, this);\n");

        code.append("    }\n\n");

        code.append("}\n");

        File outputFolder = new File(

                FrameworkConstants.GENERATED_OUTPUT_FOLDER);

        if (!outputFolder.exists()) {

            outputFolder.mkdirs();

        }

        FileWriter writer = new FileWriter(

                FrameworkConstants.GENERATED_OUTPUT_FOLDER

                        + "/RegistrationPage.java");

        writer.write(code.toString());

        writer.close();

        System.out.println("RegistrationPage.java generated successfully.");

    }

}