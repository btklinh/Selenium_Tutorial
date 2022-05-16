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

public class Level_02_Abstract_Page {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String loginPageUrl, userID, password;
	AbstractPage abstractPage;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", projectPath + "/browserDriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("G://extension_1_42_4_0.crx"));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		driver = new ChromeDriver(options);
				
	//	abstractPage = new AbstractPage();
		
		abstractPage.openUrl(driver, "https://demo.guru99.com/V4/");
	}

	@Test
	public void TC_01_Register_To_System() {
		System.out.println("Step 01 - Get login page url");
		loginPageUrl = abstractPage.getCurrentPageUrl(driver);

		System.out.println("Step 02 - Click to here link");
		abstractPage.clickToElement(driver, "//a[text()='here']");
		
		System.out.println("Step 03 - Input to Email textbox");
		abstractPage.sendKeysToElement(driver, "//input[@name='emailid']", "klinhtkt@gmail.com" );
		
		System.out.println("Step 04 - Click to submit button");
		abstractPage.clickToElement(driver, "//input[@name='btnLogin']");

		System.out.println("Step 05 - Get user ID/Password information");
		userID = abstractPage.getElementText(driver, "//td[text()='User ID :']/following-sibling::td");
		password = abstractPage.getElementText(driver, "//td[text()='Password :']/following-sibling::td");
	}

	@Test
	public void TC_02_Login_To_System() {
		// Open Login url
		abstractPage.openUrl(driver, loginPageUrl);

		System.out.println("Step 01 - Input to userID/password textbox");
		abstractPage.sendKeysToElement(driver, "//input[@name='uid']", userID);
		abstractPage.sendKeysToElement(driver, "//input[@name='password']", password);
		
		System.out.println("Step 02 - Click to login button");
		abstractPage.clickToElement(driver,"//input[@name='btnLogin']");

		System.out.println("Step 03 - Navigate to Homepage");
		Assert.assertEquals(abstractPage.getElementText(driver, "//marquee[@class='heading3']"), "Welcome To Manager's Page of Guru99 Bank");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
