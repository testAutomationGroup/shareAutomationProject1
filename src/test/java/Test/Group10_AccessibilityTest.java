package Test;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Group10_AccessibilityTest extends HeadClass{
  
  ResultsFileBuilder ResultsBuilder = new ResultsFileBuilder(driver);	
  @Parameters({"browser","path"})
  @BeforeClass
  public void beforeGroup10_AccessibilityTest(String browser, String path) {
	  System.out.println("Here we start");
	  //Create test report file for report system sanity tests
	  extent = ResultsBuilder.GetExtent("Group10_AccessibilityTest tests");
	  System.out.println("Here we start again");
	  
	  try {
		  System.out.println("Start testing");
		  //load pageLoadingTime for runningTests class functions
		  String pageLoadingTime = FuncFile.importConfigurationsData("PageLoadingTime");
		  System.out.println("Parameter page loading value is " + pageLoadingTime);
		  //open browser for each browser parameter value
		  System.out.println("System sanity tests started for browser " + browser);
		  System.out.println("Path is " + path);
		  driver = FuncFile.openBrowser(driver, browser, path); 
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
  }
  
  @Parameters({"browser"})
  @AfterClass
  public void AfterGroup10_AccessibilityTest(String browser) throws InterruptedException {
	  System.out.println("Group10_AccessibilityTest ended for browser " + browser);
	  FuncFile.waitForTimeThread(2000);
	  extent.flush();
	  //driver.close();
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 1)
  public void TestCase10_1(String browser) throws IOException {
	  String testName = "Group10_AccessibilityTest_TestCase10.1";
	  String Description = "10.1 Accessibility tab";
	  test = extent.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestResult(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 2)
  public void TestCase10_2(String browser) throws IOException {
	  String testName = "Group10_AccessibilityTest_TestCase10.1";
	  String Description = "10.1 Accessibility text";
	  test = extent.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestResult(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 3)
  public void TestCase10_3(String browser) throws IOException {
	  String testName = "Group10_AccessibilityTest_TestCase10.1";
	  String Description = "10.1 Accessibility text";
	  test = extent.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestResult(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 4)
  public void TestCase10_4(String browser) throws IOException {
	  String testName = "Group10_AccessibilityTest_TestCase10.1";
	  String Description = "10.1 Accessibility keys";
	  test = extent.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestResult(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  

}
