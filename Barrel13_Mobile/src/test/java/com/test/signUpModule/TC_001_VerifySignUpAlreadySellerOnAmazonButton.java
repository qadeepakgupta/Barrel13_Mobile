package com.test.signUpModule;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;
import com.pom.pageObjects.HomePage;

public class TC_001_VerifySignUpAlreadySellerOnAmazonButton extends TestBase {

	private static final Logger log = Logger.getLogger(TC_001_VerifySignUpAlreadySellerOnAmazonButton.class.getName());

	@Test
	public void testSignUpAlreadySellerOnAmazonButton() throws InterruptedException {
		try {

			log.info("======= starting testSignUpAlreadySellerOnAmazonButton() test========");
			HomePage hPage = new HomePage(driver);
			hPage.clickOnAlreadySellerOnAmazonButton();

			log.info("======= finished testSignUpAlreadySellerOnAmazonButton() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testSignUpAlreadySellerOnAmazonButton() test========");
			e.printStackTrace();
			Assert.fail();

		}
	}

}
