package com.pom.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.pom.comUtil.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DashboardPage {

	private static final Logger log = Logger.getLogger(DashboardPage.class.getName());
	public AppiumDriver<MobileElement> driver;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'txt_title')]")
	private MobileElement txt_DashboardHeaderName;

	// Shortlist Section
	@CacheLookup
	@AndroidFindBy(id = "ll_shortlist")
	private MobileElement btn_Shortlist;

	@CacheLookup
	@AndroidFindBy(id = "txt_shortlist_count")
	private MobileElement txt_NoOfShortlistedProduct;

	// Product Database Section
	@CacheLookup
	@AndroidFindBy(id = "ll_database")
	private MobileElement btn_ProductDatabase;

	// Category Section
	@CacheLookup
	@AndroidFindBy(id = "txt_tracker_option")
	private MobileElement txt_CategoryChart;

	@CacheLookup
	@AndroidFindBy(id = "img_tracker_option")
	private MobileElement txt_CategoryChartOptions;

	@CacheLookup
	@AndroidFindBy(id = "rv_tracker")
	private MobileElement txt_categoryChartNoOfCategoryTrackered;

	@CacheLookup
	@AndroidFindBy(id = "chart1")
	private MobileElement categoryChartElement;

	// Product Tracker Section
	@CacheLookup
	@AndroidFindBy(id = "ll_tracked_products")
	private MobileElement btn_LeftToAddTracker;

	@CacheLookup
	@AndroidFindBy(id = "txt_tracked_count")
	private MobileElement txt_LeftToTrackeredCount;

	// Brands Section
	@CacheLookup
	@AndroidFindBy(id = "ll_recent_tracked_brands")
	private MobileElement txt_RecentTrackedBrands;

	// Sellers Section
	@CacheLookup
	@AndroidFindBy(id = "txt_recent_tracked_sellers_count")
	private MobileElement txt_RecentTrackedSellers;

	// Flcutuation Section
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'txt_flcutuate_option') and @text='FLUCTUATION IN PRICE']")
	private MobileElement txt_Flcutuation;

	@CacheLookup
	@AndroidFindBy(id = "img_fluctuate")
	private MobileElement link_FlcutuateOptionIcon;

	@CacheLookup
	@AndroidFindBy(id = "rv_flcutuate")
	private MobileElement flcutuateElement;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Fluctuation in Price']")
	private MobileElement link_FlcutuateInPrice;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Fluctuation in Rank']")
	private MobileElement link_FlcutuateInRank;

	// Active Plan Section
	@CacheLookup
	@AndroidFindBy(id = "ll_active_plans")
	private MobileElement btn_ActivePlan;

	// Menu Section
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@index='0']")
	private MobileElement link_Menu;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
	private MobileElement link_SubMenuSetting;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Logout']")
	private MobileElement link_SubMenuLogout;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.Button[@text='CONFIRM']")
	private MobileElement btn_Confirm;

	public DashboardPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}

	/**
	 * All the action methods of dashboard screen.
	 * 
	 * @return
	 */
	public boolean checkShortlistButtonDisplayed() {
		log("shortlist button current display status is : " + btn_Shortlist.isDisplayed());
		return btn_Shortlist.isDisplayed();
	}

	public void clickOnShortlistButton() {
		btn_Shortlist.click();
		log("clicked on shortlist button.");
	}

	public void clickOnProductDatabaseButton() {
		btn_ProductDatabase.click();
		log("clicked on product database button.");
	}

	public void clickOnProductTrackerButton() {
		btn_LeftToAddTracker.click();
		log("clicked on product tracker button.");
	}

	public void clickOnBrandsTrackerButton() {
		TestBase.scrollToMobileElement("Recently Tracked Brands");
		txt_RecentTrackedBrands.click();
		log("clicked on brands tracker button.");
	}

	public void clickOnSellerTrackerButton() {
		TestBase.scrollToMobileElement("Recently Tracked Sellers");
		txt_RecentTrackedSellers.click();
		log("clicked on sellers tracker button.");
	}

	public String getNoOfShortlistedProductText() {
		log("No Of Shortlisted Product is : " + txt_NoOfShortlistedProduct.getText());
		return txt_NoOfShortlistedProduct.getText();
	}

	public boolean checkProductDatabaseButtonDisplayed() {
		log("Product Database button display current status is : " + btn_ProductDatabase.isDisplayed());
		return btn_ProductDatabase.isDisplayed();
	}

	public boolean checkCategoryTextDisplayed() {
		log("Category current display status is : " + txt_CategoryChart.isDisplayed());
		return txt_CategoryChart.isDisplayed();
	}

	public boolean checkCategoryChartNoOfCategoryTrackeredDisplayed() {
		log("category chart no of category trackered current display status is : "
				+ txt_categoryChartNoOfCategoryTrackered.isDisplayed());
		return txt_categoryChartNoOfCategoryTrackered.isDisplayed();
	}

	public boolean checkLeftToAddTrackerDisplayed() {
		TestBase.scrollToMobileElement("FLUCTUATION IN PRICE");
		log("left to add tracker current display status is : " + btn_LeftToAddTracker.isDisplayed());
		return btn_LeftToAddTracker.isDisplayed();
	}

	public boolean checkLeftToTrackedCountDisplayed() {
		TestBase.scrollToMobileElement("FLUCTUATION IN PRICE");
		log("left to tracked count current display status is : " + txt_LeftToTrackeredCount.isDisplayed());
		return txt_LeftToTrackeredCount.isDisplayed();
	}

	public boolean checkRecentTrackedBrandsDisplayed() {
		TestBase.scrollToMobileElement("FOLLOWING");
		log("recent tracked brands current display status is : " + txt_RecentTrackedBrands.isDisplayed());
		return txt_RecentTrackedBrands.isDisplayed();
	}

	public boolean checkRecentTrackedSellersDisplayed() {
		TestBase.scrollToMobileElement("FOLLOWING");
		log("recent tracked sellers current display status is : " + txt_RecentTrackedSellers.isDisplayed());
		return txt_RecentTrackedSellers.isDisplayed();
	}

	public boolean checkActivePlanDisplayed() {
		TestBase.scrollToMobileElement("ACTIVE PLANS");
		log("active plan current display status is : " + btn_ActivePlan.isDisplayed());
		return btn_ActivePlan.isDisplayed();
	}

	public void clickOnFlcutuateInPriceLink() {
		link_FlcutuateInPrice.click();
		log("clicked on flcutuate in price Option.");
	}

	public boolean checkFlcutuateInPriceLinkDisplayed() {
		TestBase.scrollToMobileElement("FLUCTUATION IN PRICE");
		log("Flcutuate In Price current display status is : " + link_FlcutuateInPrice.isDisplayed());
		return link_FlcutuateInPrice.isDisplayed();
	}

	public boolean checkFlcutuateInRankLinkDisplayed() {
		TestBase.scrollToMobileElement("FLUCTUATION IN PRICE");
		log("Flcutuate In Rank current display status is : " + link_FlcutuateInRank.isDisplayed());
		return link_FlcutuateInRank.isDisplayed();
	}

	public void clickOnFlcutuateInRankLink() {
		link_FlcutuateInRank.click();
		log("clicked on flcutuate in rank Option.");
	}

	public boolean checkFlcutuateInPriceNoOfCountDisplayed() {
		TestBase.scrollToMobileElement("FLUCTUATION IN PRICE");
		log("Flcutuate in price no of count current display status is : " + flcutuateElement.isDisplayed());
		return flcutuateElement.isDisplayed();
	}

	public boolean checkFlcutuateInRankNoOfCountDisplayed() {
		TestBase.scrollToMobileElement("FLUCTUATION IN PRICE");
		log("Flcutuate in rank no of count current display status is : " + flcutuateElement.isDisplayed());
		return flcutuateElement.isDisplayed();
	}

	public String getHeaderNameText() {
		log("Header Name is : " + txt_DashboardHeaderName.getText());
		return txt_DashboardHeaderName.getText();
	}

	public void clickOnFlcutuateIcon() {
		TestBase.scrollToMobileElement("FLUCTUATION IN PRICE");
		link_FlcutuateOptionIcon.click();
		log("clicked on flcutuate option icon.");
	}

	public void selectFluctuationInPrice() {
		clickOnFlcutuateIcon();
		clickOnFlcutuateInPriceLink();
	}

	public void selectFluctuationInRank() {
		clickOnFlcutuateIcon();
		clickOnFlcutuateInRankLink();
	}

	public void clickOnSubMenuSettingsLink() {
		link_SubMenuSetting.click();
		log("clicked on sub menu Settings from Menu Option.");
	}

	public void clickOnMenuLink() {
		link_Menu.click();
		log("clicked on Menu Option.");
	}

	public void clickOnLogoutLink() {
		link_SubMenuLogout.click();
		log("clicked on Logout.");
	}

	public void clickOnConfirmButton() {
		btn_Confirm.click();
		log("clicked on Confirm button.");
	}

	public void logoutApp() throws InterruptedException {
		clickOnMenuLink();
		TestBase.scrollToMobileElement("Settings");
		clickOnSubMenuSettingsLink();
		TestBase.scrollToMobileElement("Logout");
		clickOnLogoutLink();
		clickOnConfirmButton();
	}

}
