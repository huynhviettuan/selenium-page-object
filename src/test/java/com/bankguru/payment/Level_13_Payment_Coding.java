package com.bankguru.payment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import bankguru.pageObjects.BalanceEnquiryPageObject;
import bankguru.pageObjects.DeleteAccountPageObject;
import bankguru.pageObjects.DeleteCustomerPageObject;
import bankguru.pageObjects.DepositPageObject;
import bankguru.pageObjects.EditAccountPageObject;
import bankguru.pageObjects.EditCustomerPageObject;
import bankguru.pageObjects.FundTransferPageObject;
import bankguru.pageObjects.HomePageObject;
import bankguru.pageObjects.LoginPageObject;
import bankguru.pageObjects.NewAccountPageObject;
import bankguru.pageObjects.NewCustomerPageObject;
import bankguru.pageObjects.WithdrawalPageObject;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import driverFactory.DriverManager;
import driverFactory.DriverManagerFactory;

public class Level_13_Payment_Coding extends AbstractTest {

	@Parameters("browser")
	@BeforeClass
	public void initData(String browserName) {
		driverManager = DriverManagerFactory.getDriverManager(browserName);
		driver = driverManager.getDriver();

		userIDValue = "mngr231263";
		passwordValue = "AbEqyzE";
		customerName = "John Cena";
		dateOfBirth = "1989-01-01";
		address = "PO Box 912 831 Duis Avenue";
		city = "Tampa";
		state = "FL";
		pin = "451250";
		phone = "0782241221";
		email = "johncena36522@gmail.com";
		password = "automation";

		editAddress = "PO 831 Luis Juan";
		editCity = "Tampaone";
		editState = "FLos";
		editPin = "452340";
		editPhone = "0782241663";
		editEmail = "batiztuta2092@gmail.com";

		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPage.inputToDynamicTextbox(driver, "uid", userIDValue);
		loginPage.inputToDynamicTextbox(driver, "password", passwordValue);
		homePage = loginPage.clickToLoginButton();
		homePage.openDynamicPage(driver, "New Customer");
	}

	@Test(description = "Create New Customer")
	public void TC_01_CreateNewCustomerSuccessfull() {
		log.info("TC_01_CreateNewCustomer - Step 01 : Open New Customer page");
		newcustomerPage = PageGeneratorManager.getNewCustomerPage(driver);

		log.info("TC_01_CreateNewCustomer - Step 02 : Input data to maddatory/required fields");
		newcustomerPage.inputToDynamicTextbox(driver, "name", customerName);
		newcustomerPage.inputToDynamicTextbox(driver, "dob", dateOfBirth);
		newcustomerPage.inputToDynamicTextArea(driver, "addr", address);
		newcustomerPage.inputToDynamicTextbox(driver, "city", city);
		newcustomerPage.inputToDynamicTextbox(driver, "state", state);
		newcustomerPage.inputToDynamicTextbox(driver, "pinno", pin);
		newcustomerPage.inputToDynamicTextbox(driver, "telephoneno", phone);
		newcustomerPage.inputToDynamicTextbox(driver, "emailid", email);
		newcustomerPage.inputToDynamicTextbox(driver, "password", password);

		log.info("TC_01_CreateNewCustomer - Step 03 : Click to Submit Button");
		newcustomerPage.clickToDynamicButton(driver, "sub");

		log.info("TC_01_CreateNewCustomer - Step 04 : Verify success message is displayed");
		verifyTrue(newcustomerPage.isDynamicPageOrMessageDisplay(driver, "Customer Registered Successfully!!!"));

		log.info("TC_01_CreateNewCustomer - Step 05 : Verify New Customer created success");
		verifyEquals(newcustomerPage.getDynamicTextInTable(driver, "Customer Name"), customerName);
		verifyEquals(newcustomerPage.getDynamicTextInTable(driver, "Birthdate"), dateOfBirth);
		verifyEquals(newcustomerPage.getDynamicTextInTable(driver, "Address"), address);
		verifyEquals(newcustomerPage.getDynamicTextInTable(driver, "City"), city);
		verifyEquals(newcustomerPage.getDynamicTextInTable(driver, "State"), state);
		verifyEquals(newcustomerPage.getDynamicTextInTable(driver, "Pin"), pin);
		verifyEquals(newcustomerPage.getDynamicTextInTable(driver, "Mobile No."), phone);
		verifyEquals(newcustomerPage.getDynamicTextInTable(driver, "Email"), email);

		customerID = newcustomerPage.getDynamicTextInTable(driver, "Customer ID");
	}

