package com.natgeo.chip_cms.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.natgeo.chip_cms.common.ContentFieldType;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ChipCmsAddFieldPage extends PageObject {

	public ChipCmsAddFieldPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[@href[contains(., '/add-field')]]")
	private WebElementFacade selectFieldTypeContent;
	
	@FindBy(id="edit-label")
	private WebElementFacade nameField;
	
	@FindBy(id="edit-submit")
	private WebElementFacade saveAndContinueButton;
	
	@FindBy(xpath="//*[@id='edit-add']//input")
	private WebElementFacade selectFieldTypeDropdown;

	public void createField(ContentFieldType contentFieldType, String fieldName) {
		try {
			selectFieldTypeByIndex(contentFieldType.getIndex());
			typeName(fieldName);
			clickSaveAndContinueButton();
		}
		catch (Exception e) { 
			Assert.assertTrue("Could not create field", false);
		}
	}
	
	public void selectFieldTypeByIndex (Integer index) {
		try {
			selectFieldTypeDropdown.click();
			selectFieldTypeContent.selectByIndex(6);
		}
		catch (Exception e) { 
			Assert.assertTrue("Could not select field type", false);
		}
	}
	
	public void typeName (String text) {
		try {
			nameField.type(text);
		}
		catch (Exception e) { 
			Assert.assertTrue("Could not type on Label Field", false);
		}
	}
	
	public void clickSaveAndContinueButton () {
		try {
			saveAndContinueButton.click();
		}
		catch (Exception e) { 
			Assert.assertTrue("Could not click Save And Continue button", false);
		}
	}
	
}
