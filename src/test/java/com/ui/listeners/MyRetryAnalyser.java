package com.ui.listeners;

import java.util.Properties;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

public class MyRetryAnalyser implements IRetryAnalyzer{
	// Read the count from Prop File
	//private static final int MAXIMUM_NUMBER_OF_ATTEMPTS= Integer.parseInt(PropertiesUtil.readProperty(Env.QA, "MAXIMUM_NUMBER_OF_ATTEMPTS"));
	// Read the retry count from JSON file
	private static final int MAXIMUM_NUMBER_OF_ATTEMPTS= JSONUtility.readJson(Env.QA).getMAXIMUM_NUMBER_OF_ATTEMPTS();
	private static int currentAttempt=1;

	@Override
	public boolean retry(ITestResult result) {
	
		if(currentAttempt<=MAXIMUM_NUMBER_OF_ATTEMPTS) {
			currentAttempt++;
		}
		return false;
	}

}
