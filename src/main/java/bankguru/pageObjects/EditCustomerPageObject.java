package bankguru.pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.pageUIs.EditCustomerUI;
import commons.AbstractPage;
import commons.PageGeneratorManager;

public class EditCustomerPageObject extends AbstractPage {
	private WebDriver driver;

	public EditCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isEditCustomerPageDisplayed() {
		waitToElementVisible(driver, EditCustomerUI.EDIT_CUSTOMER_TEXT);
		return isElementDisplayed(driver, EditCustomerUI.EDIT_CUSTOMER_TEXT);
	}

	public void inputToCustomerIDTextbox(String customerID) {
		waitToElementVisible(driver, EditCustomerUI.CUSTOMER_ID_TEXTBOX);
		sendkeyToElement(driver, EditCustomerUI.CUSTOMER_ID_TEXTBOX, customerID);
	}

	public void clickToSubmitButton() {
		waitToElementVisible(driver, EditCustomerUI.SUBMIT_BUTTON);
		clickToElement(driver, EditCustomerUI.SUBMIT_BUTTON);
	}

	public void inputToAddressTextArea(String editAddress) {
		waitToElementVisible(driver, EditCustomerUI.ADDRESS_TEXTAREA);
		sendkeyToElement(driver, EditCustomerUI.ADDRESS_TEXTAREA, editAddress);
	}

	public void inputToCityTextBox(String editCity) {
		waitToElementVisible(driver, EditCustomerUI.CITY_TEXTBOX);
		sendkeyToElement(driver, EditCustomerUI.CITY_TEXTBOX, editCity);
	}

	public void inputToStateTextBox(String editState) {
		waitToElementVisible(driver, EditCustomerUI.STATE_TEXTBOX);
		sendkeyToElement(driver, EditCustomerUI.STATE_TEXTBOX, editState);
	}

	public void inputToPinTextBox(String editPin) {
		waitToElementVisible(driver, EditCustomerUI.PIN_TEXTBOX);
		sendkeyToElement(driver, EditCustomerUI.PIN_TEXTBOX, editPin);
	}

	public void inputToMobileTextBox(String editMobileNumber) {
		waitToElementVisible(driver, EditCustomerUI.MOBILE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, EditCustomerUI.MOBILE_NUMBER_TEXTBOX, editMobileNumber);
	}

	public void inputToEmailTextBox(String editEmail) {
		waitToElementVisible(driver, EditCustomerUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, EditCustomerUI.EMAIL_TEXTBOX, editEmail);
	}

	public HomePageObject clickToEditSubmitButton() {
		waitToElementVisible(driver, EditCustomerUI.EDIT_SUBMIT_BUTTON);
		clickToElement(driver, EditCustomerUI.EDIT_SUBMIT_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

}
