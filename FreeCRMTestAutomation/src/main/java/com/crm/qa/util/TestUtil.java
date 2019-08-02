package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
 public static long PAGE_LOAD_TIMEOUT=20;
 public static long IMPLICIT_WAIT=20;
 public static String TestData_sheet_path="C:\\Users\\ptangade\\workspace\\FreeCRMTestAutomation\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx";
 static Workbook book;
 static org.apache.poi.ss.usermodel.Sheet sheet;
 
 public void switchToFrame(){
	 driver.switchTo().frame("mainpanel");
 }
 
 public static Object[][] getTestData(String sheetName){
	 FileInputStream file=null;
	 try {
		file=new FileInputStream(TestData_sheet_path);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	 sheet=book.getSheet(sheetName);
	 Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	 for(int i=0;i<sheet.getLastRowNum();i++){
		 for (int k=0;k<sheet.getRow(0).getLastCellNum();k++){
			 data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			 
		 }
	 }
	 return data;
 }
 
 public static void takeScreenshotAtEndOfTest() throws IOException {
	 	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 		String currentDir = System.getProperty("user.dir");
	 		FileHandler.copy( scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	 		
	 		}
}

