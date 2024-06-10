package com.natgeo.aemcore.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.natgeo.aemcore.pages.AuthHomePage;
import com.natgeo.aemcore.pages.AuthLoginPage;
import com.natgeo.aemcore.pages.dialogs.CreatePageDlg;

import com.natgeo.aemcore.scenarioSteps.AEMCoreAuthoringScenarioSteps;
import com.natgeo.aemcore.scenarioSteps.AEMCoreScenarioSteps;
import com.natgeo.utilities.LoaderUtil;
import com.natgeo.aemcore.pages.CQ5Page;

import net.thucydides.core.annotations.Steps;

public class AEMAuthStepDefinitions {

	@Steps
	AEMCoreScenarioSteps coreSteps;

	@Steps
	AEMCoreAuthoringScenarioSteps authSteps;

	AuthLoginPage loginPage;
	AuthHomePage aemAuthPage;
	CreatePageDlg createpagedlg;
	CQ5Page cq5Page;
	String pagetitle;
	String pagename = "Name SerenityTest1";

	@When("^I write on input '(.*)' the value '(.*)'$")
	public void write_input_field(String field, String value) {
		// cq5Page.waitFor(10).seconds();
		cq5Page.write_input_field(field, value);
	}

	@When("^I click on New toolbar$")
	public void clickOnNewButton() {
		String input = "New...";
		cq5Page.click_on_button(input);
	}

	@When("^I click on '(.*)' button$")
	public void clickOnXButton(String name) {
		cq5Page.click_on_button(name);
	}

	@Given("^I log into the authoring site$")
	public void iLogIntoTheAuthoringSite() {

		authSteps.openURLandMaximizeBrowser("https://aem6-qa-auth.int.ngeo.com/siteadmin");
		authSteps.login(LoaderUtil.getInstance().cmsauthlogin, LoaderUtil.getInstance().cmsauthpassword);
		authSteps.navigateTree("Magazine@National Geographic Magazine@automation");
	}


	@When("^I create a new homepage with \"([^\"]*)\" template$")
	public void I_create_a_new_homepage_with_template(String templatename) {
		pagetitle = authSteps.createPageWithRandomTitle(pagename, templatename);
	}

	@Then("^I see page created with \"([^\"]*)\" template$")
	public void i_see_the_page_created(String templatetype) {
		//authSteps.checkmodifiedheader(""); 
		authSteps.checktemplatecreated(templatetype);
	}

	@When("^I open the new template created$")
	public void i_open_the_new_template_created() {
		authSteps.doubleClickLast();
	}

	@Then("^all the required components are available$")
	public void all_the_required_components_are_available() {
		authSteps.componentsCheck();
	}

}
