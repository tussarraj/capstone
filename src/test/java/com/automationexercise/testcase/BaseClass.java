package com.automationexercise.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class BaseClass {
	
	public String baseURL="https://www.automationexercise.com/";
	protected static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return tdriver.get();
    }
	
	@BeforeClass
	public void setup() {
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\tussa\\eclipse-workspace\\AutomationExercises\\Driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:\\Users\\tussa\\eclipse-workspace\\AutomationExercises\\Driver\\cjpalhdlnbpafiamejdnhcphjbkeiagm-1.50.0-Crx4Chrome.com.crx"));
		WebDriver driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		tdriver.set(driver);
		getDriver().get(baseURL);
		

	}
		
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,250)", "");
	}
	
	
	@AfterClass
	public void tearDown() {
		getDriver().quit();
	}

}
