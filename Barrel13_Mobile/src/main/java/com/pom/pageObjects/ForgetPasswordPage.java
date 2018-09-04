package com.pom.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ForgetPasswordPage {

	private static final Logger log = Logger.getLogger(ForgetPasswordPage.class.getName());
	private AppiumDriver<MobileElement> driver;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'FORGOT PASSWORD?')]")
	private MobileElement txt_ForgetPasswordHeaderName;

	@CacheLookup
	@AndroidFindBy(className = "UIAKeyboard")
	private MobileElement keyboard;

	@CacheLookup
	@AndroidFindBy(id = "ed_email_login")
	private MobileElement txtBox_Email;

	@CacheLookup
	@AndroidFindBy(id = "txt_reset")
	private MobileElement btn_Reset;

	@CacheLookup
	@AndroidFindBy(id = "snackbar_text")
	private MobileElement errMessage;

	@CacheLookup
	@AndroidFindBy(id = "snackbar_text")
	private MobileElement infoMessage;

	public ForgetPasswordPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}

	public String getHeaderNameText() {
		log("Header Name is : " + txt_ForgetPasswordHeaderName.getText());
		return txt_ForgetPasswordHeaderName.getText();
	}

	public void hideUIKeyboard() {
		driver.hideKeyboard();
	}

	public void typeEmail(String email) {
		txtBox_Email.sendKeys(email);
		log("entered email is:- " + email);
	}

	public void clickOnReset() {
		btn_Reset.click();
		log("clicked on reset button");
	}

	public String getErrorMessageText() {
		waitForVisibilityOfElement(60, errMessage);
		log("error message is : " + errMessage.getText());
		return errMessage.getText();
	}

	public void waitForVisibilityOfElement(int timeLimitInSeconds, MobileElement mobileElement) {
		WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
		wait.until(ExpectedConditions.visibilityOf(mobileElement));
	}

	public void forgetPassword(String email) {
		typeEmail(email);
		clickOnReset();
	}

}
