package Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class runningTests {
  
	static WebDriver driver;
	  /*Code before System Sanity Tests group*/
	  @Parameters({"browser","path"})
	  @BeforeGroups("SystemSanityTests")
	  public void beforeSystemSanityTests(String browser, String path) {
		  
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
		  driver.quit();
	  }
	  
	  /*Code for all test cases in System Sanity Tests group*/
	  @Parameters({"TestImagesPath", "testExcelFilesPath"})
	  @Test(alwaysRun = true, groups = "SystemSanityTests", priority = 1)
	  public void TestCase1(String TestImagesPath, String testExcelFilesPath) throws IOException {
		  System.out.println("TestCase1");
		  
		  /*Take a screen image*/
//			try {
//				FuncFile.takeScreenImage(driver, TestImagesPath);
//			} catch (IOException e) {
//				System.out.println("\nError" + e.getMessage());
//				e.printStackTrace();
//			} 
			/* Open a file*/
			try {
				//String path = FuncFile.createFile(testExcelFilesPath);
				String filePath =  "C:\\my files\\testExcelFiles\\testFile1.xlsx";
				FuncFile.addFileData(filePath,"גבדיקה1 3בדיקה בדיקה",0,0);
				System.out.println("Here1 " + filePath);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	  }
	  
	  @Test(enabled = true, groups = "SystemSanityTests", priority = 2, dependsOnMethods = "TestCase1")
	  public void TestCase2() {
		  System.out.println("TestCase2");
	  }
	  
	  @Test(groups = "SystemSanityTests", priority = 3, dependsOnMethods = "TestCase2")
	  public void TestCase3() {
		  System.out.println("TestCase3");
	  } 
}