	@Test(description = "Edit Customer")
	public void TC_02_EditCustomerAccount() {
		log.info("TC_02_EditCustomerAccount - Step 01 : Open Edit Customer page");
		newcustomerPage.openDynamicPage(driver, "Edit Customer");
		editCustomerPage = PageGeneratorManager.getEditCustomerPage(driver);

		log.info("TC_02_EditCustomerAccount - Step 02 : Enter Customer ID");
		editCustomerPage.inputToDynamicTextbox(driver, "cusid", customerID);
		editCustomerPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("TC_02_EditCustomerAccount - Step 03 : Enter edit data to fields");
		editCustomerPage.inputToDynamicTextArea(driver, "addr", editAddress);
		editCustomerPage.inputToDynamicTextbox(driver, "city", editCity);
		editCustomerPage.inputToDynamicTextbox(driver, "state", editState);
		editCustomerPage.inputToDynamicTextbox(driver, "pinno", editPin);
		editCustomerPage.inputToDynamicTextbox(driver, "telephoneno", editPhone);
		editCustomerPage.inputToDynamicTextbox(driver, "emailid", editEmail);

		log.info("TC_02_EditCustomerAccount - Step 04 : Click Submit button");
		editCustomerPage.clickToDynamicButton(driver, "sub");

		log.info("TC_02_EditCustomerAccount - Step 05 : Verify success message is displayed");
		verifyTrue(newcustomerPage.isDynamicPageOrMessageDisplay(driver, "Customer details updated Successfully!!!"));

		log.info("TC_02_EditCustomerAccount - Step 06 : Verify Edit Customer Success ");
		verifyEquals(editCustomerPage.getDynamicTextInTable(driver, "Customer ID"), customerID);
		verifyEquals(editCustomerPage.getDynamicTextInTable(driver, "Customer Name"), customerName);
		verifyEquals(editCustomerPage.getDynamicTextInTable(driver, "Birthdate"), dateOfBirth);
		verifyEquals(editCustomerPage.getDynamicTextInTable(driver, "Address"), editAddress);
		verifyEquals(editCustomerPage.getDynamicTextInTable(driver, "City"), editCity);
		verifyEquals(editCustomerPage.getDynamicTextInTable(driver, "State"), editState);
		verifyEquals(editCustomerPage.getDynamicTextInTable(driver, "Pin"), editPin);
		verifyEquals(editCustomerPage.getDynamicTextInTable(driver, "Mobile No."), editPhone);
		verifyEquals(editCustomerPage.getDynamicTextInTable(driver, "Email"), editEmail);
	}

