package bankguru.pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.pageUIs.RegisterPageUI;
import commons.AbstractPage;
import commons.PageGeneratorManager;

public class RegisterPageObject extends AbstractPage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isRegisterPageDisplayed() {
		waitToElementVisible(driver, RegisterPageUI.EMAIL_ID_TEXTBOX);
		return isElementDisplayed(driver, RegisterPageUI.EMAIL_ID_TEXTBOX);
	}

	public void inputEmailIDTextbox(String emailIDValue) {
		waitToElementVisible(driver, RegisterPageUI.EMAIL_ID_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_ID_TEXTBOX, emailIDValue);
	}

	public void clickSubmitButton() {
		waitToElementVisible(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
	}

	public String getUserIDValue() {
		waitToElementVisible(driver, RegisterPageUI.USER_ID_TEXT);
		return getTextElement(driver, RegisterPageUI.USER_ID_TEXT);
	}

	public String getPasswordValue() {
		waitToElementVisible(driver, RegisterPageUI.PASSWORD_TEXT);
		return getTextElement(driver, RegisterPageUI.PASSWORD_TEXT);
	}

	public LoginPageObject openLoginPage(String loginPageURL) {
		openAnyURL(driver, loginPageURL);
		return PageGeneratorManager.getLoginPage(driver);
	}
}
