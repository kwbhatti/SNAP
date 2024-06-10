package com.natgeo.chip_reference.api_components;

public class ContentPackageType {

	public String currentJsonPath;
	public String type;
	public String id;
	public String leadMediaUrl;
	public String leadMediaAspectRatio;
	public String leadMediaSrcset;
	public String title;
	public String showPlayButton;
	public String url;
	
	public ContentPackageType(String parentJsonPath) {
		currentJsonPath = parentJsonPath;
		initValues();
	}

	private void initValues() {
		type =  currentJsonPath + ".type";
		id = currentJsonPath + ".card.id";
		leadMediaUrl = currentJsonPath + ".card.leadMedia.url";
		leadMediaAspectRatio = currentJsonPath + ".card.leadMedia.aspectRatio";
		leadMediaSrcset = currentJsonPath + ".card.leadMedia.srcset";
		title = currentJsonPath + ".card.text.title";
		showPlayButton = currentJsonPath + ".card.config.showPlayButton";
		url =  currentJsonPath + ".card.link.url";
	}
	
	
	
}
