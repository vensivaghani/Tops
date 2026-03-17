package selenium.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverJUnitTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Automatically download correct ChromeDriver version
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testGoogleHomePageTitle() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        System.out.println("Page title: " + title);

        // Assert the title contains "Google"
        assertEquals("Google", title, "Title should be 'Google'");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}