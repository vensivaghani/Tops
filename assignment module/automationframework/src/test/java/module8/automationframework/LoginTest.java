package module8.automationframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void loginTest() throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.automationtesting.in/SignIn.html");

        String email = ExcelUtil.getEmail();

        driver.findElement(By.xpath("//input[@placeholder='E mail']")).sendKeys(email);

        driver.findElement(By.id("enterbtn")).click();

        System.out.println("Login attempted with email: " + email);

        driver.quit();
    }
}