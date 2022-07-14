package Test;
import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
		  ResultsBuilder.SendTestImage(test, driver, "PASS", testName, browser);
		  
		  /* Step 1 */
		  System.out.println("TestCase1.1.1 Step 1");
		  elements.initElements(driver);
		  Boolean isClickable = FuncFile.isElementClickable(driver, elements.logoRelativeLink, elements.Logo);
		  if (!isClickable) {
			  test.log(stepStatus.PASS, "Homepage logo is not clickable");
		  } else {
			  test.log(stepStatus.FAIL, "Homepage logo is clickable");
			  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  }
		  
		  /* Step 2 */
		  System.out.println("TestCase1.1.1 Step 2");
		  elements.trips.click();
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		  elements.initElements(driver);
		  String page = driver.getCurrentUrl();
		  if (page.equals("https://www.tripadvisor.co.il/Trips")) {
			  test.log(stepStatus.PASS, "Trips page opened");
		  }else {
			  test.log(stepStatus.FAIL, "Trips page was not opened"); 
			  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  }
		  
		  /* Step 3 */
		  System.out.println("TestCase1.1.1 Step 3");
		  elements.initElements(driver);
		  FuncFile.waitForTimeThread(400);
		  elements.Logo.click();
		  page = driver.getCurrentUrl();
		  if (page.equals("https://www.tripadvisor.co.il/")) {
			  test.log(stepStatus.PASS, "Trips logo is clickable");
		  }else {
			  test.log(stepStatus.FAIL, "Trips logo is not clickable");
			  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  }

	  }

	  @Parameters({"browser","path"})
	  @Test(enabled = false, priority = 2)
	  public void TestCase1_2_1(String browser, String path) throws IOException, InterruptedException, ParserConfigurationException, SAXException {
		  String testName = "Group1_SanityTest_TestCase1.2.1";
		  String Description = "1.2.1 Connect to profile";
		  test = report.createTest(testName + "_"+browser, Description);
		  ResultsBuilder.SendTestImage(test, driver, "PASS", testName, browser);
		  
		  
		  /*Step 1*/
		  System.out.println("TestCase1.2.1 Step 1");
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
		  }
		  
		  
		  /* Step 2*/
		  System.out.println("TestCase1.2.1 Step 2");
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
			  }
			} catch (Exception e) {
				System.out.println("Page not loaded " + e);
			}
		  
		  
		  /* Step 3*/
		  System.out.println("TestCase1.2.1 Step 3");
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
			  }
			} catch (Exception e) {
				System.out.println(e);
			}
		  
		  /* Step 4 */
		  System.out.println("TestCase1.2.1 Step 4");
		  elements.initElements(driver);
		  System.out.println(elements.AccountFirstName.getAttribute("value"));
		  System.out.println(elements.AccountFamilyName.getAttribute("value"));
		  System.out.println(elements.AccountEmail.getAttribute("value"));
		  if (elements.AccountFirstName.getAttribute("value").equals("Elad")&&elements.AccountFamilyName.getAttribute("value").equals("Arnon")&&elements.AccountEmail.getAttribute("value").equals("arnonelad1@gmail.com")) {
			  test.log(stepStatus.PASS, "Valid account details");
		  }else {
			  test.log(stepStatus.FAIL, "Account details is not valid");
			  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  }	  
		  
		  /* Step 5 */
		  System.out.println("TestCase1.2.1 Step 5");
		  elements.AccountFirstName.clear();
		  elements.AccountFirstName.sendKeys("EladSaveTest");
		  elements.AccountPageSaveButton.click();
		  
		  if (elements.AccountFirstName.getAttribute("value").equals("EladSaveTest")) {
			  test.log(stepStatus.PASS, "Valid details saving");
		  }else {
			  test.log(stepStatus.FAIL, "Details saving is not valid");
			  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  }
		  	
		  FuncFile.waitForTimeThread(3000);
		  elements.initElements(driver);
		  elements.AccountFirstName.clear();
		  elements.AccountFirstName.sendKeys("Elad");
		  elements.AccountPageSaveButton.click();
		  
		  /*Step 6 */
		  try {
			  System.out.println("TestCase1.2.1 Step 6");
			  FuncFile.waitForTimeThread(3000);
			  elements.initElements(driver);
			  elements.SignOutSeesions.click();
			  elements.continueSignOut.click();
			  if (FuncFile.searchClickableElement(driver, elements.signOutAccountNotification)) {
				  test.log(stepStatus.PASS, "Valid accounts sign out process");
			  } else {
				  test.log(stepStatus.FAIL, "Accounts sign out process is not validated");  
				  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
			  }
			  elements.signOutCloseButton.click();
			} catch (Exception e) {
				System.out.println("error " +e);
				
			}
		  
		  
	  }
	  
	  @Parameters({"browser", "path"})
	  @Test(enabled = true, priority = 3)
	  public void TestCase1_2_2(String browser, String path) throws IOException, ParserConfigurationException, SAXException, InterruptedException {
		  String testName = "Group1_SanityTest_TestCase1.2.2";
		  String Description = "1.2.2 Notifications test";
		  test = report.createTest(testName + "_"+browser, Description);
		  ResultsBuilder.SendTestImage(test, driver, "PASS", testName, browser);
		  
		  /* Step 1 */
		  System.out.println("TestCase1.2.2 Step 1");
		  driver.get(path);
          String email = FuncFile.importConfigurationsData("email");
          String password = FuncFile.importConfigurationsData("password");
		  FuncFile.connectProfile(driver, email, password);
		  elements.notifications.click();
		  String siteName = driver.getCurrentUrl();
		  if (siteName.equals("https://www.tripadvisor.co.il/Inbox")) {
			  test.log(stepStatus.PASS, "Notifications page opened");
		  }else {
			  test.log(stepStatus.FAIL, "Notifications page not opened");
			  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  }	  
		  
		  /* Step 2 */
		  elements.notificationsPageSearchRow.sendKeys("Eilat");
		  elements.notificationsPageSearchRow.sendKeys(Keys.RETURN);
		  System.out.println(elements.resultsPageActiveTab.getText());
		  if (elements.resultsPageActiveTab.getText().equals("כל התוצאות")){
			  test.log(stepStatus.PASS, "Search row validated");
		  }else {
			  test.log(stepStatus.FAIL, "Search row not valid");
			  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  }	  
		
	  }
	  
	  @Parameters({"browser"})
	  @Test(enabled = false, priority = 4)
	  public void TestCase1_2_3(String browser) throws IOException {
		  String testName = "Group1_SanityTest_TestCase1.2.3";
		  String Description = "1.2.3 Trips test";
		  test = report.createTest(testName + "_"+browser, Description);
		  ResultsBuilder.SendTestImage(test, driver, "PASS", testName, browser);
		
	  }
	  
}
