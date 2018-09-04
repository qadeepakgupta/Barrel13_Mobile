package com.pom.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VerifyYourEmailPage {

	private static final Logger log = Logger.getLogger(VerifyYourEmailPage.class.getName());
	private AppiumDriver<MobileElement> driver;

	@CacheLookup
	@AndroidFindBy(id = "txt_verify_email_header")
	private MobileElement txt_VerifyEmailHeaderName;

	@CacheLookup
	@AndroidFindBy(id = "txt_desc")
	private MobileElement txt_Description;

	@CacheLookup
	@AndroidFindBy(id = "txt_resend")
	private MobileElement btn_Resend;

	@CacheLookup
	@AndroidFindBy(id = "txt_login")
	private MobileElement btn_Login;

	@CacheLookup
	@AndroidFindBy(id = "img_close")
	private MobileElement link_CloseSign;

	public VerifyYourEmailPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}

	public String getHeaderNameText() {
		log("Header Name is : " + txt_VerifyEmailHeaderName.getText());
		return txt_VerifyEmailHeaderName.getText();
	}

	public String getDescriptionText() {
		log("Description Text is : " + txt_Description.getText());
		return txt_Description.getText();
	}

	public void clickOnResendButton() {
		btn_Resend.click();
		log("clicked on Resend button");
	}

	public void hideUIKeyboard() {
		driver.hideKeyboard();
	}

	public void clickOnLoginButton() {
		btn_Login.click();
		log("clicked on Login button");
	}

	public boolean isDisplayedResendButton() {
		return btn_Resend.isDisplayed();
	}

}
