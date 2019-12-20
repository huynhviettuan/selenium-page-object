package driverFactory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeHeadlessDriverManager extends DriverManager {

	@Override
	void createDriver() {
//		Selenium older
//		String projectFolder = System.getProperty("user.dir");
//		System.setProperty("webdriver.chrome.driver", projectFolder + "\\resources\\chromedriver.exe");
//		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("headless");
//		options.addArguments("windown-size = 1366x768");
//		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//		driver = new ChromeDriver(capabilities);

// 		Selenium latest
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("windown-size = 1366x768");
		driver = new ChromeDriver(options);
	}
}
