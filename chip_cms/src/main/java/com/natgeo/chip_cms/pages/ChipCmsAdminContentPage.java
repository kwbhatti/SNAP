package com.natgeo.chip_cms.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/admin/content")
public class ChipCmsAdminContentPage extends PageObject {
	
	public ChipCmsAdminContentPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(className="views-element-container")
	private WebElementFacade contentElementsContainer;
	
	@FindBys(value = {@FindBy(xpath="//*[@class='views-field views-field-type']/span[contains(.,'Story')]")}) 
	private List<WebElementFacade> storyContentItems;
	
	@FindBy(xpath="//*[@id='block-natgeo-admin-local-actions']/nav/li[2]/a")
	private WebElementFacade addContentButton;
	
	@FindBy(xpath="//div[@class='dropbutton-wrapper']//*[@class='edit']/a")
	private WebElementFacade storyEditButton;
	
	@FindBy(className = "ellipsis-icon")
	private WebElementFacade storyOptionsButton;
	
	@FindBy(xpath="//td[@class[contains(.,'views-field-title')]]/a")
	private WebElementFacade storyTitleAnchor;
	
	ChipCmsToolbar toolbar;
	
	public boolean isDisplayed() {
		return contentElementsContainer.isDisplayed();
	}

	public void goToEditStoryPage() {
		storyOptionsButton.click();
		storyEditButton.click();
	}

	public void goToEditTestContentItemPage() {
		TestContentItemOperations testContentItem = new TestContentItemOperations(getDriver());
		if (testContentItem.isCreated()) {
			testContentItem.edit();
			setDriver(testContentItem.getDriver());
		}
		// else
			//create new test content item
	}

}
