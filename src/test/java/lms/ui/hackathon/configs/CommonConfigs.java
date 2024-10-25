package lms.ui.hackathon.configs;

import org.openqa.selenium.WebDriver;

public class CommonConfigs {
	
	private static String browserType = null;
	String userName;
	String password;
	//String url;
	String loginUrl;
	String registerUrl;
	
	public static ThreadLocal<String> tlUrl = new ThreadLocal<String>();

	
	public static void setBrowserType(String browser) {
		browserType = browser;
	}

	public static String getBrowserType() throws Throwable {
		if (browserType != null)
			return browserType;
		else
			throw new RuntimeException("browser not specified in the testng.xml");
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public synchronized static String getUrl() {
		return tlUrl.get();
	}
	
	public void setUrl(String url) {
		//this.url = url;
		tlUrl.set(url);
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getRegisterUrl() {
		return registerUrl;
	}

	public void setRegisterUrl(String registerUrl) {
		this.registerUrl = registerUrl;
	}
	
}
