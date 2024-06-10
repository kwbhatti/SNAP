package com.natgeo.chip_cms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.natgeo.utilities.ScrollUtil;
import org.junit.Assert;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ChipCmsCreateStoryPage extends PageObject {

	public ChipCmsCreateStoryPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="chip-node-form-primary-form")
	private WebElementFacade storyForm;

	@FindBy(xpath="//input[@value='Continue']")
	private WebElementFacade continueButton	;

	@FindBy(id="edit-title-0-value")
	private WebElementFacade storyTitle;

	@FindBy(id="edit-field-seo-title-0-value")
	private WebElementFacade seoTitle;

	@FindBy(id="edit-field-social-title-0-value")
	private WebElementFacade socialTitle;

	@FindBy(id="edit-field-promo-title-0-value")
	private WebElementFacade promoTitle;

	@FindBy(id="edit-field-dek-0-value")
	private WebElementFacade dekText;

	@FindBy(id="edit-field-social-dek-0-value")
	private WebElementFacade socialDek;

	@FindBy(id="edit-field-promo-dek-0-value")
	private WebElementFacade promoDek;

	@FindBy(xpath="//*[@id='edit-layout']//label[@for='edit-layout-image']")
	private WebElementFacade imageLayoutRadio;

	@FindBy(xpath="//*[@id='edit-layout']//label[@for='edit-layout-video']")
	private WebElementFacade videoLayoutRadio;

	@FindBy(xpath="//*[@id='edit-layout']//label[@for='edit-layout-image-gallery']")
	private WebElementFacade galleryLayoutRadio;

	@FindBy(xpath="//*[@id='edit-layout']//label[@for='edit-layout-hub']")
	private WebElementFacade hubLayoutRadio;

	public void isDisplayed() {
		boolean isDisplayed = false;
		try {
			isDisplayed = storyForm.isDisplayed();
		}catch (Exception e) {
			isDisplayed = false;
		}
		Assert.assertTrue("Create Story page is not displayed", isDisplayed);
	}

	public void isContinueButtonDisplayed() {
		boolean isDisplayed = false;
		try {
			isDisplayed = storyForm.isDisplayed();
		}catch (Exception e) {
			isDisplayed = false;
		}
		Assert.assertTrue("Continue Button is not displayed", isDisplayed);
	}

	public void typeNewStoryTitle(String title) {
		boolean isTypeable = false;
		try {
			isTypeable = storyTitle.isDisplayed();
			storyTitle.click();
			storyTitle.type(title);

		}catch (Exception e) {
			isTypeable = false;
		}
		Assert.assertTrue("Not able to type story title", isTypeable);

	}

	public void typeSeoTitle(String title) {
		boolean isTypeable = false;
		try {
			isTypeable = seoTitle.isDisplayed();
			seoTitle.click();
			seoTitle.type(title);

		}catch (Exception e) {
			isTypeable = false;
		}
		Assert.assertTrue("Not able to type seo title", isTypeable);
	}

	public void typeSocialTitle(String title) {
		boolean isTypeable = false;
		try {
			isTypeable = socialTitle.isDisplayed();
			socialTitle.click();
			socialTitle.type(title);
		}catch (Exception e) {
			isTypeable = false;
		}
		Assert.assertTrue("Not able to type social title", isTypeable);
	}

	public void typePromoTitle(String title) {
		boolean isTypeable = false;
		try {
			isTypeable = promoTitle.isDisplayed();
			promoTitle.click();
			promoTitle.type(title);
		}catch (Exception e) {
			isTypeable = false;
		}
		Assert.assertTrue("Not able to type promo title", isTypeable);
	}

	public void typeDekText(String title) {
		boolean isTypeable = false;
		try {
			isTypeable = dekText.isDisplayed();
			dekText.click();
			dekText.type(title);
		}catch (Exception e) {
			isTypeable = false;
		}
		Assert.assertTrue("Not able to type dek text", isTypeable);
	}

	public void typeSocialDek(String title) {
		boolean isTypeable = false;
		try {
			isTypeable = socialDek.isDisplayed();
			socialDek.click();
			socialDek.type(title);
		}catch (Exception e) {
			isTypeable = false;
		}
		Assert.assertTrue("Not able to type social dek", isTypeable);
	}

	public void typePromoDek(String title) {
		boolean isTypeable = false;
		try {
			isTypeable = promoDek.isDisplayed();
			promoDek.click();
			promoDek.type(title);
		}catch (Exception e) {
			isTypeable = false;
		}
		Assert.assertTrue("Not able to type promo dek", isTypeable);
	}

	public void clickContinueButton() {
		boolean isClickable = false;
		try {
			ScrollUtil.scrollToEndOfElement(getDriver(), continueButton);
			isClickable = continueButton.isDisplayed();
			continueButton.click();
		}catch (Exception e) {
			isClickable = false;
		}
		Assert.assertTrue("Continue Button is not displayed", isClickable);
	}

	public void selectLayoutImage() {
		boolean isClickable = false;
		try {
			isClickable = imageLayoutRadio.isDisplayed();
			imageLayoutRadio.click();
		}catch (Exception e) {
			isClickable = false;
		}
		Assert.assertTrue("Could not select Layout type image at create story page", isClickable);
	}
	
  	public void selectLayoutVideo() {
		boolean isClickable = false;
		try {
			isClickable = videoLayoutRadio.isDisplayed();
			videoLayoutRadio.click();
		}catch (Exception e) {
			isClickable = false;
		}
		Assert.assertTrue("Could not select Layout type video at create story page", isClickable);
	}

	public void selectLayoutGallery() {
		boolean isClickable = false;
		try {
			isClickable = galleryLayoutRadio.isDisplayed();
			galleryLayoutRadio.click();
		}catch (Exception e) {
			isClickable = false;
		}
		Assert.assertTrue("Could not select Layout type gallery at create story page", isClickable);
	}
	
	public void selectLayoutHub() {
		boolean isClickable = false;
		try {
			isClickable = hubLayoutRadio.isDisplayed();
			hubLayoutRadio.click();
		}catch (Exception e) {
			isClickable = false;
		}
		Assert.assertTrue("Could not select Layout type hub at create story page", isClickable);
	}
}
