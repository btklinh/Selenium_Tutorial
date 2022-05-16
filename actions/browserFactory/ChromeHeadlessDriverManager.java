package browserFactory;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeHeadlessDriverManager extends DriverManager {
	
	String projectPath = System.getProperty("user.dir");

	@Override
	protected void createDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOpt = new ChromeOptions();
		chromeOpt.addArguments("headless");
		chromeOpt.addArguments("window-size=1366x768");
		driver = new ChromeDriver(chromeOpt);
	}

}
