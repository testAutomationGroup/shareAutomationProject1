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

public class createCurrenciesFile extends HeadClass {
	
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		
		System.out.println("Start creating countries file");
		System.out.println(FuncFile.importConfigurationsData("browser1"));
		System.out.println(FuncFile.importConfigurationsData("path"));
		try {
			/* Open browser for created currencies object function from Tripadvisor website */
			/*driver = FuncFile.openBrowser(driver, FuncFile.importConfigurationsData("browser1"), FuncFile.importConfigurationsData("path"));
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
			elements.initElements(driver);
			List<Currency> currencies = FuncFile.createCurrencyArrayFromSite(driver);*/
			
			/* Created currencies file function from currencies objects listArray values 
			   FuncFile.insertCurrenciesToFile(driver, currencies, currenciesFilePath);*/
			
			/* Take currencies filepath from configuration file and create currencies arrayList from excel file*/
			String currenciesFilePath = FuncFile.importConfigurationsData("currenciesFilePath"); 
			System.out.println("Path is " + currenciesFilePath);
						
			/* List<Currency> currencies = FuncFile.createCurrenciesListFromFile(currenciesFilePath); property in HeadClass  */
			
			/* For all currencies in file open currency menu, select currency and validate sign. See validate all currencies in FuncFile */
			
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
		 
	}

