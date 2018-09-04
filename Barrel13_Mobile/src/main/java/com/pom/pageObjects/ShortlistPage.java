package com.pom.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ShortlistPage {

	private static final Logger log = Logger.getLogger(ShortlistPage.class.getName());
	public AppiumDriver<MobileElement> driver;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'txt_title')]")
	private MobileElement txt_ShortlistHeaderName;

	public ShortlistPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}

	public String getHeaderNameText() {
		log("Header Name is : " + txt_ShortlistHeaderName.getText());
		return txt_ShortlistHeaderName.getText();
	}
}
