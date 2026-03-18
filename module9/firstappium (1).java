package module8.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import java.net.URL;
import java.time.Duration;

public class firstappium {

    public static void main(String[] args) throws Exception {

    	UiAutomator2Options options = new UiAutomator2Options();
    	options.setDeviceName("Android Emulator");
    	options.setPlatformName("ANDROID");
    	options.setAutomationName("UiAutomator2");
    	options.setAppPackage("com.android.calculator2");
    	options.setAppActivity("com.android.calculator2.Calculator");

    	options.setApp("C:\\Users\\Admin\\Downloads\\ApiDemos-debug.apk");

        AndroidDriver driver =
                new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("com.android.calculator2:id/digit_7")).click();
        driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_3")).click();
        driver.findElement(By.id("com.android.calculator2:id/eq")).click();

        Thread.sleep(3000);
        driver.quit();
    }
}
