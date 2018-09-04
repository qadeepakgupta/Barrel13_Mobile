package appiumCodePractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class ScrollExample {

	public static Properties OR = new Properties();
	private static final Logger log = Logger.getLogger(ScrollExample.class.getName());
	public static AppiumDriver<MobileElement> driver;

	@Test
	public void testScroll() throws InterruptedException {
		try {
			log.info("======= starting testScroll() test========");
			navigateToSubMenu();
			Thread.sleep(1000);
			
			scrollToMobileElement("Settings");

			log.info("======= finished testScroll() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testScroll() test========");
			e.printStackTrace();
			Assert.fail();

		}
	}

	public void navigateToSubMenu() {
		driver.findElement(By.id("txt_signin")).click();
		driver.findElement(By.id("ed_email_login")).sendKeys("deepak.g@applify.com");
		driver.findElement(By.id("ed_password_login")).sendKeys("deepak123");
		driver.findElement(By.id("txt_login")).click();
		driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
	}

	public void scrollToMobileElement(String visibleText) {
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))"));

	}

	@BeforeClass
	public static void launchAppOnEmulator() throws IOException {
		PropertyConfigurator.configure("log4j.properties");

		File file = new File(System.getProperty("user.dir") + "/src/com/pom/comUtil/config.properties");
		FileInputStream fis = new FileInputStream(file);
		OR.load(fis);

		// Set the Desired Capabilities
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, OR.getProperty("PLATFORM_VERSION"));
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, TimeUnit.SECONDS.toSeconds(60));
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, OR.getProperty("APP_PACKAGE_NAME"));
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, OR.getProperty("APP_ACTIVITY_NAME"));

		// Instantiate Appium Driver
		try {
			driver = new AndroidDriver<MobileElement>(new URL(OR.getProperty("URL")), capabilities);
			log.info("Driver : " + driver);
			Assert.assertNotNull(driver);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

			log.info("App launched successfully.");
		} catch (MalformedURLException e) {
			log.error(e.getMessage());
		}
	}

	@AfterTest
	public void closeApp() {
		if (driver != null) {
			driver.quit();
			log.info("Application closed successfully.");
		}

	}

}
