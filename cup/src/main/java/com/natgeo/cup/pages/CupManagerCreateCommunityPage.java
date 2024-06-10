package com.natgeo.cup.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CupManagerCreateCommunityPage extends CupBasePage {

	public CupManagerCreateCommunityPage(WebDriver driver) {
		super(driver);
	}

	CupManagerHomePage homePage;
	
	@FindBy(name = "name")
	public WebElementFacade communityName;

	@FindBy(name = "description")
	public WebElementFacade communityDescription;

	@FindBy(css = ".center .button:nth-child(2)")
	public WebElementFacade submitButton;

	@FindBy(css = "div.one button.ui")
	public WebElementFacade addUgcContainerButton;

	@FindBy(className = "segment")
	public WebElementFacade ugcListSegment;

	@FindBy(css = "i.plus")
	public WebElementFacade addElementIcon;

	@FindBy(css = "div.dropdown")
	public WebElementFacade elementsDropdown;

	@FindBy(css = "div.selected")
	public WebElementFacade textElement;

	@FindBy(xpath = "//label[contains(text(), 'Element name')]/following-sibling::div/input")
	public WebElementFacade elementName;

	@FindBy(css = "div[role='listitem'] input[type='text']")
	public WebElementFacade placeholder;

	@FindBy(css = "div.menu div:nth-of-type(3)")
	public WebElementFacade richTextElement;

	@FindBy(css = "div.menu div:nth-of-type(4)")
	public WebElementFacade imageElement;
	
	@FindBy(css = "div.menu div:nth-of-type(2)")
	public WebElementFacade selectElement;

	@FindBy(css = "button.primary")
	public WebElementFacade saveElementButton;

	@FindBy(css = "div.no-grow + div.content div:nth-of-type(1)")
	public WebElementFacade textAdded;

	@FindBy(css = "div.no-grow + div.content div:nth-of-type(2)")
	public WebElementFacade imageAdded;

	@FindBy(css = "div.no-grow + div.content div:nth-of-type(3)")
	public WebElementFacade richTextAdded;

	@FindBy(css = "a.active + a")
	public WebElementFacade defineUgcTab;

	@FindBy(css = "button.secondary+button")
	public WebElementFacade saveUgc;

	@FindBy(className = "ugc-container")
	public WebElementFacade singleUgc;

	@FindBy(className = "ugc-container")
	public List<WebElementFacade> ugcContainers;

	@FindBy(css = "div.basic > button.secondary")
	public WebElementFacade createCommunityCancelButton;

	public boolean checkForCreateCommunityButtonToBePresent() {
		try {
			homePage.createCommunityButton.waitUntilVisible();
			return homePage.createCommunityButton.isDisplayed();
			
		} catch (Exception e) {
			Assert.assertTrue("Unable to see the Create Community Button: ", false);
			return homePage.createCommunityButton.isDisplayed();
		}
	}
	
	public void createCommunityCancelButtonClick() {
		try {
			waitForVisibleAndClick(createCommunityCancelButton);			
		} catch (Exception e) {
			Assert.assertTrue("Unable to click on Cancel button: ", false);
		}
	}

	public boolean allUgcCreated(int counter) {
		try {
			return ugcContainers.size() == counter;
		} catch (Exception e) {
			Assert.assertTrue("Unable to see all the UGC created in the Create Community view: ", false);
			return false;
		}
	}

	public boolean ugcCreated() {
		try {
			communityName.waitUntilVisible();
			return singleUgc.isDisplayed();
		} catch (Exception e) {
			Assert.assertTrue("Unable to see the UGC created: ", false);
			return false;
		}
	}

	public void saveUgcClick() {
		try {
			waitForVisibleAndClick(saveUgc);
			communityName.waitUntilVisible();
		} catch (Exception e) {
			Assert.assertTrue("Unable to click on Save Ugc: ", false);
		}
	}

	public boolean validateTextWasAdded() {
		try {
			addElementIcon.waitUntilClickable();
			return textAdded.isDisplayed();
		} catch (Exception e) {
			Assert.assertTrue("Unable to see Text Element on the List: ", false);
			return false;
		}
	}

	public boolean validateImageWasAdded() {
		try {
			addElementIcon.waitUntilClickable();
			return imageAdded.isDisplayed();
		} catch (Exception e) {
			Assert.assertTrue("Unable to see Image Element on the List: ", false);
			return false;
		}
	}

	public boolean validateRichTextWasAdded() {
		try {
			addElementIcon.waitUntilClickable();
			return richTextAdded.isDisplayed();
		} catch (Exception e) {
			Assert.assertTrue("Unable to see Rich Text Element on the List: ", false);
			return false;
		}
	}

	public void selectTextElement(String textName) {
		try {
			typeInElement(elementName, textName);
			waitForVisibleAndClick(elementsDropdown);
			waitForVisibleAndClick(textElement);
			typeInElement(placeholder, textName);
			waitForVisibleAndClick(saveElementButton);
		} catch (Exception e) {
			Assert.assertTrue("Unable to add the Text Field: ", false);
		}
	}
	
	public void selectSelectElement(String selectName, String value, String text) {
		try {
			typeInElement(elementName, selectName);
			waitForVisibleAndClick(elementsDropdown);
			waitForVisibleAndClick(selectElement);
			typeInElement(placeholder, selectName);
			waitForVisibleAndClick(saveElementButton);
		} catch (Exception e) {
			Assert.assertTrue("Unable to add the Select Element: ", false);
		}
	}

	public void selectImageElement(String imageName) {
		try {
			typeInElement(elementName, imageName);
			waitForVisibleAndClick(elementsDropdown);
			waitForVisibleAndClick(imageElement);
			waitForVisibleAndClick(saveElementButton);
		} catch (Exception e) {
			Assert.assertTrue("Unable to add the Image Element: ", false);
		}
	}

	public void selectRichTextElement(String richTextName) {
		try {
			typeInElement(elementName, richTextName);
			waitForVisibleAndClick(elementsDropdown);
			waitForVisibleAndClick(richTextElement);
			typeInElement(placeholder, richTextName);
			waitForVisibleAndClick(saveElementButton);
		} catch (Exception e) {
			Assert.assertTrue("Unable to add the Rich Text Element: ", false);
		}
	}

	public void clickOnAddNewElement() {
		try {
			waitForVisibleAndClick(addElementIcon);
		} catch (Exception e) {
			Assert.assertTrue("Unable to click on + symbol to add a new element: ", false);
		}
	}

	public boolean ugcSectionTitleisPresent() {
		try {
			return ugcListSegment.isDisplayed();
		} catch (Exception e) {
			Assert.assertTrue("Unable to see the Define UGC Section ", false);
			return false;
		}
	}

	public boolean clicksOnAddUgcContainer() {
		try {
			waitForVisibleAndClick(addUgcContainerButton);
			ugcListSegment.waitUntilVisible();
			return ugcListSegment.isDisplayed();
		} catch (Exception e) {
			Assert.assertTrue("Not able to click on ADD UGC CONTAINER: ", false);
			return false;
		}
	}

	public boolean defineUgcClick() {
		try {
			waitForVisibleAndClick(defineUgcTab);
			ugcListSegment.waitUntilVisible();
			return ugcListSegment.isDisplayed();
		} catch (Exception e) {
			Assert.assertTrue("Not able to click on DEFINE UGC: ", false);
			return false;
		}
	}

	public void fillNameNDescription(String name, String description) {
		try {
			typeInElement(communityName, name);
			typeInElement(communityDescription, description);
		} catch (Exception e) {
			Assert.assertTrue("Not able to fill Name and Description ", false);
		}
	}

	public void submitCommunity() {
		try {
			waitForVisibleAndClick(submitButton);
		} catch (Exception e) {
			Assert.assertTrue("Unable to click on Submit: ", false);
		}
	}
}
