package com.practice.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Pages  {
	private WebDriver driver;
	private Properties _properties;
	public Pages(WebDriver driver,Properties properties) {
	this._properties=properties;
	this.driver=driver;
	}
	//Legal age page elements
	public final By eleDay_AgeSelection = By.name("day");
	public final By eleMonth_AgeSelection = By.name("month");
	public final By eleYear_AgeSelection = By.name("year");
	public final By btnEnter = By.xpath("//button[text()=\"Enter Site\"]");	
	public final By lblLegalAgeAlertMsg = By.xpath("//div[@class=\"alert alert-danger\"]");

	//Website Home page elements
	public final By lblMenu = By.id("hamburger");
	public final By lblAboutUsSubMenu = By.xpath("//*[@id=\"mp-menu\"]/div/ul/li[1]/a/span[2]");
	public final By eleStatsContainer = By.xpath("//div[@class=\"ccm-block statsBlock\"]");
	public final By eleEmployeeCount = By.xpath("//div[@class=\"container-fluid flex-target\"]//div[1]//div[@class=\"stat-count odometer odometer-auto-theme\"]");
	public final By eleCountryCount = By.xpath("//div[@class=\"container-fluid flex-target\"]//div[2]//div[@class=\"stat-count odometer odometer-auto-theme\"]");
	public final By eleLicenseCount = By.xpath("//div[@class=\"container-fluid flex-target\"]//div[3]//div[@class=\"stat-count odometer odometer-auto-theme\"]");
	public final By eleJudistrictionCount = By.xpath("//div[@class=\"container-fluid flex-target\"]//div[4]//div[@class=\"stat-count odometer odometer-auto-theme\"]");
	
	
	public void selectElement(By ele, String value) {
		Select day = new Select(driver.findElement(ele));
		day.selectByVisibleText(value);
	}
	
	public void clickElement(By ele) {
		driver.findElement(ele).click();
	}
	
	public String getElementText(By ele) {
		return driver.findElement(ele).getText();				
	}
	
	public boolean isElementDisPlayerd(By ele) {
		return driver.findElement(ele).isDisplayed();
	}
	
	public void navigateToHomePage() {
		selectElement(eleDay_AgeSelection, _properties.getProperty("validday"));
		selectElement(eleMonth_AgeSelection, _properties.getProperty("validmonth"));
		selectElement(eleYear_AgeSelection, _properties.getProperty("validyear"));
		clickElement(btnEnter);
	}
	
	public void scrollToTheExactElement(By ele) {						
		WebElement element = driver.findElement(ele);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();		
	}
	
	
	public String getAttributeValue(By ele) {
		return driver.findElement(ele).getAttribute("data-odometer-count");
	}
	
	
}
