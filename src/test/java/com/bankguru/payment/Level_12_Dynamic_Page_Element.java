package com.bankguru.payment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import bankguru.pageObjects.HomePageObject;
import bankguru.pageObjects.LoginPageObject;
import bankguru.pageObjects.NewCustomerPageObject;
import commons.AbstractTest;
import commons.PageGeneratorManager;

public class Level_12_Dynamic_Page_Element extends AbstractTest {
	WebDriver driver;
	WebDriverWait explicitWait;

	String userIDValue = "mngr231263", passwordValue = "AbEqyzE";
	String customerName = "AUTOMATION TESTING", dateOfBirth = "1989-01-01", address = "PO Box 912 831 Duis Avenue", city = "Tampa", state = "FL", pin = "451250", mobileNumber = "0782241221", email = "testautotest212@gmail.com", password = "automation";
//	private DriverManager driverManager;
	private LoginPageObject loginPage;
	private NewCustomerPageObject newcustomerPage;
	private HomePageObject homePage;

//	@Parameters("browser")
//	String browserName
	@BeforeClass
	public void initData() {
//		driverManager = DriverManagerFactory.getDriverManager(browserName);
//		driver = driverManager.getDriver();

		String projectFolder = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectFolder + "\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		explicitWait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/v4/");

	}

	@Test
	public void TC_CreateNewCustomerSuccessfull() throws InterruptedException {
		loginPage = PageGeneratorManager.getLoginPage(driver);
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPage.inputToDynamicTextbox(driver, "uid", userIDValue);
		loginPage.inputToDynamicTextbox(driver, "password", passwordValue);
		homePage = loginPage.clickToLoginButton();
		homePage.openDynamicPage(driver, "New Customer");
		newcustomerPage = PageGeneratorManager.getNewCustomerPage(driver);

		newcustomerPage.inputToDynamicTextbox(driver, "name", customerName);
		newcustomerPage.inputToDynamicTextbox(driver, "dob", dateOfBirth);

		newcustomerPage.inputToDynamicTextArea(driver, "addr", address);

		newcustomerPage.inputToDynamicTextbox(driver, "city", city);

		newcustomerPage.inputToDynamicTextbox(driver, "state", state);

		newcustomerPage.inputToDynamicTextbox(driver, "pinno", pin);

		newcustomerPage.inputToDynamicTextbox(driver, "telephoneno", mobileNumber);

		newcustomerPage.inputToDynamicTextbox(driver, "emailid", email);

		newcustomerPage.inputToDynamicTextbox(driver, "password", password);
		newcustomerPage.clickToDynamicButton(driver, "sub");

		verifyTrue(newcustomerPage.isDynamicPageOrMessageDisplay(driver, "Customer Registered Successfully!!!"));

		Assert.assertEquals(homePage.getCustomerNameText(), customerName);
		verifyEquals(newcustomerPage.getDynamicTextInTable(driver, "Customer Name"), customerName);
		verifyEquals(newcustomerPage.getDynamicTextInTable(driver, "Birthdate"), dateOfBirth);
		verifyEquals(newcustomerPage.getDynamicTextInTable(driver, "Address"), address);
		verifyEquals(newcustomerPage.getDynamicTextInTable(driver, "City"), city);
		verifyEquals(newcustomerPage.getDynamicTextInTable(driver, "State"), state);
		verifyEquals(newcustomerPage.getDynamicTextInTable(driver, "Pin"), pin);
		verifyEquals(newcustomerPage.getDynamicTextInTable(driver, "Mobile No."), mobileNumber);
		verifyEquals(newcustomerPage.getDynamicTextInTable(driver, "Email"), email);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
