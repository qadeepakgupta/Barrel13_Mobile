package com.test.signUpModule;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;
import com.pom.pageObjects.HomePage;
import com.pom.pageObjects.SignUpPage;

public class TC_007_VerifySignUpNewSellerWithInvalidData extends TestBase {

	private static final Logger log = Logger.getLogger(TC_007_VerifySignUpNewSellerWithInvalidData.class.getName());

	@Test
	public void testSignUpNewSellerWithInvalidData() throws InterruptedException {
		try {

			log.info("======= starting testSignUpNewSellerWithInvalidData() test========");
			HomePage hPage = new HomePage(driver);
			hPage.clickOnNewSellerOnAmazonButton();

			SignUpPage sPage = new SignUpPage(driver);
			sPage.signUpToAppWithNewSeller(OR.getProperty("INVALIDFULLNAME"), OR.getProperty("INVALIDGSTNO"),
					OR.getProperty("INVALIDSIGNUPEMAIL"), OR.getProperty("INVALIDSIGNUPSTORENAME"),
					OR.getProperty("INVALIDSIGNUPSTOREADDRESS"), OR.getProperty("INVALIDSIGNUPPASSWORD"));

			Assert.assertEquals(sPage.getHeaderNameText(), "CREATE ACCOUNT");

			log.info("======= finished testSignUpNewSellerWithInvalidData() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testSignUpNewSellerWithInvalidData() test========");
			e.printStackTrace();
			Assert.fail();

		}
	}

}
