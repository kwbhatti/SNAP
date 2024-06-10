package com.natgeo.cup.scenarioSteps;

import com.natgeo.cup.pages.CupReferenceContentDetails;
import com.natgeo.cup.pages.CupReferenceCreateUGCPage;
import com.natgeo.cup.pages.CupReferencePreviewPage;

import net.thucydides.core.annotations.Step;

public class CupReferenceCreateContentSteps {
	
	CupReferenceCreateUGCPage referenceCreateUGC;
	CupReferenceContentDetails referenceDetails;
	CupReferencePreviewPage referencePreview;
	
	@Step("Update UGC Content")
	public void updateContent(String title, String subtitle, String category, String description) {
		referenceCreateUGC.updateContentDetails(title, subtitle, category, description);
	}
	
	@Step("Click on Publish")
	public void clickOnPublishUgc() {
		referenceCreateUGC.publishUGC();
		//referenceDetails.waitForTitle();
	}
	
	@Step("Click on Preview")
	public void clickOnPreviewUgc() {
		referenceCreateUGC.previewUgc();
		referencePreview.waitForTitle();
	}
	
	@Step("Create Tip")
	public void createTip(String title, String category, String description) {
		referenceCreateUGC.fillTipDetails(title, category, description);
	}
	
	@Step("Create Photo")
	public void createPhoto(String title, String category, String caption) {
		referenceCreateUGC.fillPhotoDetails(title, category, caption);
	}
	
	@Step("Create Story")
	public void createStory(String title, String subTitle, String category, String description) {
		referenceCreateUGC.fillStoryDetails(title, subTitle, category, description);
	}
	
	@Step("Select an Image by name")
	public void searchImageByName(String category) {
		referenceCreateUGC.selectImageByName(category);
	}
	
	@Step("Check for Tip Preview Content")
	public void checkTipPreviewDetails(String title, String category, String description) {
		referencePreview.validateTipDetails(title, category, description);
	}
}
