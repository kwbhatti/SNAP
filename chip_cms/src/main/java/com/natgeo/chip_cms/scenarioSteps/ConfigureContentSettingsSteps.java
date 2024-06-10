package com.natgeo.chip_cms.scenarioSteps;

import org.openqa.selenium.WebDriver;
import com.natgeo.chip_cms.pages.ChipCmsContentSettingsPage;
import com.natgeo.chip_cms.pages.ChipCmsLayoutManagerPage;

import net.thucydides.core.annotations.Step;

public class ConfigureContentSettingsSteps {

	private ChipCmsContentSettingsPage contentSettingsPage;
	private ChipCmsLayoutManagerPage layoutManagerPage;
	private WebDriver currentDriver;
	
	public void setDriver(WebDriver driver) {
		currentDriver = driver;
	}

	@Step("Clicks on Primary Tab")
	public void clicksOnPrimaryTab (){
		contentSettingsPage = new ChipCmsContentSettingsPage(currentDriver);
		contentSettingsPage.clicksOnPrimaryTab();
	}

	public void clicksOnSecondaryTab() {
		contentSettingsPage = new ChipCmsContentSettingsPage(currentDriver);
		contentSettingsPage.clicksOnSecondaryTab();
	}

	public void clicksOnAdvertisingTab() {
		contentSettingsPage = new ChipCmsContentSettingsPage(currentDriver);
		contentSettingsPage.clicksOnAdvertisingTab();
	}

	public void clicksOnTechnicalTab() {
		contentSettingsPage = new ChipCmsContentSettingsPage(currentDriver);
		contentSettingsPage.clicksOnTechnicalTab();
	}
	
	public void clicksOnLayoutParagraph() {
		layoutManagerPage = new ChipCmsLayoutManagerPage(currentDriver);
		layoutManagerPage.clicksOnLayoutManagerParagraph();
	}
	public void clicksOnAddButton() {
		layoutManagerPage = new ChipCmsLayoutManagerPage(currentDriver);
		layoutManagerPage.clicksOnplusButton();
	}

	public void clicksOnImageBox() {
		layoutManagerPage = new ChipCmsLayoutManagerPage(currentDriver);
		layoutManagerPage.clicksOnImageBox();
	}
	public void clicksOnLayoutToolBar() {
		layoutManagerPage = new ChipCmsLayoutManagerPage(currentDriver);
		layoutManagerPage.clicksOnLayoutToolBar();
	}
}
