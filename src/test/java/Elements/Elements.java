package Elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import HeadClass.HeadClass;

public class Elements extends HeadClass{
	

	@FindBy(css="[alt='Tripadvisor']")
	public WebElement Logo;
	
	@FindBy(css="[alt='Tripadvisor']")
	public By byLogo;
	
	@FindBy(css="a.ciCgd")
	public By logoRelativeLink; 
	
	@FindBy(css="[href='/RegistrationController?flow=sign_up_and_save&returnTo=%2F&fullscreen=true&flowOrigin=login&hideNavigation=true&isLithium=true']")
	public WebElement connectButton;
	
	@FindBy(css="[href='/Hotels']")
	public WebElement hotels;
	
	@FindBy(css="button.Wh")
	public WebElement moreButton;
	
	@FindBy(css="#menu-item-0 .biGQs")
	public WebElement createPlaceButton;
	
	@FindBy(css=".RCAPL")
	public List<WebElement> creatPlaceMenuItems;
	
	@FindBy(css=".gWELN button")
	public WebElement creatPlaceContinueButton;
	
	@FindBy(css = "input[name='propertyName']")
	public WebElement placeNameInput;
	
	@FindBy(css = ".CIFNo input")
	public List<WebElement> placeAddressInput;
	
	@FindBy(css = "input[name='addressOne']")
	public WebElement placeAddressBuilding;
	
	@FindBy(css = ".AeLHi .ttuOS")
	public WebElement placeFormInnerContinueButton;
	
	@FindBy(css = ".gWELN .AeLHi")
	public WebElement placeFormInner2ContinueButton;
	
	@FindBy(css = ".RLAnL .Wb")
	public WebElement completePlaceForm;
	
	@FindBy(css = ".RCAPL")
	public List<WebElement> placeCategory;
	
	@FindBy(css = ".QHaGY")
	public List<WebElement> addFoodTypes;
	
	@FindBy(css = ".fpcja")
	public List<WebElement> foodTypes;
	
	@FindBy(css = ".RLAnL .sOtnj")
	public WebElement saveFoodTypes;
	
	@FindBy(css = "[for='disclaimer'] .I")
	public WebElement createPlaceAgrreement;
	
	@FindBy(css = ".RLAnL .AeLHi")
	public WebElement sendPlaceDetailes;
	
	@FindBy(css = ".UZwOE")
	public List<WebElement> placeAdressInpuItems;
	
	@FindBy(css = "main [role='search'] [role='searchbox']")
	public WebElement mainSearchInput;
	
	@FindBy(css = ".result-title")
	public List<WebElement> searchResultsHeadlines;
	
	@FindBy(css = ".search-results-title")
	public List<WebElement> searchResultsImages;
	
	@FindBy(css = ".frame .inner")
	public List<WebElement> ReferenceSearchResultsImages;
	
	@FindBy(css = ".partial_entry")
	public List<WebElement> referenceListContents;
	
	@FindBy(css = ".kaEuY [role='search'] input[role='searchbox']")
	public WebElement hotelsSearchInput;
	
	@FindBy(css = ".kaEuY [role='search'] input[role='searchbox']")
	public WebElement thingsToDoSearchInput;
	
	@FindBy(css = ".EtzER")
	public List<WebElement> searchHotelItems;
	
	@FindBy(css="[href='/Trips']")
	public WebElement trips;
	
	@FindBy(css=".oULUR")
	public WebElement tripsConnectNow;
	
	@FindBy(css= "[title='regcontroller']")
	public WebElement googleIframe;
	
	@FindBy(css = "#googleBtn")
	public WebElement googleButton;
	
	@FindBy(css = "#facebookBtn")
	public WebElement facebookButton;
	
	@FindBy(css = ".regEmailContinue")
	public WebElement tripadvisorButton;
	
	@FindBy(css =".focusClear[type='email']")
	public WebElement emailTripadvisor;
	
	public By emailByTripadvisor = By.cssSelector(".focusClear[type='email']");
	
	@FindBy(css = "[autocomplete='current-password'][placeholder='סיסמה']")
	public WebElement passwordTripadvisor;
	
	@FindBy(css = "#regSignIn .coreRegPrimaryButton")
	public WebElement signInButton;
	
	@FindBy(css = "[href='/Profile/EladAr1']")
	public WebElement profileButton;

	public By profileByButton = By.cssSelector("[href='/Profile/EladAr1']");
	
	public By profileMenu = By.cssSelector("[role='menu']");
	
	public By profileMenuItem = By.cssSelector("ul[role='menu'] li");
	
	@FindBy(css = "#firstname")
	public WebElement AccountFirstName;
	
	@FindBy(css = "#lastname")
	public WebElement AccountFamilyName;
	
	@FindBy(css = ".email")
	public WebElement AccountEmail;
	
