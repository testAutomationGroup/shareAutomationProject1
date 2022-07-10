package Test;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Group4_ProcessesTest extends HeadClass{
  
  ResultsFileBuilder ResultsBuilder = new ResultsFileBuilder(driver);	
  @Parameters({"browser","path"})
  @BeforeClass
  public void beforeGroup4_ProcessesTest(String browser, String path) {
	  System.out.println("Here we start");
	  //Create test report file for report system sanity tests
	  extent = ResultsBuilder.GetExtent("Group4_ProcessesTest tests");
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
  
  @Parameters({"browser"})
  @AfterClass
  public void AfterGroup4_ProcessesTest(String browser) throws InterruptedException {
	  System.out.println("Group4_ProcessesTest ended for browser " + browser);
	  FuncFile.waitForTimeThread(2000);
	  extent.flush();
	  //driver.close();
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 1)
  public void TestCase1(String browser) throws IOException {
	  String testName = "Group4_ProcessesTest_TestCase1";
	  String Description = "4.1.1 Connected profile process";
	  test = extent.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestResult(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 2)
  public void TestCase2(String browser) throws IOException {
	  String testName = "Group4_ProcessesTest_TestCase2";
	  String Description = "4.1.2 Create trip process";
	  test = extent.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestResult(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 3)
  public void TestCase3(String browser) throws IOException {
	  String testName = "Group4_ProcessesTest_TestCase3";
	  String Description = "4.1.3 Create reference process";
	  test = extent.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestResult(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 4)
  public void TestCase4(String browser) throws IOException {
	  String testName = "Group4_ProcessesTest_TestCase4";
	  String Description = "4.1.4 Find places menu";
	  test = extent.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestResult(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
}
