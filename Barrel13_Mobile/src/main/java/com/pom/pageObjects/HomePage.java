package com.pom.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

	private static final Logger log = Logger.getLogger(HomePage.class.getName());

	@CacheLookup
	@AndroidFindBy(id = "txt_walk")
	private MobileElement txt_HomeHeaderName;

	@CacheLookup
	@AndroidFindBy(id = "txt_signup")
	private MobileElement btn_SignUp;

	@CacheLookup
	@AndroidFindBy(id = "txt_signin")
	private MobileElement btn_Login;

	@CacheLookup
	@AndroidFindBy(id = "ll_already")
	private MobileElement btn_AlreadySellerOnAmazon;

	@CacheLookup
	@AndroidFindBy(id = "ll_new_user")
	private MobileElement btn_NewSellerOnAmazon;

	public HomePage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}

	public boolean isDisplayedLoginButton() {
		return btn_Login.isDisplayed();
	}

	public String getHeaderNameText() {
		log("Header Name is : " + txt_HomeHeaderName.getText());
		return txt_HomeHeaderName.getText();
	}

	public void clickOnSignupButton() {
		if (btn_SignUp.isDisplayed() || btn_SignUp.isEnabled()) {
			log("signup button is enabled and displayed.");
			btn_SignUp.click();
			log("clicked on Sign up button");
		} else {
			log.error("signup button is not enabled or displayed.");
			Assert.fail();
		}

	}

	public void clickOnLoginButton() {

		if (btn_Login.isDisplayed() || btn_Login.isEnabled()) {
			log("login button is enabled and displayed.");
			btn_Login.click();
			log("clicked on Login button");
		} else {
			log.error("login button is not enabled or displayed.");
			Assert.fail();
		}

	}

	public void clickOnAlreadySellerOnAmazonButton() {
		clickOnSignupButton();
		if (btn_AlreadySellerOnAmazon.isDisplayed() || btn_AlreadySellerOnAmazon.isEnabled()) {
			log("Already a Seller On Amazon Button is enabled and displayed.");
			btn_AlreadySellerOnAmazon.click();
			log("clicked on Already a Seller On Amazon Button.");
		} else {
			log.error("Already a Seller On Amazon Button is not enabled or displayed.");
			Assert.fail();
		}
	}

	public void clickOnNewSellerOnAmazonButton() {
		clickOnSignupButton();
		if (btn_NewSellerOnAmazon.isDisplayed() || btn_NewSellerOnAmazon.isEnabled()) {
			log("New Seller On Amazon Button is enabled and displayed.");
			btn_NewSellerOnAmazon.click();
			log("clicked on New Seller On Amazon Button.");
		} else {
			log.error("New Seller On Amazon Button is not enabled or displayed.");
			Assert.fail();
		}
	}
}