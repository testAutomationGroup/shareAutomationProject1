package Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

//Class for all mutual classes, properties and configuration parameters
public class HeadClass {
	
	public static WebDriver driver;
	//define extent reportFile
	public static ExtentReports extent;
	public static ExtentTest test;
	//ResultsFileBuilder ResultsBuilder = new ResultsFileBuilder(driver);
		
}
