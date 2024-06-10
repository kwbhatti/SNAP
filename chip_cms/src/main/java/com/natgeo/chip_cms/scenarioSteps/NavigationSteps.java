package com.natgeo.chip_cms.scenarioSteps;

import org.openqa.selenium.WebDriver;
import com.natgeo.chip_cms.pages.ChipCmsAdminContentPage;
import com.natgeo.chip_cms.pages.ChipCmsAdminContentTreePage;
import com.natgeo.chip_cms.pages.ChipCmsContentAdvertisingSettingsPage;
import com.natgeo.chip_cms.pages.ChipCmsContentPage;
import com.natgeo.chip_cms.pages.ChipCmsContentPrimarySettingsPage;
import com.natgeo.chip_cms.pages.ChipCmsContentSecondarySettingsPage;
import com.natgeo.chip_cms.pages.ChipCmsContentSettingsPage;
import com.natgeo.chip_cms.pages.ChipCmsContentTechnicalSettingsPage;
import com.natgeo.chip_cms.pages.ChipCmsCreateStoryPage;
import com.natgeo.chip_cms.pages.ChipCmsLayoutManagerPage;
import com.natgeo.chip_cms.pages.ChipCmsStoryTextViewPage;
import net.thucydides.core.annotations.Step;

public class NavigationSteps {

	private ChipCmsContentPage contentPage;
	private ChipCmsAdminContentPage adminContentPage;
	private ChipCmsCreateStoryPage createStoryPage;
	private ChipCmsContentSettingsPage contentSettingsPage;
	private ChipCmsContentPrimarySettingsPage contentPrimarySettingsPage;
	private ChipCmsContentSecondarySettingsPage contentSecondarySettingsPage;
	private ChipCmsContentAdvertisingSettingsPage contentAdvertisingSettingsPage;
	private ChipCmsContentTechnicalSettingsPage contentTechnicalSettingsPage;
	private ChipCmsStoryTextViewPage storyTextViewPage;
	private ChipCmsLayoutManagerPage layoutManagerPage;
	private ChipCmsAdminContentTreePage	adminContentTreePage;
	private WebDriver currentDriver;
	
	@Step("Displays Content page")
	public WebDriver goToContentPage() {
		contentPage = new ChipCmsContentPage(currentDriver);
		contentPage.open();
		return currentDriver;
	}
	
	public WebDriver goToEditItemPage() {
		adminContentPage.open();
		adminContentPage.goToEditStoryPage();
		return adminContentPage.getDriver();
	}

	public void isContentPageDisplayed() {
		contentPage.isDisplayed();
	}
	
	public void setDriver(WebDriver driver) {
		currentDriver = driver;  
	}
	
	public void initializePages() {
		contentPage = new ChipCmsContentPage(currentDriver);
		adminContentPage = new ChipCmsAdminContentPage(currentDriver);
	}

	@Step("Displays Create Story Page")
	public void isAtCreateStoryPage() {
		createStoryPage.isDisplayed();
	}

	@Step("Displays Content Settings page")
	public WebDriver goToContentSettingsPageOfCreatedStory() {
		goToContentPage();
		contentPage.goToContentSettingsPage();
		contentSettingsPage = new ChipCmsContentSettingsPage(contentPage.getDriver());
		contentSettingsPage.isDisplayed();
		return contentSettingsPage.getDriver();
	}

	public void isAtContentPrimarySettingsPage() {
		contentPrimarySettingsPage.isDisplayed();
	}

	public void isAtContentSecondarySettingsPage() {
		contentSecondarySettingsPage.isDisplayed();
	}

	public void isAtContentAdvertisingSettingsPage() {
		contentAdvertisingSettingsPage.isDisplayed();
	}

	public void isAtContentTechnicalSettingsPage() {
		contentTechnicalSettingsPage.isDisplayed();
	}

	public WebDriver goToCreateNewStoryPage() {
		goToContentPage();
		contentPage.clickOnNewContentButton();
		return contentPage.getDriver();
	}

	public void isAtStoryTextViewPage() {
		storyTextViewPage.isDisplayed();
	}

	@Step("Displays Content Primary Settings page")
	public WebDriver goToContentPrimarySettingsPage() {
		contentSettingsPage = new ChipCmsContentSettingsPage(goToContentSettingsPageOfCreatedStory());
		contentSettingsPage.clicksOnPrimaryTab();
		return contentSettingsPage.getDriver();
	}

	public void goToTextViewPage() {
		goToContentPage();
		contentPage.clickOnNewContentButton();
	}

	public void isAtLayoutManagerPage() {
		layoutManagerPage.isDisplayed();
	}

	@Step("Navigate to TestContent item edit page")
	public WebDriver goToEditTestContentItemPage() {
		adminContentPage.open();
		adminContentPage.goToEditTestContentItemPage();
		WebDriver driver = adminContentPage.getDriver();
		return driver;
	}

	@Step("User navigates to Admin Content Tree Page")
	public void goToAdminContentTreePage() {
		adminContentTreePage = new ChipCmsAdminContentTreePage(currentDriver);
		adminContentTreePage.open();
	}

	@Step("Verify Admin Content Tree Page is displayed")
	public void adminContentTreeIsDisplayed() {
		adminContentTreePage = new ChipCmsAdminContentTreePage(currentDriver);
		adminContentTreePage.verifyIsDisplayed();
	}

}
