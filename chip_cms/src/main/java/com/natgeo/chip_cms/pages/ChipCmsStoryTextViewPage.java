package com.natgeo.chip_cms.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ChipCmsStoryTextViewPage extends PageObject {

	public ChipCmsStoryTextViewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="chip-node-form-textview-form")
	private WebElementFacade storyForm;
	
	@FindBy(id="edit-submit")
	private WebElementFacade saveButton;
	
	public void isDisplayed() {		
		boolean isDisplayed = false;
		try {
			isDisplayed = storyForm.isDisplayed();
		}catch (Exception e) {
			isDisplayed = false;
		}
		Assert.assertTrue("Story Text View page is not displayed", isDisplayed);
	}

	public void clickSaveButton() {
		boolean isClickable = false;
		try {
			isClickable = saveButton.isDisplayed();
			saveButton.click();
		}catch (Exception e) {
			isClickable = false;
		}
		Assert.assertTrue("Save Button is not displayed", isClickable);
		
	}
}
