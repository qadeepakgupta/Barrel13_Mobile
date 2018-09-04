package com.test.forgetPasswordModule;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;
import com.pom.pageObjects.ForgetPasswordPage;
import com.pom.pageObjects.HomePage;
import com.pom.pageObjects.LoginPage;

public class TC_001_VerifyForgetPasswordScreenHeaderName extends TestBase {

	private static final Logger log = Logger.getLogger(TC_001_VerifyForgetPasswordScreenHeaderName.class.getName());

	@Test
	public void testForgetPasswordScreenHeaderName() throws InterruptedException {
		try {

			log.info("======= starting testForgetPasswordScreenHeaderName() test========");
			HomePage hPage = new HomePage(driver);
			hPage.clickOnLoginButton();

			LoginPage lPage = new LoginPage(driver);
			lPage.clickOnForgetPasswordLink();

			ForgetPasswordPage fPage = new ForgetPasswordPage(driver);
			Assert.assertEquals(fPage.getHeaderNameText(), "FORGOT PASSWORD?");

			log.info("======= finished testForgetPasswordScreenHeaderName() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testForgetPasswordScreenHeaderName() test========");
			e.printStackTrace();
			Assert.fail();

		}
	}
}