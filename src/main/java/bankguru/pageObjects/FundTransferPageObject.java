package bankguru.pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class FundTransferPageObject extends AbstractPage {
	private WebDriver driver;

	public FundTransferPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
