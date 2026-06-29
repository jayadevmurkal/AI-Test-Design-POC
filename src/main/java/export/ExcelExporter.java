package export;

import model.TestDesignData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import model.TestCase;
import java.util.List;

import java.io.FileOutputStream;

public class ExcelExporter {

        public static void export(TestDesignData data)
                throws Exception {

        XSSFWorkbook workbook =
                new XSSFWorkbook();

        int rowNum;

    // =========================
    // Test Scenarios Sheet
    // =========================

    Sheet scenarioSheet =
            workbook.createSheet("Test Scenarios");

    Row scenarioHeader =
            scenarioSheet.createRow(0);

    scenarioHeader.createCell(0)
            .setCellValue("Scenario");

    rowNum = 1;

    for (String scenario :
            data.getScenarios()) {

        Row row =
                scenarioSheet.createRow(rowNum++);

        row.createCell(0)
                .setCellValue(scenario);
    }

    // =========================
    // Positive Cases Sheet
    // =========================

    Sheet positiveSheet =
            workbook.createSheet("Positive Cases");

    Row positiveHeader =
            positiveSheet.createRow(0);

    positiveHeader.createCell(0)
            .setCellValue("Positive Test Case");

    rowNum = 1;

    for (String positive :
            data.getPositiveCases()) {

        Row row =
                positiveSheet.createRow(rowNum++);

        row.createCell(0)
                .setCellValue(positive);
    }

    // =========================
    // Negative Cases Sheet
    // =========================

    Sheet negativeSheet =
            workbook.createSheet("Negative Cases");

    Row negativeHeader =
            negativeSheet.createRow(0);

    negativeHeader.createCell(0)
            .setCellValue("Negative Test Case");

    rowNum = 1;

    for (String negative :
            data.getNegativeCases()) {

        Row row =
                negativeSheet.createRow(rowNum++);

        row.createCell(0)
                .setCellValue(negative);
    }

    // =========================
    // Edge Cases Sheet
    // =========================

    Sheet edgeSheet =
            workbook.createSheet("Edge Cases");

    Row edgeHeader =
            edgeSheet.createRow(0);

    edgeHeader.createCell(0)
            .setCellValue("Edge Test Case");

    rowNum = 1;

    for (String edge :
            data.getEdgeCases()) {

        Row row =
                edgeSheet.createRow(rowNum++);

        row.createCell(0)
                .setCellValue(edge);
    }

    // =========================
    // Automation Candidates Sheet
    // =========================

    Sheet automationSheet =
            workbook.createSheet(
                    "Automation Candidates");

    Row automationHeader =
            automationSheet.createRow(0);

    automationHeader.createCell(0)
            .setCellValue(
                    "Automation Candidate");

    rowNum = 1;

    for (String candidate :
            data.getAutomationCandidates()) {

        Row row =
                automationSheet.createRow(rowNum++);

        row.createCell(0)
                .setCellValue(candidate);
    }

    // =========================
    // Test Data Sheet
    // =========================

    Sheet dataSheet =
            workbook.createSheet("Test Data");

    Row dataHeader =
            dataSheet.createRow(0);

    dataHeader.createCell(0)
            .setCellValue("Test Data");

    rowNum = 1;

    for (String testData :
            data.getTestData()) {

        Row row =
                dataSheet.createRow(rowNum++);

        row.createCell(0)
                .setCellValue(testData);
    }

    FileOutputStream fos =
            new FileOutputStream(
                    "TestCases.xlsx");

    workbook.write(fos);

    workbook.close();
    fos.close();
}

    public static void exportTestCases(
        List<TestCase> testCases)
        throws Exception {

    XSSFWorkbook workbook =
            new XSSFWorkbook();
        
        int rowNum = 1;

    Sheet sheet =
            workbook.createSheet("Test Cases");

    Row header =
            sheet.createRow(0);

        header.createCell(0).setCellValue("Test Case ID");
        header.createCell(1).setCellValue("Scenario");
        header.createCell(2).setCellValue("Priority");
        header.createCell(3).setCellValue("Test Steps");
        header.createCell(4).setCellValue("Expected Result");

    //int rowNum = 1;

    for(TestCase tc : testCases) {

        Row row =
                sheet.createRow(rowNum++);

        row.createCell(0)
        .setCellValue(tc.getTestCaseId());

        row.createCell(1)
                .setCellValue(tc.getScenario());

        row.createCell(2)
                .setCellValue(tc.getPriority());

        row.createCell(3)
                .setCellValue(tc.getTestSteps());

        row.createCell(4)
                .setCellValue(tc.getExpectedResult());
    }

    FileOutputStream fos =
            new FileOutputStream(
                    "StructuredTestCases.xlsx");

    workbook.write(fos);

    workbook.close();

    fos.close();
}
}