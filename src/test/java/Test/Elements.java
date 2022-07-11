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
	
	@FindBy(css="[href='/Hotels']")
	WebElement hotels;
	
	@FindBy(css="[href='/Trips']")
	WebElement trips;

	Elements(WebDriver driver){
		System.out.println("Elements constructor");
		this.driver = driver;
	}
	
	void initElements(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
}
