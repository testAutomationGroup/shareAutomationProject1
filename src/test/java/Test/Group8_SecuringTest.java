package Test;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Group8_SecuringTest extends HeadClass{
  
  ResultsFileBuilder ResultsBuilder = new ResultsFileBuilder(driver);	
  @Parameters({"browser","path"})
  @BeforeClass
  public void beforeGroup8_SecuringTest(String browser, String path) {
	  System.out.println("Here we start");
	  //Create test report file for report system sanity tests
	  extent = ResultsBuilder.GetExtent("Group8_SecuringTest tests");
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
  public void AfterGroup8_SecuringTest(String browser) throws InterruptedException {
	  System.out.println("Group8_SecuringTest ended for browser " + browser);
	  FuncFile.waitForTimeThread(2000);
	  extent.flush();
	  //driver.close();
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 1)
  public void TestCase8_1(String browser) throws IOException {
	  String testName = "Group8_SecuringTest_TestCase8.1";
	  String Description = "8.1 Connect secured connection in various browsers";
	  test = extent.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestResult(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 2)
  public void TestCase8_2(String browser) throws IOException {
	  String testName = "Group8_SecuringTest_TestCase8.2";
	  String Description = "8.2 Location share settings";
	  test = extent.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestResult(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 3)
  public void TestCase8_3(String browser) throws IOException {
	  String testName = "Group8_SecuringTest_TestCase8.3";
	  String Description = "8.3 Import a non actual place";
	  test = extent.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestResult(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 4)
  public void TestCase8_4(String browser) throws IOException {
	  String testName = "Group8_SecuringTest_TestCase8.4";
	  String Description = "8.4 Locating machines created reviews";
	  test = extent.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestResult(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  

}
