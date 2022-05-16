package browserFactory;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverManager extends DriverManager {
	
	String projectPath = System.getProperty("user.dir");

	@Override
	protected void createDriver() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
//		FirefoxOptions firefox = new FirefoxOptions();
//		firefox.setAcceptInsecureCerts(true);
//		FirefoxProfile profile = new FirefoxProfile();
//		profile.addExtension(new File(projectPath + "/browserDriver/adblocker_ultimate-3.7.16-an+fx.xpi"));
//		firefox.setProfile(profile);
//		driver = new FirefoxDriver(firefox);
	}

}
