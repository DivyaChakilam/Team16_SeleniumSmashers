package lms.ui.hackathon.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import lms.ui.hackathon.utilities.ElementUtil;

public class BatchDetailsPage {

	private WebDriver driver;
	private ElementUtil util;
	
	public BatchDetailsPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(this.driver);
	}
	
    private By addBatchTitle=By.xpath("//span[contains(text(),'Batch Details')]");
	private By batchNameText=By.id("batchName");
	private By batchNameTextField= By.xpath("//body//app-root//input[2]']");
	private By batchDescText=By.id ("batchDescription");
	private By batchDescriptionTextField = By.xpath("//input[@*='batchDescription']");
	private By batchProgramNameTextField= By.id("programName");
	private By batchClassesText= By.id ("batchNoOfClasses"); 
	private By programNameDropdown=By.id("programName");
	private By batchprogramNameFieldDropDownBtn= By.xpath("//div[@*='button']/span");
	private By statusField=By.xpath("//div[contains(@class, 'radio')]");
	private By batchActiveRadiobtn=By.xpath("//*[@id='batchStatus']/div[1]");
	private By batchNoOfClassesField=By.xpath("//input[@id='batchNoOfClasses']");
	private By savebatchBtn=By.xpath("//button[@label='Save']");
	private By CurrentRows=By.cssSelector("tbody.p-datatable-tbody tr");
    List<WebElement> rows = driver.findElements(CurrentRows);
	private By descriptionLabel=By.cssSelector("label[for='batchDescription']");
	private By closeIconWindow=By.xpath("//span[contains(@class, 'p-dialog-header-close-icon')]");

	
	public String AddBatchTitleDisplayed() {
		
		return util.getElementText(addBatchTitle);	
	}
	
	public void ValidateAddBtachFields() {
		if (batchNameText != null && batchNameTextField != null && batchDescText != null) {
            System.out.println("All required text box fields are present in the pop-up dialog.");
        } else {
            System.out.println("Some fields are missing in the pop-up dialog.");
        }
	}
	
	public boolean isPopupDisplayingProgramNameDropdown() {
        boolean isDisplayed =  ((WebElement) programNameDropdown).isDisplayed();
        boolean isDropdown = ((WebElement) programNameDropdown).getTagName().equals("p-dropdown");
        return isDisplayed && isDropdown;
	}
	
}

