package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUI.bankGuru.EditCustomerPageUI;

public class EditCustomerPageObject extends AbstractPage{
	WebDriver driver;

	public EditCustomerPageObject(WebDriver driver) {
		
		this.driver = driver;
	}


}
