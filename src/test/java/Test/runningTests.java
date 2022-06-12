package Test;
import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class runningTests {
  
	static WebDriver driver;
	
	//define extent reportFile
	static ExtentReports extent;
	static ExtentTest test;
	ExtentManager exm = new ExtentManager(driver);
		
	  /*Code before System Sanity Tests group*/
	  @Parameters({"browser","path"})
	  @BeforeGroups("SystemSanityTests")
	  public void beforeSystemSanityTests(String browser, String path) throws AWTException, IOException {
		  System.out.println("Here we start");
		  //create tests for report manager
		  extent = exm.GetExtent();
		  System.out.println("Here we start again");
		  //test.pass("text",MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
		  //test.addScreenCaptureFromPath("path");
		  
		  
		  try {
			  System.out.println("Start testing");
			
			  //load pageLoadingTime for runningTests class functions
			  String pageLoadingTime = FuncFile.importConfigurationsData("PageLoadingTime");
			  System.out.println("Parameter page loading value is " + pageLoadingTime);
			  //open browser for each browser parameter value
			  System.out.println("System sanity tests started for browser " + browser);
			  System.out.println("Path is " + path);
			  if (browser.equals("chrome")) {
				  System.out.println("Open browser " + browser);
				  driver = FuncFile.openBrowserChrome(driver, path);
			  }else if (browser.equals("Firefox")) {
				  System.out.println("Open browser " + browser);
				  driver = FuncFile.openBrowserFirefox(driver, path);
			  }else if (browser.equals("Edge")) {
				  System.out.println("Open browser " + browser);
				  driver = FuncFile.openBrowserEdge(driver, path);
			  }
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	  }
	  
	  /*Code after System Sanity Tests group*/
	  @Parameters({"browser"})
	  @AfterGroups("SystemSanityTests")
	  public void AfterSystemSanityTests(String browser) throws InterruptedException {
		  System.out.println("System sanity tests ended for browser " + browser);
		  FuncFile.waitForTimeThread(600);
		  extent.flush();
		  driver.quit();
	  }
	  
	  /*Code for all test cases in System Sanity Tests group*/
	  @Parameters({"TestImagesPath", "testExcelFilesPath"})
	  @Test(alwaysRun = true, groups = "SystemSanityTests", priority = 1)
	  public void TestCase1(String TestImagesPath, String testExcelFilesPath) throws IOException {
		  System.out.println("TestCase1");
		  test = exm.createTest("TestCase1", "description1");
		  test.pass("text1");
		  test.fail("text2");
		  /*Take a screen image*/
///			try {
///				FuncFile.takeScreenImage(driver, TestImagesPath);
///			} catch (IOException e) {
///				System.out.println("\nError" + e.getMessage());
///				e.printStackTrace();
///			} 
			/* Open a file*/
			try {
				///String path = FuncFile.createFile(testExcelFilesPath);
				String filePath =  "C:\\my files\\testExcelFiles\\testFile1.xlsx";
				///addFileData1(filePath,"גבדיקה1 3בדיקה בדיקה",0,0);
				System.out.println("Here1 " + filePath);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	  }
	  
	  @Test(enabled = true, groups = "SystemSanityTests", priority = 2, dependsOnMethods = "TestCase1")
	  public void TestCase2() {
		  System.out.println("TestCase2");
		  test = exm.createTest("TestCase2", "description2");
		  test.pass("text1");
	  }
	  
	  @Test(groups = "SystemSanityTests", priority = 3, dependsOnMethods = "TestCase2")
	  public void TestCase3() {
		  System.out.println("TestCase3");
		  test = exm.createTest("TestCase3", "description3");
		  test.pass("text1");
	  } 
	  
	  /*Add data into existing excel file*/
		public static void addFileData1(String filePath, String value, int rowNumber, int cellNumber) throws IOException {
				
				FileInputStream inputstream = new FileInputStream(new File(filePath));
				System.out.println("before workbook");
				XSSFWorkbook workbook = null;
				try {
					workbook = (XSSFWorkbook) WorkbookFactory.create(inputstream);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.getMessage();
					e.printStackTrace();
				}
				System.out.println("after workbook");
				org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
				Row row = sheet.getRow(rowNumber);
				if (row==null) {
					row = sheet.createRow(rowNumber);
				}
				org.apache.poi.ss.usermodel.Cell cell = row.getCell(cellNumber);
				if (cell==null) {
					cell = row.createCell(cellNumber);
				}
				cell.setCellValue(value);
				
				FileOutputStream outputstream = new FileOutputStream(filePath);
				try {
					workbook.write(outputstream);
					//workbook.setSheetName(0, "names");
					workbook.close();
					outputstream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
}
