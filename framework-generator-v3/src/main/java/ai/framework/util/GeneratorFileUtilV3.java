package ai.framework.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public final class GeneratorFileUtilV3 {

    private GeneratorFileUtilV3() {
    }

    /**
     * Writes any file.
     */
    public static void writeFile(Path outputRoot,
            String relativePath,
            String content) throws IOException {

        Path file = outputRoot.resolve(relativePath);

        Files.createDirectories(file.getParent());

        Files.writeString(
                file,
                content,
                StandardCharsets.UTF_8);
    }

}