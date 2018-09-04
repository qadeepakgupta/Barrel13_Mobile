package com.test.dashboardModule;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;
import com.pom.pageObjects.DashboardPage;
import com.pom.pageObjects.HomePage;
import com.pom.pageObjects.LoginPage;

public class TC_002_VerifyDashboardShortlistButtonDisplayed extends TestBase {

	private static final Logger log = Logger.getLogger(TC_002_VerifyDashboardShortlistButtonDisplayed.class.getName());

	@Test
	public void testDashboardShortlistButtonDisplayed() throws InterruptedException {
		try {

			log.info("======= starting testDashboardShortlistButtonDisplayed() test========");
			HomePage hPage = new HomePage(driver);
			hPage.clickOnLoginButton();

			LoginPage lPage = new LoginPage(driver);
			lPage.loginToApp(OR.getProperty("EMAIL"), OR.getProperty("PASSWORD"));

			DashboardPage dPage = new DashboardPage(driver);
			Assert.assertEquals(dPage.checkShortlistButtonDisplayed(), true);
			
			log.info("======= finished testDashboardShortlistButtonDisplayed() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testDashboardShortlistButtonDisplayed() test========");
			e.printStackTrace();
			Assert.fail();

		}
	}
}