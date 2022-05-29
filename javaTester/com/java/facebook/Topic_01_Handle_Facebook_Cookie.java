package com.java.facebook;

import java.util.Set;
import java.util.concurrent.TimeUnit;

//import javax.servlet.http.Cookie;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Topic_01_Handle_Facebook_Cookie {

	WebDriver driver;

	public static Set<Cookie> allCookies;

	@BeforeTest
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/browserDriver/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("0347321590");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Klinh1993");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		sleepInSecond(5);

		allCookies = driver.manage().getCookies();
		System.out.println("Cookie name = " + allCookies);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
