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
	
	@FindBy(css = "[autocomplete='current-password'][placeholder='סיסמה']")
	WebElement passwordTripadvisor;
	
	@FindBy(css = "#regSignIn .coreRegPrimaryButton")
	WebElement signInButton;
	
	@FindBy(css = "img[height='100']")
	WebElement profileButton;

	Elements(WebDriver driver){
		System.out.println("Elements constructor");
		this.driver = driver;
	}
	
	void initElements(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
}
