package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUI.bankGuru.MainPageUI;

public class MainPageObject extends AbstractPage {

	WebDriver driver;

	public MainPageObject(WebDriver driver) {
		//super();
		this.driver = driver;
	}

	public String getWelcomeMessage() {
		waitToElementVisible(driver, MainPageUI.WELCOME_MESSAGE_TEXT);
		return getElementText(driver, MainPageUI.WELCOME_MESSAGE_TEXT);
	}

	public boolean isLoginFormUndisplayed() {
		waitToElementInvisible(driver, MainPageUI.LOGIN_FORM);
		return isControlUndisplayed(driver, MainPageUI.LOGIN_FORM);
	}

	

}
