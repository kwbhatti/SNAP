package com.natgeo.chip_cms.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.natgeo.utilities.ScrollUtil;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class TestContentItemOperations extends PageObject {

	public TestContentItemOperations(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//td/span[contains(text(), 'TestContent')]/../..//a[@href='#']")
	private WebElementFacade operationsButton;
	
	@FindBy(xpath="//td/span[contains(text(), 'TestContent')]/../..//a[@href[contains(.,'edit')]]")
	private WebElementFacade editButton;
	
	public void edit() {
		try {
			operationsButton.click();
			editButton.click();
		}
		catch (Exception e) {
			Assert.assertTrue("Could not navigate to Edit page", false);
		}
	}

	public boolean isCreated() {
		try {
			ScrollUtil.scrollToEndOfElement(getDriver(), operationsButton);
			return true;
		} catch (Exception e) {
			Assert.assertTrue("TestContent item is not created", false);
			return false;
		}
	}

}
