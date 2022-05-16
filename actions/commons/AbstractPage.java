package commons;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.bankGuru.DepositPageObject;
import pageObjects.bankGuru.EditCustomerPageObject;
import pageObjects.bankGuru.FundTransferPageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.NewCustomerPageObject;
import pageUI.bankGuru.AbstractPageUI;

public class AbstractPage {

	public void openUrl(WebDriver driver, String url) {
//		this.driver = driver;
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
	}

	public String getPageTitle(WebDriver driver) {
//		this.driver = driver;
		return driver.getTitle();
	}

	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void waitToAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelAlert(WebDriver driver) {
		alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void sendKeyToAlert(WebDriver driver, String value) {
		alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}

	public String getTextInAlert(WebDriver driver) {
		alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	public By byXpath(String locator) {
		return By.xpath(locator);
	}

	public WebElement find(WebDriver driver, String locator) {
		return driver.findElement(byXpath(locator));
	}

	public List<WebElement> finds(WebDriver driver, String locator) {
		return driver.findElements(byXpath(locator));
	}

	public String castToRestParameter(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		return locator;
	}

	public void clickToElement(WebDriver driver, String locator) {
		find(driver, locator).click();
	}

	public void clickToElement(WebDriver driver, String locator, String... values) {
		find(driver, castToRestParameter(locator, values)).click();
	}

	public void sendKeysToElement(WebDriver driver, String locator, String value) {
		find(driver, locator).clear();
		find(driver, locator).sendKeys(value);
	}

	public void sendKeysToElement(WebDriver driver, String locator, String value, String... values) {
		find(driver, castToRestParameter(locator, values)).clear();
		find(driver, castToRestParameter(locator, values)).sendKeys(value);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String itemValue) {
		select = new Select(find(driver, locator));
		select.selectByVisibleText(itemValue);
	}

	public String getFirstSelectedItemInDropdown(WebDriver driver, String locator) {
		select = new Select(find(driver, locator));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		select = new Select(find(driver, locator));
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
		find(driver, parentLocator);
		sleepInSecond(1);

		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXpath(childItemLocator)));
		List<WebElement> allItems = finds(driver, childItemLocator);

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}

	public void sleepInSecond(long timeout) {

		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		return find(driver, locator).getAttribute(attributeName);
	}

	public String getElementText(WebDriver driver, String locator) {
		return find(driver, locator).getText();
	}

	public int countElementSize(WebDriver driver, String locator) {
		return finds(driver, locator).size();
	}

	public int countElementSize(WebDriver driver, String locator, String... values) {
		return finds(driver, castToRestParameter(locator, values)).size();
	}

	public void checkToCheckbox(WebDriver driver, String locator) {
		if (!find(driver, locator).isSelected()) {
			find(driver, locator).click();
		}
	}

	public void uncheckToCheckbox(WebDriver driver, String locator) {
		if (find(driver, locator).isSelected()) {
			find(driver, locator).click();
		}
	}

	public boolean isControlDisplayed(WebDriver driver, String locator) {
		try {
			return find(driver, locator).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isControlUndisplayed(WebDriver driver, String locator) {
		overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		elements = finds(driver, locator);
		overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
		if (elements.size() == 0) {

			System.out.println("Element not in DOM");
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but not visible / displayed");
			return true;
		} else {

			System.out.println("Element in DOM and visible");
			return false;
		}

	}

	public boolean isControlDisplayed(WebDriver driver, String locator, String... values) {
		return find(driver, castToRestParameter(locator, values)).isDisplayed();
	}

	public boolean isControlEnabled(WebDriver driver, String locator) {
		return find(driver, locator).isEnabled();
	}

	public boolean isControlSelected(WebDriver driver, String locator) {
		return find(driver, locator).isSelected();
	}

	public void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(find(driver, locator));
	}

	public void switchToDefaultPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(find(driver, locator)).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(find(driver, locator)).perform();
	}

