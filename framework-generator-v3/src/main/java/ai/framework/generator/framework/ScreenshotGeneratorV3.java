package ai.framework.generator.framework;

import ai.framework.generator.Generator;
import ai.framework.model.FrameworkProject;
import ai.framework.model.GeneratedFile;

public class ScreenshotGeneratorV3 implements Generator {

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
                "ScreenshotUtil.java",
                code.toString());

        project.addFile(file);

    }

    private void buildPackage(StringBuilder code) {

        code.append("package framework;\n\n");

    }

    private void buildImports(StringBuilder code) {

        code.append("import org.openqa.selenium.OutputType;\n");
        code.append("import org.openqa.selenium.TakesScreenshot;\n");
        code.append("import org.openqa.selenium.WebDriver;\n\n");

        code.append("import java.io.File;\n");
        code.append("import java.io.IOException;\n");
        code.append("import java.nio.file.Files;\n");
        code.append("import java.nio.file.Path;\n");
        code.append("import java.nio.file.Paths;\n");
        code.append("import java.time.LocalDateTime;\n");
        code.append("import java.time.format.DateTimeFormatter;\n\n");

    }

    private void buildClassStart(StringBuilder code) {

        code.append("public class ScreenshotUtil {\n\n");

    }

    private void buildMethods(StringBuilder code) {

        buildCaptureMethod(code);

    }

    private void buildCaptureMethod(StringBuilder code) {

        code.append("    public static String capture(WebDriver driver, String screenshotName) {\n\n");

        buildCreateFolder(code);
        buildGenerateFileName(code);
        buildTakeScreenshot(code);
        buildCopyScreenshot(code);
        buildExceptionHandling(code);

        code.append("    }\n\n");

    }

    private void buildCreateFolder(StringBuilder code) {

        code.append("        try {\n\n");

        code.append("            Path folder = Paths.get(\"reports\", \"screenshots\");\n");

        code.append("            Files.createDirectories(folder);\n\n");

    }

    private void buildGenerateFileName(StringBuilder code) {

        code.append("            String timestamp = LocalDateTime.now()\n");

        code.append("                    .format(DateTimeFormatter.ofPattern(\"yyyyMMdd_HHmmss\"));\n\n");

        code.append("            String fileName = screenshotName + \"_\" + timestamp + \".png\";\n\n");

        code.append("            Path destination = folder.resolve(fileName);\n\n");

    }

    private void buildTakeScreenshot(StringBuilder code) {

        code.append("            File source = ((TakesScreenshot) driver)\n");
        code.append("                    .getScreenshotAs(OutputType.FILE);\n\n");

    }

    private void buildCopyScreenshot(StringBuilder code) {

        code.append("            Files.copy(source.toPath(), destination);\n\n");

        code.append("            return destination.toString();\n\n");

    }

    private void buildExceptionHandling(StringBuilder code) {

        code.append("        } catch (IOException e) {\n\n");

        code.append("            e.printStackTrace();\n");

        code.append("            return null;\n");

        code.append("        }\n\n");

    }

    private void buildClassEnd(StringBuilder code) {

        code.append("}\n");

    }

}