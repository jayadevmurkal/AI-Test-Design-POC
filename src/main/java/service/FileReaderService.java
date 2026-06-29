package service;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReaderService {

    public static String readFile(String path)
            throws Exception {

        return Files.readString(Paths.get(path));
    }
}