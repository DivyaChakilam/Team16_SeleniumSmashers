package lms.ui.hackathon.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import lms.ui.hackathon.utilities.ElementUtil;
import numpy.seleniumsmasher.lms.constants.AppConstants;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil util;
	

	private By loginPageImage = By.xpath("//img[@class='images']"); 
	private By Loginpageimageframe = By.xpath("//img[@class='images'])[1]");
	private By LoginHeadingText = By.xpath("//p[normalize-space()='Please login to LMS application']");
	
	private By loginFieldsPosition= By.xpath("//mat-card[@class='mat-card mat-focus-indicator']");
	private By userfieldLabel=By.xpath("//div[@class='mat-form-field-infix ng-tns-c78-0']");
	private By passwfieldLabel=By.xpath("//div[@class='mat-form-field-infix ng-tns-c78-1']");
	
	private By loginbutton= By.xpath("//button[@id='login']");
	private By loginbtnLabel=By.xpath("//span[@class='mat-button-wrapper']");

	private By Username= By.xpath("//input[@id='username']");
	private By Password=By.xpath("//input[@id='password']");
	

	private By usercolor = By.xpath("(//span[@class='ng-tns-c78-0 ng-star-inserted'])[1]");
	private By passwordcolor = By.xpath("(//span[@class='ng-tns-c78-1 ng-star-inserted'])[1]");
	
	private By pageNotFoundErrMsg = By.xpath("/html/body/div[2]/div");
	
	private By errorMessage=By.xpath("//mat-error[@id='errormessage']");
	private By errorMessage1=By.xpath("//mat-error[@id='mat-error-0']");
	private By errorMessage2=By.xpath("//mat-error[@id='mat-error-1']");
	
	private By logout = By.xpath("//*[@id=\"logout\"]/span[1]");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(this.driver);
	}
	
//	 public void getloginUrl() { 
//		 driver.get(CommonConfigs.getUrl()); 
//		 }

	
	public String getPageTitle() {
		return util.getPageTitle();
		//return driver.getTitle();
	}	
	

		public String getLoginHeadingText() {
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

		}
		public String getPageNotFoundText() {
			return driver.findElement(pageNotFoundErrMsg).getText().trim();
		}

	
		public String getusercolorText() {
			WebElement test = driver.findElement(usercolor);
			String s = test.getCssValue("color");

			System.out.println("Color is :" + s);

		      return s;
		}

		public String getpasswordcolorText() {
			WebElement test = driver.findElement(passwordcolor);
			String s = test.getCssValue("color");

			System.out.println("Color is :" + s);

		      return s;
		}


		public String getLoginErrorMgs() {
			if (driver.findElement(errorMessage).isDisplayed()) {
				System.out.println("Expected error message 'invalid credentials' element exists");
				return driver.findElement(errorMessage).getText().trim();
			} else if (driver.findElement(errorMessage1).isDisplayed()) {
				System.out.println("Expected error message 'Enter username' element exists");
				return driver.findElement(errorMessage1).getText().trim();
			} else if (driver.findElement(errorMessage2).isDisplayed()) {
				System.out.println("Expected error message 'Enter password' element exists");
				return driver.findElement(errorMessage1).getText().trim();
			}

			else {
				System.out.println("Expected error message element not exists");
				return null;
			}
		}

		public void EnterUserName(String Uname) throws InterruptedException {
			WebElement username = driver.findElement(Username);
			Actions action = new Actions(driver);
			action.sendKeys(username, Uname).build().perform();
		}

		public void EnterPassword(String Pwd) throws InterruptedException {
			WebElement pwd = driver.findElement(Password);
			Actions action = new Actions(driver);
			action.sendKeys(pwd, Pwd).build().perform();
		}


		public Object clickOnloginButton() throws Exception {
			System.out.println("Inside login button function");
			driver.findElement(loginbutton).click();
			Thread.sleep(1000);
			int errorMsgSize = driver.findElements(By.xpath("//mat-error")).size();
			if(errorMsgSize>0) {
				System.out.println("Error msg has been found after clicking login");
				return getLoginErrorMgs(); //String
			}else return new DashboardPage(driver); //DashboardPage reference
		}

		public WebElement returnlogoutbutton() {
			return driver.findElement(logout);
		}

		public void getinvalidloginUrl() {
			driver.get(AppConstants.INVALID_LMS_PORTAL_INCORRECT_URL);
		}

		public DashboardPage clickOnloginButtonThroughKeypad() {
			//driver.findElement(loginbutton).sendKeys(Keys.RETURN);
			driver.findElement(loginbutton).sendKeys(Keys.ENTER);
			return new DashboardPage(driver);
		}
		
		public String getloginfieldsposition() {
			WebElement e = driver.findElement(loginFieldsPosition);
			String elementLocation = e.getCssValue("text-align");
			return elementLocation;
			
		}
		
		public String getloginimage() {
			WebElement e = driver.findElement(loginPageImage);
			String elementsource = e.getAttribute("src");
			return elementsource;
			
		}
		
		
	}

