package com.natgeo.chip_cms.pages;

import org.openqa.selenium.WebDriver;
import com.natgeo.chip_cms.common.UserCredentials;
import com.natgeo.chip_cms.common.UserType;
import com.natgeo.utilities.OktaUtils;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/user/login")
public class ChipCmsLoginPage extends PageObject{
	
	public ChipCmsLoginPage(WebDriver driver) {
		super(driver);
	}
	
	UserCredentials credentials;
	
    @FindBy(id="edit-name")
    private WebElementFacade usernameInput;

    @FindBy(id="edit-pass")
    private WebElementFacade passwordInput;
    
    @FindBy(id="edit-submit")
    private WebElementFacade loginButton;
    
    public ChipCmsContentPage loginWith(UserType userType) {
    		credentials = new UserCredentials(userType);
    		if (getDriver().getCurrentUrl().contains("okta")) {
    			OktaUtils okta = new OktaUtils(getDriver());
    			okta.login(credentials.user, credentials.pass, credentials.token);
    		} else {
        		localDrupalLogin();
    		}
    		return new ChipCmsContentPage(getDriver());
    }

	public void waitUntilNotVisible() {
		usernameInput.waitUntilNotVisible();
	}
	
	private void localDrupalLogin() {
		usernameInput.waitUntilClickable();
		usernameInput.sendKeys(credentials.user);
		passwordInput.sendKeys(credentials.pass);
		loginButton.click();
	}
	
    
}