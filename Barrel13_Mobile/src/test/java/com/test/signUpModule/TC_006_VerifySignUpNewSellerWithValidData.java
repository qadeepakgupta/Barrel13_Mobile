package com.test.signUpModule;

import java.util.Random;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;
import com.pom.pageObjects.HomePage;
import com.pom.pageObjects.SignUpPage;
import com.pom.pageObjects.VerifyYourEmailPage;

public class TC_006_VerifySignUpNewSellerWithValidData extends TestBase {

	private static final Logger log = Logger.getLogger(TC_006_VerifySignUpNewSellerWithValidData.class.getName());
	Random r = new Random();
	String fullName = "full"+r.nextInt();
	String gstNo    = "87"+r.nextInt();
	String email    = "email"+r.nextInt();
	String storeName= "lname"+r.nextInt();
	String address  = "address"+r.nextInt();
	String password = "pass"+r.nextInt();

	@Test
	public void testSignUpNewSellerWithValidData() throws InterruptedException {
		try {

			log.info("======= starting testSignUpNewSellerWithValidData() test========");
			HomePage hPage = new HomePage(driver);
			hPage.clickOnNewSellerOnAmazonButton();

			SignUpPage sPage = new SignUpPage(driver);
			sPage.signUpToAppWithNewSeller(fullName,  "GST"+gstNo, email+"@gmail.com", storeName, address, password); 

			VerifyYourEmailPage vPage = new VerifyYourEmailPage(driver);
			Assert.assertEquals(vPage.getHeaderNameText(), "VERIFY YOUR EMAIL");

			log.info("======= finished testSignUpNewSellerWithValidData() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testSignUpNewSellerWithValidData() test========");
			e.printStackTrace();
			Assert.fail();

		}
	}

}
