package bankguru.pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.pageUIs.NewCustomerPageUI;
import commons.AbstractPage;
import commons.PageGeneratorManager;

public class NewCustomerPageObject extends AbstractPage {
	private WebDriver driver;

	public NewCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isNewCustomerPageDisplayed() {
		waitToElementVisible(driver, NewCustomerPageUI.NEW_CUSTOMER_TITLE);
		return isElementDisplayed(driver, NewCustomerPageUI.NEW_CUSTOMER_TITLE);
	}

	public void inputToCustomerNameTextBox(String customerName) {
		waitToElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, customerName);
	}

	public void checkToGenderRadio(String genderValue) {
		if (genderValue == "m") {
			waitToElementVisible(driver, NewCustomerPageUI.MALE_GENDER_RADIO);
			clickToElement(driver, NewCustomerPageUI.MALE_GENDER_RADIO);
		} else if (genderValue == "f") {
			waitToElementVisible(driver, NewCustomerPageUI.FEMALE_GENDER_RADIO);
			clickToElement(driver, NewCustomerPageUI.FEMALE_GENDER_RADIO);
		}
	}

	public void inputToDateOfBirthTextBox(String dateOfBirth) throws InterruptedException {

		waitToElementVisible(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX);
		removeAttributeInDOM(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX, "type");
		sendkeyToElement(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX, dateOfBirth);
	}

	public void inputToAddressTextArea(String address) {
		waitToElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		sendkeyToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA, address);
	}

	public void inputToCityTextBox(String city) {
		waitToElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.CITY_TEXTBOX, city);
	}

	public void inputToStateTextBox(String state) {
		waitToElementVisible(driver, NewCustomerPageUI.STATE_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.STATE_TEXTBOX, state);
	}

	public void inputToPinTextBox(String pin) {
		waitToElementVisible(driver, NewCustomerPageUI.PIN_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.PIN_TEXTBOX, pin);
	}

	public void inputToMobileTextBox(String mobileNumber) {
		waitToElementVisible(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX, mobileNumber);
	}

	public void inputToEmailTextBox(String email) {
		waitToElementVisible(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPassTextBox(String password) {
		waitToElementVisible(driver, NewCustomerPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.PASSWORD_TEXTBOX, password);
	}

	public HomePageObject clickToSubmitButton() {
		waitToElementVisible(driver, NewCustomerPageUI.SUBMIT_BUTTON);
		clickToElement(driver, NewCustomerPageUI.SUBMIT_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

}
