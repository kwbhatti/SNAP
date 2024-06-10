package com.natgeo.auth0.pages;

import org.openqa.selenium.WebDriver;

import com.natgeo.common.NatGeoBasePage;


public class ProfilesServiceBasePage extends NatGeoBasePage {

	public ProfilesServiceBasePage(WebDriver driver) {
		super(driver);
	}

	public void goToHome() {
		open("profiles.services.home.page", withParameters(""));
	}

}