	@FindBy(css = "#homeairport")
	public WebElement AccountHomeairportInput;
	
	@FindBy(css = "#street1")
	public WebElement AccountAddress1Input;
	
	@FindBy(css = "#street2")
	public WebElement AccountAddress2Input;
	
	@FindBy(css = "#cityname")
	public WebElement AccountCityInput;
	
	@FindBy(css = "#statename")
	public WebElement AccountStateInput;

	@FindBy(css = "#postalcode")
	public WebElement AccountPostalCodeInput;
	
	@FindBy(css = "#countryid")
	public WebElement AccountCountryIDInput;
	
	
	@FindBy(css = "#countrycode")
	public WebElement AccountCountryPhoneCodeInput;
	
	@FindBy(css = "#phonenumber")
	public WebElement AccountPhonenumberInput;
	
	@FindBy(css = "#submit")
	public WebElement AccountPageSaveButton;
	
	@FindBy(css = "#forgotPass")
	public WebElement ResetPassword;
	
	@FindBy(css = ".sessionSignout")
	public WebElement SignOutSeesions;
	
	@FindBy(css = ".inner .continueSignout")
	public WebElement continueSignOut;
	
	@FindBy(css = ".inner .signoutSuccess h3")
	public WebElement signOutAccountNotification;
	
	@FindBy(css = ".inner .closeSignout")
	public WebElement signOutCloseButton;
	
	@FindBy(css = "[href='/Inbox']")
	public WebElement notifications;
	
	@FindBy(css = "[role='searchbox']")
	public WebElement notificationsPageSearchRow;
	
	@FindBy(css = ".active")
	public WebElement resultsPageActiveTab;
	
	@FindBy(css = "[href='/Inbox?archived=true']")
	public WebElement archiveButton;
	
	@FindBy(css = "[href='/Settings-cs']")
	public WebElement settingsButton;
	
	@FindBy(css = "[href='https://www.tripadvisorsupport.com/hc/he/articles/200613517']")
	public WebElement commonQuestions;
	
	@FindBy(css = ".PHAlC")
	public WebElement createTrip;
	
	@FindBy(css = "[name='tripName']")
	public WebElement tripNameInput;
	
	@FindBy(css = "button.AeLHi")
	public WebElement innerCreateTripButton;
	
	public By tripsCatalog = By.cssSelector(".saAkf");
	
	@FindBy(css = ".saAkf")
	public List<WebElement> tripsInCatalog;
	
	@FindBy(css = ".RhvFy")
	public WebElement tripPageName;
	
	@FindBy(css = "[for='trips_radio_4']")
	public WebElement tripsPrivacyButton;
	
	@FindBy(css = ".MVUuZ")
	public WebElement tripMenu;
	
	@FindBy(css = "ul.MYndQ li")
	public List<WebElement> tripMenuItems;
	
	@FindBy(css = ".primary")
	public WebElement removeButton;
	
	@FindBy(css = ".ui_input_text")
	public WebElement placeSearchInput;
	
	@FindBy(css = ".inocc")
	public List<WebElement> placeSearchItems;
	
	@FindBy(css = "[href='/Hotel_Review-g293980-d308227-Reviews-Americana_Hotel-Eilat_Southern_District.html']")
	public WebElement hotelName;
	
	@FindBy(css = ".page_h1_line1")
	public WebElement eilatHotelsPageHeadline;
	
	@FindBy(css = ".gUFiK[tabindex='0'] .TXuKH")
	public WebElement eilatHotelsCalendarDay;
	
	@FindBy(css = ".oFcdM")
	public WebElement hotelsCalendar1Today;
	
	@FindBy(css = "[aria-disabled='false'][tabindex='0']")
	public WebElement hotelsCalendar2FirstDay;
	
	@FindBy(css = ".UpyrZ")
	public WebElement searchHotelsUpdateButton;
	
	@FindBy(css = ".view_deal")
	public List<WebElement> hotelsViewDeal;
	
	@FindBy(css = ".socialCTA")
	public WebElement shareTripButton;
	
	@FindBy(css = "li.ui_link")
	public List<WebElement> shareMenuItems;
	
	@FindBy(css = "[role='searchbox']")
	public WebElement tripSearchInput;
	
	@FindBy(css = ".JnwVR")
	public WebElement addsTripDates;
	
	@FindBy(css = ".QHIaI")
	public WebElement datesSelect;
	
	@FindBy(css = ".QHIaI")
	public List<WebElement> selectDatesInMenu;
	
	@FindBy(css = ".calendar")
	public List<WebElement> calendar;
	
	@FindBy(css = "[role='gridcell'][tabindex='0']")
	public WebElement clenderDay1ThisMonth;
	
	@FindBy(css = ".primary")
	public WebElement saveDatesButton;
	
