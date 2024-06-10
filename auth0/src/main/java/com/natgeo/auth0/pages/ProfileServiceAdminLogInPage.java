package com.natgeo.auth0.pages;

import org.openqa.selenium.WebDriver;

import com.natgeo.common.NatGeoBasePage;
import com.natgeo.utilities.LoaderUtil;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Login page for Profiles Service
 */
public class ProfileServiceAdminLogInPage extends NatGeoBasePage {

	@FindBy(id = "id_username")
	public WebElementFacade txtUsername;

	@FindBy(id = "id_password")
	public WebElementFacade txtPassword;

	@FindBy(css = "[type='submit']")
	public WebElementFacade btnLogIn;

	public ProfileServiceAdminLogInPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Fills the username and password fields and click on login
	 */
	public void adminLogIn() {
		txtUsername.sendKeys(LoaderUtil.getInstance().profilesServiceAdminUser);
		txtPassword.sendKeys(LoaderUtil.getInstance().profilesServiceAdminPass);
		btnLogIn.click();

	}

}
