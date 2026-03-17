package automation.HybridFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Keywords {

    WebDriver driver;

    public void openBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        System.out.println("Browser launched: " + browser);
    }

    public void navigate(String url) {
        driver.get(url);
        System.out.println("Navigating to: " + url);
    }

    public void enterText(String locatorType, String locatorValue, String data) {
        WebElement element = findElement(locatorType, locatorValue);
        element.sendKeys(data);
        System.out.println("Entered text: " + data + " in element [" + locatorType + "=" + locatorValue + "]");
    }

    public void click(String locatorType, String locatorValue) {
        WebElement element = findElement(locatorType, locatorValue);
        element.click();
        System.out.println("Clicked element [" + locatorType + "=" + locatorValue + "]");
    }

    public void closeBrowser() {
        driver.quit();
        System.out.println("Browser closed");
    }

    // Explicit wait for all elements
    private WebElement findElement(String locatorType, String locatorValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        switch(locatorType.toLowerCase()) {
            case "id":
                return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
            case "name":
                return wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
            case "css":
                return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
            case "xpath":
                return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
            default:
                throw new RuntimeException("Unknown locator type: " + locatorType);
        }
    }
}