	@Test(description = "Add New Account")
	public void TC_03_AddNewAccount() {
		log.info("TC_03_AddNewAccount - Create first account");
		log.info("TC_03_AddNewAccount - Step 01 : Open Add New Account page");
		editCustomerPage.openDynamicPage(driver, "New Account");
		newAccountPage = PageGeneratorManager.getNewAccountPage(driver);

		log.info("TC_03_AddNewAccount - Step 02 : Enter new account data to fields");
		newAccountPage.inputToDynamicTextbox(driver, "cusid", customerID);
		newAccountPage.selectItemInDynamicDropdownList(driver, "selaccount", "Savings");
		newAccountPage.inputToDynamicTextbox(driver, "inideposit", "50000");

		log.info("TC_03_AddNewAccount - Step 03 : Click to Submit button");
		newAccountPage.clickToDynamicButton(driver, "button2");

		log.info("TC_03_AddNewAccount - Step 04 : Verify success message is displayed");
		verifyTrue(newAccountPage.isDynamicPageOrMessageDisplay(driver, "Account Generated Successfully!!!"));

		log.info("TC_04_AddNewAccount - Step 05 : Verify Add New Account Success");
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Customer ID"), customerID);
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Customer Name"), customerName);
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Email"), editEmail);
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Account Type"), "Savings");
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Date of Opening"), getToday());
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Current Amount"), "50000");

		accountNo1 = newAccountPage.getDynamicTextInTable(driver, "Account ID");

		log.info("TC_03_AddNewAccount - Create second account");
		log.info("TC_03_AddNewAccount - Step 06 : Open Add New Account page");
		newAccountPage.openDynamicPage(driver, "New Account");
		newAccountPage = PageGeneratorManager.getNewAccountPage(driver);

		log.info("TC_03_AddNewAccount - Step 07 : Enter new account data to fields");
		newAccountPage.inputToDynamicTextbox(driver, "cusid", customerID);
		newAccountPage.selectItemInDynamicDropdownList(driver, "selaccount", "Savings");
		newAccountPage.inputToDynamicTextbox(driver, "inideposit", "50000");

		log.info("TC_03_AddNewAccount - Step 08 : Click to Submit button");
		newAccountPage.clickToDynamicButton(driver, "button2");

		log.info("TC_03_AddNewAccount - Step 09 : Verify success message is displayed");
		verifyTrue(newAccountPage.isDynamicPageOrMessageDisplay(driver, "Account Generated Successfully!!!"));

		log.info("TC_04_AddNewAccount - Step 10 : Verify Add New Account Success");
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Customer ID"), customerID);
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Customer Name"), customerName);
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Email"), editEmail);
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Account Type"), "Savings");
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Date of Opening"), getToday());
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Current Amount"), "50000");

		accountNo2 = newAccountPage.getDynamicTextInTable(driver, "Account ID");
	}

	@Test(description = "Edit Account")
	public void TC_04_EditAccount() {
		log.info("TC_04_EditAccount - Step 01 : Open Edit Account page");
		newAccountPage.openDynamicPage(driver, "Edit Account");
		editAccountPage = PageGeneratorManager.getEditAccountPage(driver);

		log.info("TC_04_EditAccount - Step 02 : Enter Account No");
		editAccountPage.inputToDynamicTextbox(driver, "accountno", accountNo1);
		editAccountPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("TC_04_EditAccount - Step 03 : Change Type of Account");
		editAccountPage.selectItemInDynamicDropdownList(driver, "a_type", "Current");

		log.info("TC_04_EditAccount - Step 04 : Click to Submit button");
		editAccountPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("TC_04_EditAccount - Step 05 : Verify success message is displayed");
		verifyTrue(editAccountPage.isDynamicPageOrMessageDisplay(driver, "Account details updated Successfully!!!"));

		log.info("TC_04_EditAccount - Step 06 : Verify type of account");
		verifyEquals(editAccountPage.getDynamicTextInTable(driver, "Customer ID"), customerID);
		verifyEquals(editAccountPage.getDynamicTextInTable(driver, "Customer Name"), customerName);
		verifyEquals(editAccountPage.getDynamicTextInTable(driver, "Email"), editEmail);
		verifyEquals(editAccountPage.getDynamicTextInTable(driver, "Account Type"), "Current");
		verifyEquals(editAccountPage.getDynamicTextInTable(driver, "Date of Opening"), getToday());
		verifyEquals(editAccountPage.getDynamicTextInTable(driver, "Current Amount"), "50000");
	}

