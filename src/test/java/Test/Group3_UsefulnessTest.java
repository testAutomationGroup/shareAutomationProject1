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
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Group3_UsefulnessTest extends HeadClass{
  
  ResultsFileBuilder ResultsBuilder = new ResultsFileBuilder(driver);	
  @Parameters({"browser","path"})
  @BeforeClass
  public void beforeGroup3_UsefulnessTest(String browser, String path) {
	  System.out.println("Here we start");
	  //Create test report file for report system sanity tests
	  report = ResultsBuilder.GetExtent("Group3_UsefulnessTest tests");
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
  public void AfterGroup3_UsefulnessTest(String browser) throws InterruptedException {
	  System.out.println("Group3_UsefulnessTest ended for browser " + browser);
	  FuncFile.waitForTimeThread(2000);
	  report.flush();
	  //driver.close();
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 1)
  public void TestCase3_1_1(String browser, String path) throws IOException, ParserConfigurationException, SAXException, InterruptedException {
	  String testName = "Group3_UsefulnessTest_TestCase3.1.1";
	  String Description = "3.1.1 Connect to profile";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  
	  /*Step 1*/
	  System.out.println("TestCase3.1.1 Step 1");
	  driver.get(path);
	  elements.initElements(driver);
	  elements.connectButton.click();
	  try {
		elements.initElements(driver);
		driver.switchTo().frame(elements.googleIframe);
		FuncFile.waitForTimeThread(1000);
		WebElement ConnectivityWindow = driver.findElement(By.cssSelector("#regBody"));
		test.log(stepStatus.PASS, "Connectivity windows opened");
	  } catch (Exception e) {
		System.out.println(e);
		test.log(stepStatus.FAIL, "Connectivity windows not opened");
		ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		//Assert.fail("Connectivity windows not opened");
		
	  }  
	  
	  /* Step 2*/
	  System.out.println("TestCase3.1.1 Step 2");
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
			  //Assert.fail("Profile page was not opened");
		  }
		} catch (Exception e) {
			System.out.println("Page not loaded " + e);
		}
	  
	  /* Step 3*/
	  System.out.println("TestCase3.1.1 Step 3");
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
			  //Assert.fail("Account page was not opened");
		  }
		} catch (Exception e) {
			System.out.println(e);
		}
	  
	  /* Step 4 */
	  System.out.println("TestCase3.1.1 Step 4");
	  elements.initElements(driver);
	  System.out.println(elements.AccountFirstName.getAttribute("value"));
	  System.out.println(elements.AccountFamilyName.getAttribute("value"));
	  System.out.println(elements.AccountEmail.getAttribute("value"));
	  if (elements.AccountFirstName.getAttribute("value").equals("Elad")&&elements.AccountFamilyName.getAttribute("value").equals("Arnon")&&elements.AccountEmail.getAttribute("value").equals("arnonelad1@gmail.com")) {
		  test.log(stepStatus.PASS, "Valid account details");
	  }else {
		  test.log(stepStatus.FAIL, "Account details is not valid");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Account details is not valid");
	  }	  
	  
	  /* Step 5 */
	  System.out.println("TestCase3.1.1 Step 5");
	  elements.AccountFirstName.clear();
	  elements.AccountFirstName.sendKeys("EladSaveTest");
	  elements.AccountPageSaveButton.click();
	  
	  if (elements.AccountFirstName.getAttribute("value").equals("EladSaveTest")) {
		  test.log(stepStatus.PASS, "Valid details saving");
	  }else {
		  test.log(stepStatus.FAIL, "Details saving is not valid");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Details saving is not valid");
	  }
	  	
	  FuncFile.waitForTimeThread(3000);
	  elements.initElements(driver);
	  elements.AccountFirstName.clear();
	  elements.AccountFirstName.sendKeys("Elad");
	  elements.AccountPageSaveButton.click();
	  
	  /*Step 6 */
	  try {
		  System.out.println("TestCase3.1.1 Step 6");
		  FuncFile.waitForTimeThread(3000);
		  elements.initElements(driver);
		  elements.SignOutSeesions.click();
		  elements.continueSignOut.click();
		  if (FuncFile.searchClickableElement(driver, elements.signOutAccountNotification)) {
			  test.log(stepStatus.PASS, "Valid accounts sign out process");
		  } else {
			  test.log(stepStatus.FAIL, "Accounts sign out process is not validated");  
			  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
			  //Assert.fail("Accounts sign out process is not validated");
		  }
		  elements.signOutCloseButton.click();
		} catch (Exception e) {
			System.out.println("error " +e);
			
		}
	
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 2)
  public void TestCase3_1_2(String browser, String path) throws IOException, ParserConfigurationException, SAXException {
	  String testName = "Group3_UsefulnessTest_TestCase3.1.2";
	  String Description = "3.1.2 Notifications and profile settings";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test, driver, "PASS", testName, browser);
	  
	  /* Step 1 */
	  System.out.println("TestCase3.1.2 Step 1");
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
		  //Assert.fail("Notifications page not opened");
	  }	  
	  
	  /* Step 2 */
	  System.out.println("TestCase3.1.2 Step 2");
	  elements.notificationsPageSearchRow.sendKeys("Eilat");
	  elements.notificationsPageSearchRow.sendKeys(Keys.RETURN);
	  System.out.println(elements.resultsPageActiveTab.getText());
	  if (elements.resultsPageActiveTab.getText().equals("כל התוצאות")){
		  test.log(stepStatus.PASS, "Search row validated");
	  }else {
		  test.log(stepStatus.FAIL, "Search row not valid");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Search row not valid");
	  }	  
	  
	  /* Step 3 */
	  System.out.println("TestCase3.1.2 Step 3");
	  driver.navigate().back();
	  elements.archiveButton.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  String siteName1 = driver.getCurrentUrl();
	  if (siteName1.equals("https://www.tripadvisor.co.il/Inbox?archived=true")) {
		  test.log(stepStatus.PASS, "Archive page opened");
	  }else {
		  test.log(stepStatus.FAIL, "Archive page not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Archive page not opened");
	  }	
	  
	  /* Step 4 */
	  System.out.println("TestCase3.1.2 Step 4");
	  driver.navigate().back();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.settingsButton.click();
	  List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	  driver.switchTo().window(tabs.get(1));
	  String siteName2 = driver.getCurrentUrl();
	  System.out.println(siteName2);
	  if (siteName2.equals("https://www.tripadvisor.co.il/Settings-cs")) {
		  test.log(stepStatus.PASS, "Settings page opened");
	  }else {
		  test.log(stepStatus.FAIL, "Settings page not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Settings page not opened");
	  }	
	  driver.close();
	  driver.switchTo().window(tabs.get(0));
	  
	  /* Step 5 */
	  System.out.println("TestCase3.1.2 Step 5");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  elements.commonQuestions.click();
	  List<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
	  driver.switchTo().window(tabs2.get(1));
	  String siteName3 = driver.getCurrentUrl();
	  System.out.println(siteName3);
	  if (siteName2.equals("https://www.tripadvisor.co.il/questions")) {
		  test.log(stepStatus.PASS, "Questions page opened");
		  driver.close();
		  driver.switchTo().window(tabs.get(0));
	  }else {
		  test.log(stepStatus.FAIL, "Questions page not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  driver.close();
		  driver.switchTo().window(tabs.get(0));
		  //Assert.fail("Questions page not opened");
	  }	
	  driver.close();
	
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 3)
  public void TestCase3_1_3(String browser, String path) throws IOException, ParserConfigurationException, SAXException, InterruptedException {
	  String testName = "Group3_UsefulnessTest_TestCase3.1.3";
	  String Description = "3.1.3 Trips";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test, driver, "PASS", testName, browser);
	  
	  /* Step 1 */
	  System.out.println("3.1.3 Trips test Step 1");
	  driver.get(path);
      String email = FuncFile.importConfigurationsData("email");
      String password = FuncFile.importConfigurationsData("password");
	  //FuncFile.connectProfile(driver, email, password);
	  elements.trips.click();
	  String siteName = driver.getCurrentUrl();
	  System.out.println(siteName);
	  if (siteName.equals("https://www.tripadvisor.co.il/Trips")) {
		  test.log(stepStatus.PASS, "Trips page opened");
	  }else {
		  test.log(stepStatus.FAIL, "Trips page not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Trips page not opened");
	  }
	  
	  /* Step 2 */
	  System.out.println("3.1.3 Trips test Step 2");
	  elements.createTrip.click();
	  elements.initElements(driver);
	  if (FuncFile.searchClickableElement(driver, elements.tripNameInput)) {
		  test.log(stepStatus.PASS, "Created trip window opened");
	  }else {
		  test.log(stepStatus.FAIL, "Created trip window not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Created trip window not opened");
	  }
	  
	  /* Step 3 and 4*/
	  System.out.println("3.1.3 Trips test Step 3 and 4");
	  elements.tripNameInput.sendKeys("Trip to Eilat");
	  elements.innerCreateTripButton.click();
	  WebElement eilatTrip = FuncFile.selectTrip(driver, 1);
	  eilatTrip.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  String headline = elements.tripPageName.getText();
	  if (headline.equals("Trip to Eilat")) {
		  test.log(stepStatus.PASS, "Created trip page opened");
	  }else {
		  test.log(stepStatus.FAIL, "Created trip  page not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Created trip  page not opened");
	  }
	  
	  /* Step 5 */
	  System.out.println("3.1.3 Trips test Step 5");
	  WebElement eilatTrip1 = FuncFile.selectTrip(driver, 1);
	  eilatTrip1.click();
	  elements.placeSearchInput.sendKeys("אמריקנה");
	  elements.initElements(driver);
	  elements.placeSearchItems.get(0).click();
	  elements.initElements(driver);
	  if (FuncFile.searchClickableElement(driver, elements.hotelName)) {
		  test.log(stepStatus.PASS, "Possible to add place to trip");
	  }else {
		  test.log(stepStatus.FAIL, "Cannot add place to trip");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Created trip  page not opened");
	  }
	  
	  /* Step 6 */
	  System.out.println("3.1.3 Trips test Step 6");
	  WebElement eilatTrip2 = FuncFile.selectTrip(driver, 1);
	  eilatTrip2.click();
	  elements.shareTripButton.click();
	  elements.initElements(driver);
	  elements.shareMenuItems.get(1).click();
	  FuncFile.waitForTimeThread(4000);
	  Actions builder = new Actions(driver);
	  elements.tripSearchInput.click();
	  builder.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
	  String link = elements.tripSearchInput.getAttribute("value");
	  List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	  driver.switchTo().newWindow(WindowType.TAB);
	  driver.get(link);
	  System.out.println("link is " + link);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  if (elements.tripPageName.getText().equals("Trip to Eilat")) {
		  test.log(stepStatus.PASS, "Linked saving is valid");
	  }else {
		  test.log(stepStatus.FAIL, "Linked saving is not valid");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Linked saving is not valid");
	  }
	  driver.close();
	  driver.switchTo().window(tabs.get(0));
	  elements.tripSearchInput.clear();
	  elements.tripSearchInput.sendKeys(Keys.ESCAPE);
	  
	  /* Step 7 */
	  System.out.println("3.1.3 Trips test Step 7");
	  driver.get(FuncFile.findTripsPagePath(driver));
	  elements.addsTripDates.click();
	  boolean found = FuncFile.searchClickableElement(driver, elements.datesSelect);
	  elements.datesSelect.click();
	  found = FuncFile.searchClickableElement(driver, elements.selectDatesInMenu.get(2));
	  elements.selectDatesInMenu.get(2).click();
	  found = FuncFile.searchClickableElement(driver, elements.clenderDay1ThisMonth);
	  elements.clenderDay1ThisMonth.click();
	  elements.initElements(driver);
	  found = FuncFile.searchClickableElement(driver, elements.clenderDay1ThisMonth);
	  elements.clenderDay1ThisMonth.click();
	  found = FuncFile.searchClickableElement(driver, elements.saveDatesButton);
	  elements.saveDatesButton.click();
	  found = FuncFile.searchClickableElement(driver, elements.tripDates);
	  if (found) {
		  test.log(stepStatus.PASS, "Saving trip dates is valid");
	  }else {
		  test.log(stepStatus.FAIL, "Saving trip dates is not valid");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Saving trip dates is not valid");
	  }
	  
	  /* Step 8 */
	  try {
		  System.out.println("3.1.3 Trips test Step 8");
		  driver.get(FuncFile.findTripsPagePath(driver));
		  elements.tripMenu.click();
		  List<WebElement> tripMenu = elements.tripMenuItems;
		  tripMenu.get(0).click();
		  elements.tripDescriptionInput.sendKeys("The best trip ever");
		  FuncFile.waitForSendKeys(driver, elements.tripDescriptionInput, "The best trip ever");
		  FuncFile.waitForTimeThread(4000);
		  elements.initElements(driver);
		  elements.tripUpdateSaveButton.click();
		  FuncFile.searchClickableElement(driver, elements.tripMenu);
		  FuncFile.waitForTimeThread(4000);
		  System.out.println("here 4");
		  elements.initElements(driver);
		  String description = elements.tripDescription.getText();
		  System.out.println(description);
		  if (description.equals("The best trip ever")) {
			  test.log(stepStatus.PASS, "Saving trip description is valid");
		  }else {
			  test.log(stepStatus.FAIL, "Saving trip description is not valid");
			  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
			  ////Assert.fail("Saving trip description is not valid");
		  }
	} catch (Exception e) {
		System.out.println("Error " + e);
	}
	  
	  /* Step 9 */
	  System.out.println("3.1.3 Trips test Step 9");
	  driver.get(FuncFile.findTripsPagePath(driver));
	  System.out.println("Here " + FuncFile.findTripsPagePath(driver));
	  elements.tripMenu.click();
	  List<WebElement> tripMenu2 = elements.tripMenuItems;
	  tripMenu2.get(0).click();
	  elements.updateTripNameInput.sendKeys(" city");
	  elements.tripUpdateSaveButton.click();
	  FuncFile.waitForTimeThread(3000);
	  elements.initElements(driver);
	  String tripName = elements.tripPageName.getText();
	  System.out.println(tripName);
	  if (tripName.equals("Trip to Eilat city")) {
		  test.log(stepStatus.PASS, "Saving trip name is valid");
	  }else {
		  test.log(stepStatus.FAIL, "Saving trip name is not valid");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Saving trip name is not valid");
	  }
	  
	  /* Step 10 */
	  System.out.println("3.1.3 Trips test Step 10");
	  driver.get(FuncFile.findTripsPagePath(driver));
	  elements.tripMenu.click();
	  List<WebElement> tripMenu1 = elements.tripMenuItems;
	  tripMenu1.get(1).click();
	  FuncFile.searchClickableElement(driver, elements.addTripLinkInput);
	  elements.addTripLinkInput.sendKeys("https://www.tripadvisor.co.il/Trips/115851948");
	  FuncFile.searchClickableElement(driver, elements.addLinkButton);
	  elements.addLinkButton.click();
	  FuncFile.searchClickableElement(driver, elements.addLinkButton2);
	  elements.addLinkButton2.click();
	  FuncFile.waitForTimeThread(3000);
	  elements.initElements(driver);
	  boolean tripLinkFound = FuncFile.searchClickableElement(driver, elements.tripLinkDescription);
	  if (tripLinkFound) {
		  test.log(stepStatus.PASS, "Saving link is valid");
	  }else {
		  test.log(stepStatus.FAIL, "Saving link is not valid");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Saving link is not valid");
	  }
	  
	  /* Step 11 */
	  System.out.println("3.1.3 Trips test Step 11");
	  driver.get(FuncFile.findTripsPagePath(driver));
	  elements.tripMenu.click();
	  List<WebElement> tripMenu3 = elements.tripMenuItems;
	  tripMenu3.get(3).click();
	  elements.privacyButtons.get(1).click();
	  elements.saveTripPrivacySettings.click();
	  elements.continueWithDates.get(1).click();
	  boolean likeFound = FuncFile.searchClickableElement(driver, elements.tripLikes.get(0));
	  if (likeFound) {
		  test.log(stepStatus.PASS, "Public trip is valid");
	  }else {
		  test.log(stepStatus.FAIL, "Public trip is not valid");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Saving link is not valid");
	  }
	  
	  /* Step 12 */
	  System.out.println("3.1.3 Trips test Step 12");
	  driver.get(FuncFile.findTripsPagePath(driver));
	  elements.tripMenu.click();
	  List<WebElement> tripMenu4 = elements.tripMenuItems;
	  tripMenu4.get(4).click();
	  elements.noteHeadline.sendKeys("This is a test");
	  elements.noteText.sendKeys("This is a test");
	  elements.saveNote.click();
	  FuncFile.waitForTextPresence(driver, elements.noteDescription, "This is a test");
	  String noteDescription = elements.noteDescription.getText();
	  System.out.println(noteDescription);
	  if (noteDescription.equals("This is a test")) {
		  test.log(stepStatus.PASS, "Saving note is valid");
	  }else {
		  test.log(stepStatus.FAIL, "Saving note is not valid");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Saving note is not valid");
	  }
	  
	  /* Step 13 */
	  System.out.println("3.1.3 Trips test Step 13");
	  driver.get(FuncFile.findTripsPagePath(driver));
	  elements.tripMenu.click();
	  List<WebElement> tripMenu5 = elements.tripMenuItems;
	  tripMenu5.get(5).click();
	  elements.saveTripCopy.click();
	  FuncFile.waitForTimeThread(3000);
	  FuncFile.searchClickableElement(driver, elements.tripMenu);
	  String tripName4 = elements.tripPageName.getText();
	  System.out.println("Trip name is " + tripName4);
	  if (tripName4.equals("עותק של Trip to Eilat city")) {
		  test.log(stepStatus.PASS, "Saving trip is valid");
	  }else {
		  test.log(stepStatus.FAIL, "Saving trip is not valid");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  //Assert.fail("Saving trip is not valid");
	  }
	  
	  /* Step 14 */
	  
	  try {
		  System.out.println("3.1.3 Trips test Step 14");
		  driver.get(FuncFile.findTripsPagePath(driver));
		  FuncFile.searchClickableElement(driver, elements.zoomIn);
		  elements.initElements(driver);
		  FuncFile.waitForTimeThread(4000);
		  elements.zoomIn.click();
		  FuncFile.waitForTimeThread(1000);
		  elements.zoomIn.click();
		  FuncFile.waitForTimeThread(1000);
		  elements.zoomOut.click();
		  FuncFile.waitForTimeThread(1000);
		  elements.zoomOut.click();
		  test.log(stepStatus.PASS, "Zoom in out map is valid");
		} catch (Exception e) {
			System.out.println("Error " + e);
			test.log(stepStatus.FAIL, "Zoom in out map is not valid");
			ResultsBuilder.SendTestImage(test, driver, "FAIL", testName, browser);
			//Assert.fail("Zoom in out map is not valid");
		}

	  /* Step 15 */
	  System.out.println("3.1.3 Trips test Step 15");
	  driver.get("https://www.tripadvisor.co.il/Trips");
	  elements.allTripsTab.click();
	  elements.initElements(driver);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  List<WebElement> trips = elements.tripsInCatalog;
	  int tripsNumber = trips.size();
	  System.out.println("Trips array number is " + tripsNumber);
	  if(tripsNumber>=1) {
		  test.log(stepStatus.PASS, "All trips tab present trips catalog");
	  }else {
		  test.log(stepStatus.FAIL, "All trips tab is not valid");
		  ResultsBuilder.SendTestImage(test, driver, "FAIL", testName, browser);
		  //Assert.fail("All trips tab is not valid"); 
	  }
	  
	  /* Step 16 */
	  System.out.println("3.1.3 Trips test Step 16");
	  driver.get("https://www.tripadvisor.co.il/Trips");
	  elements.tripsTab.get(1).click();
	  elements.initElements(driver);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  List<WebElement> trips2 = elements.tripsInCatalog;
	  int tripsNumber2 = trips2.size();
	  System.out.println("Trips array number is " + tripsNumber);
	  if(tripsNumber>=1) {
		  test.log(stepStatus.PASS, "All private trips tab present trips catalog");
	  }else {
		  test.log(stepStatus.FAIL, "All private trips tab is not valid");
		  ResultsBuilder.SendTestImage(test, driver, "FAIL", testName, browser);
		  //Assert.fail("All private trips tab is not valid"); 
	  }

	  /* Step 17 */
	  System.out.println("3.1.3 Trips test Step 17");
	  driver.get("https://www.tripadvisor.co.il/Trips");
	  elements.tripsTab.get(2).click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	  FuncFile.waitForTimeThread(1000);
	  elements.initElements(driver);
	  List<WebElement> trips3 = elements.tripsInCatalog;
	  int tripsNumber3 = trips3.size();
	  System.out.println("Trips array number is " + tripsNumber);
	  if(tripsNumber>=1) {
		  test.log(stepStatus.PASS, "All public trips tab present trips catalog");
	  }else {
		  test.log(stepStatus.FAIL, "All public trips tab is not valid");
		  ResultsBuilder.SendTestImage(test, driver, "FAIL", testName, browser);
		  //Assert.fail("All public trips tab is not valid"); 
	  }
	  
	  /* Step 18 */
	  System.out.println("3.1.3 Trips test Step 18");
	  driver.get("https://www.tripadvisor.co.il/Trips");
	  elements.tripsTab.get(3).click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	  FuncFile.waitForTimeThread(1000);
	  elements.initElements(driver);
	  List<WebElement> trips4 = elements.savedPlaces;
	  int tripsNumber4 = trips4.size();
	  System.out.println("Trips array number is " + tripsNumber);
	  if(tripsNumber>=1) {
		  test.log(stepStatus.PASS, "All saved places tab present trips catalog");
	  }else {
		  test.log(stepStatus.FAIL, "All saved places tab is not valid");
		  ResultsBuilder.SendTestImage(test, driver, "FAIL", testName, browser);
		  //Assert.fail("All saved places tab is not valid"); 
	  }
	  
	  
	  /* Clean tests trip and copy from trips catalog */
	  FuncFile.cleanTrip(driver, 1);
	  FuncFile.cleanTrip(driver, 1);
	
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 4)
  public void TestCase3_1_4(String browser, String path) throws IOException, ParserConfigurationException, SAXException, InterruptedException, AWTException {
	  String testName = "Group3_UsefulnessTest_TestCase3.1.4";
	  String Description = "3.1.4 References";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);

	  /* Step 1 */
	  System.out.println("3.1.4 Trips test Step 1");
	  driver.get(path);
	  FuncFile.waitForTimeThread(3000);
	  elements.initElements(driver);
	  FuncFile.searchClickableElement(driver, elements.hotels);
      String email = FuncFile.importConfigurationsData("email");
      String password = FuncFile.importConfigurationsData("password");
	  elements.initElements(driver);
	  //FuncFile.connectProfile(driver, email, password);
	  elements.referencesPageButton.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  String pageName1 = driver.getCurrentUrl();
	  if (pageName1.equals("https://www.tripadvisor.co.il/UserReview")) {
		  test.log(stepStatus.PASS, "References page is opened"); 
	  }else {
		  test.log(stepStatus.FAIL, "References page is not opened");
		  ResultsBuilder.SendTestImage(test, driver, "FAIL", testName, browser);
		  //Assert.fail("References page is not opened");
	  }

	  /* Step 2 */
	  System.out.println("3.1.4 Trips test Step 2");
	  elements.initElements(driver);
	  elements.referenceSearchInput.sendKeys("אמריקנה");
	  try {
		  elements.initElements(driver);
		  FuncFile.searchClickableElement(driver, elements.referenceSearchMenuItems.get(0));
		  test.log(stepStatus.PASS, "Search results menu opened");
		} catch (Exception e) {
			test.log(stepStatus.FAIL, "Search results menu is not opened");
			ResultsBuilder.SendTestImage(test, driver, "FAIL", testName, browser);
			//Assert.fail("Search results menu is not opened");
			System.out.println("Error " + e);
		}
	  
	  /* Step 3 */
	  System.out.println("3.1.4 Trips test Step 3");
	  elements.referenceSearchMenuItems.get(0).click();
	  Boolean foundText = FuncFile.waitForTextPresence(driver, elements.referenceHeader, "מלון אמריקנה אילת");
	  if (foundText) {
		  test.log(stepStatus.PASS, "Create reference page is opened");
	  	}else {
		  test.log(stepStatus.FAIL, "Create reference page is not opened");
		  ResultsBuilder.SendTestImage(test, driver, "FAIL", testName, browser);
		  //Assert.fail("Create reference page is not opened");
	  }
	  
	  /* Step4 */
	  System.out.println("3.1.4 Trips test Step 4");
	  elements.initElements(driver);
	  elements.sendReference.click();
	  int errorAraySize = elements.referenceFilledError.size();
	  if (errorAraySize == 5) {
		  test.log(stepStatus.PASS, "Reference card text fields is valid");
  	  }else {
		  test.log(stepStatus.FAIL, "Reference card text fields is not valid");
		  ResultsBuilder.SendTestImage(test, driver, "FAIL", testName, browser);
		  //Assert.fail("Reference card text fields is not valid");
	  }
	  
	  /* Step 5 */
	  try {
		  System.out.println("3.1.4 Trips test Step 5");
		  FuncFile.waitForTimeThread(1000);
		  elements.initElements(driver);
		  
		  elements.ReferenceAddImageButton.click();
		  FuncFile.waitForTimeThread(1000);
		  FuncFile.searchClickableElement(driver, elements.ReferenceInnerAddImageButton);
		  elements.ReferenceInnerAddImageButton.click();
		  FuncFile.waitForTimeThread(2000);
		  /* Creating Robot class object to load image */
		  Robot robot = new Robot();
		 
		  /* Copy file path to Clipboard */
		  StringSelection str = new StringSelection("C:\\my files\\Selenium\\bat yam.jpg");
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		 
		  /* Click Control+V and paste */
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_V);
		 
		  /* Release Control+V and paste */
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  robot.keyRelease(KeyEvent.VK_V);
		 
		  /* Click and release enter */
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.keyRelease(KeyEvent.VK_ENTER);
		  
		  FuncFile.waitForTimeThread(3000);
		  elements.initElements(driver);
		  elements.imageCategory.get(1).click();
		  elements.ReferenceLoadImageAgreement.click();
		  elements.ReferenceLoadImageButton.click();
		  boolean foundImage = FuncFile.searchElement(driver, elements.referenceImages.get(0));
		  if (foundImage) {
			  test.log(stepStatus.PASS, "Loading image is valid");
		  	}else {
			  test.log(stepStatus.FAIL, "Loading image is not valid");
			  ResultsBuilder.SendTestImage(test, driver, "FAIL", testName, browser);
			  //Assert.fail("Loading image is not valid");
		  }
		} catch (Exception e) {
			System.out.println("Error " + e);
		}  
	  
  }
  
}
