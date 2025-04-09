package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.ui.pojo.User;
import com.utility.BrowserUtility;
import static com.constants.Browser.*;

public class LoginTest {
	
	HomePage homepage;
	
	@BeforeMethod(description="Load Homepage of the website")
	public void setUp() {
		homepage = new HomePage(CHROME);
		
	}
	//pibixe1564@deenur.com, pavixi1714@buides.com
	
	@Test(description="Verifies whether the user is able to login with valid credentials", groups= {"e2e", "sanity"},
			dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestDataprovider")
	public void loginTest(User user) throws InterruptedException {
	
		assertEquals(homepage.goToLoginPage().doLoginWith(user.getUsername(), user.getPassword()).getUserName(),"Deepika KB");
	}
	
	@Test(description="Verifies whether the user is able to login with valid credentials", groups= {"e2e", "sanity"},
			dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestCSVDataprovider")
	public void loginCSVTest(User user) throws InterruptedException {
	
		assertEquals(homepage.goToLoginPage().doLoginWith(user.getUsername(), user.getPassword()).getUserName(),"Deepika KB");
	}
	
	@Test(description="Verifies whether the user is able to login with valid credentials", groups= {"e2e", "sanity"},
			dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestExcelDataprovider", retryAnalyzer = com.ui.listeners.MyRetryAnalyser.class)
	public void loginExcelTest(User user) throws InterruptedException {
	
		assertEquals(homepage.goToLoginPage().doLoginWith(user.getUsername(), user.getPassword()).getUserName(),"Deepika KB");
	}
	
	

}
