package com.natgeo.cup.scenarioSteps;

import static org.junit.Assert.assertTrue;
import com.natgeo.cup.pages.CupMemberCenterPage;
import net.thucydides.core.annotations.Step;

public class CupLoginSteps {

	public String user = "alberto.copado+2@wizeline.com";
	public String password = "Manager@1995";
	
	CupMemberCenterPage loginPage;

	@Step("Open Member Center Staging")
	public void openMemberCenterStaging() {
		loginPage.openUrl("https://members-staging.nationalgeographic.com/settings/public-profile/");
	}

	@Step("Member Center Staging Login")
	public void logInStaging() {
		assertTrue("Not able to execute login method successfully", loginPage.login(user, password));
		loginPage.waitForLogoToBeVisible();
	}
	
	@Step("Member Center Staging Login")
	public void logInMemberStaging(String userName, String password) {
		loginPage.memberLogin(userName, password);
		loginPage.waitForLogoToBeVisible();
	}
	
	@Step("Validate that I am logged in")
	public void loggedInToMemberStaging() {
		loginPage.seeNatgeoLogo();
	}
	
	@Step("Click Log Out From Member Center Staging")
	public void logOut() {
		loginPage.logOutFromStaging();
	}
	
	@Step("Validate Member Center Log Out")
	public void logOutValidation() {
		loginPage.validateLogOutFromStaging();
	}
	
	@Step("Member Center Login")
	public void logIn() {
		assertTrue("Not able to execute login method successfully", loginPage.login(user, password));
	}
}
