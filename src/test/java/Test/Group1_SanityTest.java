package Test;
import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

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
		  report = ResultsBuilder.GetExtent("Group1_SanityTest tests");
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
			  elements.initElements(driver);
			
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
		  report.flush();
		  //driver.close();
	  }
	  
	  /*Code for all test cases in System Sanity Tests group*/
	  @Parameters({"browser"})
	  @Test(enabled = false, alwaysRun = true, priority = 1)
	  public void TestCase1_1_1(String browser) throws IOException, InterruptedException {
		  String testName = "Group1_SanityTest_TestCase1.1.1";
		  String Description = "1.1.1 WebSite Logo";
		  test = report.createTest(testName + "_" +browser, Description);
		  
		  /* Step 1 */
		  elements.initElements(driver);
		  Boolean isClickable = FuncFile.isElementClickable(driver, elements.logoRelativeLink, elements.Logo);
		  if (!isClickable) {
			  test.log(stepStatus.PASS, "Homepage logo is not clickable");
		  } else {
			  test.log(stepStatus.FAIL, "Homepage logo is clickable");
		  }
		  
		  /* Step 2 */
		  elements.trips.click();
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		  elements.initElements(driver);
		  String page = driver.getCurrentUrl();
		  if (page.equals("https://www.tripadvisor.co.il/Trips")) {
			  test.log(stepStatus.PASS, "Trips page opened");
		  }else {
			  test.log(stepStatus.FAIL, "Trips page was not opened"); 
		  }
		  
		  /* Step 3 */
		  elements.initElements(driver);
		  FuncFile.waitForTimeThread(400);
		  elements.Logo.click();
		  page = driver.getCurrentUrl();
		  if (page.equals("https://www.tripadvisor.co.il/")) {
			  test.log(stepStatus.PASS, "Trips logo is clickable");
		  }else {
			  test.log(stepStatus.FAIL, "Trips logo is not clickable");
		  }

		  ResultsBuilder.SendTestImage(test, driver, "PASS", testName, browser);
	  }

	  @Parameters({"browser","path"})
	  @Test(enabled = true, priority = 2)
	  public void TestCase1_2_1(String browser, String path) throws IOException, InterruptedException, ParserConfigurationException, SAXException {
		  String testName = "Group1_SanityTest_TestCase1.2.1";
		  String Description = "1.2.1 Connect to profile";
		  test = report.createTest(testName + "_"+browser, Description);
		  
		  
		  /*Step 1*/
		  
		  elements.connectButton.click();
		  try {

			System.out.println("step1");
			elements.initElements(driver);
			driver.switchTo().frame(elements.googleIframe);
			FuncFile.waitForTimeThread(1000);
			WebElement ConnectivityWindow = driver.findElement(By.cssSelector("#regBody"));
			test.log(stepStatus.PASS, "Connectivity windows opened");
		  } catch (Exception e) {
			System.out.println(e);
			test.log(stepStatus.FAIL, "Connectivity windows not opened");
		  }
		  ResultsBuilder.SendTestImage(test, driver, "PASS", testName, browser);
		  
		  
		  /* Step 2*/
		  System.out.println("step2");
		  driver.get(path);
		  elements.connectButton.click();
		  elements.initElements(driver);
		  FuncFile.waitForTimeThread(1000);
		  driver.switchTo().frame(elements.googleIframe);
          driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		  elements.tripadvisorButton.click();
          String email = FuncFile.importConfigurationsData("email");
          String password = FuncFile.importConfigurationsData("password");
          System.out.println("here3 " + email + " " + password);
          elements.initElements(driver);
          driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
          elements.emailTripadvisor.sendKeys(email);
          elements.passwordTripadvisor.sendKeys(password);
          elements.signInButton.click();
          
          driver.switchTo().defaultContent();
          System.out.println(driver.getCurrentUrl());
          //driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
          elements.initElements(driver);
          WebElement profileImg = new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(elements.profileButton));
          
		  elements.profileButton.click();
          driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		  List<WebElement> menu = driver.findElements(By.cssSelector("ul[role='menu'] li"));
		  WebElement viewProfile = menu.get(0);
		  WebElement viewProfileWait = new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(viewProfile));
		  System.out.println("menu line is " + viewProfile.getText());
		  viewProfile.click();
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		  elements.initElements(driver);
		  String siteAddress = driver.getCurrentUrl();
		  System.out.println(siteAddress);
		  if (siteAddress.equals("https://www.tripadvisor.co.il/Profile/EladAr1")) {
			  test.log(stepStatus.PASS, "Profile page was opened");
		  }else {
			  test.log(stepStatus.FAIL, "Profile page was not opened");
		  }
		  
		  
		  /* Step 3 */ 
		  System.out.println("step3");
		  try {
			  driver.navigate().to(path);
		  } catch (Exception e) {
			System.out.println(e);
		  }
		  System.out.println(driver.getCurrentUrl());
		  elements.initElements(driver);
          profileImg = new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(elements.profileButton));
          System.out.println(driver.getCurrentUrl());
		  elements.profileButton.click();
		  viewProfileWait = new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(viewProfile));
		  //FuncFile.waitForTimeThread(3000);
		  menu = driver.findElements(By.cssSelector("ul[role='menu'] li"));
		  viewProfile = menu.get(1);
		  System.out.println("menu line is " + viewProfile.getText());
		  viewProfile.click();
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		  elements.initElements(driver);
		  siteAddress = driver.getCurrentUrl();
		  System.out.println(siteAddress);
		  if (siteAddress.equals("https://www.tripadvisor.co.il/Profile/EladAr1")) {
			  test.log(stepStatus.PASS, "Profile page was opened");
		  }else {
			  test.log(stepStatus.FAIL, "Profile page was not opened");
		  }
		  
	  }
	  
	  @Parameters({"browser"})
	  @Test(enabled = false, priority = 3)
	  public void TestCase1_2_2(String browser) throws IOException {
		  String testName = "Group1_SanityTest_TestCase1.2.2";
		  String Description = "1.2.2 Notifications test";
		  test = report.createTest(testName + "_"+browser, Description);
		  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
		  Assert.assertTrue(true);
		
	  }
	  
	  @Parameters({"browser"})
	  @Test(enabled = false, priority = 4)
	  public void TestCase1_2_3(String browser) throws IOException {
		  String testName = "Group1_SanityTest_TestCase1.2.3";
		  String Description = "1.2.3 Trips test";
		  test = report.createTest(testName + "_"+browser, Description);
		  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
		  Assert.assertTrue(true);
		
	  }
	  
}
