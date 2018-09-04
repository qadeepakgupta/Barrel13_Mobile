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
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class SwipeExample {

	private static final Properties OR = new Properties();
	private static final Logger log = Logger.getLogger(ScrollExample.class.getName());
	private static AppiumDriver<MobileElement> driver;

	@Test
	public void testSwipe() throws InterruptedException {
		try {
			log.info("======= starting testSwipe() test========");

			navigateToSubMenu();
			swipeToBottom();

			log.info("======= finished testSwipe() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testSwipe() test========");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void swipeToBottom() {

		MobileElement onSource = driver.findElement(By.id("txt_email"));
		MobileElement onTarget = driver.findElement(By.xpath("//android.widget.TextView[@text='Settings']"));

		TouchActions action = new TouchActions(driver);
		action.longPress(onSource).moveToElement(onTarget).build().perform();

	}

	public void navigateToSubMenu() {
		driver.findElement(By.id("txt_signin")).click();
		driver.findElement(By.id("ed_email_login")).sendKeys("deepak.g@applify.co");
		driver.findElement(By.id("ed_password_login")).sendKeys("deepak123");
		driver.findElement(By.id("txt_login")).click();
		driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();

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
		capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, OR.getProperty("APP_PACKAGE_NAME"));
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, OR.getProperty("APP_ACTIVITY_NAME"));

		// Instantiate Appium Driver
		try {
			driver = new AndroidDriver<MobileElement>(new URL(OR.getProperty("URL")), capabilities);
			log.info("Driver : " + driver);
			Assert.assertNotNull(driver);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			log.info("App launched successfully.");
		} catch (MalformedURLException e) {
			log.error(e.getMessage());
		}
	}

	@AfterTest
	public void closeApp() {
		if (driver != null) {
			driver.quit();
			log.info("App closed successfully.");
		}

	}

}
