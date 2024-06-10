package com.natgeo.cup.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CupReferenceCreateUGCPage extends CupBasePage {

	public CupReferenceCreateUGCPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".header > h1")
	private WebElementFacade contentTitle;

	@FindBy(css = "input[placeholder='subtitle...']")
	private WebElementFacade storySubtitle;

	@FindBy(css = ".button.black")
	private WebElementFacade uploadImageButton;

	@FindBy(css = ".fsp-source-list__item:nth-of-type(3) > span.fsp-icon")
	private WebElementFacade searchImageByNameButton;

	@FindBy(css = ".fsp-image-search__form > input")
	private WebElementFacade searchImageTextField;

	@FindBy(css = ".fsp-image-search__form > input + button")
	private WebElementFacade searchImageButton;

	@FindBy(css = ".fsp-image-grid > div:nth-child(1) img")
	private WebElementFacade selectFirstImage;

	@FindBy(css = ".cropper-drag-box img")
	private WebElementFacade imageLoaded;

	@FindBy(css = ".fsp-button--primary")
	private WebElementFacade uploadImageLoaded;

	@FindBy(css = "label + input")
	private WebElementFacade title_field;

	@FindBy(css = "input.search")
	private WebElementFacade categoryMenu;

	@FindBy(css = "div[role='listbox'] div:nth-of-type(1)")
	private WebElementFacade categoryOption_dogs;

	@FindBy(css = "div[role='listbox'] div:nth-of-type(2)")
	private WebElementFacade categoryOption_cats;

	@FindBy(css = "div[role='listbox'] div:nth-of-type(3)")
	private WebElementFacade categoryOption_birds;

	@FindBy(css = ".cke_editable > p") // Remember to enter the Frame first
	private WebElementFacade descriptionTextArea;
	
	@FindBy(css = "iframe[title='Rich Text Editor, editor1']")
	public WebElementFacade descriptionIFrame;

	@FindBy(css = ".create-container .field:nth-child(5) input")
	private WebElementFacade captionField;

	@FindBy(css = "div.action-buttons button:nth-of-type(1)")
	private WebElementFacade cancelButton;

	@FindBy(css = "div.action-buttons button:nth-of-type(3)")
	private WebElementFacade saveButton;

	@FindBy(css = "div.action-buttons button:nth-of-type(2)")
	private WebElementFacade previewButton;

	@FindBy(css = ".input-form .field:nth-child(5) input")
	private WebElementFacade photoCaption;

	public void selectImageByName(String category) {
		try {
			waitForVisibleAndClick(uploadImageButton);
		} catch (Exception e) {
			Assert.assertTrue("Unable to click on Upload to enter to Filestack: ", false);
		}
		try {
			waitForVisibleAndClick(searchImageByNameButton);
		} catch (Exception e) {
			Assert.assertTrue("Unable to click on the Search By Name Icon: ", false);
		}
		try {
			typeInElement(searchImageTextField, category);
		} catch (Exception e) {
			Assert.assertTrue("Unable to type text on the Search Field: ", false);
		}
		try {
			waitForVisibleAndClick(searchImageButton);
		} catch (Exception e) {
			Assert.assertTrue("Unable to click on click on Search: ", false);
		}
		try {
			Thread.sleep(2000);
			waitForVisibleAndClick(selectFirstImage);
		} catch (Exception e) {
			Assert.assertTrue("Unable to select the first Image: ", false);
		}
		try {
			Thread.sleep(5000);
			waitForVisibleAndClick(uploadImageLoaded);
		} catch (Exception e) {
			Assert.assertTrue("Unable to click on Upload When Image is Loaded: ", false);
		}
	}

	public void updateContentDetails(String title, String subtitle, String category, String description) {
		try {

			contentTitle.waitUntilVisible();
			String uploadTitleText = contentTitle.getText();

			switch (uploadTitleText.toLowerCase()) {

			case "upload story":
				selectImageByName(category);
				fillStoryDetails(title, subtitle, category, description);
				break;

			case "upload tip":
				fillTipDetails(title, category, description);
				break;

			case "upload photo":
				selectImageByName(category);
				fillPhotoDetails(title, category, description);
				break;
			}
			waitForVisibleAndClick(saveButton);

		} catch (Exception e) {
			Assert.assertTrue("Unable to edit the content: ", false);
		}
	}

	public void fillPhotoDetails(String title, String category, String caption) {
		try {
			typeInElement(title_field, title);
			waitForVisibleAndClick(categoryMenu);

			switch (category.toLowerCase()) {

			case "dogs":
				waitForVisibleAndClick(categoryOption_dogs);
				break;

			case "cats":
				waitForVisibleAndClick(categoryOption_cats);
				break;
			case "birds":
				waitForVisibleAndClick(categoryOption_birds);
				break;

			default:
				System.out.println("Please select either Dogs, Cats or Birds");
				break;
			}

			typeInElement(captionField, caption);

		} catch (Exception e) {
			Assert.assertTrue("Unable to fill all the Tip Details: ", false);
		}
	}

	public void fillTipDetails(String title, String category, String description) {
		try {
			typeInElement(title_field, title);
			waitForVisibleAndClick(categoryMenu);

			switch (category.toLowerCase()) {

			case "dogs":
				waitForVisibleAndClick(categoryOption_dogs);
				break;

			case "cats":
				waitForVisibleAndClick(categoryOption_cats);
				break;
			case "birds":
				waitForVisibleAndClick(categoryOption_birds);
				break;

			default:
				System.out.println("Please select either Dogs, Cats or Birds");
				break;
			}
			typeDescription(description);

		} catch (Exception e) {
			Assert.assertTrue("Unable to fill all the Tip Details: ", false);
		}
	}

	public void fillStoryDetails(String title, String subTitle, String category, String description) {
		try {
			typeStoryTitle(title);
			typeStorySubTitle(subTitle);
			waitForVisibleAndClick(categoryMenu);

			switch (category.toLowerCase()) {
			case "dogs":
				waitForVisibleAndClick(categoryOption_dogs);
				break;
			case "cats":
				waitForVisibleAndClick(categoryOption_cats);
				break;
			case "birds":
				waitForVisibleAndClick(categoryOption_birds);
				break;

			default:
				System.out.println("Please select either Dogs, Cats or Birds");
				break;
			}
			typeDescription(description);
			
		} catch (Exception e) {
			Assert.assertTrue("Unable to fill all the Story Details: ", false);
		}
	}

	public void typeDescription(String description) {
		try {
			descriptionIFrame.waitUntilEnabled();
			getDriver().switchTo().frame(descriptionIFrame);
			typeInElement(descriptionTextArea, description);
			getDriver().switchTo().defaultContent();
		} catch (Exception e) {
			System.out.println("************ Error: "+e.getMessage()+"***************");
			Assert.assertTrue("Unable to type description into IFrame", false);
		}
	}
	
	public void publishUGC() {
		try {
			waitForVisibleAndClick(saveButton);
		} catch (Exception e) {
			Assert.assertTrue("Unable to click on the Publish Button: ", false);
		}
	}

	public void previewUgc() {
		try {
			waitForVisibleAndClick(previewButton);
		} catch (Exception e) {
			Assert.assertTrue("Unable to click on Preview Button: ", false);
		}
	}

	public void typeStoryTitle(String storyTitle) {
		try {
			typeInElement(title_field, storyTitle);

		} catch (Exception e) {
			Assert.assertTrue("Unable to write Story Title: ", false);
		}
	}

	public void typeStorySubTitle(String storySubTitle) {
		try {
			typeInElement(storySubtitle, storySubTitle);

		} catch (Exception e) {
			Assert.assertTrue("Unable to write Story Subtitle: ", false);
		}
	}
}