package com.glance.pageobjects.dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class AddAccountPage extends BasePage {

	public AddAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//div[@class='x_title']/h2")
	WebElement lblPageName;

	@FindBy(xpath = "//h1[@class='text-center']")
	WebElement accessDeniedMessage;

	@FindBy(id = "account_name")
	WebElement txtAccountName;

	@FindBy(xpath = "//span[@class='help-block form-error']")
	WebElement lblAccountNameError;

	@FindBy(id = "ele_int_segment_id")
	WebElement drpSelectSegment;

	@FindBy(id = "submit_account")
	WebElement btnSubmit;

	@FindBy(xpath = "//span[@id='jconfirm-box99209']")
	WebElement successMessage;

	@FindBy(xpath = "//div[4]/button[1]")
	WebElement btnAddNewEntry;

	@FindBy(xpath = "//div[4]/button[2]")
	WebElement btnGoToDashboard;

	@FindBy(xpath = "//button[@id='cancel']")
	WebElement btnCancel;

	@FindBy(xpath = "//i[@class='fa fa-chevron-down']")
	WebElement clickExpand;

	@FindBy(xpath = "//i[@class='fa fa-chevron-up']")
	WebElement clickCollapse;

	@FindBy(xpath = "//i[@class='fa fa-close']")
	WebElement clickClose;

	// add account page confirmation
	public boolean verifyNavigationToAddAccountPage(String expectedMessage) {

		boolean flag;

		String actualMessage = lblPageName.getText();

		if (actualMessage.contains(expectedMessage)) {
			flag = true;
			System.out.println("You are in the add account page");

		} else {
			System.out.println("You are not in the add account page");
			flag = false;
		}

		return flag;
	}

	// access denied message
	public boolean verifyAccessDeniedMessage(String expectedMessage) {

		boolean flag;

		String actualMessage = accessDeniedMessage.getText();

		if (actualMessage.contains(expectedMessage)) {
			flag = true;
			System.out.println("User does not have access");

		} else {
			System.out.println("User have access");
			flag = false;
		}

		return flag;
	}

	// giving an account name
	public void enterAccountName(String accountName) {

		try {

			TestLog.log.info("Giving an account name");
			txtAccountName.sendKeys(accountName);
			TestLog.log.info("Gave an account name");
		}

		catch (Exception ex) {
			TestLog.log.info("Could not enter the account name. " + ex);
		}
	}

	// selecting a segment
	public void selectSegment(String segment) {

		try {

			TestLog.log.info("Select a segment from drop down list");
			Select dropdown = new Select(drpSelectSegment);
			dropdown.selectByVisibleText(segment);
			TestLog.log.info("Selected a segment from drop down list");
		}

		catch (Exception ex) {
			TestLog.log.info("Could not select segment. " + ex);
		}
	}

	// clicking submit
	public void clickSubmit() {

		try {

			TestLog.log.info("Clicking the submit button");
			btnSubmit.click();
			TestLog.log.info("Clicked the submit button");
		}

		catch (Exception ex) {
			TestLog.log.info("Could not click submit. " + ex);
		}
	}

	// Submit success
	public String submitSuccessMessage() {

		return successMessage.getText();
	}

	// selection after submit
	public void addNewEntry() {

		btnAddNewEntry.click();
	}

	public void goToDashboard() {

		btnGoToDashboard.click();
	}

	// clicking cancel
	public void clickCancel() {

		try {

			TestLog.log.info("Clicking the cancel button");
			btnCancel.click();
			TestLog.log.info("Clicked the cancel button");
		}

		catch (Exception ex) {
			TestLog.log.info("Could not click cancel. " + ex);
		}
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

			TestLog.log.info("Clicking the close icon");
			clickClose.click();
			TestLog.log.info("Clicked the close icon");
		}

		catch (Exception ex) {
			TestLog.log.info("Could not click close. " + ex);
		}
	}

}