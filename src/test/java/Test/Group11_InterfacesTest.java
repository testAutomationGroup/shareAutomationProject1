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
	  extent = ResultsBuilder.GetExtent("Group11_InterfacesTest tests");
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
  public void AfterGroup11_InterfacesTest(String browser) throws InterruptedException {
	  System.out.println("System sanity tests ended for browser " + browser);
	  FuncFile.waitForTimeThread(200);
	  extent.flush();
	  driver.quit();
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, groups = "Group11_InterfacesTest", priority = 1)
  public void TestCase1(String browser) throws IOException {
	  String testName = "Group11_InterfacesTest_TestCase1";
	  String Description = "description1";
	  test = extent.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.ReportTestResult(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  
  @Parameters({"browser"})
  @Test(alwaysRun = true, groups = "Group11_InterfacesTest", priority = 2)
  public void TestCase2(String browser) throws IOException {
	  String testName = "Group11_InterfacesTest_TestCase2";
	  String Description = "description2";
	  test = extent.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.ReportTestResult(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
  }
  

}
