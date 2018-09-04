package com.test.dashboardModule;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;
import com.pom.pageObjects.DashboardPage;
import com.pom.pageObjects.HomePage;
import com.pom.pageObjects.LoginPage;
import com.pom.pageObjects.ShortlistPage;

public class TC_017_VerifyDashboardNavigateToShortlistScreen extends TestBase {

	private static final Logger log = Logger.getLogger(TC_017_VerifyDashboardNavigateToShortlistScreen.class.getName());

	@Test
	public void testDashboardNavigateToShortlistScreen() throws InterruptedException {
		try {

			log.info("======= starting testDashboardNavigateToShortlistScreen() test========");
			HomePage hPage = new HomePage(driver);
			hPage.clickOnLoginButton();

			LoginPage lPage = new LoginPage(driver);
			lPage.loginToApp(OR.getProperty("EMAIL"), OR.getProperty("PASSWORD"));

			DashboardPage dPage = new DashboardPage(driver);
			dPage.clickOnShortlistButton();

			ShortlistPage sPage = new ShortlistPage(driver);
		
			if (sPage.getHeaderNameText().contains("SHORTLISTED")) {
				Assert.assertTrue(true);
			} else {
				Assert.fail();
			}

			log.info("======= finished testDashboardNavigateToShortlistScreen() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testDashboardNavigateToShortlistScreen() test========");
			e.printStackTrace();
			Assert.fail();

		}
	}
}