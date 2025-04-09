package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility{
	
	private static final By EMAIL_TEXTBOX_Locator=By.id("email");
	private static final By PASSWORD_TEXTBOX_LOCATOR=By.id("passwd");
	private static final By SUBMIT_LOGINBUTTON_LOCATOR=By.id("SubmitLogin");

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public MyAccountPage doLoginWith(String username, String password) {
		
		enterText(EMAIL_TEXTBOX_Locator, username);
		enterText(PASSWORD_TEXTBOX_LOCATOR, password);
		clickOn(SUBMIT_LOGINBUTTON_LOCATOR);
		MyAccountPage myaccountpage= new MyAccountPage(getDriver());
		return myaccountpage;
	}

}
