package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.jQuery.HomePageObject;

public class Level_12_Handle_Datatable extends AbstractTest {

	WebDriver driver;
	HomePageObject homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass()
	public void beforeClass(String browserName, String appURL) {

		driver = getBrowserDriver(browserName, appURL);
		homePage = new HomePageObject(driver);
	}

	
	public void TC_01_Input() {

		// Input to textbox
		homePage.inputToTextBoxByColumnName("Country", "Vietnam");
		
		homePage.inputToTextBoxByColumnName("Females", "642000");
		
		homePage.inputToTextBoxByColumnName("Males", "678000");
		
		homePage.inputToTextBoxByColumnName("Total", "1320000");

		homePage.sleepInSecond(2);
	}

	
	public void TC_02_Navigate() {
		
		homePage.refreshCurrentPage(driver);
		
		// Navigate to any page
		homePage.navigateToPageByPageNumber("3");
		// Verify page navigate success
		Assert.assertTrue(homePage.isPageActivedByPageNumber("3"));

		homePage.navigateToPageByPageNumber("12");
		Assert.assertTrue(homePage.isPageActivedByPageNumber("12"));

		homePage.navigateToPageByPageNumber("22");
		Assert.assertTrue(homePage.isPageActivedByPageNumber("22"));
	}

	
	public void TC_03_Icon() {
		//homePage.refreshCurrentPage(driver);
		
		homePage.clickToDeleteIconByCountryName("Afghanistan");
		homePage.sleepInSecond(2);
		homePage.refreshCurrentPage(driver);
		
		homePage.clickToDeleteIconByCountryName("Armenia");
		homePage.sleepInSecond(2);
		homePage.refreshCurrentPage(driver);
		
		homePage.clickToEditIconByCountryName("AFRICA");
		homePage.sleepInSecond(4);
	}


	public void TC_04_Displayed() {
		Assert.assertTrue(homePage.isAllInfoDisplayed("12253515", "AFRICA", "12599691", "24853148"));
		Assert.assertTrue(homePage.isAllInfoDisplayed("764956", "Arab Rep of Egypt", "802948", "1567904"));
		Assert.assertTrue(homePage.isAllInfoDisplayed("750", "Aruba", "756", "1504"));
		homePage.sleepInSecond(2);
	}

	@Test
	public void TC_05_Index() {
		homePage.openUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		homePage.inputToTextboxByColumnNameAtRow("Artist","1","Automation FC");
		homePage.sleepInSecond(3);
	}
	@AfterClass
	public void afterClass() {
		removeBrowserDriver();
	}

}
