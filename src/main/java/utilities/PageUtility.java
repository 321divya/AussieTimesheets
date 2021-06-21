package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

public class PageUtility {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions act;
	

	public PageUtility(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver, 30);
		js=(JavascriptExecutor)driver;
		act= new Actions(driver);
	}
	
	//**************************** sendKeys****************************************
	public void sendKeys(WebElement e,String message) {
		e.sendKeys(message);
	}
	//*************************** click *********************************************
	public void click(WebElement e) {
		e.click();
	}
	//**************************** wait **********************************************
	public void waitForVisibility(WebElement e) {
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	public void waitForClickable(WebElement e) {
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}
	 public void implicitWait() {
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 }
	 public void waitForAlertPresent() {
		 wait.until(ExpectedConditions.alertIsPresent());
	 }
	 
	//****************** thread *******************************************
	 public void waitForThread(int index) throws InterruptedException {
		 Thread.sleep(index *1000); 
	 }
	
	 //********************** Robot class *************************************
	 public void robotClassEscapeKey() throws AWTException {
		 Robot robot=new Robot();
		 robot.keyPress(KeyEvent.VK_META);
		  robot.keyPress(KeyEvent.VK_TAB);
		  robot.keyRelease(KeyEvent.VK_META);
		  robot.keyRelease(KeyEvent.VK_TAB);
		  robot.delay(500);
		 robot.keyPress(KeyEvent.VK_ESCAPE);
	     robot.keyRelease(KeyEvent.VK_ESCAPE);
		 
	 }
	//***************************** Select Class********************************************
	public void selectDropDownByValue(WebElement e,String value) {
		Select s1=new Select(e);
		s1.selectByValue(value);
	}
	
	public void selectDropDownByIndex(WebElement e,int index) {
		Select s1=new Select(e);
		s1.selectByIndex(index);
	}
	
	public void selectDropDownByText(WebElement e,String text) {
		Select s1=new Select(e);
		s1.selectByVisibleText(text);
	}
	
	
	
	//*************************** Scroll Down***********************************************
	public void scrollDown(WebElement e) {
		js.executeScript("arguments[0].scrollIntoView();", e);
	}
	
	//*********************** Actions class *******************************
	public void actionClick(WebElement e) {
		act.click(e).build().perform();
	}
	public void actionSendKeys(WebElement e,String message) {
		act.sendKeys(e,message).build().perform();
	}
	
	//********************** File Download ********************************
	public boolean download(WebElement e,String fileName) throws IOException {
		e.click();
		//copying downloaded file to a different location
		File srcFile=new File("/Users/divyarajappan/Downloads/"+fileName);
		File destFile=new File(System.getProperty("user.dir")+"/DownloadFile/"+System.currentTimeMillis()+fileName);
		String flPath=destFile.getAbsolutePath();
		
		boolean fileDownloadInProgress=true;
		while(fileDownloadInProgress) {
			if(srcFile.exists()) {
				FileUtils.copyFile(srcFile, destFile);
				fileDownloadInProgress=false;	
			}
			else {
				fileDownloadInProgress=true;
			}
		}
		return fileDownloadInProgress;
	}
	
	
	
	//********************* File Upload ************************************
	 public void fileUploadMac(String path) throws AWTException {
		  
		  File file=new File(path);
		  StringSelection strSelection= new StringSelection(file.getAbsolutePath());
		  
		  Clipboard clipboard= Toolkit.getDefaultToolkit().getSystemClipboard();
		  clipboard.setContents(strSelection, null);
		
		    
		
		  Robot robot=new Robot();
		  robot.keyPress(KeyEvent.VK_META);
		  robot.keyPress(KeyEvent.VK_TAB);
		  robot.keyRelease(KeyEvent.VK_META);
		  robot.keyRelease(KeyEvent.VK_TAB);
		  robot.delay(500);
		  
		  robot.keyPress(KeyEvent.VK_META);
		  robot.keyPress(KeyEvent.VK_SHIFT);
		  robot.keyPress(KeyEvent.VK_G);
		  robot.keyRelease(KeyEvent.VK_META);
		  robot.keyRelease(KeyEvent.VK_SHIFT);
		  robot.keyRelease(KeyEvent.VK_G);
		  
		  //copying the clipboard value
		  robot.delay(1000);
		  robot.keyPress(KeyEvent.VK_META);
		  robot.keyPress(KeyEvent.VK_V);
		  robot.delay(1000);
		  robot.keyRelease(KeyEvent.VK_META);
		  robot.keyRelease(KeyEvent.VK_V);
		  
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.keyRelease(KeyEvent.VK_ENTER);
		  robot.delay(1000);
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.keyRelease(KeyEvent.VK_ENTER);
		    
	  }
	
	//************************Alert *****************************************
	public void alertAccept() {
		Alert al=driver.switchTo().alert();
		al.accept();
		driver.switchTo().defaultContent();
	}
	
	public void alertDismiss() {
		Alert al=driver.switchTo().alert();
		al.dismiss();
		driver.switchTo().defaultContent();
	}
	
	public void alertSendKeys(String message) {
		driver.switchTo().alert().sendKeys("message");
	}
	//******************* iframe *************************************
	public void iframeIndexSwitch(int n) {
		driver.switchTo().frame(n);
	}
	
	//******************** Swichto default***************************
	public void defaultSwitch() {
		driver.switchTo().defaultContent();
	}
	
	//********************** Window Handle **********************************
//	public void windowHandleSwitch(WebElement e) {
//		String mainWindow=driver.getWindowHandle();
//		e.click();
//		Set<String>s1=driver.getWindowHandles();
//		Iterator<String>i1=s1.iterator();
//		while(i1.hasNext()) {
//			String childWindow=i1.next();
//			
//			if(!mainWindow.equalsIgnoreCase(childWindow)) {
//				driver.switchTo().window(childWindow);
//			}
//		}
		
//	}
	

	
	
}
