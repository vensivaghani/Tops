package module8.automationframework;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ExcelUtil {

public static String getEmail() throws Exception {

FileInputStream fis = new FileInputStream(
System.getProperty("user.dir") + "/TestData/loginData.xlsx");

XSSFWorkbook workbook = new XSSFWorkbook(fis);

XSSFSheet sheet = workbook.getSheetAt(0);

String email = sheet.getRow(1).getCell(0).getStringCellValue();

workbook.close();

return email;
}
}