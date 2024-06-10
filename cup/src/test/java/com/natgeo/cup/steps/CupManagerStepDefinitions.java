package com.natgeo.cup.steps;

import com.natgeo.cup.scenarioSteps.CupLoginSteps;
import com.natgeo.cup.scenarioSteps.CupManagerSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CupManagerStepDefinitions {

	@Steps
	CupManagerSteps managerSteps;
	
	@Steps
	CupLoginSteps loginSteps;
	
	@Given("^a user is at Natgeo Manager Site, user: (.*), password: (.*)$")
	public void loginManagerSite(String userName, String password) {
		loginSteps.openMemberCenterStaging();
		loginSteps.logInMemberStaging(userName, password);
		managerSteps.isOnTheHomePage();
	}
	
	@When("^the user creates a Community with Name: (.*) and Description: (.*)$")
	public void createCommunity(String communityName, String communityDescription) {
		managerSteps.clikOnCreateCommunity();
		managerSteps.fillCommunityDetails(communityName, communityDescription);
		managerSteps.submitCommunity();
	}
	
	@Then("^(.*) is present in the Home Page$")
	public void verifyCommunityCreated(String communityName) {
		managerSteps.shouldSeeTheCommunity(communityName);
	}
	
	@When("^the user goes to create a new Community and clicks on Cancel$")
	public void cancelCreateCommunity() {
		managerSteps.clikOnCreateCommunity();
		managerSteps.cancelCommunity();
	}
	
	@Then("^the user should be redirected to the Manager site Home Page$")
	public void redirectedToManagerHomePage() {
		managerSteps.validateManagerHomePage();
	}
	
	@When("^The user selects the existing elements from ADD UGC CONTAINER filling the required content with: (.*), (.*) and (.*)$")
	public void selectElementsFromAddUgcContainer(String textName, String imageName, String richTextName) {
		managerSteps.clikOnCreateCommunity();
		managerSteps.clickAddUgcContainer();
		managerSteps.addNewElement();
		managerSteps.addTextElement(textName);
		managerSteps.addNewElement();
		managerSteps.addImageElement(imageName);
		managerSteps.addNewElement();
		managerSteps.addRichTextElement(richTextName);
	}
	
	@When("^The user selects the existing elements from DEFINE UGC filling the required content with: (.*), (.*) and (.*)$")
	public void selectElementsFromDefineUgc(String textName, String imageName, String richTextName) {
		managerSteps.clikOnCreateCommunity();
		managerSteps.clickOnDefineUgcTab();
		managerSteps.addNewElement();
		managerSteps.addTextElement(textName);
		managerSteps.addNewElement();
		managerSteps.addImageElement(imageName);
		managerSteps.addNewElement();
		managerSteps.addRichTextElement(richTextName);
	}
	
	@When("^The user saves the UGC$")
	public void saveUgc() {
		managerSteps.clikcOnSaveUgc();
	}
	
	@When("^The user creates (\\d+) UGCs with a Text, Image and Rich Text elements called: (.*), (.*) and (.*)$")
	public void addMultipleUgcs(int counter, String textName, String imageName, String richTextName) {
		managerSteps.clikOnCreateCommunity();
		for (int i = 1; i <= counter; i++) {
			managerSteps.addUgcs(textName, imageName, richTextName);
		}
	}
	
	@Then("^All the elements are added in the container before creating the UGC$")
	public void shouldSeeAllElementsAddedInTheUGC() {
		managerSteps.textElementIsPresent();
		managerSteps.imageElementIsPresent();
		managerSteps.richTextElementIsPresent();
	}
	
	@Then("^The UGC is created in the Define Community section$")
	public void seeUgcCreated() {
		managerSteps.validateUgcCreated();
	}
	
	@Then("^(\\d+) UGCs are created in the Create Community section$")
	public void seeAllUgcCreated(int counter) {
		managerSteps.validateAllUgcCreated(counter);
	}
	
	@Then("^I should see the Community Details$")
	public void seeCommunityDetails() {
		managerSteps.checksForDetailsToBeVisible();
	}
}