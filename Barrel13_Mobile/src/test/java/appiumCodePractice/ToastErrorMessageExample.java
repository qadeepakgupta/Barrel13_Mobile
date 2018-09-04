package appiumCodePractice;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;
import com.pom.pageObjects.HomePage;
import com.pom.pageObjects.LoginPage;

public class ToastErrorMessageExample extends TestBase {

	private static final Logger log = Logger.getLogger(ToastErrorMessageExample.class.getName());

	@Test
	public void testLoginErrorMessage() throws InterruptedException {
		try {

			log.info("======= starting testLoginErrorMessage() test========");
			HomePage hPage = new HomePage(driver);
			hPage.clickOnLoginButton();

			LoginPage lPage = new LoginPage(driver);
			lPage.clickOnLoginButton();
			

			// Example 1
			//String getMessage = getToastMessageFromSaveImage(takeScreenShot(driver));
			//Assert.assertTrue(getMessage.contains("Please enter email"));

			// Example 2
			// String getMessage = getToastMessageWithoutSaveImage(driver);
			// Assert.assertTrue(getMessage.contains("Please enter email"));

			// Example 3
			 String getMessage = getToastMessage();
			 Assert.assertTrue(getMessage.contains("Please enter email"));

			log.info("======= finished testLoginErrorMessage() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testLoginErrorMessage() test========");
			e.printStackTrace();
			Assert.fail();

		}
	}

}