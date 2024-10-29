package lms.ui.hackathon.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import lms.ui.hackathon.utilities.ElementUtil;

public class ProgramDetailsPage {
	
	private WebDriver driver;
	private ElementUtil util;
	
	private By title = By.xpath("//span[contains(@class,'p-dialog-title')]");
	private By nameAsterisk = By.xpath("//label[@for='programName']//span[1]");
	private By saveButton = By.xpath("//span[text()='Save']");
	private By nameRequiredText = By.xpath("//small[text()='Program name is required.']");
	private By descriptionRequiredText = By.xpath("//small[text()='Program name is required.']");
	private By statusRequiredText = By.xpath("//small[text()='Status is required.']");
	private By cancelButton = By.xpath("//span[text()='Cancel']");
	private By nameTextbox = By.id("programName");
	private By descriptionTextbox = By.id("programDescription");
	//private By activeRadio = By.xpath("//input[@id='Active']");
	private By activeRadio = By.xpath("(//div[@class='p-radiobutton-box'])[1]");
	//private By inactiveRadio = By.xpath("//input[@id='Inactive']");
	private By inactiveRadio = By.xpath("(//div[@class='p-radiobutton-box'])[2]");
	//private By successMsg = By.xpath("//div[text()='Program Created Successfully']");
	private By successEditMsg = By.xpath("//div[text()='Program Updated']");
	
	public ProgramDetailsPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(this.driver);
	}
	
	
	public Boolean isProgramDetailsTitleExists() {
		return util.isElementPresent(title);
	}
	
	public String getProgramDetailsTitle()
	{
		return util.getElement(title).getText();
	}
	public String ProgramDetailsNameMandatoryText() {
		return util.getElement(nameAsterisk).getText();
	}
	
	public void clickProgramDetailsSave()
	{
		 util.getElement(saveButton).click();
	}
	
	public boolean verifyRequiredFields()
	{
		return util.getElement(nameRequiredText) != null && util.getElement(descriptionRequiredText) != null && util.getElement(statusRequiredText) != null;
	}
	public void clickProgramDetailsCancel()
	{
		 util.getElement(cancelButton).click();
	}
	
	public void SendKeys(String key,String value)
	{
		System.out.println("key ->"+key);
		switch(key)
		{
		case "Name":
			util.doSendKeys(nameTextbox, value);
			break;
		case "Description":
			util.doSendKeys(descriptionTextbox, value);
			break;
		case "Active":
			util.getElement(activeRadio).click();
			break;
		case "InActive":
			util.getElement(inactiveRadio).click();
			break;
		default:	
		}
		
		
	}
	
	public String getProgramNameText()
	{
		String aa=  util.getElement(nameTextbox).getText();
		System.out.println("aa ->"+aa);
		return util.getElement(nameTextbox).getText();
	}
	public String getProgramDescriptionText()
	{
		return util.getElement(descriptionTextbox).getText();
	}
	public String getProgramActiveText()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("isElementDisplayed1 ->"+util.isElementDisplayed(activeRadio));
		return util.getElement(activeRadio).getText();
	}
	public String getProgramInActiveText()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("isElementDisplayed1 ->"+util.isElementDisplayed(inactiveRadio));
		return util.getElement(inactiveRadio).getText();
	}
	
	public ProgramPage ProgramSave(String name,String Desc,String option)
	{
		util.doSendKeys(nameTextbox, name);
		util.doSendKeys(descriptionTextbox, Desc);
		if (option.equals("Active"))
			{
				util.getElement(activeRadio).click();
			}
		else
			{
				util.getElement(inactiveRadio).click();
			}
		
		util.getElement(saveButton).click();
		return new ProgramPage(driver);
		
	}
	
	/*
	 * public Boolean isProgramCreatedSuccessfully() { return
	 * util.isElementPresent(successMsg); }
	 */
	
	public String editName()
	{
	 String edited = util.getElement(nameTextbox).getAttribute("value")+"Edited";
	 util.doSendKeys(nameTextbox, edited);
	 return edited;
	}
	public void editDescription()
	{
	 String edited = util.getElement(descriptionTextbox).getAttribute("value")+"Edited";
	 util.doSendKeys(descriptionTextbox, edited);
	
	}
	
	public Boolean isProgramEditedSuccessfully() {
		return util.isElementPresent(successEditMsg);
	}
	
	public void ToggleStatus()
	{
		boolean isactive = util.getElement(activeRadio).isSelected();
		if(isactive)
		{
			util.doClick(inactiveRadio);
			//util.getElement(inactiveRadio).click();
		}
		else
		{
			util.doClick(activeRadio);
			//util.getElement(activeRadio).click();
		}
		
	}
	

}
