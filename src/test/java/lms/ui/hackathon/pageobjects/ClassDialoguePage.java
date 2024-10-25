package lms.ui.hackathon.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import lms.ui.hackathon.utilities.ElementUtil;

public class ClassDialoguePage {

	private WebDriver driver;
	private ElementUtil util;
	
	private By classTopicLabel = By.xpath("//mat-card-title[text()='Class Topic']");
	private By classTopicLabelValue = By.xpath("//mat-card-title[text()='Class Topic']/following-sibling::mat-card-subtitle");
	private By noOfClassesLabel = By.xpath("//*[text()='No of Classes']");
	private By noOfClassesValue = By.xpath("//*[text()='No of Classes']/following-sibling::mat-card-subtitle");
	private By classStartDateLabel = By.xpath("//*[text()='Class Start Date']");
	private By classStartDateValue = By.xpath("//*[text()='Class Start Date']/following-sibling::mat-card-subtitle");
	private By descriptionLabel = By.xpath("//*[text()='Class Description']");
	private By descriptionValue = By.xpath("//*[text()='Class Description']/following-sibling::mat-card-subtitle");
	private By statusLabel = By.xpath("//*[text()='Status']");
	private By statusValue = By.xpath("//*[text()='Status']/following-sibling::mat-card-subtitle");
	private By commentLabel = By.xpath("//*[text()='Class Comments']");
	private By class_commentValue = By.xpath("//*[text()='Class Comments']/following-sibling::mat-card-subtitle");
	private By class_noteLabel = By.xpath("//*[text()='Class Notes']");
	private By class_note = By.xpath("//*[text()='Class Notes']/following-sibling::mat-card-subtitle");	
	private By class_recordlabel = By.xpath("//*[text()='Class Recording Path']");
	private By class_recordingPath = By.xpath("//*[text()='Class Recording Path']/following-sibling::mat-card-subtitle");


	public ClassDialoguePage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(this.driver);	
	}
}
