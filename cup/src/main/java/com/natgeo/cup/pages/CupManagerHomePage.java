package com.natgeo.cup.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CupManagerHomePage extends CupBasePage {

	public CupManagerHomePage(WebDriver driver) {
		super(driver);
	}
	
	public String communityXpath1 = "//div[@class='ui header'][contains(text(),'";
	public String communityXpath2 = "')]";

	WebElementFacade community_name;

	@FindBy(css = "div.ui.fluid.vertical.tabular.menu > a + a")
	public WebElementFacade communitiesButton;

	@FindBy(css=".main-container .button:nth-child(1)")
	public WebElementFacade createCommunityButton;
	
	@FindBy(css="h1.header")
	private WebElementFacade communityTitle;
	
	public void clickOnCreateCommunity() {
		try {
			waitForVisibleAndClick(createCommunityButton);
			communityTitle.waitUntilVisible();
		} catch (Exception e) {
			Assert.assertTrue("Unable to click on Create Community: ========== " + e.getMessage() + " ==========", false);
		}
	}
	
	public void navigateToHomePage() {
		try {
			openUrl("https://community-manager-dev.nationalgeographic.com/");
		} catch (Exception e) {
			Assert.assertTrue("Unable to open the Manager Site: ", false);
		}
	}
	
	public boolean clickOnCommunitiesButton() {
		try {
			waitForVisibleAndClick(communitiesButton);
			return true;
		} catch (Exception e) {
			Assert.assertTrue("Unable to click on Communities Button: ", false);
			return false;
		}
	}

	public boolean validateCommunityDisplayed(String communityName) {
		try {
			community_name = $(communityXpath1 + communityName + communityXpath2);
			return community_name.isDisplayed();
		} catch (Exception e) {
			Assert.assertTrue("Unable to find " + communityName + ": ", false);
			return community_name.isDisplayed();
		}
	}
	
	public void waitForCreateCommunityToBeVisible() {
		try {
			createCommunityButton.waitUntilVisible();
		} catch (Exception e) {
			Assert.assertTrue("Unable to see the Create Community Button: ", false);
		}
	}
}