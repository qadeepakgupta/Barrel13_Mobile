package com.test.dashboardModule;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;
import com.pom.pageObjects.DashboardPage;
import com.pom.pageObjects.HomePage;
import com.pom.pageObjects.LoginPage;

public class TC_008_VerifyDashboardRecentlyTrackedBrandsDisplayed extends TestBase {

	private static final Logger log = Logger.getLogger(TC_008_VerifyDashboardRecentlyTrackedBrandsDisplayed.class.getName());

	@Test
	public void testDashboardRecentlyTrackedBrandsDisplayed() throws InterruptedException {
		try {

			log.info("======= starting testDashboardRecentlyTrackedBrandsDisplayed() test========");
			HomePage hPage = new HomePage(driver);
			hPage.clickOnLoginButton();

			LoginPage lPage = new LoginPage(driver);
			lPage.loginToApp(OR.getProperty("EMAIL"), OR.getProperty("PASSWORD"));

			DashboardPage dPage = new DashboardPage(driver);
			Assert.assertEquals(dPage.checkRecentTrackedBrandsDisplayed(), true);

			log.info("======= finished testDashboardRecentlyTrackedBrandsDisplayed() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testDashboardRecentlyTrackedBrandsDisplayed() test========");
			e.printStackTrace();
			Assert.fail();

		}
	}
}