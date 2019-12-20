package driverFactory;

import java.util.Collections;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager extends DriverManager {

	@Override
	void createDriver() {

// 		Selenium older patch + manual setup chrome driver
//		String projectFolder = System.getProperty("user.dir");
//		System.setProperty("webdriver.chrome.driver", projectFolder + "\\resources\\chromedriver.exe");
//		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--incognito");
//		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//		driver = new ChromeDriver(capabilities);

//		Options for chrome		
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--incognito");
//		options.addArguments("--disable-extensions");
//		options.addArguments("disable-inforbars");
//		options.addArguments("start-maximized");
//		options.addArguments("--disable-notifications");
//		options.addArguments("--incognito");
//		driver = new ChromeDriver(options);

// 		Setup options for Chrome latest		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("--disable-extensions");
		options.addArguments("start-maximized");
		options.addArguments("--disable-notifications");
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		driver = new ChromeDriver(options);
	}
}
