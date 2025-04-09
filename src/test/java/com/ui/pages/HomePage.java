package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.PropertiesUtil;

public final class HomePage extends BrowserUtility{

	private static final By SIGN_IN_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");
	
	public HomePage(Browser browserName) {
		super(browserName);
		goToWebsite(PropertiesUtil.readProperty(QA,"URL"));
	}
	
	public LoginPage goToLoginPage() {
		clickOn(SIGN_IN_LOCATOR);
		LoginPage loginpage = new LoginPage(getDriver());
		return loginpage;
	}
	
}
