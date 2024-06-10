package com.natgeo.chip_reference.api_components;

public class ContentPackageJsonPathMap {

	public String currentJsonPath;
	public String id;
	public String key;
	public String componentId;
	public String version;
	public String isHighHero;
	public String theme;
	public String header;
	public String leadContentAspectRatio;
	public String mediumContentAspectRatio;
	public String smallContentAspectRatio;
	public String timestamp;
	public ContentPackageType smallContent;
	public ContentPackageType leadContent;
	public ContentPackageType mediumContent;
	
	public ContentPackageJsonPathMap() {
		currentJsonPath = "regions.main.findAll {it.name == 'ContentPackage'}";
		initValues();
	}
	private void initValues() {
		id = currentJsonPath + ".id";
		key = currentJsonPath + ".key";
		isHighHero = currentJsonPath + ".data.config.isHighHero";
		theme = currentJsonPath + "data.config.theme";
		header = currentJsonPath + "data.config.packageHeader";
		leadContentAspectRatio = currentJsonPath + "data.config.leadContent.promoCardConfig.cardAspectRatio";
		mediumContentAspectRatio = currentJsonPath + "data.config.mediumContent.promoCardConfig.cardAspectRatio";
		smallContentAspectRatio = currentJsonPath + "data.config.smallContent.promoCardConfig.cardAspectRatio";
		timestamp = currentJsonPath + "data.timestamp";
		smallContent = new ContentPackageType ("regions.main.findAll {it.name == 'ContentPackage'}data.content.smallContent");
		leadContent = new ContentPackageType("regions.main.findAll {it.name == 'ContentPackage'}data.content.leadContent");
		mediumContent = new ContentPackageType("regions.main.findAll {it.name == 'ContentPackage'}data.content.mediumContent");
		
		
		componentId = currentJsonPath + ".component_id";
		version = currentJsonPath + ".version";
	}
}
