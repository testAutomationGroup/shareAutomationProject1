package Test;
import java.awt.AWTException;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Group1_SanityTest extends HeadClass{
	  		
	  /*Code before System Sanity Tests group*/
	  @Parameters({"browser","path"})
	  @BeforeClass
	  public void beforeGroup1_SystemSanityTests(String browser, String path) throws AWTException, IOException {
		  System.out.println("Here we start");
		  //Create test report file for report system sanity tests
		  extent = ResultsBuilder.GetExtent("Group1_SanityTest tests");
		  System.out.println("Here we start again");
		  
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
	  @AfterClass
	  public void AfterGroup1_SSystemSanityTests(String browser) throws InterruptedException {
		  System.out.println("System sanity tests ended for browser " + browser);
		  FuncFile.waitForTimeThread(200);
		  extent.flush();
		  driver.quit();
	  }
	  
	  /*Code for all test cases in System Sanity Tests group*/
	  @Parameters({"browser"})
	  @Test(alwaysRun = true, priority = 1)
	  public void TestCase1(String browser) throws IOException {
		  String testName = "Group1_SanityTest_TestCase1";
		  String Description = "1.1.1 WebSite Logo";
		  test = extent.createTest(testName + "_" +browser, Description);
		  ResultsBuilder.SendTestResult(test, driver, "PASS", testName, browser);
		  Assert.assertTrue(true);
		
	  }

	  @Parameters({"browser"})
	  @Test(enabled = true, priority = 2, dependsOnMethods = "TestCase1")
	  public void TestCase2(String browser) throws IOException {
		  String testName = "Group1_SanityTest_TestCase2";
		  String Description = "1.2.1 Connect to profile";
		  test = extent.createTest(testName + "_"+browser, Description);
		  ResultsBuilder.SendTestResult(test,driver, "PASS", testName, browser);
		  Assert.assertTrue(true);
		
	  }
	  
	  @Parameters({"browser"})
	  @Test(groups = "SystemSanityTests", priority = 3)
	  public void TestCase3(String browser) throws IOException {
		  String testName = "Group1_SanityTest_TestCase3";
		  String Description = "1.2.2 Notifications test";
		  test = extent.createTest(testName + "_"+browser, Description);
		  ResultsBuilder.SendTestResult(test,driver, "PASS", testName, browser);
		  Assert.assertTrue(true);
		
	  }
	  
	  @Parameters({"browser"})
	  @Test(groups = "SystemSanityTests", priority = 4)
	  public void TestCase4(String browser) throws IOException {
		  String testName = "Group1_SanityTest_TestCase4";
		  String Description = "1.2.3 Trips test";
		  test = extent.createTest(testName + "_"+browser, Description);
		  ResultsBuilder.SendTestResult(test,driver, "PASS", testName, browser);
		  Assert.assertTrue(true);
		
	  }
	  
}
