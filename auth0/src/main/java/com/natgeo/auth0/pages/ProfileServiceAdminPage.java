package com.natgeo.auth0.pages;

import org.openqa.selenium.WebDriver;

import com.natgeo.common.NatGeoBasePage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProfileServiceAdminPage extends NatGeoBasePage {

	@FindBy(id = "content-main")
	private WebElementFacade modulesContainer;
	@FindBy(id = "site-name")
	private WebElementFacade btnHome;

	private WebElementFacade actualModel = null;

	public ProfileServiceAdminPage(WebDriver driver) {
		super(driver);
	}

	public WebElementFacade selectModule(String name) {
		String module = ".app-" + name.toLowerCase();
		return modulesContainer.findBy(module);
	}

	/**
	 * Return the WebElement of the row with the model name in the given module
	 * 
	 * @param model the name of the model I'm looking for
	 * @param module the name of the module where the model is located
	 * @return the entire row with the title and the buttons
	 */
	public WebElementFacade selectModelInModule(String model, String module) {
		model = model.toLowerCase();
		if (model.equals("profiles")) {
			model = "profile";
		}
		if (model.equals("subscriptions")) {
			model = "subscription";
		}
		String modelCss = ".model-" + model;
		actualModel = selectModule(module).findBy(modelCss);
		return selectModule(module).findBy(modelCss);
	}

	/**
	 * Clicks on the change button in the selected row
	 */
	public void clickOnChangeInActualModel() {
		actualModel.findBy(".changelink").click();
	}

	/**
	 * Clicks on the add button in the selected row
	 */
	public void clickOnAddInActualModel() {
		actualModel.findBy(".addlink").click();
	}

}
