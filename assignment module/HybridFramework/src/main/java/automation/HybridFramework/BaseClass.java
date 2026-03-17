package automation.HybridFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

    public static WebDriver driver;

    public static void openBrowser(String browser) {

        if(browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    public static void closeBrowser() {

        driver.quit();
    }
}