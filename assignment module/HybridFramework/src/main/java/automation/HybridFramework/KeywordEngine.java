package automation.HybridFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeywordEngine {

    WebDriver driver;

    public void openBrowser(String browser) {
        if(browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
    }

    public void navigate(String url) {
        driver.get(url);
    }

    public void enterText(String locatorType, String locatorValue, String data) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element;

        switch(locatorType.toLowerCase()) {
            case "id":
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
                break;
            case "name":
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
                break;
            case "css":
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
                break;
            case "xpath":
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
                break;
            default:
                throw new RuntimeException("Unknown locator type: " + locatorType);
        }

        element.sendKeys(data);
    }

    public void click(String locatorType, String locatorValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element;

        switch(locatorType.toLowerCase()) {
            case "id":
                element = wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
                break;
            case "name":
                element = wait.until(ExpectedConditions.elementToBeClickable(By.name(locatorValue)));
                break;
            case "css":
                element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locatorValue)));
                break;
            case "xpath":
                element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
                break;
            default:
                throw new RuntimeException("Unknown locator type: " + locatorType);
        }

        element.click();
    }

    public void closeBrowser() {
        driver.quit();
    }

	public void startExecution() {
		// TODO Auto-generated method stub
		
	}
}