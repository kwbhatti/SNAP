package com.natgeo.chip_reference.api_components;

public class VideoPlayListJsonPathMap {

	public String currentJsonPath;
	public String id;
	public String key;
	public String configHeading;
	public String configDurationFormat;
	public String timestamp;
	public String videosGuid;
	public String videosType;
	public String videosTitle;
	public String videosDuration;
	public String videosAbstract;
	public String videosPublishDate;
	public String videosThumbnail;
	public String videosDirectLink;
	public String videosAspectRatio;
	public String componentId;
	public String version;
	
	public VideoPlayListJsonPathMap() {
		currentJsonPath = "regions.main.findAll {it.name == 'VideoPlaylist'}";
		initValues();
	}
	
	private void initValues() {
		id = currentJsonPath + ".id";
		key = currentJsonPath + ".key";
		configHeading = currentJsonPath + ".data.config.heading";
		configDurationFormat = currentJsonPath + ".data.config.durationFormat";
		timestamp = currentJsonPath + ".data.timestamp";
		videosGuid = currentJsonPath + ".data.content.videoPlaylist.dataModel.videos.guid";
		videosType = currentJsonPath + ".data.content.videoPlaylist.dataModel.videos.type";
		videosTitle = currentJsonPath + ".data.content.videoPlaylist.dataModel.videos.title";
		videosDuration = currentJsonPath + ".data.content.videoPlaylist.dataModel.videos.duration";
		videosAbstract = currentJsonPath + ".data.content.videoPlaylist.dataModel.videos.abstract";
		videosPublishDate = currentJsonPath + ".data.content.videoPlaylist.dataModel.videos.publishDate";
		videosThumbnail = currentJsonPath + ".data.content.videoPlaylist.dataModel.videos.thumbnail";
		videosDirectLink = currentJsonPath + ".data.content.videoPlaylist.dataModel.videos.directLink";
		videosAspectRatio = currentJsonPath + ".data.content.videoPlaylist.dataModel.videos.aspectRatio";
		componentId = currentJsonPath + ".component_id";
		version = currentJsonPath + ".version";
	}

}
