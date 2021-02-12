package com.practice.learning;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.learning.demo.Base;
import com.practice.pages.Pages;

public class TestCases extends Base{	
	Pages objPage;
	
	@Test(priority = 1)
	public void verifyLegalAge() throws InterruptedException {
		objPage = new Pages(driver,property);		
		objPage.selectElement(objPage.eleDay_AgeSelection, property.getProperty("uday"));
		objPage.selectElement(objPage.eleMonth_AgeSelection, property.getProperty("umonth"));
		objPage.selectElement(objPage.eleYear_AgeSelection, property.getProperty("uyear"));
		objPage.clickElement(objPage.btnEnter);
		Thread.sleep(2000);
		Assert.assertEquals(objPage.getElementText(objPage.lblLegalAgeAlertMsg),"Alert: Sorry you must be over 18 to enter.");
	}
	
	@Test(priority = 2)
	public void verifyLegalAge_GreaterThan18() throws InterruptedException {
		objPage = new Pages(driver,property);
		
		objPage.navigateToHomePage();
		Thread.sleep(2000);
		Assert.assertEquals(objPage.isElementDisPlayerd(objPage.lblLegalAgeAlertMsg), false);
	}
	
	@Test(priority = 3)
	public void validateNumberOfEmployees() throws InterruptedException {
		objPage = new Pages(driver,property);
		
		objPage.navigateToHomePage();
		Thread.sleep(5000);
		objPage.clickElement(objPage.lblMenu);
		objPage.clickElement(objPage.lblAboutUsSubMenu);		
		objPage.scrollToTheExactElement(objPage.eleStatsContainer);
		Thread.sleep(6000);
		Assert.assertEquals(objPage.getAttributeValue(objPage.eleEmployeeCount),property.getProperty("employeeCount"));
		Assert.assertEquals(objPage.getAttributeValue(objPage.eleCountryCount),property.getProperty("countryCount"));	
		Assert.assertEquals(objPage.getAttributeValue(objPage.eleLicenseCount),property.getProperty("licenseCount"));
		Assert.assertEquals(objPage.getAttributeValue(objPage.eleJudistrictionCount),property.getProperty("judstrictionCount"));
		
					
	}
	
	

}
