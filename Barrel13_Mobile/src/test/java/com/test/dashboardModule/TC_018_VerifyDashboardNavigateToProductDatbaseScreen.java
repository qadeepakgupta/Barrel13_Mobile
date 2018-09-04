package com.test.dashboardModule;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.comUtil.TestBase;
import com.pom.pageObjects.DashboardPage;
import com.pom.pageObjects.HomePage;
import com.pom.pageObjects.LoginPage;
import com.pom.pageObjects.ProductDatabasePage;

public class TC_018_VerifyDashboardNavigateToProductDatbaseScreen extends TestBase {

	private static final Logger log = Logger.getLogger(TC_018_VerifyDashboardNavigateToProductDatbaseScreen.class.getName());

	@Test
	public void testDashboardNavigateToProductDatbaseScreen() throws InterruptedException {
		try {

			log.info("======= starting testDashboardNavigateToProductDatbaseScreen() test========");
			HomePage hPage = new HomePage(driver);
			hPage.clickOnLoginButton();

			LoginPage lPage = new LoginPage(driver);
			lPage.loginToApp(OR.getProperty("EMAIL"), OR.getProperty("PASSWORD"));

			DashboardPage dPage = new DashboardPage(driver);
			dPage.clickOnProductDatabaseButton();

			ProductDatabasePage pPage = new ProductDatabasePage(driver);
			Assert.assertEquals(pPage.getHeaderNameText(), "PRODUCT DATABASE");

			log.info("======= finished testDashboardNavigateToProductDatbaseScreen() test========");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			log.error(e.getCause());
			log.error("======= finished testDashboardNavigateToProductDatbaseScreen() test========");
			e.printStackTrace();
			Assert.fail();

		}
	}
}