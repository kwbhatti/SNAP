package com.natgeo.cup.steps;

import com.natgeo.cup.scenarioSteps.CupReferenceSteps;
import com.natgeo.cup.scenarioSteps.CupLoginSteps;
import com.natgeo.cup.scenarioSteps.CupReferenceCreateContentSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CupReferenceStepDefinitions {

	@Steps
	CupReferenceSteps communitySteps;
	
	@Steps
	CupReferenceCreateContentSteps createContent;
	
	@Steps
	CupLoginSteps loginSteps;

	@Given("^a user open the Member Center Staging Login Page and log in with credentials: \"([^\"]*)\", \"([^\"]*)\"$")
	public void memberCenterLogin(String userName, String password) {
		loginSteps.openMemberCenterStaging();
		loginSteps.logInMemberStaging(userName, password);
	}
	
	@Given("^a user is at Natgeo Reference Site, user: \"([^\"]*)\", password: \"([^\"]*)\"$")
	public void referenceSiteMemberCenterLogin(String userName, String password) {
		loginSteps.openMemberCenterStaging();
		loginSteps.logInMemberStaging(userName, password);
		communitySteps.isOnTheReferenceHomePage();
	}
	
	@When("^The user creates a Photo with the following information: Title = (.*), Category = (.*) and Caption = (.*)$")
	public void createPhoto(String title, String category, String caption) {
		communitySteps.clickOnUploadPhoto();
		createContent.searchImageByName(category);
		createContent.createPhoto(title, category, caption);
		createContent.clickOnPublishUgc();
	}
	
	@When("^The user creates a Story with the following information: Title = (.*), Subtitle = (.*), Category = (.*) and Description = (.*)$")
	public void createStory(String title, String subTitle, String category, String description) {
		communitySteps.clickOnUploadStory();
		createContent.searchImageByName(category);
		createContent.createStory(title, subTitle, category, description);
		createContent.clickOnPublishUgc();
	}
	
	@When("^The user previews a content with details: Title = (.*), Category = (.*) and Description = (.*) before creating it$")
	public void previewContent(String title, String category, String description) {
		communitySteps.clickOnUploadTip();
		createContent.createTip(title, category, description);
		createContent.clickOnPreviewUgc();
	}
	
	@When("^The user creates a tip with the following information: Title = (.*), Category = (.*) and Description = (.*)$")
	public void createTip(String title, String category, String description) {
		communitySteps.clickOnUploadTip();
		createContent.createTip(title, category, description);
		createContent.clickOnPublishUgc();
	}
	
	@When("^I log out$")
	public void logOutFromMemberStaging() {
		loginSteps.logOut();
	}
	
	@When("^I Follow a User$")
	public void followUser() {
		communitySteps.findUserAndFollow();
	}
	
	@Then("^The user enters to a content details and click on Like$")
	public void likeContent() {
		communitySteps.goToStoryDetails();
		communitySteps.likeContent();
	}
	
	@When("^The user Deletes one of his own Contents$")
	public void deleteMyContent() {
		communitySteps.goToMyContent();
		communitySteps.goToContentDetails();
		communitySteps.deleteContent();
	}
	
	@When("^The user Updates one of his own Contents with Title = (.*), Subtitle = (.*), Category = (.*), Description = (.*)$")
	public void updateMyContent(String title, String subtitle, String category, String description) {
		communitySteps.goToMyContent();
		communitySteps.goToContentDetails();
		communitySteps.goToUpdateContent();
		createContent.updateContent(title, subtitle, category, description);
	}
	
	@When("^The user makes a Comment (.*) into a Story$")
	public void commentIntoStory(String comment) {
		communitySteps.goToStoryDetails();
		communitySteps.commentStory(comment);
	}
	
	@Then("^The comment (.*) is successfully posted$")
	public void commentPosted(String comment) {
		communitySteps.lookForComment(comment);
	}
	
	@Then("^The Updates are displayed: Title = (.*), Category = (.*), Description = (.*)$")
	public void validateContentUpdates(String title, String category, String description) {
		communitySteps.checkForContentUpdates(title, category, description);
	}
	
	@Then("^The content is deleted and Home page is displayed$")
	public void validateReturnToHomePageAfterAction() {
		communitySteps.returnToHomePage();
	}
	
	@Then("^The content with the details: Title = (.*), of Category = (.*) and Description = (.*) is showed$")
	public void validatePreviewTip(String title, String category, String description) {
		createContent.checkTipPreviewDetails(title, category, description);
	}

	@Then("^I should be redirected to the Member Center Login Page$")
	public void validateLogOut() {
		loginSteps.logOutValidation();
	}
	
	@Then("^The user logs in to the page$")
	public void validateSession() {
		loginSteps.loggedInToMemberStaging();
	}
	
	@Then("^The new Tip with Title = (.*), Category = (.*) and Description = (.*) is created$")
	public void iShouldBeAbleToCreateTip(String title, String category, String description) {
		communitySteps.validateTipCreated(title, category, description);
	}
	
	@Then("^The new Story with Title = (.*), Category = (.*) and Description = (.*) is created$")
	public void validateStoryDetails(String title, String category, String description) {
		communitySteps.validateStoryCreated(title, category, description);
	}
	
	@Then("^The new Photo with Title = (.*), Category = (.*) and Caption = (.*) is created$")
	public void validatePhotoDetails(String title, String category, String caption) {
		communitySteps.validatePhotoCreated(title, category, caption);
	}
}