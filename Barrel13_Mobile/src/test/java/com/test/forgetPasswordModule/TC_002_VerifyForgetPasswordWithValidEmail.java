package com.test.forgetPasswordModule;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;
import com.pom.pageObjects.ForgetPasswordPage;
import com.pom.pageObjects.HomePage;
import com.pom.pageObjects.LoginPage;

public class TC_002_VerifyForgetPasswordWithValidEmail extends TestBase {

	private static final Logger log = Logger.getLogger(TC_002_VerifyForgetPasswordWithValidEmail.class.getName());

	@Test
	public void testForgetPasswordWithValidEmail() throws InterruptedException {
		try {

			log.info("======= starting testForgetPasswordWithValidEmail() test========");
			HomePage hPage = new HomePage(driver);
			hPage.clickOnLoginButton();

			LoginPage lPage = new LoginPage(driver);
			lPage.clickOnForgetPasswordLink();

			ForgetPasswordPage fPage = new ForgetPasswordPage(driver);
			fPage.forgetPassword(OR.getProperty("FORGETEMAIL"));

			Assert.assertEquals(lPage.getHeaderNameText(), "LOGIN");

			log.info("======= finished testForgetPasswordWithValidEmail() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testForgetPasswordWithValidEmail() test========");
			e.printStackTrace();
			Assert.fail();

		}
	}
}