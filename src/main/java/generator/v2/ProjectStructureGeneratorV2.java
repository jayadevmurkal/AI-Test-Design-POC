package generator.v2;

import config.FrameworkConstants;

import java.io.File;

public class ProjectStructureGeneratorV2 {

    public static void generate() {

        createFolder(FrameworkConstants.GENERATED_OUTPUT_FOLDER);

        createFolder(FrameworkConstants.GENERATED_OUTPUT_FOLDER + "/src");

        createFolder(FrameworkConstants.GENERATED_OUTPUT_FOLDER + "/src/main");
        createFolder(FrameworkConstants.GENERATED_OUTPUT_FOLDER + "/src/main/java");
        createFolder(FrameworkConstants.GENERATED_OUTPUT_FOLDER + "/src/main/resources");

        createFolder(FrameworkConstants.GENERATED_OUTPUT_FOLDER + "/src/test");
        createFolder(FrameworkConstants.GENERATED_OUTPUT_FOLDER + "/src/test/java");

        createFolder(FrameworkConstants.GENERATED_OUTPUT_FOLDER + "/src/main/java/framework");
        createFolder(FrameworkConstants.GENERATED_OUTPUT_FOLDER + "/src/main/java/pages");
        createFolder(FrameworkConstants.GENERATED_OUTPUT_FOLDER + "/src/main/java/config");
        createFolder(FrameworkConstants.GENERATED_OUTPUT_FOLDER + "/src/main/java/utils");

        createFolder(FrameworkConstants.GENERATED_OUTPUT_FOLDER + "/src/test/java/tests");

        createFolder(FrameworkConstants.GENERATED_OUTPUT_FOLDER + "/reports");
        createFolder(FrameworkConstants.GENERATED_OUTPUT_FOLDER + "/reports/screenshots");

        createFolder(FrameworkConstants.GENERATED_OUTPUT_FOLDER + "/logs");

        System.out.println("Project Structure generated successfully.");
    }

    private static void createFolder(String path) {

        File folder = new File(path);

        if (!folder.exists()) {

            folder.mkdirs();

        }

    }

}