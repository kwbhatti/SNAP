package com.natgeo.aemcore.scenarioSteps;

import com.natgeo.aemcore.pages.BasePage;
import com.natgeo.aemcore.pages.HomePage;
import static org.hamcrest.MatcherAssert.assertThat;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class AEMCoreScenarioSteps extends ScenarioSteps {

	private static final long serialVersionUID = 6633250639653098564L;

	HomePage homePage;
	BasePage aemCoreBasePage;


	public AEMCoreScenarioSteps(Pages pages) {
		super(pages);
	}

	@Step
	public HomePage homePage() {
		return homePage;
	}
	
}
