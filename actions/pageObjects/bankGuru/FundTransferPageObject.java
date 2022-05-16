package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUI.bankGuru.FundTransferPageUI;
import pageUI.bankGuru.NewCustomerUI;

public class FundTransferPageObject extends AbstractPage{
	WebDriver driver;

	public FundTransferPageObject(WebDriver driver) {
		
		this.driver = driver;
	}



}
