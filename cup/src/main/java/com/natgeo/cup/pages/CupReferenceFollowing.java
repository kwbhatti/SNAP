package com.natgeo.cup.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CupReferenceFollowing extends CupBasePage{

	public CupReferenceFollowing(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = ".follower-name")
	private WebElementFacade followingUserName;
	
	public void validateFollowingUser() {
		try {
						
		} catch (Exception e) {		
			Assert.assertTrue("Unable to find the user you are looking for under your Following List: ", false);
		}
	}

}
