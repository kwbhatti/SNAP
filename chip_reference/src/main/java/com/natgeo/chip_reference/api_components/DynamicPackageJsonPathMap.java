package com.natgeo.chip_reference.api_components;

public class DynamicPackageJsonPathMap {

	private String currentJsonPath;
	public String id;
	public String key;
	public String theme;
	public String cardAspectRatio;
	public String timestamp;
	public ContentPackageType card;
	public String title;
	
	public DynamicPackageJsonPathMap() {
		currentJsonPath = "regions.main.findAll {it.name == 'DynamicPackage'}";
		initValues();
	}
	
	private void initValues() {
		id = this.currentJsonPath + ".id";
		key = this.currentJsonPath + ".key";
		title = currentJsonPath + ".data.config.title";
		theme = this.currentJsonPath + ".data.config.theme";
		cardAspectRatio = currentJsonPath + ".data.config.cardsConfig.cardAspectRatio";
		timestamp = currentJsonPath + "data.timestamp";
		card = new ContentPackageType(currentJsonPath + ".data.content.cards");
		
	}

}
