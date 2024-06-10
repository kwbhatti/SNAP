package com.natgeo.cup.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CupManagerCommunityDetailsPage extends CupBasePage {

	public CupManagerCommunityDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="div.ui.segment")
	public WebElementFacade uiSegment;
	
	public boolean waitForUIToBeVisible() {
		try {
			uiSegment.waitUntilVisible();
			return true;
		} catch (Exception e) {
			Assert.assertTrue("Unable to see the content: ", false);
			return false;
		}
	}
}
