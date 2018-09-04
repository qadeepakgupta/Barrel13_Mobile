package com.pom.comUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

/**
 * 
 * Maven Project TestBase Class
 * 
 * @author Applify
 *
 */

public class TestBase {
	public static AppiumDriver<MobileElement> driver;
	private static final Logger log = Logger.getLogger(TestBase.class.getName());
	public static Properties OR = new Properties();
	public static DesiredCapabilities capabilities;

	static String scrShotDir = "screenshots";
	static File scrShotDirPath = new File("./" + scrShotDir + "//");
	static String destFile;

	public static ExtentReports extent;
	public static ExtentTest test;
	public ITestResult result;

	static {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ss_aa");
		extent = new ExtentReports(System.getProperty("user.dir") + "/src/main/java/com/pom/report/Extent_Report_"
				+ formater.format(calendar.getTime()) + ".html", false);
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws IOException {

		launchAppOnEmulator();
		// launchAppOnRealDevice();
	}

	public static void launchAppOnEmulator() throws IOException {

		loadData();
		File appDir = new File("App");
		File app = new File(appDir, "Barrel13.apk");

		// Set the Desired Capabilities
		capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, OR.getProperty("PLATFORM_VERSION"));
		capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30);
		// capabilities.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);
		capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, OR.getProperty("APP_PACKAGE_NAME"));
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, OR.getProperty("APP_ACTIVITY_NAME"));
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

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

	public static void launchAppOnRealDevice() throws IOException {
		loadData();
		File appDir = new File("App");
		File app = new File(appDir, "Barrel13.apk");

		// Set the Desired Capabilities
		capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "My Phone");
		capabilities.setCapability(MobileCapabilityType.UDID, OR.getProperty("UDID"));
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, OR.getProperty("PLATFORM_VERSION"));
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

		// capabilities.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);
		capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, OR.getProperty("APP_PACKAGE_NAME"));
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, OR.getProperty("APP_ACTIVITY_NAME"));
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		// Instantiate Appium Driver
		try {
			driver = new AndroidDriver<MobileElement>(new URL(OR.getProperty("URL")), capabilities);
			log.info("Driver : " + driver);
			Assert.assertNotNull(driver);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			log.info("App launched successfully.");
		} catch (MalformedURLException e) {
			log.error(e.getMessage());
		}
	}

	public static void loadData() throws IOException {
		File file = new File(System.getProperty("user.dir") + "/src/main/java/com/pom/comUtil/config.properties");
		FileInputStream fis = new FileInputStream(file);
		OR.load(fis);
		PropertyConfigurator.configure("log4j.properties");
	}

	// take screen shot and image saved in random name.
	public static String takeScreenShot(AppiumDriver<WebElement> driver) {

		File targetFile = null;
		try {

			File srcFile = driver.getScreenshotAs(OutputType.FILE);
			String fileName = UUID.randomUUID().toString();
			targetFile = new File("./screenshots/" + fileName + ".png");
			FileUtils.copyFile(srcFile, targetFile);
			System.out.println(targetFile.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return targetFile.toString();

	}

	public static String getToastMessageFromSaveImage() {

		String imgName = takeScreenShot();
		String result = null;
		File imageFile = new File(scrShotDirPath, imgName);
		System.out.println("Image name is :" + imageFile.toString());

		ITesseract instance = new Tesseract();

		// In case you don't have your own tessdata, let it also be extracted for you
		File tessDataFolder = LoadLibs.extractTessResources("tessdata");

		// Set the tessdata path
		instance.setDatapath(tessDataFolder.getAbsolutePath());

		try {
			result = instance.doOCR(imageFile);
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public static String getToastMessageWithoutSaveImage() {

		String result = null;

		File srcFile = driver.getScreenshotAs(OutputType.FILE);
		ITesseract instance = new Tesseract();

		// In case you don't have your own tessdata, let it also be extracted for you
		File tessDataFolder = LoadLibs.extractTessResources("tessdata");

		// Set the tessdata path
		instance.setDatapath(tessDataFolder.getAbsolutePath());

		try {
			result = instance.doOCR(srcFile);
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	// Take screen shot and image saved into date format
	public static String takeScreenShot() {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ss_aa");
		// Create folder under project with name "screenshots" if doesn't exist
		new File(scrShotDir).mkdirs();
		// Set file name
		destFile = dateFormat.format(new Date()) + ".png";
		try {
			// Copy
			FileUtils.copyFile(scrFile, new File(scrShotDir + "/" + destFile));
		} catch (IOException e) {
			System.out.println("Image not transfered to screenshot folder");
			e.printStackTrace();
		}
		return destFile;
	}

	public static String getToastMessage() throws TesseractException {
		String imgName = takeScreenShot();
		String result = null;
		File imageFile = new File(scrShotDirPath, imgName);
		System.out.println("Image name is :" + imageFile.toString());
		ITesseract instance = new Tesseract();
		// Extracts
		File tessDataFolder = LoadLibs.extractTessResources("tessdata");
		// sets tessData
		instance.setDatapath(tessDataFolder.getAbsolutePath());

		try {
			result = instance.doOCR(imageFile);
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public void screenRotate() {
		if (driver.getOrientation().equals("LANDSCAPE")) {
			switchtomode("PORTRAIT");
			switchtomode("LANDSCAPE");
		} else {
			switchtomode("LANDSCAPE");
		}

	}

	public void switchtomode(String modeType) {
		ScreenOrientation currentOrientation = driver.getOrientation();
		System.out.println("CurrentOrientation : " + currentOrientation);
		if (modeType.equalsIgnoreCase("LANDSCAPE"))
			driver.rotate(ScreenOrientation.LANDSCAPE);
		else if (modeType.equalsIgnoreCase("PORTRAIT")) {
			driver.rotate(ScreenOrientation.PORTRAIT);
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		currentOrientation = driver.getOrientation();
		System.out.println("AfterRotate : " + currentOrientation);
	}

	public static void scrollToMobileElement(String visibleText) {
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))"));
	}

	public void getScreenShot(WebDriver driver, ITestResult result, String folderName) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ss_aa");

		String methodName = result.getName();

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/pom/";
			File destFile = new File((String) reportDirectory + "/" + folderName + "/" + methodName + "_"
					+ formater.format(calendar.getTime()) + ".png");

			FileUtils.copyFile(scrFile, destFile);

			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
					+ "' height='100' width='100'/> </a>");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getScreenShotOnSucess(WebDriver driver, ITestResult result) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ss_aa");

		String methodName = result.getName();

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/pom/";
			File destFile = new File((String) reportDirectory + "/failure_screenshots/" + methodName + "_"
					+ formater.format(calendar.getTime()) + ".png");

			FileUtils.copyFile(scrFile, destFile);

			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
					+ "' height='100' width='100'/> </a>");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String captureScreen(String fileName) {
		if (fileName == "") {
			fileName = "Issue_Screenshot";
		}
		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ss_aa");

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "/src/main/java/com/pom/screenshot/";
			destFile = new File((String) reportDirectory + fileName + "_" + formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(scrFile, destFile);
			// This will help us to link the screen shot in testNG report
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
					+ "' height='100' width='100'/> </a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile.toString();
	}

	public void log(String data) {
		log.info(data);
		Reporter.log(data);
		test.log(LogStatus.INFO, data);
	}

	public void getresult(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result.getName() + " test is pass");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.ERROR, result.getName() + " test is failed" + result.getThrowable());
			String screen = captureScreen("");
			test.log(LogStatus.FAIL, test.addScreenCapture(screen));
		} else if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName() + " test is started");
		}
	}

	@AfterMethod()
	public void afterMethod(ITestResult result) {
		getresult(result);
		test.log(LogStatus.INFO, result.getName() + " test finished");
	}

	@BeforeMethod()
	public void beforeMethod(Method result) {
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
	}

	@AfterClass(alwaysRun = true)
	public void endTest() throws InterruptedException {
		closeApp();
	}

	public static void closeApp() throws InterruptedException {
		if (driver != null) {
			driver.quit();
			log.info("App closed successfully.");
		}
		extent.endTest(test);
		extent.flush();
	}

}