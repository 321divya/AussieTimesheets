package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import utilities.PageUtility;

public class PageDashboard extends PageUtility {

	WebDriver driver;
	SoftAssert sa;

	@FindBy(xpath = "//a[@title='Dashboard']/span")
	WebElement dashboard;

	@FindBy(xpath = "//a[@title='Calendar']/span")
	WebElement calender;

	@FindBy(xpath = "//a[@title='Mailbox']/span")
	WebElement mailBox;

	@FindBy(xpath = "//a[@title='File Manager']/span")
	WebElement fileManager;

	@FindBy(xpath = "//a[@title='Projects']/span")
	WebElement projects;

	@FindBy(xpath = "//a[@title='Tasks']/span")
	WebElement tasks;

	@FindBy(xpath = "//a[@title='Bugs']/span")
	WebElement bugs;

	@FindBy(xpath = "//a[@title='Opportunities']/span")
	WebElement opportunities;

	@FindBy(xpath = "//a[@href='#stock']")
	WebElement stock;

	@FindBy(xpath = "//a[@title='Leads']")
	WebElement leads;

	@FindBy(xpath = "//a[@href='#sales']")
	WebElement sales;

	@FindBy(xpath = "//a[@title='Tickets']")
	WebElement tickets;

	@FindBy(xpath = "//a[@href='#knowledgebase']/span")
	WebElement knowledgeBase;

	@FindBy(xpath = "//a[@href='#transactions_menu']/span")
	WebElement transactions;

	@FindBy(xpath = "//a[@title='Client']/span")
	WebElement client;

	@FindBy(xpath = "//a[@title='Departments']")
	WebElement departments;

	@FindBy(xpath = "//a[@href='#office_stock']/span")
	WebElement officeAsset;

	@FindBy(xpath = "//a[@href='#attendance']/span")
	WebElement attendence;

	@FindBy(xpath = "//a[@href='#job_circular']/span")
	WebElement recruitment;

	@FindBy(xpath = "//a[@href='#payroll']")
	WebElement payroll;

	@FindBy(xpath = "//a[@href='#performance']/span")
	WebElement performance;

	@FindBy(xpath = "//a[@title='Leave Management']/span")
	WebElement leaveManagement;

	@FindBy(xpath = "//a[@title='Training']")
	WebElement training;

	@FindBy(xpath = "//a[@title='Announcements']")
	WebElement announcements;

	@FindBy(xpath = "//a[@href='#utilities']")
	WebElement utilities;

	@FindBy(xpath = "//a[@href='#report']")
	WebElement reports;

	@FindBy(xpath = "//a[@title='User']")
	WebElement user;

	@FindBy(xpath = "//a[@title='Settings']/span")
	WebElement settings;

	@FindBy(xpath = "//a[@title='Backup Database']/span")
	WebElement backUpDatabase;

	@FindBy(xpath = "//a[@title='Private Chat']/span")
	WebElement privateChat;

	@FindBy(xpath = "//p[@class='mb0 text-muted' and text()='Invoice Today']")
	WebElement invoiceToday;

	@FindBy(xpath = "//p[text()='Payment Today']")
	WebElement paymentToday;

	@FindBy(xpath = "//p[text()='Paid Amount']")
	WebElement paidAmount;

	@FindBy(xpath = "//p[text()='Due Amount']")
	WebElement dueAmount;

	@FindBy(xpath = "//p[text()='In Progress Task']")
	WebElement inProgressTask;

	@FindBy(xpath = "//p[text()='Open Tickets']")
	WebElement openTickets;

	@FindBy(xpath = "//p[text()='In Progress Bugs']")
	WebElement inProgressBugs;

	@FindBy(xpath = "//p[text()='In Progress Projects']")
	WebElement inProgressProjects;

	@FindBy(xpath = "//h3[text()='My Calendar']")
	WebElement myCalender;

	@FindBy(xpath = "//h3[text()='Goal Reports']")
	WebElement goalReports;

	@FindBy(xpath = "//div[@id='21']//child::h3")
	WebElement financeOverview;

	@FindBy(xpath = "//h3[text()='Income Vs Expense']")
	WebElement incomeVsExpense;

	@FindBy(xpath = "//h3[text()='Recent Activities']")
	WebElement recentActivities;

	@FindBy(xpath = "//h3[text()='Recently Paid Invoices']")
	WebElement recentlyPaidInvoices;

	@FindBy(xpath = "//h3[text()='My Project']")
	WebElement myProject;

	@FindBy(xpath = "//h3[text()='My Tasks']")
	WebElement myTasks;

	@FindBy(xpath = "//h3[text()='Announcements']")
	WebElement announcement;

	@FindBy(xpath = "//div[@id='22']//child::h3")
	WebElement toDoList;

	@FindBy(xpath = "//h3[text()='Expense Report']")
	WebElement expenseReport;

	public PageDashboard(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		sa = new SoftAssert();
	}

