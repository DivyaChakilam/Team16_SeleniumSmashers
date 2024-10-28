package lms.ui.hackathon.pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import lms.ui.hackathon.utilities.ElementUtil;

public class BatchPage extends CommonAndPaginationFeatures{
	
	private WebDriver driver;
	private ElementUtil util;
	
	//Batch Page Navigation 
	
	private By userLoc = By.id("username");
	private By passwordLoc = By.id("password");
	private By loginButton = By.xpath("//span[@class='mat-button-wrapper']");
		
	//Batch Page Validation
	
	private By manageBatchHeader = By.xpath("//div[contains(text(),'Manage Batch')]");
	//private By paginationtext= By.xpath("//p-paginator/div/span[1]");
	private By DisDeleteIcon = By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");
	private By DeleteIcon = By.xpath("//tbody/tr[1]/td[7]/div[1]/span[2]/button[1]/span[1]");
	private By checkBoxRows=By.xpath("//table/tbody/tr//div[@role='checkbox']");
	private By editIcons= By.xpath("//table/tbody/tr//button[contains(@icon, 'pi-pencil')]");
	private By deleteIcons=By.xpath("//table/tbody/tr//button[contains(@icon, 'pi-trash')]"); 
    private By dataTableCheckBox = By.xpath("//div[@class='p-checkbox-box']");
	private By dataTableHeader = By.xpath("//thead[@class='p-datatable-thead']");
	private By batchProgramNameSortIcon = By.xpath("//th[@psortablecolumn='programName']/p-sorticon");
    private By batchDescriptionSortIcon = By.xpath("//th[@psortablecolumn='batchDescription']/p-sorticon");
	private By NextPage = By.xpath("//span[contains(@class,'angle-right')]/..");

	//Add New Batch
	
     private By addNewBatchBtn = By.xpath("//button[text()='Add New Batch']");
     private By BatchPopupFrame=By.xpath("//div[contains(@role,'dialog')]"); 
	
	
	public BatchPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		util = new ElementUtil(this.driver);
	}
	
	public void login() {
		driver.get("https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/login");
		util.doSendKeys(userLoc, "Sdet@gmail.com");
		driver.findElement(passwordLoc).sendKeys("LmsHackathon@2024");	
		util.doClick(loginButton);
			
	}
	
	public boolean ischeckBoxDisplayedForEachRow() {
		
		boolean flag = false;
		int totalRows = util.getElementSize(By.xpath("//table/tbody/tr"));
		if(util.getElementSize(checkBoxRows) == totalRows)
		{
			flag =true;
		}else flag = false;
		
		return flag;
	}
	

	public Boolean BatchHeaderExists() {
		return util.isElementDisplayed(manageBatchHeader);
	}	
		
	public boolean IspaginationActive() {
		
		return driver.findElement(NextPage).isEnabled();
	}
	
	public Boolean IsDisabledDeleteIcon() {
		
		return !util.isElementEnabled(DisDeleteIcon);	
	}
	
	public Boolean IsDeleteIconDisplayed() {
		
		return util.isElementDisplayed(DeleteIcon);	
	}
	
	public boolean IsEditIconsDisplayed() {
        boolean allEditIconsDisplayed = true;
    	List<WebElement> editiconsList = driver.findElements(editIcons);
		for (WebElement editIcon: editiconsList) {
            if (!editIcon.isDisplayed()) {
                System.out.println("Edit icon is not Displayed: " + editIcon.getText());
                allEditIconsDisplayed = false;
            }
        }
        return allEditIconsDisplayed;
    }
    
	public boolean IsdeleteIconsDisplayed() {
        boolean alldeleteIconsDisplayed = true;
    	List<WebElement> deleteIconsList= driver.findElements(deleteIcons);
		for (WebElement  deleteIcon: deleteIconsList) {
            if (!deleteIcon.isDisplayed()) {
                System.out.println("Delete icon is not Displayed: " + deleteIcon.getText());
                alldeleteIconsDisplayed = false;
            }
        }
        return alldeleteIconsDisplayed;
    }
	
	public boolean IscheckBoxRowsDisplayed() {
        boolean allcheckBoxDisplayed= true;
    	List<WebElement> checkBoxList = driver.findElements(checkBoxRows);
    	for (WebElement checkBox: checkBoxList) {
            if (!checkBox.isDisplayed()) {
                System.out.println("Edit icon is not Displayed: " + checkBox.getText());
                allcheckBoxDisplayed = false;
            }
        }
        return allcheckBoxDisplayed;
    }
    
	public boolean IsdataTableHeaderDisplayed() {
		
		System.out.println("IsdataTableHeaderDisplayed");
		return util.isElementDisplayed(dataTableHeader);
    }
	
	public boolean IsdataTableCheckBoxDisplayed() {
		System.out.println("IsdataTableCheckBoxDisplayed");
		return util.isElementDisplayed(dataTableCheckBox);	
	}
	
	
	public BatchDetailsPage AddNewBatch() {
	    util.doClick(addNewBatchBtn);
	    return new BatchDetailsPage(driver);
	}
	
	public String getBatchSubMenu() {
		System.out.println("In getBatchSubMenu");  
		System.out.println(util.getElementText(addNewBatchBtn));  

	    return util.getElementText(addNewBatchBtn);
	}
	
	public boolean verifyBatchSortIcon()
	{
		System.out.println("In verifyBatchSortIcon");
		return (util.getElement(batchProgramNameSortIcon) != null ? true:false) && (util.getElement(batchDescriptionSortIcon) != null ? true:false)
				&&(util.getElement(batchProgramNameSortIcon) != null ? true:false);
	}
	
	public Boolean IsBatchDetailsPopupPageDisplayed() {
		
		return util.isElementDisplayed(BatchPopupFrame);	
	}

}
	
	



