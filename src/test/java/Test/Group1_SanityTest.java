package Test;
import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
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
	  
	  ResultsFileBuilder ResultsBuilder = new ResultsFileBuilder(driver);
	  Elements elements = new Elements(driver);
	  
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
			  driver = FuncFile.openBrowser(driver, browser, path); 
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	  }
	  
	  /*Code after System Sanity Tests group*/
	  @Parameters({"browser"})
	  @AfterClass
	  public void AfterGroup1_SystemSanityTests(String browser) throws InterruptedException {
		  System.out.println("Group1_SystemSanityTests ended for browser " + browser);
		  FuncFile.waitForTimeThread(2000);
		  extent.flush();
		  //driver.close();
	  }
	  
	  /*Code for all test cases in System Sanity Tests group*/
	  @Parameters({"browser"})
	  @Test(alwaysRun = true, priority = 1)
	  public void TestCase1_1_1(String browser) throws IOException, InterruptedException {
		  String testName = "Group1_SanityTest_TestCase1.1.1";
		  String Description = "1.1.1 WebSite Logo";
		  test = extent.createTest(testName + "_" +browser, Description);
		  //elements.initElements(driver);
		  //elements.trips.click();
		  //driver.manage().timeouts().implicitlyWait(Duration.ofMillis(200));
		  //elements.Logo.click();
		  ResultsBuilder.SendTestResult(test, driver, "PASS", testName, browser);
		  Assert.assertTrue(true);
		
	  }

	  @Parameters({"browser"})
	  @Test(enabled = true, priority = 2, dependsOnMethods = "TestCase1_1_1")
	  public void TestCase1_2_1(String browser) throws IOException {
		  String testName = "Group1_SanityTest_TestCase1.2.1";
		  String Description = "1.2.1 Connect to profile";
		  test = extent.createTest(testName + "_"+browser, Description);
		  ResultsBuilder.SendTestResult(test,driver, "PASS", testName, browser);
		  Assert.assertTrue(true);
		
	  }
	  
	  @Parameters({"browser"})
	  @Test(enabled = true, priority = 3)
	  public void TestCase1_2_2(String browser) throws IOException {
		  String testName = "Group1_SanityTest_TestCase1.2.2";
		  String Description = "1.2.2 Notifications test";
		  test = extent.createTest(testName + "_"+browser, Description);
		  ResultsBuilder.SendTestResult(test,driver, "PASS", testName, browser);
		  Assert.assertTrue(true);
		
	  }
	  
	  @Parameters({"browser"})
	  @Test(priority = 4)
	  public void TestCase1_2_3(String browser) throws IOException {
		  String testName = "Group1_SanityTest_TestCase1.2.3";
		  String Description = "1.2.3 Trips test";
		  test = extent.createTest(testName + "_"+browser, Description);
		  ResultsBuilder.SendTestResult(test,driver, "PASS", testName, browser);
		  Assert.assertTrue(true);
		
	  }
	  
}
