package pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import utilities.PageUtility;

public class PageUser extends PageUtility {

	WebDriver driver;
	SoftAssert sa;

	@FindBy(id = "s-menu")
	WebElement wSearch;
	@FindBy(xpath = "//a[@title='User']")
	WebElement wUser;
	@FindBy(xpath = "//select[@name='DataTables_length']")
	WebElement wSelectTableLength;
	@FindBy(xpath = "//div[@class='dt-buttons']//child::a[1]//i")
	WebElement wPrintIcon;
	@FindBy(xpath = "//div[@class='dt-buttons']//child::a[2]//i")
	WebElement wPrintSelectedIcon;
	@FindBy(xpath = "//div[@class='dt-buttons']//child::a[3]")
	WebElement wXlsxDownloadIcon;
	@FindBy(xpath = "//div[@class='dt-buttons']//child::a[4]//i")
	WebElement wCsvDownloadIcon;
	@FindBy(xpath = "//div[@class='dt-buttons']//child::a[5]//i")
	WebElement wPdfDownloadIcon;
	@FindBy(xpath = "//i[@class='fa fa-filter']")
	WebElement wFilter;
	@FindBy(xpath = "//button[@class='btn btn-default dropdown-toggle']/following-sibling::*//a[text()='Client']")
	WebElement wFilterClient;
	@FindBy(xpath = "//div[@id='DataTables_filter']//input")
	WebElement wSearchAllColumn;
	@FindBy(xpath = "//a[@href='http://buffalocart.com/demo/erp/admin/user/change_banned/18']")
	WebElement wBanIcon;
	@FindBy(xpath = "//a[@href='http://buffalocart.com/demo/erp/admin/user/send_welcome_email/33']")
	WebElement wEmailIcon;
	@FindBy(xpath = "//a[@href='http://buffalocart.com/demo/erp/admin/user/user_list/edit_user/33']")
	WebElement wEditIcon;
	@FindBy(xpath = "//a[@href='http://buffalocart.com/demo/erp/admin/user/delete_user/33']")
	WebElement wDeleteIcon;
	@FindBy(xpath = "//li[@class='paginate_button active']/a")
	WebElement wPaginationOne;
	@FindBy(xpath = "//li[@id='DataTables_next']/a")
	WebElement wPaginationNext;
	@FindBy(xpath = "//tr[@id='table_1']")
	WebElement wFirstUserListRow;
	@FindBys(value = { @FindBy(xpath = "//table[@id='DataTables']//td[5]") })
	List<WebElement> wUserTypeList;
	@FindBys(value = { @FindBy(xpath = "//table[@id='DataTables']//td[2]") })
	List<WebElement> wNameList;
	@FindBys(value = { @FindBy(xpath = "//table[@id='DataTables']//td[3]") })
	List<WebElement> wUserNameList;
	@FindBys(value = { @FindBy(xpath = "//table[@id='DataTables']//tbody/tr") })
	List<WebElement> wRowList;
	@FindBy(xpath = "//td[text()='No matching records found']")
	WebElement wNoMatchingFoundMessage;
	@FindBy(xpath = "//a[@href='http://buffalocart.com/demo/erp/admin/user/user_details/24']")
	WebElement wRandomName;
	@FindBy(xpath = "//a[@href='http://buffalocart.com/demo/erp/admin/user/change_banned/24']/span")
	WebElement wRandomUserForBan;
	@FindBy(xpath = "//a[@href='http://buffalocart.com/demo/erp/admin/user/set_banned/0/24']")
	WebElement wRandomUserForUnBan;
	@FindBy(xpath = "//textarea[@name='ban_reason']")
	WebElement wRandomUserBanReason;
	@FindBy(xpath = "//button[text()='Close']")
	WebElement wRandomUserBanReasonClose;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement wRandomUserBanReasonSave;
	@FindBy(xpath = "//span[text()='Banned']")
	WebElement wRandomUserBannedTag;
	@FindBy(xpath = "//a[@href='http://buffalocart.com/demo/erp/admin/user/send_welcome_email/24']")
	WebElement wRandomUserForMail;
	@FindBy(xpath = "//a[@href='http://buffalocart.com/demo/erp/admin/user/user_list/edit_user/24']")
	WebElement wRandomUserForEdit;
	@FindBy(xpath = "//input[@id='check_employment_id']")
	WebElement wRandomUserForEditEmpId;
	@FindBy(xpath = "//input[@name='phone']")
	WebElement wRandomUserForEditEmpPhone;
	@FindBy(xpath = "//input[@name='skype']")
	WebElement wRandomUserForEditEmpSkype;
	@FindBy(xpath = "// div[@class='form-horizontal']/div[4]/child::div/div/div/label[1]")
	WebElement wRandomUserForEditEmpPermissionMailboxYes;
	@FindBy(xpath = "// div[@class='form-horizontal']/div[4]/child::div/div/div/label[2]")
	WebElement wRandomUserForEditEmpPermissionMailboxNo;
	@FindBy(xpath = "//button[text()='Update User']")
	WebElement wRandomUserForEditEmpUpdate;
	@FindBy(xpath = "//a[@href='http://buffalocart.com/demo/erp/admin/user/delete_user/34']")
	WebElement wRandomUserForDelete;
	@FindBy(xpath = "//button[text()='Proceed Anyway!']")
	WebElement wRandomUserForDeleteProceed;
	
	
	public PageUser(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		sa = new SoftAssert();
	}

