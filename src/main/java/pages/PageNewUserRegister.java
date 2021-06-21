package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import utilities.PageUtility;

public class PageNewUserRegister extends PageUtility {
	WebDriver driver;
	SoftAssert sa;

	public PageNewUserRegister(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		sa = new SoftAssert();
	}

	@FindBy(xpath = "//a[@class='btn btn-block btn-default']")
	WebElement GetYourAccountButton;

	@FindBy(xpath = "//input[@name='name']")
	WebElement NewUsercompanyName;

	@FindBy(xpath = "//input[@name='email']")
	WebElement NewUsercompanyEmail;

	@FindBy(xpath = "//select[@class='form-control']")
	WebElement language;

	@FindBy(xpath = "//input[@name='username']")
	WebElement NewUserUsername;

	@FindBy(id = "password")
	WebElement NewUserPassword;

	@FindBy(id = "signupInputRePassword1")
	WebElement confirmNewUserPassword;

	@FindBy(xpath = "//button[@class='btn btn-block btn-primary mt-lg']")
	WebElement newUserSignUp;

	@FindBy(xpath = "//div[@class='alert alert-success']")
	WebElement newUserRegisterMsg;

	// List of usernames in that page
	@FindBys(value = { @FindBy(xpath = "//table[@id='DataTables']//td[3]") })
	List<WebElement> newUserInAllUsersList;

	@FindBy(linkText = "User")
	WebElement userInMenu;

	@FindBy(xpath = "//a[@href='#' and text()='Next']")
	WebElement nextPagination;

	// Click on Get Your Account
	public void clickGetYourAccountButton() {
		click(GetYourAccountButton);
	}

	// Enter Newuser Company Name
	public void enterNewUserCompanyName(String newUsrCmpyName) {
		sendKeys(NewUsercompanyName, newUsrCmpyName);
	}

	// Enter Newuser Company Email
	public void enterNewUserCompanyEmail(String newUsrCmpyEmail) {
		sendKeys(NewUsercompanyEmail, newUsrCmpyEmail);
	}

	// Selecting the language
	public void selectLanguage(String value) {
		selectDropDownByValue(language, value);
	}

	// Enter Newuser username
	public void enterNewUserUsername(String newUsrName) {
		sendKeys(NewUserUsername, newUsrName);
	}

	// Enter Newuser password
	public void enterNewUserPassword(String newUsrPwd) {
		sendKeys(NewUserPassword, newUsrPwd);
	}

	// Enter Newuser confirm password
	public void enterNewUserConfirmPassword(String newUsrConfirmPwd) {
		sendKeys(confirmNewUserPassword, newUsrConfirmPwd);
	}

	// click on SignUp button
	public void clickNewUserSignUp() {
		click(newUserSignUp);
	}

	// verifying whether the successfully registered message is appeared
	public void verifyNewUserSuccessfullyRegisteredMessageDisplayed() {
		waitForVisibility(newUserRegisterMsg);
		sa.assertTrue(newUserRegisterMsg.isDisplayed(), "Successfully Registered msg is not displayed");
		sa.assertAll();
	}

	// verifying the successfully registered msg is correct
	public void verifyNewUserSuccessfullyRegisteredMessage() {
		String exp_Message = "You have successfully registered! Check your email address to activate your account.";
		String act_Message = newUserRegisterMsg.getText();
		sa.assertEquals(act_Message, exp_Message);
		sa.assertAll();
	}

	// verifying the newuser details in the user module
	public void verifyNewUsernameInAllUsersList(String newUserName) {

		System.out.println("name= " + newUserName);
		scrollDown(userInMenu);
		click(userInMenu);
		boolean userNameNotFound = true;
		while (userNameNotFound) {

			for (int i = 0; i < newUserInAllUsersList.size(); i++) {
				String userNameInPage = newUserInAllUsersList.get(i).getText();
				if (userNameInPage.contentEquals(newUserName)) {
					Assert.assertTrue(true);
					userNameNotFound = false;
					break;
				}

			}
			if (userNameNotFound == true) {
				click(nextPagination);
			}
		}

		
	}

}
