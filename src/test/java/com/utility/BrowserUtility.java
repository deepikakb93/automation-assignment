package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public class BrowserUtility {

	
	private static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	Logger logger=LoggerUtility.getLogger(this.getClass());
	
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
		logger.info("Launching Browser for "+browserName);
		if(browserName==Browser.CHROME) {
			driver.set(new ChromeDriver());
		}else if(browserName==Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		}
	}
	
	
	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching Browser for "+browserName);
		
			
		if(browserName==Browser.CHROME ) {
			if(isHeadless) {
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--headless=old");
			options.addArguments("--window-size=1920,1080");
			driver.set(new ChromeDriver(options));
		}else {
			driver.set(new ChromeDriver());
		}
		
		}else if(browserName== Browser.EDGE) {
			if(isHeadless) {
				EdgeOptions options=new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--disable-gpu");
				driver.set(new EdgeDriver(options));
			}else {
				driver.set(new EdgeDriver());
			}
		}else if(browserName== Browser.FIREFOX) {
			if(isHeadless) {
				FirefoxOptions options=new FirefoxOptions();
				options.addArguments("--headless=old");
				options.addArguments("--disable-gpu");
				driver.set(new FirefoxDriver(options));
			}else {
				driver.set(new FirefoxDriver());
			}
			
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
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("HH-mm-ss");
		String timeStamp=format.format(date);
		String path=System.getProperty("user.dir")+"//screenshots//"+name+" - "+timeStamp+".png";
		File screenshotFile=new File(path);
		try {
			FileUtils.copyFile(ScreenshotData, screenshotFile);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return path;
	}
	
}
