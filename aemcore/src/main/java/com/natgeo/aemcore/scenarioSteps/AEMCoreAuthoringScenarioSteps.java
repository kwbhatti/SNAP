package com.natgeo.aemcore.scenarioSteps;

import cucumber.api.java.en.When;
import static org.apache.commons.text.CharacterPredicates.DIGITS;
import static org.apache.commons.text.CharacterPredicates.LETTERS;

import java.io.Console;
import java.util.ArrayList;

import org.apache.commons.text.RandomStringGenerator;
import org.apache.tools.ant.taskdefs.WaitFor;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natgeo.aemcore.pages.AuthHomePage;
import com.natgeo.aemcore.pages.AuthLoginPage;
import com.natgeo.aemcore.pages.dialogs.CreatePageDlg;
import com.natgeo.aemcore.pages.CQ5Page;
import com.natgeo.utilities.WindowsHandlerUtil;
import com.natgeo.utilities.ScrollUtil;
import com.natgeo.utilities.TableUtil;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class AEMCoreAuthoringScenarioSteps extends ScenarioSteps {

	private static final long serialVersionUID = 6633250639653098564L;
	private static final Logger LOGGER = LoggerFactory.getLogger(AEMCoreAuthoringScenarioSteps.class);

	AuthLoginPage loginPage;
	AuthHomePage aemAuthPage;
	CreatePageDlg createpagedlg;
	CQ5Page cq5Page;

	public AEMCoreAuthoringScenarioSteps(Pages pages) {
		super(pages);
	}

	@Step("Create new authoring page")
	public String createPageWithRandomTitle(String pagename, String templatename) {
		String strTitle = "Serenity Test Title - XXX";

		RandomStringGenerator generator = new RandomStringGenerator.Builder()
		        .withinRange('0', 'Z')
		        .filteredBy(LETTERS, DIGITS)
		        .build();
		String rndChars = generator.generate(10);
		strTitle = strTitle.replace("XXX", rndChars);

		aemAuthPage.clickNewPageBtn();
		

		createpagedlg.titleinput().waitUntilPresent().type(strTitle);
		createpagedlg.nameinput().type(pagename);
		createpagedlg.choosetemplate(templatename);
	    createpagedlg.createbutton().click();
		
		return strTitle;
	}

	@Step("AEM Authoring Page login")
	public void login(String userName, String passwd) {
		loginPage.userlogin.type(userName);
		 loginPage.userpassword.type(passwd);
		loginPage.submitbutton.click();
	}

	@Step("Navigate tree")
	public void navigateTree(String path) {
		aemAuthPage.selectTreePath(path);
	}

	@Step("Goto URL and maximize browser")
	public void openURLandMaximizeBrowser(String url) {
		loginPage.openUrl(url);
		loginPage.maximizeBrowser();
	}

	@Step("Verify page title")
	public void verifyPage(String title) {
		aemAuthPage.verifytitle(title);
	}

	@Step("Sort Modified Header")
	public void checkmodifiedheader(String templatetype) {
		aemAuthPage.sortmodifiedheader(""); 
	}
	
	@Step("Check Template Created")
	public void checktemplatecreated(String templatetype) {
		aemAuthPage.checktemplateexists(templatetype); 
	}
	 

	@Step("Open Up Click First Row")
	public void doubleClickFirst() {
        aemAuthPage.doubleClickFirstrow();
	}
	
	@Step("Open Up Click Last Row")
	public void doubleClickLast() {
        aemAuthPage.doubleClickLastrow();
	}
	
	@Step("Components are Visible")
	public void componentsCheck() {

		createpagedlg.componentcheck();

	}

}
