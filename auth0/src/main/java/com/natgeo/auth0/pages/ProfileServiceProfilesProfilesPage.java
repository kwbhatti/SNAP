package com.natgeo.auth0.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.natgeo.common.NatGeoBasePage;
import com.natgeo.utilities.*;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProfileServiceProfilesProfilesPage extends NatGeoBasePage {
	TableUtil profilesEmailTable = new TableUtil("//thead/tr/th", "//tbody/tr[%s]/th[%s]");
	TableUtil profilesInfoTable = new TableUtil("//thead/tr/th", "//tbody/tr[%s]/td[%s]");
	@FindBy(id = "searchbar")
	private WebElementFacade searchBar;
	@FindBy(id = "site-name")
	private WebElementFacade btnHome;

	public ProfileServiceProfilesProfilesPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Fill the Search field with the given name and click on search
	 * 
	 * @param name the name to search
	 */
	public void searchUser(String name) {
		searchBar.clear();
		searchBar.sendKeys(name);
		searchBar.sendKeys(Keys.ENTER);
	}

	/**
	 * Return true if the first email of the list is the same I'm looking for
	 * 
	 * @param email the email I want to verify
	 */
	public boolean verifyFirstEmail(String email) {
		return (profilesEmailTable.GetCellText(this, "EMAIL", "1").equals(email));
	}

	/**
	 * Clicks on the first email of the list
	 */
	public void clickOnFirstEmail() {
		profilesEmailTable.GetCellElement(this, "EMAIL", "1").click();
	}

}
