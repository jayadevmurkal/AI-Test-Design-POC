package generator.v2;

import config.FrameworkConstants;

public class ConfigGeneratorV2 {

    public static void generate() throws Exception {

        StringBuilder config = new StringBuilder();

        config.append("# ======================================\n");
        config.append("# AI Generated Framework Configuration\n");
        config.append("# ======================================\n\n");

        config.append("browser=chrome\n");
        config.append("baseUrl=https://demoapp.com\n");
        config.append("implicitWait=10\n");
        config.append("explicitWait=20\n");
        config.append("pageLoadTimeout=30\n");
        config.append("headless=false\n");

        GeneratorFileUtil.writeFile(
                "src/main/resources",
                "config.properties",
                config.toString());
    }
}