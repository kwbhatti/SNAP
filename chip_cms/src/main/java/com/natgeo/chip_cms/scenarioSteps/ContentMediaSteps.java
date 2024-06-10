package com.natgeo.chip_cms.scenarioSteps;

import org.openqa.selenium.WebDriver;
import com.natgeo.chip_cms.pages.ChipCmsAdminContentTreePage;
import net.thucydides.core.annotations.Step;

public class ContentMediaSteps {

	private WebDriver currentDriver;
	private ChipCmsAdminContentTreePage adminContentTreePage;
	
	public void setDriver(WebDriver driver) {
		currentDriver = driver;  
	}

	@Step("User clicks on expand button")
	public void clickExpandButtonAdminContentTree() {
		adminContentTreePage = new ChipCmsAdminContentTreePage(currentDriver);
		adminContentTreePage.clickExpandButton();
	}

	@Step("Verify tree displays children elements of a category")
	public void treeDisplaysChildrenElementsOfACategory() {
		adminContentTreePage = new ChipCmsAdminContentTreePage(currentDriver);
		adminContentTreePage.verifyCollapseButtonIsDisplayed();
	}

	public void clickCollapseButtonAdminContentTree() {
		adminContentTreePage = new ChipCmsAdminContentTreePage(currentDriver);
		adminContentTreePage.clickCollapseButton();
	}

	public void treeHidesChildrenElementsOfACategory() {
		adminContentTreePage = new ChipCmsAdminContentTreePage(currentDriver);
		adminContentTreePage.verifyCollapseButtonIsHidden();
	}

	public void contentTreePageDisplaysAccessDeniedMessage() {
		adminContentTreePage = new ChipCmsAdminContentTreePage(currentDriver);
		adminContentTreePage.verifyAccessDeniedMessageIsDisplayedAtContentTreePage();
	}
	
}
