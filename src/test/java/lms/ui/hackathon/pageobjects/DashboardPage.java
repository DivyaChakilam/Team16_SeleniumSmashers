package lms.ui.hackathon.pageobjects;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.net.HttpURLConnection;
import java.net.URL;

import lms.ui.hackathon.utilities.ElementUtil;


public class DashboardPage extends CommonAndPaginationFeatures{
	private WebDriver driver;
	private ElementUtil util;

	private By loginbtnLabel=By.xpath("//span[@class='mat-button-wrapper']");

	private By userLoc = By.id("username");
	private By passwordLoc = By.id("password");
	private By loginButton = By.xpath("//span[@class='mat-button-wrapper']");

	private By lMSTitle=By.xpath("//span[contains(text(),'LMS - Learning Management System')]") ;
	private By programNameLabel =By.xpath("//span[contains(text(),'Program')]") ;
	private By batchNameLabel=By.xpath("//span[contains(text(),'Batch')]") ;
	private By userNameLabel=By.xpath("//span[contains(text(),'User')]") ;
	private By brokenLink=By.xpath("//a[text()='400 brokenlink']")  ;
	private By navigationBarText=By.xpath("//mat-toolbar[@class='mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted']");
	private By loginToLmsText=By.xpath("//p[normalize-space()='Please login to LMS application']");
	private By allElements=By.xpath( "//body//app-root//app-header//mat-toolbar//button");



	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		util = new ElementUtil(this.driver);
	}

	public void loginHomePage() {
		String LoginPageTitle=util.getElementText(loginToLmsText).trim();
		System.out.println("The User is on Login Home Page "+ LoginPageTitle);
	}
	public void login() {
		driver.get("https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/login");
		util.doSendKeys(userLoc, "Sdet@gmail.com");
		driver.findElement(passwordLoc).sendKeys("LmsHackathon@2024");	
		util.doClick(loginButton);

	}


	// Dashboard page Title	
	public String validateDashboardPageTitle() {
		String dashboardpageTitle=driver.getTitle();
		return dashboardpageTitle;
	}   

	//LMS Title text
	public String getLMSTitleText()
	{
		return util.getElementText(lMSTitle);
	}

	public  String HomeloginLMSAppText() {

		return util.getElementText(loginToLmsText);
	}

	// Title Alignment
	public boolean isTitleAtTopLeftCorner() {
		Dimension windowSize = this.driver.manage().window().getSize();
		WebElement lmstit=util.getElement(lMSTitle);

		Point titlePosition = lmstit.getLocation();

		return (titlePosition.getX() <= windowSize.getWidth() / 2) 
				&& (titlePosition.getY() <= windowSize.getHeight() / 2);

	}


	public long navigationResponseTime() {
		long starttime = System.currentTimeMillis();
	    WebElement wlmsTitle=util.getElement(lMSTitle);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
	    wait.until(ExpectedConditions.visibilityOf(wlmsTitle));
	    long timeToLoad = (System.currentTimeMillis() - starttime);
	    return timeToLoad;
		
	}

	public  boolean CheckBrokenLink(int brokencode) {

		String url= driver.getCurrentUrl();

		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setConnectTimeout(3000);
			connection.connect();
			System.out.println("Response code " +connection.getResponseCode());
			return connection.getResponseCode() >= brokencode;

		} catch (Exception e) {
			System.out.println(url + " - is a broken link");
		}
		return true;
	}	

	public boolean validateNavigationBarText() {
		String headerList = driver.findElement(navigationBarText).getText();
        List<String> lstheaderList = Arrays.asList(headerList.split("\\n"));

		String[] expectedTexts= {"LMS - Learning Management System","Program","Batch","Class","Logout"};		
		for (String expected : expectedTexts) {
			boolean found = false;
			for (String element : lstheaderList) {
				if (element.trim().equalsIgnoreCase(expected)) {
					found = true;
					break;
				}
			}
			if (!found) {
				return false; 
			}
		}
		return true; 
	}


	public boolean SpaceCheck() {
		String actualTitle = util.getElementText(lMSTitle).trim();

		System.out.println(actualTitle.equals("LMS - Learning Management System") 
				? "Admin LMS title is correct!" 
						: "Admin LMS title is incorrect!");

		return actualTitle.equals("LMS - Learning Management System") ?true:false;


	}

	// check if navigation bar text is aligned to the top-right
	public boolean isNavigationBarRightTopAligned() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement navtoolbar = wait.until(ExpectedConditions.visibilityOfElementLocated(navigationBarText));
	    
	    int toolbarX = navtoolbar.getLocation().getX();
	    int toolbarY = navtoolbar.getLocation().getY();
	    int windowWidth = driver.manage().window().getSize().getWidth();
	    
	    return toolbarX >= windowWidth - navtoolbar.getSize().getWidth() - 20 && toolbarY <= 20;
	

	}

	// return a list of all the navigation bar elements
	public List<WebElement> getNavigationBarElements() {
		return driver.findElements(allElements);
	}

	//  validate the order of navigation bar items
	public boolean validateNavBarOrder() {
		String[] expectedOrder= {"Program","Batch","Class","Logout"};
		List<WebElement> headerList = getNavigationBarElements();
		for (int i = 0; i < expectedOrder.length; i++) {
			if (!headerList.get(i).getText().equalsIgnoreCase(expectedOrder[i])) {
				return false;
			}
		}
		return true;
	}



}
