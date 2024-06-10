package com.natgeo.cup.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CupReferencePreviewPage extends CupBasePage{

	private boolean flag = false;
	
	public CupReferencePreviewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(tagName = "img")
	private WebElementFacade editorsChoiceImage;
	
	@FindBy(css = "div.action-buttons button:nth-of-type(1)")
	private WebElementFacade continueEditingButton;
	
	@FindBy(css = "div.action-buttons button:nth-of-type(2)")
	private WebElementFacade saveButton;
	
	@FindBy(className = "tip-detail-title")
	private WebElementFacade tipTitle;
	
	@FindBy(className = "tip-detail-category")
	private WebElementFacade tipCategory;
	
	@FindBy(css = ".tip-detail-body p")
	private WebElementFacade tipDescription;

	public void waitForTitle() {
		try {	
			tipTitle.waitUntilVisible();	
		} catch (Exception e) {
			Assert.assertTrue("Unable to see the Title: ", false);
		}
	}
	
	public boolean validateTipDetails(String title, String category, String description) {
		try {
			waitForTitle();
			editorsChoiceImage.waitUntilVisible();
			String previewTitle = tipTitle.getText();
			String previewCategory = tipCategory.getText();
			String previewDescription = tipDescription.getText();
			
			if (title.equals(previewTitle) && category.equals(previewCategory) && description.equals(previewDescription)) {
				flag = true;
			}
			
			return flag;	
		} catch (Exception e) {
			Assert.assertTrue("The Tip Preview Details doesn't match with the ones you typed: " + e.getMessage(), flag);
			return flag;
		}
	}
}
