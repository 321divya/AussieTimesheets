package pages;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import utilities.PageUtility;

public class PageMailbox extends PageUtility {

	WebDriver driver;
	SoftAssert sa;

	@FindBy(xpath = "//a[@title='Mailbox']/span")
	WebElement wMailBox;
	@FindBy(xpath = "//h3[@class='panel-title']")
	WebElement wAllMessages;
	@FindBy(xpath = "//a[@href='http://buffalocart.com/demo/erp/admin/mailbox/index/inbox']")
	WebElement wInbox;
	@FindBy(xpath = "//a[@href='http://buffalocart.com/demo/erp/admin/mailbox/index/sent']")
	WebElement wSent;
	@FindBy(xpath = "//a[@href='http://buffalocart.com/demo/erp/admin/mailbox/index/draft']")
	WebElement wDrafts;

	@FindBy(xpath = "//a[@href='http://buffalocart.com/demo/erp/admin/mailbox/index/favourites']")
	WebElement wFavourites;

	@FindBy(xpath = "//a[@href='http://buffalocart.com/demo/erp/admin/mailbox/index/trash']")
	WebElement wTrash;

	@FindBy(xpath = "//input[@id='parent_present']")
	WebElement wCheckBoxIcon;

	@FindBy(xpath = "//button[@class='btn btn-default btn-xs mr-sm']")
	WebElement wDeleteIcon;

	@FindBy(xpath = "//i[@class='fa fa-refresh']")
	WebElement wRefreshIcon;

	@FindBy(xpath = "//a[@href='http://buffalocart.com/demo/erp/admin/mailbox/index/compose']")
	WebElement wComposeButton;
	@FindBy(xpath = "//input[@placeholder='To : Select or Write']")
	WebElement wComposeMailTo;
	@FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']")
	WebElement wComposeMailToSelected;
	@FindBy(xpath = "//input[@placeholder='Subject:']")
	WebElement wComposeMailSubject;
	@FindBy(xpath = "//html[@dir='ltr']//p")
	WebElement wcomposeMailDescription;
	@FindBy(xpath = "//div[@class='dz-default dz-message']//span")
	WebElement wcomposeMailUpload;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement wcomposeMailSend;
	
	@FindBys(value = { @FindBy(xpath = "//table//tr") })
	List<WebElement> wInboxMailsList;
	@FindBys(value = { @FindBy(xpath = "//table//tr/td[1]//input") })
	List<WebElement> wInboxMailsCheckboxList;

	public PageMailbox(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		sa = new SoftAssert();
	}

	public void verifyAllItemsDisplayedInPage() {
		click(wMailBox);
		sa.assertTrue(wAllMessages.isDisplayed(), "All Messages heading is not displayed");
		sa.assertTrue(wInbox.isDisplayed(), "Inbox is not displayed in Page");
		sa.assertTrue(wSent.isDisplayed(), "Sent is not displayed in Page");
		sa.assertTrue(wDrafts.isDisplayed(), "Drafts is not displayed in Page");
		sa.assertTrue(wFavourites.isDisplayed(), "Favourites is not displayed in Page");
		sa.assertTrue(wTrash.isDisplayed(), "Trash is not displayed in Page");
		sa.assertTrue(wCheckBoxIcon.isDisplayed(), "Checkbox Icon is not  displayed in Page");
		sa.assertTrue(wDeleteIcon.isDisplayed(), "Delete Icon is not displayed in Page");
		sa.assertTrue(wRefreshIcon.isDisplayed(), "Refresh Icon is not displayed in Page");
		sa.assertTrue(wComposeButton.isDisplayed(), "Compose button is not displayed in Page");
		//inbox mails displayed in the page
		int inboxlist = wInboxMailsList.size();
		for (int i = 0; i < inboxlist; i++) {
			sa.assertTrue((wInboxMailsList.get(i)).isDisplayed(), "All the mails in inbox is not displayed");
		}
		sa.assertAll();

	}

	// checking checkbox icon
	public void verifyCheckboxIcon() {
		click(wCheckBoxIcon);
		Assert.assertTrue(wCheckBoxIcon.isSelected(), "Checkbox icon is not selected");
		// verifying when we click that checkbox all inbox mail checkbox is selected.
		int checkboxList = wInboxMailsCheckboxList.size();
		System.out.println("size:" + checkboxList);
		for (int i = 0; i < checkboxList; i++) {
			Assert.assertTrue((wInboxMailsCheckboxList.get(i)).isSelected(), "All the mails in inbox is not selected");
		}

	}

	public void clickComposeButton() {
		click(wComposeButton);
	}
	public void enterComposeMailTo(String composeTo) {	
		waitForVisibility(wComposeMailTo);
		sendKeys(wComposeMailTo, composeTo);
		click(wComposeMailToSelected);
	}
	public void enterComposeMailSubject(String composeSubject) {	
		sendKeys(wComposeMailSubject, composeSubject);	
	}
	public void enterComposeMailDescription(String composeDescription) {
		iframeIndexSwitch(0);
		actionSendKeys(wcomposeMailDescription, composeDescription);
		defaultSwitch();
		
	}
	public void enterComposeMailClickUpload(String path) throws AWTException, InterruptedException {	
		click(wcomposeMailUpload);
		Thread.sleep(3000);
		fileUploadMac(path);
	}
	public void sendButton() throws InterruptedException {
		
		waitForVisibility(wcomposeMailSend);
		actionClick(wcomposeMailSend);
	}
}
