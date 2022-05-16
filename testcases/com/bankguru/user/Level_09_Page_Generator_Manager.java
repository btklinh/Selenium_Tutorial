package com.bankguru.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.MainPageObject;
import pageObjects.bankGuru.NewCustomerPageObject;
import pageObjects.bankGuru.RegisterPageObject;

public class Level_09_Page_Generator_Manager extends AbstractTest {

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
		email = "lynn" + randomNumber() + "@gmail.com";

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
	public void TC_03_New_Customer() {
		System.out.println("New Customer - Step 01: Open New customer");
		newCustomerPage = mainPage.openNewCustomerPage(driver);

		System.out.println("New Customer - Step 02: Input to 'Name' textbox");
		newCustomerPage.inputToNameTextbox(name);

		System.out.println("New Customer - Step 03: Input to 'Date of birth' textbox");
		newCustomerPage.inputToDateOfBirthTextbox(dateOfBirth);

		System.out.println("New Customer - Step 04: Input to 'Address' textbox");
		newCustomerPage.inputToAddressTextArea(address);

		System.out.println("New Customer - Step 05: Input to 'City' textbox");
		newCustomerPage.inputToCityTextbox(city);

		System.out.println("New Customer - Step 06: Input to 'State' textbox");
		newCustomerPage.inputToStateTextbox(state);

		System.out.println("New Customer - Step 07: Input to 'PIN' textbox");
		newCustomerPage.inputToPinTextbox(pin);

		System.out.println("New Customer - Step 08: Input to 'Phone' textbox");
		newCustomerPage.inputToPhoneTextbox(phone);

		System.out.println("New Customer - Step 09: Input to 'Email' textbox");
		newCustomerPage.inputToEmailTextbox(email);

		System.out.println("New Customer - Step 10: Input to 'Password' textbox");
		newCustomerPage.inputToPasswordTextbox(password);

		System.out.println("New Customer - Step 11: Click to 'Submit' button");
		newCustomerPage.clickToSubmitButton();

		System.out.println("New Customer - Step 12: Verify Success message displayed");
		Assert.assertEquals(newCustomerPage.getSuccessMessage(), "Customer Registered Successfully!!!");
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

	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(99);
	}

	WebDriver driver;

	String loginPageUrl, userID, password;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MainPageObject mainPage;
	NewCustomerPageObject newCustomerPage;
	String name, dateOfBirth, address, city, state, pin, phone, email;

}
