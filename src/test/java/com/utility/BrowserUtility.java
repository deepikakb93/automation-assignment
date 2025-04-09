package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constants.Browser;

public abstract class BrowserUtility {

	
	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver = driver; // initialize the IV(this refers to iv)
	}
	
	public BrowserUtility(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else {
			System.err.println("Invalid Browser Name. Please select chrome/ Firfox only!!");
		}
	}
	
	public BrowserUtility(Browser browserName) {
		if(browserName==Browser.CHROME) {
			driver=new ChromeDriver();
		}else if(browserName==Browser.FIREFOX) {
			driver=new FirefoxDriver();
		}
	}
	
	public void goToWebsite(String url) {
		driver.get(url);
	}
	
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public void clickOn(By locator) {
		WebElement element =driver.findElement(locator);
		element.click();
	}
	
	public void enterText(By Locator, String textToEnter) {
		WebElement element=driver.findElement(Locator);
		element.sendKeys(textToEnter);
	}
	
	public String getVisibleText(By Locator) {
		WebElement element = driver.findElement(Locator);
		return element.getText();
	}
	
}
