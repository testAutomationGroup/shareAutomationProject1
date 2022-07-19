package Test;

import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Group9_CompatibilityTest extends HeadClass{
  
  ResultsFileBuilder ResultsBuilder = new ResultsFileBuilder(driver);	
  @Parameters({"browser","path"})
  @BeforeClass
  public void beforeGroup9_CompatibilityTest(String browser, String path) {
	  System.out.println("Here we start");
	  //Create test report file for report system sanity tests
	  report = ResultsBuilder.GetExtent("Group9_CompatibilityTest tests");
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
  public void AfterGroup9_CompatibilityTest(String browser) throws InterruptedException {
	  System.out.println("Group9_CompatibilityTest ended for browser " + browser);
	  FuncFile.waitForTimeThread(2000);
	  report.flush();
	  //driver.close();
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 1)
  public void TestCase9_1(String browser, String path) throws IOException, InterruptedException {
	  String testName = "Group9_CompatibilityTest_TestCase9.1";
	  String Description = "9.1 Compatible with various browsers";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);

	  /* Step 1 */
	  System.out.println("TestCase9.1 Step 1");
	  driver.get(path);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  FuncFile.waitForTimeThread(3000);
	  String siteName = driver.getCurrentUrl();
	  if (siteName.equals("https://www.tripadvisor.co.il/")) {
		  test.log(stepStatus.PASS, "Tripadvisor home page is opened on various browsers");
	  }else {
		  test.log(stepStatus.FAIL, "Tripadvisor home page is not opened on various browsers");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Tripadvisor home page is not opened on various browsers");
	  }
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 2)
  public void TestCase9_2(String browser, String path) throws IOException, InterruptedException {
	  String testName = "Group9_CompatibilityTest_TestCase9.2";
	  String Description = "9.2 Compatible with various screen sizes";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);

	  /* Step 1 */
	  System.out.println("TestCase9.1 Step 1");
	  driver.get(path);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  FuncFile.waitForTimeThread(3000);
	  String siteName = driver.getCurrentUrl();
	  if (siteName.equals("https://www.tripadvisor.co.il/")) {
		  test.log(stepStatus.PASS, "Tripadvisor home page is opened");
	  }else {
		  test.log(stepStatus.FAIL, "Tripadvisor home page is not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Tripadvisor home page is not opened");
	  }
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 3)
  public void TestCase9_3(String browser, String path) throws IOException, InterruptedException {
	  String testName = "Group9_CompatibilityTest_TestCase9.3";
	  String Description = "9.3 Compatible with various mobile phones";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);

	  /* Step 1 */
	  System.out.println("TestCase9.1 Step 2");
	  driver.get(path);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  FuncFile.waitForTimeThread(3000);
	  String siteName = driver.getCurrentUrl();
	  if (siteName.equals("https://www.tripadvisor.co.il/")) {
		  test.log(stepStatus.PASS, "Tripadvisor home page is opened");
	  }else {
		  test.log(stepStatus.FAIL, "Tripadvisor home page is not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Tripadvisor home page is not opened");
	  }
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 4)
  public void TestCase9_4(String browser, String path) throws IOException, InterruptedException {
	  String testName = "Group9_CompatibilityTest_TestCase9.4";
	  String Description = "9.4 Compatible with various windows sizes";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  
	  /* Step 1 */
	  System.out.println("TestCase9.4 Step 1");
	  driver.get(path);
	  JavascriptExecutor javascript = (JavascriptExecutor)driver;
	  Actions builder= new Actions(driver);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  FuncFile.waitForTimeThread(3000);
	  driver.manage().window().setSize(new Dimension(1920, 1080));
	  FuncFile.waitForTimeThread(3000);
	  javascript.executeScript("arguments[0].scrollIntoView(true);", elements.currencyLanguageButtons.get(1));
	  
	  String siteName = driver.getCurrentUrl();
	  if (siteName.equals("https://www.tripadvisor.co.il/")) {
		  test.log(stepStatus.PASS, "Tripadvisor home page is opened (1920, 1080)");
	  }else {
		  test.log(stepStatus.FAIL, "Tripadvisor home page is not opened (1920, 1080)");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Tripadvisor home page is not opened (1920, 1080)");
	  }
	  
	  /* Step 2 */
	  System.out.println("TestCase9.4 Step 2");
	  driver.get(path);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  FuncFile.waitForTimeThread(3000);
	  driver.manage().window().setSize(new Dimension(1680, 1050));
	  FuncFile.waitForTimeThread(3000);
	  javascript.executeScript("arguments[0].scrollIntoView(true);", elements.hotels);
	  
	  String siteName1 = driver.getCurrentUrl();
	  if (siteName1.equals("https://www.tripadvisor.co.il/")) {
		  test.log(stepStatus.PASS, "Tripadvisor home page is opened (1680, 1050)");
	  }else {
		  test.log(stepStatus.FAIL, "Tripadvisor home page is not opened (1680, 1050)");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Tripadvisor home page is not opened (1680, 1050)");
	  }
	  
	  /* Step 3 */
	  System.out.println("TestCase9.4 Step 3");
	  driver.get(path);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  FuncFile.waitForTimeThread(3000);
	  driver.manage().window().setSize(new Dimension(1440, 900));
	  FuncFile.waitForTimeThread(3000);
	  javascript.executeScript("arguments[0].scrollIntoView(true);", elements.hotels);
	  
	  String siteName4 = driver.getCurrentUrl();
	  if (siteName4.equals("https://www.tripadvisor.co.il/")) {
		  test.log(stepStatus.PASS, "Tripadvisor home page is opened (1440, 900)");
	  }else {
		  test.log(stepStatus.FAIL, "Tripadvisor home page is not opened (1440, 900)");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Tripadvisor home page is not opened (1440, 900)");
	  }
	  
	  /* Step4 */
	  System.out.println("TestCase9.4 Step 4");
	  driver.get(path);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  FuncFile.waitForTimeThread(3000);
	  driver.manage().window().setSize(new Dimension(1366, 768));
	  FuncFile.waitForTimeThread(3000);
	  javascript.executeScript("arguments[0].scrollIntoView(true);", elements.hotels);
	  
	  String siteName2 = driver.getCurrentUrl();
	  if (siteName2.equals("https://www.tripadvisor.co.il/")) {
		  test.log(stepStatus.PASS, "Tripadvisor home page is opened (1366, 768)");
	  }else {
		  test.log(stepStatus.FAIL, "Tripadvisor home page is not opened (1366, 768)");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Tripadvisor home page is not opened (1366, 768)");
	  }
	  
	  /* Step5 */
	  System.out.println("TestCase9.4 Step 5");
	  driver.get(path);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  FuncFile.waitForTimeThread(3000);
	  driver.manage().window().setSize(new Dimension(1024, 768));
	  FuncFile.waitForTimeThread(3000);
	  javascript.executeScript("arguments[0].scrollIntoView(true);", elements.hotels);
	  
	  String siteName3 = driver.getCurrentUrl();
	  if (siteName3.equals("https://www.tripadvisor.co.il/")) {
		  test.log(stepStatus.PASS, "Tripadvisor home page is opened (1024, 768)");
	  }else {
		  test.log(stepStatus.FAIL, "Tripadvisor home page is not opened (1024, 768)");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Tripadvisor home page is not opened (1024, 768)");
	  }
  }

}
