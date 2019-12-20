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

import commons.AbstractPage;

public class Level_02_Apply_Abstract_Page_II extends AbstractPage {

	WebDriver driver;
	WebDriverWait explicitWait;
	String email, loginPageURL, userIDValue, passwordValue;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 20);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		email = "JohnWick" + randomNumber() + "@gmail.com";
		openAnyURL(driver, "http://demo.guru99.com/v4/");
	}

	@Test
	public void TC_01_RegisterToSystem() {
		loginPageURL = getCurrentPageURL(driver);

		clickToElement(driver, "//a[contains(text(),'here')]");

		waitToElementVisible(driver, "//input[@name='emailid']");

		sendkeyToElement(driver, "//input[@name='emailid']", email);

		clickToElement(driver, "//input[@name='btnLogin']");

		userIDValue = getTextElement(driver, "//td[contains(text(),'User ID :')]/following-sibling::td");

		passwordValue = getTextElement(driver, "//td[contains(text(),'Password :')]/following-sibling::td");
	}

	@Test
	public void TC_02_LoginToSystem() {
		openAnyURL(driver, loginPageURL);

		sendkeyToElement(driver, "//input[@name='uid']", userIDValue);

		sendkeyToElement(driver, "//input[@name='password']", passwordValue);

		clickToElement(driver, "//input[@name='btnLogin']");

		Assert.assertTrue(isElementDisplayed(driver, "//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]"));
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
