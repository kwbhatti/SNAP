package com.natgeo.chip_cms.scenarioSteps;

import org.openqa.selenium.WebDriver;

import com.natgeo.chip_cms.pages.ChipCmsContentPage;
import com.natgeo.chip_cms.pages.ChipCmsContentPrimarySettingsPage;
import com.natgeo.chip_cms.pages.ChipCmsCreateStoryPage;
import com.natgeo.chip_cms.pages.ChipCmsLayoutManagerPage;

import net.thucydides.core.annotations.Step;

public class PageLayoutSteps {

	private ChipCmsContentPage contentPage;
	private ChipCmsCreateStoryPage createStoryPage;
	private ChipCmsContentPrimarySettingsPage contentPrimarySettingsPage;
	private ChipCmsLayoutManagerPage layoutManagerPage;
	private WebDriver currentDriver;

	public void setDriver(WebDriver driver) {
		currentDriver = driver;
	}	
	
	@Step("New content button is displayed at content page")
	public void isNewContentButtonDisplayedAtContentPage (){
		contentPage = new ChipCmsContentPage(currentDriver);
		contentPage.isNewContentButtonDisplayed();
	}

	public void isContinueButtonDisplayedAtCreateStoryPage() {
		createStoryPage =  new ChipCmsCreateStoryPage(currentDriver);
		createStoryPage.isContinueButtonDisplayed();
		
	}

	public void isSaveButtonDisplayedAtContentPrimaryPage() {
		contentPrimarySettingsPage = new ChipCmsContentPrimarySettingsPage(currentDriver);
		contentPrimarySettingsPage.isSaveButtonDisplayed();
		
	}
	
	/*Layout Manager Chip tool bar*/
//	public void isChipToolBarDisplayedAtLayoutManagerPage() {
//		layoutManagerPage = new ChipCmsLayoutManagerPage(currentDriver);
//		layoutManagerPage.isChipToolBarDisplayed();
//		
//	}
	
	/*Layout Manager Save Button*/
	public void isSaveButtonDisplayedAtLayoutManagerPage() {
		layoutManagerPage = new ChipCmsLayoutManagerPage(currentDriver);
		layoutManagerPage.isSaveButtonDisplayed();
		
	}
	
	public void isLayoutManagerParagraphDisplayed() {
		layoutManagerPage = new ChipCmsLayoutManagerPage(currentDriver);
		layoutManagerPage.isParagraphDisplayed();
		
	}
	
	public void addButtonIsDisplayed() {
		layoutManagerPage = new ChipCmsLayoutManagerPage(currentDriver);
		layoutManagerPage.isAddButtonDisplayed();
		
	}
	
	public void componentsListsIsDisplayed() {
		layoutManagerPage = new ChipCmsLayoutManagerPage(currentDriver);
		layoutManagerPage.isComponentlistDisplayed();
		
	}
	
	public void dialogBoxIsDisplayed() {
		layoutManagerPage = new ChipCmsLayoutManagerPage(currentDriver);
		layoutManagerPage.isDialogBoxDisplayed();
		
	}
	public void imageAdded() {
		layoutManagerPage = new ChipCmsLayoutManagerPage(currentDriver);
		layoutManagerPage.isImageAdded();
		
	}
	

	
}
