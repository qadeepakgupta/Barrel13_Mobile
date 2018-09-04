package com.test.loginModule;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;
import com.pom.pageObjects.HomePage;
import com.pom.pageObjects.LoginPage;

public class TC_001_VerifyLoginScreenHeaderName extends TestBase {

	private static final Logger log = Logger.getLogger(TC_001_VerifyLoginScreenHeaderName.class.getName());

	@Test
	public void testLoginScreenHeaderName() throws InterruptedException {
		try {

			log.info("======= starting testLoginScreenHeaderName() test========");
			HomePage hPage = new HomePage(driver);
			hPage.clickOnLoginButton();

			LoginPage lPage = new LoginPage(driver);
			Assert.assertEquals(lPage.getHeaderNameText(), "LOGIN");

			log.info("======= finished testLoginScreenHeaderName() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testLoginScreenHeaderName() test========");
			e.printStackTrace();
			Assert.fail();

		}
	}
}