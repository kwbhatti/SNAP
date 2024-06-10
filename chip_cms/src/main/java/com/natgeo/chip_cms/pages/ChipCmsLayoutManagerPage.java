package com.natgeo.chip_cms.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ChipCmsLayoutManagerPage extends PageObject {
	
	public ChipCmsLayoutManagerPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(className="chip_layout_manager")
	private WebElementFacade layoutManagerBlock;
	
	/*Element For layout manager Chip tool bar*/
	@FindBy(className="ngp-chip-toolbar__nav-wrapper")
	private WebElementFacade layoutToolBar;
	
	/*Element for save buttonon layout manager*/
//	@FindBy(className="sc-iRbamj bFUyVF")
	@FindBy(className="menu")
	private WebElementFacade layoutSaveButton;
	
	/*Element for paragraph on layout manager*/
	@FindBy(className="chip_editor__paragraph")
	private WebElementFacade layoutManagerParagraph;
	
	/*Element for plus button on layout manager*/
	@FindBy(className="plus")
	private WebElementFacade addButton;
	
	/*Element for dialog box on layout manager*/
	@FindBy(className="react-draggable")
	private WebElementFacade dialogBox;
	
	/*Element for component lists in dialog box on layout manager*/
	@FindBy(className="components-list")
	private WebElementFacade componentslist;
	
	/*Element for image dialog box on layout manager*/
	@FindBy(className="item")
	private WebElementFacade imagedialogBox;
	
	/*Element for adding image on layout manager*/
	@FindBy(className="_27Ma9")
	private WebElementFacade imageadded;
	
	
	/*Layout Manager landing page display*/
	public void isDisplayed() {		
		boolean isDisplayed = false;
		try {
			isDisplayed = layoutManagerBlock.isDisplayed();
		}catch (Exception e) {
			isDisplayed = false;
		}
		Assert.assertTrue("Layout Manager page is not displayed", isDisplayed);
	}
	
	
	/*Display of Paragraph on Layout Manager */
	public void isParagraphDisplayed() {		
		boolean isDisplayed = false;
		try {
			isDisplayed = layoutManagerParagraph.isDisplayed();
		}catch (Exception e) {
			isDisplayed = false;
		}
		Assert.assertTrue("Layout Manager Paragraph is not displayed", isDisplayed);
	}
	
	/*Editing of Paragraph by a click on paragraph Text Area*/
	public void clicksOnLayoutManagerParagraph() {
		try {
			layoutManagerParagraph.click();
		}catch (Exception e) {
			Assert.assertTrue("layout Manager Paragraph is not clickable", false);
		}
	}
	
	/*Display of Plus Button on Layout Manager page*/
        public void isAddButtonDisplayed() {
		boolean isDisplayed = false;
		try {
			isDisplayed = addButton.isDisplayed();
		}catch (Exception e) {
			isDisplayed = false;
		}
		Assert.assertTrue("Add button is not displayed at Layout Manager Paragraph", isDisplayed);
	}

        /*Enabling Dialog box by clicking on Plus button*/
		public void clicksOnplusButton() {
			try {
				addButton.click();
			}catch (Exception e) {
				Assert.assertTrue("plus button is not clickable", false);
			}
		}
		
		/*Display of dialog Box on Layout Manager page*/	
		public void isDialogBoxDisplayed() {		
			boolean isDisplayed = false;
			try {
				isDisplayed = dialogBox.isDisplayed();
			}catch (Exception e) {
				isDisplayed = false;
			}
			Assert.assertTrue("Dialog Box is not displayed", isDisplayed);
		}
		
		/*Display of component lists in dialog box on Layout Manager page*/
		public void isComponentlistDisplayed() {		
			boolean isDisplayed = false;
			try {
				isDisplayed = componentslist.isDisplayed();
			}catch (Exception e) {
				isDisplayed = false;
			}
			Assert.assertTrue("components list is not displayed", isDisplayed);
		}

		/*Adding Image between paragraphs by clicking on Image component in dialog box*/
		public void clicksOnImageBox() {
			try {
				imagedialogBox.click();
			}catch (Exception e) {
				Assert.assertTrue("image box is not clickable", false);
			}
		}
		
		/*Validation of Image added between paragraphs successfully*/
		public void isImageAdded() {		
			boolean isDisplayed = false;
			try {
				isDisplayed = imageadded.isDisplayed();
			}catch (Exception e) {
				isDisplayed = false;
			}
			Assert.assertTrue("Image is not added", isDisplayed);
		}

		/*Layout Manager chip tool bar validation*/
		public void clicksOnLayoutToolBar() {
			boolean isDisplayed = false;
			try {
				isDisplayed = layoutToolBar.isDisplayed();
			}catch (Exception e) {
				isDisplayed = false;
			}
			Assert.assertTrue("Layout Tool Bar is not displayed", isDisplayed);
			
		}
		
		/*Layout Manager Save Button validation*/
		public void isSaveButtonDisplayed() {
			boolean isDisplayed = false;
			try {
				isDisplayed = layoutSaveButton.isDisplayed();
			}catch (Exception e) {
				isDisplayed = false;
			}
			Assert.assertTrue("Layout Save Button is not displayed", isDisplayed);
			
		}

}


