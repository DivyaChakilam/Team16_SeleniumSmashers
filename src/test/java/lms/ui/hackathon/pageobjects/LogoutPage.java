package lms.ui.hackathon.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import lms.ui.hackathon.utilities.ElementUtil;

public class LogoutPage {
       private WebDriver driver;
      //private ElementUtil util;
        
       private By logoutbutton = By.xpath("//span[normalize-space()='Logout']");

	    public LogoutPage(WebDriver driver) {
		this.driver = driver;
	
		//util = new ElementUtil(this.driver);
		
	}
	
	public void clickLogoutBtn() 
	{
		driver.findElement(logoutbutton).click();
	}
	
}
