package com.java.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class test {

	@Test
	public void TC_01(){
		WebDriver driver;
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/browserDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://ai.mudah.my/ad/new/1");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='ReactModalPortal']//button[text()='CONTINUE']")).click();

	}

}
