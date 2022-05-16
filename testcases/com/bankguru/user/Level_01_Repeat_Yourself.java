package com.bankguru.user;

import java.io.File;
import java.util.concurrent.TimeUnit;
//import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Level_01_Repeat_Yourself {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String loginPageUrl, userID, password;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", projectPath + "/browserDriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("G://extension_1_42_4_0.crx"));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		driver = new ChromeDriver(options);
		driver.get("https://demo.guru99.com/V4/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_Register_To_System() {

		// Get login page url
		loginPageUrl = driver.getCurrentUrl();

		// Click to here link
		driver.findElement(By.xpath("//a[text()='here']")).click();
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("klinhtkt@gmail.com");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

		// get user name / password
		userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
	}

	@Test
	public void TC_02_Login_To_System() {

		// Open Login url
		driver.get(loginPageUrl);

		// input login id/password
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userID);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

		// Navigate to Homepage
		Assert.assertEquals(driver.findElement(By.xpath("//marquee[@class='heading3']")).getText(), "Welcome To Manager's Page of Guru99 Bank");

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
