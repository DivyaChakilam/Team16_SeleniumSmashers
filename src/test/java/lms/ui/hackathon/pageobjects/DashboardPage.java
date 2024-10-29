package lms.ui.hackathon.pageobjects;

import java.time.Duration;
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

	private By loginbutton= By.xpath("//button[@id='login']");
	private By loginbtnLabel=By.xpath("//span[@class='mat-button-wrapper']");

	private By Username= By.xpath("//input[@id='username']");
	private By Password=By.xpath("//input[@id='password']");
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

	public void login() {
		driver.get("https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/login");
		util.doSendKeys(Username, "Sdet@gmail.com");
		driver.findElement(Password).sendKeys("LmsHackathon@2024");	
		util.doClick(loginbutton);
			
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
		Dimension windowSize = driver.manage().window().getSize();
		Point titlePosition = ((WebElement) lMSTitle).getLocation();

		return (titlePosition.getX() <= windowSize.getWidth() / 2) 
				&& (titlePosition.getY() <= windowSize.getHeight() / 2);

	}

	public boolean navigationResponseTime() {
		long start = System.currentTimeMillis();
		// Here perform the navigation actions, like clicking on the login button
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.visibilityOf((WebElement) lMSTitle));
		long timeToLoad = (System.currentTimeMillis() - start);
		if(timeToLoad<450)
			return true;
		else
			return false;
	}

	public  boolean CheckBrokenLink(int brokencode) {

		String url= driver.getCurrentUrl();
		boolean isbrokenlink=false;
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setConnectTimeout(3000);
			connection.connect();

			isbrokenlink= (connection.getResponseCode() > brokencode) ? false:true;

		} catch (Exception e) {
			System.out.println(url + " - is a broken link");
		}
		return isbrokenlink;
       }	

	 //Verify navigation bar text
	 public String getNavigationBarText() {
		return driver.findElement(navigationBarText).getText();
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
		    int navigationBarX = ((WebElement) navigationBarText).getLocation().getX();
		    int navigationBarY = ((WebElement) navigationBarText).getLocation().getY();
		    int windowWidth = driver.manage().window().getSize().getWidth();

		    // Consider the navigation bar to be top-right if X is close to the window's right edge 
		    // and Y is close to the top edge
		    boolean isTopRight = navigationBarX >= (windowWidth - 20) && navigationBarY <= 20;

		    // Optional: Log the result for debugging purposes
		    if (isTopRight) {
		        System.out.println("Navigation bar is positioned on the top-right side.");
		    } else {
		        System.out.println("Navigation bar is not positioned on the top-right side.");
		    }

		    return isTopRight;
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
