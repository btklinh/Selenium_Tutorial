package com.bankguru.user;

import static org.testng.Assert.assertTrue;

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

public class Level_14_Assert_Verify extends AbstractTest {

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
		userID = "mngr399874";
				password= "uteguga";

	}

	@Test
	public void TC_01_Register_To_System() {
	}

	@Test
	public void TC_02_Login_To_System() {
		System.out.println("Login- Step 01: Open Login page");
		//loginPage = registerPage.openLoginPage(loginPageUrl);
		
		// First false
		System.out.println("Login- Step 02: Check login form displayed");		
		verifyTrue(loginPage.isLoginFormDisplay());

		System.out.println("Login- Step 03: Input to userID/password textbox");
		loginPage.inputToUserIDTextbox(userID);
		loginPage.inputToPasswordTextbox(password);

		System.out.println("Login - Step 04: Click to login button");
		mainPage = loginPage.clickToLoginButton();

		// Second false
		System.out.println("Login - Step 05: Navigate to Homepage");
		verifyEquals(mainPage.getWelcomeMessage(), "Welcome To Manager's Page of. ");
		
		
		// Third false
		System.out.println("Login- Step 06: Check login form undisplayed");
		verifyFalse(mainPage.isLoginFormUndisplayed());
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
