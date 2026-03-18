package framework.module8;

import java.io.FileInputStream;
import java.time.Duration;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExcelLogin {
    public static void main(String[] args) throws Exception {
        
        FileInputStream file = new FileInputStream("C:\\Users\\desk\\eclipse-workspace\\module8\\TestData\\logindata.xlsx");
        Workbook wb = new XSSFWorkbook(file);
        Sheet sheet = wb.getSheetAt(0);
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // 1. Navigate to the URL
        driver.get("https://demo.automationtesting.in/SignIn.html");
        
        // 2. Setup an Explicit Wait (Wait up to 10 seconds)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        String username = sheet.getRow(0).getCell(0).getStringCellValue();
        String password = sheet.getRow(0).getCell(1).getStringCellValue();
        
        // 3. Wait until the email field is actually visible on screen
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='E-mail Address']")));
        emailField.sendKeys(username);
        
        // 4. Do the same for password
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        
        // 5. Click Enter
        driver.findElement(By.id("enterbtn")).click();
        
        wb.close();
    }
}