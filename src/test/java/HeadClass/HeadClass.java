package HeadClass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Elements.Elements;
import Tools.Country;
import Tools.Currency;

//Class for all mutual classes, properties and configuration parameters
public class HeadClass {
	
	public static WebDriver driver;
	//define extent reportFile
	public static ExtentReports report;
	public static ExtentTest test;
	public static Status stepStatus;
	public static Elements elements = new Elements(driver);
	public static List<Country> countries = Tools.createCountriesFile.createCountriesArrayList();
	public static List<Currency> currencies = Tools.createCurrenciesFile.createCurrenciesrrayList();
	//ResultsFileBuilder ResultsBuilder = new ResultsFileBuilder(driver);
		
}
