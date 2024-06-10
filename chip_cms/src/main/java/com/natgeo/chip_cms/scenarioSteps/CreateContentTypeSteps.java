package com.natgeo.chip_cms.scenarioSteps;

import org.openqa.selenium.WebDriver;
import com.natgeo.chip_cms.pages.ChipCmsAdminContentPage;
import com.natgeo.chip_cms.pages.ChipCmsContentTypesPage;
import net.thucydides.core.annotations.Step;

public class CreateContentTypeSteps {

	ChipCmsContentTypesPage contentTypesPage;
	ChipCmsAdminContentPage adminContentPage;
	private WebDriver currentDriver;
	
	@Step("Verify TestContent exists")
	public void createTestContentType() {
		contentTypesPage.open();
		currentDriver = contentTypesPage.getDriver();
		contentTypesPage = new ChipCmsContentTypesPage(currentDriver);
		if (!contentTypesPage.testContentTypeExists()) {
			contentTypesPage.createTestContentType();
			contentTypesPage.open();
			contentTypesPage.addTaxonomyFieldsToTestContentType();
		}
	}
	
	public void setDriver(WebDriver driver) {
		currentDriver = driver;
	}
	
}
 