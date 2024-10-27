package lms.ui.hackathon.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import lms.ui.hackathon.utilities.ElementUtil;

public class ClassPage extends CommonAndPaginationFeatures{
	private WebDriver driver;
	private ElementUtil util;

	private By addNewClassBtn = By.xpath("//button[text()='Add New Class']");
	private By manageClassHeader = By.xpath("//div[normalize-space()='Manage Class']");
	
	//Column Headers
	private By headerCheckbox = By.xpath("//thead//div[@role='checkbox']");
	private By headerBatchName = By.xpath("//th[@psortablecolumn='batchName']");
	private By batchNameSortIcon = By.xpath("//th[@psortablecolumn='batchName']/p-sorticon");
	
	private By headerClassTopic = By.xpath("//th[@psortablecolumn='classTopic']");
	private By batchClassTopic = By.xpath("//th[@psortablecolumn='classTopic']/p-sorticon");
	
	private By headerClassDescription = By.xpath("//th[@psortablecolumn='classDescription']");
	private By classDescriptionSortIcon = By.xpath("//th[@psortablecolumn='classDescription']/p-sorticon");
	
	private By headerClassStatus = By.xpath("//th[@psortablecolumn='classStatus']");
	private By classStatusSortIcon = By.xpath("//th[@psortablecolumn='classStatus']/p-sorticon");
	
	private By headerClassDate = By.xpath("//th[@psortablecolumn='classDate']");
	private By classDateSortIcon = By.xpath("//th[@psortablecolumn='classDate']/p-sorticon");
	
	private By headerClassStaffName = By.xpath("//th[@psortablecolumn='classStaffName']");
	private By classStaffNameSortIcon = By.xpath("//th[@psortablecolumn='classStaffName']/p-sorticon");
	
	private By headerEditDelete = By.xpath("//th[normalize-space()='Edit / Delete']");
	
	
	public ClassPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		util = new ElementUtil(this.driver);
		util.doClick(programMenu);
	}
	
	/**
	 * This method checks of Manage Class Header exists and returns a boolean value
	 * @return
	 */
	public Boolean manageClassHeaderExists() {
		return util.isElementDisplayed(manageClassHeader);
	}
	
	/**
	 * This method navigates user to Class Details page
	 * @return
	 * @throws InterruptedException 
	 */
	public ClassDetailsPage goToAddNewClassPage() {
		util.doClick(programMenu);
		util.doClick(addNewClassBtn);
		return new ClassDetailsPage(driver);
	}
	
	
	

}
