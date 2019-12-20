package bankguru.pageUIs;

public class HomePageUI {
	public static final String WELCOME_MESSAGE_TEXT = "//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]";
	public static final String LOG_OUT_LINK = "//a[contains(text(),'Log out')]";
	public static final String SUCCESS_MESSAGE = "//p[@class='heading3']";
	public static final String CUSTOMER_NAME_TEXT = "//td[contains(text(),'Customer Name')]/following-sibling::td";
	public static final String DATE_OF_BIRTH_TEXT = "//td[contains(text(),'Birthdate')]/following-sibling::td";
	public static final String ADDRESS_TEXT = "//td[contains(text(),'Address')]/following-sibling::td";
	public static final String CITY_TEXT = "//td[contains(text(),'City')]/following-sibling::td";
	public static final String STATE_TEXT = "//td[contains(text(),'State')]/following-sibling::td";
	public static final String PIN_TEXT = "//td[contains(text(),'Pin')]/following-sibling::td";
	public static final String MOBILE_TEXT = "//td[contains(text(),'Mobile No.')]/following-sibling::td";
	public static final String EMAIL_TEXT = "//td[contains(text(),'Email')]/following-sibling::td";
	public static final String EDIT_CUSTOMER_SUCCESS_MSG = "//p[text()='Customer details updated Successfully!!!']";
}
