package com.natgeo.auth0.scenarioSteps;

import com.natgeo.auth0.api_components.MailinatorApi;
import com.natgeo.auth0.pages.*;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class Auth0ScenarioSteps extends ScenarioSteps {

	private static final long serialVersionUID = -4516669837018702273L;

	PlaygroundMainPage playgroundPage;
	PlaygroundLogInPage playgroundLogIn;
	PlaygroundRegistrationPage playgroundRegistration;
	PlaygroundSuccessfulRegistrationPage playgroundSucces;
	PlaygroundUserInfoPage playgroundUserInfo;
	ProfileServiceAdminLogInPage profileServiceAdminLogIn;
	ProfileServiceAdminPage profileSreviceMainPage;
	ProfileServiceProfilesProfilesPage profileSreviceProfilesPage;
	ProfileServiceSubscriptionsPage profileSreviceSubsPage;
	ProfileServiceProfileInfoPage profileServiceProfileInfoPage;
	HomePage homePage;
	ProfilesServiceBasePage profileServicesBasePage;

	public Auth0ScenarioSteps(Pages pages) {
		super(pages);
	}

	@Step
	public HomePage homePage() {
		return homePage;
	}
	
	@Step
	public PlaygroundMainPage PlaygroundPage() {
		return playgroundPage;
	}

	@Step
	public PlaygroundLogInPage PlaygroundLogIn() {
		return playgroundLogIn;
	}

	@Step
	public PlaygroundRegistrationPage PlaygroundRegistration() {
		return playgroundRegistration;
	}

	@Step
	public PlaygroundSuccessfulRegistrationPage PlaygroundSucces() {
		return playgroundSucces;
	}

	@Step
	public PlaygroundUserInfoPage PlaygroundUserInfo() {
		return playgroundUserInfo;
	}

	@Step
	public ProfileServiceAdminLogInPage ProfileServiceAdminLogIn() {
		return profileServiceAdminLogIn;
	}

	@Step
	public ProfileServiceAdminPage ProfileServiceMain() {
		return profileSreviceMainPage;
	}

	@Step
	public ProfileServiceProfilesProfilesPage ProfileServiceProfiles() {
		return profileSreviceProfilesPage;
	}

	@Step
	public ProfileServiceSubscriptionsPage ProfileServiceSubscriptions() {
		return profileSreviceSubsPage;
	}

	@Step
	public ProfileServiceProfileInfoPage ProfileServiceProfileInfoPage() {
		return profileServiceProfileInfoPage;
	}

	@Step
	public void checkInbox() throws Exception {
		getDriver().get(MailinatorApi.getInstance().GetEmailLink(Serenity.sessionVariableCalled("email").toString()));
	}
}
