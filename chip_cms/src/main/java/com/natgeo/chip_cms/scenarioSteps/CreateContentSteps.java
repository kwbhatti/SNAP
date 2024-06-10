package com.natgeo.chip_cms.scenarioSteps;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import com.natgeo.chip_cms.pages.ChipCmsContentPage;
import com.natgeo.chip_cms.pages.ChipCmsCreateStoryPage;
import com.natgeo.chip_cms.pages.ChipCmsStoryTextViewPage;
import com.natgeo.chip_cms.pages.ChipCmsContentTypesPage;
import net.thucydides.core.annotations.Step;

public class CreateContentSteps {

	private ChipCmsContentPage contentPage;
	private ChipCmsCreateStoryPage createStoryPage;
	private ChipCmsStoryTextViewPage storyTextViewPage;
	private ChipCmsContentTypesPage contentTypesPage;
	private WebDriver currentDriver;

	public void setDriver(WebDriver driver) {
		currentDriver = driver;
	}

	public void isNewContentButtonDisplayedAtContentPage (){
		contentPage = new ChipCmsContentPage(currentDriver);
		contentPage.isNewContentButtonDisplayed();
	}

	@Step("Clicks on New Content button")
	public WebDriver clickOnNewContentButton() {
		contentPage = new ChipCmsContentPage(currentDriver);
		contentPage.clickOnNewContentButton();
		return contentPage.getDriver();
	}

	@Step("Enters new story title")
	public void enterNewStoryTitle(String storyTitle) {
		createStoryPage = new ChipCmsCreateStoryPage(currentDriver);
		createStoryPage.typeNewStoryTitle(storyTitle);
	}

	@Step("Enters SEO title")
	public void enterSeoTitle(String seoTitle) {
		createStoryPage = new ChipCmsCreateStoryPage(currentDriver);
		createStoryPage.typeSeoTitle(seoTitle);
	}

	@Step("Enters Social title")
	public void entersocialTitle(String socialTitle) {
		createStoryPage = new ChipCmsCreateStoryPage(currentDriver);
		createStoryPage.typeSocialTitle(socialTitle);
	}

	@Step("Enters Promo title")
	public void enterpromoTitle(String promoTitle) {
		createStoryPage = new ChipCmsCreateStoryPage(currentDriver);
		createStoryPage.typePromoTitle(promoTitle);
	}

	@Step("Enters Dek Text")
	public void enterdekText(String dekText) {
		createStoryPage = new ChipCmsCreateStoryPage(currentDriver);
		createStoryPage.typeDekText(dekText);
	}

	@Step("Enters Social Dek")
	public void entersocialDek(String socialDek) {
		createStoryPage = new ChipCmsCreateStoryPage(currentDriver);
		createStoryPage.typeSocialDek(socialDek);
	}

	@Step("Enters Promo Dek")
	public void enterpromoDek(String promoDek) {
		createStoryPage = new ChipCmsCreateStoryPage(currentDriver);
		createStoryPage.typePromoDek(promoDek);
	}

	public WebDriver createNewStoryLayoutImageAndContinueToTextView() {
		clickOnNewContentButton();
	    return selectStoryLayoutImageEnterTitleAndContinueToTextView();
	}

	public WebDriver createNewStoryLayoutVideoAndContinueToTextView() {
		clickOnNewContentButton();
	    return selectStoryLayoutVideoEnterTitleAndContinueToTextView();
	}

	public WebDriver createNewStoryLayoutGalleryAndContinueToTextView() {
		clickOnNewContentButton();
	    return selectStoryLayoutGalleryEnterTitleAndContinueToTextView();
	}

	public WebDriver createNewStoryLayoutHubAndContinueToTextView() {
		clickOnNewContentButton();
	    return selectStoryLayoutHubEnterTitleAndContinueToTextView();
	}

	public WebDriver clickOnSaveButtonAtStoryTextViewPage() {
		storyTextViewPage = new ChipCmsStoryTextViewPage(currentDriver);
		storyTextViewPage.clickSaveButton();
		return storyTextViewPage.getDriver();
	}

	public WebDriver selectStoryLayoutImageEnterTitleAndContinueToTextView() {
	    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    Date date = new Date();
		createStoryPage = new ChipCmsCreateStoryPage(currentDriver);
		createStoryPage.selectLayoutImage();
		createStoryPage.typeNewStoryTitle("Automation Test By Selecting Layout Type Image" + dateFormatter.format(date));
		createStoryPage.typeSeoTitle("Photography");
		createStoryPage.typeSocialTitle("Pets");
		createStoryPage.typePromoTitle("Pets Photography");
		createStoryPage.typeDekText("Labrador");
		createStoryPage.typeSocialDek("He is the Best");
		createStoryPage.typePromoDek("Support Pets");
		createStoryPage.clickContinueButton();
		return createStoryPage.getDriver();
	}

	public WebDriver selectStoryLayoutVideoEnterTitleAndContinueToTextView() {
	    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    Date date = new Date();
		createStoryPage = new ChipCmsCreateStoryPage(currentDriver);
		createStoryPage.selectLayoutVideo();
		createStoryPage.typeNewStoryTitle("Automation Test By Selecting Layout Type Video" + dateFormatter.format(date));
		createStoryPage.typeSeoTitle("Photography");
		createStoryPage.typeSocialTitle("Pets");
		createStoryPage.typePromoTitle("Pets Photography");
		createStoryPage.typeDekText("Labrador");
		createStoryPage.typeSocialDek("He is the Best");
		createStoryPage.typePromoDek("Support Pets");
		createStoryPage.clickContinueButton();
		return createStoryPage.getDriver();
	}

	public WebDriver selectStoryLayoutGalleryEnterTitleAndContinueToTextView() {
	    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    Date date = new Date();
		createStoryPage = new ChipCmsCreateStoryPage(currentDriver);
		createStoryPage.selectLayoutGallery();
		createStoryPage.typeNewStoryTitle("Automation Test By Selecting Layout Type Gallery" + dateFormatter.format(date));
		createStoryPage.typeSeoTitle("Photography");
		createStoryPage.typeSocialTitle("Pets");
		createStoryPage.typePromoTitle("Pets Photography");
		createStoryPage.typeDekText("Labrador");
		createStoryPage.typeSocialDek("He is the Best");
		createStoryPage.typePromoDek("Support Pets");
		createStoryPage.clickContinueButton();
		return createStoryPage.getDriver();
	}

	public WebDriver selectStoryLayoutHubEnterTitleAndContinueToTextView() {
	    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    Date date = new Date();
		createStoryPage = new ChipCmsCreateStoryPage(currentDriver);
		createStoryPage.selectLayoutHub();
		createStoryPage.typeNewStoryTitle("Automation Test By Selecting Layout Type Hub" + dateFormatter.format(date));
		createStoryPage.typeSeoTitle("Photography");
		createStoryPage.typeSocialTitle("Pets");
		createStoryPage.typePromoTitle("Pets Photography");
		createStoryPage.typeDekText("Labrador");
		createStoryPage.typeSocialDek("He is the Best");
		createStoryPage.typePromoDek("Support Pets");
		createStoryPage.clickContinueButton();
		return createStoryPage.getDriver();
	}

	public void createTestContentItem() {
		contentTypesPage.createTestContentType();
		contentTypesPage.addTaxonomyFieldsToTestContentType();
	}

}
