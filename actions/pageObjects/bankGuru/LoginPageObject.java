package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUI.bankGuru.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	
	WebDriver driver;
	
	//Constructor
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	
	
	public RegisterPageObject clickToHereLink() {
		waitToElementVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public String getLoginPageUrl() {
		return getCurrentPageUrl(driver);		
	}

	public void inputToUserIDTextbox(String userID) {
		waitToElementVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.USER_ID_TEXTBOX, userID);		
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);		
	}

	public MainPageObject clickToLoginButton() {
		waitToElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getMainPage(driver);
	}

	public boolean isLoginFormDisplay() {
	
		return isControlDisplayed(driver, LoginPageUI.LOGIN_FORM);
	}



	//facebook method
	public void inputToUserTextBox(String user) {
		sendKeysToElement(driver, LoginPageUI.USER_TEXT, user);
	}

	public void inputToPasswordTextBox(String pass) {
		sendKeysToElement(driver, LoginPageUI.PASS_TEXT, pass);
	}

	public void clickToLogin() {
		clickToElement(driver, LoginPageUI.LOGIN_F_BUTTON);
		
	}

}
