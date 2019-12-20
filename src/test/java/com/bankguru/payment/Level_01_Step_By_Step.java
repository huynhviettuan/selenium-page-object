package com.bankguru.payment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_01_Step_By_Step {

	WebDriver driver;
	WebDriverWait explicitWait;
	String email, loginPageURL, userIDValue, passwordValue;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 20);
		driver.get("http://demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		email = "JohnWick" + randomNumber() + "@gmail.com";
	}

	@Test
	public void TC_01_RegisterToSystem() {
		loginPageURL = driver.getCurrentUrl();
		driver.findElement(By.xpath("//a[contains(text(),'here')]")).click();
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@name='emailid']")));
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		userIDValue = driver.findElement(By.xpath("//td[contains(text(),'User ID :')]/following-sibling::td")).getText();
		passwordValue = driver.findElement(By.xpath("//td[contains(text(),'Password :')]/following-sibling::td")).getText();

	}

	@Test
	public void TC_02_LoginToSystem() {
		driver.get(loginPageURL);
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userIDValue);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passwordValue);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]")).isDisplayed());

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
