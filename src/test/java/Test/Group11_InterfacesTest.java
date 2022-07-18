package Test;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.Keys;
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
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 1)
  public void TestCase11_1(String browser, String path) throws IOException, InterruptedException {
	  String testName = "Group11_InterfacesTest_TestCase11.1";
	  String Description = "11.1 Social networks interfaces";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  
	  /* Step 1 */
	  System.out.println("TestCase11.1 Step 1");
	  driver.get(path);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.instagram.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  boolean foundPath1 =FuncFile.waitForSitePath(driver, "https://www.instagram.com/accounts/login/?next=/tripadvisor/");
	  boolean foundPath2 =FuncFile.waitForSitePath(driver, "https://www.instagram.com/tripadvisor/");
	  if (foundPath1 || foundPath2) {
		  test.log(stepStatus.PASS, "Instagram tripadvisor page opened");
	  }else {
		  test.log(stepStatus.FAIL, "Instagram tripadvisor page not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Instagram tripadvisor page not opened");
	  }
	  
	  /* Step 2 */
	  System.out.println("TestCase11.1 Step 2");
	  driver.get(path);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.twitter.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  boolean foundPath3 =FuncFile.waitForSitePath(driver, "https://twitter.com/TripAdvisor");
	  if (foundPath3) {
		  test.log(stepStatus.PASS, "Twitter tripadvisor page opened");
	  }else {
		  test.log(stepStatus.FAIL, "Twitter tripadvisor page not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Twitter tripadvisor page not opened");
	  }
	  
	  /* Step 3 */
	  System.out.println("TestCase11.1 Step 3");
	  driver.get(path);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.facebook.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  boolean foundPath4 =FuncFile.waitForSitePath(driver, "https://www.facebook.com/Tripadvisor/");
	  if (foundPath4) {
		  test.log(stepStatus.PASS, "Twitter tripadvisor page opened");
	  }else {
		  test.log(stepStatus.FAIL, "Twitter tripadvisor page not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Twitter tripadvisor page not opened");
	  }
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 2)
  public void TestCase11_2(String browser, String path) throws IOException, ParserConfigurationException, SAXException, InterruptedException {
	  String testName = "Group11_InterfacesTest_TestCase11.2";
	  String Description = "11.2 Connect hotels orders from partner sites";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  
	  /* Step 1 */
	  System.out.println("TestCase11.2 Step 1");
	  driver.get(path);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
      String email = FuncFile.importConfigurationsData("email");
      String password = FuncFile.importConfigurationsData("password");
	  FuncFile.connectProfile(driver, email, password);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.hotels.click();
	  boolean found = FuncFile.searchClickableElement(driver, elements.hotelsSearchInput);
	  if (found) {
		  test.log(stepStatus.PASS, "Hotels search menu opened");
	  }else {
		  test.log(stepStatus.FAIL, "Hotels search menu not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Hotels search menu not opened"); 
	  }
	  
	  /* Step 2 */
	  System.out.println("TestCase11.2 Step 2");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.hotelsSearchInput.sendKeys("אילת");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  FuncFile.searchClickableElement(driver, elements.searchHotelItems.get(0));
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  FuncFile.waitForTimeThread(1000);
	  elements.searchHotelItems.get(0).click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  boolean found1 = FuncFile.waitForSitePathContainsText(driver, "https://www.tripadvisor.co.il/Hotels");
	  if (found1) {
		  test.log(stepStatus.PASS, "Eilat hotels page opened");
	  }else {
		  test.log(stepStatus.FAIL, "Eilat hotels page not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Eilat hotels page not opened"); 
	  }
	  
	  /* Step 3 */
	  try {
		  System.out.println("TestCase11.2 Step 3");
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		  elements.initElements(driver);
		  /* Set dates in calendar if calendar is closed*/
		  boolean found2 = FuncFile.searchClickableElement(driver, elements.hotelsCalendar1Today);
		  if (found2) {
			  elements.hotelsCalendar1Today.click();
			  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
			  FuncFile.waitForTimeThread(2000);
			  elements.initElements(driver);
			  elements.hotelsCalendar2FirstDay.click();
			  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
			  FuncFile.waitForTimeThread(2000);
			  elements.initElements(driver);
			  elements.searchHotelsUpdateButton.click();
			  FuncFile.waitForTimeThread(2000);
			  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
			  elements.initElements(driver);
		  }

		  elements.initElements(driver);
		  elements.hotelsViewDeal.get(26).click();
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		  elements.initElements(driver);
		  List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		  driver.switchTo().window(tabs.get(1));
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		  elements.initElements(driver);
		  boolean foundSitePath = FuncFile.waitForSitePathContainsText(driver, "tripadvisor");
		  FuncFile.waitForTimeThread(3000);
		  if (!foundSitePath) {
			  test.log(stepStatus.PASS, "Hotel deals page opened");
		  }else {
			  test.log(stepStatus.FAIL, "Hotel deals  page not opened");
			  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
			  Assert.fail("Hotel deals  page not opened");
		  }
		  driver.close();
		  driver.switchTo().window(tabs.get(0));
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
	 
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 3)
  public void TestCase11_3(String browser, String path) throws IOException, InterruptedException, ParserConfigurationException, SAXException {
	  String testName = "Group11_InterfacesTest_TestCase11.3";
	  String Description = "11.3 Connect flights orders from partner sites";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  
	  /* Step 1 */
	  System.out.println("TestCase11.3 Step 1");
	  driver.get(path);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
      String email = FuncFile.importConfigurationsData("email");
      String password = FuncFile.importConfigurationsData("password");
	  //FuncFile.connectProfile(driver, email, password);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.moreButton.click();
	  FuncFile.waitForTimeThread(1000);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.flights.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  boolean foundSitPath1 = FuncFile.waitForSitePathContainsText(driver, "https://www.tripadvisor.co.il/Flights");
	  if (foundSitPath1) {
		  test.log(stepStatus.PASS, "Flights deals page opened");
	  }else {
		  test.log(stepStatus.FAIL, "Flights deals  page not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Flights deals  page not opened");
	  }
	  
	  /* Step 2 */
	  try {
		  System.out.println("TestCase11.3 Step 2");
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		  elements.initElements(driver);
		  boolean found = FuncFile.searchClickableElement(driver, elements.flightWhereInput.get(1));
		  System.out.println("result " + found);
		  elements.initElements(driver);
		  System.out.println("From " + elements.flightWhereInput.get(0).getAttribute("value"));
		  if (found && (elements.flightWhereInput.get(1).getAttribute("value").isBlank())) {
			  elements.flightWhereInput.get(1).click();
			  elements.flightWhereInput.get(1).sendKeys("לונדון");
		  }
		  FuncFile.waitForTimeThread(1000);
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		  elements.initElements(driver);
		  elements.searchFlightsButton.click();
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		  elements.initElements(driver);
		  boolean found1 = FuncFile.searchClickableElement(driver, elements.innerSearchFlightsButton);
		  FuncFile.waitForTimeThread(3000);
		  if(found1) {
			  test.log(stepStatus.PASS, "Flight search results page opened");
		  }else {
			  test.log(stepStatus.FAIL, "Flight search results page not opened");
			  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
			  Assert.fail("Flight search results page not opened");
		  }
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
	  
	  
	  /* Step 3 */
	  System.out.println("TestCase11.3 Step 3");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  boolean found3 = FuncFile.searchClickableElement(driver, elements.viewFlightDeal);
	  elements.viewFlightDeal.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  boolean found2 = FuncFile.waitForTextPresence(driver, elements.viewFlightHeadline, "הצג את פרטי הטיסה שלך");
	  FuncFile.waitForTimeThread(3000);
	  if(found2) {
		  test.log(stepStatus.PASS, "Flight search results card opened");
	  }else {
		  test.log(stepStatus.FAIL, "Flight search results card not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Flight search results card not opened");
	  }
	  
	  /* Step 4 */
	  System.out.println("TestCase11.3 Step 4");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.viewInnerFlightDeal.get(0).click();
	  FuncFile.waitForTimeThread(3000);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	  driver.switchTo().window(tabs.get(1));
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  boolean foundSitePath = FuncFile.waitForSitePathContainsText(driver, "tripadvisor");
	  if (!foundSitePath) {
		  test.log(stepStatus.PASS, "Flights deals page opened");
	  }else {
		  test.log(stepStatus.FAIL, "Flights deals page not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Flights deals  page not opened");
	  }
	  driver.close();
	  driver.switchTo().window(tabs.get(0));
	
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 4)
  public void TestCase11_4(String browser, String path) throws IOException, ParserConfigurationException, SAXException, InterruptedException {
	  String testName = "Group11_InterfacesTest_TestCase11.4";
	  String Description = "11.4 Connect cruise orders from partner sites";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  
	  /* Step 1 */
	  System.out.println("TestCase11.4 Step 1");
	  driver.get(path);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
      String email = FuncFile.importConfigurationsData("email");
      String password = FuncFile.importConfigurationsData("password");
	  //FuncFile.connectProfile(driver, email, password);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.moreButton.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.cruise.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  String siteName = driver.getCurrentUrl();
	  if (siteName.contains("https://www.tripadvisor.co.il/Cruises")) {
		  test.log(stepStatus.PASS, "Cruises deals page opened");
	  }else {
		  test.log(stepStatus.FAIL, "Cruises deals page not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Flights deals  page not opened");
	  }
	
  }
  

}
