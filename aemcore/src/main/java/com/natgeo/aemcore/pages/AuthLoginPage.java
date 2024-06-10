package com.natgeo.aemcore.pages;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class AuthLoginPage extends BasePage {
	private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

	public AuthLoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "#username")
	public WebElementFacade userlogin;

	@FindBy(css = "#password")
	public WebElementFacade userpassword;

	@FindBy(css = "#submit-button")
	public WebElementFacade submitbutton;
	
}