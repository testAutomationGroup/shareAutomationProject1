package Functions;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v100.emulation.Emulation;
import org.openqa.selenium.devtools.v100.log.Log;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import HeadClass.HeadClass;
import Tools.Country;
import Tools.Currency;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class FuncFile extends HeadClass{
	/// issue - how to import value from inner function import ConfigurationsData?
		static int pageLoadingTime = 19000;
		
		/*open Chrome web browser*/
		public static String importConfigurationsData(String propertyName) throws ParserConfigurationException, IOException, SAXException{
			File fXmlFile = new File("configurations.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile); 
			doc.getDocumentElement().normalize();
			return doc.getElementsByTagName(propertyName).item(0).getTextContent();
		}
		
		public static WebDriver openBrowser(WebDriver driver, String browserName, String path) {
			if (browserName.equals("Chrome")){
				/*WebDriverManager.chromedriver().setup();*/
				/* Define chrome driver path manually for chrome improved beta version 104 */ 
				System.setProperty("webdriver.chrome.driver", "C:\\my files\\Selenium\\chromeDriver104\\chromedriver.exe");
				
				ChromeOptions options = new ChromeOptions(); 
				/* Continue when the is password message in browser */
				options.addArguments("--start-maximized");
				options.addArguments("--disable-web-security");
				options.addArguments("--no-proxy-server");

				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				options.setExperimentalOption("prefs", prefs);
				/* Continue when there is not secured message in browser*/
				options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
				/* Add chrome 104 beta improved version menually */
				options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe");
				driver = new ChromeDriver(options); 
				
			}else if (browserName.equals("Firefox")){
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();				
			}else if (browserName.equals("Edge")){
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			driver.manage().window().maximize();
			driver.get(path);
			/* Wait for Logo element presence */
			WebElement result = new WebDriverWait(driver, Duration.ofMillis(pageLoadingTime))
					.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[alt='Tripadvisor']")));
			
			System.out.println("Open browser " + browserName);
			return driver;
		}
		/* List<String> excludeSwitches = new ArrayList<>();
		excludeSwitches.add("enable-automation");
		options.setExperimentalOption("excludeSwitches", excludeSwitches);
		options.setExperimentalOption("useAutomationExtention", false);
		options.addArguments("--disable-infobars");*/
		//System.out.println("Tab URL and title are " + driver.getCurrentUrl() + "   " + driver.getTitle());
		
		/*Wait for constant time using Thread.sleep*/
		public static void waitForTimeThread(int millis) throws InterruptedException {
			try {
				Thread.sleep(millis);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		/*Wait until page all elements present with time limit using implicit wait*/ 
		public static void waitForImplicitTime(WebDriver driver, int millis) {
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(millis));
		}
		
		/*Wait until specific element present with time limit using explicit wait*/
		public static void waitForElementToPresent(WebDriver driver, int millis,  By by) {
			WebElement result = new WebDriverWait(driver, Duration.ofMillis(millis)).until(ExpectedConditions.presenceOfElementLocated(by));
		}
		
		/*Wait for element to be refreshed and clickable until 4 seconds */
		public static WebElement waitForElementToBeRefreshedAndClickable(WebDriver driver, WebElement element) {
			return new WebDriverWait(driver, Duration.ofMillis(4000))
					.until(ExpectedConditions.elementToBeClickable(element));
		}
		
		/* Wait for site address presence in 5 seconds*/
		public static boolean waitForSitePath(WebDriver driver, String expectedPath) {
			String pathNow = driver.getCurrentUrl();
			StopWatch stopper = new StopWatch();
			stopper.start();
			double timeNow = 0.0;
			
			while(timeNow < 5000) {
				pathNow = driver.getCurrentUrl();
				if (pathNow.equals(expectedPath)) {
					System.out.println(pathNow);
					return true;
				}
				timeNow = stopper.getTime();
			}
			stopper.stop();
			return false;
		}
		
		/* Wait for site address presence in 5 seconds that contains text*/
		public static boolean waitForSitePathContainsText(WebDriver driver, String expectedPath) {
			String pathNow = driver.getCurrentUrl();
			StopWatch stopper = new StopWatch();
			stopper.start();
			double timeNow = 0.0;
			while(timeNow < 5000) {
				pathNow = driver.getCurrentUrl();
				if (pathNow.contains(expectedPath)) {
					System.out.println(pathNow);
					return true;
				}
				timeNow = stopper.getTime();
			}
			stopper.stop();
			return false;
		}
		
		/* Highlight text */
		static public void highlightText(WebElement elementContent) {
			Actions builder = new Actions(driver);
		    builder.moveToElement(elementContent, 0, 0).clickAndHold().moveToElement(elementContent, elementContent.getSize().getWidth()/2, elementContent.getSize().getHeight()/2).release().build().perform();
		}
		
		/*Find whether element is clickable*/
		public static boolean isRelativeElementClickable(WebDriver driver, By relativeLink, WebElement element) {
			
			try {
				driver.findElement(RelativeLocator.with(relativeLink).above(element));
				System.out.println("Element is clickable");
				return true;
			} catch (Exception e) {
				System.out.println("Element is not clickable ");
				return false;
			}
			
		}
		
		/* Search element in the page with by locator*/
		public static boolean searchByElement(WebDriver driver, By byLocator) {
			
			try {
				elements.initElements(driver);
				driver.findElement(byLocator);
				System.out.println("Element was found in page");
				return true;
			} catch (Exception e) {
				System.out.println("Element not found with error " + e);
				return false;
			}
		}
		
		/* Search element in the page */
		public static boolean searchElement(WebDriver driver, WebElement element) {
			
			try {
				elements.initElements(driver);
				element.getTagName();
				System.out.println("Element was found in page");
				return true;
			} catch (Exception e) {
				System.out.println("Element not found with error " + e);
				return false;
			}
		}
		
		/* Search clickable element in the page */
		public static boolean searchClickableElement(WebDriver driver, WebElement element) {
			
			try {
				elements.initElements(driver);
				WebElement found = new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.elementToBeClickable(element));
				System.out.println("Element was found in page");
				return true;
			} catch (Exception e) {
				System.out.println("Element not found with error " + e);
				return false;
			}
		}
		
		/* Search if page contains text*/
		public static boolean isTextInPage(WebDriver driver, String text) {
			return driver.getPageSource().contains(text);
		}
					
		/* Connect to existing profile */
		public static void connectProfile(WebDriver driver, String email, String password) throws InterruptedException {
			  elements.connectButton.click();
			  elements.initElements(driver);
			  FuncFile.waitForTimeThread(1000);
			  driver.switchTo().frame(elements.googleIframe);
	          driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
			  elements.tripadvisorButton.click();
	          System.out.println("here3 " + email + " " + password);
	          elements.initElements(driver);
	          driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	          WebElement foundEmailRow = new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.presenceOfElementLocated(elements.emailByTripadvisor));
	          elements.emailTripadvisor.sendKeys(email);
	          elements.passwordTripadvisor.sendKeys(password);
	          /* Validating that email and password exist and print their values */
	          FuncFile.isSendKeys(elements.emailTripadvisor, "Email");
	          FuncFile.isSendKeys(elements.passwordTripadvisor, "Password");
	          FuncFile.waitForTimeThread(1000);
	          driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	          elements.signInButton.click();
	          
	          /* Wait for signIn process and click profile button */
	          System.out.println("Wait for signIn process");
	          driver.switchTo().defaultContent();
	          System.out.println(driver.getCurrentUrl());
	          elements.initElements(driver);   
	          FuncFile.searchByElement(driver, elements.profileByButton);
		}
		
		/* Log out from profile */
		public static void logOutFromProfile(WebDriver driver) throws InterruptedException {
			  driver.get("https://www.tripadvisor.co.il/");
		      elements.profileButton.click();
		      System.out.println("Button was clicked for log out");
		      /* Wait for profile menu presence and click profile page name */
		      driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		      WebElement menu = new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.presenceOfElementLocated(elements.profileMenu));
			  List<WebElement> menuItems = driver.findElements(elements.profileMenuItem);
			  WebElement logOutProfile = menuItems.get(2);
			  System.out.println("menu line is " + logOutProfile.getText());
			  logOutProfile.click();
			  FuncFile.waitForTimeThread(1000);
		}
		
		/* Select specific trip */
		public static WebElement selectTrip(WebDriver driver, int tripNumber) throws InterruptedException {
			driver.get("https://www.tripadvisor.co.il/Trips");
			FuncFile.waitForTimeThread(3000);
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
			elements.initElements(driver);
			List<WebElement> trips = driver.findElements(elements.tripsCatalog);
			return trips.get(tripNumber-1);
		}
		
		/* Clean trip and trips copy from catalog */
		public static void cleanTrip(WebDriver driver, int tripNumber) throws InterruptedException {
			driver.get("https://www.tripadvisor.co.il/Trips");
			WebElement trip = FuncFile.selectTrip(driver, tripNumber);
			trip.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
			elements.initElements(driver);
			elements.tripMenu.click();
			List<WebElement> tripMenu = elements.tripMenuItems;
			tripMenu.get(6).click();
			elements.removeButton.click();
		}
		
		/* Clean trip and trips copy from catalog */
		public static void cleanTripWithoutLink(WebDriver driver, int tripNumber) throws InterruptedException {
			driver.get("https://www.tripadvisor.co.il/Trips");
			WebElement trip = FuncFile.selectTrip(driver, tripNumber);
			trip.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
			elements.initElements(driver);
			elements.tripMenu.click();
			List<WebElement> tripMenu = elements.tripMenuItems;
			tripMenu.get(5).click();
			elements.removeButton.click();
		}
		
		/* Find page path for the created trip */
		static public String findTripsPagePath(WebDriver driver) {
			driver.get("https://www.tripadvisor.co.il");
			elements.trips.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
			elements.initElements(driver);
			elements.tripsInCatalog.get(0).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
			return driver.getCurrentUrl();
		}
		
		/* Wait until sendkeys inserted */
		static public Boolean waitForSendKeys(WebDriver driver, WebElement element, String value) {
			try {
				Boolean foundString = new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.attributeToBe(element, "value", value));
				return foundString;
			} catch (Exception e) {
				System.out.println("Send keys string wa not found  " + e);
				return false;
			}
		}
		
		/* Wait until text presented in element */
		static public Boolean waitForTextPresence(WebDriver driver, WebElement element, String value) {
	       return new WebDriverWait(driver, Duration.ofMillis(4000)).until(ExpectedConditions.textToBePresentInElement(element, value));
		}
		
		/* Test that Internet is connected */
		static public boolean isConnectedInternet() {
			try {
		         URL url = new URL("http://www.google.com");
		         URLConnection connection = url.openConnection();
		         connection.connect();
		         System.out.println("Internet is connected");
		    	  return true;
		      } catch (MalformedURLException e) {
		         System.out.println("Internet is not connected");
		    	  return false;
		      } catch (IOException e) {
		          System.out.println("Internet is not connected");
		    	  return false;
		      }
		}
		
						
		/*Take a screen shot for the page in test without URL with takeScreenshot*/
		public static String takeScreenImage(WebDriver driver, String path, String text, String testName) throws IOException {
			//save date and time for image name
			SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy_HHmmss.SSS");
			Date date = new Date(System.currentTimeMillis());
			String dateForImage = formatter.format(date);
			
			TakesScreenshot scrShot = ((TakesScreenshot)driver);
			File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
			//System.out.println("Saved image into path " + path + "\\" + testName + "_"+ dateForImage + "_" + text);
			String imagepath = path + "\\" + testName + "_"+ dateForImage + "_" + text+ ".jpg";
			FileUtils.copyFile(scrFile, new File(imagepath));
			return imagepath;
		}
		
		/*Take screen image like print screen for whatever is shown on screen with createScreenCapture*/
		public static void takePrintScreen(String path) throws IOException, AWTException {
			//save date and time for image name
			SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy_HHmmss");
			Date date = new Date(System.currentTimeMillis());
			String dateForImage = formatter.format(date);
					
			Robot robot = new Robot();
			BufferedImage PrintScreen = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(PrintScreen, "JPG", new File(path + "\\screenImage_" + dateForImage + ".jpg"));
		}
		
		/*Take full page image including scrolling with AShot*/
		public static String takePageScrollImage(WebDriver driver, String path, String text, String testName) throws IOException {
			SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy_HHmmss");
			Date date = new Date(System.currentTimeMillis());
			String dateForImage = formatter.format(date);
			
			System.out.println("Saved image into path " + path + "\\" + testName + "_"+ dateForImage + "_" + text);
			String imagepath = path + "\\" + testName + "_"+ dateForImage + "_" + text+ ".PNG";
			
			Screenshot entirePageScreenShot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
			ImageIO.write(entirePageScreenShot.getImage(),"PNG", new File(imagepath));
			return imagepath;
		}
		/*Take specific element photo with getScreenShot function*/
		public static void takeSpesificElementImage(WebElement Element, String path) throws IOException {
			File image = Element.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(image, new File(path));
		}
		
		/*Take specific elements image with AShot*/
		public static void takeSpesificElementImageAShot(WebDriver driver, WebElement Element, String path) throws IOException {
			Screenshot screenshot = new AShot().takeScreenshot(driver, Element);
			ImageIO.write(screenshot.getImage(),"PNG", new File(path));
		}
		
		/*Take a video with ATUTestRecorder without sound for quality  video.start()/stop()*/
		public static void takeVideo(String path) throws ATUTestRecorderException {
			ATUTestRecorder video = new ATUTestRecorder(path,"TestVideo-",false);
			video.start();
		}
		/*Start stopper*/
		public static StopWatch startStopper() {
			StopWatch stopper = new StopWatch();
			stopper.start();
			return stopper;
		}
		
		/* Stop stopper*/
		public static double stopStopper(StopWatch stopper) {
			stopper.stop();
			return stopper.getTime()/1000.0;
		}
		
		/*Move to tab number #*/
		public static void selectTab(WebDriver driver, int tabNumber) {
			List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(tabNumber));
		}
		
		/*Click on element with input image using sikuli*/
		public static void clickOnImage(String path) throws FindFailed {
			Screen scrn = new Screen();
			scrn.click(path);
		}
		
		/*Find element with input image using siluli*/
		public static boolean isImageOnPage(String path) {
			Screen scrn = new Screen();
			boolean result = false;
			if (scrn.exists(path)!=null) {
				result = true;
			}
			return result;
		}
		
		/* Finds if input row has text from sendkeys function */
		public static boolean isSendKeys(WebElement inputElement, String inputName) {
			if (inputElement.getAttribute("value")!="") {
	        	  System.out.println(inputName + " value is " + inputElement.getAttribute("value"));
	        	  return true;
	          }else {
	        	  System.out.println(inputName + " is missing");
	        	  return false;
	          }
		}
		
		/* Save browser log into array list */
		public static List<String> saveBrowserConsoleLog(WebDriver driver, String browserName){
			List<String> consoleLog = new ArrayList<String>();
			if (browserName.equals("Chrome")){
				DevTools tools = ((ChromeDriver)driver).getDevTools();
				tools.createSession();
				tools.send(Log.enable());
				tools.addListener(Log.entryAdded(), entry->{
					consoleLog.add("Log: " + entry.getText());
					consoleLog.add("Level: " + entry.getLevel());
				});
			}
			return consoleLog;
		}
		
		/* Validates whether the website language is presented in specific language. Text Element is tested */
		public static boolean validateLanguage(WebDriver driver, List<Country> countries , int countryNumber) {
			String expectedTranslation = countries.get(countryNumber).tripsTranslated;
			String textFromSite = elements.trips.getText();
			String countryName = countries.get(countryNumber).countryName;
			String countryLanguage = countries.get(countryNumber).countryLanguage;
			System.out.println("Expected translated trips for country number " + countryNumber + " with name " + countryName + " with language " + countryLanguage + " is " + expectedTranslation);
			return textFromSite.equals(expectedTranslation); /*"טיולים"*/
		}
		
		/* Validate all languages transation */
		public static boolean validateAllLanguages(WebDriver driver, List<Country> countries) throws InterruptedException {

			boolean validateLanguages = true;
			boolean validateThisLanguage = true;
			try {
				elements.currencyLanguageButtons.get(1).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
				elements.initElements(driver);
				int size = elements.countries.size();
				elements.currencyLanguageButtons.get(1).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
				elements.initElements(driver);
				System.out.println("Size is " + size);
				
				for(int i = 0; i<size; i++) {
						/* Click country button to select country langauge. In china where button is not clickable navigate back to open menu( Country 32 中国  旅行) */
						if (i==31) {
							System.out.println("Country china menu is not clickable");
							continue;
						}
						if(i==13) {
							System.out.println("Alert window in Germany web site. Continue validate");
							continue;
						}
						elements.currencyLanguageButtons.get(1).click();
						driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
						elements.initElements(driver);
						FuncFile.searchClickableElement(driver, elements.countries.get(i));
						FuncFile.waitForTimeThread(1000);
						/* Click selected country and validate */
						elements.countries.get(i).click();
						driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
						elements.initElements(driver);
						FuncFile.searchClickableElement(driver, elements.trips);
						FuncFile.waitForTimeThread(1000);
						validateThisLanguage = FuncFile.validateLanguage(driver, countries, i);
						if(!validateThisLanguage) {
							validateLanguages = false;
							System.out.println("Transaltion for country " + countries.get(i).countryNumber + countries.get(i).countryName + " is not valid");
						}else {
							System.out.println("Country language " + countries.get(i).countryNumber + " is valid");
						}
						driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
						elements.initElements(driver);
					}	
			} catch (Exception e) {
				System.out.println("Error " + e);
			}
			return validateLanguages;
		}
		
		/* Create countries object ArrayList from filepath */
		public static List<Country> createCountriesListFromFile(String filePath) throws IOException{
			System.out.println("here1");
			List<Country> countries = new ArrayList<Country>();
			System.out.println("here2");
			FileInputStream fileinsputstream = new FileInputStream("C:\\my files\\projectFiles\\saved files\\countriesFile.xlsx");
			System.out.println("here3");
			try {
				XSSFWorkbook workbook = new XSSFWorkbook(fileinsputstream);
				System.out.println("here4");
				XSSFSheet sheet = workbook.getSheet("Countries Languages");
				int firstRow = sheet.getFirstRowNum();
				int lastRow = sheet.getLastRowNum();
				int lastCell = 4;
				for(int i = firstRow; i <= lastRow; i++) {
					Row row = sheet.getRow(i);
					if (row!=null) {
						lastCell = row.getLastCellNum();
						Country country = new Country();
						for(int k=0;k < lastCell; k++) {
							Cell cell = row.getCell(i);
							if (cell!=null) {
								if (k==0) {
									country.countryNumber = (int) cell.getNumericCellValue();
								}
								if(k==1) {
									country.countryName = cell.getStringCellValue();
								}
								if(k==2) {
									country.countryLanguage = cell.getStringCellValue();
								}
								if(k==3) {
									country.tripsTranslated = cell.getStringCellValue();
								}
							}
							
						}
						countries.add(country);
					}
				}
			} catch (Exception e) {
				System.out.println("Error " + e);
			}
			return countries;
		}
		
		/* Insert all countries information into excel file */
		public static void insertCountriesToFile(WebDriver driver, List<Country> countries, String filePath) throws FileNotFoundException {
			try {
				
				int size = countries.size();
				int rowNumber = 0;
				int cellNumber = 0;
				File countryFile = new File(filePath);
				FileInputStream inputStream = new FileInputStream(countryFile);
				XSSFWorkbook workbook = new XSSFWorkbook();
				/* Open existing countriesFile from saved path */
				XSSFSheet sheet = workbook.createSheet("Countries Languages");
				
				System.out.println("Start insert countries languages into file");
				
				/* Insert listArray objects */
				for(Country ctry : countries) {
					Row row = sheet.createRow(rowNumber++);
					if (row==null) {
						row = sheet.createRow(rowNumber);
					}
					Cell cell1 = row.createCell(0);
					cell1.setCellValue(ctry.countryNumber);//Integer(ctry.countryNumber)
					Cell cell2 = row.createCell(1);
					cell2.setCellValue(ctry.countryName);//String(ctry.countryName)
					Cell cell3 = row.createCell(2);
					cell3.setCellValue(ctry.countryLanguage);//String()
					Cell cell4 = row.createCell(3);
					cell4.setCellValue(ctry.tripsTranslated);//String(ctry.tripsTranslated)
				}
				
				/* Save and close file */
				try(FileOutputStream outputstream = new FileOutputStream(countryFile)) {
					System.out.println("File been created");
					workbook.write(outputstream);
					//workbook.setSheetName(0, "Countries languages");
					//workbook.close();
					outputstream.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				
			} catch (Exception e) {
				System.out.println("Error " + e);
			}
			

		}
		
		public static void writeCountry(Country country, Row row) {
			Cell cell = row.createCell(1);
			cell.setCellValue(country.countryNumber);
			cell = row.createCell(2);
			cell.setCellValue(country.countryName);
			cell = row.createCell(3);
			cell.setCellValue(country.countryLanguage);
			cell = row.createCell(4);
			cell.setCellValue(country.tripsTranslated);
		}
		
		/* Create countries objects array from site*/
		public static List<Country> createCountriesArrayFromSite (WebDriver driver) throws InterruptedException{

			System.out.println("Start create countries objects array ");
			driver.get("https://www.tripadvisor.co.il/");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
			elements.initElements(driver);
			List<Country> countries = new ArrayList<Country>();
			try {
				System.out.println("here1");
				elements.currencyLanguageButtons.get(1).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
				elements.initElements(driver);
				int size = elements.countries.size();
				elements.currencyLanguageButtons.get(1).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
				elements.initElements(driver);
				System.out.println("Size is " + size);
				for(int i = 47; i < size; i++) {	
					Country country = new Country();
					country.countryNumber = i+1;
					/* Click country button to select country langauge. In china where button is not clickable navigate back to open menu( Country 32 中国  旅行) */
					if (country.countryNumber==33) {
						System.out.println("Country 33");
						elements.initElements(driver);
						driver.navigate().back();
						driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
						elements.initElements(driver);
					}
					if(country.countryNumber==14) {
						continue;
					}
					elements.currencyLanguageButtons.get(1).click();
					FuncFile.searchClickableElement(driver, elements.countries.get(i));
					//FuncFile.waitForTimeThread(400);
					driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
					elements.initElements(driver);
					/* Click selected country, create object and add */
					country.countryName = elements.countries.get(i).getText();
					elements.countries.get(i).click();
					FuncFile.searchClickableElement(driver, elements.trips);
					//FuncFile.waitForTimeThread(400);
					driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
					elements.initElements(driver);
					/* Print version language text when presented */
					try {
						System.out.println(country.countryNumber + " " + elements.versionLanguage.getText());
					} catch (Exception e) {
						System.out.println("VersionLanguage not found");
					}
					country.countryLanguage = "";
					country.tripsTranslated = elements.trips.getText();
					countries.add(country);
					country.printCountry();
				}	
			} catch (Exception e) {
				System.out.println("Error " + e);
			}

			return countries;
		}
	
		/*Add data into existing excel file*/
		public static void addFileData1(String filePath, String value, int rowNumber, int cellNumber) throws IOException, EncryptedDocumentException, InvalidFormatException {
				
				FileInputStream inputstream = new FileInputStream(new File(filePath));
				System.out.println("before workbook");
				XSSFWorkbook workbook = null;
				try {
					workbook = (XSSFWorkbook) WorkbookFactory.create(inputstream);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.getMessage();
					e.printStackTrace();
				}
				System.out.println("Here1");
				org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
				Row row = sheet.getRow(rowNumber);
				if (row==null) {
					row = sheet.createRow(rowNumber);
				}
				org.apache.poi.ss.usermodel.Cell cell = row.getCell(cellNumber);
				if (cell==null) {
					cell = row.createCell(cellNumber);
				}
				cell.setCellValue(value);
				
				FileOutputStream outputstream = new FileOutputStream(filePath);
				try {
					workbook.write(outputstream);
					//workbook.setSheetName(0, "names");
					workbook.close();
					outputstream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		} 
		
		/* Create currencies objects array from site*/
		public static List<Currency> createCurrencyArrayFromSite (WebDriver driver) throws InterruptedException{

			System.out.println("Start create currencies objects array ");
			driver.get("https://www.tripadvisor.co.il/");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
			elements.initElements(driver);
			List<Currency> currencies = new ArrayList<Currency>();
			try {
				System.out.println("CreateCurrencyArrayFromSite here1");
				elements.currencyLanguageButtons.get(0).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
				FuncFile.searchClickableElement(driver, elements.currencies.get(1));
				elements.initElements(driver);
				int size = elements.currencies.size();
				System.out.println("Size is " + size);
				for(int i = 0; i < size; i++) {	
					Currency currency = new Currency();
					currency.currencyNumber = i;
					/* Click currency button to select */
					driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
					elements.initElements(driver);
					/* Click selected currency, create object and add */
					String[] currencyLine = elements.currencies.get(i).getText().split(" ", 2);
					currency.currencyName = currencyLine[1];
					currency.currencySign =  currencyLine[0];
					currencies.add(currency);
					currency.printCurrency();
				}	
			} catch (Exception e) {
				System.out.println("Error " + e);
			}

			return currencies;
		}
		
		/* Insert all currencies information into excel file */
		public static void insertCurrenciesToFile(WebDriver driver, List<Currency> currencies, String filePath) throws FileNotFoundException {
			try {
				
				int size = countries.size();
				int rowNumber = 0;
				int cellNumber = 0;
				File countryFile = new File(filePath);
				FileInputStream inputStream = new FileInputStream(countryFile);
				XSSFWorkbook workbook = new XSSFWorkbook();
				/* Open existing countriesFile from saved path */
				XSSFSheet sheet = workbook.createSheet("Currencies signs");		
				System.out.println("Start insert currencies signs into file");
				
				/* Insert listArray objects */
				for(Currency curr : currencies) {
					Row row = sheet.createRow(rowNumber++);
					if (row==null) {
						row = sheet.createRow(rowNumber);
					}
					Cell cell1 = row.createCell(0);
					cell1.setCellValue(curr.currencyNumber);
					Cell cell2 = row.createCell(1);
					cell2.setCellValue(curr.currencyName);
					Cell cell3 = row.createCell(2);
					cell3.setCellValue(curr.currencySign);
				}
				
				/* Save and close file */
				try(FileOutputStream outputstream = new FileOutputStream(countryFile)) {
					System.out.println("File been created");
					workbook.write(outputstream);
					//workbook.setSheetName(0, "Countries languages");
					//workbook.close();
					outputstream.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				
			} catch (Exception e) {
				System.out.println("Error " + e);
			}
		}
		
		/* Create currencies object ArrayList from filepath */
		public static List<Currency> createCurrenciesListFromFile(String filePath) throws IOException{
			System.out.println("here1");
			List<Currency> currencies = new ArrayList<Currency>();
			System.out.println("here2");
			FileInputStream fileinsputstream = new FileInputStream("C:\\my files\\projectFiles\\saved files\\currenciesFile.xlsx");
			System.out.println("here3");
			try {
				XSSFWorkbook workbook = new XSSFWorkbook(fileinsputstream);
				System.out.println("here4");
				XSSFSheet sheet = workbook.getSheet("Countries Languages");
				int firstRow = sheet.getFirstRowNum();
				int lastRow = sheet.getLastRowNum();
				int lastCell = 3;
				for(int i = firstRow; i <= lastRow; i++) {
					Row row = sheet.getRow(i);
					if (row!=null) {
						lastCell = row.getLastCellNum();
						Currency currency = new Currency();
						for(int k=0;k < lastCell; k++) {
							Cell cell = row.getCell(i);
							if (cell!=null) {
								if (k==0) {
									currency.currencyNumber = (int) cell.getNumericCellValue();
								}
								if(k==1) {
									currency.currencyName = cell.getStringCellValue();
								}
								if(k==2) {
									currency.currencySign = cell.getStringCellValue();
								}
							}
							
						}
						currencies.add(currency);
					}
				}
			} catch (Exception e) {
				System.out.println("Error " + e);
			}
			return currencies;
		}
		
		/* Validates whether the website currency is presented. Text sign is searched in page */
		public static boolean validateCurrency(WebDriver driver, List<Currency> currencies , int currencyNumber) {
			String expectedCurrency = currencies.get(currencyNumber).currencySign.trim();
			String currencyName = currencies.get(currencyNumber).currencyName;
			System.out.println("Expected currency for currency number " + currencyNumber + " and name " + currencyName + " is " + expectedCurrency);
			return driver.getPageSource().contains(expectedCurrency); /*"₪"*/
		}
		
		/* Validate all currencies signs */
		public static boolean validateAllcurrencies(WebDriver driver, List<Currency> currencies) throws InterruptedException {
			boolean validateCurrencies = true;
			boolean validateThisCurrency = true;
			elements.currencyLanguageButtons.get(0).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
			elements.initElements(driver);
			int size = elements.currencies.size();
			elements.currencyLanguageButtons.get(0).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
			elements.initElements(driver);
			System.out.println("Size is " + size);
			
			for(int i = 0; i<size; i++) {
					/* Click currency button to select from menu */
					
					elements.currencyLanguageButtons.get(0).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
					elements.initElements(driver);
					FuncFile.searchClickableElement(driver, elements.currencies.get(i));
					//FuncFile.waitForTimeThread(1000);
					/* Click selected currency and validate */
					elements.currencies.get(i).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
					elements.initElements(driver);
					FuncFile.searchClickableElement(driver, elements.trips);
					FuncFile.waitForTimeThread(1000);
					validateThisCurrency = FuncFile.validateCurrency(driver, currencies, i);
					if(!validateThisCurrency) {
						validateCurrencies = false;
						System.out.println("Currency sign " + currencies.get(i).currencyNumber + currencies.get(i).currencyName + " is not valid");
					}else {
						System.out.println("Currency sign " + currencies.get(i).currencyName + " is valid");
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
					elements.initElements(driver);
				}	
			return validateCurrencies;
		}
		
		/* Set geolocation via development tools */
		public static void setLocation(String city) {
			DevTools tools = ((ChromeDriver)driver).getDevTools();
			tools.createSession();
			/* latitude, longtitude, accuracy */
			if(city.equals("San Francisco")) {
				tools.send((Emulation.setGeolocationOverride(Optional.of(37.774929), Optional.of(-122.419416), Optional.of(100))));
				System.out.println("Location is set to Sun Fransisco");
			}
			if(city.equals("Holon")) {
				tools.send((Emulation.setGeolocationOverride(Optional.of(32.0167), Optional.of(34.7667), Optional.of(100))));
				System.out.println("Location is set to Holon");
			}
		}
		
		/* Find my google location */
		public static String findMyLocation(WebDriver driver) throws InterruptedException {
			System.out.println("Find my location function started");
			String myLocation = "";
			driver.get("https://www.google.co.il/");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
			elements.initElements(driver);
			FuncFile.waitForTimeThread(1000);
			elements.googleSearchInput.sendKeys("My location");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
			elements.initElements(driver);
			elements.googleSearchInput.sendKeys(Keys.RETURN);
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
			elements.initElements(driver);
			
			try {
				myLocation = elements.overseasLocation.getText().split(",", 2)[0];
				System.out.println("My location is set to " + myLocation);
				return myLocation;
			} catch (Exception e) {
				myLocation = elements.israelLocation.getText();
				System.out.println("My location in Israel is " + myLocation);
				return myLocation;
			}
		}	
		
		/* Set window size to mobile device screen size with Dev Tools device mode */
		public static void setScreenSize(WebDriver driver, String deviceName) {
			DevTools tools = ((ChromeDriver)driver).getDevTools();
			tools.createSession();
			int width = 828;
			int height = 1792;
			int pixelRatio = 100;
			int previewScale = 3;
			if (deviceName.equals("iPhone11")){
				width = 828/previewScale;
				height = 1792/previewScale;
				pixelRatio = 100;
				System.out.println("Device is set for " + deviceName);
			}
			if (deviceName.equals("A5_2017")){
				width = 1080/3;
				height = 1920/3;
				pixelRatio = 100;
				System.out.println("Device is set for " + deviceName);
			}
			boolean mobile = true;
			try {
				tools.send(Emulation.setDeviceMetricsOverride(width, height, pixelRatio, mobile, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
			} catch (Exception e) {
				System.out.println("Error " + e);
			}
			
		}
}
