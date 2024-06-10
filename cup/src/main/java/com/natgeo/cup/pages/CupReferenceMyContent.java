package com.natgeo.cup.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CupReferenceMyContent extends CupBasePage{

	public CupReferenceMyContent(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = ".ui.cards")
	private WebElementFacade ugcCards;
	
	@FindBy(css = ".cards > .landscape:nth-of-type(1)")
	private WebElementFacade ugcCard;

	@FindBy(css = ".cards > .landscape:nth-of-type(1) i")
	private WebElementFacade readUgc;
	
	public void clickOnReadDetails() {
		try {
			waitForVisibleAndClick(readUgc);
		} catch (Exception e) {
			Assert.assertTrue("Unable to click on READ: ", false);
		}
	}
}
