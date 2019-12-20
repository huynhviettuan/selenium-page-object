package com.bankguru.payment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import bankguru.pageObjects.LoginPageObject;
import commons.AbstractTest;
import commons.PageGeneratorManager;

public class Level_10_ElementUndisplayed extends AbstractTest {

	WebDriver driver;
	WebDriverWait explicitWait;
	String email, loginPageURL, userIDValue, passwordValue;
	private LoginPageObject loginPage;

	@BeforeClass
	public void initData() {
		String projectFolder = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectFolder + "\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		explicitWait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		email = "JohnWick" + randomNumber() + "@gmail.com";
		driver.get("http://demo.guru99.com/v4/");

	}

	@Test
	public void TC_01_RegisterToSystem() {
		loginPage = PageGeneratorManager.getLoginPage(driver);
		Assert.assertFalse(loginPage.isEmailIDTextboxAtRegisterPageUndisplayed());
		Assert.assertFalse(loginPage.isFileUploadLinkisdisplay());

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