	@Test(description = "Deposit")
	public void TC_05_Deposit() {
		log.info("TC_05_Deposit - Step 01 : Open Deposit page");
		editAccountPage.openDynamicPage(driver, "Deposit");
		depositPage = PageGeneratorManager.getDepositPage(driver);

		log.info("TC_05_Deposit - Step 02 : Fill Amount Deposit form");
		depositPage.inputToDynamicTextbox(driver, "accountno", accountNo1);
		depositPage.inputToDynamicTextbox(driver, "ammount", "5000");
		depositPage.inputToDynamicTextbox(driver, "desc", "Fund Trans");

		log.info("TC_05_Deposit - Step 03 : Click to Submit button");
		depositPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("TC_06_Deposit - Step 04 : Verify success message is displayed");
		verifyTrue(depositPage.isDynamicPageOrMessageDisplay(driver, "Transaction details of Deposit for Account " + accountNo1));

		log.info("TC_06_Deposit - Step 05 : Verify Transaction details of Deposit");
		verifyEquals(depositPage.getDynamicTextInTable(driver, "Account No"), accountNo1);
		verifyEquals(depositPage.getDynamicTextInTable(driver, "Amount Credited"), "5000");
		verifyEquals(depositPage.getDynamicTextInTable(driver, "Type of Transaction"), "Deposit");
		verifyEquals(depositPage.getDynamicTextInTable(driver, "Description"), "Fund Trans");
		verifyEquals(depositPage.getDynamicTextInTable(driver, "Current Balance"), "55000");
	}

	@Test(description = "Withdrawal")
	public void TC_06_Withdrawal() {
		log.info("TC_06_Withdrawal - Step 01 : Open Withdrawal page");
		depositPage.openDynamicPage(driver, "Withdrawal");
		withdrawalPage = PageGeneratorManager.getWithdrawalPage(driver);

		log.info("TC_06_Withdrawal - Step 02 : Fill Amount Withdrawal form");
		withdrawalPage.inputToDynamicTextbox(driver, "accountno", accountNo1);
		withdrawalPage.inputToDynamicTextbox(driver, "ammount", "5000");
		withdrawalPage.inputToDynamicTextbox(driver, "desc", "Withdrawal");

		log.info("TC_06_Withdrawal - Step 03 : Click to Submit button");
		withdrawalPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("TC_06_Withdrawal - Step 04 : Verify success message is displayed");
		verifyTrue(withdrawalPage.isDynamicPageOrMessageDisplay(driver, "Transaction details of Withdrawal for Account " + accountNo1));

		log.info("TC_06_Withdrawal - Step 05 : Verify Transaction details of Withdrawal");
		verifyEquals(withdrawalPage.getDynamicTextInTable(driver, "Account No"), accountNo1);
		verifyEquals(withdrawalPage.getDynamicTextInTable(driver, "Amount Debited"), "5000");
		verifyEquals(withdrawalPage.getDynamicTextInTable(driver, "Type of Transaction"), "Withdrawal");
		verifyEquals(withdrawalPage.getDynamicTextInTable(driver, "Description"), "Withdrawal");
		verifyEquals(withdrawalPage.getDynamicTextInTable(driver, "Current Balance"), "50000");
	}

	@Test(description = "Fund Transfer")
	public void TC_07_TransferToAnotherAccount() {
		log.info("TC_07_TransferToAnotherAccount - Step 01 : Open Fund Transfer page");
		withdrawalPage.openDynamicPage(driver, "Fund Transfer");
		fundTransferPage = PageGeneratorManager.getFundTransferPage(driver);

		log.info("TC_07_TransferToAnotherAccount - Step 02 : Enter data fund transfer");
		fundTransferPage.inputToDynamicTextbox(driver, "payersaccount", accountNo1);
		fundTransferPage.inputToDynamicTextbox(driver, "payeeaccount", accountNo2);
		fundTransferPage.inputToDynamicTextbox(driver, "ammount", "5000");
		fundTransferPage.inputToDynamicTextbox(driver, "desc", "Fund Trans");

		log.info("TC_07_TransferToAnotherAccount - Step 03 : Click to Submit button");
		fundTransferPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("TC_07_TransferToAnotherAccount - Step 04 : Verify success message is displayed");
		verifyTrue(fundTransferPage.isDynamicPageOrMessageDisplay(driver, "Fund Transfer Details"));

		log.info("TC_07_TransferToAnotherAccount - Step 05 : Verify Fund Transfer Details");
		verifyEquals(fundTransferPage.getDynamicTextInTable(driver, "From Account Number"), accountNo1);
		verifyEquals(fundTransferPage.getDynamicTextInTable(driver, "To Account Number"), accountNo2);
		verifyEquals(fundTransferPage.getDynamicTextInTable(driver, "Amount"), "5000");
		verifyEquals(fundTransferPage.getDynamicTextInTable(driver, "Description"), "Fund Trans");
	}

