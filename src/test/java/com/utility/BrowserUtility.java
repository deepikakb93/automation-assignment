package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constants.Browser;

public abstract class BrowserUtility {

	
	private static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver); // initialize the IV(this refers to iv)
	}
	
	public BrowserUtility(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver.set(new FirefoxDriver());
		}else {
			System.err.println("Invalid Browser Name. Please select chrome/ Firfox only!!");
		}
	}
	
	public BrowserUtility(Browser browserName) {
		if(browserName==Browser.CHROME) {
			driver.set(new ChromeDriver());
		}else if(browserName==Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		}
	}
	
	public void goToWebsite(String url) {
		driver.get().get(url);
	}
	
	public void maximizeWindow() {
		driver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator) {
		WebElement element =driver.get().findElement(locator);
		element.click();
	}
	
	public void enterText(By Locator, String textToEnter) {
		WebElement element=driver.get().findElement(Locator);
		element.sendKeys(textToEnter);
	}
	
	public String getVisibleText(By Locator) {
		WebElement element = driver.get().findElement(Locator);
		return element.getText();
	}
	
	public String takeScreenshot(String name) {
		
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File ScreenshotData=screenshot.getScreenshotAs(OutputType.FILE);
		SimpleDateFormat format=new SimpleDateFormat("HH-mm-ss");
		String timestamp=format.format(null);
		String path=System.getProperty("user.dir")+"//screenshots//"+name+"-"+"timestamp"+".png";
		File screenshotFile=new File(path);
		try {
			FileUtils.copyFile(ScreenshotData, screenshotFile);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return path;
	}
	
}
