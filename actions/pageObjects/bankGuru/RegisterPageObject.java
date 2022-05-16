package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUI.bankGuru.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {

	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		//super();
		this.driver = driver;
	}

	public void inputToEmailTextBox(String email) {
		waitToElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void clickToSubmitButton() {
		waitToElementClickable(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
	}

	public String getUserIDText() {
		waitToElementVisible(driver, RegisterPageUI.USER_ID_TEXT);
		return getElementText(driver, RegisterPageUI.USER_ID_TEXT);
	}

	public String gePasswordText() {
		waitToElementVisible(driver, RegisterPageUI.PASSWORD_TEXT);
		return getElementText(driver, RegisterPageUI.PASSWORD_TEXT);
	}

	public LoginPageObject openLoginPage(String loginPageUrl) {
		openUrl(driver, loginPageUrl);
		return PageGeneratorManager.getLoginPage(driver);
	}

}
