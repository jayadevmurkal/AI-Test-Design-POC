package ai.framework.generator.framework;

import ai.framework.model.GeneratedFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FrameworkWriterV3 {

    private final Path outputDirectory;

    public FrameworkWriterV3(String outputDirectory) {

        this.outputDirectory = Paths.get(outputDirectory);

    }

    public void write(GeneratedFile generatedFile) throws IOException {

        Path directory = resolveDirectory(generatedFile);

        Files.createDirectories(directory);

        Path filePath = directory.resolve(
                generatedFile.getFileName());

        Files.writeString(
                filePath,
                generatedFile.getContent(),
                StandardCharsets.UTF_8);

    }

    public void writeAll(
            List<GeneratedFile> generatedFiles) throws IOException {

        for (GeneratedFile generatedFile : generatedFiles) {

            write(generatedFile);

        }

    }

    private Path resolveDirectory(GeneratedFile generatedFile) {

        String packageName = generatedFile.getPackageName();
        String fileName = generatedFile.getFileName();

        if ("config.properties".equals(fileName)) {

            return outputDirectory
                    .resolve("src")
                    .resolve("main")
                    .resolve("resources");

        }

        if (packageName == null || packageName.isBlank()) {

            return outputDirectory;

        }

        String packagePath = packageName.replace(
                ".",
                java.io.File.separator);

        if ("tests".equals(packageName)) {

            return outputDirectory
                    .resolve("src")
                    .resolve("test")
                    .resolve("java")
                    .resolve(packagePath);

        }

        return outputDirectory
                .resolve("src")
                .resolve("main")
                .resolve("java")
                .resolve(packagePath);

    }

}