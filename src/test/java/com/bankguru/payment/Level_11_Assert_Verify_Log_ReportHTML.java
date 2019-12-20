package com.bankguru.payment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import bankguru.pageObjects.HomePageObject;
import bankguru.pageObjects.LoginPageObject;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import driverFactory.DriverManager;
import driverFactory.DriverManagerFactory;

public class Level_11_Assert_Verify_Log_ReportHTML extends AbstractTest {

	WebDriver driver;
	WebDriverWait explicitWait;
	String email, loginPageURL, userIDValue, passwordValue;
	private DriverManager driverManager;
	private LoginPageObject loginPage;
	private HomePageObject homePage;

	@Parameters("browser")
	@BeforeClass
	public void initData(String browserName) {
		driverManager = DriverManagerFactory.getDriverManager(browserName);
		driver = driverManager.getDriver();

		explicitWait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/v4/");
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}

	@Test(description = "Login To System")
	public void TC_01_LoginToSystem() {
		log.info("Log_01_LoginToSystem - Step 01: Verify EmailID textbox is not displayed at Login Page");
		verifyFalse(loginPage.isEmailIDTextboxAtRegisterPageUndisplayed());
		log.info("Log_01_LoginToSystem - Step 02: Verify File Upload Link displayed at Login Page");
		verifyFalse(loginPage.isFileUploadLinkisdisplay());
		log.info("Log_01_LoginToSystem - Step 03: Input UserID and Password Textbox");
		loginPage.inputToUserIDTextbox("mngr231263");
		loginPage.inputToPasswrodTextbox("AbEqyzE");
		log.info("Log_01_LoginToSystem - Step 04: Click To Login Button");
		homePage = loginPage.clickToLoginButton();
		log.info("Log_01_LoginToSystem - Step 05: Verify Welcome Message displayed at Home Page");
		verifyFalse(homePage.isWelcomeMessageDisplayed());
		closeBrowserAndDriver(driver);
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}
}
