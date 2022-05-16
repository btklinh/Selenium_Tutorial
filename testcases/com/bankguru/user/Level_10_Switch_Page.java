package com.bankguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.bankGuru.DepositPageObject;
import pageObjects.bankGuru.EditCustomerPageObject;
import pageObjects.bankGuru.FundTransferPageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.MainPageObject;
import pageObjects.bankGuru.NewCustomerPageObject;
import pageObjects.bankGuru.RegisterPageObject;

public class Level_10_Switch_Page extends AbstractTest {

	@Parameters("browser")
	@BeforeClass()
	public void beforeClass(String browserName) {

		System.out.println("Pre-condition: Open browser and Navigate to app url");
		driver = getBrowserDriver(browserName);
		System.out.println("---Driver at Class Test = " + driver.toString() + "---");
		System.out.println("Run on browser name = " + browserName + " with thread id = " + Thread.currentThread().getId());
		loginPage = PageGeneratorManager.getLoginPage(driver);

		name = "Lynn";
		dateOfBirth = "1988-10-07";
		address = "Tan Xuan Dong Ngac";
		city = "Ha Noi";
		state = "Hanoi";
		pin = "100231";
		phone = "0999127882";
		//email = "lynn" + randomNumber() + "@gmail.com";

	}

	@Test
	public void TC_01_Register_To_System() {

		System.out.println("Register - Step 01: Get login page url");
		loginPageUrl = loginPage.getLoginPageUrl();
		// loginPageUrl = getCurrentPageUrl(driver);

		System.out.println("Register - Step 02: Click to here link");
		registerPage = loginPage.clickToHereLink();

		System.out.println("Register - Step 03: Input to Email textbox");
		registerPage.inputToEmailTextBox("klinhtkt@gmail.com");

		System.out.println("Register - Step 04: Click to submit button");
		registerPage.clickToSubmitButton();

		System.out.println("Register - Step 05: Get user ID/Password information");
		userID = registerPage.getUserIDText();
		password = registerPage.gePasswordText();
	}

	@Test
	public void TC_02_Login_To_System() {
		loginPage = registerPage.openLoginPage(loginPageUrl);

		System.out.println("Login- Step 02: Input to userID/password textbox");
		loginPage.inputToUserIDTextbox(userID);
		loginPage.inputToPasswordTextbox(password);

		System.out.println("Login - Step 03: Click to login button");
		mainPage = loginPage.clickToLoginButton();

		System.out.println("Login - Step 04: Navigate to Homepage");
		Assert.assertEquals(mainPage.getWelcomeMessage(), "Welcome To Manager's Page of Guru99 Bank");
	}

	@Test
	public void TC_03_Navigate_To_Other_Page() {
		// Main Page -> New Customer
		newCustomerPage = mainPage.openNewCustomerPage(driver);

		// New Customer -> Deposit
		depositPage = newCustomerPage.openDepositPage(driver);

		// Deposit -> Edit Customer
		editCustomerPage = depositPage.openEditCustomerPage(driver);

		// Edit Customer -> Fund Transfer
		fundTransferPage = editCustomerPage.openFundTransferPage(driver);
		
		// Fund Transfer -> Edit Customer
		editCustomerPage = fundTransferPage.openEditCustomerPage(driver);
		
		//Edit Customer -> New Customer 
		newCustomerPage = editCustomerPage.openNewCustomerPage(driver);
	}

	@Test
	public void TC_04_Logout() {
		System.out.println("Logout - Step 01: Click to logout link");
		loginPage = newCustomerPage.clickToLogoutLink(driver);

		System.out.println("Logout - Step 02: Verify login form displayed");
		Assert.assertTrue(loginPage.isLoginFormDisplay());

	}

	@AfterClass
	public void afterClass() {
		System.out.println("Postcondition - Close browser");
		removeBrowserDriver();
	}

	WebDriver driver;

	String loginPageUrl, userID, password;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MainPageObject mainPage;
	NewCustomerPageObject newCustomerPage;
	DepositPageObject depositPage;
	EditCustomerPageObject editCustomerPage;
	FundTransferPageObject fundTransferPage;
	String name, dateOfBirth, address, city, state, pin, phone, email;

}
