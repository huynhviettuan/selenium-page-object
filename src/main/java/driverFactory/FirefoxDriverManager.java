package driverFactory;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverManager extends DriverManager {

	@Override
	void createDriver() {
// 		Selenium older		
//		String rootFolder = System.getProperty("user.dir");
//		FirefoxProfile profile = new FirefoxProfile();
//		DesiredCapabilities capability = DesiredCapabilities.firefox();
//		profile.setAcceptUntrustedCertificates(false);
//		profile.setAssumeUntrustedCertificateIssuer(true);
//		profile.setPreference("dom.webnotifications.enabled", false);
//		profile.setPreference("browser.download.folderList", 2);
//		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
//		profile.setPreference("browser.download.manager.showWhenStarting", false);
//		profile.setPreference("browser.download.dir", rootFolder + "\\downloadFiles");
//		profile.setPreference("browser.download.downloadDir", rootFolder + "\\downloadFiles");
//		profile.setPreference("browser.download.defaultFolder", rootFolder + "\\downloadFiles");
//		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/anytext,text/plain,text/html,application/plain");
//		capability = DesiredCapabilities.firefox();
//		capability.setCapability(FirefoxDriver.PROFILE, profile);
//		driver = new FirefoxDriver(capability);

// 		Selenium lastest
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("browser.download.folderList", 2);
		options.addPreference("browser.download.dir", "C:\\Windows\\temp");
		options.addPreference("browser.download.useDownloadDir", true);
		options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		options.addPreference("pdfjs.disabled", true);
		options.addArguments("-private");
		driver = new FirefoxDriver(options);
	}
}