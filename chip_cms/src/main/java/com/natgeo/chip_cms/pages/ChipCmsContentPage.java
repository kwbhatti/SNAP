package com.natgeo.chip_cms.pages;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import com.natgeo.utilities.ScrollUtil;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/content")
public class ChipCmsContentPage extends PageObject {
	
	public ChipCmsContentPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(className="views-element-container")
	private WebElementFacade contentElementsContainer;
	
	@FindBys(value = {@FindBy(xpath="//*[@class='views-field views-field-type']/span[contains(.,'Story')]")}) 
	private List<WebElementFacade> storyContentItems;
	
	@FindBy(xpath="//*[@id='block-natgeo-admin-local-actions']/nav/li[2]/a")
	private WebElementFacade addContentButton;
	
	@FindBy(xpath="//div[@class='dropbutton-wrapper']//*[@class='edit']")
	private WebElementFacade storyItemEditButton;
	
	@FindBy(xpath="//*[@class='view-content']//*[@class='dropbutton-wrapper']")
	private WebElementFacade storyOptionsButton;
	
	@FindBy(xpath="//*[@class='view-content']//*[@class='nothing-2']/a")
	private WebElementFacade storyContentSettingsButton;
	
	@FindBy(xpath="//td[@class[contains(.,'views-field-title')]]/a")
	private WebElementFacade storyTitleAnchor;
	
	@FindBy(xpath="//a[@href='/story/add']")
	private WebElementFacade newContentButton;
	
	ChipCmsToolbar toolbar;
	
	public boolean isDisplayed() {
		return contentElementsContainer.isDisplayed();
	}

	public void isNewContentButtonDisplayed() {
		boolean isDisplayed = false;
		try {
			isDisplayed = newContentButton.isDisplayed();
		}catch (Exception e) {
			isDisplayed = false;
		}
		Assert.assertTrue("New Content button does not exist", isDisplayed);
	}

	public void clickOnNewContentButton() {
		try {
			ScrollUtil.scrollToEndOfElement(getDriver(), newContentButton);
			newContentButton.click();
		}catch (Exception e) {
			Assert.assertTrue("New Content button is not clickable", false);
		}
	}

	public void goToContentSettingsPage() {
		try {
			storyOptionsButton.click();
			storyContentSettingsButton.click();
		}catch (Exception e) {
			Assert.assertTrue("Content Settings button is not clickable", false);
		}
	}

}
