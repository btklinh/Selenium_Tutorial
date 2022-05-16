package browserFactory;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxHeadlessDriverManager extends DriverManager {

	//String projectPath = System.getProperty("user.dir");

	@Override
	protected void createDriver() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions firefoxOpt = new FirefoxOptions();
		firefoxOpt.addArguments("-headless");
		firefoxOpt.addArguments("window-size=1366x768");
		driver = new FirefoxDriver(firefoxOpt);
	}

}
