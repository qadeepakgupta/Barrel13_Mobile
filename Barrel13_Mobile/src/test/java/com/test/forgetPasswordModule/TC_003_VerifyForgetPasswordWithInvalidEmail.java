package com.test.forgetPasswordModule;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;
import com.pom.pageObjects.ForgetPasswordPage;
import com.pom.pageObjects.HomePage;
import com.pom.pageObjects.LoginPage;

public class TC_003_VerifyForgetPasswordWithInvalidEmail extends TestBase {

	private static final Logger log = Logger.getLogger(TC_003_VerifyForgetPasswordWithInvalidEmail.class.getName());

	@Test
	public void testForgetPasswordWithInvalidEmail() throws InterruptedException {
		try {

			log.info("======= starting testForgetPasswordWithInvalidEmail() test========");
			HomePage hPage = new HomePage(driver);
			hPage.clickOnLoginButton();

			LoginPage lPage = new LoginPage(driver);
			lPage.clickOnForgetPasswordLink();

			ForgetPasswordPage fPage = new ForgetPasswordPage(driver);
			fPage.forgetPassword(OR.getProperty("INVALIDFORGETEMAIL"));

			Assert.assertEquals(fPage.getHeaderNameText(), "FORGOT PASSWORD?");

			log.info("======= finished testForgetPasswordWithInvalidEmail() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testForgetPasswordWithInvalidEmail() test========");
			e.printStackTrace();
			Assert.fail();

		}
	}
}