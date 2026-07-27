package generator.v2;

import config.FrameworkConstants;

import java.io.File;
import java.io.FileWriter;

public class GeneratorFileUtil {

    public static void writeFile(
            String folderName,
            String fileName,
            String content) throws Exception {

        String filePath;

        if (folderName == null || folderName.isBlank()) {

            filePath = FrameworkConstants.GENERATED_OUTPUT_FOLDER
                    + "/"
                    + fileName;

        } else {

            String folderPath = FrameworkConstants.GENERATED_OUTPUT_FOLDER
                    + "/"
                    + folderName;

            File folder = new File(folderPath);

            if (!folder.exists()) {
                folder.mkdirs();
            }

            filePath = folderPath + "/" + fileName;
        }

        FileWriter writer = new FileWriter(filePath);

        writer.write(content);

        writer.close();

        System.out.println(fileName + " generated successfully.");
    }

}