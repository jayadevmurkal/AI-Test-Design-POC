package generator.v2;

import config.FrameworkConstants;

public class PomGeneratorV2 {

        public static void generate() throws Exception {

                StringBuilder code = new StringBuilder();

                buildProjectStart(code);
                buildProperties(code);
                buildDependencies(code);
                buildBuildPlugins(code);
                buildProjectEnd(code);

                writeFile(code);

                System.out.println("pom.xml generated successfully.");
        }

        private static void buildProjectStart(StringBuilder code) {

                code.append("<project xmlns=\"http://maven.apache.org/POM/4.0.0\"\n");
                code.append("         xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n");
                code.append("         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 ");
                code.append("http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n\n");

                code.append("    <modelVersion>4.0.0</modelVersion>\n\n");

                code.append("    <groupId>ai.framework</groupId>\n");
                code.append("    <artifactId>GeneratedFramework</artifactId>\n");
                code.append("    <version>1.0</version>\n\n");

        }

        private static void buildProperties(StringBuilder code) {

                code.append("    <properties>\n");

                code.append("        <maven.compiler.source>17</maven.compiler.source>\n");
                code.append("        <maven.compiler.target>17</maven.compiler.target>\n");

                code.append("    </properties>\n\n");

        }

        private static void buildDependencies(StringBuilder code) {

                code.append("    <dependencies>\n\n");

                dependency(code,
                                "org.seleniumhq.selenium",
                                "selenium-java",
                                "4.34.0");

                dependency(code,
                                "org.testng",
                                "testng",
                                "7.11.0");

                dependency(code,
                                "io.github.bonigarcia",
                                "webdrivermanager",
                                "6.3.2");

                dependency(code,
                                "com.aventstack",
                                "extentreports",
                                "5.1.2");

                dependency(code,
                                "com.fasterxml.jackson.core",
                                "jackson-databind",
                                "2.20.0");

                dependency(code,
                                "org.apache.poi",
                                "poi-ooxml",
                                "5.4.1");

                code.append("    </dependencies>\n\n");

        }

        private static void dependency(
                        StringBuilder code,
                        String groupId,
                        String artifactId,
                        String version) {

                code.append("        <dependency>\n");

                code.append("            <groupId>")
                                .append(groupId)
                                .append("</groupId>\n");

                code.append("            <artifactId>")
                                .append(artifactId)
                                .append("</artifactId>\n");

                code.append("            <version>")
                                .append(version)
                                .append("</version>\n");

                code.append("        </dependency>\n\n");

        }

        private static void buildBuildPlugins(StringBuilder code) {

                code.append("    <build>\n");

                code.append("        <plugins>\n\n");

                code.append("            <plugin>\n");
                code.append("                <groupId>org.apache.maven.plugins</groupId>\n");
                code.append("                <artifactId>maven-surefire-plugin</artifactId>\n");
                code.append("                <version>3.5.3</version>\n");
                code.append("            </plugin>\n\n");

                code.append("        </plugins>\n");

                code.append("    </build>\n\n");

        }

        private static void buildProjectEnd(StringBuilder code) {

                code.append("</project>");

        }

        private static void writeFile(StringBuilder code) throws Exception {

                GeneratorFileUtil.writeFile(
                                "",
                                "pom.xml",
                                code.toString());

        }

}