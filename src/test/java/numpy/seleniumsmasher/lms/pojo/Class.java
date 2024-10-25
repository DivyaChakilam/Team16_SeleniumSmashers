package numpy.seleniumsmasher.lms.pojo;

public class Class {

	private String batchName;
	private String classTopic;
	private String classDescription;
	private String classDates;
	private String noOfClasses;
	private String staffName;
	private Boolean status;
	private String comments;
	private String notes;
	private String recording;

	public Class(String batchName, String classTopic, String classDates, String noOfClasses, String staffName,
			Boolean status) {
		this.batchName = batchName;
		this.classTopic = classTopic;
		this.classDates = classDates;
		this.noOfClasses = noOfClasses;
		this.staffName = staffName;
		this.status = status;
	}

	public Class(String batchName, String classTopic, String classDescription, String classDates, String noOfClasses,
			String staffName, Boolean status, String comments, String notes, String recording) {
		this.batchName = batchName;
		this.classTopic = classTopic;
		this.classDescription = classDescription;
		this.classDates = classDates;
		this.noOfClasses = noOfClasses;
		this.staffName = staffName;
		this.status = status;
		this.comments = comments;
		this.notes = notes;
		this.recording = recording;

	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getClassTopic() {
		return classTopic;
	}

	public void setClassTopic(String classTopic) {
		this.classTopic = classTopic;
	}

	public String getClassDescription() {
		return classDescription;
	}

	public void setClassDescription(String classDescription) {
		this.classDescription = classDescription;
	}

	public String getClassDates() {
		return classDates;
	}

	public void setClassDates(String classDates) {
		this.classDates = classDates;
	}

	public String getNoOfClasses() {
		return noOfClasses;
	}

	public void setNoOfClasses(String noOfClasses) {
		this.noOfClasses = noOfClasses;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getRecording() {
		return recording;
	}

	public void setRecording(String recording) {
		this.recording = recording;
	}

}
