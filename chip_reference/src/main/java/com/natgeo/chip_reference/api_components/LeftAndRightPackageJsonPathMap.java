package com.natgeo.chip_reference.api_components;

public class LeftAndRightPackageJsonPathMap {
	public String currentJsonPath;
	public String id;
	public String key;
	public String componentId;
	public String version;
	public String configLeftHeader;
	public String configRightHeader;
	public String theme;
	public String header;
	public String articleItemsCardAspectRatio;
	public String mediumCardsCardAspectRatio;
	public String smallCardsCardAspectRatio;
	public String timestamp;
	public ContentPackageType articleItems;
	public ContentPackageType mediumCards;
	public ContentPackageType smallCards;
	
	public LeftAndRightPackageJsonPathMap() {
		currentJsonPath = "regions.main.findAll {it.name == 'LeftAndRightPackage'}";
		initValues();
	}
	private void initValues() {
		id = currentJsonPath + ".id";
		key = currentJsonPath + ".key";
		configLeftHeader = currentJsonPath + ".data.config.leftHeader";
		configRightHeader = currentJsonPath + ".data.config.rightHeader";
		theme = currentJsonPath + "data.config.theme";
		header = currentJsonPath + "data.config.packageHeader";
		articleItemsCardAspectRatio = currentJsonPath + "data.config.articleItems.promoCardConfig.cardAspectRatio";
		mediumCardsCardAspectRatio = currentJsonPath + "data.config.mediumCards.promoCardConfig.cardAspectRatio";
		smallCardsCardAspectRatio = currentJsonPath + "data.config.smallCards.promoCardConfig.cardAspectRatio";
		timestamp = currentJsonPath + "data.timestamp";
		articleItems = new ContentPackageType (currentJsonPath + ".data.content.articleItems");
		mediumCards = new ContentPackageType(currentJsonPath + "data.content.mediumCards");
		smallCards = new ContentPackageType(currentJsonPath + "data.content.smallCards");
		componentId = currentJsonPath + ".component_id";
		version = currentJsonPath + ".version";
	}

}

