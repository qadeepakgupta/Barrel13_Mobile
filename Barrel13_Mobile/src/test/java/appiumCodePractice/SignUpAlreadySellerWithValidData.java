package appiumCodePractice;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;
import com.pom.pageObjects.HomePage;
import com.pom.pageObjects.SignUpPage;
import com.pom.pageObjects.VerifyYourEmailPage;

public class SignUpAlreadySellerWithValidData extends TestBase {

	private static final Logger log = Logger.getLogger(SignUpAlreadySellerWithValidData.class.getName());

	@Test
	public void testSignUpAlreadySellerWithValidData() throws InterruptedException {
		try {

			log.info("======= starting testSignUpAlreadySellerWithValidData() test========");
			HomePage hPage = new HomePage(driver);
			hPage.clickOnAlreadySellerOnAmazonButton();

			SignUpPage sPage = new SignUpPage(driver);
			sPage.signUpToAppWithAlreadySeller("Deepak Singh", "GST123456789034", "New Firm", "deepak.g1@applify.co",
					"deepak12345");

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
