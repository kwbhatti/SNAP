package com.natgeo.chip_cms.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ChipCmsContentPrimarySettingsPage extends PageObject {

	public ChipCmsContentPrimarySettingsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="chip-node-form-primary-form")
	private WebElementFacade settingsPrimaryForm;
	
	@FindBy(id="edit-submit")
	private WebElementFacade saveButton;
	
	public void isDisplayed() {		
		try {
			settingsPrimaryForm.isDisplayed();
		}catch (Exception e) {
			Assert.assertTrue("Content Primary Settings page is not displayed", false);
		}
	}

	public void isSaveButtonDisplayed() {
		boolean isDisplayed = false;
		try {
			isDisplayed = saveButton.isDisplayed();
		}catch (Exception e) {
			isDisplayed = false;
		}
		Assert.assertTrue("Save button is not displayed at Primary Settings Page", isDisplayed);
	}

	public void clickSaveButton() {
		boolean isClickable = false;
		try {
			isClickable = saveButton.isDisplayed();
			saveButton.click();
		}catch (Exception e) {
			isClickable = false;
		}
		Assert.assertTrue("Save button is not clickable", isClickable);
	}
}