	public void hoverToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(find(driver, locator)).perform();
	}

	public void dragAndDropToElement(WebDriver driver, String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(find(driver, sourceLocator), find(driver, targetLocator)).perform();
	}

	public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(find(driver, locator), key).perform();
	}

	public Object executeForBrowser(WebDriver driver, String javaScript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = find(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", find(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", find(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", find(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", find(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver, int timeout) {
		explicitWait = new WebDriverWait(driver, timeout);
		jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", find(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", find(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitToElementPresence(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(byXpath(locator)));
	}

	public void waitToElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(locator)));
	}

	public void waitToElementVisible(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(castToRestParameter(locator, values))));
	}

	public void waitToElementInvisible(WebDriver driver, String locator) {
		try {
			// co gia tri khi co trong dom
			explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
			
			overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
			explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(locator)));
			overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void waitToElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(locator)));
	}

	public void waitToElementClickable(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(castToRestParameter(locator, values))));
	}

	/* Open Dynamic Page Menu */
	/* 1 - So luong page it (15-20 page) */
	public AbstractPage openMenuPageByName(WebDriver driver, String pageName) {
		waitToElementClickable(driver, AbstractPageUI.DYNAMIC_MENU_PAGE_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_MENU_PAGE_LINK, pageName);
		if (pageName.equals("New Customer")) {
			return PageGeneratorManager.getNewCustomerPage(driver);
		} else if (pageName.equals("Edit Customer")) {
			return PageGeneratorManager.getEditCustomerPage(driver);
		} else if (pageName.equals("Deposit")) {
			return PageGeneratorManager.getDepositPage(driver);
		} else if (pageName.equals("Fund Transfer")) {
			return PageGeneratorManager.getFundTransferPage(driver);
		} else {
			throw new RuntimeException();
		}

	}

	/* 2 - So luong page nhieu */
	public void openMenuPagesByName(WebDriver driver, String pageName) {
		waitToElementClickable(driver, AbstractPageUI.DYNAMIC_MENU_PAGE_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_MENU_PAGE_LINK, pageName);

	}

//	
//
	// Open Bank guru page
	public NewCustomerPageObject openNewCustomerPage(WebDriver driver) {
		waitToElementClickable(driver, AbstractPageUI.NEW_CUSTOMER_LINK);
		clickToElement(driver, AbstractPageUI.NEW_CUSTOMER_LINK);
		return PageGeneratorManager.getNewCustomerPage(driver);
	}

	public DepositPageObject openDepositPage(WebDriver driver) {
		waitToElementClickable(driver, AbstractPageUI.DEPOSIT_PAGE_LINK);
		clickToElement(driver, AbstractPageUI.DEPOSIT_PAGE_LINK);
		return PageGeneratorManager.getDepositPage(driver);
	}

	public EditCustomerPageObject openEditCustomerPage(WebDriver driver) {
		waitToElementClickable(driver, AbstractPageUI.EDIT_CUSTOMER_LINK);
		clickToElement(driver, AbstractPageUI.EDIT_CUSTOMER_LINK);
		return PageGeneratorManager.getEditCustomerPage(driver);
	}

	public FundTransferPageObject openFundTransferPage(WebDriver driver) {
		waitToElementClickable(driver, AbstractPageUI.FUND_TRANSFER_LINK);
		clickToElement(driver, AbstractPageUI.FUND_TRANSFER_LINK);
		return PageGeneratorManager.getFundTransferPage(driver);
	}

	public LoginPageObject clickToLogoutLink(WebDriver driver) {
		waitToElementClickable(driver, AbstractPageUI.LOG_OUT_LINK);
		clickToElementByJS(driver, AbstractPageUI.LOG_OUT_LINK);
		waitToAlertPresence(driver);
		acceptAlert(driver);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public void overrideGlobalTimeout(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	WebDriver driver;
	private Alert alert;
	private Select select;
	private JavascriptExecutor jsExecutor;
	private Actions action;
	private List<WebElement> elements;
	private WebDriverWait explicitWait;
}
