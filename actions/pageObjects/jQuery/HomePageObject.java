package pageObjects.jQuery;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.jQuery.HomePageUI;

public class HomePageObject extends AbstractPage {

	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void inputToTextBoxByColumnName(String columnName, String value) {
		waitToElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_COLUMN_NAME, columnName);
		sendKeysToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_COLUMN_NAME, value, columnName);
	}

	public void navigateToPageByPageNumber(String pageNumber) {
		waitToElementClickable(driver, HomePageUI.DYNAMIC_PAGING_BY_PAGE_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.DYNAMIC_PAGING_BY_PAGE_NUMBER, pageNumber);
	}

	public boolean isPageActivedByPageNumber(String pageNumber) {
		waitToElementVisible(driver, HomePageUI.DYNAMIC_PAGE_ACTIVED_BY_PAGE_NUMBER, pageNumber);
		return isControlDisplayed(driver, HomePageUI.DYNAMIC_PAGE_ACTIVED_BY_PAGE_NUMBER, pageNumber);
	}

	public void clickToDeleteIconByCountryName(String countryName) {
		waitToElementClickable(driver, HomePageUI.DYNAMIC_DELETE_ICON_BY_COUNTRY_NAME, countryName);
		clickToElement(driver, HomePageUI.DYNAMIC_DELETE_ICON_BY_COUNTRY_NAME, countryName);
	}

	public void clickToEditIconByCountryName(String countryName) {
		waitToElementClickable(driver, HomePageUI.DYNAMIC_EDIT_ICON_BY_COUNTRY_NAME, countryName);
		clickToElement(driver, HomePageUI.DYNAMIC_EDIT_ICON_BY_COUNTRY_NAME, countryName);
	}

	public boolean isAllInfoDisplayed(String females, String country, String males, String total) {
		waitToElementVisible(driver, HomePageUI.DYNAMIC_ALL_INFO_AT_ROW, females, country, males, total);
		return isControlDisplayed(driver, HomePageUI.DYNAMIC_ALL_INFO_AT_ROW, females, country, males, total);
	}

	public void inputToTextboxByColumnNameAtRow(String columnName, String rowNumber, String value) {
		waitToElementVisible(driver, HomePageUI.DYNAMIC_INDEX_BY_COLUMN_NAME, columnName);
		String columnNameIndex = String.valueOf(countElementSize(driver, HomePageUI.DYNAMIC_INDEX_BY_COLUMN_NAME, columnName) + 1);
		waitToElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_COLUMN_AND_ROW_INDEX, rowNumber, columnNameIndex);
		sendKeysToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_COLUMN_AND_ROW_INDEX, value, rowNumber, columnNameIndex);
	}

}
