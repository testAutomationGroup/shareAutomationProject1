package Tests;

import org.testng.annotations.Test;

import Functions.FuncFile;
import HeadClass.HeadClass;
import Tools.ResultsFileBuilder;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Group8_SecuringTest extends HeadClass{
  
  ResultsFileBuilder ResultsBuilder = new ResultsFileBuilder(driver);	
  @Parameters({"browser","path"})
  @BeforeClass
  public void beforeGroup8_SecuringTest(String browser, String path) {
	  System.out.println("Here we start");
	  //Create test report file for report system sanity tests
	  report = ResultsBuilder.GetExtent("Group8_SecuringTest tests");
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
  public void AfterGroup8_SecuringTest(String browser) throws InterruptedException {
	  System.out.println("Group8_SecuringTest ended for browser " + browser);
	  FuncFile.waitForTimeThread(2000);
	  report.flush();
	  //driver.close();
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 1)
  public void TestCase8_1(String browser, String path) throws IOException {
	  String testName = "Group8_SecuringTest_TestCase8.1";
	  String Description = "8.1 Connect secured connection in various browsers";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  
	  /* Step 1 */
	  System.out.println("TestCase8.1 Step 1");
	  driver.get(path);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  boolean isSequredSite = driver.getCurrentUrl().contains("https");
	  if (isSequredSite) {
		  test.log(stepStatus.PASS, "Site path is sequred");
	  }else {
		  test.log(stepStatus.FAIL, "Site path is not sequred");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Site path is not sequred");
	  }
	
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 2)
  public void TestCase8_2(String browser, String path) throws IOException, InterruptedException {
	  String testName = "Group8_SecuringTest_TestCase8.2";
	  String Description = "8.2 Location share settings";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  
	  /* Step 1 */
	  System.out.println("TestCase8.2 Step 1");
	  /* Set my location to test hotels search in the area */
	  FuncFile.setLocation("San Francisco");
	  String myLocation = FuncFile.findMyLocation(driver);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  /* Start website location test. Then set English language for best search */
	  driver.get(path);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  FuncFile.waitForTimeThread(2000);
	  elements.initElements(driver);
	  elements.currencyLanguageButtons.get(1).click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.countries.get(0).click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  /* FuncFile.connectProfile(driver, email, password); */
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.hotels.click();
	  boolean found = FuncFile.searchClickableElement(driver, elements.hotelsSearchInput);
	  if (found) {
		  test.log(stepStatus.PASS, "Hotels search menu opened");
	  }else {
		  test.log(stepStatus.FAIL, "Hotels search menu not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Hotels search menu not opened"); 
	  }
	  
	  /* Step 2 */
	  System.out.println("TestCase8.2 Step 2");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  FuncFile.waitForTimeThread(1000);
	  System.out.println(elements.searchHotelItems.get(0).getText());
	  elements.searchHotelItems.get(0).click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  FuncFile.waitForTimeThread(2000);
	  System.out.println("My location is " + myLocation);
	  boolean found1 = driver.getPageSource().contains(myLocation);
	  if (found1) {
		  test.log(stepStatus.PASS, "Location share setting is valid");
	  }else {
		  test.log(stepStatus.FAIL, "Location share setting is not valid");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Location share setting is not valid"); 
	  }
	  
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 3)
  public void TestCase8_3(String browser, String path) throws IOException, InterruptedException {
	  String testName = "Group8_SecuringTest_TestCase8.3";
	  String Description = "8.3 Import a non actual place";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  
	  /* Step 1 */
	  try {
		  System.out.println("TestCase8.3 Step 1");
		  driver.get(path);
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		  elements.initElements(driver);
	      String email = FuncFile.importConfigurationsData("email");
	      String password = FuncFile.importConfigurationsData("password");
		  FuncFile.connectProfile(driver, email, password);
		  
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		  elements.initElements(driver);
		  elements.moreButton.click();
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		  elements.initElements(driver);
		  elements.createPlaceButton.click();
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		  elements.initElements(driver);
		  String siteName = driver.getCurrentUrl();
		  if (siteName.equals("https://www.tripadvisor.co.il/CreateListing.html")) {
			  test.log(stepStatus.PASS, "Create place page opened");
		  }else {
			  test.log(stepStatus.FAIL, "Create place page is not opened");
			  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
			  //Assert.fail("Create place page is not opened");
		  }
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
	  
	  
	  /* Step 2 */
	  System.out.println("TestCase8.3 Step 2");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.creatPlaceMenuItems.get(2).click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.creatPlaceMenuItems.get(5).click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.creatPlaceContinueButton.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  boolean found = FuncFile.searchClickableElement(driver, elements.placeNameInput);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  if (found) {
		  test.log(stepStatus.PASS, "Create trip card opened");
	  }else {
		  test.log(stepStatus.FAIL, "Create trip card is not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Create trip card is not opened"); 
	  }
	  
	  /*Step 3 */
	  System.out.println("TestCase8.3 Step 3");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  FuncFile.waitForTimeThread(1000);
	  elements.initElements(driver);
	  elements.placeNameInput.sendKeys("Place name");
	  elements.placeAddressInput.get(0).sendKeys("Ramat Gan");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.placeAdressInpuItems.get(0).click();
	  elements.placeAddressBuilding.sendKeys("Street and Building number");
	  FuncFile.waitForTimeThread(1000);
	  elements.placeFormInnerContinueButton.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  FuncFile.waitForTimeThread(2000);
	  elements.initElements(driver);
	  boolean found1 = FuncFile.searchClickableElement(driver, elements.placeCategory.get(0));
	  if (found1) {
		  test.log(stepStatus.PASS, "Trip attched to catalog");
	  }else {
		  test.log(stepStatus.FAIL, "Trip not attched to catalog");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Trip not attched to catalog"); 
	  }
	  
	  /*Step 4 */
	  System.out.println("TestCase8.3 Step 4");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.placeCategory.get(0).click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.addFoodTypes.get(0).click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.foodTypes.get(0).click();
	  elements.foodTypes.get(1).click();
	  elements.foodTypes.get(2).click();
	  elements.foodTypes.get(3).click();
	  elements.foodTypes.get(4).click();
	  elements.saveFoodTypes.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.createPlaceAgrreement.click();
	  elements.placeFormInner2ContinueButton.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.sendPlaceDetailes.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  FuncFile.waitForTimeThread(1000);
	  boolean found2 = FuncFile.searchClickableElement(driver, elements.completePlaceForm);
	  elements.completePlaceForm.click();
	  if (found2){
		  test.log(stepStatus.PASS, "Create place is sent for validating");
	  }else {
		  test.log(stepStatus.FAIL, "Create place is not sent for validating");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Create place is not sent for validating"); 
	  }
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 4)
  public void TestCase8_4(String browser, String path) throws IOException, InterruptedException {
	  String testName = "Group8_SecuringTest_TestCase8.4";
	  String Description = "8.4 Locating machines created reviews";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  Assert.assertTrue(true);
	
	  /* Step 1 */
	  System.out.println("TestCase8.4 Step 1");
	  driver.get(path);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  FuncFile.waitForTimeThread(2000);
	  elements.initElements(driver);
	  /* FuncFile.connectProfile(driver, email, password); */
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.mainSearchInput.sendKeys("Pastory");
	  elements.mainSearchInput.sendKeys(Keys.RETURN);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  boolean found = FuncFile.waitForTextPresence(driver, elements.searchResultsHeadlines.get(0), "Pastory");
	  FuncFile.waitForTimeThread(1000);
	  if (found) {
		  test.log(stepStatus.PASS, "Hotels search menu opened");
	  }else {
		  test.log(stepStatus.FAIL, "Hotels search menu not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Hotels search menu not opened"); 
	  }
	  
	  /* Step 2 */
	  System.out.println("TestCase8.4 Step 2");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  FuncFile.waitForTimeThread(3000);
	  elements.initElements(driver);
	  elements.searchResultsHeadlines.get(0).click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  FuncFile.waitForTimeThread(1000);
	  List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	  driver.switchTo().window(tabs.get(1));
	  
	  boolean found4 = FuncFile.searchClickableElement(driver, elements.referenceListContents.get(0));
	  if (found4) {
		  test.log(stepStatus.PASS, "References results is opened");
	  }else {
		  test.log(stepStatus.FAIL, "References results is not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("References results is not opened"); 
	  }	
	  driver.close();
	  driver.switchTo().window(tabs.get(0));
	 
  }
  

}
