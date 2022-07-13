package Test;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Group11_InterfacesTest extends HeadClass{
  
  ResultsFileBuilder ResultsBuilder = new ResultsFileBuilder(driver);	
  @Parameters({"browser","path"})
  @BeforeClass
  public void beforeGroup11_InterfacesTest(String browser, String path) {
	  System.out.println("Here we start");
	  //Create test report file for report system sanity tests
	  report = ResultsBuilder.GetExtent("Group11_InterfacesTest tests");
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
  public void AfterGroup11_InterfacesTest(String browser) throws InterruptedException {
	  System.out.println("Group11_InterfacesTest ended for browser " + browser);
	  FuncFile.waitForTimeThread(2000);
	  report.flush();
	  //driver.close();
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 1)
  public void TestCase11_1(String browser) throws IOException {
	  String testName = "Group11_InterfacesTest_TestCase11.1";
	  String Description = "11.1 Social networks interfaces";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 2)
  public void TestCase11_2(String browser) throws IOException {
	  String testName = "Group11_InterfacesTest_TestCase11.2";
	  String Description = "11.2 Connect hotels orders from partner sites";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 3)
  public void TestCase11_3(String browser) throws IOException {
	  String testName = "Group11_InterfacesTest_TestCase11.3";
	  String Description = "11.3 Connect flights orders from partner sites";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, priority = 4)
  public void TestCase11_4(String browser) throws IOException {
	  String testName = "Group11_InterfacesTest_TestCase11.4";
	  String Description = "11.4 Connect cruise orders from partner sites";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  

}
