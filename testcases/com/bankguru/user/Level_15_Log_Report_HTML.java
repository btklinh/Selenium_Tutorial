package com.bankguru.user;

import org.openqa.selenium.WebDriver;
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

public class Level_15_Log_Report_HTML extends AbstractTest {

	@Parameters("browser")
	@BeforeClass()
	public void beforeClass(String browserName) {
		log.info("Pre-condition: Open " + browserName + " and Navigate to app url");
		driver = getBrowserDriver(browserName);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		email = "klinhtkt@gmail.com";
	}

	@Test
	public void TC_01_Register_To_System() {
		log.info("Register - Step 01: Get login page url");
		loginPageUrl = loginPage.getLoginPageUrl();

		log.info("Register - Step 02: Click to 'here' link");
		loginPage.clickToHereLink();
		registerPage = new RegisterPageObject(driver);

		log.info("Register - Step 03: Input to 'Email' textbox with value: " + email);
		registerPage.inputToEmailTextBox(email);

		log.info("Register - Step 04: Click to 'Submit' button");
		registerPage.clickToSubmitButton();

		log.info("Register - Step 05: Get 'Username' / 'Password' information");
		userID = registerPage.getUserIDText();
		password = registerPage.gePasswordText();
	}

	@Test
	public void TC_02_Login_To_System() {
		log.info("Login - Step 01: Open Login page");
		loginPage = registerPage.openLoginPage(loginPageUrl);

		log.info("Login - Step 03: Input to 'Username' textbox with value: " + userID);
		loginPage.inputToUserIDTextbox(userID);
		
		log.info("Login - Step 04: Input to 'Password' textbox with value: " + password);
		loginPage.inputToPasswordTextbox(password);

		log.info("Login - Step 05: Click to 'Login' button");
		mainPage = loginPage.clickToLoginButton();

		log.info("Login - Step 06: Verify welcom message display in 'Homepage'");
		verifyEquals(mainPage.getWelcomeMessage(), "Welcome To Manager's Page of Guru99 Bankdfasd ., ");
	}

	@AfterClass
	public void afterClass() {
		log.info("Postcondition - Close browser");
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
