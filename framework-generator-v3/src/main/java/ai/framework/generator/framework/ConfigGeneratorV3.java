package ai.framework.generator.framework;

import ai.framework.generator.Generator;
import ai.framework.model.FrameworkProject;
import ai.framework.model.GeneratedFile;

public class ConfigGeneratorV3 implements Generator {

    private GeneratedFile generatedFile;

    @Override
    public void generate(FrameworkProject project) throws Exception {

        StringBuilder code = new StringBuilder();

        buildBrowser(code);
        buildApplicationUrl(code);
        buildTimeouts(code);
        buildExecutionSettings(code);

        generatedFile = new GeneratedFile(
                "config",
                "config.properties",
                code.toString());

    }

    public GeneratedFile getGeneratedFile() {
        return generatedFile;
    }

    private void buildBrowser(StringBuilder code) {

        code.append("browser=chrome\n");

    }

    private void buildApplicationUrl(StringBuilder code) {

        code.append("url=https://example.com\n\n");

    }

    private void buildTimeouts(StringBuilder code) {

        code.append("implicitWait=10\n");

        code.append("explicitWait=20\n\n");

    }

    private void buildExecutionSettings(StringBuilder code) {

        code.append("headless=false\n");

        code.append("maximize=true\n");

    }

}