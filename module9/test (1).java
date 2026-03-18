package module8.appium;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.URL;
import java.time.Duration;
public class test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	



		  UiAutomator2Options options = new UiAutomator2Options();
	        options.setPlatformName("ANDROID");
	        options.setAutomationName("UiAutomator2");
	        options.setDeviceName("emulator-5554");

	        options.setApp("C:/Users/shruti/ApkProjects/ApiDemos-debug/ApiDemos-debug.apk");

	        AndroidDriver driver = new AndroidDriver(
	                new URL("http://127.0.0.1:4723"), options);

	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        // Click App
	        driver.findElement(AppiumBy.accessibilityId("App")).click();

	        // Click Alert Dialogs
	        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();

	        driver.navigate().back();
	        driver.quit();
		    }
		

	

}

