package ai.framework.generator.framework;

import ai.framework.generator.Generator;
import ai.framework.model.FrameworkProject;
import ai.framework.model.GeneratedFile;

public class TestNGGeneratorV3 implements Generator {

    private GeneratedFile generatedFile;

    @Override
    public void generate(FrameworkProject project) throws Exception {

        StringBuilder code = new StringBuilder();

        buildXmlStart(code);
        buildSuite(code);
        buildTest(code);
        buildClasses(code);
        buildXmlEnd(code);

        generatedFile = new GeneratedFile(
                "",
                "testng.xml",
                code.toString());

    }

    public GeneratedFile getGeneratedFile() {
        return generatedFile;
    }

    private void buildXmlStart(StringBuilder code) {

        code.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n\n");

    }

    private void buildSuite(StringBuilder code) {

        code.append("<suite name=\"Automation Suite\">\n\n");

    }

    private void buildTest(StringBuilder code) {

        code.append("    <test name=\"Generated Tests\">\n\n");

    }

    private void buildClasses(StringBuilder code) {

        code.append("        <classes>\n");

        code.append("            <class name=\"tests.SampleTest\"/>\n");

        code.append("        </classes>\n\n");

        code.append("    </test>\n\n");

    }

    private void buildXmlEnd(StringBuilder code) {

        code.append("</suite>\n");

    }

}