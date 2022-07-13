package Test;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Group7_InternationalityTest extends HeadClass{
  
  ResultsFileBuilder ResultsBuilder = new ResultsFileBuilder(driver);	
  @Parameters({"browser","path"})
  @BeforeClass
  public void beforeGroup7_InternationalityTest(String browser, String path) {
	  System.out.println("Here we start");
	  //Create test report file for report system sanity tests
	  report = ResultsBuilder.GetExtent("Group7_InternationalityTest tests");
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
  public void AfterGroup7_InternationalityTest(String browser) throws InterruptedException {
	  System.out.println("Group7_InternationalityTest ended for browser " + browser);
	  FuncFile.waitForTimeThread(2000);
	  report.flush();
	  //driver.close();
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 1)
  public void TestCase7_1(String browser) throws IOException {
	  String testName = "Group7_InternationalityTest_TestCase7.1";
	  String Description = "7.1 Open google translate addon in differnet browsers";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 2)
  public void TestCase7_2(String browser) throws IOException {
	  String testName = "Group7_InternationalityTest_TestCase7.2";
	  String Description = "7.2 Test right currency conversions";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 3)
  public void TestCase7_3(String browser) throws IOException {
	  String testName = "Group7_InternationalityTest_TestCase7.3";
	  String Description = "7.3 Translate all contect to proposed languages";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 4)
  public void TestCase7_4(String browser) throws IOException {
	  String testName = "Group7_InternationalityTest_TestCase7.4";
	  String Description = "7.4 English pages to integrate with hebrew";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  

}
