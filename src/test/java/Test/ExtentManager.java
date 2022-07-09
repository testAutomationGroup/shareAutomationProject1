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

public class ExtentManager{
	
	public static WebDriver driver;
	//Constractor for report infrustructure class
	public ExtentManager(WebDriver driver){
		System.out.println("In constructor function");
		this.driver = driver;
	}
	public static ExtentReports extent;
	public static ExtentSparkReporter htmlReporter;
	//יצירת תיקיה ששמה הוא התאריך
	static DateFormat df = new SimpleDateFormat("ddMMyy_HHmmss");
	static Date today = Calendar.getInstance().getTime();
	static String reportDate = df.format(today);
	static String reportFolder = "C:\\my files\\reportFile\\" + "TestReport" + reportDate;
	public static String reportPath = reportFolder + "\\TestReport" + reportDate + ".html";
	
	/*Create reports folders and report file*/ 
	public ExtentReports GetExtent(String reportName) {
		System.out.println("In GetExtent function");
		new File(reportFolder).mkdirs();
		if (extent != null) {
			return extent; //avoid creating new instance of html file
			}
		extent = new ExtentReports();
		extent.attachReporter(getHtmlReporter(reportName));
		return extent;
	}
	
	/*HTML file elements configuration*/
	private static ExtentSparkReporter getHtmlReporter(String reportName) {
		htmlReporter = new ExtentSparkReporter(reportPath);
		htmlReporter.config().setTimeStampFormat("dd/MM/yy HH:mm:ss");
		htmlReporter.config().setDocumentTitle ("QA Automation Report"); 
		htmlReporter.config().setReportName(reportName);
		htmlReporter.config().setEncoding("windows-1255"); 
		return htmlReporter ;
	}
	
	public static void addImageFromFile(ExtentTest test, String path) {
		test.addScreenCaptureFromPath("path");
	}
	
	/*Set testResult and save images into report folder*/
	public void ReportTestResult(ExtentTest test, WebDriver driver, String result, String testName, String browser) {
		String imagepath="";
		if (result == "PASS") {
			System.out.println("test pass");
			test.pass("PASS");
			try {
				imagepath = FuncFile.takeScreenImage(driver, reportFolder, "PASS", testName + " "+ browser);
			} catch (IOException e) {
				e.printStackTrace();
			}
			test.pass("PASS",MediaEntityBuilder.createScreenCaptureFromPath(imagepath).build());
		}else if(result == "FAIL") {
			System.out.println("test fail");
			test.fail("FAIL");
			try {
				imagepath = FuncFile.takeScreenImage(driver, reportFolder, "FAIL", testName + " "+ browser);
			} catch (IOException e) {
				e.printStackTrace();
			}
			test.fail("FAIL",MediaEntityBuilder.createScreenCaptureFromPath(imagepath).build());
		}else {
			test.info("Skip Error");
			try {
				imagepath = FuncFile.takeScreenImage(driver, reportFolder, "INFO", testName + " "+ browser);
			} catch (IOException e) {
				e.printStackTrace();
			}
			test.info("Skip Error",MediaEntityBuilder.createScreenCaptureFromPath(imagepath).build());
	    }  
	}
	
}