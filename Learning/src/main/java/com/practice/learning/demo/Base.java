package com.practice.learning.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class Base {
	
	public WebDriver driver;
	public Properties property;
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void getDriver() {
		
		try {
			 
		property = readPropertiesFile("config.properties");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String dir = System.getProperty("user.dir");
		
		if(property.getProperty("browsertype").contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",dir+"\\Resource\\chromedriver.exe");
			driver = new ChromeDriver();
		}	
		else if (property.getProperty("browsertype").contains("mozilla")) 
		{
			System.setProperty("webdriver.gecko.driver",dir+"\\Resource\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	    String url = "https://www.playtech.com/";
	    driver.get(url);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().deleteAllCookies();
	    driver.manage().window().maximize();	
	    
	}
	public static Properties readPropertiesFile(String fileName) throws IOException {
	      FileInputStream fis = null;
	      Properties prop = null;
	      try {
	         fis = new FileInputStream(fileName);
	         prop = new Properties();
	         prop.load(fis);
	      } catch(FileNotFoundException fnfe) {
	         fnfe.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } finally {
	         fis.close();
	      }
	      return prop;
	   }
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
