package Test;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.time.Duration;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 1)
  public void TestCase7_1(String browser, String path) throws IOException, ParserConfigurationException, SAXException, InterruptedException {
	  String testName = "Group7_InternationalityTest_TestCase7.1";
	  String Description = "7.1 Open google translate in differnet browsers";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  
	  /* Step 1 */
	  System.out.println("TestCase7.1 Step 1");
	  driver.get(path);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
      String email = FuncFile.importConfigurationsData("email");
      String password = FuncFile.importConfigurationsData("password");
	  //FuncFile.connectProfile(driver, email, password);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.moreButton.click();
	  FuncFile.waitForTimeThread(2000);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.travelersChoice.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  boolean foundSitePath1 = FuncFile.waitForSitePath(driver, "https://www.tripadvisor.co.il/TravelersChoice");
	  if (foundSitePath1) {
		  test.log(stepStatus.PASS, "TravelersChoice page opened");
	  }else {
		  test.log(stepStatus.FAIL, "TravelersChoice page not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("TravelersChoice page not opened");
	  }
	  

	  /* Step 2 */
	  System.out.println("TestCase7.1 Step 2");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  try {
		  System.out.println(elements.travelersChoiceTextP.get(0).getText());
		  WebElement textElement = elements.travelersChoiceTextP.get(0);
		  Actions builder = new Actions(driver);
		  builder.moveToElement(textElement).doubleClick(textElement).doubleClick().build().perform();
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		} catch (Exception e) {
			System.out.println("Error " + e);
		} 
	
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 2)
  public void TestCase7_2(String browser, String path) throws IOException, ParserConfigurationException, SAXException, InterruptedException {
	  String testName = "Group7_InternationalityTest_TestCase7.2";
	  String Description = "7.2 Test right currency conversions";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);

	  /* Step 1 */
	  System.out.println("TestCase7.2 Step 1");
	  driver.get(path);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
      String email = FuncFile.importConfigurationsData("email");
      String password = FuncFile.importConfigurationsData("password");
	  //FuncFile.connectProfile(driver, email, password);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  FuncFile.waitForTimeThread(2000);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.currencyLanguageButtons.get(0).click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  boolean foundSitePath1 = FuncFile.searchClickableElement(driver, elements.currencyUSD);
	  if (foundSitePath1) {
		  test.log(stepStatus.PASS, "Currency menu opened");
	  }else {
		  test.log(stepStatus.FAIL, "Currency menu not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Currency menu not opened");
	  }
	  
	  /* Step 2 */
	  System.out.println("TestCase7.2 Step 2");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  /* Select USD */
	  elements.currencyUSD.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  FuncFile.waitForTimeThread(2000);
	  /* Select Israel Shekel from menu */
	  elements.currencyLanguageButtons.get(0).click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.currencyILS.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  FuncFile.waitForTimeThread(2000);
	  String foundCurrencyType = elements.currencyLanguageButtons.get(0).getText();
	  System.out.println("currency type is " + foundCurrencyType);
	  if (foundCurrencyType.equals("₪ ILS")) {
		  test.log(stepStatus.PASS, "Currency type selected");
	  }else {
		  test.log(stepStatus.FAIL, "Currency type not selected");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Currency type not selected");
	  }
	  
	  /* Step 3 */
	  System.out.println("TestCase7.2 Step 3");
	  driver.get(path);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  FuncFile.waitForTimeThread(2000);
	  elements.initElements(driver);
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
	  
	  /* Step 4 */
	  System.out.println("TestCase7.2 Step 4");
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
	  
	  /* Step 5 */
	  System.out.println("TestCase7.2 Step 5");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  boolean foundCurrencySign = elements.hotelsPrices.get(0).getText().contains("₪");
	  FuncFile.waitForTimeThread(1000);
	  if (foundCurrencySign) {
		  test.log(stepStatus.PASS, "Price currency is valid");
	  }else {
		  test.log(stepStatus.FAIL, "Price currency is not valid");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Price currency is not valid"); 
	  }
	  
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 3)
  public void TestCase7_3(String browser, String path) throws IOException, ParserConfigurationException, SAXException, InterruptedException {
	  String testName = "Group7_InternationalityTest_TestCase7.3";
	  String Description = "7.3 Translate all contect to proposed languages";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  
	  /* Step 1 */
	  System.out.println("TestCase7.3 Step 1");
	  driver.get(path);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
      String email = FuncFile.importConfigurationsData("email");
      String password = FuncFile.importConfigurationsData("password");
	  //FuncFile.connectProfile(driver, email, password);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  FuncFile.waitForTimeThread(2000);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.currencyLanguageButtons.get(1).click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  boolean foundSitePath1 = FuncFile.searchClickableElement(driver, elements.englishUnitedStates);
	  if (foundSitePath1) {
		  test.log(stepStatus.PASS, "Language menu opened");
	  }else {
		  test.log(stepStatus.FAIL, "Language menu not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Currency menu not opened");
	  }
	  
	  /* Step 2 */
	  try {
		  System.out.println("TestCase7.3 Step 2");
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		  elements.initElements(driver);
		  /* Select USD */
		  elements.englishUnitedStates.click();
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		  elements.initElements(driver);
		  /* Select Israel Shekel from menu */
		  elements.currencyLanguageButtons.get(1).click();
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		  elements.initElements(driver);
		  elements.hebrewIsrael.click();
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		  FuncFile.waitForTimeThread(2000);
		  elements.initElements(driver);
		  String foundCurrencyType = elements.currencyLanguageButtons.get(1).getText();
		  System.out.println("currency type is " + foundCurrencyType);
		  if (foundCurrencyType.equals("ישראל")) {
			  test.log(stepStatus.PASS, "Language type selected");
		  }else {
			  test.log(stepStatus.FAIL, "Language type not selected");
			  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
			  Assert.fail("Language type not selected");
		  }
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
	 
	
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 4)
  public void TestCase7_4(String browser, String path) throws IOException, ParserConfigurationException, SAXException, InterruptedException {
	  String testName = "Group7_InternationalityTest_TestCase7.4";
	  String Description = "7.4 English pages to integrate with hebrew";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  
	  /* Step 1 */
	  System.out.println("TestCase7.4 Step 1");
	  driver.get(path);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
      String email = FuncFile.importConfigurationsData("email");
      String password = FuncFile.importConfigurationsData("password");
	  //FuncFile.connectProfile(driver, email, password);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.moreButton.click();
	  FuncFile.waitForTimeThread(2000);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.travelersChoice.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  boolean foundSitePath1 = FuncFile.waitForSitePath(driver, "https://www.tripadvisor.co.il/TravelersChoice");
	  /* Find whether the text is translated to Hebrew */
	  /* boolean isTextInHebrew */
	  if (foundSitePath1) {
		  test.log(stepStatus.PASS, "TravelersChoice page opened");
	  }else {
		  test.log(stepStatus.FAIL, "TravelersChoice page not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("TravelersChoice page not opened");
	  }
	
  }
  

}
