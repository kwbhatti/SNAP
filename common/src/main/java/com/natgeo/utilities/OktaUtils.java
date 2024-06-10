package com.natgeo.utilities;

import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class OktaUtils extends PageObject {

	@FindBy(id="okta-signin-username")
    private WebElementFacade oktaUserName;
	
	@FindBy(id="okta-signin-password")
    private WebElementFacade oktaUserPass;
	
	@FindBy(id="okta-signin-submit")
    private WebElementFacade oktaSubmitButton;
	
	@FindBy(name="answer")
    private WebElementFacade oktaCodeField;

	public OktaUtils(WebDriver driver) {
		super(driver);
	}

	public void login(String user, String pwd, String oktaToken) {
		String oktaCode="";
		oktaUserName.sendKeys(user);
		oktaUserPass.sendKeys(pwd);
		oktaSubmitButton.click();
		Totp generator = new Totp(oktaToken);
		oktaCode = generator.now();
		oktaCodeField.waitUntilClickable();
		oktaCodeField.sendKeys(oktaCode);
		oktaCodeField.sendKeys(Keys.ENTER);
	}
	
}
