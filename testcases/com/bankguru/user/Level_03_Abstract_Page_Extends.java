package com.bankguru.user;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;

public class Level_03_Abstract_Page_Extends extends AbstractPage {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String loginPageUrl, userID, password;

	@BeforeClass
	public void beforeClass() {

		System.out.println("Precondition - Step 01: Open browser");
		System.setProperty("webdriver.chrome.driver", projectPath + "/browserDriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("G://extension_1_42_4_0.crx"));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		driver = new ChromeDriver(options);

		System.out.println("Precondition - Step 02: Navigate to app url");
		openUrl(driver, "https://demo.guru99.com/V4/");
	}

	@Test
	public void TC_01_Register_To_System() {
		System.out.println("Register - Step 01: Get login page url");
		loginPageUrl = getCurrentPageUrl(driver);

		System.out.println("Register - Step 02: Click to here link");
		clickToElement(driver, "//a[text()='here']");

		System.out.println("Register - Step 03: Input to Email textbox");
		sendKeysToElement(driver, "//input[@name='emailid']", "klinhtkt@gmail.com");

		System.out.println("Register - Step 04: Click to submit button");
		clickToElement(driver, "//input[@name='btnLogin']");

		System.out.println("Register - Step 05: Get user ID/Password information");
		userID = getElementText(driver, "//td[text()='User ID :']/following-sibling::td");
		password = getElementText(driver, "//td[text()='Password :']/following-sibling::td");
	}

	@Test
	public void TC_02_Login_To_System() {
		// Open Login url
		openUrl(driver, loginPageUrl);

		System.out.println("Login- Step 01: Input to userID/password textbox");
		sendKeysToElement(driver, "//input[@name='uid']", userID);
		sendKeysToElement(driver, "//input[@name='password']", password);

		System.out.println("Login - Step 02: Click to login button");
		clickToElement(driver, "//input[@name='btnLogin']");

		System.out.println("Login - Step 03: Navigate to Homepage");
		Assert.assertEquals(getElementText(driver, "//marquee[@class='heading3']"), "Welcome To Manager's Page of Guru99 Bank");
	}

	@Test
	public void TC_03_New_Customer() {

	}

	@Test
	public void TC_04_Logout() {

	}

	@AfterClass
	public void afterClass() {
		System.out.println("Postcondition - Close browser");
		driver.quit();
	}
}
