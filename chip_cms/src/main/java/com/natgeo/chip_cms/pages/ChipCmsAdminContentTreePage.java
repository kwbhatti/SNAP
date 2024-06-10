package com.natgeo.chip_cms.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/admin/content/tree")
public class ChipCmsAdminContentTreePage extends PageObject {

	public ChipCmsAdminContentTreePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(className="natgeo-content-tree")
	private WebElementFacade adminContentTree;
	
	@FindBy(className="expand")
	private WebElementFacade expandButton;
	
	@FindBy(className="collapse")
	private WebElementFacade collapseButton;
	
	@FindBy(id="block-natgeo-admin-content")
	private WebElementFacade errorMessageContainer;
	
	private String accessDeniedMessage = "You are not authorized to access this page.";
	
	public void verifyIsDisplayed() {
		Assert.assertTrue("Admin Content Tree is not displayed", adminContentTree.isDisplayed());
	}

	public void clickExpandButton() {
		try {
			expandButton.click();
		} catch (Exception e) {
			Assert.assertTrue("Expand button could not be clicked at Admin Content Tree page", false);
		}
	}

	public void verifyCollapseButtonIsDisplayed() {
		try { 
			collapseButton.isDisplayed();
			Assert.assertTrue("Collapse button is not hidden at Admin Content Tree page", false);
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}

	public void clickCollapseButton() {
		try {
			Actions actions = new Actions(getDriver());
			actions.moveToElement(collapseButton, 10,10).click().perform();
		} catch (Exception e) {
			Assert.assertTrue("Collapse button could not be clicked at Admin Content Tree page", false);
		}
	}

	public void verifyCollapseButtonIsHidden() {
		try { 
			collapseButton.isDisplayed();
			Assert.assertTrue("Children categories still visible", false);
		} catch (Exception e) {}
	}

	public void verifyAccessDeniedMessageIsDisplayedAtContentTreePage() {
		try { 
			if(!errorMessageContainer.getText().contains(accessDeniedMessage)) {
				Assert.assertTrue("Access denied message is not displayed", false);
			} 
		} catch (Exception e) {
			Assert.assertTrue("Block container could not be found", false);
		}
	}
}
