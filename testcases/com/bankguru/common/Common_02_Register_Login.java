package com.bankguru.common;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.MainPageObject;
import pageObjects.bankGuru.RegisterPageObject;

public class Common_02_Register_Login extends AbstractTest {

	WebDriver driver;
	public static String userID, password;

	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		email = "klinhtkt@gmail.com";

		log.info("Register - Step 01: Click to 'here' link");
		loginPageUrl = loginPage.getLoginPageUrl();
		loginPage.clickToHereLink();
		registerPage = new RegisterPageObject(driver);

		log.info("Register - Step 02: Input to 'Email' textbox with value: " + email);
		registerPage.inputToEmailTextBox(email);

		log.info("Register - Step 03: Click to 'Submit' button");
		registerPage.clickToSubmitButton();

		log.info("Register - Step 04: Get 'Username' / 'Password' information");
		userID = registerPage.getUserIDText();
		password = registerPage.gePasswordText();
		
		log.info("Login - Step 01: Open Login page");
		loginPage = registerPage.openLoginPage(loginPageUrl);

		log.info("Login - Step 03: Input to 'Username' textbox with value: " + userID);
		loginPage.inputToUserIDTextbox(userID);
		
		log.info("Login - Step 04: Input to 'Password' textbox with value: " + password);
		loginPage.inputToPasswordTextbox(password);

		log.info("Login - Step 05: Click to 'Login' button");
		mainPage = loginPage.clickToLoginButton();

		log.info("Login - Step 06: Verify welcom message display in 'Homepage'");
		verifyEquals(mainPage.getWelcomeMessage(), "Welcome To Manager's Page of Guru99 Bankd.");
		
		// Get ra Cookie luu lai thanh 1 bien static
		
		removeBrowserDriver();
	}

	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MainPageObject mainPage;

	String name, dateOfBirth, address, city, state, pin, phone, email, loginPageUrl;

}
