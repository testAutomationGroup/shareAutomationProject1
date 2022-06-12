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
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class FuncFile {
	/// issue - how to import value from inner function importConfigurationsData?
		static int pageLoadingTime = 900;
		
		/*open Chrome web browser*/
		public static String importConfigurationsData(String propertyName) throws ParserConfigurationException, SAXException, IOException{
			File fXmlFile = new File("configurations.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile); 
			doc.getDocumentElement().normalize();
			return doc.getElementsByTagName(propertyName).item(0).getTextContent();
		}
		
		public static WebDriver openBrowserChrome(WebDriver driver, String path) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			//waitForElementToPresent(driver, pageLoadingTime, By.cssSelector("[alt='Tripadvisor']"));
			driver.get(path);
			waitForImplicitTime(driver, pageLoadingTime);
			System.out.println("Tab URL and title are " + driver.getCurrentUrl() + "   " + driver.getTitle());
			return driver;
		}
		
		/*Open Firefox browser*/
		public static WebDriver openBrowserFirefox(WebDriver driver, String path) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(path);
			waitForImplicitTime(driver, pageLoadingTime);
			System.out.println("Tab URL and title are " + driver.getCurrentUrl() + "   " + driver.getTitle());
			return driver;
		}
		
		/*Open Microsoft edge browser*/
		public static WebDriver openBrowserEdge(WebDriver driver, String path) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(path);
			waitForImplicitTime(driver, pageLoadingTime);
			System.out.println("Tab URL and title are " + driver.getCurrentUrl() + "   " + driver.getTitle());
			return driver;
		}
		
		/*wait for constant time using Thread.sleep*/
		public static void waitForTimeThread(int millis) throws InterruptedException {
			try {
				Thread.sleep(millis);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		/*wait until page all elements present with time limit using implicit wait*/ 
		public static void waitForImplicitTime(WebDriver driver, int millis) {
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(millis));
		}
		
		/*wait until specific element present with time limit using explicit wait*/
		public static void waitForElementToPresent(WebDriver driver, int millis,  By by) {
			new WebDriverWait(driver, Duration.ofMillis(millis)).until(ExpectedConditions.elementToBeClickable(by));
		}
		
		/*Take a screen shot for the page in test without URL with takeScreenshot*/
		public static void takeScreenImage(WebDriver driver, String path) throws IOException {
			//save date and time for image name
			SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy_HHmmss");
			Date date = new Date(System.currentTimeMillis());
			String dateForImage = formatter.format(date);
			
			TakesScreenshot scrShot = ((TakesScreenshot)driver);
			File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
			System.out.println("Saved image into path " + path + "\\screenImage_" + dateForImage);
			FileUtils.copyFile(scrFile, new File(path + "\\screenImage_" + dateForImage + ".jpg"));
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
		public static void takePageScrollImage(WebDriver driver, String path) throws IOException {
			Screenshot entirePageScreenShot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
			ImageIO.write(entirePageScreenShot.getImage(),"PNG", new File(path));
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
		
		/*Stop stopper*/
		public static double stopStopper(StopWatch stopper) {
			stopper.stop();
			return stopper.getTime()/1000.0;
		}
		
		/*Check if page contains text*/
		public static boolean isTextInPage(WebDriver driver, String text) {
			return driver.getPageSource().contains(text);
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
		
		/*Import data from excel file*/
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
			
}
