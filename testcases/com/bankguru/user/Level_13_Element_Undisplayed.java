package com.bankguru.user;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.bankGuru.DepositPageObject;
import pageObjects.bankGuru.EditCustomerPageObject;
import pageObjects.bankGuru.FundTransferPageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.MainPageObject;
import pageObjects.bankGuru.NewCustomerPageObject;
import pageObjects.bankGuru.RegisterPageObject;

public class Level_13_Element_Undisplayed extends AbstractTest {

	WebDriver driver;
	LoginPageObject loginPage;
	AbstractPage abstractPage;
	
	@Parameters("browser")
	@BeforeClass()
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		abstractPage = new AbstractPage();
		//abstractPage.openUrl(driver, "https://www.facebook.com/");
	}

	@Test
	public void TC_01_Element_Undisplayed() throws InterruptedException {
		//driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

		// Kiem tra 1 element hien thi
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Case 01 - Start: " + getTimeNow());
		abstractPage.waitToElementVisible(driver, "//input[@name='firstname']");
		Assert.assertFalse(abstractPage.isControlUndisplayed(driver, "//input[@name='firstname']"));
		System.out.println("Case 01 - End: " + getTimeNow());
	
		// kiem tra 1 element khong hien thi (ko co tren ui nhung lai xuat hien trong dom)
		
		System.out.println("Case 02 - Start: " + getTimeNow());
		abstractPage.waitToElementInvisible(driver, "//input[@name='reg_email_confirmation__']");
		Assert.assertTrue(abstractPage.isControlUndisplayed(driver, "//input[@name='reg_email_confirmation__']"));
		System.out.println("Case 02 - End: " + getTimeNow());
		
		// kiem tra 1 element khong hien thi (ko co tren ui va ko xuat hien trong dom)
		driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
		Thread.sleep(2000);
		System.out.println("Case 03 - Start: " + getTimeNow());
		abstractPage.waitToElementInvisible(driver, "//input[@name='firstname']");
		System.out.println("Case 03 - End: " + getTimeNow());
		
		System.out.println("Case 04 - Start: " + getTimeNow());
		Assert.assertTrue(abstractPage.isControlUndisplayed(driver,"//input[@name='firstname']"));
		System.out.println("Case 04 - End: " + getTimeNow());
		//System.out.println("Case 03 - End: " + getTimeNow());
	}

	public String getTimeNow() {
		Date date = new Date();
		return date.toString();
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Case 03 - End: " + getTimeNow());
	 removeBrowserDriver();

	}


	

}
