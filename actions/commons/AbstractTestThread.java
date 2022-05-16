package commons;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTestThread {
	protected enum Browser {
		CHROME, FIREFOX, IE, CHROMEHEADLESS, FIREFOXHEADLESS, EDGE;
	}

	// private WebDriver driver;
	// protected static WebDriver driver;

	private static ThreadLocal<WebDriver> tDriver = new ThreadLocal<WebDriver>();

	private String projectPath = System.getProperty("user.dir");

	public WebDriver getBrowserDriver(String browserName) {

		Browser browser = Browser.valueOf(browserName.toUpperCase());

		switch (browser) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			tDriver.set(new ChromeDriver());
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			tDriver.set(new FirefoxDriver());
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

		// driver.get("https://demo.guru99.com/v4");
		tDriver.get().get("https://facebook.com");
		tDriver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return tDriver.get();
	}
	
	protected void removeBrowserDriver() {
		tDriver.get().quit();
		tDriver.remove();
	}

}
