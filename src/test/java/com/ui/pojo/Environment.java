package com.ui.pojo;

import com.constants.Env;
import com.utility.PropertiesUtil;

public class Environment {

	private String url;
	private int MAXIMUM_NUMBER_OF_ATTEMPTS;
	
	public int getMAXIMUM_NUMBER_OF_ATTEMPTS() {
		return MAXIMUM_NUMBER_OF_ATTEMPTS;
	}

	public void setMAXIMUM_NUMBER_OF_ATTEMPTS(int mAXIMUM_NUMBER_OF_ATTEMPTS) {
		MAXIMUM_NUMBER_OF_ATTEMPTS = mAXIMUM_NUMBER_OF_ATTEMPTS;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
