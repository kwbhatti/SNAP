package com.natgeo.cup.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CupReferenceViewAllTipsPage extends CupBasePage{

	public CupReferenceViewAllTipsPage(WebDriver driver) {
		super(driver);
	}
	
	private String tipTitle;
	private boolean flag = false;
	
	@FindBy(css = ".tip-card-title")
	private List<WebElementFacade> tipsTitle;

	@FindBy(css = ".tip-card.landscape:nth-of-type(1)")
	public WebElementFacade firstTip;
	
	public boolean compareTipsTitle(String title) {
		try {
			firstTip.waitUntilVisible();
			for (WebElementFacade element : tipsTitle) {
				tipTitle = element.getText();
				if (tipTitle.equals(title)) {
					flag = true;
					break;
				}	
			}		
			return flag;	
		} catch (Exception e) {
			Assert.assertTrue("There are no matches with your Title: ", false);
			return flag;
		}
	}
}
