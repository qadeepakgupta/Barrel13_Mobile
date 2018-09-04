package com.pom.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageObjectManager {

	private AppiumDriver<MobileElement> driver;
	private HomePage hPage;
	private SignUpPage sPage;
	private LoginPage lPage;
	private DashboardPage dPage;

	public PageObjectManager(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public HomePage getHomePage() {
		return (hPage == null) ? hPage = new HomePage(driver) : hPage;
	}

	public SignUpPage getSignUpPage() {
		return (sPage == null) ? sPage = new SignUpPage(driver) : sPage;
	}

	public LoginPage getLoginPage() {
		return (lPage == null) ? lPage = new LoginPage(driver) : lPage;
	}

	public DashboardPage getDashboardPage() {
		return (dPage == null) ? dPage = new DashboardPage(driver) : dPage;
	}
}