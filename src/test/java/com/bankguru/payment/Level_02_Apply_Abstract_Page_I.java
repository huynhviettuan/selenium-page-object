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

public class Level_02_Apply_Abstract_Page_I {

	WebDriver driver;
	WebDriverWait explicitWait;
	String email, loginPageURL, userIDValue, passwordValue;
	public AbstractPage abstractPage;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 20);
		abstractPage = new AbstractPage();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		email = "JohnWick" + randomNumber() + "@gmail.com";
		abstractPage.openAnyURL(driver, "http://demo.guru99.com/v4/");
	}

	@Test
	public void TC_01_RegisterToSystem() {
		loginPageURL = abstractPage.getCurrentPageURL(driver);

		abstractPage.clickToElement(driver, "//a[contains(text(),'here')]");

		abstractPage.waitToElementVisible(driver, "//input[@name='emailid']");

		abstractPage.sendkeyToElement(driver, "//input[@name='emailid']", email);

		abstractPage.clickToElement(driver, "//input[@name='btnLogin']");

		userIDValue = abstractPage.getTextElement(driver, "//td[contains(text(),'User ID :')]/following-sibling::td");

		passwordValue = abstractPage.getTextElement(driver, "//td[contains(text(),'Password :')]/following-sibling::td");
	}

	@Test
	public void TC_02_LoginToSystem() {
		abstractPage.openAnyURL(driver, loginPageURL);

		abstractPage.sendkeyToElement(driver, "//input[@name='uid']", userIDValue);

		abstractPage.sendkeyToElement(driver, "//input[@name='password']", passwordValue);

		abstractPage.clickToElement(driver, "//input[@name='btnLogin']");

		Assert.assertTrue(abstractPage.isElementDisplayed(driver, "//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]"));
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