	/* Create and print countries array manually for validation */
	public static List<Currency> createCurrenciesrrayList(){
		List<Currency> currencies = new ArrayList<Currency>();
		currencies.add(new Currency(0,"  דולר אמריקני"," $"));
		currencies.add(new Currency(1,"  פאונד בריטי"," £"));
		currencies.add(new Currency(2,"  אירו"," €"));
		currencies.add(new Currency(3,"  דולר קנדי"," CA$"));
		currencies.add(new Currency(4,"  פרנק שוויצרי"," CHF"));
		currencies.add(new Currency(5,"  דולר אוסטרלי"," A$"));
		currencies.add(new Currency(6,"  ין יפני"," ¥"));
		currencies.add(new Currency(7,"  יואן סיני"," CN¥"));
		currencies.add(new Currency(8,"  רופיה הודית"," ₹"));
		currencies.add(new Currency(9,"  ריאל ברזילאי"," R$"));
		currencies.add(new Currency(10,"  דולר הונג קונג"," HK$"));
		currencies.add(new Currency(11,"  רובל רוסי"," RUB"));
		currencies.add(new Currency(12,"  קרונה שוודית"," SEK"));
		currencies.add(new Currency(13,"  לירה טורקית"," TRY"));
		currencies.add(new Currency(14,"  קרונה דנית"," DKK"));
		currencies.add(new Currency(15,"  פסו מקסיקני"," MX$"));
		currencies.add(new Currency(16,"  דולר טיוואני חדש"," NT$"));
		currencies.add(new Currency(17,"  קרונה נורווגי"," NOK"));
		currencies.add(new Currency(18,"  זלוטי פולני"," PLN"));
		currencies.add(new Currency(19,"  דירהם איחוד האמירויות הערביות"," AED"));
		currencies.add(new Currency(20,"  אפגני אפגניסטני"," AFN"));
		currencies.add(new Currency(21,"  לק אלבני"," ALL"));
		currencies.add(new Currency(22,"  דראם ארמני"," AMD"));
		currencies.add(new Currency(23,"  גילדר האנטילים ההולנדיים"," ANG"));
		currencies.add(new Currency(24,"  קוואנזה אנגולי"," AOA"));
		currencies.add(new Currency(25,"  פסו ארגנטינאי"," ARS"));
		currencies.add(new Currency(26,"  גילדר ארובי"," AWG"));
		currencies.add(new Currency(27,"  מאנט אזרביג'אני"," AZN"));
		currencies.add(new Currency(28,"  מארק סחיר בוסניה והרצגובינה"," BAM"));
		currencies.add(new Currency(29,"  דולר ברבדוס"," BBD"));
		currencies.add(new Currency(30,"  טאקה בנגלדשי"," BDT"));
		currencies.add(new Currency(31,"  לב בולגרי"," BGN"));
		currencies.add(new Currency(32,"  דינר בחרייני"," BHD"));
		currencies.add(new Currency(33,"  פרנק בורונדי"," BIF"));
		currencies.add(new Currency(34,"  דולר ברמודי"," BMD"));
		currencies.add(new Currency(35,"  דולר ברוניי"," BND"));
		currencies.add(new Currency(36,"  בוליביאנו בוליביאני"," BOB"));
		currencies.add(new Currency(37,"  דולר איי בהאמה"," BSD"));
		currencies.add(new Currency(38,"  נגולטרום בהוטני"," BTN"));
		currencies.add(new Currency(39,"  פולה בוטסואני"," BWP"));
		currencies.add(new Currency(40,"  דולר בליזי"," BZD"));
		currencies.add(new Currency(41,"  פרנק קונגולזי"," CDF"));
		currencies.add(new Currency(42,"  פסו צ'יליאני"," CLP"));
		currencies.add(new Currency(43,"  פסו קולומביאני"," COP"));
		currencies.add(new Currency(44,"  קולון קוסטה ריקני"," CRC"));
		currencies.add(new Currency(45,"  אסקודו כף ורדה"," CVE"));
		currencies.add(new Currency(46,"  קרונה צ'כית"," CZK"));
		currencies.add(new Currency(47,"  פרנק ג'יבוטי"," DJF"));
		currencies.add(new Currency(48,"  פסו דומיניקני"," DOP"));
		currencies.add(new Currency(49,"  דינר אלג'ירי"," DZD"));
		currencies.add(new Currency(50,"  לירה מצרית"," EGP"));
		currencies.add(new Currency(51,"  נאקפה אריתריאי"," ERN"));
		currencies.add(new Currency(52,"  ביר אתיופי"," ETB"));
		currencies.add(new Currency(53,"  דולר פיג'י"," FJD"));
		currencies.add(new Currency(54,"  פאונד איי פוקלנד"," FKP"));
		currencies.add(new Currency(55,"  לארי גרוזיני"," GEL"));
		currencies.add(new Currency(56,"  סדי גאני"," GHS"));
		currencies.add(new Currency(57,"  פאונד גיברלטרי"," GIP"));
		currencies.add(new Currency(58,"  דלסי גמבי"," GMD"));
		currencies.add(new Currency(59,"  פרנק גינאה"," GNF"));
		currencies.add(new Currency(60,"  קצאל גווטאמלי"," GTQ"));
		currencies.add(new Currency(61,"  דולר גיאני"," GYD"));
		currencies.add(new Currency(62,"  למפירה הונדורס"," HNL"));
		currencies.add(new Currency(63,"  קונה קרואטיה"," HRK"));
		currencies.add(new Currency(64,"  גורד האיטי"," HTG"));
		currencies.add(new Currency(65,"  פורינט הונגרי"," HUF"));
		currencies.add(new Currency(66,"  רופיה אינדונזית"," IDR"));
		currencies.add(new Currency(67,"  שקל חדש"," ₪"));
		currencies.add(new Currency(68,"  דינר עירקי"," IQD"));
		currencies.add(new Currency(69,"  ריאל איראני"," IRR"));
		currencies.add(new Currency(70,"  קרונה איסלנדי"," ISK"));
		currencies.add(new Currency(71,"  דולר ג'מייקני"," JMD"));
		currencies.add(new Currency(72,"  דינר ירדני"," JOD"));
		currencies.add(new Currency(73,"  שילינג קניה"," KES"));
		currencies.add(new Currency(74,"  סון קירגיזסטני"," KGS"));
		currencies.add(new Currency(75,"  ריאל קמבודי"," KHR"));
		currencies.add(new Currency(76,"  פרנק קומורו"," KMF"));
		currencies.add(new Currency(77,"  וון דרום קוריאני"," ₩"));
		currencies.add(new Currency(78,"  דינר כוויתי"," KWD"));
		currencies.add(new Currency(79,"  דולר איי קיימן"," KYD"));
		currencies.add(new Currency(80,"  טנגה קזחסטאני"," KZT"));
		currencies.add(new Currency(81,"  קיפ לאו"," LAK"));
		currencies.add(new Currency(82,"  פאונד לבנוני"," LBP"));
		currencies.add(new Currency(83,"  רופיה סרי לנקה"," LKR"));
		currencies.add(new Currency(84,"  דולר ליברי"," LRD"));
		currencies.add(new Currency(85,"  דינר לובי"," LYD"));
		currencies.add(new Currency(86,"  דירהם מרוקאי"," MAD"));
		currencies.add(new Currency(87,"  לאו מולדובני"," MDL"));
		currencies.add(new Currency(88,"  אריארי מלגשי"," MGA"));
		currencies.add(new Currency(89,"  דנאר מקדוני"," MKD"));
		currencies.add(new Currency(90,"  טוגרוג מונגולי"," MNT"));
		currencies.add(new Currency(91,"  פאטאקה מקאו"," MOP"));
		currencies.add(new Currency(92,"  אוגווייה מאוריטני"," MRO"));
		currencies.add(new Currency(93,"  רופיה מאוריציוס"," MUR"));
		currencies.add(new Currency(94,"  רופיה מלדיבית"," MVR"));
		currencies.add(new Currency(95,"  קוואצ'ה מלאווי"," MWK"));
		currencies.add(new Currency(96,"  רינגיט מלזי"," MYR"));
		currencies.add(new Currency(97,"  מטיקל מוזמביקי"," MZN"));
		currencies.add(new Currency(98,"  דולר נמיבי"," NAD"));
		currencies.add(new Currency(99,"  נאירה ניגרי"," NGN"));
		currencies.add(new Currency(100,"  קורדובה אורו ניקרגואי"," NIO"));
		currencies.add(new Currency(101,"  רופיה נפאלי"," NPR"));
		currencies.add(new Currency(102,"  דולר ניו זילנד"," NZ$"));
		currencies.add(new Currency(103,"  ריאל עומני"," OMR"));
		currencies.add(new Currency(104,"  בלבואה פנמי"," PAB"));
		currencies.add(new Currency(105,"  סול חדש פרואני"," PEN"));
		currencies.add(new Currency(106,"  קינה פפואה גינאה החדשה"," PGK"));
		currencies.add(new Currency(107,"  פסו פיליפיני"," PHP"));
		currencies.add(new Currency(108,"  רופיה פקיסטני"," PKR"));
		currencies.add(new Currency(109,"  גואני פרגוואי"," PYG"));
		currencies.add(new Currency(110,"  ריאל קטארי"," QAR"));
		currencies.add(new Currency(111,"  לאו חדש רומניה"," RON"));
		currencies.add(new Currency(112,"  דינר סרבי"," RSD"));
		currencies.add(new Currency(113,"  פרנק רואנדי"," RWF"));
		currencies.add(new Currency(114,"  ריאל סעודי"," SAR"));
		currencies.add(new Currency(115,"  דולר איי שלמה"," SBD"));
		currencies.add(new Currency(116,"  רופיה סיישלית"," SCR"));
		currencies.add(new Currency(117,"  דולר סינגפורי"," SGD"));
		currencies.add(new Currency(118,"  פאונד סנט הלנה"," SHP"));
		currencies.add(new Currency(119,"  ליאונה סיירה ליאוני"," SLL"));
		currencies.add(new Currency(120,"  שילינג סומלי"," SOS"));
		currencies.add(new Currency(121,"  דולר סורינאמי"," SRD"));
		currencies.add(new Currency(122,"  דוברה סאו טומה ופרינסיפה"," STD"));
		currencies.add(new Currency(123,"  בהט תאילנדי"," ฿"));
		currencies.add(new Currency(124,"  סומוני טג'יקיסטני"," TJS"));
		currencies.add(new Currency(125,"  מאנט טורקמניסטני"," TMT"));
		currencies.add(new Currency(126,"  דינר טוניסאי"," TND"));
		currencies.add(new Currency(127,"  פאנגה טונגה"," TOP"));
		currencies.add(new Currency(128,"  דולר טרינידד וטובגו"," TTD"));
		currencies.add(new Currency(129,"  שילינג טנזני"," TZS"));
		currencies.add(new Currency(130,"  הריבניה אוקראיני"," UAH"));
		currencies.add(new Currency(131,"  שילינג אוגנדי"," UGX"));
		currencies.add(new Currency(132,"  פסו אורוגוואי"," UYU"));
		currencies.add(new Currency(133,"  סום אוזבקי"," UZS"));
		currencies.add(new Currency(134,"  דונג וייטנאמי"," ₫"));
		currencies.add(new Currency(135,"  ואטו ונאוטו"," VUV"));
		currencies.add(new Currency(136,"  טלה סמואי"," WST"));
		currencies.add(new Currency(137,"  פרנק CFA מרכז אפריקאי"," FCFA"));
		currencies.add(new Currency(138,"  דולר האיים הקריביים המזרחיים"," EC$"));
		currencies.add(new Currency(139,"  פרנק CFA מערב אפריקאי"," F CFA"));
		currencies.add(new Currency(140,"  פרנק CFP"," CFPF"));
		currencies.add(new Currency(141,"  ריאל תימני"," YER"));
		currencies.add(new Currency(142,"  ראנד דרום אפריקה"," ZAR"));
		currencies.add(new Currency(143,"  וון צפון קוריאני"," KPW"));
		currencies.add(new Currency(144,"  קיאט בורמזי"," MMK"));
		currencies.add(new Currency(145,"  פאונד סודני"," SDG"));
		currencies.add(new Currency(146,"  פאונד סורי"," SYP"));
		currencies.add(new Currency(147,"  רובל בלרוסי"," BYN"));

		for(Currency currency : currencies) {
			currency.printCurrency();
		}
		return currencies;
	}

}