	@FindBy(css = ".primary")
	public WebElement tripDates;
	
	@FindBy(css = ".Erzxb .primary")
	public WebElement tripUpdateSaveButton;
	
	@FindBy(css = "[name='description']")
	public WebElement tripDescriptionInput;
	
	@FindBy(css = ".fIrGe ._a")
	public WebElement tripDescription;
	
	@FindBy(css = "#trip_title")
	public WebElement updateTripNameInput;
	
	@FindBy(css = "#trip_url")
	public WebElement addTripLinkInput;
	
	@FindBy(css = ".rmyCe")
	public WebElement addLinkButton;
	
	@FindBy(css = ".rmyCe")
	public WebElement addLinkButton2;
	
	@FindBy(css = "[href='https://www.tripadvisor.co.il/Trips/115851948'] .b")
	public WebElement tripLinkDescription;
	
	@FindBy(css = ".UcrlT")
	public List<WebElement> privacyButtons;
	
	@FindBy(css = ".primary")
	public WebElement saveTripPrivacySettings;
	
	@FindBy(css = ".primary")
	public List<WebElement> continueWithDates;
	
	@FindBy(css = ".bohqm")
	public List<WebElement> tripLikes;
	
	@FindBy(css = "#note_title")
	public WebElement noteHeadline;
	
	@FindBy(css = "[name='body']")
	public WebElement noteText;
	
	@FindBy(css = ".wEfhf [type='submit']")
	public WebElement saveNote;
	
	@FindBy(css = ".cRnyv")
	public WebElement noteDescription;
	
	@FindBy(css = ".primary")
	public WebElement saveTripCopy;
	
	@FindBy(css = "#map_container_column")
	public WebElement mapArea;
	
	@FindBy(css = "[role='button'][tabindex='-1']")
	public WebElement zoomIn;
	
	@FindBy(css = "[role='button'][tabindex='-2']")
	public WebElement zoomOut;
	
	@FindBy(css = ".wyvSS")
	public WebElement allTripsTab;
	
	@FindBy(css = ".BlFsg")
	public List<WebElement> tripsTab;
	
	@FindBy(css = ".KSVvt")
	public List<WebElement> savedPlaces;
	
	@FindBy(css = ".EnLFm")
	public WebElement setProfileButton;
	
	@FindBy(css = ".photo.sBHmh")
	public WebElement setProfileImage;
	
	@FindBy(css = "input.R2")
	public List<WebElement> setProfileInputs;
	
	@FindBy(css = ".Fwwhu")
	public WebElement loadImage;
	
	@FindBy(css = ".Fwwhu")
	public WebElement loadFrontImage;
	
	@FindBy(css = ".primary")
	public WebElement saveProfileSettings;
	
	@FindBy(css = ".brsfY")
	public WebElement profileName;
	
	@FindBy(css = ".NIgFo")
	public WebElement setProfileMenu;
	
	@FindBy(css = "li .ui_link")
	public List<WebElement> setProfileMenuItems;
	
	@FindBy(css = "[href='/AccountMerge']")
	public WebElement AccountGroup;
	
	@FindBy(css = ".rNZKv")
	public List<WebElement> sharesFollowersButtons;
	
	@FindBy(css = "[href='/UserReview']")
	public WebElement referencesPageButton;
	
	@FindBy(css = ".aThUm[type='search']")
	public WebElement referenceSearchInput;
		
	@FindBy(css = ".EtzER")
	public List<WebElement> referenceSearchMenuItems;
	
	@FindBy(css = ".reviewHeader .propertyname")
	public WebElement referenceHeader;
		
	@FindBy(css = ".bubble_40")
	public WebElement referenceRankink;
	
	@FindBy(css = "#ReviewText")
	public WebElement referenceTextArea;
	
	@FindBy(css = "#trip_date_month_year")
	public WebElement referenceWhenVisited;

	@FindBy(css = "[name='trip_date_month_year']")
	public List<WebElement> referenceDatesVisitid;
	
	@FindBy(css = "#qid505")
	public WebElement referenceVisitedWith;
	
	@FindBy(css = ".confirmedBooker.required")
	public List<WebElement> referenceVisitedWithItems;
	
	@FindBy(css = ".checkbox")
	public WebElement referenceAgreement;
	
	@FindBy(css = "#SUBMIT")
	public WebElement sendReference;
	
	@FindBy(css = "fieldset .error")
	public List<WebElement> referenceFilledError;
	
	@FindBy(css = ".uploadButtons .buttonTextDefault")
	public WebElement ReferenceAddImageButton;
	
	@FindBy(css = ".inner .addPhotoBtn")
	public WebElement ReferenceInnerAddImageButton;
	
	@FindBy(css = ".uploadBtn")
	public WebElement ReferenceLoadImageButton;
	
