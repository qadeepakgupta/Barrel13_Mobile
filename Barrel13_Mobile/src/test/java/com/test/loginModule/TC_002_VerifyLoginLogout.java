package com.test.loginModule;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;
import com.pom.pageObjects.DashboardPage;
import com.pom.pageObjects.HomePage;
import com.pom.pageObjects.LoginPage;

public class TC_002_VerifyLoginLogout extends TestBase {
	private static final Logger log = Logger.getLogger(TC_002_VerifyLoginLogout.class.getName());
	HomePage hPage;
	DashboardPage dPage;

	@Test
	public void testLogin() throws InterruptedException {
		try {

			log.info("======= starting testLogin() test========");
			hPage = new HomePage(driver);
			hPage.clickOnLoginButton();

			LoginPage lPage = new LoginPage(driver);
			lPage.loginToApp(OR.getProperty("EMAIL"), OR.getProperty("PASSWORD"));

			dPage = new DashboardPage(driver);
			Assert.assertEquals(dPage.getHeaderNameText(), "DASHBOARD");

			log.info("======= finished testLogin() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testLogin() test========");
			e.printStackTrace();
			Assert.fail();

		}
	}

	@Test(dependsOnMethods = "testLogin")
	public void testLogout() throws InterruptedException {
		try {
			log.info("======= starting testLogout() test========");

			dPage = new DashboardPage(driver);
			dPage.logoutApp();

			hPage = new HomePage(driver);
			Assert.assertTrue(hPage.isDisplayedLoginButton(), "Login Button is displayed.");

			log.info("======= finished testLogout() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testLogout() test========");
			e.printStackTrace();
			Assert.fail();

		}
	}

}