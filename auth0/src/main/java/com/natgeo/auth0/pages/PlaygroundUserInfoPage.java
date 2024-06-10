package com.natgeo.auth0.pages;

import org.openqa.selenium.WebDriver;

import com.natgeo.common.NatGeoBasePage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class PlaygroundUserInfoPage extends NatGeoBasePage {

	@FindBy(css = ".btn-primary")
	public WebElementFacade btnLogOut;

	public PlaygroundUserInfoPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Return true if the profile is logged in
	 * 
	 * @return if the logout button is visible 
	 */
	public boolean verifyLogIn() {
		btnLogOut.waitUntilVisible();
		return btnLogOut.isCurrentlyVisible();
	}

}
