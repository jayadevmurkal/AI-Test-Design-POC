package ai.framework.generator.framework;

import ai.framework.generator.Generator;
import ai.framework.model.FrameworkProject;
import ai.framework.model.GeneratedFile;

public class TestGeneratorV3 implements Generator {

    private GeneratedFile generatedFile;

    @Override
    public void generate(FrameworkProject project) throws Exception {

        StringBuilder code = new StringBuilder();

        buildPackage(code);
        buildImports(code);
        buildClassStart(code);
        buildTestMethod(code);
        buildClassEnd(code);

        generatedFile = new GeneratedFile(
                "tests",
                "SampleTest.java",
                code.toString());
    }

    public GeneratedFile getGeneratedFile() {
        return generatedFile;
    }

    private void buildPackage(StringBuilder code) {

        code.append("package tests;\n\n");

    }

    private void buildImports(StringBuilder code) {

        code.append("import org.testng.annotations.Test;\n\n");

        code.append("import framework.BaseTest;\n");
        code.append("import pages.SamplePage;\n\n");

    }

    private void buildClassStart(StringBuilder code) {

        code.append("public class SampleTest extends BaseTest {\n\n");

    }

    private void buildTestMethod(StringBuilder code) {

        code.append("    @Test\n");

        code.append("    public void sampleTest() {\n\n");

        code.append("        SamplePage page = new SamplePage(driver);\n\n");

        code.append("        page.sampleAction();\n\n");

        code.append("    }\n\n");

    }

    private void buildClassEnd(StringBuilder code) {

        code.append("}\n");

    }

}