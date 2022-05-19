package commons;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.apache.commons.
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractTest {
	protected enum Browser {
		CHROME, FIREFOX, IE, CHROMEHEADLESS, FIREFOXHEADLESS, EDGE;
	}

	private static ThreadLocal<WebDriver> tDriver = new ThreadLocal<WebDriver>();
	
	//khai bao
	protected final Log log;
	
	//khoi tao
	protected AbstractTest() {
		log = LogFactory.getLog(getClass());
	}

	private String projectPath = System.getProperty("user.dir");

	public WebDriver getBrowserDriver(String browserName) {

		Browser browser = Browser.valueOf(browserName.toUpperCase());

		switch (browser) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			ChromeOptions chrome = new ChromeOptions();
			chrome.setAcceptInsecureCerts(true);
			chrome.addExtensions(new File(projectPath + "/browserDriver/extension_1_42_4_0.crx"));
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, chrome);
			chrome.merge(capabilities);
			tDriver.set(new ChromeDriver(chrome));
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefox = new FirefoxOptions();
			firefox.setAcceptInsecureCerts(true);
			FirefoxProfile profile = new FirefoxProfile();
			profile.addExtension(new File(projectPath + "/browserDriver/adblocker_ultimate-3.7.16-an+fx.xpi"));
			firefox.setProfile(profile);
			tDriver.set(new FirefoxDriver(firefox));
			break;
		case CHROMEHEADLESS:
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOpt = new ChromeOptions();
			chromeOpt.addArguments("headless");
			chromeOpt.addArguments("window-size=1366x768");
			tDriver.set(new ChromeDriver(chromeOpt));
			break;
		case FIREFOXHEADLESS:
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOpt = new FirefoxOptions();
			firefoxOpt.addArguments("-headless");
			firefoxOpt.addArguments("window-size=1366x768");
			tDriver.set(new FirefoxDriver(firefoxOpt));
			break;
		default:
			throw new RuntimeException("Please choose browser name");
		}

		tDriver.get().get(GlobalConstants.BANK_DEV_URL);
		tDriver.get().manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		return tDriver.get();
	}

	public WebDriver getBrowserDriver(String browserName, String appURL) {

		Browser browser = Browser.valueOf(browserName.toUpperCase());

		switch (browser) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
//			ChromeOptions chrome = new ChromeOptions();
//			chrome.setAcceptInsecureCerts(true);
//			chrome.addExtensions(new File(projectPath + "/browserDriver/extension_1_42_4_0.crx"));
//			DesiredCapabilities capabilities = new DesiredCapabilities();
//			capabilities.setCapability(ChromeOptions.CAPABILITY, chrome);
//			chrome.merge(capabilities);
			tDriver.set(new ChromeDriver());
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefox = new FirefoxOptions();
			firefox.setAcceptInsecureCerts(true);
			FirefoxProfile profile = new FirefoxProfile();
			profile.addExtension(new File(projectPath + "/browserDriver/adblocker_ultimate-3.7.16-an+fx.xpi"));
			firefox.setProfile(profile);
			tDriver.set(new FirefoxDriver(firefox));
			break;
		case CHROMEHEADLESS:
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOpt = new ChromeOptions();
			chromeOpt.addArguments("headless");
			chromeOpt.addArguments("window-size=1366x768");
			tDriver.set(new ChromeDriver(chromeOpt));
			break;
		case FIREFOXHEADLESS:
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOpt = new FirefoxOptions();
			firefoxOpt.addArguments("-headless");
			firefoxOpt.addArguments("window-size=1366x768");
			tDriver.set(new FirefoxDriver(firefoxOpt));
			break;
		default:
			throw new RuntimeException("Please choose browser name");
		}

		tDriver.get().get(appURL);
		tDriver.get().manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		return tDriver.get();
	}

	protected void removeBrowserDriver() {
		tDriver.get().quit();
		tDriver.remove();
	}
	
	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {		
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {			
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			
		} catch (Throwable e) {
			pass = false;			
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}
}
