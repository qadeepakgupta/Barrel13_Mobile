package com.test.dashboardModule;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;
import com.pom.pageObjects.DashboardPage;
import com.pom.pageObjects.HomePage;
import com.pom.pageObjects.LoginPage;

public class TC_007_VerifyDashboardFluctuationInRankLinkDisplayed extends TestBase {

	private static final Logger log = Logger.getLogger(TC_007_VerifyDashboardFluctuationInRankLinkDisplayed.class.getName());

	@Test
	public void testDashboardFluctuationInRankLinkDisplayed() throws InterruptedException {
		try {

			log.info("======= starting testDashboardFluctuationInRankLinkDisplayed() test========");
			HomePage hPage = new HomePage(driver);
			hPage.clickOnLoginButton();

			LoginPage lPage = new LoginPage(driver);
			lPage.loginToApp(OR.getProperty("EMAIL"), OR.getProperty("PASSWORD"));

			DashboardPage dPage = new DashboardPage(driver);
			dPage.clickOnFlcutuateIcon();

			Assert.assertEquals(dPage.checkFlcutuateInRankLinkDisplayed(), true);

			log.info("======= finished testDashboardFluctuationInRankLinkDisplayed() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testDashboardFluctuationInRankLinkDisplayed() test========");
			e.printStackTrace();
			Assert.fail();

		}
	}
}