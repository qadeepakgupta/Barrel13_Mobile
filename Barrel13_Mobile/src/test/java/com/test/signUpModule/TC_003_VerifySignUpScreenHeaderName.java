package com.test.signUpModule;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;
import com.pom.pageObjects.HomePage;
import com.pom.pageObjects.SignUpPage;

public class TC_003_VerifySignUpScreenHeaderName extends TestBase {

	private static final Logger log = Logger.getLogger(TC_003_VerifySignUpScreenHeaderName.class.getName());

	@Test
	public void testSignUpScreenHeaderName() throws InterruptedException {
		try {

			log.info("======= starting testSignUpScreenHeaderName() test========");
			HomePage hPage = new HomePage(driver);
			hPage.clickOnAlreadySellerOnAmazonButton();

			SignUpPage sPage = new SignUpPage(driver);
			Assert.assertEquals(sPage.getHeaderNameText(), "CREATE ACCOUNT");

			log.info("======= finished testSignUpScreenHeaderName() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testSignUpScreenHeaderName() test========");
			e.printStackTrace();
			Assert.fail();

		}
	}

}
