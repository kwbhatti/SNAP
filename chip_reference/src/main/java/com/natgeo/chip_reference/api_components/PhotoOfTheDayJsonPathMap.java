package com.natgeo.chip_reference.api_components;

public class PhotoOfTheDayJsonPathMap {
	public String currentJsonPath;
	public String id;
	public String photoOfTheDayText;
	public String viewAllText;
	public String linkUrl;
	public String creditText;
	public String timestamp;
	public String photoTitle;
	public String photoCaption;
	public String photoAltText;
	public String photoUrl;
	public String photoCredit;
	public String photoSrcset;
	public String photoAspectRatio;
	public String componentId;
	public String version;
	public String key;
	
	public PhotoOfTheDayJsonPathMap() {
		currentJsonPath = "regions.main.findAll {it.name == 'PhotoOfTheDay'}";
		initValues();
	}
	private void initValues() {
		id = currentJsonPath + ".id";
		key = currentJsonPath + ".key";
		photoOfTheDayText = currentJsonPath + ".data.config.photoOfTheDayText";
		viewAllText = currentJsonPath + ".data.config.viewAllText";
		linkUrl = currentJsonPath + ".data.config.linkUrl";
		creditText = currentJsonPath + ".data.config.creditText";
		timestamp = currentJsonPath + ".data.timestamp";
		photoTitle = currentJsonPath + ".data.content.photo.title";
		photoCaption = currentJsonPath + ".data.content.photo.caption";
		photoAltText = currentJsonPath + ".data.content.photo.altText";
		photoUrl = currentJsonPath + ".data.content.photo.url";
		photoCredit = currentJsonPath + ".data.content.photo.credit";
		photoSrcset = currentJsonPath + ".data.content.photo.srcset";
		photoAspectRatio = currentJsonPath + ".data.content.photo.aspectRatio";
		componentId = currentJsonPath + ".component_id";
		version = currentJsonPath + ".version";
	}

}
