package com.natgeo.chip_cms.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import com.natgeo.chip_cms.common.ContentFieldType;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/admin/structure/types")
public class ChipCmsContentTypesPage extends PageObject {

	public ChipCmsContentTypesPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[@href='/admin/structure/types/add']")
	private WebElementFacade addContentTypeButton;
	
	@FindBys(value = {@FindBy(className = "menu-label")})
	private List<WebElementFacade> contentTypesList;
	
	private String testContentName = "TestContent";

	public void createContentType(String contentTypeName) {
		addContentTypeButton.click();
		ChipCmsAddContentTypePage addContentTypePage = new ChipCmsAddContentTypePage(getDriver());
		addContentTypePage.createContentType(contentTypeName);
		setDriver(addContentTypePage.getDriver());
	}

	public boolean testContentTypeExists() {
		if (contentTypesList.size() > 0) {
			for(WebElementFacade item : contentTypesList){
				if (item.getText().contains(testContentName))
					return true;	
			}
		}
		return false;
	}

	public void createTestContentType() {
		createContentType(testContentName);
	}
	
	public void addTaxonomyFieldsToTestContentType() {
		ContentTypeOperations testContent = new ContentTypeOperations(getDriver());
		testContent.selectContentType(testContentName);
		testContent.goToManageFields();
		ChipCmsManageFieldsPage manageFieldsPage = new ChipCmsManageFieldsPage(testContent.getDriver());
		manageFieldsPage.createField(ContentFieldType.TAXONOMY_API_REFERENCE, "Subjects");
	}
	
}
