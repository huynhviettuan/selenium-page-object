package bankguru.pageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPage;

public class LoginPageFactory extends AbstractPage {
	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//form[@name = 'frmLogin']")
	private WebElement loginForm;

	@FindBy(how = How.NAME, using = "uid")
	private WebElement userIDTextbox;

	@FindBy(how = How.NAME, using = "password")
	private WebElement passwordTextbox;

	@FindBy(css = "input[name='btnLogin']")
	private List<WebElement> loginButton;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'here')]")
	private WebElement hereLink;

	@FindBy(how = How.NAME, using = "emailid")
	private WebElement emaidIDTextbox;

	public LoginPageFactory(WebDriver mappingDriver) {
		driver = mappingDriver;
		PageFactory.initElements(driver, this);
	}

	public boolean isLoginFormDisplayed() {
		return loginForm.isDisplayed();
	}

	public String getLoginPageURL() {
		return getCurrentPageURL(driver);
	}

	public void clickToHereLink() {
		hereLink.click();
	}

	public void inputToUserIDTextbox(String userIDInfor) {
		userIDTextbox.sendKeys(userIDInfor);
	}

	public void inputToPasswordTextbox(String passwordInfor) {
		passwordTextbox.sendKeys(passwordInfor);
	}

	public void clickToLoginButton() {
		loginButton.get(0).click();
	}
}
