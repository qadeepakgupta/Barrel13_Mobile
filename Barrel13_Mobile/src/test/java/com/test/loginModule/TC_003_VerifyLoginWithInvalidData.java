package com.test.loginModule;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;
import com.pom.pageObjects.HomePage;
import com.pom.pageObjects.LoginPage;

public class TC_003_VerifyLoginWithInvalidData extends TestBase {
	private static final Logger log = Logger.getLogger(TC_003_VerifyLoginWithInvalidData.class.getName());

	@Test
	public void testLoginWithInvalidData() throws InterruptedException {
		try {

			log.info("======= starting testLoginWithInvalidData() test========");
			HomePage hPage = new HomePage(driver);
			hPage.clickOnLoginButton();

			LoginPage lPage = new LoginPage(driver);
			lPage.loginToApp(OR.getProperty("INVALIDEMAIL"), OR.getProperty("INVALIDPASSWORD"));

			Assert.assertEquals(lPage.getErrorMessageText(), "Please enter a valid email");

			log.info("======= finished testLoginWithInvalidData() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testLoginWithInvalidData() test========");
			e.printStackTrace();
			Assert.fail();
		}

	}

}