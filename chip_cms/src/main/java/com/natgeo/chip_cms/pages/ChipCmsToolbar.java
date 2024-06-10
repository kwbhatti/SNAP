package com.natgeo.chip_cms.pages;

import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ChipCmsToolbar extends PageObject {
	
	public ChipCmsToolbar(WebDriver driver) {
	    super(driver);
	}

	@FindBy(id="toolbar-link-system-admin_content")
	private WebElementFacade contentTab;
	 
	public void clickContentTab() {
		contentTab.click();
	}

}
