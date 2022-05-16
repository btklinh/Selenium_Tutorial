package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUI.bankGuru.DepositPageUI;

public class DepositPageObject extends AbstractPage{
	WebDriver driver;

	public DepositPageObject(WebDriver driver) {
		
		this.driver = driver;
	}



}
