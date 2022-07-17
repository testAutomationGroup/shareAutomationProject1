package Test;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Group5_ConnectivityTest extends HeadClass{
  
  ResultsFileBuilder ResultsBuilder = new ResultsFileBuilder(driver);	
  @Parameters({"browser","path"})
  @BeforeClass
  public void beforeGroup5_ConnectivityTest(String browser, String path) {
	  System.out.println("Here we start");
	  //Create test report file for report system sanity tests
	  report = ResultsBuilder.GetExtent("Group5_ConnectivityTest tests");
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
  public void AfterGroup5_ConnectivityTest(String browser) throws InterruptedException {
	  System.out.println("Group5_ConnectivityTest ended for browser " + browser);
	  FuncFile.waitForTimeThread(2000);
	  report.flush();
	  //driver.close();
  }
  
  @Parameters({"browser"})
  @Test(enabled = true, priority = 1)
  public void TestCase5_1_1(String browser) throws IOException, InterruptedException {
	  String testName = "Group5_ConnectivityTest_TestCase5.1.1";
	  String Description = "5.1.1 WebSite Logo";
	  test = report.createTest(testName + "_" +browser, Description);
	  ResultsBuilder.SendTestImage(test, driver, "PASS", testName, browser);
	  
	  /* Step 1 */
	  System.out.println("TestCase5.1.1 Step 1");
	  elements.initElements(driver);
	  Boolean isClickable = FuncFile.isRelativeElementClickable(driver, elements.logoRelativeLink, elements.Logo);
	  if (!isClickable) {
		  test.log(stepStatus.PASS, "Homepage logo is not clickable");
	  } else {
		  test.log(stepStatus.FAIL, "Homepage logo is clickable");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Homepage logo is clickable");
	  }
	  
	  /* Step 2 */
	  System.out.println("TestCase5.1.1 Step 2");
	  elements.trips.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  String page = driver.getCurrentUrl();
	  if (page.equals("https://www.tripadvisor.co.il/Trips")) {
		  test.log(stepStatus.PASS, "Trips page opened");
	  }else {
		  test.log(stepStatus.FAIL, "Trips page was not opened"); 
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
	  }
	  
	  /* Step 3 */
	  try {
		  System.out.println("TestCase5.1.1 Step 3");
		  driver.get("https://www.tripadvisor.co.il/Trips");
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		  FuncFile.waitForTimeThread(3000);
		  elements.initElements(driver);
		  System.out.println("here1");
		  elements.Logo.click();
		  System.out.println("here2");
		  FuncFile.waitForTimeThread(1000);
		  page = driver.getCurrentUrl();
		  if (page.equals("https://www.tripadvisor.co.il/")) {
			  test.log(stepStatus.PASS, "Trips logo is clickable");
		  }else {
			  test.log(stepStatus.FAIL, "Trips logo is not clickable");
			  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
			  Assert.fail("Trips logo is not clickable");
		  }
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
	  
	
  }
  
  @Parameters({"browser","path"})
  @Test(enabled = true, priority = 2)
  public void TestCase5_1_2(String browser, String path) throws IOException, ParserConfigurationException, SAXException, InterruptedException {
	  String testName = "Group5_ConnectivityTest_TestCase5.1.2";
	  String Description = "5.1.2 Connect to profile";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test, driver, "PASS", testName, browser);
	  
	  
	  /*Step 1*/
	  System.out.println("TestCase5.1.2 Step 1");
	  driver.get(path);
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
		ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		Assert.fail("Connectivity windows not opened");
		
	  }
	  
	  
	  /* Step 2*/
	  System.out.println("TestCase5.1.2 Step 2");
	  driver.get(path);
      String email = FuncFile.importConfigurationsData("email");
      String password = FuncFile.importConfigurationsData("password");
	  FuncFile.connectProfile(driver, email, password);
      
      elements.profileButton.click();
      System.out.println("Button was clicked");
	  
      /* Wait for profile menu presence and click page name */
      driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
      WebElement menu = new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.presenceOfElementLocated(elements.profileMenu));
	  List<WebElement> menuItems = driver.findElements(elements.profileMenuItem);
	  WebElement viewProfile = menuItems.get(0);
	  System.out.println("menu line is " + viewProfile.getText());
	  viewProfile.click();
	  
	  /* Wait for page to load and print site address */
	  try {
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		  String siteAddress = driver.getCurrentUrl();
		  System.out.println("siteAddress is " + siteAddress);
		  
		  /* Updating step pass/fail in results file */
		  if (siteAddress.equals("https://www.tripadvisor.co.il/Profile/EladAr1")) {
			  test.log(stepStatus.PASS, "Profile page was opened");
		  }else {
			  test.log(stepStatus.FAIL, "Profile page was not opened");
			  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
			  Assert.fail("Profile page was not opened");
		  }
		} catch (Exception e) {
			System.out.println("Page not loaded " + e);
		}
	  
	  
	  /* Step 3*/
	  System.out.println("TestCase5.1.2 Step 3");
	  try {
		  driver.get(path);
		} catch (Exception e) {
			System.out.println("Page not loaded " + e);
		}
	  
	  System.out.println("step3 here");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
      elements.initElements(driver);   
      FuncFile.searchByElement(driver, elements.profileByButton);
      elements.profileButton.click();
      System.out.println("Button was clicked");
	  
      /* Wait for profile menu presence and click page name */
      try {
    	  elements.initElements(driver);
          driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
    	  WebElement menu1 = new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.presenceOfElementLocated(elements.profileMenu));
		  List<WebElement> menuItems1 = driver.findElements(elements.profileMenuItem);
		  WebElement viewAccount = menuItems1.get(1);
		  System.out.println("menu line is " + viewAccount.getText());
		  viewAccount.click();
		} catch (Exception e) {
			System.out.println("Element not found " + e);
		}
      
	  
	  /* Wait for page to load and print site address */
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  try {
		  String siteAddress = driver.getCurrentUrl();
		  System.out.println("siteAddress is " + siteAddress);
		  
		  /* Updating step pass/fail in results file */
		  if (siteAddress.equals("https://www.tripadvisor.co.il/Settings-cp")) {
			  test.log(stepStatus.PASS, "Account page was opened");
		  }else {
			  test.log(stepStatus.FAIL, "Account page was not opened");
			  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
			  Assert.fail("Account page was not opened");
		  }
		} catch (Exception e) {
			System.out.println(e);
		}
	
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 3)
  public void TestCase5_3(String browser, String path) throws IOException, ParserConfigurationException, SAXException {
	  String testName = "Group5_ConnectivityTest_TestCase5.3";
	  String Description = "5.3 Notifications test";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test, driver, "PASS", testName, browser);
	  
	  /* Step 1 */
	  System.out.println("TestCase5.3 Step 1");
	  driver.get(path);
      String email = FuncFile.importConfigurationsData("email");
      String password = FuncFile.importConfigurationsData("password");
	  //FuncFile.connectProfile(driver, email, password);
	  elements.notifications.click();
	  String siteName = driver.getCurrentUrl();
	  if (siteName.equals("https://www.tripadvisor.co.il/Inbox")) {
		  test.log(stepStatus.PASS, "Notifications page opened");
	  }else {
		  test.log(stepStatus.FAIL, "Notifications page not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Notifications page not opened");
	  }	  
	
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 4)
  public void TestCase5_4(String browser, String path) throws IOException, ParserConfigurationException, SAXException {
	  String testName = "Group5_ConnectivityTest_TestCase5.4";
	  String Description = "5.4 Notifications test";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test, driver, "PASS", testName, browser);
	  
	  /* Step 1 */
	  System.out.println("TestCase5.4 Step 1");
	  driver.get(path);
      String email = FuncFile.importConfigurationsData("email");
      String password = FuncFile.importConfigurationsData("password");
	  //FuncFile.connectProfile(driver, email, password);
	  elements.initElements(driver);
	  elements.trips.click();
	  String siteName = driver.getCurrentUrl();
	  if (siteName.equals("https://www.tripadvisor.co.il/Trips")) {
		  test.log(stepStatus.PASS, "Trips page opened");
	  }else {
		  test.log(stepStatus.FAIL, "Trips page not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Trips page not opened");
	  }	  
	
  }
  

}
