package com.test.signUpModule;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;
import com.pom.pageObjects.HomePage;

public class TC_002_VerifySignUpNewSellerOnAmazonButton extends TestBase {

	private static final Logger log = Logger.getLogger(TC_002_VerifySignUpNewSellerOnAmazonButton.class.getName());

	@Test
	public void testSignUpNewSellerOnAmazonButton() throws InterruptedException {
		try {

			log.info("======= starting testSignUpNewSellerOnAmazonButton() test========");
			HomePage hPage = new HomePage(driver);
			hPage.clickOnNewSellerOnAmazonButton();

			log.info("======= finished testSignUpNewSellerOnAmazonButton() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testSignUpNewSellerOnAmazonButton() test========");
			e.printStackTrace();
			Assert.fail();

		}
	}

}