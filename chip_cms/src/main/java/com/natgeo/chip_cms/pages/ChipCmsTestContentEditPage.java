package com.natgeo.chip_cms.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.natgeo.utilities.ScrollUtil;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ChipCmsTestContentEditPage extends PageObject {

	public ChipCmsTestContentEditPage(WebDriver driver) {
		super(driver);
		initializeElements();
	}
	
	public TaxonomyApiField subjectsLimited;
	public TaxonomyApiField locationsUnlimited;
	public TaxonomyApiField personsAllowNewTerms;
	
	@FindBy(id="edit-submit")
	private WebElementFacade saveButton;
	
	@FindBy(xpath="//*[@id='toast-container']/div[contains(.,'this field cannot hold more than 1 values')]")
	private WebElementFacade exceedingValuesErrorMessage;
	
	private void initializeElements() {
		subjectsLimited = new TaxonomyApiField(getDriver(), "edit-field-test-subjects");
		locationsUnlimited = new TaxonomyApiField(getDriver(), "edit-field-test-locations");
		personsAllowNewTerms = new TaxonomyApiField(getDriver(), "edit-field-test-persons");
	}
	public void clickSaveButton() {
		try {
			ScrollUtil.scrollToEndOfElement(getDriver(), saveButton);
			saveButton.click();
		} catch (Exception e) {
			Assert.assertTrue("Could not click on save Button", false);
		}
	}

	public void verifyExceedingLimitedValuesMessage() {
		try {
			exceedingValuesErrorMessage.isDisplayed();
		} catch (Exception e) {
			Assert.assertTrue("Exceeding values error message is not displayed", false);
		}
	}
}
