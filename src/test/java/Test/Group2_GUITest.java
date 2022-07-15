package Test;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Group2_GUITest extends HeadClass{
  
  ResultsFileBuilder ResultsBuilder = new ResultsFileBuilder(driver);	
  @Parameters({"browser","path"})
  @BeforeClass
  public void beforeGroup2_GUITest(String browser, String path) {
	  System.out.println("Here we start");
	  //Create test report file for report system sanity tests
	  report = ResultsBuilder.GetExtent("Group2_GUITest tests");
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
  public void AfterGroup2_GUITest(String browser) throws InterruptedException {
	  System.out.println("Group2_GUITest ended for browser " + browser);
	  FuncFile.waitForTimeThread(2000);
	  report.flush();
	  //driver.close();
  }
  
  @Parameters({"browser"})
  @Test(enabled = true, priority = 1)
  public void TestCase2_1_1(String browser) throws IOException, InterruptedException {
	  String testName = "Group2_GUITest_TestCase2.1.1";
	  String Description = "2.1.1 Website Logo";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  
	  /* Step 1 */
	  System.out.println("TestCase2.1.1 Step 1");
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
	  System.out.println("TestCase2.1.1 Step 2");
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
	  System.out.println("TestCase2.1.1 Step 3");
	  elements.initElements(driver);
	  FuncFile.waitForTimeThread(400);
	  elements.Logo.click();
	  FuncFile.searchClickableElement(driver, elements.hotels);
	  page = driver.getCurrentUrl();
	  if (page.equals("https://www.tripadvisor.co.il/")) {
		  test.log(stepStatus.PASS, "Trips logo is clickable");
	  }else {
		  test.log(stepStatus.FAIL, "Trips logo is not clickable");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Trips logo is not clickable");
	  }
	
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 2)
  public void TestCase2_1_2_1_1(String browser, String path) throws IOException, ParserConfigurationException, SAXException, InterruptedException {
	  String testName = "Group2_GUITest_TestCase2.1.2.1.1";
	  String Description = "2.1.2.1.1 Profile image update";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  
	  /* Step 1*/
	  System.out.println("TestCase2.1.2.1.1 Step 1");
	  System.out.println(path);
	  driver.get(path);
	  elements.initElements(driver);
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
	  System.out.println("TestCase2.1.2.1.1 Step 2");
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
	  
	  /* Step 3 */
	  System.out.println("TestCase2.1.2.1.1 Step 3");
	  elements.setProfileButton.click();
	  FuncFile.searchClickableElement(driver, elements.setProfileImage);
	  elements.initElements(driver);
	  //elements.setProfileImage.click();
	  elements.setProfileInputs.get(0).sendKeys(" test");
	  elements.saveProfileSettings.click();
	  FuncFile.waitForTimeThread(3000);
	  String profileName = elements.profileName.getText();
	  System.out.println("profileName" + profileName);
	  if (profileName.equals("Elad test")){
		  test.log(stepStatus.PASS, "Profile name updated");
		  elements.initElements(driver);
		  elements.setProfileButton.click();
		  elements.initElements(driver);
		  elements.setProfileInputs.get(0).clear();
		  FuncFile.waitForTimeThread(1000);
		  elements.setProfileInputs.get(0).sendKeys("Elad");
		  elements.saveProfileSettings.click();
		  FuncFile.logOutFromProfile(driver);
		  System.out.println("Here");
	  }else {
		  test.log(stepStatus.FAIL, "Profile name is not updated");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Profile name is not updated");
	  }
	  
	
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 3)
  public void TestCase2_1_2_1_2(String browser, String path) throws IOException, ParserConfigurationException, SAXException, InterruptedException {
	  String testName = "Group2_GUITest_TestCase2.1.2.1.2";
	  String Description = "2.1.2.1.2 Profile details update";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  
	  /* Step 1*/
	  System.out.println("TestCase2.1.2.1.2 Step 1");
	  System.out.println(path);
	  driver.get(path);
	  System.out.println("here1");
	  FuncFile.waitForTimeThread(1000);
	  elements.initElements(driver);
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
	  System.out.println("TestCase2.1.2.1.2 Step 2");
	  driver.get(path);
      String email = FuncFile.importConfigurationsData("email");
      String password = FuncFile.importConfigurationsData("password");
	  FuncFile.connectProfile(driver, email, password);
      
      elements.profileButton.click();
      System.out.println("Button was clicked");
	  
      /* Wait for profile menu presence and click profile page name */
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
	  
	  /* Step 3 */
	  System.out.println("TestCase2.1.2.1.2 Step 3");
	  elements.setProfileMenu.click();
	  elements.initElements(driver);
	  elements.setProfileMenuItems.get(0).click();
	  elements.initElements(driver);
	  boolean foundSetProfileImage = FuncFile.searchClickableElement(driver, elements.setProfileImage);
	  if (foundSetProfileImage) {
		  test.log(stepStatus.PASS, "Set profile card was opened");
		  elements.saveProfileSettings.click();
		  FuncFile.waitForTimeThread(1000);
	  }else {
		  test.log(stepStatus.FAIL, "Set profile card was not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Set profile card was not opened");
	  }

	  /* Step 4 */
	  System.out.println("TestCase2.1.2.1.2 Step 4");
	  elements.setProfileMenu.click();
	  elements.initElements(driver);
	  elements.setProfileMenuItems.get(1).click();
	  elements.initElements(driver);
	  boolean foundLoadImage = FuncFile.searchClickableElement(driver, elements.loadImage);
	  if (foundLoadImage) {
		  test.log(stepStatus.PASS, "Load image card was opened");
		  Actions builder = new Actions(driver);
		  builder.sendKeys(Keys.ESCAPE).perform();
		  FuncFile.waitForTimeThread(1000);
	  }else {
		  test.log(stepStatus.FAIL, "Load image card was not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Load image card was not opened");
	  }
	  
	  /* Step 5 */
	  System.out.println("TestCase2.1.2.1.2 Step 5");
	  elements.initElements(driver);
	  elements.setProfileMenuItems.get(2).click();
	  elements.initElements(driver);
	  boolean foundLoadImage1 = FuncFile.searchClickableElement(driver, elements.loadFrontImage);
	  if (foundLoadImage1) {
		  test.log(stepStatus.PASS, "Load front image card was opened");
		  Actions builder = new Actions(driver);
		  builder.sendKeys(Keys.ESCAPE).perform();
		  
	  }else {
		  test.log(stepStatus.FAIL, "Load front image card was not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Load front image card was not opened");
	  }
	  
	  /* Step 6 */
	  System.out.println("TestCase2.1.2.1.2 Step 6");
	  elements.initElements(driver);
	  elements.setProfileMenuItems.get(3).click();
	  elements.initElements(driver);
	  boolean foundAccountName = FuncFile.searchClickableElement(driver, elements.AccountFirstName);
	  if (foundAccountName) {
		  test.log(stepStatus.PASS, "Account screen was opened");
		  Actions builder = new Actions(driver);
		  builder.sendKeys(Keys.ESCAPE).perform();
		  
	  }else {
		  test.log(stepStatus.FAIL, "Account screen was opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Account screen was not opened");
	  }
	  
	  /* Step 7 */
	  System.out.println("TestCase2.1.2.1.2 Step 7");
	  driver.navigate().back();
	  FuncFile.searchClickableElement(driver, elements.setProfileMenu);
	  elements.setProfileMenu.click();
	  elements.initElements(driver);
	  elements.setProfileMenuItems.get(4).click();
	  elements.initElements(driver);
	  boolean foundAccountMerge = FuncFile.searchClickableElement(driver, elements.AccountGroup);
	  if (foundAccountMerge) {
		  test.log(stepStatus.PASS, "Settings screen, facebook and google settings was opened");
		  Actions builder = new Actions(driver);
		  builder.sendKeys(Keys.ESCAPE).perform();
		  
	  }else {
		  test.log(stepStatus.FAIL, "Settings screen facebook and google settings was not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Settings screen facebook and google settings was not opened");
	  }
	  
	  /* Step 8 */
	  System.out.println("TestCase2.1.2.1.2 Step 8");
	  elements.AccountGroup.click();
	  elements.initElements(driver);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	  elements.initElements(driver);
	  String pageName = driver.getCurrentUrl();
	  if (pageName.equals("https://www.tripadvisor.co.il/AccountMerge")) {
		  test.log(stepStatus.PASS, "Account group screen was opened");
		  Actions builder = new Actions(driver);
		  builder.sendKeys(Keys.ESCAPE).perform();
		  
	  }else {
		  test.log(stepStatus.FAIL, "Account group screen was not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Account group screen was not opened");
	  }
	  
	  /* Step 9 */
	  System.out.println("TestCase2.1.2.1.2 Step 9");
	  driver.navigate().back();
	  driver.navigate().back();
	  FuncFile.searchClickableElement(driver, elements.setProfileMenu);
	  elements.setProfileMenu.click();
	  elements.initElements(driver);
	  elements.setProfileMenuItems.get(5).click();
	  elements.initElements(driver);
	  String pageName1 = driver.getCurrentUrl();
	  if (pageName1.equals("https://www.tripadvisor.co.il/Settings-cs")) {
		  test.log(stepStatus.PASS, "Subscribers emails settings screen was opened");
		  Actions builder = new Actions(driver);
		  builder.sendKeys(Keys.ESCAPE).perform();
		  
	  }else {
		  test.log(stepStatus.FAIL, "Subscribers emails settings screen was not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Subscribers emails settings screen was not opened");
	  }
	  
	  /* Step 10 */
	  System.out.println("TestCase2.1.2.1.2 Step 10");
	  driver.navigate().back();
	  FuncFile.searchClickableElement(driver, elements.setProfileMenu);
	  elements.setProfileMenu.click();
	  elements.initElements(driver);
	  elements.setProfileMenuItems.get(6).click();
	  elements.initElements(driver);
	  String pageName2 = driver.getCurrentUrl();
	  if (pageName2.equals("https://www.tripadvisor.co.il/payment")) {
		  test.log(stepStatus.PASS, "Payment screen was opened");
		  Actions builder = new Actions(driver);
		  builder.sendKeys(Keys.ESCAPE).perform();
		  
	  }else {
		  test.log(stepStatus.FAIL, "Payment screen was not opened");
		  ResultsBuilder.SendTestImage(test,driver, "FAIL", testName, browser);
		  Assert.fail("Payment screen was not opened");
	  }
	  
	  
	
  }
  
  @Parameters({"browser", "path"})
  @Test(enabled = true, priority = 4)
  public void TestCase2_1_2_1_3(String browser, String path) throws IOException, ParserConfigurationException, SAXException, InterruptedException {
	  String testName = "Group2_GUITest_TestCase2.1.2.1.3";
	  String Description = "2.1.2.1.3 Profile statistics and shares";
	  test = report.createTest(testName + "_"+browser, Description);
	  ResultsBuilder.SendTestImage(test,driver, "PASS", testName, browser);
	  
	  /* Step 1*/
	  System.out.println("TestCase2.1.2.1.3 Step 1");
	  System.out.println(path);
	  driver.get(path);
	  elements.initElements(driver);
	  elements.connectButton.click();
	  try {

		System.out.println("step 1");
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
	  
	  /* Step 2 */
	  driver.get(path);
	  System.out.println("TestCase2.1.2.1.3 Step 2");
      String email = FuncFile.importConfigurationsData("email");
      String password = FuncFile.importConfigurationsData("password");
	  FuncFile.connectProfile(driver, email, password);
      
      elements.profileButton.click();
      System.out.println("Button was clicked");
      /* Wait for profile menu presence and click profile page name */
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
	  
	  /* Step 3 */
	  System.out.println("TestCase2.1.2.1.3 Step 3");
	  elements.initElements(driver);
	  boolean found = FuncFile.searchElement(driver, elements.sharesFollowersButtons.get(0));
	  if (found) {
		  test.log(stepStatus.PASS, "Shares and follwers presented");
	  }else {
	  	  test.log(stepStatus.FAIL, "Shares and follwers not presented");
	  	  ResultsBuilder.SendTestImage(test, driver, "PASS", testName, browser);
	  	  Assert.fail("Shares and follwers not presented");
	  	  }
  }
  
}
