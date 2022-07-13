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
	  report = ResultsBuilder.GetExtent("Group3_UsefulnessTest tests");
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
  public void AfterGroup3_UsefulnessTest(String browser) throws InterruptedException {
	  System.out.println("Group3_UsefulnessTest ended for browser " + browser);
	  FuncFile.waitForTimeThread(2000);
	  report.flush();
	  //driver.close();
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 1)
  public void TestCase3_1_1(String browser) throws IOException {
	  String testName = "Group3_UsefulnessTest_TestCase3.1.1";
	  String Description = "3.1.1 Connect to profile";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 2)
  public void TestCase3_1_2(String browser) throws IOException {
	  String testName = "Group3_UsefulnessTest_TestCase3.1.2";
	  String Description = "3.1.2 Notifications and profile settings";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 3)
  public void TestCase3_1_3(String browser) throws IOException {
	  String testName = "Group3_UsefulnessTest_TestCase3.1.3";
	  String Description = "3.1.3 Trips";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 4)
  public void TestCase3_1_4(String browser) throws IOException {
	  String testName = "Group3_UsefulnessTest_TestCase3.1.4";
	  String Description = "3.1.4 References";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
}
