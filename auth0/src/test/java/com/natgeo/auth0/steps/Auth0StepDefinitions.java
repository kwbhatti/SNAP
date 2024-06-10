package com.natgeo.auth0.steps;

import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import static org.junit.Assert.assertTrue;
import com.natgeo.auth0.scenarioSteps.Auth0APIScenarioSteps;
import com.natgeo.auth0.scenarioSteps.Auth0ScenarioSteps;
import com.natgeo.utilities.LoaderUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class Auth0StepDefinitions {

	@Steps
	Auth0APIScenarioSteps apiSteps;
	
	String jobName;

	@Steps
	Auth0ScenarioSteps exSteps;

	@Before
	public void setUp(Scenario scenario) throws Exception {
		LoaderUtil.getInstance().intilizeValues();
		LoaderUtil.getInstance().startSaucelabs(exSteps.getDriver(), scenario);
		jobName = scenario.getName();
	}

	@After
	public void tearDown(Scenario scenario) throws Exception {
		LoaderUtil.getInstance().stopSauceLabs(scenario);
	}
	
	@When("^I send a ([^\"]*) service request with default header to ([^\"]*) and body ([^\"]*)$")
	public void sendRequest(String operationType, String restUrl, String data) {
		apiSteps.SendServiceRequest(restUrl, operationType, data);
	}
	
	@Then("^I will receive HTTP code ([^\"]*) as service response$")
	public void assertResponse(String codeValue) {
		Auth0APIScenarioSteps.response.then().statusCode(Integer.valueOf(codeValue));
	}

	@Given("^I am on the page \"([^\"]*)\"$")
	public void i_am_on_the_page(String page) throws Exception {
		exSteps.homePage().openPage(page);
	}

	@Given("^I open a browser to ([^\"]*)$")
	public void open_browser_to(String pageName) {
		String option = pageName;
		if (pageName.toUpperCase().equals("PLAYGROUND")) {
			exSteps.PlaygroundPage().openPlayground();
		}
	}

	@When("^I click on LogIn button$")
	public void clickOnLogIn() {
		exSteps.PlaygroundPage().clickOnLogIn();
	}

	@When("^I click on Join button$")
	public void clickOnJoin() {
		exSteps.PlaygroundLogIn().clickOnJoinNow();
	}

	@When("^I fill the chart with random information$")
	public void fillInformation() {
		String randomEmail = exSteps.PlaygroundRegistration().generateRandomProfile();
		String randomName = randomEmail.split("_")[0];
		exSteps.PlaygroundRegistration().fillInformation(randomName, "autombot", randomEmail, randomEmail,
				"Montevideo");
		Serenity.setSessionVariable("email").to(randomEmail);
		Serenity.setSessionVariable("password").to(randomEmail);
	}

	@Then("^I should see a confirmation page$")
	public void seeConfirmation() {
		assertTrue(exSteps.PlaygroundSucces().verifyRegistration());
	}

	@When("^I logIn with the recently created account$")
	public void logIn() {
		String email = Serenity.sessionVariableCalled("email").toString();
		String pass = Serenity.sessionVariableCalled("password").toString();
		exSteps.PlaygroundLogIn().logIn(email, pass);

	}

	@Then("^I should see the user page$")
	public void seeUserPage() {
		exSteps.PlaygroundUserInfo().verifyLogIn();
	}

	@When("^I login to profile service with admin credentials$")
	public void profileServiceLogin() {
		exSteps.ProfileServiceAdminLogIn().adminLogIn();
	}

	@When("^I click on the option ([^\\\"]*) in the model ([^\\\\\\\"]*) into the module ([^\\\\\\\"]*)$")
	public void clickOnOptionInModule(String option, String model, String module) {
		exSteps.ProfileServiceMain().selectModelInModule(model, module);
		option = option.toUpperCase();
		if (option.equals("CHANGE")) {
			exSteps.ProfileServiceMain().clickOnChangeInActualModel();
		} else if (option.equals("ADD")) {
			exSteps.ProfileServiceMain().clickOnAddInActualModel();
		}

	}

	@Then("^I verify ([^\\\"]*) profile is created$")
	public void profileVerify(String profile) {
		if (profile.equalsIgnoreCase("the recently created")) {
			exSteps.ProfileServiceProfiles().searchUser(Serenity.sessionVariableCalled("email").toString());
			assertTrue(exSteps.ProfileServiceProfiles().verifyFirstEmail(Serenity.sessionVariableCalled("email").toString()));
		} else {
			exSteps.ProfileServiceProfiles().searchUser(profile);
			assertTrue(exSteps.ProfileServiceProfiles().verifyFirstEmail(profile));
		}
	}

	@When("^I click on ([^\\\"]*) profile$")
	public void profileClick(String profile) {
		if (profile.equalsIgnoreCase("the recently created")) {
			exSteps.ProfileServiceProfiles().searchUser(Serenity.sessionVariableCalled("email").toString());
		} else {
			exSteps.ProfileServiceProfiles().searchUser(profile);
		}
		exSteps.ProfileServiceProfiles().clickOnFirstEmail();
	}

	@When("^I click on the first subscription")
	public void firstSubcriptionClick() {
		exSteps.ProfileServiceSubscriptions().clickOnFirstSubscripion();
	}

	@When("^I go to the home page")
	public void goToHomePage() {
		exSteps.homePage().goToHome();
	}

	@When("^I delete the profile I am watching")
	public void deleteProfile() {
		exSteps.ProfileServiceProfileInfoPage().deleteProfile();
	}

	@Then("^I verify ([^\\\"]*) profile is subscribed to vendor ([^\\\\\\\"]*)$")
	public void profileSubscriptionVerify(String profile, String vendor) {
		if (profile.equalsIgnoreCase("the recently created")) {
			assertTrue(exSteps.ProfileServiceSubscriptions().verfySubscription(Serenity.sessionVariableCalled("email").toString(),
					vendor));
		} else {
			assertTrue(exSteps.ProfileServiceSubscriptions().verfySubscription(profile, vendor));
		}
	}

	@When("^I check the inbox for the recently created profile and validate the account")
	public void validateAccount() throws Exception {
		exSteps.checkInbox();
	}

}
