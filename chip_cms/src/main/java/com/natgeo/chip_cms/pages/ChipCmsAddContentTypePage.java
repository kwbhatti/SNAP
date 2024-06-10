package com.natgeo.chip_cms.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.natgeo.utilities.ScrollUtil;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ChipCmsAddContentTypePage extends PageObject {

	public ChipCmsAddContentTypePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="edit-name")
	private WebElementFacade nameField;
	
	@FindBy(id="edit-save-continue")
	private WebElementFacade saveContentTypeButton;
	
	@FindBy(className="machine-name-label")
	private WebElementFacade machineNameLabel;

	public void typeName(String text) {
		try{
			nameField.click();
			nameField.sendKeys(text);
			machineNameLabel.waitUntilVisible();
		}
		catch (Exception e){
			Assert.assertTrue("Could not enter text into Name field", false);
		}
	}

	public void clickSaveContentTypeButton() {
		try{
			ScrollUtil.scrollToEndOfElement(getDriver(), saveContentTypeButton);
			saveContentTypeButton.click();
		}
		catch (Exception e){
			Assert.assertTrue("Could not click Save Content Type Button", false);
		}
	}

	public void createContentType(String contentTypeName) {
		typeName(contentTypeName);
		clickSaveContentTypeButton();
	}

	
}
