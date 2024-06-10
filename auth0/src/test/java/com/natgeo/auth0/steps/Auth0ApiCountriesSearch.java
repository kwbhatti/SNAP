package com.natgeo.auth0.steps;

import com.natgeo.auth0.scenarioSteps.Auth0APIScenarioSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;


public class Auth0ApiCountriesSearch {
	
   @Steps
   Auth0APIScenarioSteps countriesSearchSteps;
   
   @Then("^the returned JSON should contain the country \"([^\"]*)\"$")
   public void theReturnCountryShouldContain(String country) {
       countriesSearchSteps.iShouldFindCountry(country);
   }
}