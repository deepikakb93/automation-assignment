package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

public class LoginTestOLD {
	
	//pibixe1564@deenur.com"

	public static void main(String[] args) {
		WebDriver wd=new ChromeDriver(); //Browser session is created
		
		BrowserUtility browserutility= new BrowserUtility(wd);
		browserutility.goToWebsite("http://www.automationpractice.pl");
		browserutility.maximizeWindow();
		
		By signInLinkLocator = By.xpath("//a[contains(text(),'Sign in')]");
		browserutility.clickOn(signInLinkLocator);
		
		By emailTextBoxLocator=By.id("email");
		browserutility.enterText(emailTextBoxLocator, "pibixe1564@deenur.com");

		
		By passwordTextBoxLocator=By.id("passwd");
		browserutility.enterText(passwordTextBoxLocator, "Password");
		
		
		By submitLoginButtonLocator=By.id("SubmitLogin");
		browserutility.clickOn(submitLoginButtonLocator);
		
	}

}
