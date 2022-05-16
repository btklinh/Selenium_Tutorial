package browserFactory;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager extends DriverManager {
	
	String projectPath = System.getProperty("user.dir");

	@Override
	protected void createDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
//		ChromeOptions chrome = new ChromeOptions();
//		chrome.setAcceptInsecureCerts(true);
//		chrome.addExtensions(new File(projectPath + "/browserDriver/extension_1_42_4_0.crx"));
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability(ChromeOptions.CAPABILITY, chrome);
//		chrome.merge(capabilities);
//		driver = new ChromeDriver(chrome);		
	}

}
