package Tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.xml.sax.SAXException;

import Functions.FuncFile;
import HeadClass.HeadClass;

public class createCountriesFile extends HeadClass{
	
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		
		System.out.println("Start creating countries file");
		System.out.println(FuncFile.importConfigurationsData("browser1"));
		System.out.println(FuncFile.importConfigurationsData("path"));
		try {
			/* Open browser for created countries object function from Tripadvisor website */
			/* driver = FuncFile.openBrowser(driver, FuncFile.importConfigurationsData("browser1"), FuncFile.importConfigurationsData("path"));
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
			elements.initElements(driver);
			countries = FuncFile.createCountriesArray(driver);*/
			
			/* Created countries file function from countries objects listArray values 
			   FuncFile.insertCountriesToFile(driver, countries, countriesFilePath);*/
			
			/* Take countries filepath from configuration file and create countries arrayList from excel file*/
			String countriesFilePath = FuncFile.importConfigurationsData("countriesFilePath"); 
			System.out.println("Path is " + countriesFilePath);
			
			List<Country> countries = new ArrayList<Country>();
			File file = new File("C:\\my files\\projectFiles\\saved files\\countriesFile.xlsx");
			FileInputStream fis = new FileInputStream(file);
			System.out.println("here1");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			System.out.println("here4");
			
			/* countries = FuncFile.createCountriesListFromFile(countriesFilePath). property in HeadClass */
			/* For all countries in file open country menu, select country and validate trips translated. See validate all languages in FuncFile */
			
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
		 
	}

	/* Create and print countries array manually for validation */
	public static List<Country> createCountriesArrayList(){
		List<Country> countries = new ArrayList<Country>();
		countries.add(new Country(1,"United States" , "English", "Trips"));
		countries.add(new Country(2,"Canada" , "English", "Trips")); 
		countries.add(new Country(3,"Canada" , "français", "Voyages")); 
		countries.add(new Country(4,"Brasil" , "Portugese", "Viagens"));
		countries.add(new Country(5,"México" , "Mexican", "Viajes"));
		countries.add(new Country(6,"Argentina" , "Spanish", "Viajes"));
		countries.add(new Country(7,"Chile" , "Spanish", "Viajes"));
		countries.add(new Country(8,"Colombia" , "Spanish", "Viajes"));
		countries.add(new Country(9,"Perú" , "Spanish", "Viajes"));
		countries.add(new Country(10,"Venezuela" , "Spanish", "Viajes"));
		countries.add(new Country(11,"United Kingdom" , "English", "Trips"));
		countries.add(new Country(12,"Italia" , "Italian", "Viaggi"));
		countries.add(new Country(13,"España" , "Spanish", "Viajes"));
		countries.add(new Country(14,"Deutschland" , "German", "Reisen"));
		countries.add(new Country(15,"France" , "French", "Voyages"));
		countries.add(new Country(16,"Sverige" , "Swedish ", "Resor"));
		countries.add(new Country(17,"Nederland" , "Dutch", "Reizen"));
		countries.add(new Country(18,"Türkiye" , "Turkish", "Seyahatler"));
		countries.add(new Country(19,"Danmark" , "Denish", "Rejser"));
		countries.add(new Country(20,"Ireland" , "Irish", "Trips"));
		countries.add(new Country(21,"Österreich" , "German", "Reisen"));
		countries.add(new Country(22,"Ελλάδα" , "Greeke", "Ταξίδια"));
		countries.add(new Country(23,"Norge" , "Norwegian", "Reiser"));
		countries.add(new Country(24,"Portugal" , "Spanish", "Viagens"));
		countries.add(new Country(25,"Россия" , "Russian", "Поездки"));
		countries.add(new Country(26,"Schweiz" , "French", "Reisen"));
		countries.add(new Country(27,"Suisse" , "German", "Voyages"));
		countries.add(new Country(28,"Svizzera" , "German", "Viaggi"));
		countries.add(new Country(29,"Belgique" , "French", "Voyages"));
		countries.add(new Country(30,"België" , "French", "Reizen"));
		countries.add(new Country(31,"日本" , "Japanese", "旅リスト"));
		countries.add(new Country(32,"中国" , "Chinese", "旅行"));
		countries.add(new Country(33,"中文国际版" , "Chinese", "旅行"));
		countries.add(new Country(34,"India" , "English", "Trips"));
		countries.add(new Country(35,"Australia" , "English", "Trips"));
		countries.add(new Country(36,"Malaysia" , "English", "Trips"));
		countries.add(new Country(37,"New Zealand" , "English", "Trips"));
		countries.add(new Country(38,"Philippines" , "English", "Trips"));
		countries.add(new Country(39,"Singapore" , "English", "Trips"));
		countries.add(new Country(40,"Indonesia" , "English", "Trip"));
		countries.add(new Country(41,"대한민국" , "Korean", "여행"));
		countries.add(new Country(42,"ไทย" , "Thai", "ทริป"));
		countries.add(new Country(43,"Việt Nam" , "Vietnamese", "Chuyến đi"));
		countries.add(new Country(44,"台灣" , "Taiwanese", "旅程"));
		countries.add(new Country(45,"Hong Kong SAR" , "English", "Trips"));
		countries.add(new Country(46,"香港特別行政區" , "Chinese", "旅程"));
		countries.add(new Country(47,"العربية" , "Arabic", "رحلات"));
		countries.add(new Country(48,"مصر" , "Arabic", "رحلات"));
		countries.add(new Country(49,"South Africa" , "English", "Trips"));
		countries.add(new Country(50,"ישראל" , "English", "טיולים"));
		for(Country ctry : countries) {
			ctry.printCountry();
		}
		return countries;
	}

}
