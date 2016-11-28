package com.glance.pageobjects.dashboard;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class DashboardPage extends BasePage {

	public DashboardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	// variable for specifying the dashboard page
	@FindBy(xpath = "//h3")
	WebElement lblPageName;

	// variable initialize with xpath for 'Date range selection'
	@FindBy(xpath = "//div[@id='reportrange']")
	WebElement drpdwndateRange;

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

	// variable declaration with xpath for 'Account Level Dashboard icons'
	@FindBy(xpath = "//i[@class='fa fa-chevron-up']")
	WebElement icnMaxMin;

	@FindBy(xpath = "//i[@class='fa fa-close']")
	WebElement icnClose;

	@FindBy(xpath = "//i[@class='fa fa-trash']")
	WebElement icnDelete;

	// variable declaration with xpath for 'Add New Element'
	@FindBy(xpath = "//button[@id='define_now']")
	WebElement btnAddNewElement;

	// page specifying method(verification)
	public String verifyPageName() {
		return lblPageName.getText();
	}

	public boolean verifyNavigationToDashboardPage(String expectedMessage){
		boolean flag = false;
		String actualMessage=lblPageName.getText();
		if (actualMessage.contains(expectedMessage)) {
			flag = true;
			System.out.println("You are in the dashboard page");
			}
		else {
			System.out.println("You are not in the dashboard page");
			flag = false;
			}
		
		return flag;
		
		
	}
	
	// text of the date range will selection through this
	public void selectDateRange(String lblDateRanges) {
		try {
			TestLog.log.info("Changing date range");
			Select range = new Select(drpdwndateRange);
			range.selectByVisibleText(lblDateRanges);

			TestLog.log.info("Date range is changed");
		} catch (Exception ex) {

		}

	}

	// methods for entering custom date range
	public void selectCustomDateStart(String enterStartDate) {
		try {
			TestLog.log.info("Selecting custom date start");
			Select dateFrom = new Select(txtCustomDateStart);
			dateFrom.selectByValue(enterStartDate);

			TestLog.log.info("Date range is changed to customDate");
		} catch (Exception ex) {

		}
	}

	public void selectCustomDateEnd(String enterEndDate) {
		try {
			TestLog.log.info("Selecting custom date end");
			Select dateTo = new Select(txtCustomDateEnd);
			dateTo.selectByValue(enterEndDate);

			TestLog.log.info("Date range is changed to customDate");
		} catch (Exception ex) {

		}
	}

	// methods for selecting custom date range
	public void selectCustomDate() {
		try {
			TestLog.log.info("Changing date range to customDate");
			lblCustomDate.click();

			TestLog.log.info("Date range is changed to customDate");
		} catch (Exception ex) {

		}

	}

	public void selectStartYear() {
		try {
			TestLog.log.info("Selecting start year for customDate");
			drpdwnYearLeft.click();

			TestLog.log.info("Start year is changed");
		} catch (Exception ex) {

		}

	}

	public void selectStartMonth() {
		try {
			TestLog.log.info("Selecting start month for customDate");
			drpdwnMonthLeft.click();

			TestLog.log.info("Start month is changed");
		} catch (Exception ex) {

		}

	}

	public void selectStartDate() {
		try {
			TestLog.log.info("Selecting start date for customDate");
			drpdwnDateLeft.click();

			TestLog.log.info("Start date is changed");
		} catch (Exception ex) {

		}

	}

	public void selectEndYear() {
		try {
			TestLog.log.info("Selecting end year for customDate");
			drpdwnYearRight.click();

			TestLog.log.info("End year is changed");
		} catch (Exception ex) {

		}

	}

	public void selectEndMonth() {
		try {
			TestLog.log.info("Selecting end month for customDate");
			drpdwnMonthRight.click();

			TestLog.log.info("End month is changed");
		} catch (Exception ex) {

		}

	}

	public void selectEndDate() {
		try {
			TestLog.log.info("Selecting end date for customDate");
			drpdwnDateRight.click();

			TestLog.log.info("End date is changed");
		} catch (Exception ex) {

		}

	}

	// methods for custom date submit and cancel
	public void selectSubmit() {
		try {
			TestLog.log.info("Selecting submit button");
			btnSubmit.click();

			TestLog.log.info("Entered date will submitted");
		} catch (Exception ex) {

		}
	}

	public void selectClear() {
		try {
			TestLog.log.info("Selecting clear button");
			btnClear.click();

			TestLog.log.info("Date range picker will cancel");
		} catch (Exception ex) {

		}
	}

	// methods for the dash board icons
	public void selectMaxMin() {

		try {
			TestLog.log.info("Select ^ icon");
			icnMaxMin.click();
			TestLog.log.info("dashboard will maximize or minimize");

		} catch (Exception ex) {

		}

	}

	public void selectClose() {

		try {
			TestLog.log.info("Select X icon");
			icnClose.click();
			TestLog.log.info("dashboard will Close");

		} catch (Exception ex) {

		}

	}

	public void selectDelete() {

		try {
			TestLog.log.info("Select delete icon");
			icnDelete.click();
			TestLog.log.info("dashboard will delete");

		} catch (Exception ex) {

		}

	}

	// method for ass new element
	public void selectAddNewElement() {

		try {
			TestLog.log.info("Select delete icon");
			btnAddNewElement.click();
			TestLog.log.info("Navigated to add element");

		} catch (Exception ex) {

		}

	}

}
