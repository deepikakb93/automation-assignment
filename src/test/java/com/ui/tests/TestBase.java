package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public class TestBase {
	
	protected HomePage homepage;
	Logger logger=LoggerUtility.getLogger(getClass());
	
	@BeforeMethod(description="Load Homepage of the website")
	public void setUp() {
		logger.info("Load thw homepage of the website");
		homepage = new HomePage(CHROME, false);
		
	}
	
	public BrowserUtility getInstance() {
		return homepage;
	}

}
