package com.natgeo.auth0.pages;

import org.openqa.selenium.WebDriver;

import com.natgeo.common.NatGeoBasePage;
import com.natgeo.utilities.LoaderUtil;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class PlaygroundMainPage extends NatGeoBasePage {

	@FindBy(css = ".btn-primary")
	public WebElementFacade btnLogIn;

	public PlaygroundMainPage(WebDriver driver) {
		super(driver);
	}

	public void openPlayground() {
		openUrl(LoaderUtil.getInstance().playgroundUrl);
	}

	/**
	 * Clicks on login button
	 */
	public void clickOnLogIn() {
		btnLogIn.click();
	}

}