	@Test(description = "Check current account balance")
	public void TC_08_CheckCurrentAccountBalance() {
		log.info("TC_08_CheckCurrentAccountBalance - Step 01 : Open Balance Enquiry page");
		fundTransferPage.openDynamicPage(driver, "Balance Enquiry");
		balanceEnquiryPage = PageGeneratorManager.getBalanceEnquiryPage(driver);

		log.info("TC_08_CheckCurrentAccountBalance - Step 02 : Enter Account No");
		balanceEnquiryPage.inputToDynamicTextbox(driver, "accountno", accountNo1);

		log.info("TC_08_CheckCurrentAccountBalance - Step 03 : Click Submit button");
		balanceEnquiryPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("TC_08_CheckCurrentAccountBalance - Step 04 : Verify success message is displayed");
		verifyTrue(balanceEnquiryPage.isDynamicPageOrMessageDisplay(driver, "Balance Details for Account " + accountNo1));

		log.info("TC_08_CheckCurrentAccountBalance - Step 05 : Verify Balance Details for Account");
		verifyEquals(balanceEnquiryPage.getDynamicTextInTable(driver, "Account No"), accountNo1);
		verifyEquals(balanceEnquiryPage.getDynamicTextInTable(driver, "Type of Account"), "Current");
		verifyEquals(balanceEnquiryPage.getDynamicTextInTable(driver, "Balance"), "45000");
	}

	@Test(description = "Delete current bank account")
	public void TC_09_DeleteCurrentBankAccount() {
		log.info("Delete first account");
		log.info("TC_09_DeleteCurrentBankAccount - Step 01 : Open Delete Account page");
		balanceEnquiryPage.openDynamicPage(driver, "Delete Account");
		deleteAccountPage = PageGeneratorManager.getDeleteAccountPage(driver);

		log.info("TC_09_DeleteCurrentBankAccount - Step 02 : Enter Account No");
		deleteAccountPage.inputToDynamicTextbox(driver, "accountno", accountNo1);

		log.info("TC_09_DeleteCurrentBankAccount - Step 03 : Click Submit button");
		deleteAccountPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("TC_09_DeleteCurrentBankAccount - Step 04 : Verify and accept confirm alert message");
		verifyTrue(deleteAccountPage.isDynamicAlertMessageDisplayed(driver, "Do you really want to delete this Account?"));

		log.info("TC_09_DeleteCurrentBankAccount - Step 05 : Verify account delete successfull");
		verifyTrue(deleteAccountPage.isDynamicAlertMessageDisplayed(driver, "Account Deleted Sucessfully"));

		log.info("TC_09_DeleteCurrentBankAccount - Step 06 : Open Delete Account page");
		deleteAccountPage.openDynamicPage(driver, "Delete Account");

		log.info("TC_09_DeleteCurrentBankAccount - Step 07 : Enter Account No");
		deleteAccountPage.inputToDynamicTextbox(driver, "accountno", accountNo1);

		log.info("TC_09_DeleteCurrentBankAccount - Step 08 : Click Submit button");
		deleteAccountPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("TC_09_DeleteCurrentBankAccount - Step 09 : Verify and accept confirm alert message");
		verifyTrue(deleteAccountPage.isDynamicAlertMessageDisplayed(driver, "Do you really want to delete this Account?"));

		log.info("TC_09_DeleteCurrentBankAccount - Step 10 : Verify and accept account does not exitst alert message");
		verifyTrue(deleteAccountPage.isDynamicAlertMessageDisplayed(driver, "Customer does not exist!!"));

		log.info("Delete second account");
		log.info("TC_09_DeleteCurrentBankAccount - Step 11 : Open Delete Account page");
		deleteAccountPage.openDynamicPage(driver, "Delete Account");

		log.info("TC_09_DeleteCurrentBankAccount - Step 12 : Enter Account No");
		deleteAccountPage.inputToDynamicTextbox(driver, "accountno", accountNo2);

		log.info("TC_09_DeleteCurrentBankAccount - Step 13 : Click Submit button");
		deleteAccountPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("TC_09_DeleteCurrentBankAccount - Step 14 : Verify and accept confirm alert message");
		verifyTrue(deleteAccountPage.isDynamicAlertMessageDisplayed(driver, "Do you really want to delete this Account?"));

		log.info("TC_09_DeleteCurrentBankAccount - Step 15 : Verify account delete successfull");
		verifyTrue(deleteAccountPage.isDynamicAlertMessageDisplayed(driver, "Account Deleted Sucessfully"));

	}

