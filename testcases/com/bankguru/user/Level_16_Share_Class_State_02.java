package com.bankguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Common_01_Register;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.bankGuru.DepositPageObject;
import pageObjects.bankGuru.EditCustomerPageObject;
import pageObjects.bankGuru.FundTransferPageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.MainPageObject;
import pageObjects.bankGuru.NewCustomerPageObject;
import pageObjects.bankGuru.RegisterPageObject;

public class Level_16_Share_Class_State_02 extends AbstractTest {

	@Parameters("browser")
	@BeforeClass()
	public void beforeClass(String browserName) {
		log.info("Pre-condition: Open " + browserName + " and Navigate to app url");
		driver = getBrowserDriver(browserName);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		//email = "klinhtkt@gmail.com";
		
		log.info("Pre-Condition 01 - Step 01: Input to UserID textbox");
		loginPage.inputToUserIDTextbox(Common_01_Register.userID);
		
		log.info("Pre-Condition 01 - Step 02: Input to Password textbox");
		loginPage.inputToPasswordTextbox(Common_01_Register.password);

		log.info("Pre-Condition 01 - Step 03: Input to Login button");
		mainPage = loginPage.clickToLoginButton();
	}


	@Test
	public void TC_01_Create_New_Customer() {
		
	}
	
	@Test
	public void TC_02_View_Customer() {
		
	}
	
	@Test
	public void TC_03_Edit_Customer() {
		
	}
	
	@Test
	public void TC_04_Delete_Customer() {
		
	}

	@AfterClass
	public void afterClass() {
		log.info("Postcondition - Close browser");
		removeBrowserDriver();
	}

	WebDriver driver;

	//String loginPageUrl, userID, password;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MainPageObject mainPage;
	NewCustomerPageObject newCustomerPage;
	DepositPageObject depositPage;
	EditCustomerPageObject editCustomerPage;
	FundTransferPageObject fundTransferPage;
	String name, dateOfBirth, address, city, state, pin, phone, email;

}
