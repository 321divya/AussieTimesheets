package scripts;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;


import org.testng.annotations.Test;

public class TC_RegressionTest extends TestHelper {

	@Test(priority = 1, groups = { "invalid_login" }, description = "Invalid username and invalid password")
	public void tc2_InvalidUsernameInvalidPassword() throws Exception {
		driver.get(url);
		objLogin.enterUsername(excelLogin.readData("Invalid username"));
		objLogin.enterPassword(excelLogin.readData("Invalid password"));
		objLogin.clickSignIn();
		objLogin.verifyIsInvalidUsernamePasswordMessageDisplayed();
		objLogin.verifyInvalidUsernamePasswordMessage();
	}

	@Test(priority = 2, groups = { "invalid_login" }, description = "Blank username and valid password")
	public void tc3_BlankUsernamevalidPassword() throws Exception {
		driver.get(url);
		objLogin.enterUsername(excelLogin.readData("blank"));
		objLogin.enterPassword(excelLogin.readData("password"));
		objLogin.clickSignIn();
		objLogin.verifyIsBlankUsernameMessageDisplayed();
		objLogin.verifyBlankUsernameMessage();
	}

	@Test(priority = 3, groups = { "valid_login", "dashboard_page", "user_page",
			"mailbox_page" }, description = "Valid username and valid password")
	public void tc1_ValidUsernameValidPassword() throws Exception {
		driver.get(url);
		objLogin.enterUsername(excelLogin.readData("username"));
		objLogin.enterPassword(excelLogin.readData("password"));
		objLogin.clickSignIn();
		objLogin.isSuccessfullyLoggedToDashboard();
	}

	@Test(priority = 4, groups = {
			"newuser_registration" }, description = "New User Registration and checking whether the new user added to User's list in the application")
	public void tc4_NewUserRegistrtaion() throws Exception {
		driver.get(url);
		Long currentTime = System.currentTimeMillis();
		String userNameRandom = excelNewUser.readData("Username") + currentTime;
		String emailRandom = userNameRandom + "@abc.com";
		objRegister.clickGetYourAccountButton();
		objRegister.enterNewUserCompanyName(excelNewUser.readData("Company Name"));
		objRegister.enterNewUserCompanyEmail(emailRandom);
		objRegister.selectLanguage(excelNewUser.readData("Language"));
		objRegister.enterNewUserUsername(userNameRandom);
		objRegister.enterNewUserPassword(excelNewUser.readData("Password"));
		objRegister.enterNewUserConfirmPassword(excelNewUser.readData("Confirm Password"));
		objRegister.clickNewUserSignUp();
		objRegister.verifyNewUserSuccessfullyRegisteredMessageDisplayed();
		objRegister.verifyNewUserSuccessfullyRegisteredMessage();
		objLogin.enterUsername(excelLogin.readData("username"));
		objLogin.enterPassword(excelLogin.readData("password"));
		objLogin.clickSignIn();
		objLogin.implicitWait();
		objRegister.verifyNewUsernameInAllUsersList(userNameRandom);
	}

	@Test(priority = 5, groups = { "dashboard_page" }, description = "Dashboard Page verification")
	public void tc5_VerifyDashboardPage() throws Exception {
		
		objDashboard.implicitWait();
		objDashboard.verifyMenuItemsDisplayed();
		objDashboard.verifyDashboardItemsDisplayed();
	}

	@Test(priority = 6, groups = { "user_page" }, description = "User page display verification")
	public void tc6_VerifyUserPage() throws Exception {

		objLogin.implicitWait();
		objUser.verifyUserPageDetailsDisplay();
	}

	// @Test(priority=7,groups= {"user_page"},description="User page filter icon verification")
	public void tc7_VerifyFilterUserPage() throws InterruptedException {
		objUser.verifyFilterIcon();
	}

	// @Test(priority = 8, groups = { "user_page" }, description = "User page Search all columns bar verification")
	public void tc8_VerifySearchUserPage() throws InterruptedException {
		objUser.verifySearchAllColumns();
	}

	// @Test(priority=9,groups= {"user_page"},description="Select the number of user listing in page")
	public void tc9_SelectNumberOfListingInPage() throws InterruptedException {
		objUser.verifySelectListing();
	}

	// @Test(priority=10,groups= {"user_page"},description="User page Print icon verification")
	public void tc10_VerifyPrintIconUserPage() throws Exception {
		objUser.verifyPrintIcon();

	}

	// @Test(priority=11,groups= {"user_page"},description="User page Print selectedicon verification")
	public void tc11_VerifyPrintSelectedIconUserPage() throws Exception {
		objUser.verifyPrintSelectedIcon();

	}

	// @Test(priority=12,groups= {"user_page"},description="User page download pdf icon verification")
	public void tc12_13_14_VerifyDownloadIconUserPage() throws IOException {
		objUser.verifyDownloadpdfIcon();
		objUser.verifyDownloadCsvIcon();
		objUser.verifyDownloadXlsxIcon();
	}

	//@Test(priority=13,groups= {"user_page"},description="Verifying User page banned icon of specific user")
	public void tc15_VerifyBannedIconUserPage() throws Exception {
		objUser.verifyBannedIcon(excelRandomUser.readData("RandomUser"));
	}

	@Test(priority = 14, groups = {"user_page" }, description = "Verifying User page edit icon of specific user", dataProvider = "ReadFromExcel")
	public void tc17_VerifyEditIconUserPage(String randomUsr,String empId,String phone,String skypeId) {
		
		objUser.verifyEditIcon(randomUsr,empId,phone,skypeId);
		
	}

	

	//@Test(priority=15,groups= {"user_page"},description="Verifying User page delete icon of specific user")
	public void tc18_VerifyDeleteIconUserPage() throws Exception {
			
		objUser.verifyDeleteIcon("ObClient1");
	}

	//@Test(priority=16,groups= {"user_page"},description="Verifying User page pagination is displayed")
	public void tc19_VerifyPaginationUserPage() {
		objUser.verifyPagination();;
	}

	@Test(priority = 15, groups = { "mailbox_page" }, description = "Mailbox page verification")
	public void tc20_VerifyMailBoxPage() throws Exception {

		objLogin.implicitWait();
		objMailbox.verifyAllItemsDisplayedInPage();
	}
	
	@Test(priority = 16, groups = { "mailbox_page" }, description = "Mailbox page verification")
	public void tc21_VerifyCheckboxIconMailBoxPage() {
		objMailbox.verifyCheckboxIcon();	
	}
	
	@Test(priority = 17, groups = { "mailbox_page" }, description = "Compose function verification")
	public void tc25_VerifyComposeButtonMailBoxPage() throws Exception  {
		objMailbox.composeMailFunctionality(excelComposeMail.readData("To"),excelComposeMail.readData("Subject"),excelComposeMail.readData("Description"),excelComposeMail.readData("UploadFile"));
			
	}
}
