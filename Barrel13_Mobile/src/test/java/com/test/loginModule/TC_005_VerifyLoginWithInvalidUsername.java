package com.test.loginModule;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;
import com.pom.pageObjects.HomePage;
import com.pom.pageObjects.LoginPage;

public class TC_005_VerifyLoginWithInvalidUsername extends TestBase {
	private static final Logger log = Logger.getLogger(TC_005_VerifyLoginWithInvalidUsername.class.getName());

	@Test
	public void testLoginWithInvalidUsername() throws InterruptedException {
		try {

			log.info("======= starting testLoginWithInvalidUsername() test========");
			HomePage hPage = new HomePage(driver);
			hPage.clickOnLoginButton();

			LoginPage lPage = new LoginPage(driver);
			lPage.loginToApp(OR.getProperty("INVALIDEMAIL"), OR.getProperty("PASSWORD"));

			Assert.assertEquals(lPage.getErrorMessageText(), "Please enter a valid email");

			log.info("======= finished testLoginWithInvalidUsername() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testLoginWithInvalidUsername() test========");
			e.printStackTrace();
			Assert.fail();
		}

	}

}