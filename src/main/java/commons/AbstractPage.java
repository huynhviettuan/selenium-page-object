package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import bankguru.pageObjects.DeleteCustomerPageObject;
import bankguru.pageObjects.EditCustomerPageObject;
import bankguru.pageObjects.NewCustomerPageObject;
import bankguru.pageUIs.AbstractPageUI;

public class AbstractPage extends AbstractPageUI {

	public void openAnyURL(WebDriver driver, String urlValue) {
		driver.get(urlValue);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentPageURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void fowardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void sendkeyToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public void clickToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void clickToElement(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
	}

	public void sendkeyToElement(WebDriver driver, String locator, String sendkeyValue, String... values) {
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(sendkeyValue);
	}

	public void selectItemInDropdrown(WebDriver driver, String locator, String valueItem) {
		select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(valueItem);
	}

	public void selectItemInDropdrown(WebDriver driver, String locator, String valueItem, String... values) {
		locator = String.format(locator, (Object[]) values);
		select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(valueItem);
	}

	public String getFirstItemInDropdown(WebDriver driver, String locator) {
		select = new Select(driver.findElement(By.xpath(locator)));
		return select.getFirstSelectedOption().getText();
	}

	public void selectItemInDropdown(WebDriver driver, String parentLocator, String allItemLocator, String expectedItem) throws Exception {
		jsExcecutor = (JavascriptExecutor) driver;
		element = driver.findElement(By.xpath(parentLocator));
		jsExcecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		jsExcecutor.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);

		waitExplicit = new WebDriverWait(driver, Constants.LONG_TIMEOUT);
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemLocator)));

		elements = driver.findElements(By.xpath(allItemLocator));

		for (WebElement item : elements) {
			System.out.println(item.getText());
			if (item.getText().equals(expectedItem)) {
				jsExcecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				Thread.sleep(1000);
				item.click();
				break;
			}
		}
	}

	public String getAttribueValue(WebDriver driver, String locator, String attributeName) {
		element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}

	public String getTextElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public String getTextElement(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public void countNumberofElement(WebDriver driver, String locator) {
		elements = driver.findElements(By.xpath(locator));
		elements.size();
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		overideImplicitTimeout(driver, Constants.SHORT_TIMEOUT);
		try {
			element = driver.findElement(By.xpath(locator));
			overideImplicitTimeout(driver, Constants.LONG_TIMEOUT);
			return element.isDisplayed();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			overideImplicitTimeout(driver, Constants.LONG_TIMEOUT);
			return false;
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator, String... values) {
		overideImplicitTimeout(driver, Constants.SHORT_TIMEOUT);
		try {
			locator = String.format(locator, (Object[]) values);
			element = driver.findElement(By.xpath(locator));
			overideImplicitTimeout(driver, Constants.LONG_TIMEOUT);
			return element.isDisplayed();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			overideImplicitTimeout(driver, Constants.LONG_TIMEOUT);
			return false;
		}
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public boolean isElementEnabled(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public void checkToCheckBox(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		if (!isElementSelected(driver, locator)) {
			clickToElement(driver, locator);
		}
	}

	public void uncheckToCheckBox(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		if (isElementSelected(driver, locator)) {
			clickToElement(driver, locator);
		}
	}

	public void switchToChildWindowByTitle(WebDriver driver, String title) {
		allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			driver.switchTo().window(runWindow);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}

		}
	}

	public boolean closeAllWindowsWithoutParent(WebDriver driver, String parentWindow) {
		allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentWindow)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	public void hoverToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		element = driver.findElement(By.xpath(locator));
		action.moveToElement(element).perform();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		element = driver.findElement(By.xpath(locator));
		action.doubleClick(element).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		element = driver.findElement(By.xpath(locator));
		action.contextClick(element).perform();
	}

	public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		WebElement sourcElement = driver.findElement(By.xpath(sourceLocator));
		WebElement targetElement = driver.findElement(By.xpath(targetLocator));
		action.dragAndDrop(sourcElement, targetElement).perform();
	}

	public void sendKeyboardToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		element = driver.findElement(By.xpath(locator));
		action.sendKeys(element, key).perform();
	}

	public Object executeForBrowserByJS(String javaSript) {
		return jsExcecutor.executeScript(javaSript);
	}

	public boolean verifyTextInInnerText(String textExpected) {
		String textActual = (String) jsExcecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		System.out.println("Text actual = " + textActual);
		return textActual.equals(textExpected);
	}

	public boolean verifyTextInInnerTextContains(String textExpected) {
		return (boolean) jsExcecutor.executeScript("return document.documentElement.innerText.contains('" + textExpected + "')");
	}

	public void scrollToBottomPage() {
		jsExcecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(String url) {
		jsExcecutor.executeScript("window.location = '" + url + "'");
	}

	public Object executeForElementByJS(String javaSript) {
		return jsExcecutor.executeScript(javaSript, element);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		jsExcecutor.executeScript("arguments[0].click();", element);
	}

	public void scrollToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		jsExcecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		element = driver.findElement(By.xpath(locator));
		jsExcecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExcecutor = (JavascriptExecutor) driver;
		element = driver.findElement(By.xpath(locator));
		jsExcecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove, String... values) {
		jsExcecutor = (JavascriptExecutor) driver;
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		jsExcecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}

	public void highlightElement() {
		String originalStyle = element.getAttribute("style");
		jsExcecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 5px solid red; border-style: dashed;");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		jsExcecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);

	}

	public void waitToElementVisible(WebDriver driver, String locator) {
		by = By.xpath(locator);
		waitExplicit = new WebDriverWait(driver, Constants.LONG_TIMEOUT);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitToElementVisible(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		by = By.xpath(locator);
		waitExplicit = new WebDriverWait(driver, Constants.LONG_TIMEOUT);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitToElementPresence(WebDriver driver, String locator) {
		by = By.xpath(locator);
		waitExplicit = new WebDriverWait(driver, Constants.LONG_TIMEOUT);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void waitToElementClickable(WebDriver driver, String locator) {
		by = By.xpath(locator);
		waitExplicit = new WebDriverWait(driver, Constants.LONG_TIMEOUT);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void waitToElementInvisible(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, Constants.SHORT_TIMEOUT);
		try {
			by = By.xpath(locator);
			waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(by));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void overideImplicitTimeout(WebDriver driver, long timeInSecond) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void waitToAlertPresence(WebDriver driver) {
		waitExplicit = new WebDriverWait(driver, Constants.LONG_TIMEOUT);
		waitExplicit.until(ExpectedConditions.alertIsPresent());
	}

	public NewCustomerPageObject openNewCustomerPage(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.NEW_CUSTOMER_LINK);
		clickToElement(driver, AbstractPageUI.NEW_CUSTOMER_LINK);
		return PageGeneratorManager.getNewCustomerPage(driver);
	}

	public EditCustomerPageObject openEditCustomerPage(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.EDIT_CUSTOMER_LINK);
		clickToElement(driver, AbstractPageUI.EDIT_CUSTOMER_LINK);
		return PageGeneratorManager.getEditCustomerPage(driver);
	}

	public DeleteCustomerPageObject openDeleteCustomerPage(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.DELETE_CUSTOMER_LINK);
		clickToElement(driver, AbstractPageUI.DELETE_CUSTOMER_LINK);
		return PageGeneratorManager.getDeleteCustomerPage(driver);
	}

	public AbstractPage openDynamicPage(WebDriver driver, String pagename) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, pagename);
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, pagename);

		switch (pagename) {
		default:
			return PageGeneratorManager.getHomePage(driver);
		case "New Customer":
			return PageGeneratorManager.getNewCustomerPage(driver);
		case "Edit Customer":
			return PageGeneratorManager.getEditCustomerPage(driver);
		case "Delete Customer":
			return PageGeneratorManager.getDeleteCustomerPage(driver);
		case "New Account":
			return PageGeneratorManager.getNewAccountPage(driver);
		case "Edit Account":
			return PageGeneratorManager.getEditAccountPage(driver);
		case "Delete Account":
			return PageGeneratorManager.getDeleteAccountPage(driver);
		case "Deposit":
			return PageGeneratorManager.getDepositPage(driver);
		case "Withdrawal":
			return PageGeneratorManager.getWithdrawalPage(driver);
		case "Fund Transfer":
			return PageGeneratorManager.getFundTransferPage(driver);
		case "Balance Enquiry":
			return PageGeneratorManager.getBalanceEnquiryPage(driver);
		}
	}

	public void inputToDynamicTextbox(WebDriver driver, String nameAttributeValue, String valueToSendkey) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, nameAttributeValue);
		if (nameAttributeValue.equals("dob")) {
			removeAttributeInDOM(driver, AbstractPageUI.DYNAMIC_TEXTBOX, "type", nameAttributeValue);
		}
		sendkeyToElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX, valueToSendkey, nameAttributeValue);
	}

	public void inputToDynamicTextArea(WebDriver driver, String textareanameID, String valueToSendkey) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTAREA, textareanameID);
		sendkeyToElement(driver, AbstractPageUI.DYNAMIC_TEXTAREA, valueToSendkey, textareanameID);
	}

	public void clickToDynamicButton(WebDriver driver, String buttonnameID) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_BUTTON, buttonnameID);
		clickToElement(driver, AbstractPageUI.DYNAMIC_BUTTON, buttonnameID);
	}

	public boolean isDynamicPageOrMessageDisplay(WebDriver driver, String pageHeadingName) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_PAGE_TITLE, pageHeadingName);
		return isElementDisplayed(driver, AbstractPageUI.DYNAMIC_PAGE_TITLE, pageHeadingName);
	}

	public String getDynamicTextInTable(WebDriver driver, String rowName) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_VERIFY_TEXT, rowName);
		return getTextElement(driver, AbstractPageUI.DYNAMIC_VERIFY_TEXT, rowName);
	}

	public void selectItemInDynamicDropdownList(WebDriver driver, String dropdownID, String valueItem) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_DROPDOWNLIST, dropdownID);
		selectItemInDropdrown(driver, AbstractPageUI.DYNAMIC_DROPDOWNLIST, valueItem, dropdownID);
	}

	public void sleepInSecond(long seconds) {
		try {
			Thread.sleep(seconds);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public boolean isDynamicAlertMessageDisplayed(WebDriver driver, String expectedAlertMessage) {
		waitToAlertPresence(driver);
		String actualAlertMessage = getTextAlert(driver);
		acceptAlert(driver);
		sleepInSecond(10);
		return actualAlertMessage.equals(expectedAlertMessage);
	}

	By by;
	Select select;
	Actions action;
	WebElement element;
	Set<String> allWindows;
	List<WebElement> elements;
	WebDriverWait waitExplicit;
	JavascriptExecutor jsExcecutor;
}