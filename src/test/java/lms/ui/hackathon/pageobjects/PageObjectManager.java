package lms.ui.hackathon.pageobjects;

import org.openqa.selenium.WebDriver;
import lms.ui.hackathon.configs.CommonConfigs;


public class PageObjectManager {
		
		public WebDriver driver;
		//private CommonConfigs commonConfigs;
		public LoginPage loginPage;
		public DashboardPage dashboardPage;
		public BatchPage batchPage;
		public BatchDetailsPage batchDetailsPage;
		public ProgramPage programPage;
		public ClassPage classPage;
		public LogoutPage logoutPage;
		public ProgramDetailsPage programDetails;

		public PageObjectManager(WebDriver driver) {
			this.driver = driver;
		}
		public LoginPage getLoginPage() {
			loginPage = new LoginPage(driver);
			return loginPage;
		}

		public DashboardPage getDashboardPage() {
			if(dashboardPage == null)
				dashboardPage = new DashboardPage(driver);
			return dashboardPage;
		}

		public BatchPage getBatchPage() {
			batchPage = new BatchPage(driver);
			return batchPage;
		}
		
		public BatchDetailsPage getBatchDetailsPage() {
			batchDetailsPage = new BatchDetailsPage(driver);
			return batchDetailsPage;
		}

		public ProgramPage getProgramPage() {
			programPage = new ProgramPage(driver);
			return programPage;
		}

		public ClassPage getClassPage() {
			classPage = new ClassPage(driver);
			return classPage;
		}
		
		public LogoutPage getLogoutPage() {
			logoutPage = new LogoutPage(driver);
			return logoutPage;
		}
		public ProgramDetailsPage getProgramDetailsPage() {
			programDetails = new ProgramDetailsPage(driver);
			return programDetails;
		}
		

}
