package com.natgeo.cup.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CupBasePage extends PageObject {
	 
	private Actions builder = new Actions(getDriver());
	
	public CupBasePage(WebDriver driver) {
		super(driver);
	}
	
	protected void waitForVisibleAndClick(WebElementFacade element) {
		element.waitUntilVisible().click();
	}
	
	protected void typeInElement(WebElementFacade element, String text) {		
		element.waitUntilVisible();	
				builder.moveToElement(element).
				click().
				sendKeys(Keys.chord(Keys.CONTROL, "a"), text).
				build().perform();	
	}
	
	protected String getElementText(WebElementFacade element) {
		return element.waitUntilPresent().getText();
	}
	
	protected void selectAndDeleteTextViaKeyboard(WebElementFacade element) {
	    selectTextViaKeyboard(element);
	    deleteViaKeyboard(element);
	}

	protected void deleteViaKeyboard(WebElementFacade element) {
	    
	    builder.moveToElement(element).
	    	sendKeys(Keys.DELETE).
	    	release().perform();
	}

	protected void selectTextViaKeyboard(WebElementFacade element) {
		builder.moveToElement(element).
			keyDown(Keys.CONTROL)
	        .sendKeys("a")
	        .keyUp(Keys.CONTROL)
	        .build().perform();
	}
	
}
