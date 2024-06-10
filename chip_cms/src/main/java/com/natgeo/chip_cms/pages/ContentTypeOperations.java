package com.natgeo.chip_cms.pages;

import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.By;;

public class ContentTypeOperations extends PageObject {

	public ContentTypeOperations(WebDriver driver) {
		super(driver);
	}
	
	private WebElementFacade operationsButton;
	private WebElementFacade manageFieldsButton;

	public void selectContentType(String testContentName) {
		try {			
			operationsButton = find(By.xpath("//td[contains(text(), '" + testContentName + "')]/..//a[@href='#']"));
			manageFieldsButton = find(By.xpath("//td[contains(., '" + testContentName + "')]/..//a[@href[contains(., '/fields')]]"));
		}
		catch (Exception e) {
			Assert.assertTrue("Content Type not found: " + testContentName, false);
		}
	}
	
	public void goToManageFields() {
		operationsButton.click();
		manageFieldsButton.click();
	}

}
