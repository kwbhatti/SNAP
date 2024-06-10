package com.natgeo.cup.scenarioSteps;

import static org.junit.Assert.assertTrue;
import com.natgeo.cup.pages.CupManagerCommunityDetailsPage;
import com.natgeo.cup.pages.CupManagerCreateCommunityPage;
import com.natgeo.cup.pages.CupManagerHomePage;
import net.thucydides.core.annotations.Step;

public class CupManagerSteps {
	
	CupManagerHomePage managerHomePage;
	CupManagerCreateCommunityPage createCommunity;
	CupManagerCommunityDetailsPage details;
	
	@Step("Click on Create Community")
	public void clikOnCreateCommunity() {
		managerHomePage.clickOnCreateCommunity();
	}
	
	@Step("Click on Cancel Button")
	public void cancelCommunity() {
		createCommunity.createCommunityCancelButtonClick();
	}
	
	@Step("Check that you land in the Manager Home Page - List of Communities")
	public void validateManagerHomePage() {
		assertTrue("Assertion Error: Not able to see the Create Community Button ", createCommunity.checkForCreateCommunityButtonToBePresent());
	}
	
	@Step("Validate that all the UGCs were created")
	public void validateAllUgcCreated(int counter) {
		assertTrue("Assertion Error: The UGC was not created correctly ", createCommunity.allUgcCreated(counter));
	}
	
	@Step("Add N Number of UGCS to the Community you are about to create")
	public void addUgcs(String textName, String imageName, String richTextName) {
			createCommunity.defineUgcClick();
			createCommunity.clickOnAddNewElement();
			createCommunity.selectTextElement(textName);
			createCommunity.clickOnAddNewElement();
			createCommunity.selectImageElement(imageName);
			createCommunity.clickOnAddNewElement();
			createCommunity.selectRichTextElement(richTextName);
			createCommunity.saveUgcClick();
	}
	
	@Step("Validate that the UGC was created")
	public void validateUgcCreated() {
		assertTrue("Assertion Error: The UGC was not created", createCommunity.ugcCreated());
	}

	@Step("Click on Save")
	public void clikcOnSaveUgc() {
		createCommunity.saveUgcClick();
	}

	@Step("Click on Define UGC Tab")
	public void clickOnDefineUgcTab() {
		createCommunity.defineUgcClick();
	}

	@Step("Validate Text Element was added properly")
	public void textElementIsPresent() {
		createCommunity.validateTextWasAdded();
	}

	@Step("Validate Image Element was added properly")
	public void imageElementIsPresent() {
		createCommunity.validateImageWasAdded();
	}

	@Step("Validate Rich Text Element was added properly")
	public void richTextElementIsPresent() {
		createCommunity.validateRichTextWasAdded();
	}

	@Step("Add Text Element")
	public void addTextElement(String textName) {
		createCommunity.selectTextElement(textName);
	}

	@Step("Add Image Element")
	public void addImageElement(String imageName) {
		createCommunity.selectImageElement(imageName);
	}

	@Step("Add Rich Text Element")
	public void addRichTextElement(String richTextName) {
		createCommunity.selectRichTextElement(richTextName);
	}

	@Step("Add a New Element from the List of Existing Elements")
	public void addNewElement() {
		createCommunity.clickOnAddNewElement();
	}

	@Step("I am in the Define UGC Section")
	public void seeUgcSection() {
		createCommunity.ugcSectionTitleisPresent();
	}

	@Step("Click on ADD UGC CONTAINER")
	public void clickAddUgcContainer() {
		createCommunity.clicksOnAddUgcContainer();
	}

	@Step("Fill Community Name and Description")
	public void fillCommunityDetails(String name, String description) {
		createCommunity.fillNameNDescription(name, description);
	}

	@Step("Submit Community")
	public void submitCommunity() {
		createCommunity.submitCommunity();
		managerHomePage.waitForCreateCommunityToBeVisible();
	}
	
	@Step("Open Natgeo Manager Site Home Page")
	public void isOnTheHomePage() {
		managerHomePage.navigateToHomePage();
	}
	
	@Step("Checks for {0} to be Displayed")
	public void shouldSeeTheCommunity(String communityName) {
		assertTrue(communityName + " is not displayed", managerHomePage.validateCommunityDisplayed(communityName));
	}
	
	@Step("Check that Details of the Community are Visible")
	public void checksForDetailsToBeVisible() {
		assertTrue("Not able to see the Community Details", details.waitForUIToBeVisible());
	}
}
