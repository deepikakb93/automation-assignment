package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyser implements IRetryAnalyzer{
	
	private static final int MAXIMUM_NUMBER_OF_ATTEMPTS=3;
	private static int currentAttempt=1;

	@Override
	public boolean retry(ITestResult result) {
	
		if(currentAttempt<=MAXIMUM_NUMBER_OF_ATTEMPTS) {
			currentAttempt++;
		}
		return false;
	}

}
