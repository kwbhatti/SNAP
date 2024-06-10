package com.natgeo.auth0.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.natgeo.common.NatGeoBasePage;
import com.natgeo.utilities.TableUtil;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProfileServiceSubscriptionsPage extends NatGeoBasePage {

	TableUtil subscriptionsEmailTable = new TableUtil("//thead/tr/th", "//tbody/tr[%s]/th[%s]");
	TableUtil subscriptionsInfoTable = new TableUtil("//thead/tr/th", "//tbody/tr[%s]/td[%s]");
	private final int MAX_ATTEMPTS = 30;
	
	@FindBy(id = "searchbar")
	private WebElementFacade txtSearchBar;
	@FindBy(id = "site-name")
	private WebElementFacade btnHome;

	public ProfileServiceSubscriptionsPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Clear the search field and fill it with the name I'm looking for and click on search
	 * 
	 * @param name the name I'm looking  for
	 */
	public void searchSubscription(String name) {
		txtSearchBar.clear();
		txtSearchBar.sendKeys(name);
		txtSearchBar.sendKeys(Keys.ENTER);
	}

	/**
	 * Make click on the first subscription of the list
	 */
	public void clickOnFirstSubscripion() {
		subscriptionsEmailTable.GetCellElement(this, "PROFILE", "1").click();
	}

	/**
	 * Return true if the first subscription of the list is the same I'm looking for
	 * 
	 * @param profile the profile I want to verify
	 * @param vendor the name of the vendor to check the profile is subscribed to
	 */
	public boolean verfySubscription(String profile, String vendor) {
		String status = "";
		int i = 0;
		while(!status.equalsIgnoreCase("Subscribed") && i < MAX_ATTEMPTS) {
			searchSubscription(profile);
			status = subscriptionsInfoTable.GetCellText(this, "SYNC STATUS", "1");
			i++;
		}
		String actualVendor = subscriptionsInfoTable.GetCellText(this, "VENDOR", "1");
		return vendor.equals(actualVendor);

	}

}
