package com.natgeo.auth0.pages;

import org.openqa.selenium.WebDriver;

import com.natgeo.common.NatGeoBasePage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProfileServiceProfileInfoPage extends NatGeoBasePage {
	
	private final String CONFIRM_DELETION = "//div[@id='content']/form/div/input[2]";
	
	@FindBy(css = ".deletelink")
	private WebElementFacade btnDelete;

	public ProfileServiceProfileInfoPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Deletes the profile I'm watching
	 */
	public void deleteProfile() {
		btnDelete.click();
		findBy(CONFIRM_DELETION).waitUntilClickable().click();
	}

}
