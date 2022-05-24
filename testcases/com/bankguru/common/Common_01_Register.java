package com.bankguru.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.MainPageObject;
import pageObjects.bankGuru.RegisterPageObject;

public class Common_01_Register extends AbstractTest {

	WebDriver driver;

	public static String userID, password;

	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		email = "klinhtkt@gmail.com";

		log.info("Register - Step 01: Click to 'here' link");
		loginPage.clickToHereLink();
		registerPage = new RegisterPageObject(driver);

		log.info("Register - Step 02: Input to 'Email' textbox with value: " + email);
		registerPage.inputToEmailTextBox(email);

		log.info("Register - Step 03: Click to 'Submit' button");
		registerPage.clickToSubmitButton();

		log.info("Register - Step 04: Get 'Username' / 'Password' information");
		userID = registerPage.getUserIDText();
		password = registerPage.gePasswordText();
		
		removeBrowserDriver();
	}

	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MainPageObject mainPage;

	String name, dateOfBirth, address, city, state, pin, phone, email;

}
