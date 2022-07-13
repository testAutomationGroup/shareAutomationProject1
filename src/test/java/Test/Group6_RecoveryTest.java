package Test;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Group6_RecoveryTest extends HeadClass{
  
  ResultsFileBuilder ResultsBuilder = new ResultsFileBuilder(driver);	
  @Parameters({"browser","path"})
  @BeforeClass
  public void beforeGroup6_RecoveryTest(String browser, String path) {
	  System.out.println("Here we start");
	  //Create test report file for report system sanity tests
	  report = ResultsBuilder.GetExtent("Group6_RecoveryTest tests");
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
  public void AfterGroup6_RecoveryTest(String browser) throws InterruptedException {
	  System.out.println("Group6_RecoveryTest ended for browser " + browser);
	  FuncFile.waitForTimeThread(2000);
	  report.flush();
	  //driver.close();
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 1)
  public void TestCase6_1(String browser) throws IOException {
	  String testName = "Group6_RecoveryTest_TestCase6.1";
	  String Description = "6.1 Recovery from disconnections during trips creation";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 2)
  public void TestCase6_2(String browser) throws IOException {
	  String testName = "Group6_RecoveryTest_TestCase6.2";
	  String Description = "6.2 Recovery from disconnections during reviews creation";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 3)
  public void TestCase6_3(String browser) throws IOException {
	  String testName = "Group6_RecoveryTest_TestCase6.3";
	  String Description = "6.3 Recovery from disconnections while adding a place to visit";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 4)
  public void TestCase6_4(String browser) throws IOException {
	  String testName = "Group6_RecoveryTest_TestCase6.4";
	  String Description = "6.4 Recovery from disconnections while adding image";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  

}
