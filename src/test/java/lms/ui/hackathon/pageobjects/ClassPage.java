package lms.ui.hackathon.pageobjects;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import lms.ui.hackathon.utilities.ElementUtil;

public class ClassPage extends CommonAndPaginationFeatures {
	private WebDriver driver;
	private ElementUtil util;

	private By addNewClassBtn = By.xpath("//button[text()='Add New Class']");
	private By manageClassHeader = By.xpath("//div[normalize-space()='Manage Class']");

	// Column Headers
	private By headerCheckbox = By.xpath("//thead//div[@role='checkbox']");
	private By headerBatchName = By.xpath("//th[@psortablecolumn='batchName']");
	private By batchNameSortIcon = By.xpath("//th[@psortablecolumn='batchName']/p-sorticon");

	private By headerClassTopic = By.xpath("//th[@psortablecolumn='classTopic']");
	private By classTopicSortIcon = By.xpath("//th[@psortablecolumn='classTopic']/p-sorticon");
	
	private By headerClassDescription = By.xpath("//th[@psortablecolumn='classDescription']");
	private By classDescriptionSortIcon = By.xpath("//th[@psortablecolumn='classDescription']/p-sorticon");

	private By headerClassStatus = By.xpath("//th[@psortablecolumn='classStatus']");
	private By classStatusSortIcon = By.xpath("//th[@psortablecolumn='classStatus']/p-sorticon");

	private By headerClassDate = By.xpath("//th[@psortablecolumn='classDate']");
	private By classDateSortIcon = By.xpath("//th[@psortablecolumn='classDate']/p-sorticon");

	private By headerClassStaffName = By.xpath("//th[@psortablecolumn='classStaffName']");
	private By classStaffNameSortIcon = By.xpath("//th[@psortablecolumn='classStaffName']/p-sorticon");

	private By headerEditDelete = By.xpath("//th[normalize-space()='Edit / Delete']");

	private By tableRows = By.xpath("//tbody[@class='p-datatable-tbody']/tr");

	public ClassPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		util = new ElementUtil(this.driver);
	}

	// *************** Menu Banner Methods ***************************

	/**
	 * This method checks of Manage Class Header exists and returns a boolean value
	 * 
	 * @return
	 */
	public Boolean manageClassHeaderExists() {
		return util.isElementDisplayed(manageClassHeader);
	}

	/**
	 * This method navigates user to Class Details page
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public ClassDetailsPage goToAddNewClassPage() {
		util.doClick(programMenu);
		util.doClick(addNewClassBtn);
		return new ClassDetailsPage(driver);
	}
	
	public ClassDetailsPage gotoAddNewClassThroughTABBING() {
		
		util.doClick(programMenu);
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.TAB).keyUp(Keys.TAB) 
		.keyDown(Keys.TAB).keyUp(Keys.TAB)
		.keyDown(Keys.ENTER)
		.build().perform();
		
		util.doClick(addNewClassBtn);
		return new ClassDetailsPage(driver);

	}

	// *************** Table Body Methods ***************************

	/**
	 * This method checks if table rows exists
	 * 
	 * @return
	 */
	public boolean doesTableRowsExists() {
		if (util.getElementSize(tableRows) > 0) {
			return true;
		} else
			return false;
	}

	/**
	 * This method retrieves String Values for a given List<WebElement>
	 * @param list
	 * @param colValue
	 * @return
	 */
	private List<String> getStringList(List<WebElement> list) {

		List<String> columnNameValueList = new ArrayList<String>();
		for (WebElement e : list) {
			columnNameValueList.add(e.getText());
		}

		return columnNameValueList;
	}

	/**
	 * This method checks if all values for a given column matches with a given
	 * String
	 * 
	 * @param colName
	 * @param colValue
	 * @return
	 */
	public boolean isAllValuesInAColumnSame(String colName, String colValue) {

		boolean flag = false;
		List<WebElement> list = new ArrayList<WebElement>();

		if (doesTableRowsExists()) {
			if (colName.toLowerCase().trim().equals("batch name")) {
				list = util.getElements(By.xpath("//tbody[@class='p-datatable-tbody']/tr/td[2]"));
			} else if (colName.toLowerCase().trim().equals("class topic")) {
				list = util.getElements(By.xpath("//tbody[@class='p-datatable-tbody']/tr/td[3]"));
			} else if (colName.toLowerCase().trim().equals("staff name")) {
				list = util.getElements(By.xpath("//tbody[@class='p-datatable-tbody']/tr/td[7]"));
			}

			List<String> colValueInStringlist = getStringList(list);

			int count = 0;
			for (String e : colValueInStringlist) {
				if (e.equals(colValue)) {
					count++;
				}
			}

			if (count == colValueInStringlist.size()) {
				flag = true;
			} else
				flag = false;

		}
		return flag;
	}

	/**
	 * This method returns String List for a given column
	 * @param colName
	 * @return
	 */
	public List<String> getColumnValues(String colName) {
		
		List<WebElement> list = new ArrayList<WebElement>();
		
		if(doesTableRowsExists()) {
			if(colName.toLowerCase().trim().equals("batch name")) {
				 list = util.getElements(By.xpath("//tbody[@class='p-datatable-tbody']/tr/td[2]"));
				
			}else if(colName.toLowerCase().trim().equals("class topic")) {
				list = util.getElements(By.xpath("//tbody[@class='p-datatable-tbody']/tr/td[3]"));
				
			}else if(colName.toLowerCase().trim().equals("class description")) {
				list = util.getElements(By.xpath("//tbody[@class='p-datatable-tbody']/tr/td[4]"));
				
			}else if(colName.toLowerCase().trim().equals("status")) {
				list = util.getElements(By.xpath("//tbody[@class='p-datatable-tbody']/tr/td[5]"));
				
			}else if(colName.toLowerCase().trim().equals("class date")) {
				list = util.getElements(By.xpath("//tbody[@class='p-datatable-tbody']/tr/td[6]"));
			}else if(colName.toLowerCase().trim().equals("staff name")) {
				list = util.getElements(By.xpath("//tbody[@class='p-datatable-tbody']/tr/td[7]"));
			}
		}	
		return getStringList(list);
	}
	
	/**
	 * This method clicks on a column value and opens the Class Dialogue Box
	 * @param fieldValue
	 * @return
	 */
	public ClassDialoguePage clickOnColumnValueInTableRow(String fieldValue) {
		By fieldValueElement = By.xpath("//td[text()='"+fieldValue+"']");
		util.doClick(fieldValueElement);
		return new ClassDialoguePage(driver);
	}

	// *************** Sort Icon Methods ***************************

	/**
	 * This method clicks on sortIcon for a given column Name	 * 
	 * @param colName
	 */
	public void clickOnSortIconFor(String colName) {

		switch (colName.toLowerCase().trim()) {
		case "batch name":
			util.doClick(batchNameSortIcon);
			break;
		case "class topic":
			util.doClick(classTopicSortIcon);
			break;
		case "status":
			util.doClick(classStatusSortIcon);
			break;
		case "class date":
			util.doClick(classDateSortIcon);
			break;
		case "staff name":
			util.doClick(classStaffNameSortIcon);
			break;
		default:
			break;
		}
	}
	
	public List<String> getSortedList(List<String> list){
		List<String> sortedList = list.stream().sorted(String.CASE_INSENSITIVE_ORDER)
				.collect(Collectors.toList());
		return sortedList;
	}
	
}