	// Checking whether all the details of the page is displayed or not
	public void verifyUserPageDetailsDisplay() {
		sendKeys(wSearch, "User");
		click(wUser);
		sa.assertTrue(wSelectTableLength.isDisplayed(), "Number dropdown is not displayed");
		sa.assertTrue(wPrintIcon.isDisplayed(), "Print Icon is not displayed");
		sa.assertTrue(wPrintSelectedIcon.isDisplayed(), "Selected print icon is not displayed");
		sa.assertTrue(wXlsxDownloadIcon.isDisplayed(), "Xlsx download icon is not displayed");
		sa.assertTrue(wCsvDownloadIcon.isDisplayed(), "Csv download icon is not displayed");
		sa.assertTrue(wPdfDownloadIcon.isDisplayed(), "Pdf download icon is not displayed");
		sa.assertTrue(wFilter.isDisplayed(), "Filter icon is not displayed");
		sa.assertTrue(wSearchAllColumn.isDisplayed(), "Search column is not displayed");
		sa.assertTrue(wFirstUserListRow.isDisplayed(), "User List is not displayed");

		sa.assertTrue(wPaginationOne.isDisplayed(), "Pagination icon is not displayed");
	}

	// checking the function of filter icon
	public void verifyFilterIcon() throws InterruptedException {
		sendKeys(wSearch, "User");
		click(wUser);
		waitForClickable(wFilter);
		click(wFilter);
		// checking the filter for assertion by selecting Client
		click(wFilterClient);
		click(wFilter);
		waitForThread(3);
		for (int i = 0; i < wUserTypeList.size(); i++) {
			String userType = wUserTypeList.get(i).getText();
			System.out.println(userType);
			Assert.assertEquals(userType, "Client", "Filter is not working properly");
		}

	}

	// checking the pdf download icon
	public void verifyDownloadpdfIcon() throws IOException {
		boolean status = download(wPdfDownloadIcon, "User List.pdf");
		Assert.assertFalse(status, "Pdf file not Downloaded");
	}

	// checking the csv download icon
	public void verifyDownloadCsvIcon() throws IOException {
		boolean status = download(wCsvDownloadIcon, "User List.csv");
		Assert.assertFalse(status, "Csv file not Downloaded");
	}

	// checking the xlsx download icon
	public void verifyDownloadXlsxIcon() throws IOException {
		boolean status = download(wXlsxDownloadIcon, "User List.xlsx");
		Assert.assertFalse(status, "Xlsx file not Downloaded");
	}

	// checking the search box functionality
	public void verifySearchAllColumns() throws InterruptedException {
		sendKeys(wSearchAllColumn, "Obsqura");
		String searchData = "Obsqura";
		waitForThread(3);

		// checking the displayed details is correct or not using assertion
		System.out.println("size :" + wRowList.size());
		boolean searchContains = false;

		for (int i = 0; i < wRowList.size(); i++) {
			try {
				String displayName = wNameList.get(i).getText();
				String displayUsername = wUserNameList.get(i).getText();
				System.out.println("Name :" + displayName);
				System.out.println("Username :" + displayUsername);

				if ((displayName.contains(searchData))) {
					searchContains = true;

				} else if ((displayUsername.contains(searchData))) {
					searchContains = true;

				}
				Assert.assertTrue(searchContains, "Search function is not working Properly");
			} catch (Exception e) {

				Assert.assertTrue(wNoMatchingFoundMessage.isDisplayed(), "No matching found message was not displayed");
			}
		}

	}

	// Checking the print icon
	public void verifyPrintIcon() throws Exception {
		waitForClickable(wPrintIcon);
		click(wPrintIcon);
		waitForThread(3);
		robotClassEscapeKey();
		

	}

