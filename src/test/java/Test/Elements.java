package Test;

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
	
	Elements(WebDriver driver){
		System.out.println("Elements constructor");
		this.driver = driver;
	}
	
	void initElements(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
}
