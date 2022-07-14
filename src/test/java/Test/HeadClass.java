package Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

//Class for all mutual classes, properties and configuration parameters
public class HeadClass {
	
	public static WebDriver driver;
	//define extent reportFile
	public static ExtentReports report;
	public static ExtentTest test;
	public static Status stepStatus;
	public static Elements elements = new Elements(driver);
	//ResultsFileBuilder ResultsBuilder = new ResultsFileBuilder(driver);
		
}
