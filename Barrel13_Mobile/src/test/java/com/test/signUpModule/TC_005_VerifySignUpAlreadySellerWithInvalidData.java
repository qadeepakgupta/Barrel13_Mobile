package com.test.signUpModule;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;
import com.pom.pageObjects.HomePage;
import com.pom.pageObjects.SignUpPage;

public class TC_005_VerifySignUpAlreadySellerWithInvalidData extends TestBase {

	private static final Logger log = Logger.getLogger(TC_005_VerifySignUpAlreadySellerWithInvalidData.class.getName());

	@Test
	public void testSignUpAlreadySellerWithInvalidData() throws InterruptedException {
		try {

			log.info("======= starting testSignUpAlreadySellerWithInvalidData() test========");
			HomePage hPage = new HomePage(driver);
			hPage.clickOnAlreadySellerOnAmazonButton();

			SignUpPage sPage = new SignUpPage(driver);
			sPage.signUpToAppWithAlreadySeller(OR.getProperty("INVALIDFULLNAME"), OR.getProperty("INVALIDGSTNO"),
					OR.getProperty("INVALIDFIRMNAME"), OR.getProperty("INVALIDSIGNUPEMAIL"),
					OR.getProperty("INVALIDSIGNUPPASSWORD"));

			Assert.assertEquals(sPage.getHeaderNameText(), "CREATE ACCOUNT");

			log.info("======= finished testSignUpAlreadySellerWithInvalidData() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testSignUpAlreadySellerWithInvalidData() test========");
			e.printStackTrace();
			Assert.fail();

		}
	}

}
