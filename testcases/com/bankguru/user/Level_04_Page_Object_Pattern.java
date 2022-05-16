package com.bankguru.user;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.MainPageObject;
import pageObjects.bankGuru.NewCustomerPageObject;
import pageObjects.bankGuru.RegisterPageObject;

public class Level_04_Page_Object_Pattern extends AbstractPage {

	@BeforeClass
	public void beforeClass() {

		System.out.println("Precondition - Step 02: Open browser and Navigate to app url");
//		System.setProperty("webdriver.chrome.driver", projectPath + "/browserDriver/chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		options.setAcceptInsecureCerts(true);
//		options.addExtensions(new File("G://extension_1_42_4_0.crx"));
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//		options.merge(capabilities);
//		driver = new ChromeDriver(options);

		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDriver/geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.setAcceptInsecureCerts(true);
		FirefoxProfile profile= new FirefoxProfile();
		profile.addExtension(new File("G://adblocker_ultimate-3.7.16-an+fx.xpi"));
		options.setProfile(profile);
		driver = new FirefoxDriver (options);

		name = "Lynn";
		dateOfBirth = "1988-10-07";
		address = "Tan Xuan Dong Ngac";
		city = "Ha Noi";
		state = "Hanoi";
		pin = "100231";
		phone = "0999127882";
		email = "lynn" + randomNumber() + "@gmail.com";

		loginPage = new LoginPageObject(driver);
		loginPage.openUrl(driver, "https://demo.guru99.com/V4/");
	}

	@Test
	public void TC_01_Register_To_System() {
		System.out.println("Register - Step 01: Get login page url");
		loginPageUrl = loginPage.getLoginPageUrl();
		// loginPageUrl = getCurrentPageUrl(driver);

		System.out.println("Register - Step 02: Click to here link");
		loginPage.clickToHereLink();
		registerPage = new RegisterPageObject(driver);
		// clickToElement(driver, "//a[text()='here']");

		System.out.println("Register - Step 03: Input to Email textbox");
		registerPage.inputToEmailTextBox("klinhtkt@gmail.com");
		// sendKeysToElement(driver, "//input[@name='emailid']", "klinhtkt@gmail.com");

		System.out.println("Register - Step 04: Click to submit button");
		registerPage.clickToSubmitButton();

		// clickToElement(driver, "//input[@name='btnLogin']");

		System.out.println("Register - Step 05: Get user ID/Password information");
		userID = registerPage.getUserIDText();
		password = registerPage.gePasswordText();
		/*
		 * userID = getElementText(driver, "//td[text()='User ID :']/following-sibling::td"); password = getElementText(driver,
		 * "//td[text()='Password :']/following-sibling::td");
		 */
	}

	@Test
	public void TC_02_Login_To_System() {
		// Open Login url
		openUrl(driver, loginPageUrl);
		registerPage.openLoginPage(loginPageUrl);
		loginPage = new LoginPageObject(driver);

		System.out.println("Login- Step 02: Input to userID/password textbox");
		loginPage.inputToUserIDTextbox(userID);
		loginPage.inputToPasswordTextbox(password);
//		sendKeysToElement(driver, "//input[@name='uid']", userID);
//		sendKeysToElement(driver, "//input[@name='password']", password);

		System.out.println("Login - Step 03: Click to login button");
		loginPage.clickToLoginButton();
		mainPage = new MainPageObject(driver);
//		clickToElement(driver, "//input[@name='btnLogin']");

		System.out.println("Login - Step 04: Navigate to Homepage");
		Assert.assertEquals(mainPage.getWelcomeMessage(), "Welcome To Manager's Page of Guru99 Bank");
	}

	@Test
	public void TC_03_New_Customer() {
		System.out.println("New Customer - Step 01: Open New customer");
		mainPage.openNewCustomerPage(driver);
		newCustomerPage = new NewCustomerPageObject(driver);

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
		newCustomerPage.clickToLogoutLink(driver);
		loginPage = new LoginPageObject(driver);

		System.out.println("Logout - Step 02: Verify login form displayed");
		Assert.assertTrue(loginPage.isLoginFormDisplay());

	}

	@AfterClass

	public void afterClass() {
		System.out.println("Postcondition - Close browser");
		driver.quit();
	}

	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(99);
	}

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String loginPageUrl, userID, password;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MainPageObject mainPage;
	NewCustomerPageObject newCustomerPage;
	String name, dateOfBirth, address, city, state, pin, phone, email;

}
