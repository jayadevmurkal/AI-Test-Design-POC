package generator.v2;

import config.FrameworkConstants;

import java.io.File;
import java.io.FileWriter;

public class GeneratorFileUtil {

    private static final String ROOT = FrameworkConstants.GENERATED_OUTPUT_FOLDER;

    // New API
    public static void writeJavaFile(
            String packageName,
            String fileName,
            String content) throws Exception {

        write(
                ROOT + "/src/main/java/" + packageName.replace(".", "/"),
                fileName,
                content);
    }

    public static void writeTestFile(
            String packageName,
            String fileName,
            String content) throws Exception {

        write(
                ROOT + "/src/test/java/" + packageName.replace(".", "/"),
                fileName,
                content);
    }

    public static void writeResourceFile(
            String fileName,
            String content) throws Exception {

        write(
                ROOT + "/src/main/resources",
                fileName,
                content);
    }

    public static void writeRootFile(
            String fileName,
            String content) throws Exception {

        write(
                ROOT,
                fileName,
                content);
    }

    // Compatibility API (OLD generators still call this)
    public static void writeFile(
            String folderName,
            String fileName,
            String content) throws Exception {

        String basePath;

        switch (folderName) {

            case "framework":
            case "pages":
            case "config":
            case "utils":
                basePath = FrameworkConstants.GENERATED_OUTPUT_FOLDER
                        + "/src/main/java/";
                break;

            case "tests":
                basePath = FrameworkConstants.GENERATED_OUTPUT_FOLDER
                        + "/src/test/java/";
                break;

            default:
                basePath = FrameworkConstants.GENERATED_OUTPUT_FOLDER
                        + "/";
        }

        String folderPath = basePath + folderName;

        File folder = new File(folderPath);

        if (!folder.exists()) {
            folder.mkdirs();
        }

        FileWriter writer = new FileWriter(folderPath + "/" + fileName);

        writer.write(content);

        writer.close();

        System.out.println(fileName + " generated successfully.");
    }

    private static void write(
            String folderPath,
            String fileName,
            String content) throws Exception {

        File folder = new File(folderPath);

        if (!folder.exists()) {
            folder.mkdirs();
        }

        FileWriter writer = new FileWriter(folderPath + "/" + fileName);

        writer.write(content);

        writer.close();

        System.out.println(fileName + " generated successfully.");
    }
}