	@FindBy(css = ".file .radioOption")
	public List<WebElement> imageCategory; 
	
	@FindBy(css = "#i-agree")
	public WebElement ReferenceLoadImageAgreement;
	
	@FindBy(css =".photo")
	public List<WebElement> referenceImages; 
	
	@FindBy(css = "[href='/Attractions']")
	public WebElement thingsToDo;

	@FindBy(css =".EtzER")
	public List<WebElement> thingsToDoMenuItems;
	
	@FindBy(css = ".mdkdE")
	public List<WebElement> thingsToDoEilat;
	
	@FindBy(css = "[data-tab-name='מפת נסיעות']")
	public WebElement travelingMap;
	
	@FindBy(css = ".IYPQU")
	public List<WebElement> profileIntroItems;
	
	@FindBy(css = ".internet input")
	public WebElement profileInternetSiteLinkInput;
	
	@FindBy(css = ".BcPve")
	public WebElement profileAttchedInternetLink;
	
	@FindBy(css = "textarea")
	public WebElement profileTextAreaInput;
	
	@FindBy(css = ".PwbCu")
	public WebElement profileTextAreaDiscription;
	
	@FindBy(css = ".zQpMQ")
	public List<WebElement> shareProfileImagesReferences;
	
	@FindBy(css = ".ViJpi")
	public WebElement shareLoadImagesButton;
	
	@FindBy(css = "#media-upload-description-0")
	public WebElement sharedImageAddDescription;
	
	@FindBy(css = ".biGQs input")
	public WebElement sharedImageAddLocation;
	
	@FindBy(css = ".AeLHi .biGQs")
	public WebElement sharedImageSubmit;
	
	@FindBy(css = "[title='בת ים']")
	public WebElement sharedImageHeadLine;
	
	@FindBy(css = "#Settings")
	public WebElement accountSettingMenuButton;

	@FindBy(css = "[href='/Settings-cs']")
	public WebElement accountSettingMenuSubscribers;
	
	@FindBy(css = ".heading")
	public WebElement subscribersSettingHeadline;
	
	@FindBy(css = ".hakMy img")
	public WebElement sharedLoadImage;
	
	@FindBy(css = "button.bMrpo")
	public List<WebElement> currencyLanguageButtons;
	
	@FindBy(css = ".biGQs p")
	public WebElement versionLanguage;
	
	@FindBy(css = "[role='menu'] li")
	public List<WebElement> countries;
	
	@FindBy(css = "#menu-item-USD")
	public WebElement currencyUSD;
	
	@FindBy(css = "#menu-item-ILS")
	public WebElement currencyILS;
	
	@FindBy(css = ".IIbRQ li")
	public List<WebElement> currencies;
	
	@FindBy(css = ".price-wrap .price")
	public List<WebElement>  hotelsPrices;
	
	@FindBy(css = "#menu-item-0")
	public WebElement englishUnitedStates;
	
	@FindBy(css = "#menu-item-49")
	public WebElement hebrewIsrael;
	
	@FindBy(css = "[title='‪Instagram‬']")
	public WebElement instagram;
	
	@FindBy(css = "[title='‪Twitter‬']")
	public WebElement twitter;
	
	@FindBy(css = "[title='‪Facebook‬']")
	public WebElement facebook;

	@FindBy(css = "#menu-item-4")
	public WebElement flights;
	
	@FindBy(css = ".qLWrA button")
	public WebElement searchFlightsButton;
	
	@FindBy(css = "button.primary")
	public WebElement innerSearchFlightsButton;
	
	@FindBy(css = ".Kpztm input")
	public List<WebElement> flightWhereInput;
	
	@FindBy(css = ".KgxGZ button")
	public WebElement viewFlightDeal;
	
	@FindBy(css = ".cVdTY")
	public WebElement viewFlightHeadline;
	
	@FindBy(css = ".pcyWY")
	public List<WebElement> viewInnerFlightDeal;
	
	@FindBy(css = "#menu-item-1")
	public WebElement cruise;
	
	@FindBy(css = ".fb_logo")
	public WebElement facebookLogo;
	
	@FindBy(css = "#menu-item-9")
	public WebElement travelersChoice;
	
	@FindBy(css = "p")
	public List<WebElement> travelersChoiceTextP;
	
	@FindBy(css = "[href='/TravelersChoice-Destinations-g1']")
	public WebElement travelersChoiceImageLink;
	
	@FindBy(css = ".desktop-title-subcontent")
	public WebElement overseasLocation;
	
	@FindBy(css = ".desktop-title-content")
	public WebElement israelLocation;
	
	@FindBy(css = "input.gLFyf")
	public WebElement googleSearchInput;
	
	public Elements(WebDriver driver){
		System.out.println("Elements constructor");
		this.driver = driver;
	}
	
	public void initElements(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
}
