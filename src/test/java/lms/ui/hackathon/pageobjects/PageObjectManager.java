package lms.ui.hackathon.pageobjects;

import org.openqa.selenium.WebDriver;

import lms.hackathon.ui.pageobjects.BatchPage;
import lms.hackathon.ui.pageobjects.DashboardPage;
import lms.hackathon.ui.pageobjects.LoginPage;
import lms.hackathon.ui.pageobjects.ProgramPage;
import lms.hackathon.ui.pageobjects.UserPage;
import lms.ui.hackathon.configs.CommonConfigs;



public class PageObjectManager {
		
		public WebDriver driver;
		private CommonConfigs commonConfigs;
		public LoginPage loginPage;
		public DashboardPage dashboardPage;
		public BatchPage batchPage;
		public ProgramPage programPage;
		public ClassPage classPage;
		public LogoutPage commonPage;

		public PageObjectManager(WebDriver driver, CommonConfigs commonConfigs ) {
			this.driver = driver;
			this.commonConfigs = commonConfigs;
		}
		public LoginPage getLoginPage() {
			loginPage = new LoginPage(driver);
			return loginPage;
		}

		public DashboardPage getDashboardPage() {
			dashboardPage = new DashboardPage(driver);
			return dashboardPage;
		}

		public BatchPage getBatchPage() {
			batchPage = new BatchPage(driver);
			return batchPage;
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

}
