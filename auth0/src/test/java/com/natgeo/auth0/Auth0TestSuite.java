package com.natgeo.auth0;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"junit:target/test-report/cucumber.xml","pretty"},
        features = "src/test/resources/com/natgeo/auth0/"
)


public class Auth0TestSuite {

}
