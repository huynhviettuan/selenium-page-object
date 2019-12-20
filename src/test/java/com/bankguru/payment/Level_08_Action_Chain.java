package com.bankguru.payment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import bankguru.pageObjects.DeleteCustomerPageObject;
import bankguru.pageObjects.EditCustomerPageObject;
import bankguru.pageObjects.HomePageObject;
import bankguru.pageObjects.LoginPageObject;
import bankguru.pageObjects.NewCustomerPageObject;
import bankguru.pageObjects.RegisterPageObject;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import driverFactory.DriverManager;
import driverFactory.DriverManagerFactory;

public class Level_08_Action_Chain extends AbstractTest {

	WebDriver driver;
	WebDriverWait explicitWait;
	String email, loginPageURL, userIDValue, passwordValue;
	private DriverManager driverManager;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private NewCustomerPageObject newCustomerPage;
	private EditCustomerPageObject editCustomerPage;
	private DeleteCustomerPageObject deleteCustomerPage;

	@Parameters("browser")
	@BeforeClass
	public void initData(String browserName) {
		driverManager = DriverManagerFactory.getDriverManager(browserName);
		driver = driverManager.getDriver();

		explicitWait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		email = "JohnWick" + randomNumber() + "@gmail.com";
		driver.get("http://demo.guru99.com/v4/");

	}

	@Test
	public void TC_01_RegisterToSystem() {
		loginPage = PageGeneratorManager.getLoginPage(driver);
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPageURL = loginPage.getLoginPageURL();
		registerPage = loginPage.clickToHereLink();
		registerPage.isRegisterPageDisplayed();
		registerPage.inputEmailIDTextbox(email);
		registerPage.clickSubmitButton();
		userIDValue = registerPage.getUserIDValue();
		passwordValue = registerPage.getPasswordValue();
	}

	@Test
	public void TC_02_LoginToSystem() {
		loginPage = registerPage.openLoginPage(loginPageURL);
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPage.inputToUserIDTextbox(userIDValue);
		loginPage.inputToPasswrodTextbox(passwordValue);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isWelcomeMessageDisplayed());
	}

	@Test
	public void TC_03_WebDriverLifeCycle() {
		newCustomerPage = homePage.openNewCustomerPage(driver);
		editCustomerPage = newCustomerPage.openEditCustomerPage(driver);
		deleteCustomerPage = editCustomerPage.openDeleteCustomerPage(driver);
		deleteCustomerPage.openDynamicPage(driver, "");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}
}
