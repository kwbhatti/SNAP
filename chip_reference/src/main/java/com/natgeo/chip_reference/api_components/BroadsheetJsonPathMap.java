package com.natgeo.chip_reference.api_components;

public class BroadsheetJsonPathMap {

	public String currentJsonPath;
	public String id;
	public String key;
	public String configSubscriptionTitle;
	public String configSubscriptionSubTitle;
	public String configSubscriptionButtonLabel;
	public String configSubscriptionLinkUrl;
	public String configMagazineTitle;
	public String configMagazineIssueCreditText;
	public String timestamp;
	public String magazineIssueKickersName;
	public String magazineIssueTitle;
	public String magazineIssueImageTitle;
	public String magazineIssueImageCaption;
	public String magazineIssueImageAltText;
	public String magazineIssueImageUrl;
	public String magazineIssueImageCredit;
	public String magazineIssueImageSrcset;
	public String magazineIssueImageAspectRatio;
	public String magazineIssueCredit;
	public String magazineIssueAltBodiesId;
	public String magazineIssueAltBodiesContentType;
	public String magazineIssueAltBodiesHtmlContent;
	public String magazineCoverImageUrl;
	public String magazineCoverSrcset;
	public String magazineCoverAltText;
	public String magazineTableOfContentId;
	public String magazineTableOfContentTitle;
	public String magazineTableOfContentLinkUrl;
	public String componentId;
	public String version;
	
	public BroadsheetJsonPathMap() {
		currentJsonPath = "regions.main.findAll {it.name == 'Broadsheet'}";
		initValues();
	}
	
	private void initValues() {
		id = currentJsonPath + ".id";
		key = currentJsonPath + ".key";
		configSubscriptionTitle = currentJsonPath + ".data.config.subscription.title";
		configSubscriptionSubTitle = currentJsonPath + ".data.config.subscription.subtitle";
		configSubscriptionButtonLabel = currentJsonPath + ".data.config.subscription.buttonLabel";
		configSubscriptionLinkUrl = currentJsonPath + ".data.config.subscription.linkUrl";
		configMagazineTitle = currentJsonPath + ".data.config.magazine.title";
		configMagazineIssueCreditText = currentJsonPath + ".data.config.magazine.issue.creditText";
		timestamp = currentJsonPath + ".data.timestamp";
		magazineIssueKickersName = currentJsonPath + ".data.content.magazine.issue.kickers.name";
		magazineIssueTitle = currentJsonPath + ".data.content.magazine.issue.title" ;
		magazineIssueImageTitle = currentJsonPath + ".data.content.magazine.issue.image.title";
		magazineIssueImageCaption = currentJsonPath + ".data.content.magazine.issue.image.caption";
		magazineIssueImageAltText = currentJsonPath + ".data.content.magazine.issue.image.altText";
		magazineIssueImageUrl = currentJsonPath + ".data.content.magazine.issue.image.url";
		magazineIssueImageCredit = currentJsonPath + ".data.content.magazine.issue.image.credit";
		magazineIssueImageSrcset = currentJsonPath + ".data.content.magazine.issue.image.srcset";
		magazineIssueImageAspectRatio = currentJsonPath + ".data.content.magazine.issue.image.aspectRatio";
		magazineIssueCredit = currentJsonPath + ".data.content.magazine.issue.credit";
		magazineIssueAltBodiesId = currentJsonPath + ".data.content.magazine.issue.altBodies.id";
		magazineIssueAltBodiesContentType = currentJsonPath + ".data.content.magazine.issue.altBodies.contentType";
		magazineIssueAltBodiesHtmlContent = currentJsonPath + ".data.content.magazine.issue.altBodies.props.htmlContent";
		magazineCoverImageUrl = currentJsonPath + ".data.content.magazine.cover.imageUrl";
		magazineCoverSrcset = currentJsonPath + ".data.content.magazine.cover.srcset";
		magazineCoverAltText = currentJsonPath + ".data.content.magazine.cover.altText";
		magazineTableOfContentId = currentJsonPath + ".data.content.magazine.tableOfContent.entries.id";
		magazineTableOfContentTitle = currentJsonPath + ".data.content.magazine.tableOfContent.entries.title";;
		magazineTableOfContentLinkUrl = currentJsonPath + ".data.content.magazine.tableOfContent.entries.linkUrl";;
		componentId = currentJsonPath + ".component_id";
		version = currentJsonPath + ".version";
	}
	

}
