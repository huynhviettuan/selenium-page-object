package bankguru.pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.pageUIs.LoginPageUI;
import bankguru.pageUIs.RegisterPageUI;
import commons.AbstractPage;
import commons.PageGeneratorManager;

public class LoginPageObject extends AbstractPage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getLoginPageURL() {
		return getCurrentPageURL(driver);
	}

	public boolean isLoginFormDisplayed() {
		waitToElementVisible(driver, LoginPageUI.LOGIN_FORM);
		return isElementDisplayed(driver, LoginPageUI.LOGIN_FORM);
	}

	public RegisterPageObject clickToHereLink() {
		waitToElementVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public void inputToUserIDTextbox(String userIDValue) {
		waitToElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX, userIDValue);
	}

	public void inputToPasswrodTextbox(String passwordValue) {
		waitToElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passwordValue);
	}

	public HomePageObject clickToLoginButton() {
		waitToElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

	public boolean isEmailIDTextboxAtRegisterPageUndisplayed() {
		waitToElementInvisible(driver, RegisterPageUI.EMAIL_ID_TEXTBOX);
		return isElementDisplayed(driver, RegisterPageUI.EMAIL_ID_TEXTBOX);
	}

	public boolean isFileUploadLinkisdisplay() {
		waitToElementInvisible(driver, LoginPageUI.FILE_UPLOAD_LINK_IN_NAV_BAR);
		return isElementDisplayed(driver, LoginPageUI.FILE_UPLOAD_LINK_IN_NAV_BAR);
	}
}
