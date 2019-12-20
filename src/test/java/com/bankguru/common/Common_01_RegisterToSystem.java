package com.bankguru.common;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import bankguru.pageObjects.LoginPageObject;
import bankguru.pageObjects.RegisterPageObject;
import commons.AbstractTest;
import commons.PageGeneratorManager;

public class Common_01_RegisterToSystem extends AbstractTest {
	WebDriver driver;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	public static String USERNAME, PASSWORD;
	String email;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = openMultiBrowser(browserName);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		email = "autotest" + randomNumber() + "@gmail.com";

		log.info("Register - Step 01 : Verify Login Page is displayed");
		Assert.assertTrue(loginPage.isLoginFormDisplayed());

		log.info("Register - Step 02 : Click To Here Link");
		registerPage = loginPage.clickToHereLink();

		log.info("Register - Step 03 : Input To Email ID Textbox");
		registerPage.inputEmailIDTextbox(email);

		log.info("Register - Step 04 : Click Submit Button");
		registerPage.clickSubmitButton();

		log.info("Register - Step 05 : Get UserID and Password Information");
		USERNAME = registerPage.getUserIDValue();
		PASSWORD = registerPage.getPasswordValue();
		driver.quit();
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}
}
