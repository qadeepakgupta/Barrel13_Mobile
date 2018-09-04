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

public class LoginPage {
	private static final Logger log = Logger.getLogger(LoginPage.class.getName());
	private AppiumDriver<MobileElement> driver;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'LOGIN')]")
	private MobileElement txt_LoginHeaderName;

	@CacheLookup
	@AndroidFindBy(className = "UIAKeyboard")
	private MobileElement keyboard;

	@CacheLookup
	@AndroidFindBy(id = "ed_email_login")
	private MobileElement txtBox_Email;

	@CacheLookup
	@AndroidFindBy(id = "ed_password_login")
	private MobileElement txtBox_Password;

	@CacheLookup
	@AndroidFindBy(id = "txt_login")
	private MobileElement btn_Login;

	@CacheLookup
	@AndroidFindBy(id = "txt_forgot_password")
	private MobileElement link_ForgetPassword;

	@CacheLookup
	@AndroidFindBy(id = "snackbar_text")
	private MobileElement errMessage;

	public LoginPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}

	public String getHeaderNameText() {
		log("header name is : " + txt_LoginHeaderName.getText());
		return txt_LoginHeaderName.getText();
	}

	public void typeEmail(String email) {
		txtBox_Email.sendKeys(email);
		log("entered email is:- " + email);
	}

	public void typePassword(String password) {
		txtBox_Password.sendKeys(password);
		log("entered password is:- " + password);
	}

	public void clickOnLoginButton() {
		btn_Login.click();
		log("clicked on login button");
	}
	
	public void clickOnForgetPasswordLink() {
		link_ForgetPassword.click();
		log("clicked on forget password link");
	}

	public boolean isDisplayedLoginButton() {
		return btn_Login.isDisplayed();
	}

	public void hideUIKeyboard() {
		driver.hideKeyboard();
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

	public void loginToApp(String email, String password) {
		typeEmail(email);
		typePassword(password);
		txtBox_Password.click();
		hideUIKeyboard();
		clickOnLoginButton();
	}

}