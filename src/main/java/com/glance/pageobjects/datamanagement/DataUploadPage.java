package com.glance.pageobjects.datamanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class DataUploadPage extends BasePage {

	public DataUploadPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//div[@class='x_title']/h2")
	WebElement lblPageName;

	@FindBy(xpath = "//select[@class='form-control step2']")
	WebElement drpSelectDataTable;

	@FindBy(xpath = "//div[@id='dZUpload']")
	WebElement selectFileUpload;

	@FindBy(xpath = "//button[@id='upload']")
	WebElement btnUpload;

	@FindBy(xpath = "//span[@class='title']")
	WebElement submitSuccessMessage;

	@FindBy(xpath = "//button[@class='btn btn-success']")
	WebElement btnDone;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement btnOkay;

	@FindBy(xpath = "//i[@class='fa fa-chevron-up']")
	WebElement clickExpand;

	@FindBy(xpath = "//i[@class='fa fa-chevron-down']")
	WebElement clickCollapse;

	@FindBy(xpath = "//i[@class='fa fa-close']")
	WebElement clickClose;

	@FindBy(xpath = "//div[@class='content']")
	WebElement alertMessage;

	@FindBy(xpath = "//div[@class='content']")
	WebElement lblRecordsAdded;

	@FindBy(xpath = "//div[@class='content']")
	WebElement lblNoRecordsAdded;

	// add data upload page confirmation
	public boolean verifyNavigationToDataUploadPage(String expectedMessage) {

		boolean flag;

		String actualMessage = lblPageName.getText();

		if (actualMessage.contains(expectedMessage)) {
			flag = true;
			System.out.println("You are in the data upload page");

		} else {
			System.out.println("You are not in the data upload page");
			flag = false;
		}

		return flag;
	}

	// selecting a table
	public void selectDataTable(String tableName) {

		try {

			TestLog.log.info("Selecting a table from drop down list");
			Select dropdown = new Select(drpSelectDataTable);
			dropdown.selectByVisibleText(tableName);
			TestLog.log.info("Selected a table from drop down list");
		}

		catch (Exception ex) {
			TestLog.log.info("Could not select table. " + ex);
		}
	}

	// select file upload area
	public void selectFileUploadArea() {

		selectFileUpload.click();
	}

	// clicking upload
	public void clickUpload() {

		try {

			TestLog.log.info("Clicking upload button");
			btnUpload.click();
			TestLog.log.info("Clicked upload button");
		}

		catch (Exception ex) {
			TestLog.log.info("Could not click upload. " + ex);
		}
	}

	/*// submit success message
	public boolean verifySubmitSuccess(String expectedMessage) {

		boolean flag = false;

		String actualMessage = submitSuccessMessage.getText();

		if (actualMessage.contains(expectedMessage)) {
			flag = true;
			System.out.println("You have uploaded the file successfully");

		} else {
			System.out.println("You have not uploaded the file");
			flag = false;
		}

		return flag;
	}*/

	// click done
	public void clickDone() {

		btnDone.click();
	}

	// empty file
	public boolean verifyEmptyFileErrorMessage(String expectedMessage) {

		boolean flag;

		String actualMessage = alertMessage.getText();

		if (actualMessage.contains(expectedMessage)) {
			flag = true;
			System.out.println("Select a file to upload");

		} else {
			flag = false;
			System.out.println("File is selected");
			
		}

		return flag;
	}

	// table is not selected
	public boolean verifyTableSelection(String expectedMessage) {

		boolean flag;

		String actualMessage = alertMessage.getText();

		if (actualMessage.contains(expectedMessage)) {
			flag = true;
			System.out.println("Select a table to upload");

		} else {
			flag = false;
			System.out.println("Table is selected");
			
		}

		return flag;
	}

	// both fields empty
	public boolean verifyEmptyFields(String expectedMessage) {

		boolean flag;

		String actualMessage = alertMessage.getText();

		if (actualMessage.contains(expectedMessage)) {
			flag = true;
			System.out.println("Table and File both are empty");

		} else {
			flag = false;
			System.out.println("Both fields are selected");

		}

		return flag;
	}

	// error message accepted
	public void clickOkay() {

		btnOkay.click();
	}

	// records uploaded to the table
	public boolean verifyRecordsAdded(String expectedMessage) {

		boolean flag;

		String actualMessage = lblRecordsAdded.getText();

		if (actualMessage.contains(expectedMessage)) {
			flag = true;
			System.out.println("Records uploaded to the table");

		} else {
			flag = false;
			System.out.println("Records have not uploaded to the table");
			
		}

		return flag;
	}

	// records not uploaded to the table
	public boolean verifyNoRecordsAdded(String expectedMessage) {

		boolean flag;

		String actualMessage = lblNoRecordsAdded.getText();

		if (actualMessage.contains(expectedMessage)) {
			flag = true;
			System.out.println("Records not uploaded to the table");

		} else {
			flag = false;
			System.out.println("Records uploaded to the table");
			
		}

		return flag;
	}

	// click collapse and expand
	public void clickCollapseExpand() {

		try {

			TestLog.log.info("Clicking the collapse icon");
			clickCollapse.click();
			clickExpand.click();
			TestLog.log.info("Clicked the collapse icon");
		}

		catch (Exception ex) {
			TestLog.log.info("Could not click collapse. " + ex);
		}
	}

	// clicking close
	public void clickClose() {

		try {

			TestLog.log.info("Clicking close icon");
			clickClose.click();
			TestLog.log.info("Clicked close icon");
		}

		catch (Exception ex) {
			TestLog.log.info("Could not click close. " + ex);
		}
	}

}
