package com.natgeo.chip_cms.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ChipCmsContentSettingsPage extends PageObject {
	
	public ChipCmsContentSettingsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//article")
	private WebElementFacade articleMainContentBlock;
	
	@FindBy(xpath="//a[@href[contains(.,'/settings/primary')]]")
	private WebElementFacade primarySettingsTab;
	
	@FindBy(css = "a[href*='primary'")
	private WebElementFacade primarySettingsTab2;
	
	@FindBy(xpath="//a[@href[contains(.,'/settings/secondary')]]")
	private WebElementFacade secondarySettingsTab;
	
	@FindBy(xpath="//a[@href[contains(.,'/settings/advertising')]]")
	private WebElementFacade advertisingSettingsTab;
	
	@FindBy(xpath="//a[@href[contains(.,'/settings/technical')]]")
	private WebElementFacade technicalSettingsTab;
	
	public void isDisplayed() {		
		boolean isDisplayed = false;
		try {
			isDisplayed = articleMainContentBlock.isDisplayed();
		}catch (Exception e) {
			isDisplayed = false;
		}
		Assert.assertTrue("Content Settings page is not displayed", isDisplayed);
	}

	public void clicksOnPrimaryTab() {
		primarySettingsTab.click();
	}

	public void clicksOnSecondaryTab() {
		secondarySettingsTab.click();
	}

	public void clicksOnAdvertisingTab() {
		advertisingSettingsTab.click();
	}

	public void clicksOnTechnicalTab() {
		technicalSettingsTab.click();
	}
}


