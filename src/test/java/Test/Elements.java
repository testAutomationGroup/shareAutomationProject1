package Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Elements extends HeadClass{
	

	@FindBy(css="[alt='Tripadvisor']")
	WebElement Logo;
	
	@FindBy(css="[alt='Tripadvisor']")
	By byLogo;
	
	@FindBy(css="a.ciCgd")
	By logoRelativeLink; 
	
	@FindBy(css="[href='/RegistrationController?flow=sign_up_and_save&returnTo=%2F&fullscreen=true&flowOrigin=login&hideNavigation=true&isLithium=true']")
	WebElement connectButton;
	
	@FindBy(css="[href='/Hotels']")
	WebElement hotels;
	
	@FindBy(css="button.Wh")
	WebElement moreButton;
	
	@FindBy(css="#menu-item-0 .biGQs")
	WebElement createPlaceButton;
	
	@FindBy(css=".RCAPL")
	List<WebElement> creatPlaceMenuItems;
	
	@FindBy(css=".gWELN button")
	WebElement creatPlaceContinueButton;
	
	@FindBy(css = "input[name='propertyName']")
	WebElement placeNameInput;
	
	@FindBy(css = ".CIFNo input")
	List<WebElement> placeAddressInput;
	
	@FindBy(css = "input[name='addressOne']")
	WebElement placeAddressBuilding;
	
	@FindBy(css = ".AeLHi .ttuOS")
	WebElement placeFormInnerContinueButton;
	
	@FindBy(css = ".gWELN .AeLHi")
	WebElement placeFormInner2ContinueButton;
	
	@FindBy(css = ".RLAnL .Wb")
	WebElement completePlaceForm;
	
	@FindBy(css = ".RCAPL")
	List<WebElement> placeCategory;
	
	@FindBy(css = ".QHaGY")
	List<WebElement> addFoodTypes;
	
	@FindBy(css = ".fpcja")
	List<WebElement> foodTypes;
	
	@FindBy(css = ".RLAnL .sOtnj")
	WebElement saveFoodTypes;
	
	@FindBy(css = "[for='disclaimer'] .I")
	WebElement createPlaceAgrreement;
	
	@FindBy(css = ".RLAnL .AeLHi")
	WebElement sendPlaceDetailes;
	
	@FindBy(css = ".UZwOE")
	List<WebElement> placeAdressInpuItems;
	
	@FindBy(css = "main [role='search'] [role='searchbox']")
	WebElement mainSearchInput;
	
	@FindBy(css = ".result-title")
	List<WebElement> searchResultsHeadlines;
	
	@FindBy(css = ".search-results-title")
	List<WebElement> searchResultsImages;
	
	@FindBy(css = ".frame .inner")
	List<WebElement> ReferenceSearchResultsImages;
	
	@FindBy(css = ".partial_entry")
	List<WebElement> referenceListContents;
	
	@FindBy(css = ".kaEuY [role='search'] input[role='searchbox']")
	WebElement hotelsSearchInput;
	
	@FindBy(css = ".kaEuY [role='search'] input[role='searchbox']")
	WebElement thingsToDoSearchInput;
	
	@FindBy(css = ".EtzER")
	List<WebElement> searchHotelItems;
	
	@FindBy(css="[href='/Trips']")
	WebElement trips;
	
	@FindBy(css=".oULUR")
	WebElement tripsConnectNow;
	
	@FindBy(css= "[title='regcontroller']")
	WebElement googleIframe;
	
	@FindBy(css = "#googleBtn")
	WebElement googleButton;
	
	@FindBy(css = "#facebookBtn")
	WebElement facebookButton;
	
	@FindBy(css = ".regEmailContinue")
	WebElement tripadvisorButton;
	
	@FindBy(css =".focusClear[type='email']")
	WebElement emailTripadvisor;
	
	By emailByTripadvisor = By.cssSelector(".focusClear[type='email']");
	
	@FindBy(css = "[autocomplete='current-password'][placeholder='סיסמה']")
	WebElement passwordTripadvisor;
	
	@FindBy(css = "#regSignIn .coreRegPrimaryButton")
	WebElement signInButton;
	
	@FindBy(css = "[href='/Profile/EladAr1']")
	WebElement profileButton;

	By profileByButton = By.cssSelector("[href='/Profile/EladAr1']");
	
	By profileMenu = By.cssSelector("[role='menu']");
	
	By profileMenuItem = By.cssSelector("ul[role='menu'] li");
	
	@FindBy(css = "#firstname")
	WebElement AccountFirstName;
	
	@FindBy(css = "#lastname")
	WebElement AccountFamilyName;
	
	@FindBy(css = ".email")
	WebElement AccountEmail;
	
	@FindBy(css = "#homeairport")
	WebElement AccountHomeairportInput;
	
	@FindBy(css = "#street1")
	WebElement AccountAddress1Input;
	
	@FindBy(css = "#street2")
	WebElement AccountAddress2Input;
	
	@FindBy(css = "#cityname")
	WebElement AccountCityInput;
	
	@FindBy(css = "#statename")
	WebElement AccountStateInput;

	@FindBy(css = "#postalcode")
	WebElement AccountPostalCodeInput;
	
	@FindBy(css = "#countryid")
	WebElement AccountCountryIDInput;
	
	
	@FindBy(css = "#countrycode")
	WebElement AccountCountryPhoneCodeInput;
	
	@FindBy(css = "#phonenumber")
	WebElement AccountPhonenumberInput;
	
	@FindBy(css = "#submit")
	WebElement AccountPageSaveButton;
	
	@FindBy(css = "#forgotPass")
	WebElement ResetPassword;
	
	@FindBy(css = ".sessionSignout")
	WebElement SignOutSeesions;
	
	@FindBy(css = ".inner .continueSignout")
	WebElement continueSignOut;
	
	@FindBy(css = ".inner .signoutSuccess h3")
	WebElement signOutAccountNotification;
	
	@FindBy(css = ".inner .closeSignout")
	WebElement signOutCloseButton;
	
	@FindBy(css = "[href='/Inbox']")
	WebElement notifications;
	
	@FindBy(css = "[role='searchbox']")
	WebElement notificationsPageSearchRow;
	
	@FindBy(css = ".active")
	WebElement resultsPageActiveTab;
	
	@FindBy(css = "[href='/Inbox?archived=true']")
	WebElement archiveButton;
	
	@FindBy(css = "[href='/Settings-cs']")
	WebElement settingsButton;
	
	@FindBy(css = "[href='https://www.tripadvisorsupport.com/hc/he/articles/200613517']")
	WebElement commonQuestions;
	
	@FindBy(css = ".PHAlC")
	WebElement createTrip;
	
	@FindBy(css = "[name='tripName']")
	WebElement tripNameInput;
	
	@FindBy(css = "button.AeLHi")
	WebElement innerCreateTripButton;
	
	By tripsCatalog = By.cssSelector(".saAkf");
	
	@FindBy(css = ".saAkf")
	List<WebElement> tripsInCatalog;
	
	@FindBy(css = ".RhvFy")
	WebElement tripPageName;
	
	@FindBy(css = "[for='trips_radio_4']")
	WebElement tripsPrivacyButton;
	
	@FindBy(css = ".MVUuZ")
	WebElement tripMenu;
	
	@FindBy(css = "ul.MYndQ li")
	List<WebElement> tripMenuItems;
	
	@FindBy(css = ".primary")
	WebElement removeButton;
	
	@FindBy(css = ".ui_input_text")
	WebElement placeSearchInput;
	
	@FindBy(css = ".inocc")
	List<WebElement> placeSearchItems;
	
	@FindBy(css = "[href='/Hotel_Review-g293980-d308227-Reviews-Americana_Hotel-Eilat_Southern_District.html']")
	WebElement hotelName;
	
	@FindBy(css = ".page_h1_line1")
	WebElement eilatHotelsPageHeadline;
	
	@FindBy(css = ".gUFiK[tabindex='0'] .TXuKH")
	WebElement eilatHotelsCalendarDay;
	
	@FindBy(css = ".oFcdM")
	WebElement hotelsCalendar1Today;
	
	@FindBy(css = "[aria-disabled='false'][tabindex='0']")
	WebElement hotelsCalendar2FirstDay;
	
	@FindBy(css = ".UpyrZ")
	WebElement searchHotelsUpdateButton;
	
	@FindBy(css = ".view_deal")
	List<WebElement> hotelsViewDeal;
	
	@FindBy(css = ".socialCTA")
	WebElement shareTripButton;
	
	@FindBy(css = "li.ui_link")
	List<WebElement> shareMenuItems;
	
	@FindBy(css = "[role='searchbox']")
	WebElement tripSearchInput;
	
	@FindBy(css = ".JnwVR")
	WebElement addsTripDates;
	
	@FindBy(css = ".QHIaI")
	WebElement datesSelect;
	
	@FindBy(css = ".QHIaI")
	List<WebElement> selectDatesInMenu;
	
	@FindBy(css = ".calendar")
	List<WebElement> calendar;
	
	@FindBy(css = "[role='gridcell'][tabindex='0']")
	WebElement clenderDay1ThisMonth;
	
	@FindBy(css = ".primary")
	WebElement saveDatesButton;
	
	@FindBy(css = ".primary")
	WebElement tripDates;
	
	@FindBy(css = ".Erzxb .primary")
	WebElement tripUpdateSaveButton;
	
	@FindBy(css = "[name='description']")
	WebElement tripDescriptionInput;
	
	@FindBy(css = ".fIrGe ._a")
	WebElement tripDescription;
	
	@FindBy(css = "#trip_title")
	WebElement updateTripNameInput;
	
	@FindBy(css = "#trip_url")
	WebElement addTripLinkInput;
	
	@FindBy(css = ".rmyCe")
	WebElement addLinkButton;
	
	@FindBy(css = ".rmyCe")
	WebElement addLinkButton2;
	
	@FindBy(css = "[href='https://www.tripadvisor.co.il/Trips/115851948'] .b")
	WebElement tripLinkDescription;
	
	@FindBy(css = ".UcrlT")
	List<WebElement> privacyButtons;
	
	@FindBy(css = ".primary")
	WebElement saveTripPrivacySettings;
	
	@FindBy(css = ".primary")
	List<WebElement> continueWithDates;
	
	@FindBy(css = ".bohqm")
	List<WebElement> tripLikes;
	
	@FindBy(css = "#note_title")
	WebElement noteHeadline;
	
	@FindBy(css = "[name='body']")
	WebElement noteText;
	
	@FindBy(css = ".wEfhf [type='submit']")
	WebElement saveNote;
	
	@FindBy(css = ".cRnyv")
	WebElement noteDescription;
	
	@FindBy(css = ".primary")
	WebElement saveTripCopy;
	
	@FindBy(css = "#map_container_column")
	WebElement mapArea;
	
	@FindBy(css = "[role='button'][tabindex='-1']")
	WebElement zoomIn;
	
	@FindBy(css = "[role='button'][tabindex='-2']")
	WebElement zoomOut;
	
	@FindBy(css = ".wyvSS")
	WebElement allTripsTab;
	
	@FindBy(css = ".BlFsg")
	List<WebElement> tripsTab;
	
	@FindBy(css = ".KSVvt")
	List<WebElement> savedPlaces;
	
	@FindBy(css = ".EnLFm")
	WebElement setProfileButton;
	
	@FindBy(css = ".photo.sBHmh")
	WebElement setProfileImage;
	
	@FindBy(css = "input.R2")
	List<WebElement> setProfileInputs;
	
	@FindBy(css = ".Fwwhu")
	WebElement loadImage;
	
	@FindBy(css = ".Fwwhu")
	WebElement loadFrontImage;
	
	
	@FindBy(css = ".primary")
	WebElement saveProfileSettings;
	
	@FindBy(css = ".brsfY")
	WebElement profileName;
	
	@FindBy(css = ".NIgFo")
	WebElement setProfileMenu;
	
	@FindBy(css = "li .ui_link")
	List<WebElement> setProfileMenuItems;
	
	@FindBy(css = "[href='/AccountMerge']")
	WebElement AccountGroup;
	
	@FindBy(css = ".rNZKv")
	List<WebElement> sharesFollowersButtons;
	
	@FindBy(css = "[href='/UserReview']")
	WebElement referencesPageButton;
	
	@FindBy(css = ".aThUm[type='search']")
	WebElement referenceSearchInput;
		
	@FindBy(css = ".EtzER")
	List<WebElement> referenceSearchMenuItems;
	
	@FindBy(css = ".reviewHeader .propertyname")
	WebElement referenceHeader;
		
	@FindBy(css = ".bubble_40")
	WebElement referenceRankink;
	
	@FindBy(css = "#ReviewText")
	WebElement referenceTextArea;
	
	@FindBy(css = "#trip_date_month_year")
	WebElement referenceWhenVisited;

	@FindBy(css = "[name='trip_date_month_year']")
	List<WebElement> referenceDatesVisitid;
	
	@FindBy(css = "#qid505")
	WebElement referenceVisitedWith;
	
	@FindBy(css = ".confirmedBooker.required")
	List<WebElement> referenceVisitedWithItems;
	
	@FindBy(css = ".checkbox")
	WebElement referenceAgreement;
	
	@FindBy(css = "#SUBMIT")
	WebElement sendReference;
	
	@FindBy(css = "fieldset .error")
	List<WebElement> referenceFilledError;
	
	@FindBy(css = ".uploadButtons .buttonTextDefault")
	WebElement ReferenceAddImageButton;
	
	@FindBy(css = ".inner .addPhotoBtn")
	WebElement ReferenceInnerAddImageButton;
	
	@FindBy(css = ".uploadBtn")
	WebElement ReferenceLoadImageButton;
	
	@FindBy(css = ".file .radioOption")
	List<WebElement> imageCategory; 
	
	@FindBy(css = "#i-agree")
	WebElement ReferenceLoadImageAgreement;
	
	@FindBy(css =".photo")
	List<WebElement> referenceImages; 
	
	@FindBy(css = "[href='/Attractions']")
	WebElement thingsToDo;

	@FindBy(css =".EtzER")
	List<WebElement> thingsToDoMenuItems;
	
	@FindBy(css = ".mdkdE")
	List<WebElement> thingsToDoEilat;
	
	@FindBy(css = "[data-tab-name='מפת נסיעות']")
	WebElement travelingMap;
	
	@FindBy(css = ".IYPQU")
	List<WebElement> profileIntroItems;
	
	@FindBy(css = ".internet input")
	WebElement profileInternetSiteLinkInput;
	
	@FindBy(css = ".BcPve")
	WebElement profileAttchedInternetLink;
	
	@FindBy(css = "textarea")
	WebElement profileTextAreaInput;
	
	@FindBy(css = ".PwbCu")
	WebElement profileTextAreaDiscription;
	
	@FindBy(css = ".zQpMQ")
	List<WebElement> shareProfileImagesReferences;
	
	@FindBy(css = ".ViJpi")
	WebElement shareLoadImagesButton;
	
	@FindBy(css = "#media-upload-description-0")
	WebElement sharedImageAddDescription;
	
	@FindBy(css = ".biGQs input")
	WebElement sharedImageAddLocation;
	
	@FindBy(css = ".AeLHi .biGQs")
	WebElement sharedImageSubmit;
	
	@FindBy(css = "[title='בת ים']")
	WebElement sharedImageHeadLine;
	
	@FindBy(css = "#Settings")
	WebElement accountSettingMenuButton;

	@FindBy(css = "[href='/Settings-cs']")
	WebElement accountSettingMenuSubscribers;
	
	@FindBy(css = ".heading")
	WebElement subscribersSettingHeadline;
	
	@FindBy(css = ".hakMy img")
	WebElement sharedLoadImage;
	
	@FindBy(css = "button.bMrpo .fOtGX")
	List<WebElement> currencyLanguageButtons;
	
	@FindBy(css = "#menu-item-USD")
	WebElement currencyUSD;
	
	@FindBy(css = "#menu-item-ILS")
	WebElement currencyILS;
	
	@FindBy(css = ".price-wrap .price")
	List<WebElement>  hotelsPrices;
	
	@FindBy(css = "#menu-item-0")
	WebElement englishUnitedStates;
	
	@FindBy(css = "#menu-item-49")
	WebElement hebrewIsrael;
	
	@FindBy(css = "[title='‪Instagram‬']")
	WebElement instagram;
	
	@FindBy(css = "[title='‪Twitter‬']")
	WebElement twitter;
	
	@FindBy(css = "[title='‪Facebook‬']")
	WebElement facebook;

	@FindBy(css = "#menu-item-4")
	WebElement flights;
	
	@FindBy(css = ".qLWrA button")
	WebElement searchFlightsButton;
	
	@FindBy(css = "button.primary")
	WebElement innerSearchFlightsButton;
	
	@FindBy(css = ".Kpztm input")
	List<WebElement> flightWhereInput;
	
	@FindBy(css = ".KgxGZ button")
	WebElement viewFlightDeal;
	
	@FindBy(css = ".cVdTY")
	WebElement viewFlightHeadline;
	
	@FindBy(css = ".pcyWY")
	List<WebElement> viewInnerFlightDeal;
	
	@FindBy(css = "#menu-item-1")
	WebElement cruise;
	
	@FindBy(css = ".fb_logo")
	WebElement facebookLogo;
	
	@FindBy(css = "#menu-item-9")
	WebElement travelersChoice;
	
	@FindBy(css = "p")
	List<WebElement> travelersChoiceTextP;
	
	@FindBy(css = "[href='/TravelersChoice-Destinations-g1']")
	WebElement travelersChoiceImageLink;
	
	Elements(WebDriver driver){
		System.out.println("Elements constructor");
		this.driver = driver;
	}
	
	void initElements(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
}
