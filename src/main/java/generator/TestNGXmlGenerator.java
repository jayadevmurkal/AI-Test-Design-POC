package generator;

import java.nio.file.Files;
import java.nio.file.Path;

public class TestNGXmlGenerator {

    public static void generate()
            throws Exception {

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE suite SYSTEM \"https://testng.org/testng-1.0.dtd\">\n" +
                "<suite name=\"AI Generated Suite\">\n" +
                "    <test name=\"Registration Tests\">\n" +
                "        <classes>\n" +
                "            <class name=\"tests.GeneratedTests\"/>\n" +
                "        </classes>\n" +
                "    </test>\n" +
                "</suite>";

        Files.writeString(
                Path.of("testng.xml"),
                xml);
    }
}