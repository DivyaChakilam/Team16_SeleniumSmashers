package lms.ui.hackathon.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lms.ui.hackathon.configs.CommonConfigs;
import lms.ui.hackathon.configs.ConfigurationManager;
import lms.ui.hackathon.utilities.ElementUtil;


public class LoginPage {
	private WebDriver driver;
	private ElementUtil util;
	
	@FindBy(xpath="//img[@class='images']") WebElement loginPageImage; 
	@FindBy(xpath="(//img[@class='images'])[1]") WebElement Loginpageimageframe;
	@FindBy(xpath="//p[normalize-space()='Please login to LMS application']") WebElement LoginHeadingText;
	
	@FindBy(xpath="//mat-card[@class='mat-card mat-focus-indicator']") WebElement loginFieldsPosition ;
	@FindBy(xpath="//div[@class='mat-form-field-infix ng-tns-c78-0']") WebElement userfieldLabel;
	@FindBy(xpath="//div[@class='mat-form-field-infix ng-tns-c78-1']") WebElement passwfieldLabel;
	
	@FindBy(xpath="//button[@id='login']")  WebElement loginbutton;
	@FindBy(xpath="//span[@class='mat-button-wrapper']")  WebElement loginbtnLabel;

	@FindBy(xpath="//input[@id='username']") WebElement Username;
	@FindBy(xpath="//input[@id='password']") WebElement Password;
	
	@FindBy (xpath="//mat-error[@id='mat-error-0']") WebElement errorMessage1;
	@FindBy (xpath="//mat-error[@id='mat-error-1']") WebElement errorMessage2;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(this.driver);
	}
	
	/*
	 * public void getloginUrl() { //driver.get(CommonConfigs.url); }
	 */
	
	public String getPageTitle() {
		return util.getPageTitle();
		//return driver.getTitle();
	}	
	/*	public String getLoginHeadingText() {
			return driver.findElement(LoginHeadingText).getText().trim();
		}
		public boolean userNameFieldExist() {
			return driver.findElement(Username).isDisplayed();
		}

		public boolean passwordFieldExist() {
			return driver.findElement(Password).isDisplayed();
		}

		public boolean usernameLabelExist() {
			return driver.findElement(userfieldLabel).isDisplayed();
		}

		public String getusernameLabelText() {
			return driver.findElement(userfieldLabel).getText().trim();
		}

		public boolean LoginHeadingTextFieldExist() {
			return driver.findElement(LoginHeadingText).isDisplayed();
		}

		public boolean passwordLabelFieldExist() {
			return driver.findElement(passwfieldLabel).isDisplayed();
		}

		public String getpasswordLabelText() {
			return driver.findElement(passwfieldLabel).getText().trim();
		}
		public boolean loginButtonExists() {
			return driver.findElement(loginbutton).isDisplayed();
		}

		public String getloginBtnLabelText() {
			return driver.findElement(loginbtnLabel).getText().trim();
		} */
}
