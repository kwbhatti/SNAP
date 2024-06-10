package com.natgeo.cup.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CupMemberCenterPage extends CupBasePage {

	public CupMemberCenterPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "input#email")
	private WebElementFacade userId_field;

	@FindBy(css = "input#password")
	private WebElementFacade password_field;

	@FindBy(css = "button.button-login")
	private WebElementFacade logInButton;

	@FindBy(css = "a.gn_logo-container.gn_logo-container--inline")
	private WebElementFacade natgeoLogo;
	
	@FindBy(className = "gn_userbox-name")
	private WebElementFacade userName_loggedIn;
	
	@FindBy(className = "gn_userbox-button")
	private WebElementFacade useroptionsDropdown;
	
	@FindBy(css = "a[href*='logout']")
	private WebElementFacade logOutButton;

	public boolean login(String userName, String pass) {
		try {
			typeInElement(userId_field, userName);
			typeInElement(password_field, pass);
			logInButton.click();
			return true;
		} catch (Exception e) {
			Assert.assertTrue("Unable to login ", false);
			return false;
		}
	}
	
	public void memberLogin(String userName, String password) {
		try {
			typeInElement(userId_field, userName);
			typeInElement(password_field, password);
			logInButton.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			Assert.assertTrue("Unable to login ", false);
		}
	}
	
	public boolean seeNatgeoLogo() {
		try {
			natgeoLogo.waitUntilVisible();
			return natgeoLogo.isDisplayed();
		} catch (Exception e) {
			Assert.assertTrue("Unable to see the Natgeo Logo: ", false);
			return natgeoLogo.isDisplayed();
		}
	}
	
	public void logOutFromStaging() {
		try {
			userName_loggedIn.waitUntilClickable();
			waitForVisibleAndClick(useroptionsDropdown);
			waitForVisibleAndClick(logOutButton);
		} catch (Exception e) {
			Assert.assertTrue("Unable to Log Out of Member Center Staging ", false);
		}
	}
	
	public boolean validateLogOutFromStaging() {
		try {
			userId_field.waitUntilVisible();
			return userId_field.isCurrentlyVisible();
		} catch (Exception e) {
			Assert.assertTrue("Unable to see the content of the Login Page: ", false);
			return userId_field.isCurrentlyVisible();
		}
	}
	
	public void waitForLogoToBeVisible() {
		try {
			natgeoLogo.waitUntilVisible();
		} catch (Exception e) {
			Assert.assertTrue("Unable to see the Logo: ", false);
		}
	}
}
