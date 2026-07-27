package generator.v2;

import model.v2.GeneratedTestSuite;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FrameworkGenerationReportGeneratorV2 {

    public static void generate(GeneratedTestSuite suite) throws Exception {

        StringBuilder code = new StringBuilder();

        buildHeader(code);
        buildBody(code, suite);
        buildFooter(code);

        GeneratorFileUtil.writeFile(
                "",
                "FrameworkConstants.GENERATION_REPORT_FILE",
                code.toString());
    }

    private static void buildHeader(StringBuilder code) {

        code.append("<!DOCTYPE html>\n");
        code.append("<html>\n");
        code.append("<head>\n");

        code.append("<title>Framework Generation Report</title>\n");

        code.append("<style>\n");

        code.append("body{font-family:Arial;background:#f5f5f5;padding:30px;}\n");
        code.append(".card{background:white;padding:25px;border-radius:10px;");
        code.append("box-shadow:0 2px 8px rgba(0,0,0,.2);max-width:900px;margin:auto;}\n");

        code.append("h1{color:#1565c0;}\n");
        code.append("table{width:100%;border-collapse:collapse;margin-top:20px;}\n");
        code.append("th,td{border:1px solid #ddd;padding:10px;text-align:left;}\n");
        code.append("th{background:#1565c0;color:white;}\n");
        code.append(".success{color:green;font-weight:bold;}\n");

        code.append("</style>\n");

        code.append("</head>\n");
    }

    private static void buildBody(
            StringBuilder code,
            GeneratedTestSuite suite) {

        code.append("<body>\n");

        code.append("<div class=\"card\">\n");

        code.append("<h1>AI Test Design Framework Generator V2.0</h1>\n");

        code.append("<hr>\n");

        code.append("<table>\n");

        addRow(code, "Feature", suite.getFeature());
        addRow(code, "Requirement", suite.getRequirement());
        addRow(code, "Framework Version", "2.0");
        addRow(code, "Generated Tests",
                String.valueOf(suite.getTestCases().size()));

        addRow(code,
                "Generated On",
                LocalDateTime.now().format(
                        DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss")));

        code.append("</table>\n");

        code.append("<br>\n");

        code.append("<h2>Generated Components</h2>\n");

        code.append("<ul>\n");

        component(code, "Base Framework");
        component(code, "Driver Factory");
        component(code, "Base Page");
        component(code, "Wait Utility");
        component(code, "Screenshot Utility");
        component(code, "Logger Utility");
        component(code, "Extent Reports");
        component(code, "Configuration Reader");
        component(code, "Page Objects");
        component(code, "Generated Test Classes");
        component(code, "README");
        component(code, "CHANGELOG");
        component(code, "LICENSE");
        component(code, "Framework Architecture");

        code.append("</ul>\n");

        code.append("<h2>Execution Command</h2>\n");

        code.append("<pre>");
        code.append("mvn clean test");
        code.append("</pre>\n");

        code.append("</div>\n");

        code.append("</body>\n");
    }

    private static void component(
            StringBuilder code,
            String component) {

        code.append("<li class=\"success\">");
        code.append("Generated - ");
        code.append(component);
        code.append("</li>\n");

    }

    private static void addRow(
            StringBuilder code,
            String key,
            String value) {

        code.append("<tr>");

        code.append("<th>");
        code.append(key);
        code.append("</th>");

        code.append("<td>");
        code.append(value);
        code.append("</td>");

        code.append("</tr>\n");

    }

    private static void buildFooter(StringBuilder code) {

        code.append("</html>");

    }

}