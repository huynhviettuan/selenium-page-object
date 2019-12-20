package bankguru.pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.pageUIs.HomePageUI;
import commons.AbstractPage;
import commons.PageGeneratorManager;

public class HomePageObject extends AbstractPage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isWelcomeMessageDisplayed() {
		waitToElementVisible(driver, HomePageUI.WELCOME_MESSAGE_TEXT);
		return isElementDisplayed(driver, HomePageUI.WELCOME_MESSAGE_TEXT);
	}

	public boolean isCustomerRegisterSuccessDisplayed() {
		waitToElementVisible(driver, HomePageUI.SUCCESS_MESSAGE);
		return isElementDisplayed(driver, HomePageUI.SUCCESS_MESSAGE);
	}

	public boolean isEditCustomerSuccessDisplayed() {
		waitToElementVisible(driver, HomePageUI.EDIT_CUSTOMER_SUCCESS_MSG);
		return isElementDisplayed(driver, HomePageUI.EDIT_CUSTOMER_SUCCESS_MSG);
	}

	public String getCustomerNameText() {
		waitToElementVisible(driver, HomePageUI.CUSTOMER_NAME_TEXT);
		return getTextElement(driver, HomePageUI.CUSTOMER_NAME_TEXT);
	}

	public String getBirthdateText() {
		waitToElementVisible(driver, HomePageUI.DATE_OF_BIRTH_TEXT);
		return getTextElement(driver, HomePageUI.DATE_OF_BIRTH_TEXT);
	}

	public String getAddressText() {
		waitToElementVisible(driver, HomePageUI.ADDRESS_TEXT);
		return getTextElement(driver, HomePageUI.ADDRESS_TEXT);
	}

	public String getCityText() {
		waitToElementVisible(driver, HomePageUI.CITY_TEXT);
		return getTextElement(driver, HomePageUI.CITY_TEXT);
	}

	public String getStateText() {
		waitToElementVisible(driver, HomePageUI.STATE_TEXT);
		return getTextElement(driver, HomePageUI.STATE_TEXT);
	}

	public String getPinText() {
		waitToElementVisible(driver, HomePageUI.PIN_TEXT);
		return getTextElement(driver, HomePageUI.PIN_TEXT);
	}

	public String getMobileText() {
		waitToElementVisible(driver, HomePageUI.MOBILE_TEXT);
		return getTextElement(driver, HomePageUI.MOBILE_TEXT);
	}

	public String getEmailText() {
		waitToElementVisible(driver, HomePageUI.EMAIL_TEXT);
		return getTextElement(driver, HomePageUI.EMAIL_TEXT);
	}

	public LoginPageObject clickToLogOutLink() {
		waitToElementVisible(driver, HomePageUI.LOG_OUT_LINK);
		clickToElement(driver, HomePageUI.LOG_OUT_LINK);
		waitToAlertPresence(driver);
		acceptAlert(driver);
		return PageGeneratorManager.getLoginPage(driver);
	}
}
