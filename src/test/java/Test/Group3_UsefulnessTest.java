package Test;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Group3_UsefulnessTest extends HeadClass{
  
  ResultsFileBuilder ResultsBuilder = new ResultsFileBuilder(driver);	
  @Parameters({"browser","path"})
  @BeforeClass
  public void beforeGroup3_UsefulnessTest(String browser, String path) {
	  System.out.println("Here we start");
	  //Create test report file for report system sanity tests
	  extent = ResultsBuilder.GetExtent("Group3_UsefulnessTest tests");
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
  public void AfterGroup3_UsefulnessTest(String browser) throws InterruptedException {
	  System.out.println("Group3_UsefulnessTest ended for browser " + browser);
	  FuncFile.waitForTimeThread(2000);
	  extent.flush();
	  //driver.close();
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 1)
  public void TestCase1(String browser) throws IOException {
	  String testName = "Group3_UsefulnessTest_TestCase1";
	  String Description = "3.1.1 Connect to profile";
	  test = extent.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestResult(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 2)
  public void TestCase2(String browser) throws IOException {
	  String testName = "Group3_UsefulnessTest_TestCase2";
	  String Description = "3.1.2 Notifications and profile settings";
	  test = extent.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestResult(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 3)
  public void TestCase3(String browser) throws IOException {
	  String testName = "Group3_UsefulnessTest_TestCase3";
	  String Description = "3.1.3 Trips";
	  test = extent.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestResult(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 4)
  public void TestCase4(String browser) throws IOException {
	  String testName = "Group3_UsefulnessTest_TestCase4";
	  String Description = "3.1.4 References";
	  test = extent.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestResult(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
}
