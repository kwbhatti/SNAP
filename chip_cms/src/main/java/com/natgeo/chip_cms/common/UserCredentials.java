package com.natgeo.chip_cms.common;

import com.natgeo.chip_cms.common.UserType;
import com.natgeo.utilities.LoaderUtil;

public class UserCredentials {

	public String user;
	public String pass;
	public String token;
	
	public UserCredentials(UserType userType) {
		LoaderUtil.getInstance().intilizeValues();
		getUserCredentials(userType);
	}
	
	public void getUserCredentials(UserType userType) {
		switch(userType) {
		case ADMIN:
			user = LoaderUtil.getInstance().chipCmsAdminUser;
			pass = LoaderUtil.getInstance().chipCmsAdminPass;
			token = LoaderUtil.getInstance().chipCmsAdminToken;
			break;
		case AUTHENTICATED:
			user = LoaderUtil.getInstance().chipCmsAuthUser;
			pass = LoaderUtil.getInstance().chipCmsAuthPass;
			token = LoaderUtil.getInstance().chipCmsAuthToken;
			break;
		default:
			user = "";
			pass = "";
		}
	}
	
}
