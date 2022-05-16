package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUI.bankGuru.NewCustomerUI;

public class NewCustomerPageObject extends AbstractPage {

	WebDriver driver;

	public NewCustomerPageObject(WebDriver driver) {
		//super();
		this.driver = driver;
	}

	public void inputToNameTextbox(String name) {
		waitToElementVisible(driver, NewCustomerUI.CUSTOMER_NAME_TEXTBOX);
		sendKeysToElement(driver, NewCustomerUI.CUSTOMER_NAME_TEXTBOX, name);
	}

	public void inputToDateOfBirthTextbox(String dateOfBirth) {
		waitToElementVisible(driver, NewCustomerUI.DATE_OF_BIRTH_TEXTBOX);
		//removeAttributeInDOM(driver, NewCustomerUI.DATE_OF_BIRTH_TEXTBOX, "type");
	//	waitToElementVisible(driver, NewCustomerUI.DATE_OF_BIRTH_TEXTBOX);
		sendKeysToElement(driver, NewCustomerUI.DATE_OF_BIRTH_TEXTBOX, dateOfBirth);
	}

	public void inputToAddressTextArea(String address) {
		waitToElementVisible(driver, NewCustomerUI.ADDRESS_TEXTAREA);
		sendKeysToElement(driver, NewCustomerUI.ADDRESS_TEXTAREA, address);
	}

	public void inputToCityTextbox(String city) {
		waitToElementVisible(driver, NewCustomerUI.CITY_TEXTBOX);
		sendKeysToElement(driver, NewCustomerUI.CITY_TEXTBOX, city);
	}

	public void inputToStateTextbox(String state) {
		waitToElementVisible(driver, NewCustomerUI.STATE_TEXTBOX);
		sendKeysToElement(driver, NewCustomerUI.STATE_TEXTBOX, state);
	}

	public void inputToPhoneTextbox(String phone) {
		waitToElementVisible(driver, NewCustomerUI.MOBILE_NUMBER_TEXTBOX);
		sendKeysToElement(driver, NewCustomerUI.MOBILE_NUMBER_TEXTBOX, phone);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, NewCustomerUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, NewCustomerUI.PASSWORD_TEXTBOX, password);
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, NewCustomerUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, NewCustomerUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPinTextbox(String pin) {
		waitToElementVisible(driver, NewCustomerUI.PIN_TEXTBOX);
		sendKeysToElement(driver, NewCustomerUI.PIN_TEXTBOX, pin);
	}

	public void clickToSubmitButton() {
		waitToElementClickable(driver, NewCustomerUI.SUBMIT_BUTTON);
		clickToElement(driver, NewCustomerUI.SUBMIT_BUTTON);
	}

	public String getSuccessMessage() {
		waitToElementVisible(driver, NewCustomerUI.NEW_SUCCESS_MESSAGE);
		return getElementText(driver, NewCustomerUI.NEW_SUCCESS_MESSAGE);
	}



	

}
