package com.pom.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.pom.comUtil.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignUpPage {
	private static final Logger log = Logger.getLogger(SignUpPage.class.getName());
	private AppiumDriver<MobileElement> driver;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'CREATE ACCOUNT')]")
	private MobileElement txt_SignUpHeaderName;

	@CacheLookup
	@AndroidFindBy(className = "UIAKeyboard")
	private MobileElement keyboard;

	@CacheLookup
	@AndroidFindBy(id = "img_back")
	private MobileElement btn_BackSign;

	@CacheLookup
	@AndroidFindBy(id = "ed_full_name")
	private MobileElement txtBox_FullName;

	@CacheLookup
	@AndroidFindBy(id = "ed_gst")
	private MobileElement txtBox_GSTNo;

	@CacheLookup
	@AndroidFindBy(id = "ed_firm_name")
	private MobileElement txtBox_FirmName;

	@CacheLookup
	@AndroidFindBy(id = "ed_email_login")
	private MobileElement txtBox_Email;

	@CacheLookup
	@AndroidFindBy(id = "ed_password_login")
	private MobileElement txtBox_Password;

	@CacheLookup
	@AndroidFindBy(id = "ed_firm_name")
	private MobileElement txtBox_LocalStoreName;

	@CacheLookup
	@AndroidFindBy(id = "ed_local_address")
	private MobileElement txtBox_LocalStoreAddress;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Already Registered?')]")
	private MobileElement txt_AlreadyRegistered;

	@CacheLookup
	@AndroidFindBy(id = "txt_login")
	private MobileElement btn_Login;

	@CacheLookup
	@AndroidFindBy(id = "txt_signup")
	private MobileElement btn_SignUp;

	@CacheLookup
	@AndroidFindBy(id = "snackbar_text")
	private MobileElement errMessage;

	@CacheLookup
	@AndroidFindBy(id = "--------------")
	private MobileElement infoMessage;

	public SignUpPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}

	public void hideUIKeyboard() {
		driver.hideKeyboard();
	}

	public String getHeaderNameText() {
		log("Header Name is : " + txt_SignUpHeaderName.getText());
		return txt_SignUpHeaderName.getText();
	}

	public void typeFullName(String fullName) {
		txtBox_FullName.sendKeys(fullName);
		log("entered full name is:- " + fullName);
	}

	public void typeGSTNo(String gstNo) {
		txtBox_GSTNo.sendKeys(gstNo);
		log("entered gst no is:- " + gstNo);
	}

	public void typeFirmName(String firmName) {
		txtBox_FirmName.sendKeys(firmName);
		log("entered Firm name is:- " + firmName);
	}

	public void typeEmail(String email) {
		txtBox_Email.sendKeys(email);
		log("entered email is:- " + email);
	}

	public void typePassword(String password) {
		txtBox_Password.sendKeys(password);
		log("entered password is:- " + password);
	}

	public void clickOnSignUpButton() {
		btn_SignUp.click();
		log("clicked on signup button");
	}

	public void typeLocalStoreName(String localStoreName) {
		txtBox_LocalStoreName.sendKeys(localStoreName);
		log("entered local store name is:- " + localStoreName);
	}

	public void typeLocalStoreAddress(String localStoreAddress) {
		txtBox_LocalStoreAddress.sendKeys(localStoreAddress);
		log("entered local store address is:- " + localStoreAddress);
	}

	public String getErrorMessageText() {
		waitForVisibilityOfElement(60, errMessage);
		log("Error Message is : " + errMessage.getText());
		return errMessage.getText();
	}

	public void waitForVisibilityOfElement(int timeLimitInSeconds, MobileElement mobileElement) {
		WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
		wait.until(ExpectedConditions.visibilityOf(mobileElement));
	}

	public void signUpToAppWithAlreadySeller(String fullName, String gstNo, String firmName, String email, String password) {
		typeFullName(fullName);
		typeGSTNo(gstNo);
		typeFirmName(firmName);
		typeEmail(email);
		TestBase.scrollToMobileElement("Password");
		typePassword(password);
		clickOnSignUpButton();

	}

	public void signUpToAppWithNewSeller(String fullName, String gstNo, String email, String localStoreName,
			String localStoreAddress, String password) {

		typeFullName(fullName);
		typeGSTNo(gstNo);
		typeEmail(email);
		typeLocalStoreName(localStoreName);
		TestBase.scrollToMobileElement("Password");
		typeLocalStoreAddress(localStoreAddress);
		typePassword(password);
		clickOnSignUpButton();
	}
}