package com.natgeo.auth0.pages;

import org.openqa.selenium.WebDriver;

import com.natgeo.common.NatGeoBasePage;

public class PlaygroundSuccessfulRegistrationPage extends NatGeoBasePage {

	private final static String CONFIRMATION_TEXT_XPATH = "//div[@id='verify-box']/div/h1";

	public PlaygroundSuccessfulRegistrationPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Return true if the the page show the successful registration of the profile  
	 * 
	 * @return if the text "You're done!" is showed 
	 */
	public boolean verifyRegistration() {
		String confirmation = findBy(CONFIRMATION_TEXT_XPATH).waitUntilPresent().getText();
		return confirmation.equals("You're done!");
	}
}
