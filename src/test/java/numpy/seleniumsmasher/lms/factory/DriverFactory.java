package numpy.seleniumsmasher.lms.factory;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

	public WebDriver driver;
	private Properties prop;
	public BroswerOptionsManager optionsManager;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public WebDriver initDriver(Properties prop, String browserFromTestNG) throws MalformedURLException, URISyntaxException {
		
		String browserNameForExecution = null;
		
		//if browser is empty from TestNG
		if(browserFromTestNG != null) {
			browserNameForExecution = browserFromTestNG;
		}else {
			browserNameForExecution = prop.getProperty("browser").trim();
		}
			
		
		
		System.out.println("Browser name for execution is = " + browserNameForExecution);

		optionsManager = new BroswerOptionsManager(prop);

		if (browserNameForExecution.trim().equalsIgnoreCase("chrome")) {

			// if remote flag is true
			if (Boolean.parseBoolean(prop.getProperty("remote").trim())) {
				
				init_remoteDriver(browserNameForExecution);
				
			} else // if remote flag is false, run locally
				tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			
		} else if (browserNameForExecution.trim().equalsIgnoreCase("firefox")) {
			
			// if remote flag is true
			if (Boolean.parseBoolean(prop.getProperty("remote").trim())) {
					init_remoteDriver(browserNameForExecution);
			} else
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));

		} else if (browserNameForExecution.trim().equalsIgnoreCase("safari")) {
			tlDriver.set(new SafariDriver());

		} else if (browserNameForExecution.trim().equalsIgnoreCase("edge")) {
			tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));

		} else {
			System.out.println("Plz pass the right browser");
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();

		return getDriver();

	}

	public synchronized static WebDriver getDriver() {
		return tlDriver.get();
	}
	
	private void init_remoteDriver(String browser) throws MalformedURLException, URISyntaxException{
		
		System.out.println("Running tests on grid server:::" + browser);
		
		// URL hubUrl = new URL(prop.getProperty("hubUrl").trim()); // this kept giving
		// : The constructor URL(String) is deprecated since version 20
		/*
		 * ChatGPT explanation: In Java 20 and later, the constructor URL(String spec)
		 * has been deprecated in favor of using the URI class to create a URL object.
		 * You can update your code to use URI as follows:
		 */

		// Create URI object for the remote WebDriver
		URI hubUri = new URI(prop.getProperty("hubUrl").trim()); // Ensure this is a valid URI

		// Convert URI to URL
		URL hubUrl = hubUri.toURL();
		
		switch (browser.toLowerCase()) {
		case "chrome":
			tlDriver.set(new RemoteWebDriver(hubUrl, optionsManager.getChromeOptions()));
			break;
			
		case "firefox":
			tlDriver.set(new RemoteWebDriver(hubUrl, optionsManager.getFirefoxOptions()));
			break;
			
		case "edge":
			tlDriver.set(new RemoteWebDriver(hubUrl, optionsManager.getEdgeOptions()));
			break;
			
		default:
			System.out.println("plz pass the right browser for remote execution..." + browser);
			throw new RuntimeException("NOREMOTEBROWSEREXCEPTION");
		}

	}
	

}
