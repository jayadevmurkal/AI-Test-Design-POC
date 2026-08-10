package generator.v2;

import config.FrameworkConstants;

public class TestNGGeneratorV2 {

    public static void generate() throws Exception {

        StringBuilder code = new StringBuilder();

        buildSuite(code);

        GeneratorFileUtil.writeFile(
                "",
                "testng.xml",
                code.toString());

        System.out.println("testng.xml generated successfully.");
    }

    private static void buildSuite(StringBuilder code) {

        code.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n\n");

        code.append("<!DOCTYPE suite SYSTEM \"https://testng.org/testng-1.0.dtd\">\n\n");

        code.append("<suite name=\"AI Automation Suite\" verbose=\"1\" parallel=\"methods\" thread-count=\"2\">\n\n");

        code.append("    <listeners>\n");
        code.append("        <listener class-name=\"framework.ExtentListener\"/>\n");
        code.append("    </listeners>\n\n");

        code.append("    <test name=\"Generated Tests\">\n");

        code.append("        <classes>\n");

        code.append("            <class name=\"")
                .append(FrameworkConstants.TEST_PACKAGE)
                .append(".")
                .append(FrameworkConstants.TEST_CLASS)
                .append("\"/>\n");

        code.append("        </classes>\n");

        code.append("    </test>\n\n");

        code.append("</suite>\n");
    }

}