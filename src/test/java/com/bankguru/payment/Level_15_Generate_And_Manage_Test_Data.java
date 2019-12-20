package com.bankguru.payment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.testdata.Customer;

import bankguru.pageObjects.HomePageObject;
import bankguru.pageObjects.LoginPageObject;
import bankguru.pageObjects.NewCustomerPageObject;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import driverFactory.DriverManager;
import driverFactory.DriverManagerFactory;

public class Level_15_Generate_And_Manage_Test_Data extends AbstractTest {

	@Parameters("browser")
	@BeforeClass
	public void initData(String browserName) {
		driverManager = DriverManagerFactory.getDriverManager(browserName);
		driver = driverManager.getDriver();

		userIDValue = "mngr237972";
		passwordValue = "yzahYry";

		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPage.inputToDynamicTextbox(driver, "uid", userIDValue);
		loginPage.inputToDynamicTextbox(driver, "password", passwordValue);
		homePage = loginPage.clickToLoginButton();
		homePage.openDynamicPage(driver, "New Customer");
	}

	@Test(description = "Create New Customer")
	public void TC_01_CreateNewCustomerSuccessfull() {
		log.info("TC_01_CreateNewCustomer - Step 01 : Open New Customer page");
		newcustomerPage = PageGeneratorManager.getNewCustomerPage(driver);

		log.info("TC_01_CreateNewCustomer - Step 02 : Input data to maddatory/required fields");
		newcustomerPage.inputToDynamicTextbox(driver, "name", Customer.NewCustomer.CUSTOMER_NAME);
		newcustomerPage.inputToDynamicTextbox(driver, "dob", Customer.NewCustomer.DATE_OF_BIRTH);
		newcustomerPage.inputToDynamicTextArea(driver, "addr", Customer.NewCustomer.ADDRESS);
		newcustomerPage.inputToDynamicTextbox(driver, "city", Customer.NewCustomer.CITY);
		newcustomerPage.inputToDynamicTextbox(driver, "state", Customer.NewCustomer.STATE);
		newcustomerPage.inputToDynamicTextbox(driver, "pinno", Customer.NewCustomer.PIN);
		newcustomerPage.inputToDynamicTextbox(driver, "telephoneno", Customer.NewCustomer.PHONE);
		newcustomerPage.inputToDynamicTextbox(driver, "emailid", Customer.NewCustomer.EMAIL);
		newcustomerPage.inputToDynamicTextbox(driver, "password", Customer.NewCustomer.PASSWORD);

		log.info("TC_01_CreateNewCustomer - Step 03 : Click to Submit Button");
		newcustomerPage.clickToDynamicButton(driver, "sub");

		log.info("TC_01_CreateNewCustomer - Step 04 : Verify success message is displayed");
		verifyTrue(newcustomerPage.isDynamicPageOrMessageDisplay(driver, "Customer Registered Successfully!!!"));

		log.info("TC_01_CreateNewCustomer - Step 05 : Verify New Customer created success");
		verifyEquals(newcustomerPage.getDynamicTextInTable(driver, "Customer Name"), Customer.NewCustomer.CUSTOMER_NAME);
		verifyEquals(newcustomerPage.getDynamicTextInTable(driver, "Birthdate"), Customer.NewCustomer.DATE_OF_BIRTH);
		verifyEquals(newcustomerPage.getDynamicTextInTable(driver, "Address"), Customer.NewCustomer.ADDRESS);
		verifyEquals(newcustomerPage.getDynamicTextInTable(driver, "City"), Customer.NewCustomer.CITY);
		verifyEquals(newcustomerPage.getDynamicTextInTable(driver, "State"), Customer.NewCustomer.STATE);
		verifyEquals(newcustomerPage.getDynamicTextInTable(driver, "Pin"), Customer.NewCustomer.PIN);
		verifyEquals(newcustomerPage.getDynamicTextInTable(driver, "Mobile No."), Customer.NewCustomer.PHONE);
		verifyEquals(newcustomerPage.getDynamicTextInTable(driver, "Email"), Customer.NewCustomer.EMAIL);

	}

	public void cleanData() {
		closeBrowserAndDriver(driver);
	}

	WebDriver driver;
	WebDriverWait explicitWait;

	private String userIDValue;
	private String passwordValue;
	private DriverManager driverManager;
	private LoginPageObject loginPage;
	private NewCustomerPageObject newcustomerPage;
	private HomePageObject homePage;

}
