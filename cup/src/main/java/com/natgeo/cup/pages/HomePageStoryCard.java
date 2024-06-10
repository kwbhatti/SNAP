package com.natgeo.cup.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;

public class HomePageStoryCard extends CupBasePage {

	public HomePageStoryCard(WebDriver driver, int id) {
		super(driver);
		initializeElements(id);
	}
	
	private WebElementFacade card;	
	private WebElementFacade readButton;
	
	private void initializeElements(int id) {
		card = find(By.cssSelector(".story-card:nth-of-type("+ id +")")); 
		readButton = find(By.cssSelector(".story-card:nth-of-type("+ id +") .read-more > i")); 	
	}
	
	public void waitUntilEnabled() {
		try {
			card.waitUntilEnabled();
		} catch (Exception e) {
			Assert.assertTrue("Card did not load", false);
		}
	}
	
	public void clickReadButton() {
		try {
			waitForVisibleAndClick(readButton);
		}
		catch (Exception e) {
			Assert.assertTrue("Could not click on Read Button", false);
		}
	}
}
