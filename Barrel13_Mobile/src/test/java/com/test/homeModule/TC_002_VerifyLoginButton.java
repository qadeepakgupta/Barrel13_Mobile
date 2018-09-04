package com.test.homeModule;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;
import com.pom.pageObjects.HomePage;

public class TC_002_VerifyLoginButton extends TestBase {

	private static final Logger log = Logger.getLogger(TC_002_VerifyLoginButton.class.getName());

	@Test
	public void testLoginButton() throws InterruptedException {
		try {

			log.info("======= starting testSignUpButton() test========");
			HomePage hPage = new HomePage(driver);
			hPage.clickOnLoginButton();

			log.info("======= finished testSignUpButton() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testSignUpButton() test========");
			e.printStackTrace();
			Assert.fail();

		}
	}

}
