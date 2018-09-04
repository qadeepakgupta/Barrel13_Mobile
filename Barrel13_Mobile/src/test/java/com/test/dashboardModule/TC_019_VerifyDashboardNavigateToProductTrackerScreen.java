package com.test.dashboardModule;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;
import com.pom.pageObjects.DashboardPage;
import com.pom.pageObjects.HomePage;
import com.pom.pageObjects.LoginPage;
import com.pom.pageObjects.ProductTrackerPage;

public class TC_019_VerifyDashboardNavigateToProductTrackerScreen extends TestBase {

	private static final Logger log = Logger.getLogger(TC_019_VerifyDashboardNavigateToProductTrackerScreen.class.getName());

	@Test
	public void testDashboardNavigateToProductTrackerScreen() throws InterruptedException {
		try {

			log.info("======= starting testDashboardNavigateToProductTrackerScreen() test========");
			HomePage hPage = new HomePage(driver);
			hPage.clickOnLoginButton();

			LoginPage lPage = new LoginPage(driver);
			lPage.loginToApp(OR.getProperty("EMAIL"), OR.getProperty("PASSWORD"));

			DashboardPage dPage = new DashboardPage(driver);
			dPage.clickOnProductTrackerButton();

			ProductTrackerPage pPage = new ProductTrackerPage(driver);
			Assert.assertEquals(pPage.getHeaderNameText(), "PRODUCT TRACKER");

			log.info("======= finished testDashboardNavigateToProductTrackerScreen() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testDashboardNavigateToProductTrackerScreen() test========");
			e.printStackTrace();
			Assert.fail();

		}
	}
}