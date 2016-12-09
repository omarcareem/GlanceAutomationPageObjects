package com.glance.pageobjects.dashboard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class DashboardPage extends BasePage {

	public DashboardPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// variable for specifying the dashboard page
	@FindBy(xpath = "//div[@class='row x_title']/div[@class='col-md-6']/h3")
	WebElement lblPageName;

	// variable initialize with xpath for 'Date range selection'
	@FindBy(xpath = "//div[@id='reportrange']")
	WebElement drpdwndateRange;

	@FindBy(xpath = "//div[@class='ranges']/ul/li")
	String drpdwndateRangeArea;

	// variables regarding custom date
	@FindBy(xpath = "//div[@class='ranges']/ul/li[7]")
	WebElement lblCustomDate;

	@FindBy(xpath = "//input[@name='daterangepicker_start']")
	WebElement txtCustomDateStart;

	@FindBy(xpath = "//input[@name='daterangepicker_end']")
	WebElement txtCustomDateEnd;

	// custom date auto selection variables
	@FindBy(xpath = "//div[@class='calendar first left']/div/table/thead/tr/th/select[@class='yearselect']")
	WebElement drpdwnYearLeft;

	@FindBy(xpath = "//div[@class='calendar first left']/div/table/thead/tr/th/select[@class='monthselect']")
	WebElement drpdwnMonthLeft;

	@FindBy(xpath = "//div[@class='calendar first left']/div/table/tbody/tr/td[@class='available']")
	WebElement drpdwnDateLeft;

	@FindBy(xpath = "//div[@class='calendar second right']/div/table/thead/tr/th/select[@class='yearselect']")
	WebElement drpdwnYearRight;

	@FindBy(xpath = "//div[@class='calendar second right']/div/table/thead/tr/th/select[@class='monthselect']")
	WebElement drpdwnMonthRight;

	@FindBy(xpath = "//div[@class='calendar second right']/div/table/tbody/tr/td[@class='available']")
	WebElement drpdwnDateRight;

	// custom date submit and cancel variables
	@FindBy(xpath = "//button[@class='applyBtn btn btn-default btn-small btn-primary']")
	WebElement btnSubmit;

	@FindBy(xpath = "//button[@class='cancelBtn btn btn-default btn-small']")
	WebElement btnClear;

	@FindBy(xpath = "//span[@class='title']")
	WebElement msgSubmit;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement btnDelete;

	@FindBy(xpath = "//div[@class='jconfirm-box']/div[@class='title-c']/span[@class='title']")
	WebElement msgDelete;

	@FindBy(xpath = "//div[@class='jconfirm-box']/div/button[@class='btn btn-default']")
	WebElement btnOkay;

	@FindBy(xpath = "//div[@class='jconfirm-box']/div[@class='buttons']/button[2][@class='btn btn-default']")
	WebElement btnClose;

	// variable diclaration with xpath for 'Account Level Dashboard icons'
	@FindBy(xpath = "//i[@class='fa fa-chevron-up']")
	WebElement icnMaxMinUp;

	@FindBy(xpath = "//i[@class='fa fa-chevron-down']")
	WebElement icnMaxMinDown;

	@FindBy(xpath = "//i[@class='fa fa-close']")
	WebElement icnClose;

	@FindBy(xpath = "//i[@class='fa fa-trash']")
	WebElement icnDelete;

	// variable diclaration with xpath for 'Add New Element'
	@FindBy(xpath = "//button[@id='define_now']")
	WebElement btnAddNewElement;

	@FindBy(xpath = "//h1")
	WebElement lblElementMessage;

	@FindBy(xpath = "//div[@class='x_title']/span")
	WebElement headChartTitle;

	@FindBy(xpath = "//button[contains(text(),'DELETE')]")
	WebElement btnConfirmDelete;

	@FindBy(xpath = "//div/button[contains(text(),'Okay')]")
	WebElement btnDeleteConfirmOk;
	
	@FindBy(xpath = "//h1[@class='text-center']")
	WebElement accessDenied;

	WebDriverWait wait = new WebDriverWait(driver, 10);

	// dashboard page confirmation
	public boolean verifyNavigationToDashboardPage(String expectedMessage) {
		boolean flag = false;
		String actualMessage = lblPageName.getText();
		if (actualMessage.contains(expectedMessage)) {
			flag = true;
			System.out.println("You are in the dashboard page");
		} else {
			System.out.println("You are not in the dashboard page");
			flag = false;
		}

		return flag;

	}

	// page specifying method(verification)
	public boolean getPageName(String lblExpectedTitle) {
		boolean flag = false;

		String pageName = lblPageName.getText();
		if (pageName.contains(lblExpectedTitle)) {
			System.out.println("Navigated to dashboard page " + pageName);
			flag = true;
		} else {
			System.out.println("Not Navigated to dashboard page");
			flag = false;
		}
		return flag;
	}
	
	

	// text of the date range will selection through this
	public void clickDateRange() {
		try {
			TestLog.log.info("click on date range selection");
			drpdwndateRange.click();

			TestLog.log.info("date range selection will appear");
		} catch (Exception ex) {

		}

	}

	By drpdwndateRangeArea2 = By
			.xpath("//div[@class='daterangepicker dropdown-menu opensleft']/div[@class='ranges']/ul/li");

	public void selectDateRange(String lblDateRanges) {

		List<WebElement> dateRangeList = driver.findElements(drpdwndateRangeArea2);

		for (WebElement dateRange : dateRangeList) {
			String dataDateRange = dateRange.getText();
			System.out.println(dataDateRange);
			if (dataDateRange.contains(lblDateRanges)) {
				dateRange.click();
				System.out.println("entered date range= " + lblDateRanges + "actual date range= " + dateRange);
				break;
			} else {
				System.out.println("error selecting date range");
			}
		}

	}

	// methods for entering custom date range
	public void selectCustomDateStart(String enterStartDate) {
		try {
			TestLog.log.info("Selecting custom date start");
			txtCustomDateStart.clear();
			txtCustomDateStart.sendKeys(enterStartDate);
			TestLog.log.info("Date range is changed to customDate");
		} catch (Exception ex) {
			TestLog.log.info("Error entering start date" + ex);
		}
	}

	public void selectCustomDateEnd(String enterEndDate) {
		try {
			TestLog.log.info("Selecting custom date end");
			txtCustomDateEnd.clear();
			txtCustomDateEnd.sendKeys(enterEndDate);
			TestLog.log.info("Date range is changed to customDate");
		} catch (Exception ex) {
			TestLog.log.info("Error entering end date" + ex);
		}
	}

	// methods for selecting custom date range
	public void selectCustomDate() {
		try {
			TestLog.log.info("Changing date range to customDate");
			lblCustomDate.click();

			TestLog.log.info("Date range is changed to customDate");
		} catch (Exception ex) {
			TestLog.log.info("Error selecting custom date" + ex);
		}

	}

	public void selectStartYear() {
		try {
			TestLog.log.info("Selecting start year for customDate");
			drpdwnYearLeft.click();

			TestLog.log.info("Start year is changed");
		} catch (Exception ex) {
			TestLog.log.info("Error selecting start year" + ex);
		}

	}

	public void selectStartMonth() {
		try {
			TestLog.log.info("Selecting start month for customDate");
			drpdwnMonthLeft.click();

			TestLog.log.info("Start month is changed");
		} catch (Exception ex) {
			TestLog.log.info("Error selecting start month" + ex);
		}

	}

	public void selectStartDate() {
		try {
			TestLog.log.info("Selecting start date for customDate");
			drpdwnDateLeft.click();

			TestLog.log.info("Start date is changed");
		} catch (Exception ex) {
			TestLog.log.info("Error selecting start date" + ex);
		}

	}

	public void selectEndYear() {
		try {
			TestLog.log.info("Selecting end year for customDate");
			drpdwnYearRight.click();

			TestLog.log.info("End year is changed");
		} catch (Exception ex) {
			TestLog.log.info("Error selecting end year" + ex);
		}

	}

	public void selectEndMonth() {
		try {
			TestLog.log.info("Selecting end month for customDate");
			drpdwnMonthRight.click();

			TestLog.log.info("End month is changed");
		} catch (Exception ex) {
			TestLog.log.info("Error selecting end month" + ex);
		}

	}

	public void selectEndDate() {
		try {
			TestLog.log.info("Selecting end date for customDate");
			drpdwnDateRight.click();

			TestLog.log.info("End date is changed");
		} catch (Exception ex) {
			TestLog.log.info("Error selecting end date" + ex);
		}

	}

	// methods for custom date submit and clear
	public void selectSubmit() {
		try {
			TestLog.log.info("Selecting submit button");
			btnSubmit.click();

			TestLog.log.info("Entered date will submitted");
		} catch (Exception ex) {
			TestLog.log.info("Error selecting submit" + ex);
		}
	}

	public void selectClear() {
		try {
			TestLog.log.info("Selecting clear button");
			btnClear.click();

			TestLog.log.info("Date range picker will cancel");
		} catch (Exception ex) {
			TestLog.log.info("Error selecting clear" + ex);
		}
	}

	// methods for the dashboard icons
	public void selectMaxMin() {

		try {
			TestLog.log.info("Select ^ icon");
			icnMaxMinUp.click();
			icnMaxMinDown.click();
			TestLog.log.info("dashboard will maximize or minimize");

		} catch (Exception ex) {
			TestLog.log.info("Error selecting maxmin icon" + ex);
		}

	}

	public void selectClose() {

		try {
			TestLog.log.info("Select X icon");
			icnClose.click();
			TestLog.log.info("dashboard will Close");

		} catch (Exception ex) {
			TestLog.log.info("Error selecting closse icon" + ex);
		}

	}

	public void selectDelete() {

		try {
			wait.until(ExpectedConditions.visibilityOf(icnDelete));
			TestLog.log.info("Select delete icon");
			icnDelete.click();
			TestLog.log.info("dashboard will delete");

		} catch (Exception ex) {

		}

	}

	public void confirmDeleteGraph() {
		try {
			wait.until(ExpectedConditions.visibilityOf(btnConfirmDelete));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", btnConfirmDelete);
			TestLog.log.info("Confirming deletion of graph");
			executor.executeScript("arguments[0].click();", btnDeleteConfirmOk);
			TestLog.log.info("Delete the graph");

		} catch (Exception ex) {

		}
	}

	// method for verifying delete
	public boolean verifyDelete(String lblExpectedTitle) {

		boolean flag = false;

		String popupMessageName = msgSubmit.getText();
		if (popupMessageName.contains(lblExpectedTitle)) {
			System.out.println("Navigated to correct message " + popupMessageName);
			flag = true;
		} else {
			System.out.println("Navigated to wrong message");
			flag = false;
		}
		return flag;

	}

	public void selectDeleteInPopup() {
		try {
			TestLog.log.info("select add new entry");
			btnDelete.click();
			TestLog.log.info("new entry will submit");

		} catch (Exception ex) {
			TestLog.log.info("Error selecting delete button" + ex);
		}

	}

	// method for verifying done
	public boolean verifyDeleteDone(String lblExpectedTitle) {

		boolean flag = false;

		String popupMessageName = msgDelete.getText();
		if (popupMessageName.contains(lblExpectedTitle)) {
			System.out.println("Navigated to deleted message " + popupMessageName);
			flag = true;
		} else {
			System.out.println("not Navigated to deleted message");
			flag = false;
		}
		return flag;

	}

	By okayBtn = By.xpath("//div[@class='buttons']/button[@type='button']");

	public void selectOkayInPopup() {
		try {
			TestLog.log.info("select go to dashboard");
			//((WebElement) okayBtn).click();
			//driver.findElement(okayBtn).click();
			btnDeleteConfirmOk.click();
			TestLog.log.info("navigate to dashboard page");

		} catch (Exception ex) {
			TestLog.log.info("Error selecting okay button" + ex);
		}
	}

	public void selectCloseInPopup() {
		try {
			TestLog.log.info("select go to dashboard");
			btnClose.click();
			TestLog.log.info("navigate to dashboard page");
			System.out.println("navigate to dashboard page");
		} catch (Exception ex) {
			TestLog.log.info("Error selecting close" + ex);
		}
	}

	// method for add new element
	public void selectAddNewElement() {

		try {
			wait.until(ExpectedConditions.visibilityOf(btnAddNewElement));
			TestLog.log.info("Navigating to add element");
			btnAddNewElement.click();
			TestLog.log.info("Navigated to add element");

		} catch (Exception ex) {

		}

	}

	public boolean verifyElementMessage() {

		boolean flag = false;
		try {
			// wait.until(ExpectedConditions.visibilityOf(lblElementMessage));
			String actualElementMessage = lblElementMessage.getText();
			String expectedElementMessage = "No dashboard elements defined!";
			if (actualElementMessage.contains(expectedElementMessage)) {
				TestLog.log.info("Element is not defined");
				flag = true;
			}
		} catch (Exception ex) {
			TestLog.log.info("Could not retrieve the element message. Due to: " + ex);
		}

		return flag;
	}

	public String verifyChartTitle() {
		wait.until(ExpectedConditions.visibilityOf(headChartTitle));
		String actualChartTitle = headChartTitle.getText();
		System.out.println(actualChartTitle);

		return actualChartTitle;
	}

	// dashboard page access denied confirmation
		public boolean verifyNavigationToAccessDeniedPage(String expectedMessage) {
			boolean flag = false;
			String actualMessage = accessDenied.getText();
			if (actualMessage.contains(expectedMessage)) {
				flag = true;
				System.out.println("You are in the Access Denied page");
			} else {
				System.out.println("You are not in the dashboard page");
				flag = false;
			}

			return flag;

		}
}
