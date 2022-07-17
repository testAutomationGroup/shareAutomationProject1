package Test;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Group6_RecoveryTest extends HeadClass{
  
  ResultsFileBuilder ResultsBuilder = new ResultsFileBuilder(driver);	
  @Parameters({"browser","path"})
  @BeforeClass
  public void beforeGroup6_RecoveryTest(String browser, String path) {
	  System.out.println("Here we start");
	  //Create test report file for report system sanity tests
	  report = ResultsBuilder.GetExtent("Group6_RecoveryTest tests");
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
  public void AfterGroup6_RecoveryTest(String browser) throws InterruptedException {
	  System.out.println("Group6_RecoveryTest ended for browser " + browser);
	  FuncFile.waitForTimeThread(2000);
	  report.flush();
	  //driver.close();
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 1)
  public void TestCase6_1(String browser, String path) throws IOException, ParserConfigurationException, SAXException, InterruptedException {
	  String testName = "Group6_RecoveryTest_TestCase6.1";
	  String Description = "6.1 Recovery from disconnections during trips creation";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  
	  /* Step 1 */
//	  System.out.println(FuncFile.isConnectedInternet());
//	  Runtime.getRuntime().exec("netsh wlan disconnect");
//	  while (!FuncFile.isConnectedInternet()) {
//		  System.out.println("Trying to connect");
//		  Runtime.getRuntime().exec("netsh wlan connect name='Hackeru1'");
//	  }
	  
	  
	  System.out.println("TestCase6.1 Step 1");
	  driver.get(path);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
      String email = FuncFile.importConfigurationsData("email");
      String password = FuncFile.importConfigurationsData("password");
	  FuncFile.connectProfile(driver, email, password);
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
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
	  
	  /* Step 2 */
	  System.out.println("TestCase6.1 Step 2");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.createTrip.click();
	  elements.initElements(driver);
	  FuncFile.waitForTimeThread(2000);
	  boolean found = FuncFile.searchClickableElement(driver, elements.tripNameInput);
	  if (found) {
		  test.log(stepStatus.PASS, "Create trip card opened");
	  }else {
		  test.log(stepStatus.FAIL, "Create trip card is not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Create trip card is not opened"); 
	  }
	  
	  /*Step 3 */
	  System.out.println("TestCase6.1 Step 3");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  FuncFile.waitForTimeThread(1000);
	  elements.initElements(driver);
	  elements.tripNameInput.sendKeys("התאוששות מניתוקים");
	  elements.innerCreateTripButton.click();
	  elements.initElements(driver);
	  boolean found1 = FuncFile.searchClickableElement(driver, elements.tripsInCatalog.get(0));
	  if (found1) {
		  test.log(stepStatus.PASS, "Trip attched to catalog");
	  }else {
		  test.log(stepStatus.FAIL, "Trip not attched to catalog");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Trip not attched to catalog"); 
	  }
	  
	  /* Step 4 */ 
	  System.out.println("TestCase6.1 Step 4");
	  FuncFile.waitForTimeThread(3000);
	  elements.initElements(driver);
	  FuncFile.searchClickableElement(driver, elements.tripsInCatalog.get(0));
	  elements.tripsInCatalog.get(0).click();
	  elements.initElements(driver);
	  boolean found2 = FuncFile.searchClickableElement(driver, elements.placeSearchInput);
	  if (found2) {
		  test.log(stepStatus.PASS, "Trip page is opened");
	  }else {
		  test.log(stepStatus.FAIL, "Trip page is not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Trip page is not opened"); 
	  }
	  
	  /* Step 5 */
	  System.out.println("TestCase6.1 Step 5");
	  elements.placeSearchInput.sendKeys("אילת");
	  elements.initElements(driver);
	  FuncFile.searchClickableElement(driver, elements.placeSearchItems.get(0));
	  elements.placeSearchItems.get(0).click();
	  elements.initElements(driver);
	  boolean found3 = FuncFile.searchClickableElement(driver, elements.savedPlaces.get(0));
	  if (found3) {
		  test.log(stepStatus.PASS, "Place attached to trip route");
	  }else {
		  test.log(stepStatus.FAIL, "Place not attached to trip route");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Place not attached to trip route"); 
	  }
	  
	  /* Step 6 */
	  System.out.println("TestCase6.1 Step 6");
	  FuncFile.waitForTimeThread(2000);
	  System.out.println("TestCase6.1 Step 6");
	  Runtime.getRuntime().exec("netsh wlan disconnect");
	  FuncFile.waitForTimeThread(4000);
	  Runtime.getRuntime().exec("netsh wlan connect name='Hackeru1'");
	  
	  FuncFile.cleanTripWithoutLink(driver, 1);
	
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 2)
  public void TestCase6_2(String browser, String path) throws IOException, ParserConfigurationException, SAXException, InterruptedException {
	  String testName = "Group6_RecoveryTest_TestCase6.2";
	  String Description = "6.2 Recovery from disconnections during reviews creation";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  
	  /* Step 1 */
	  try {
		  System.out.println("TestCase6.2 Step 1");
		  driver.get(path);
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		  elements.initElements(driver);
	      String email = FuncFile.importConfigurationsData("email");
	      String password = FuncFile.importConfigurationsData("password");
		  FuncFile.connectProfile(driver, email, password);
		  
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		  elements.initElements(driver);
		  elements.referencesPageButton.click();
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		  elements.initElements(driver);
		  String siteName = driver.getCurrentUrl();
		  if (siteName.equals("https://www.tripadvisor.co.il/UserReview")) {
			  test.log(stepStatus.PASS, "Reference page opened");
		  }else {
			  test.log(stepStatus.FAIL, "Reference page not opened");
			  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
			  Assert.fail("Reference page not opened");
		  }
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
	  
	  
	  /* Step 2 */
	  System.out.println("TestCase6.2 Step 2");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.referenceSearchInput.sendKeys("טיילת בת ים");
	  FuncFile.waitForTimeThread(2000);
	  elements.initElements(driver);
	  elements.referenceSearchMenuItems.get(0).click();
	  FuncFile.waitForTimeThread(2000);
	  elements.initElements(driver);
	  boolean found = FuncFile.searchClickableElement(driver, elements.tripNameInput);
	  if (found) {
		  test.log(stepStatus.PASS, "Create trip card opened");
	  }else {
		  test.log(stepStatus.FAIL, "Create trip card is not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Create trip card is not opened"); 
	  }
	  
	  /*Step 3 */
	  System.out.println("TestCase6.2 Step 3");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  FuncFile.waitForTimeThread(1000);
	  elements.initElements(driver);
	  elements.referenceTextArea.sendKeys("Refeerence text area Refeerence text area Refeerence text area Refeerence text area\n"
	  		+ "Refeerence text area Refeerence text area Refeerence text area Refeerence text area\n"
	  		+ "Refeerence text area Refeerence text area Refeerence text area Refeerence text area\n"
	  		+ "Refeerence text area Refeerence text area Refeerence text area Refeerence text area");
	  elements.referenceTextArea.sendKeys("Your Reference headlines");
	  elements.referenceTextArea.sendKeys("Your Reference");
	  elements.referenceWhenVisited.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.referenceDatesVisitid.get(1).click();
	  elements.referenceVisitedWith.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.referenceVisitedWithItems.get(2).click();
	  elements.referenceAgreement.click();
	  elements.sendReference.click();
	  
	  
	  elements.initElements(driver);
	  boolean found1 = FuncFile.searchClickableElement(driver, elements.tripsInCatalog.get(0));
	  if (found1) {
		  test.log(stepStatus.PASS, "Trip attched to catalog");
	  }else {
		  test.log(stepStatus.FAIL, "Trip not attched to catalog");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Trip not attched to catalog"); 
	  }
	  
	  /* Step 4 */
//	  System.out.println("TestCase6.2 Step 4");
//	  FuncFile.waitForTimeThread(2000);
//	  Runtime.getRuntime().exec("netsh wlan disconnect");
//	  FuncFile.waitForTimeThread(4000);
//	  Runtime.getRuntime().exec("netsh wlan connect name='Hackeru1'");
	
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 3)
  public void TestCase6_3(String browser, String path) throws IOException, InterruptedException {
	  String testName = "Group6_RecoveryTest_TestCase6.3";
	  String Description = "6.3 Recovery from disconnections while adding a place to visit";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  
	  /* Step 1 */
	  try {
		  System.out.println("TestCase6.3 Step 1");
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
			  Assert.fail("Create place page is not opened");
		  }
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
	  
	  
	  /* Step 2 */
	  System.out.println("TestCase6.3 Step 2");
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
		  Assert.fail("Create trip card is not opened"); 
	  }
	  
	  /*Step 3 */
	  System.out.println("TestCase6.3 Step 3");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  FuncFile.waitForTimeThread(1000);
	  elements.initElements(driver);
	  elements.placeNameInput.sendKeys("Place name");
	  elements.placeAddressInput.get(0).sendKeys("Ramat Gan");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.placeAdressInpuItems.get(0).click();
	  elements.placeAddressBuilding.sendKeys("Street and Building number");
	  elements.placeFormInnerContinueButton.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  boolean found1 = FuncFile.searchClickableElement(driver, elements.placeCategory.get(0));
	  if (found1) {
		  test.log(stepStatus.PASS, "Trip attched to catalog");
	  }else {
		  test.log(stepStatus.FAIL, "Trip not attched to catalog");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Trip not attched to catalog"); 
	  }
	  
	  /* Step 4 */
//	  System.out.println("TestCase6.3 Step 4");
//	  FuncFile.waitForTimeThread(2000);
//	  Runtime.getRuntime().exec("netsh wlan disconnect");
//	  FuncFile.waitForTimeThread(4000);
//	  Runtime.getRuntime().exec("netsh wlan connect name='Hackeru1'");
	
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 4)
  public void TestCase6_4(String browser, String path) throws IOException, InterruptedException, AWTException, ParserConfigurationException, SAXException {
	  String testName = "Group6_RecoveryTest_TestCase6.4";
	  String Description = "6.4 Recovery from disconnections while adding image";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  
	  /* Step 1 */
	  System.out.println("TestCase6.4 Step 1");
	  driver.get(path);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
      String email = FuncFile.importConfigurationsData("email");
      String password = FuncFile.importConfigurationsData("password");
	  FuncFile.connectProfile(driver, email, password);
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.profileButton.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.createPlaceButton.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  List<WebElement> menuItems1 = driver.findElements(elements.profileMenuItem);
	  WebElement viewProfile = menuItems1.get(1);
	  boolean found = FuncFile.searchClickableElement(driver, viewProfile);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  if (found) {
		  test.log(stepStatus.PASS, "Profile menu opened");
	  }else {
		  test.log(stepStatus.FAIL, "Profile menu not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Profile menu not opened"); 
	  }
	  
	  /* Step 2 */
	  System.out.println("TestCase6.4 Step 2");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  viewProfile.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  String siteName = driver.getCurrentUrl();
	  if (siteName.equals("https://www.tripadvisor.co.il/Profile/EladAr1")) {
		  test.log(stepStatus.PASS, "View profile page opened");
	  }else {
		  test.log(stepStatus.FAIL, "View profile page is not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("View profile page is not opened");
	  }
	  
	  /*Step 3 */
	  System.out.println("TestCase6.4 Step 3");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  FuncFile.waitForTimeThread(1000);
	  elements.initElements(driver);
	  elements.shareProfileImagesReferences.get(0).click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  boolean found1 = FuncFile.searchClickableElement(driver, elements.shareLoadImagesButton);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  if (found1) {
		  test.log(stepStatus.PASS, "Image load card opned");
	  }else {
		  test.log(stepStatus.FAIL, "Image load card not opned");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Image load card not opned"); 
	  }
	  
	  /* Step 4 */
	  System.out.println("TestCase6.4 Step 4");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.shareLoadImagesButton.click();

	  FuncFile.waitForTimeThread(1000);
	  
	  StringSelection path1 = new StringSelection("C:\\my files\\Selenium\\bat yam.jpg");
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path1, null);
	  Robot robot = new Robot();
	  robot.keyPress(KeyEvent.VK_CONTROL);
	  robot.keyPress(KeyEvent.VK_V);
	  robot.keyRelease(KeyEvent.VK_CONTROL);
	  robot.keyRelease(KeyEvent.VK_V);
	  robot.keyPress(KeyEvent.VK_ENTER);
	  robot.keyRelease(KeyEvent.VK_ENTER);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  
	  boolean foundSharedImage = FuncFile.searchElement(driver, elements.sharedLoadImage);
	  if (foundSharedImage) {
		  test.log(stepStatus.PASS, "Share image is valid");
	  }else {
		  test.log(stepStatus.FAIL, "Share image is not valid");
		  ResultsBuilder.SendTestImage(test, driver, "PASS", testName, browser);
		  Assert.fail("Share image is not valid");
	  }
	  
	  /* Step 5 */
	  System.out.println("TestCase6.4 Step 5");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.sharedImageAddDescription.sendKeys("Image description");
	  FuncFile.waitForSendKeys(driver, elements.profileTextAreaInput, "Image description");
	  elements.sharedImageAddLocation.click();
	  elements.sharedImageAddLocation.sendKeys("בת ים");
	  FuncFile.waitForSendKeys(driver, elements.profileTextAreaInput, "בת ים");
	  elements.sharedImageAddLocation.sendKeys(Keys.ENTER);
	  elements.sharedImageSubmit.click();
	  boolean foundSharedImageHeadLine = FuncFile.searchElement(driver, elements.sharedImageHeadLine);
	  if (foundSharedImageHeadLine) {
		  test.log(stepStatus.PASS, "Share image is valid");
	  }else {
		  test.log(stepStatus.FAIL, "Share image is not valid");
		  ResultsBuilder.SendTestImage(test, driver, "PASS", testName, browser);
		  Assert.fail("Share image is not valid");
	  }
	  
	  
	  /* Step 6 */
//	  System.out.println("TestCase6.4 Step 6");
//	  FuncFile.waitForTimeThread(2000);
//	  Runtime.getRuntime().exec("netsh wlan disconnect");
//	  FuncFile.waitForTimeThread(4000);
//	  Runtime.getRuntime().exec("netsh wlan connect name='Hackeru1'");
	
  }
  

}