	// Checking the print selected icon
	public void verifyPrintSelectedIcon() throws Exception {
		waitForClickable(wPrintSelectedIcon);
		click(wPrintSelectedIcon);
		waitForThread(3);
		robotClassEscapeKey();

	}

	// Checking the dropdown for tablelength
	public void verifySelectListing() throws InterruptedException {
		selectDropDownByValue(wSelectTableLength, "25");
		waitForThread(2);;
		int rowSize = wRowList.size();
		System.out.println("size :" + rowSize);
		boolean sizeCount = false;
		if (rowSize <= 25) {
			sizeCount = true;
		}
		Assert.assertTrue(sizeCount, "Selection for listing is not working properly");
	}

	// Checking the banned icon of specific user(Obsqura1)
	public void verifyBannedIcon(String randomUserExcel) {
		sendKeys(wSearchAllColumn, randomUserExcel);
		waitForVisibility(wRandomName);

		if (wRandomUserForBan.isDisplayed()) {
	
			click(wRandomUserForBan);
			String bannedReasonMessage = "Not attending the sessions properly";
			sendKeys(wRandomUserBanReason, bannedReasonMessage);
			click(wRandomUserBanReasonSave);
			// checking whether the user is really banned as per expected condition
			sendKeys(wSearchAllColumn, randomUserExcel);
			waitForVisibility(wRandomName);
			// assert for banned tag
			Assert.assertTrue(wRandomUserBannedTag.isDisplayed(), "Banned tag is not displayed for the banned user");
			String act_bannedMessage = wRandomUserBannedTag.getAttribute("title");
			System.out.println(act_bannedMessage);
			// assert for ban message verification
			Assert.assertEquals(act_bannedMessage, bannedReasonMessage, "The banned reason displayed is not correct");
			// assert for unban icon at the place of ban icon
			Assert.assertTrue(wRandomUserForUnBan.isDisplayed(),
					"The icon to remove or unban the user is not displayed");

		}
		if (wRandomUserForUnBan.isDisplayed()) {
			click(wRandomUserForUnBan); // Removing the ban

		}
	}
	
	//Checking Edit icon
	public void verifyEditIcon(String randomUsr,String empId,String phone,String skypeId) {
		sendKeys(wSearchAllColumn,randomUsr);
		waitForVisibility(wRandomName);
		click(wRandomUserForEdit);
		implicitWait();
		wRandomUserForEditEmpId.clear();
		sendKeys(wRandomUserForEditEmpId, empId);
		wRandomUserForEditEmpPhone.clear();
		sendKeys(wRandomUserForEditEmpPhone,phone);
		wRandomUserForEditEmpSkype.clear();
		sendKeys(wRandomUserForEditEmpSkype, skypeId);
		actionClick(wRandomUserForEditEmpPermissionMailboxYes);
		click(wRandomUserForEditEmpUpdate);
		//Assertion checking whether the data is updated
		waitForVisibility(wSearchAllColumn);
		sendKeys(wSearchAllColumn,randomUsr);
		waitForVisibility(wRandomName);
		click(wRandomUserForEdit);
		implicitWait();
		String act_EmpId=wRandomUserForEditEmpId.getAttribute("value");
		String act_Phone=wRandomUserForEditEmpPhone.getAttribute("value");
		String act_SkypeId=wRandomUserForEditEmpSkype.getAttribute("value");
		Assert.assertEquals(act_EmpId, empId,"The EmploymentId is not updated properly");
		Assert.assertEquals(act_Phone, phone,"The Phone number is not updated properly");
		Assert.assertEquals(act_SkypeId, skypeId,"The Skype id is not updated properly");
		Assert.assertTrue(wRandomUserForEditEmpPermissionMailboxYes.isDisplayed(), "Mailbox Permission Yes is selected but not updated");
	}
	
	//checking delete icon
	public void verifyDeleteIcon(String deleteUser) {
		sendKeys(wSearchAllColumn,deleteUser);
		
		click(wRandomUserForDelete);
		click(wRandomUserForDeleteProceed);
		//assertion for checking the delete
		sendKeys(wSearchAllColumn,deleteUser);
		Assert.assertTrue(wNoMatchingFoundMessage.isDisplayed(), "User is not deleted properly");
			
	}
	
	//checking whether pagination is displayed
	public void verifyPagination() {
		waitForVisibility(wPaginationOne);
		scrollDown(wPaginationOne);
		Assert.assertTrue(wPaginationOne.isDisplayed(), "Pagination is not displayed");
	}
}