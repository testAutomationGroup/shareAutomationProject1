package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Elements extends HeadClass{
	
	WebElement Logo = driver.findElement(By.cssSelector("[alt='Tripadvisor']"));
	Elements(WebDriver driver){
		System.out.println("Elements constructor");
		this.driver = driver;
	}
	
}
