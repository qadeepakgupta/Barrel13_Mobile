package com.test.dashboardModule;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;
import com.pom.pageObjects.DashboardPage;
import com.pom.pageObjects.HomePage;
import com.pom.pageObjects.LoginPage;
import com.pom.pageObjects.SellerTrackerPage;

public class TC_021_VerifyDashboardNavigateToSellersScreen extends TestBase {

	private static final Logger log = Logger.getLogger(TC_021_VerifyDashboardNavigateToSellersScreen.class.getName());

	@Test
	public void testDashboardNavigateToSellersScreen() throws InterruptedException {
		try {

			log.info("======= starting testDashboardNavigateToSellersScreen() test========");
			HomePage hPage = new HomePage(driver);
			hPage.clickOnLoginButton();

			LoginPage lPage = new LoginPage(driver);
			lPage.loginToApp(OR.getProperty("EMAIL"), OR.getProperty("PASSWORD"));

			DashboardPage dPage = new DashboardPage(driver);
			dPage.clickOnSellerTrackerButton();

			SellerTrackerPage bPage = new SellerTrackerPage(driver);
			Assert.assertEquals(bPage.getHeaderNameText(), true);

			log.info("======= finished testDashboardNavigateToSellersScreen() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testDashboardNavigateToSellersScreen() test========");
			e.printStackTrace();
			Assert.fail();

		}
	}
}