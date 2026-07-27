package generator.v2;

import config.FrameworkConstants;

public class ScreenshotUtilityGeneratorV2 {

    public static void generate() throws Exception {

        StringBuilder code = new StringBuilder();

        buildPackage(code);
        buildImports(code);
        buildClassStart(code);
        buildCaptureMethod(code);
        buildClassEnd(code);

        writeFile(code);

        System.out.println("ScreenshotUtil.java generated successfully.");
    }

    private static void buildPackage(StringBuilder code) {

        code.append("package framework;\n\n");

    }

    private static void buildImports(StringBuilder code) {

        code.append("import org.openqa.selenium.OutputType;\n");
        code.append("import org.openqa.selenium.TakesScreenshot;\n");
        code.append("import org.openqa.selenium.WebDriver;\n\n");

        code.append("import java.io.File;\n");
        code.append("import java.io.IOException;\n");
        code.append("import java.nio.file.Files;\n");
        code.append("import java.nio.file.StandardCopyOption;\n\n");

        code.append("import java.text.SimpleDateFormat;\n");
        code.append("import java.util.Date;\n\n");

    }

    private static void buildClassStart(StringBuilder code) {

        code.append("public class ScreenshotUtil {\n\n");

    }

    private static void buildCaptureMethod(StringBuilder code) {

        code.append("    public static String capture(WebDriver driver, String testName) {\n\n");

        code.append("        try {\n\n");

        code.append("            String timestamp = new SimpleDateFormat(\"yyyyMMdd_HHmmss\")\n");
        code.append("                    .format(new Date());\n\n");

        code.append("            String folder = \"reports/screenshots\";\n\n");

        code.append("            File directory = new File(folder);\n\n");

        code.append("            if (!directory.exists()) {\n");
        code.append("                directory.mkdirs();\n");
        code.append("            }\n\n");

        code.append("            File source = ((TakesScreenshot) driver)\n");
        code.append("                    .getScreenshotAs(OutputType.FILE);\n\n");

        code.append("            String destinationPath =\n");
        code.append("                    folder + \"/\" + testName + \"_\" + timestamp + \".png\";\n\n");

        code.append("            File destination = new File(destinationPath);\n\n");

        code.append("            Files.copy(\n");
        code.append("                    source.toPath(),\n");
        code.append("                    destination.toPath(),\n");
        code.append("                    StandardCopyOption.REPLACE_EXISTING);\n\n");

        code.append("            return destination.getAbsolutePath();\n\n");

        code.append("        } catch (IOException e) {\n\n");

        code.append("            e.printStackTrace();\n\n");

        code.append("            return null;\n");

        code.append("        }\n\n");

        code.append("    }\n\n");

    }

    private static void buildClassEnd(StringBuilder code) {

        code.append("}\n");

    }

    private static void writeFile(StringBuilder code) throws Exception {

        GeneratorFileUtil.writeFile(
                "framework",
                "ScreenshotUtil.java",
                code.toString());

    }

}