	// checking all the items listed in the side menu bar
	public void verifyMenuItemsDisplayed() {
		sa.assertTrue(dashboard.isDisplayed(), "Dashboard is not displayed in Menu List");
		sa.assertTrue(calender.isDisplayed(), "Calender is not displayed in Menu List");
		sa.assertTrue(mailBox.isDisplayed(), "Mailbox is not displayed in Menu List");
		sa.assertTrue(fileManager.isDisplayed(), "File Manager is not displayed in Menu List");
		sa.assertTrue(projects.isDisplayed(), "Projects is not displayed in Menu List");
		sa.assertTrue(tasks.isDisplayed(), "Tasks is not displayed in Menu List");
		sa.assertTrue(bugs.isDisplayed(), "Bugs is not displayed in Menu List");
		sa.assertTrue(opportunities.isDisplayed(), "Opportunities is not displayed in Menu List");
		sa.assertTrue(stock.isDisplayed(), "Stock is not displayed in Menu List");
		sa.assertTrue(leads.isDisplayed(), "Leads is not displayed in Menu List");
		sa.assertTrue(sales.isDisplayed(), "Sales is not displayed in Menu List");
		sa.assertTrue(tickets.isDisplayed(), "Tickets is not displayed in Menu List");
		sa.assertTrue(knowledgeBase.isDisplayed(), "Knowledge Base is not displayed in Menu List");
		sa.assertTrue(transactions.isDisplayed(), "Transactions is not displayed in Menu List");
		sa.assertTrue(client.isDisplayed(), "Client is not displayed in Menu List");
		sa.assertTrue(departments.isDisplayed(), "Departments is not displayed in Menu List");
		sa.assertTrue(officeAsset.isDisplayed(), "Office Asset is not displayed in Menu List");
		sa.assertTrue(attendence.isDisplayed(), "Attendence is not displayed in Menu List");
		sa.assertTrue(recruitment.isDisplayed(), "Recruitment is not displayed in Menu List");
		sa.assertTrue(payroll.isDisplayed(), "Payroll is not displayed in Menu List");
		sa.assertTrue(performance.isDisplayed(), "Performance is not displayed in Menu List");
		sa.assertTrue(leaveManagement.isDisplayed(), "Leave Management is not displayed in Menu List");
		sa.assertTrue(training.isDisplayed(), "Training is not displayed in Menu List");
		sa.assertTrue(announcements.isDisplayed(), "Announcements is not displayed in Menu List");
		sa.assertTrue(utilities.isDisplayed(), "Utilities is not displayed in Menu List");
		sa.assertTrue(reports.isDisplayed(), "Reports is not displayed in Menu List");
		sa.assertTrue(user.isDisplayed(), "User is not displayed in Menu List");
		sa.assertTrue(settings.isDisplayed(), "Settings is not displayed in Menu List");
		sa.assertTrue(backUpDatabase.isDisplayed(), "Backup Database is not displayed in Menu List");
		sa.assertTrue(privateChat.isDisplayed(), "Private Chat is not displayed in Menu List");
		sa.assertAll();

	}

	public void verifyDashboardItemsDisplayed() {
		sa.assertTrue(invoiceToday.isDisplayed(), "Invoice Today is not displayed in the Dashboard page");
		sa.assertTrue(paymentToday.isDisplayed(), "Payment Today is not displayed in the Dashboard page");
		sa.assertTrue(paidAmount.isDisplayed(), "Paid Amount is not displayed in the Dashboard page");
		sa.assertTrue(dueAmount.isDisplayed(), "Due Amount is not displayed in the Dashboard page");
		sa.assertTrue(inProgressTask.isDisplayed(), "In Progress Task is not displayed in the Dashboard page");
		sa.assertTrue(openTickets.isDisplayed(), "openTickets is not displayed in the Dashboard page");
		sa.assertTrue(inProgressBugs.isDisplayed(), "inProgressBugs is not displayed in the Dashboard page");
		sa.assertTrue(inProgressProjects.isDisplayed(), "inProgressProjects is not displayed in the Dashboard page");
		sa.assertTrue(myCalender.isDisplayed(), "myCalender is not displayed in the Dashboard page");
		sa.assertTrue(goalReports.isDisplayed(), "goalReports is not displayed in the Dashboard page");
		sa.assertTrue(financeOverview.isDisplayed(), "financeOverview is not displayed in the Dashboard page");
		sa.assertTrue(incomeVsExpense.isDisplayed(), "incomeVsExpense is not displayed in the Dashboard page");
		sa.assertTrue(recentActivities.isDisplayed(), "recentActivities is not displayed in the Dashboard page");
		sa.assertTrue(recentlyPaidInvoices.isDisplayed(),
				"recentlyPaidInvoices is not displayed in the Dashboard page");
		sa.assertTrue(myProject.isDisplayed(), "myProject is not displayed in the Dashboard page");
		sa.assertTrue(myTasks.isDisplayed(), "myTasks is not displayed in the Dashboard page");
		sa.assertTrue(announcement.isDisplayed(), "announcement is not displayed in the Dashboard page");
		sa.assertTrue(toDoList.isDisplayed(), "toDoList is not displayed in the Dashboard page");
		sa.assertTrue(expenseReport.isDisplayed(), "expenseReport is not displayed in the Dashboard page");
		sa.assertAll();

	}
}
