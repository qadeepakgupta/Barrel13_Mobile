package com.test.dashboardModule;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;
import com.pom.pageObjects.BrandTrackerPage;
import com.pom.pageObjects.DashboardPage;
import com.pom.pageObjects.HomePage;
import com.pom.pageObjects.LoginPage;

public class TC_020_VerifyDashboardNavigateToBrandsScreen extends TestBase {

	private static final Logger log = Logger.getLogger(TC_020_VerifyDashboardNavigateToBrandsScreen.class.getName());

	@Test
	public void testDashboardNavigateToBrandsScreen() throws InterruptedException {
		try {

			log.info("======= starting testDashboardNavigateToBrandsScreen() test========");
			HomePage hPage = new HomePage(driver);
			hPage.clickOnLoginButton();

			LoginPage lPage = new LoginPage(driver);
			lPage.loginToApp(OR.getProperty("EMAIL"), OR.getProperty("PASSWORD"));

			DashboardPage dPage = new DashboardPage(driver);
			dPage.clickOnBrandsTrackerButton();

			BrandTrackerPage bPage = new BrandTrackerPage(driver);
			Assert.assertEquals(bPage.getHeaderNameText(), true);

			log.info("======= finished testDashboardNavigateToBrandsScreen() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testDashboardNavigateToBrandsScreen() test========");
			e.printStackTrace();
			Assert.fail();

		}
	}
}