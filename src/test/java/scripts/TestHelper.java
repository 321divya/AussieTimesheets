package scripts;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.PageDashboard;
import pages.PageLogin;
import pages.PageMailbox;
import pages.PageNewUserRegister;
import pages.PageUser;
import utilities.ExcelUtility;

public class TestHelper {
	WebDriver driver;
	PageLogin objLogin;
	PageNewUserRegister objRegister;
	PageDashboard objDashboard;
	PageUser objUser;
	PageMailbox objMailbox;
	ExcelUtility excelLogin;
	ExcelUtility excelNewUser;
	ExcelUtility excelRandomUser;
	ExcelUtility excelComposeMail;

	String url;

	@BeforeClass(groups = { "invalid_login", "valid_login", "newuser_registration", "dashboard_page", "user_page",
			"mailbox_page" })
	public void init() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/divyarajappan/eclipse-workspace/AussieTimesheets/drivers/chromedriver");
		driver = new ChromeDriver();

		objLogin = new PageLogin(driver);
		objRegister = new PageNewUserRegister(driver);
		objDashboard = new PageDashboard(driver);
		objUser = new PageUser(driver);
		objMailbox = new PageMailbox(driver);
		excelLogin = new ExcelUtility("Login");
		excelNewUser = new ExcelUtility("NewUser");
		excelRandomUser = new ExcelUtility("UserPage");
		excelComposeMail = new ExcelUtility("ComposeMail");
		url = "http://buffalocart.com/demo/erp/login";
	}

	@AfterClass
	public void close() {

	}

	// **************** DataProvider ********************
	@DataProvider(name = "ReadFromExcel")
	public Object[][] readData() throws IOException {
		FileInputStream fls = new FileInputStream(
				"/Users/divyarajappan/eclipse-workspace/AussieTimesheets/src/main/resources/Testdata_AussieSheet.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(fls);
		XSSFSheet sheet = book.getSheet("UserPageEdit");
		XSSFRow row = sheet.getRow(0);

		int r = sheet.getLastRowNum() + 1; // getting last row number
		int c = row.getLastCellNum(); // getting last column number
		System.out.println("r=" + r);
		System.out.println("c=" + c);

		String values[][] = new String[r][c];

		for (int i = 0; i < r; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < c; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter formatter = new DataFormatter();
				values[i][j] = formatter.formatCellValue(cell);

			}
		}
		return values;

	}

}
