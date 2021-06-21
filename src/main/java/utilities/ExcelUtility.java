package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class ExcelUtility {
	String sheetName;
	
	public ExcelUtility(String sheetName) {
		this.sheetName=sheetName;
		
	}
	
	public String readData(String header) throws Exception {
		FileInputStream fls=new FileInputStream("/Users/divyarajappan/eclipse-workspace/AussieTimesheets/src/main/resources/Testdata_AussieSheet.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fls);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		XSSFRow row=sheet.getRow(0);
		int colm_num=-1;
		
		for(int i=0;i<row.getLastCellNum();i++) {
			if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(header)) {
				colm_num=i;
			}
		}
		if(colm_num==-1) {
			Assert.fail("No heading found");
			System.out.println("No heading found");
		}
		row=sheet.getRow(1);
		XSSFCell cell=row.getCell(colm_num);
		DataFormatter formatter=new DataFormatter();
		String value=formatter.formatCellValue(cell);
		return value.trim();
		
	}

}
