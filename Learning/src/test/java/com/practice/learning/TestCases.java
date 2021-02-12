package com.practice.learning;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.learning.demo.Base;
import com.practice.pages.Pages;

public class TestCases extends Base{	
	Pages objPage;
	
	@Test(priority = 1)
	public void verifyLegalAge() throws InterruptedException {
		objPage = new Pages(driver);		
		objPage.selectElement(objPage.eleDay_AgeSelection, "30");
		objPage.selectElement(objPage.eleMonth_AgeSelection, "05");
		objPage.selectElement(objPage.eleYear_AgeSelection, "2015");
		objPage.clickElement(objPage.btnEnter);
		Thread.sleep(2000);
		Assert.assertEquals(objPage.getElementText(objPage.lblLegalAgeAlertMsg),"Alert: Sorry you must be over 18 to enter.");
	}
	
	@Test(priority = 2)
	public void verifyLegalAge_GreaterThan18() throws InterruptedException {
		objPage = new Pages(driver);
		
		objPage.navigateToHomePage();
		Thread.sleep(2000);
		Assert.assertEquals(objPage.isElementDisPlayerd(objPage.lblLegalAgeAlertMsg), false);
	}
	
	@Test(priority = 3)
	public void validateNumberOfEmployees() throws InterruptedException {
		objPage = new Pages(driver);
		
		objPage.navigateToHomePage();
		Thread.sleep(4000);
		objPage.clickElement(objPage.lblMenu);
		objPage.clickElement(objPage.lblAboutUsSubMenu);		
		objPage.scrollToTheExactElement(objPage.eleStatsContainer);
		Thread.sleep(5000);
		Assert.assertEquals(objPage.getAttributeValue(objPage.eleEmployeeCount),"5900");
		Assert.assertEquals(objPage.getAttributeValue(objPage.eleCountryCount),"19");	
		Assert.assertEquals(objPage.getAttributeValue(objPage.eleLicenseCount),"140");
		Assert.assertEquals(objPage.getAttributeValue(objPage.eleJudistrictionCount),"20");
		
					
	}
	
	

}
