package com.natgeo.chip_cms.common;

public enum ContentFieldType {
	TAXONOMY_API_REFERENCE(6);
	private Integer index;
	public Integer getIndex() {
		return this.index;
	}
	ContentFieldType(Integer index){
		this.index = index;
	}
}
