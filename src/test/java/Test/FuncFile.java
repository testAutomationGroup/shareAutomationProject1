package Test;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

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
		/*Create excel file*/
	/*	public static String createFile(String folder) throws IOException {
			SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy_HHmmss"); 
			Date date = new Date(System.currentTimeMillis());
			String fileName = "testFile_" + formatter.format(date);
			String path = folder + "\\" + fileName + ".xlsx";
			System.out.println("Path is " + path);
			
			try {
				System.out.println("Path is " + path);
				try (XSSFWorkbook workbook = new XSSFWorkbook()) {
					XSSFSheet sheet = workbook.createSheet("Java Books");
					
					Row row = sheet.createRow(0);
					Cell cell = row.createCell(0);
					cell.setCellValue(1);
					try(FileOutputStream outputStream = new FileOutputStream(new File(path))){
						System.out.println("Excel File has been created successfully."); 
						workbook.write(outputStream);
						outputStream.close();
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
				}
			  	
			} catch (Exception e) {
			
				System.out.println("Error" + e.getMessage());
			}
			return path; 
			
			
		}*/
		
		/*Read data from excel file*/
		/*Add data into existing excel file*/
		/*public static void addFileData(String filePath, String value, int rowNumber, int cellNumber) throws IOException {
				
				FileInputStream inputstream = new FileInputStream(filePath);
				System.out.println("before workbook");
				XSSFWorkbook workbook = null;
				try {
					workbook = new XSSFWorkbook(inputstream);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.getMessage();
					e.printStackTrace();
				}
				System.out.println("after workbook");
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
				
		}*/
		/*Delete data from existing excel file*/
		/*Create test case report excel file*/
		/* Open a file*//*
			try {
				///String path = FuncFile.createFile(testExcelFilesPath);
				String filePath =  "C:\\my files\\testExcelFiles\\testFile1.xlsx";
				///addFileData1(filePath,"בדיקה 1 בדיקה בדיקה",0,0);
				System.out.println("Here1 " + filePath);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}*/
		
		/*Add data into existing excel file*/
		/*public static void addFileData1(String filePath, String value, int rowNumber, int cellNumber) throws IOException {
				
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
				System.out.println("after workbook");
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
				
		} */
			
}
