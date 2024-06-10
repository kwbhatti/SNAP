package com.natgeo.chip_cms.scenarioSteps;

import org.openqa.selenium.WebDriver;
import com.natgeo.chip_cms.common.UserType;
import com.natgeo.chip_cms.pages.ChipCmsLoginPage;
import net.thucydides.core.annotations.Step;

public class LoginSteps {
	
	ChipCmsLoginPage	 loginPage;
	@Step
	public WebDriver loginWith(String userString) {
		loginPage.open();
		UserType userType = null;
		if (userString.contains("Admin")) {
			userType = UserType.ADMIN;
		}else 
		if (userString.contains("Auth")) {
			userType = UserType.AUTHENTICATED;
		}
		loginPage.loginWith(userType);
		loginPage.waitUntilNotVisible();
		return loginPage.getDriver();
	}

}
