package com.natgeo.chip_reference.api_components;

public class TvGuidePreviewJsonPathMap {

	private String currentJsonPath;
	public String id;
	public String key;
	public String guideUrl;
	public String guideLabel;
	public String dateFormat;
	public String timestamp;
	public String channelsName;
	public String channelsRawChannelName;
	public String channelsTvShowsId;
	public String channelsTvShowsTitle;
	public String channelsTvShowsTime;
	public String componentId;
	public String version;
	
	public TvGuidePreviewJsonPathMap() {
		currentJsonPath = "regions.main.findAll {it.name == 'TVGuidePreview'}";
		initValues();
	}
	
	private void initValues() {
		id = currentJsonPath + ".id";
		key = currentJsonPath + ".key";
		guideUrl = currentJsonPath + ".data.config.guide.url";
		guideLabel = currentJsonPath + "data.config.guide.label";
		dateFormat = currentJsonPath + "data.config.dateFormat";
		timestamp = currentJsonPath + "data.timestamp";
		channelsName = currentJsonPath + "data.content.channels.name";
		channelsRawChannelName = currentJsonPath + "data.content.channels.rawChannelName";
		channelsTvShowsId = currentJsonPath + "data.content.channels.tvShows.id";
		channelsTvShowsTitle = currentJsonPath + "data.content.channels.tvShows.title";
		channelsTvShowsTime = currentJsonPath + "data.content.channels.tvShows.time";
		componentId = currentJsonPath + ".component_id";
		version = currentJsonPath + ".version";
	}

}
