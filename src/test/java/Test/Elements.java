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
	
	@FindBy(css = ".EtzER")
	List<WebElement> searchHotelItems;
	
	@FindBy(css="[href='/Trips']")
	WebElement trips;
	
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
	
	@FindBy(css = "#submit")
	WebElement AccountPageSaveButton;
	
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
	WebElement innerCreateButton;
	
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
	
	Elements(WebDriver driver){
		System.out.println("Elements constructor");
		this.driver = driver;
	}
	
	void initElements(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
}
