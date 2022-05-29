package com.java.facebook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Login_Success {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/browserDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
	}
	

	@Test
	public void Load_Cookies() {
		for (Cookie cookie : Topic_01_Handle_Facebook_Cookie.allCookies) {
			driver.manage().addCookie(cookie);
		}
		Topic_01_Handle_Facebook_Cookie.allCookies = driver.manage().getCookies();
		System.out.println("Cookie name = " + Topic_01_Handle_Facebook_Cookie.allCookies);
		driver.navigate().refresh();
		sleepInSecond(5);
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}

	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
