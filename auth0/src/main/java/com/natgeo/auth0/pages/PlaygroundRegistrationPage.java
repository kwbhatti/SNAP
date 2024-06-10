package com.natgeo.auth0.pages;

import java.util.Date;

import org.openqa.selenium.WebDriver;

import com.natgeo.common.NatGeoBasePage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class PlaygroundRegistrationPage extends NatGeoBasePage {

	private final static String LOCATION_CSS = "[tabindex='0']";
	private final static String COUNTRY_SELECTION_CSS = "//body/ul/li[1]";

	@FindBy(id = "firstName_singup")
	public WebElementFacade txtFirstName;

	@FindBy(id = "lastName_singup")
	public WebElementFacade txtLastName;

	@FindBy(id = "email_singup")
	public WebElementFacade txtEmail;

	@FindBy(id = "password_singup")
	public WebElementFacade txtPassword;

	@FindBy(id = "confirm_password")
	public WebElementFacade txtPasswordConfirm;

	@FindBy(id = "locationReference")
	public WebElementFacade txtCity;

	@FindBy(id = "btn-signup")
	public WebElementFacade btnJoin;

	public PlaygroundRegistrationPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Fill the fields with the given information and clicks on Join button
	 * 
	 * @param fName the first name of the user
	 * @param lName the last name of the user
	 * @param email the email of the user
	 * @param pass the password for the account
	 * @param city the city of the user
	 */
	public void fillInformation(String fName, String lName, String email, String pass,
			String city) {
		txtFirstName.sendKeys(fName);
		txtLastName.sendKeys(lName);
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(pass);
		txtPasswordConfirm.sendKeys(pass);
		txtCity.sendKeys(city);
		findBy(LOCATION_CSS).waitUntilPresent().waitUntilEnabled();
		findBy(COUNTRY_SELECTION_CSS).waitUntilPresent().click();
		btnJoin.waitUntilClickable().click();
	}

	/**
	 * Returns a random generated email
	 * 
	 * @return the generated email
	 */
	public String generateRandomProfile() {
		String actualDate = "" + new Date().getTime();
		String email = actualDate + "_autombot@mailinator.com";
		return email;
	}
}
