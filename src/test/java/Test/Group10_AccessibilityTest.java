package Test;

import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import org.sikuli.hotkey.Keys;
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
	  report = ResultsBuilder.GetExtent("Group10_AccessibilityTest tests");
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
	  report.flush();
	  //driver.close();
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 1)
  public void TestCase10_1(String browser, String path) throws IOException, InterruptedException {
	  String testName = "Group10_AccessibilityTest_TestCase10.1";
	  String Description = "10.1 Accessibility tab";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  
	  /* Step 1 */
	  System.out.println("TestCase10.1 Step 1");
	  driver.get(path);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.mainSearchInput.sendKeys("Accessibility");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.mainSearchInput.sendKeys(org.openqa.selenium.Keys.RETURN);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  try {
		  boolean found1 = FuncFile.searchClickableElement(driver, elements.searchResultsHeadlines.get(2));
		  test.log(stepStatus.PASS, "Accessibility Hebrew results found");
	  } catch (Exception e) {
		  test.log(stepStatus.FAIL, "Accessibility Hebrew results not found");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  /* Active row when we want to stop the test at this point. 
		   //Assert.fail("Accessibility english results not found"); */
		  System.out.println("Error " + e);
	  }
	  
	  /* Step 2 */
	  System.out.println("TestCase10.1 Step2");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  driver.get(path);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.currencyLanguageButtons.get(1).click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.englishUnitedStates.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.mainSearchInput.sendKeys("Accessibility");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.mainSearchInput.sendKeys(org.openqa.selenium.Keys.RETURN);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  boolean found = FuncFile.searchClickableElement(driver, elements.searchResultsHeadlines.get(2));
	  if (found) {
		  test.log(stepStatus.PASS, "Accessibility English results found");
	  }else {
		  test.log(stepStatus.FAIL, "Accessibility English results not found");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Accessibility Esnglish results not found"); 
	  }
	  
  }
}
  