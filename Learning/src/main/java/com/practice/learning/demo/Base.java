package com.practice.learning.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class Base {
	
	public WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void getDriver() {
		String dir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",dir+"\\Resource\\chromedriver.exe");
		driver = new ChromeDriver();
	    String url = "https://www.playtech.com/";
	    driver.get(url);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().deleteAllCookies();
	    driver.manage().window().maximize();	
	    
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
