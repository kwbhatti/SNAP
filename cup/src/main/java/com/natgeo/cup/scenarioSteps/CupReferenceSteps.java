package com.natgeo.cup.scenarioSteps;

import static org.junit.Assert.assertTrue;
import com.natgeo.cup.pages.CupReferenceContentDetails;
import com.natgeo.cup.pages.CupReferenceHomePage;
import com.natgeo.cup.pages.CupReferenceMyContent;
import com.natgeo.cup.pages.CupReferenceViewAllTipsPage;
import net.thucydides.core.annotations.Step;

public class CupReferenceSteps {
	
	CupReferenceHomePage referenceHomePage;
	CupReferenceViewAllTipsPage referenceAllTipsPage;
	CupReferenceContentDetails referenceDetails;
	CupReferenceMyContent referenceMyContent;
	
	@Step("Validate Title, Category and Description of a Story Created")
	public void validateStoryCreated(String title, String category, String description) {
		referenceDetails.checkForStoryDetailsToMatch(title, category, description);
	}
	
	@Step("Validate Title, Category and Description of a Photo Created")
	public void validatePhotoCreated(String title, String category, String caption) {
		referenceDetails.checkForPhotoDetailsToMatch(title, category, caption);
	}
	
	@Step("Validate Title, Category and Description of a Tip Created")
	public void validateTipCreated(String title, String category, String description) {
		referenceDetails.checkForTipDetailsToMatch(title, category, description);
	}
	
	@Step("Make a Comment into a Story")
	public void commentStory(String comment) {
		referenceDetails.typeComment(comment);
	}
	
	@Step("Validate Comment Created")
	public void lookForComment(String comment) {
		referenceDetails.validateCommentCreated(comment);
	}
	
	@Step("Click on Like")
	public void likeContent() {
		referenceDetails.clickOnLike();
	}
	
	@Step("Go to a Story Details")
	public void goToStoryDetails() {
		referenceHomePage.clickOnReadDetails();
	}
	
	@Step("Return To Home Page")
	public void returnToHomePage() {
		referenceHomePage.returnToHomePage();
	}
	
	@Step("Click on Delete Content")
	public void deleteContent() {
		referenceDetails.clickOnDeleteContent();
	}
	
	@Step("Click on Update Content")
	public void goToUpdateContent() {
		referenceDetails.clickOnUpdateContent();
	}
	
	@Step("Check that the changes you made on the UGC are Correct")
	public void checkForContentUpdates(String title, String category, String description) {
		referenceDetails.validateContentUpdates(title, category, description);
	}
	
	@Step("Go to a Content Details")
	public void goToContentDetails() {
		referenceMyContent.clickOnReadDetails();
	}
	
	@Step("Go To My Content")
	public void goToMyContent() {
		referenceHomePage.clickOnMyContent();
	}
	
	@Step("Follow a User from Home")
	public void findUserAndFollow() {
		referenceHomePage.findFollowButtonAndClick();
	}
	
	@Step("Wait For Page To Be Ready")
	public void waitForNavBarToBeVisible() {
		referenceHomePage.navBarReady();
	}
	
	@Step("Validate that the new Tip is Created")
	public void validateTipCreated(String title) {
		referenceHomePage.clickOnViewAllTips();
		assertTrue("The title you add does not match with any existing Title", referenceAllTipsPage.compareTipsTitle(title));
	}
	
	@Step("Click on Upload Tip")
	public void clickOnUploadTip() {
		referenceHomePage.uploadTip();
	}
	
	@Step("Click on Upload Story")
	public void clickOnUploadStory() {
		referenceHomePage.uploadStory();
	}
	
	@Step("Click on Upload Photo")
	public void clickOnUploadPhoto() {
		referenceHomePage.uploadPhoto();
	}
	
	@Step("Open Natgeo Reference Site Home Page")
	public void isOnTheReferenceHomePage() {
		referenceHomePage.navigateToReferenceHomePage();
	}
}