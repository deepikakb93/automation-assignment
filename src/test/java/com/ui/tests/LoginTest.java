package com.ui.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.ui.pojo.User;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

import static com.constants.Browser.*;


@Listeners({com.ui.listeners.TestListener.class})
public class LoginTest extends TestBase{
	Logger logger=LoggerUtility.getLogger(getClass());

	//pavixi1714@buides.com
	
	@Test(description="Verifies whether the user is able to login with valid credentials", groups= {"e2e", "sanity"},
			dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestDataprovider")
	public void loginTest(User user) throws InterruptedException {
	
		Assert.assertEquals(homepage.goToLoginPage().doLoginWith(user.getUsername(), user.getPassword()).getUserName(),"Deepika KB");
	}
	
	@Test(description="Verifies whether the user is able to login with valid credentials", groups= {"e2e", "sanity"},
			dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestCSVDataprovider")
	public void loginCSVTest(User user) throws InterruptedException {
	
		Assert.assertEquals(homepage.goToLoginPage().doLoginWith(user.getUsername(), user.getPassword()).getUserName(),"Deepika KB");
	}
	
	@Test(description="Verifies whether the user is able to login with valid credentials", groups= {"e2e", "sanity"},
			dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestExcelDataprovider", retryAnalyzer = com.ui.listeners.MyRetryAnalyser.class)
	public void loginExcelTest(User user) throws InterruptedException {

		Assert.assertEquals(homepage.goToLoginPage().doLoginWith(user.getUsername(), user.getPassword()).getUserName(),"Deepika KB");
	}
	
	

}
