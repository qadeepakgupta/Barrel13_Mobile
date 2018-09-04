package com.pom.comUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class InstallApp {
	public static AppiumDriver<WebElement> driver;
	private static final Logger log = Logger.getLogger(TestBase.class.getName());
	public static Properties OR = new Properties();
	public static DesiredCapabilities capabilities;

	@Test
	public void appInstall() throws IOException {
		//launchAppOnRealDevice();
		 launchAppOnEmulator();
	}

	@AfterTest
	public void closeApp() {
		driver.quit();
		log.info("App closed successfully.");

	}

	public static void launchAppOnRealDevice() throws IOException {
		loadData();
		File appDir = new File("App");
		File app = new File(appDir, OR.getProperty("APP_NAME"));

		// Set the Desired Capabilities
		capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "My Phone");
		capabilities.setCapability(MobileCapabilityType.UDID, OR.getProperty("UDID"));
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, OR.getProperty("PLATFORM_VERSION"));
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		// Instantiate Appium Driver
		try {
			driver = new AndroidDriver<WebElement>(new URL(OR.getProperty("URL")), capabilities);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
			Assert.assertNotNull(driver);
			log.info("Driver : " + driver);
			log.info("App installed successfully.");
		} catch (MalformedURLException e) {
			log.error(e.getMessage());
		}
	}

	public static void loadData() throws IOException {
		File file = new File(System.getProperty("user.dir") + "/src/com/pom/comUtil/config.properties");
		FileInputStream fis = new FileInputStream(file);
		OR.load(fis);
		PropertyConfigurator.configure("log4j.properties");
	}

	public static void launchAppOnEmulator() throws IOException {

		loadData();
		File appDir = new File("App");
		File app = new File(appDir, OR.getProperty("APP_NAME"));

		// Set the Desired Capabilities
		capabilities = new DesiredCapabilities();

		// Set the Desired Capabilities
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, OR.getProperty("PLATFORM_VERSION"));
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		// Instantiate Appium Driver
		try {
			driver = new AndroidDriver<WebElement>(new URL(OR.getProperty("URL")), capabilities);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
			Assert.assertNotNull(driver);
			log.info("Driver : " + driver);
			log.info("App installed successfully.");
		} catch (MalformedURLException e) {
			log.error(e.getMessage());
		}
	}

}