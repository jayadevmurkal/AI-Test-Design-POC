package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {

    public static Object[][] getData(
            String sheetName) throws Exception {

        FileInputStream fis = new FileInputStream("TestData.xlsx");

        Workbook workbook = WorkbookFactory.create(fis);

        Sheet sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getPhysicalNumberOfRows();

        int colCount = sheet.getRow(0)
                .getPhysicalNumberOfCells();

        List<Object[]> data = new ArrayList<>();

        for (int i = 1; i < rowCount; i++) {

            Object[] rowData = new Object[colCount];

            for (int j = 0; j < colCount; j++) {

                rowData[j] = sheet.getRow(i)
                        .getCell(j)
                        .toString();
            }

            data.add(rowData);
        }

        workbook.close();

        return data.toArray(
                new Object[0][]);
    }
}