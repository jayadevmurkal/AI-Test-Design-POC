package generator.v2;

import config.FrameworkConstants;
import java.time.LocalDate;

public class FrameworkVersionGeneratorV2 {

        public static void generate() throws Exception {

                StringBuilder code = new StringBuilder();

                code.append("package config;\n\n");

                code.append("public final class FrameworkVersion {\n\n");

                code.append("    public static final String FRAMEWORK_NAME = ")
                                .append("\"")
                                .append(FrameworkConstants.FRAMEWORK_NAME)
                                .append("\";\n\n");

                code.append("    public static final String VERSION = ")
                                .append("\"")
                                .append(FrameworkConstants.FRAMEWORK_VERSION)
                                .append("\";\n\n");

                code.append("    public static final String AUTHOR = ")
                                .append("\"")
                                .append(FrameworkConstants.FRAMEWORK_AUTHOR)
                                .append("\";\n\n");

                code.append("    public static final String GENERATED_DATE = ")
                                .append("\"")
                                .append(LocalDate.now())
                                .append("\";\n\n");

                code.append("    private FrameworkVersion() {\n");
                code.append("    }\n\n");

                code.append("}\n");

                GeneratorFileUtil.writeFile(
                                "config",
                                "FrameworkVersion.java",
                                code.toString());
        }
}