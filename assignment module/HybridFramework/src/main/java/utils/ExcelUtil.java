package utils;

import java.io.FileInputStream;

import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    private XSSFWorkbook workbook;
    private Sheet sheet;

    public ExcelUtil(String path) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheetAt(0);
        fis.close();
    }

    public int getRowCount() {
        return sheet.getLastRowNum() + 1;
    }

    public String getCellData(int row, int col) {
        Row r = sheet.getRow(row);
        if (r == null) return "";

        Cell c = r.getCell(col);
        if (c == null) return "";

        switch (c.getCellType()) {
            case STRING: return c.getStringCellValue();
            case NUMERIC:
                double val = c.getNumericCellValue();
                if (val == (int) val) return String.valueOf((int) val);
                else return String.valueOf(val);
            case BOOLEAN: return String.valueOf(c.getBooleanCellValue());
            case FORMULA: return c.getCellFormula();
            default: return "";
        }
    }

    public void close() throws IOException {
        if (workbook != null) workbook.close();
    }
}