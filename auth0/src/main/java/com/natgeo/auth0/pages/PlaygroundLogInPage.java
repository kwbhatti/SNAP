package com.natgeo.auth0.pages;

import org.openqa.selenium.WebDriver;

import com.natgeo.common.NatGeoBasePage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class PlaygroundLogInPage extends NatGeoBasePage {

	private final static String PASSWORD_CSS = "#password";

	@FindBy(id = "email")
	public WebElementFacade txtEmail;

	@FindBy(id = "btn-login")
	public WebElementFacade btnLogIn;

	@FindBy(id = "btn-facebook")
	public WebElementFacade btnFacebook;

	@FindBy(xpath = "//div[@id='otherOptions']/div[4]/a[@class='mt3_textlink']")
	public WebElementFacade btnJoin;

	public PlaygroundLogInPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Clicks on Join now text in the page
	 */
	public void clickOnJoinNow() {
		btnJoin.waitUntilClickable().click();
	}

	/**
	 * Fills the email field and click on log in
	 * 
	 * @param mail the registered email to log in
	 */
	public void fillEmail(String mail) {
		txtEmail.sendKeys(mail);
		btnLogIn.click();
	}

	/**
	 * Fills the password field and click on log in
	 * 
	 * @param pass the password for the registered email
	 */
	public void fillPassword(String pass) {
		findBy(PASSWORD_CSS).waitUntilVisible().sendKeys(pass);
	}

	/**
	 * Logs in a user registered in the page
	 * 
	 * @param email the email of the registered user
	 * @param pass the password for the respective email
	 */
	public void logIn(String email, String pass) {
		fillEmail(email);
		fillPassword(pass);
		btnLogIn.click();
	}

}
