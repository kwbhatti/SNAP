package com.natgeo.chip_reference.api_components;

public class AdManagerJsonPathMap {
	public String adManagerJsonPath;
	public String id;
	public String key;
	public String provider;
	public String boxStyle;
	public String timestamp;
	public String componentId;
	public String name;
	public String version;
	public String contentMapper;
	public String adProviderDimensions;
	
	public AdManagerJsonPathMap() {
		adManagerJsonPath = "regions.main.findAll {it.name == 'AdManager'}";
		initValues();
	}
	
	private void initValues() {
		id = adManagerJsonPath + ".id";
		key = adManagerJsonPath + ".key";
		provider = adManagerJsonPath + ".data.config.provider";
		boxStyle = adManagerJsonPath + ".data.config.boxStyle";
		timestamp = adManagerJsonPath + "data.timestamp";
		componentId = adManagerJsonPath + ".component_id";
		name = adManagerJsonPath + ".name";
		version = adManagerJsonPath + ".version";
		contentMapper = adManagerJsonPath + ".content_mapper";
		adProviderDimensions = adManagerJsonPath + ".data.config.adProviderConfig.dimensions";
	}
}

