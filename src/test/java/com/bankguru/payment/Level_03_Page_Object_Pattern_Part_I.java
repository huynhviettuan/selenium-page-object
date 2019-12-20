package com.bankguru.payment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import bankguru.pageObjects.HomePageObject;
import bankguru.pageObjects.LoginPageObject;
import bankguru.pageObjects.RegisterPageObject;
import commons.AbstractPage;

public class Level_03_Page_Object_Pattern_Part_I extends AbstractPage {

	WebDriver driver;
	WebDriverWait explicitWait;
	String email, loginPageURL, userIDValue, passwordValue;

	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		email = "JohnWick" + randomNumber() + "@gmail.com";
		driver.get("http://demo.guru99.com/v4/");
	}

	@Test
	public void TC_01_RegisterToSystem() {
		loginPage = new LoginPageObject(driver);
		loginPageURL = loginPage.getLoginPageURL();
		loginPage.clickToHereLink();
		registerPage = new RegisterPageObject(driver);
		registerPage.inputEmailIDTextbox(email);
		registerPage.clickSubmitButton();
		userIDValue = registerPage.getUserIDValue();
		passwordValue = registerPage.getPasswordValue();
	}

	@Test
	public void TC_02_LoginToSystem() {
		registerPage.openLoginPage(loginPageURL);
		loginPage.inputToUserIDTextbox(userIDValue);
		loginPage.inputToPasswrodTextbox(passwordValue);
		loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isWelcomeMessageDisplayed());
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
