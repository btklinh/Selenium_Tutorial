package browserFactory;

public class DriverManagerFactory {

	protected enum Browser {
		CHROME, FIREFOX, IE, CHROMEHEADLESS, FIREFOXHEADLESS, EDGE;
	}

	public static DriverManager getBrowserDriver(String browserName) {

		Browser browser = Browser.valueOf(browserName.toUpperCase());
		DriverManager driverManager;
		switch (browser) {
		case CHROME:
			driverManager = new ChromeDriverManager();
			break;
		case FIREFOX:
			driverManager = new FirefoxDriverManager();
			break;
		case CHROMEHEADLESS:
			driverManager = new ChromeHeadlessDriverManager();
			break;
		case FIREFOXHEADLESS:
			driverManager = new FirefoxHeadlessDriverManager();
			break;
		default:
			throw new RuntimeException("Please choose browser name");
		}
		return driverManager;
	}

}
