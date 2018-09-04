package com.test.signUpModule;

import java.util.Random;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;
import com.pom.pageObjects.HomePage;
import com.pom.pageObjects.SignUpPage;
import com.pom.pageObjects.VerifyYourEmailPage;

public class TC_004_VerifySignUpAlreadySellerWithValidData extends TestBase {

	private static final Logger log = Logger.getLogger(TC_004_VerifySignUpAlreadySellerWithValidData.class.getName());
	Random r = new Random();
	String fullName  = "full"+r.nextInt();
	String gstNo     = "87"+r.nextInt();
	String firmName  = "firm"+r.nextInt();
	String email     = "email"+r.nextInt();
	String password  = "pass"+r.nextInt();

	@Test
	public void testSignUpAlreadySellerWithValidData() throws InterruptedException {
		try {

			log.info("======= starting testSignUpAlreadySellerWithValidData() test========");
			HomePage hPage = new HomePage(driver);
			hPage.clickOnAlreadySellerOnAmazonButton();

			SignUpPage sPage = new SignUpPage(driver);
			sPage.signUpToAppWithAlreadySeller(fullName, "GST"+gstNo, firmName, email+"@gmail.com", password);

			VerifyYourEmailPage vPage = new VerifyYourEmailPage(driver);
			Assert.assertEquals(vPage.getHeaderNameText(), "VERIFY YOUR EMAIL");

			log.info("======= finished testSignUpAlreadySellerWithValidData() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testSignUpAlreadySellerWithValidData() test========");
			e.printStackTrace();
			Assert.fail();

		}
	}

}
