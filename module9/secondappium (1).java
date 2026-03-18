package module8.appium;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class secondappium {

    public static void main(String[] args) throws Exception {

        System.out.println("--- Starting Appium Test Script ---");

        // 1. Setting up Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Android Emulator");
        options.setPlatformName("ANDROID");
        options.setApp("C:/Users/shruti/ApkProjects/ApiDemos-debug/ApiDemos-debug.apk");

        System.out.println("Step 1: Capabilities configured. Connecting to Appium Server...");

        // 2. Initializing the Driver
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        System.out.println("Step 2: Session created! Application launched on Emulator.");

        Thread.sleep(3000);

        // 3. Navigation
        System.out.println("Step 3: Clicking on 'App' menu...");
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='App']")).click();

        System.out.println("Step 4: Clicking on 'Alert Dialogs'...");
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Alert Dialogs']")).click();

        System.out.println("Step 5: Opening 'Text Entry dialog'...");
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Text Entry dialog']")).click();

        // 4. Using Explicit Wait
        System.out.println("Step 6: Waiting for the Username field to become clickable...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("io.appium.android.apis:id/username_edit")));

        // 5. Data Entry
        System.out.println("Step 7: Entering username and password...");
        driver.findElement(By.id("io.appium.android.apis:id/username_edit")).sendKeys("Dharmishtha");
        driver.findElement(By.id("io.appium.android.apis:id/password_edit")).sendKeys("12345");

        System.out.println("Step 8: Clicking 'OK' button...");
        driver.findElement(By.id("android:id/button1")).click();

        // 6. Cleanup
        System.out.println("Step 9: Test completed successfully. Closing the session...");
        driver.quit();
        
        System.out.println("--- Test Process Finished ---");
    }
}