	@Test(description = "Delete current customer account")
	public void TC_10_DeleteCurrentCustomerAccount() {
		log.info("TC_10_DeleteCurrentCustomerAccount - Step 01 : Open Delete Customer page");
		deleteAccountPage.openDynamicPage(driver, "Delete Customer");
		deleteCustomerPage = PageGeneratorManager.getDeleteCustomerPage(driver);

		log.info("TC_10_DeleteCurrentCustomerAccount - Step 02 : Enter Customer ID");
		deleteCustomerPage.inputToDynamicTextbox(driver, "cusid", customerID);

		log.info("TC_10_DeleteCurrentCustomerAccount - Step 03 : Click Submit button");
		deleteCustomerPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("TC_10_DeleteCurrentCustomerAccount - Step 04 : Verify and accept confirm alert message");
		verifyTrue(deleteCustomerPage.isDynamicAlertMessageDisplayed(driver, "Do you really want to delete this Customer?"));

		log.info("TC_10_DeleteCurrentBankAccount - Step 05 : Verify customer delete successfull");
		verifyTrue(deleteCustomerPage.isDynamicAlertMessageDisplayed(driver, "Customer deleted Successfully"));

		log.info("TC_10_DeleteCurrentCustomerAccount - Step 06 : Open Delete Customer page");
		deleteCustomerPage.openDynamicPage(driver, "Delete Customer");

		log.info("TC_10_DeleteCurrentCustomerAccount - Step 07 : Enter Customer ID");
		deleteCustomerPage.inputToDynamicTextbox(driver, "cusid", customerID);

		log.info("TC_10_DeleteCurrentCustomerAccount - Step 08 : Click Submit button");
		deleteCustomerPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("TC_10_DeleteCurrentCustomerAccount - Step 09 : Verify and accept confirm alert message");
		verifyTrue(deleteCustomerPage.isDynamicAlertMessageDisplayed(driver, "Do you really want to delete this Customer?"));

		log.info("TC_10_DeleteCurrentBankAccount - Step 10 : Verify account does not exitst alert message");
		verifyTrue(deleteCustomerPage.isDynamicAlertMessageDisplayed(driver, "Customer does not exist!!"));
	}

	public void cleanData() {
		closeBrowserAndDriver(driver);
	}

	WebDriver driver;
	WebDriverWait explicitWait;

	private String userIDValue;
	private String passwordValue;
	private String customerName;
	private String dateOfBirth;
	private String address;
	private String city;
	private String state;
	private String pin;
	private String phone;
	private String email;
	private String password;
	private String editAddress;
	private String editCity;
	private String editState;
	private String editPin;
	private String editPhone;
	private String editEmail;
	private String customerID, accountNo1, accountNo2;
	private DriverManager driverManager;
	private LoginPageObject loginPage;
	private NewCustomerPageObject newcustomerPage;
	private HomePageObject homePage;
	private EditCustomerPageObject editCustomerPage;
	private NewAccountPageObject newAccountPage;
	private EditAccountPageObject editAccountPage;
	private DepositPageObject depositPage;
	private WithdrawalPageObject withdrawalPage;
	private FundTransferPageObject fundTransferPage;
	private BalanceEnquiryPageObject balanceEnquiryPage;
	private DeleteAccountPageObject deleteAccountPage;
	private DeleteCustomerPageObject deleteCustomerPage;

}
