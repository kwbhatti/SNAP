package com.natgeo.chip_cms.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ChipCmsContentTechnicalSettingsPage extends PageObject {

	public ChipCmsContentTechnicalSettingsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="edit-submit")
	private WebElementFacade saveButton;
	
	public void isDisplayed() {		
		boolean isDisplayed = false;
		try {
			isDisplayed = saveButton.isDisplayed();
		}catch (Exception e) {
			isDisplayed = false;
		}
		Assert.assertTrue("Content Technical Settings page is not displayed", isDisplayed);
	}
}
