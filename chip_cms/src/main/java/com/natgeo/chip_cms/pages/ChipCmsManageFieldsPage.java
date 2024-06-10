package com.natgeo.chip_cms.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.natgeo.chip_cms.common.ContentFieldType;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ChipCmsManageFieldsPage extends PageObject {

	public ChipCmsManageFieldsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//a[@href[contains(., '/fields')]]")
	WebElementFacade manageFieldsTab;
	
	@FindBy(xpath="//a[@href[contains(., '/add-field')]]")
	private WebElementFacade addFieldButton;
	
	public void createField(ContentFieldType contentFieldType, String fieldName) {
		clickAddFieldButton();
		ChipCmsAddFieldPage addFieldPage = new ChipCmsAddFieldPage(getDriver());
		addFieldPage.createField(contentFieldType, fieldName);
	}

	private void clickAddFieldButton() {
		try {
			addFieldButton.click();
		}
		catch (Exception e) {
			Assert.assertTrue("Could not click on Add Field Button", false);
		}	
	}

}
