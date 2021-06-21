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

public class PageLogin extends PageUtility {
	WebDriver driver;
	SoftAssert sa;
	

	@FindBy(xpath = "//input[@name='user_name']")
	WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//button[@class='btn btn-primary  btn-flat']")
	WebElement signIn;

	@FindBy(linkText = "Dashboard")
	WebElement dashboard;

	@FindBy(xpath = "//div[@class='alert alert-danger']")
	WebElement invalidMessage;

	@FindBy(xpath = "//li[text()='This value is required.']")
	WebElement blankUsernameMsg;

	
	public PageLogin(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		sa = new SoftAssert();
	}

	// To enter Username
	public void enterUsername(String usrName) {
		sendKeys(username, usrName);
	}

	// To enter password
	public void enterPassword(String usrPassword) {
		sendKeys(password, usrPassword);
	}

	// To click signin button
	public void clickSignIn() {
		click(signIn);
	}

	// To check entering valid username and password log the user to dashboard
	public void isSuccessfullyLoggedToDashboard() {

		Assert.assertTrue(dashboard.isDisplayed());
	}

	// To check entering invalid username or password shows message
	public void verifyIsInvalidUsernamePasswordMessageDisplayed() {

		sa.assertTrue(invalidMessage.isDisplayed(), "username or password information doesn't exist! message missing");
		sa.assertAll();
	}

	// To check entering invalid username or password shows the expected message
	public void verifyInvalidUsernamePasswordMessage() {
		String exp_Message = "username or password information doesn't exist!";
		String act_Message = invalidMessage.getText();
		sa.assertEquals(act_Message, exp_Message);
		sa.assertAll();
	}

	// To check keeping username as blank shows message
	public void verifyIsBlankUsernameMessageDisplayed() {
		sa.assertTrue(blankUsernameMsg.isDisplayed(), "Blank Username message not displayed");
		sa.assertAll();
	}

	// To check keeping username as blank shows the expected message
	public void verifyBlankUsernameMessage() {
		String exp_Message = "This value is required.";
		String act_Message = blankUsernameMsg.getText();
		sa.assertEquals(act_Message, exp_Message);
		sa.assertAll();
	}

	
}
