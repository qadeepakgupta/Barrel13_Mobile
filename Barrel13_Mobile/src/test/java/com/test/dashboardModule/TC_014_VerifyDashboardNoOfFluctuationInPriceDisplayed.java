package com.test.dashboardModule;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;
import com.pom.pageObjects.DashboardPage;
import com.pom.pageObjects.HomePage;
import com.pom.pageObjects.LoginPage;

public class TC_014_VerifyDashboardNoOfFluctuationInPriceDisplayed extends TestBase {

	private static final Logger log = Logger.getLogger(TC_014_VerifyDashboardNoOfFluctuationInPriceDisplayed.class.getName());

	@Test
	public void testDashboardNoOfFluctuationInPriceDisplayed() throws InterruptedException {
		try {

			log.info("======= starting testDashboardNoOfFluctuationInPriceDisplayed() test========");
			HomePage hPage = new HomePage(driver);
			hPage.clickOnLoginButton();

			LoginPage lPage = new LoginPage(driver);
			lPage.loginToApp(OR.getProperty("EMAIL"), OR.getProperty("PASSWORD"));

			DashboardPage dPage = new DashboardPage(driver);
			dPage.selectFluctuationInPrice();
			Assert.assertEquals(dPage.checkFlcutuateInPriceNoOfCountDisplayed(), true);

			log.info("======= finished testDashboardNoOfFluctuationInPriceDisplayed() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testDashboardNoOfFluctuationInPriceDisplayed() test========");
			e.printStackTrace();
			Assert.fail();

		}
	}
}