package com.natgeo.examples.scenarioSteps;

import com.natgeo.examples.pages.ExampleBasePage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;


public class ExampleScenarioSteps extends ScenarioSteps {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4516669837018702273L;

	ExampleBasePage basePage;

   
	public ExampleScenarioSteps(Pages pages) {
		super(pages);
	}
	
	@Step
	public ExampleBasePage ExampleBasePage() {
		return basePage;
	}
	
	
}


