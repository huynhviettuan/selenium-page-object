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

import bankguru.pageFactory.HomePageFactory;
import bankguru.pageFactory.LoginPageFactory;
import bankguru.pageFactory.RegisterPageFactory;
import commons.AbstractPage;

public class Level_04_Page_Factory extends AbstractPage {

	private WebDriver driver;
	WebDriverWait explicitWait;
	String email, loginPageURL, userIDValue, passwordValue;

	LoginPageFactory loginPage;
	RegisterPageFactory registerPage;
	HomePageFactory homePage;

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
		loginPage = new LoginPageFactory(driver);
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPageURL = loginPage.getLoginPageURL();
		loginPage.clickToHereLink();
		registerPage = new RegisterPageFactory(driver);
		Assert.assertTrue(registerPage.isRegisterPageDisplayed());
		registerPage.inputToEmailIDTextbox(email);
		registerPage.clickToLoginButton();
		userIDValue = registerPage.getUserIDInfor();
		passwordValue = registerPage.getPasswordInfor();
	}

	@Test
	public void TC_02_LoginToSystem() {
		registerPage.openLoginPage(loginPageURL);
		loginPage = new LoginPageFactory(driver);
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPage.inputToUserIDTextbox(userIDValue);
		loginPage.inputToPasswordTextbox(passwordValue);
		loginPage.clickToLoginButton();
		homePage = new HomePageFactory(driver);
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
