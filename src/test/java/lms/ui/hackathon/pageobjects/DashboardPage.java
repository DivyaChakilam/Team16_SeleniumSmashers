package lms.ui.hackathon.pageobjects;

import org.openqa.selenium.WebDriver;

public class DashboardPage extends CommonAndPaginationFeatures{
	private WebDriver driver;

	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	
}
