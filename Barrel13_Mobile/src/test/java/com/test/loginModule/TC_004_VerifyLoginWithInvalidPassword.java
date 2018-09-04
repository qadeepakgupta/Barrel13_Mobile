package com.test.loginModule;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;
import com.pom.pageObjects.HomePage;
import com.pom.pageObjects.LoginPage;

public class TC_004_VerifyLoginWithInvalidPassword extends TestBase {
	private static final Logger log = Logger.getLogger(TC_004_VerifyLoginWithInvalidPassword.class.getName());

	@Test
	public void testLoginWithInvalidPassword() throws InterruptedException {
		try {

			log.info("======= starting testLoginWithInvalidPassword() test========");
			HomePage hPage = new HomePage(driver);
			hPage.clickOnLoginButton();

			LoginPage lPage = new LoginPage(driver);
			lPage.loginToApp(OR.getProperty("EMAIL"), OR.getProperty("INVALIDPASSWORD"));

			Assert.assertEquals(lPage.getHeaderNameText(), "LOGIN");

			log.info("======= finished testLoginWithInvalidPassword() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testLoginWithInvalidPassword() test========");
			e.printStackTrace();
			Assert.fail();
		}

	}

}