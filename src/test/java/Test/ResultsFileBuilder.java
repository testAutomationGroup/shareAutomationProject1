package Test;
/*
import java.awt.AWTException
import java.io.File
import java.io.IOException
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date*/

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ResultsFileBuilder extends HeadClass {

	//Constructor for report infrastructure class
	public ResultsFileBuilder(WebDriver driver){
		System.out.println("ResultsFileBuilder constructor");
		this.driver = driver;
	}
	
	public static ExtentReports extent;
	public static ExtentSparkReporter htmlReporter;
	//Create folder with todays date name
	static DateFormat df = new SimpleDateFormat("ddMMyy_HHmmss");
	static Date today = Calendar.getInstance().getTime();
	static String ResultsFileDate = df.format(today);
	static String ResultsFolder = "C:\\my files\\ResultsFile" + "\\" + "TestResults_" + ResultsFileDate;
	public static String ResultsPath = ResultsFolder + "\\TestResults_" + ResultsFileDate + ".html";
	
	/*Create reports folders and report file*/ 
	public ExtentReports GetExtent(String ResultsFileName) {
		System.out.println("In GetExtent function");
		new File(ResultsFolder).mkdirs();
		if (extent != null) {
			return extent; //avoid creating new instance of html file
			}
		extent = new ExtentReports();
		extent.attachReporter(getHtmlReporter(ResultsFileName));
		return extent;
	}
	
	/*HTML file elements configuration*/
	private static ExtentSparkReporter getHtmlReporter(String ResultsFileName) {
		ResultsPath = ResultsFolder + "\\TestResults_" + ResultsFileName + ResultsFileDate + ".html";
		htmlReporter = new ExtentSparkReporter(ResultsPath);
		htmlReporter.config().setTimeStampFormat("dd/MM/yy HH:mm:ss");
		htmlReporter.config().setDocumentTitle ("Tests Results"); 
		htmlReporter.config().setReportName(ResultsFileName);
		//htmlReporter.config().setEncoding("windows-1255"); 
		return htmlReporter ;
	}
	
	public static void addImageFromFile(ExtentTest test, String path) {
		test.addScreenCaptureFromPath("path");
	}
	
	/*Define testResult and save images into report folder*/
	public void SendTestResult(ExtentTest test, WebDriver driver, String result, String testName, String browser) {
		String imagepath="";
		if (result == "PASS") {
			
			try {
				imagepath = FuncFile.takeScreenImage(driver, ResultsFolder, "PASS", testName + " " + browser);
				System.out.println("Test passed. Saved into file: " + imagepath);
			} catch (IOException e) {
				System.out.println("Image not saved " + e.getMessage());
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("Test failed. Saved into file:"+ imagepath);
			}
			test.pass("PASS",MediaEntityBuilder.createScreenCaptureFromPath(imagepath).build());
			
		}else if(result == "FAIL") {
			
			try {
				imagepath = FuncFile.takeScreenImage(driver, ResultsFolder, "FAIL", testName + " "+ browser);
				System.out.println("Test failed. Saved into file:"+ imagepath);
			} catch (IOException e) {
				System.out.println("Image not saved " + e.getMessage());
				e.printStackTrace();
			}
			test.fail("FAIL",MediaEntityBuilder.createScreenCaptureFromPath(imagepath).build());
			
		}
	}
	
}