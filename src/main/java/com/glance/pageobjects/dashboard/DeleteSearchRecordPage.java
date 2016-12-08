package com.glance.pageobjects.dashboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class DeleteSearchRecordPage extends BasePage {

	public DeleteSearchRecordPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// variable declaration with xpath for identifying page name
	@FindBy(xpath = "//div[@class='x_title']/h2")
	WebElement lblPageName;

	// initialization of variables with the xpath in Delete Search Record page
	@FindBy(xpath = "//div[@id='searchTable_length']/label/select[@name='searchTable_length']")
	WebElement drpdwnShowEntry;

	@FindBy(xpath = "//a[@id='searchTable_first']")
	WebElement btnFirst;

	@FindBy(xpath = "//a[@id='searchTable_previous']")
	WebElement btnPrevious;

	@FindBy(xpath = "//a[@id='searchTable_next']")
	WebElement btnNext;

	@FindBy(xpath = "//a[@id='searchTable_last']")
	WebElement btnLast;

	@FindBy(xpath = "//a[@class='paginate_button current']")
	WebElement btnPageNumber;

	@FindBy(xpath = "//a[@onclick='rowData(this.id);']")
	WebElement btnDelete;

	@FindBy(xpath = "//div[@class='jconfirm-box']/div[@class='title-c']/span[@class='title']")
	WebElement msgDelete;

	@FindBy(xpath = "//div[@class='jconfirm-box']/div[@class='buttons']/button[@class='btn btn-danger']")
	WebElement btnOkay;

	@FindBy(xpath = "//div[@class='jconfirm-box']/div[@class='buttons']/button[@class='btn btn-default']")
	WebElement btnClose;

	@FindBy(xpath = "//div[@id='searchTable_info']")
	WebElement lblRecordCount;

	@FindBy(xpath = "//tr[@class='odd']/td[@class='dataTables_empty']")
	WebElement rowDetail;

	By middlePagination = By.xpath("//div[@id='searchTable_paginate']/span/a");
	By txtSearch = By.xpath("//input[@type='search']");

	// method for identifying the page title
	public boolean getPageName(String lblExpectedTitle) {
		boolean flag = false;

		String pageName = lblPageName.getText();
		if (pageName.contains(lblExpectedTitle)) {
			System.out.println("Navigated to delete Search result page " + pageName);
			flag = true;
		} else {
			System.out.println("Not Navigated to delete Search result page");
			flag = false;
		}
		return flag;
	}

	// Page Navigation - First page
	public void firstPageNavigation() {

		try {
			TestLog.log.info("Check First Button eneble");
			if (btnFirst.isEnabled()) {
				System.out.println("btnFirst is clicked");
				btnFirst.click();
			} else {
				TestLog.log.info("Page Navigation button First Disable");
			}
		} catch (Exception ex) {
			TestLog.log.info("Could not find page Navigation button" + ex);
		}
	}

	// Page Navigation - Previous page
	public void previousPageNavigation() {
		try {
			TestLog.log.info("Check Previous Button eneble");
			if (btnPrevious.isEnabled()) {
				System.out.println("btnPrevious is clicked");
				btnPrevious.click();
			} else {
				TestLog.log.info("Page Navigation button Previous Disable");
			}
		} catch (Exception ex) {
			TestLog.log.info("Could not find page Navigation button" + ex);
		}
	}

	// Page Navigation - Next page
	public void nextPageNavigation() {
		try {
			TestLog.log.info("Check Next Button eneble");
			if (btnNext.isEnabled()) {
				System.out.println("btnNext is clicked");
				btnNext.click();
			} else {
				TestLog.log.info("Page Navigation button Previous Disable");
			}
		} catch (Exception ex) {
			TestLog.log.info("Could not find page Navigation button" + ex);
		}
	}

	// Page Navigation - Last page
	public void lastPageNavigation() {
		try {
			TestLog.log.info("Check Last Button eneble");
			if (btnLast.isEnabled()) {
				System.out.println("btnLast is clicked");
				btnLast.click();
			} else {
				TestLog.log.info("Page Navigation button Previous Disable");
			}
		} catch (Exception ex) {
			TestLog.log.info("Could not find page Navigation button" + ex);
		}
	}

	// Page navigation - Middle Pages

	public void middlePageNavigation() {
		try {
			List<WebElement> pagination = driver.findElements(middlePagination);
			TestLog.log.info("checkif pagination link exists");

			if (pagination.size() > 0) {
				System.out.println("pagination exists");
				TestLog.log.info("click on pagination link ");
				for (int i = 0; i < pagination.size(); i++) {
					pagination.get(i).click();
					System.out.println("pagination clicked on " + i);
				}
			} else {
				System.out.println("pagination not exists");
			}
		} catch (Exception ex) {
			TestLog.log.info("Could not find page Navigation button" + ex);
		}
	}

	// Page navigation verification - Actual page count text
	public String actualPage() {
		String recordCount = null;
		try {

			TestLog.log.info("get actual page count text");
			recordCount = lblRecordCount.getText();
			System.out.println(recordCount);

		} catch (Exception ex) {
			TestLog.log.info("Could not find dropdown" + ex);
		}
		return recordCount;
	}

	// methods for the Delete Search Record page
	public void clicktShowEntry() {
		try {
			TestLog.log.info("select the dropdwn list");
			drpdwnShowEntry.click();
			TestLog.log.info("drop down will appear");
		} catch (Exception ex) {
			TestLog.log.info("Error clicking show entry" + ex);
		}
	}

	// select the table entry count from the drop down
	public void selectDropDown(String dropDownValue) {
		try {
			TestLog.log.info("check dropdown exist");
			if (drpdwnShowEntry.isDisplayed()) {
				TestLog.log.info("select from dropdown list");
				Select drpRecords = new Select(drpdwnShowEntry);
				drpRecords.selectByVisibleText(dropDownValue);
			} else {
				TestLog.log.info("dropdown does not exist");
				System.out.println("Table Entry dropdown not visible");
			}

		} catch (Exception ex) {
			TestLog.log.info("Could not find dropdown" + ex);
		}

	}

	public void expectedRowCount(int rowCount) {

		TestLog.log.info("verify selection");
		System.out.println(rowCount);
		Select visibleRecords = new Select(drpdwnShowEntry);

		TestLog.log.info("get selection from drop down");
		WebElement element = visibleRecords.getFirstSelectedOption();
		String selectedValue = element.getText();
		int expectedRowCount = 0;

		try {
			TestLog.log.info("get actual row count");
			if (rowCount <= 10) {
				if (selectedValue == "10") {
					expectedRowCount = rowCount;
				} else if (selectedValue == "25") {
					expectedRowCount = rowCount;
				} else if (selectedValue == "50") {
					expectedRowCount = rowCount;
				} else if (selectedValue == "100") {
					expectedRowCount = rowCount;
				} else {
					TestLog.log.info("no record added");
					System.out.println("No records appeared");
				}
			}
			if (rowCount > 10 || rowCount <= 25) {
				if (selectedValue == "10") {
					expectedRowCount = 10;
				} else if (selectedValue == "25") {
					expectedRowCount = rowCount;
				} else if (selectedValue == "50") {
					expectedRowCount = rowCount;
				} else if (selectedValue == "100") {
					expectedRowCount = rowCount;
				} else {
					System.out.println("No records appeared");
				}
			}
			if (rowCount > 25 || rowCount <= 50) {
				if (selectedValue == "10") {
					expectedRowCount = 10;
				} else if (selectedValue == "25") {
					expectedRowCount = 25;
				} else if (selectedValue == "50") {
					expectedRowCount = rowCount;
				} else if (selectedValue == "100") {
					expectedRowCount = rowCount;
				} else {
					System.out.println("No records appeared");
				}
			}
			if (rowCount > 50 || rowCount <= 100) {
				if (selectedValue == "10") {
					expectedRowCount = 10;
				} else if (selectedValue == "25") {
					expectedRowCount = 25;
				} else if (selectedValue == "50") {
					expectedRowCount = 50;
				} else if (selectedValue == "100") {
					expectedRowCount = rowCount;
				} else {
					System.out.println("No records appeared");
				}
			}
			if (rowCount > 100) {
				if (selectedValue == "10") {
					expectedRowCount = 10;
				} else if (selectedValue == "25") {
					expectedRowCount = 25;
				} else if (selectedValue == "50") {
					expectedRowCount = 50;
				} else if (selectedValue == "100") {
					expectedRowCount = 100;
				} else {
					System.out.println("No records appeared");
				}
			}
		} catch (Exception ex) {
			TestLog.log.info("Could not find dropdown" + ex);
		}

	}

	// validate actual row count
	public int actualRowCount() {
		int actualRawCount = 0;

		try {
			actualRawCount = driver.findElements(By.tagName("tr")).size();
			System.out.println("actualRawCount" + actualRawCount);

		} catch (Exception ex) {
			TestLog.log.info("Could not find table" + ex);
		}
		return actualRawCount;

	}

	// Page count verification - Expected page count
	public void verifyDropDownPageCount(int rowCount) {
		try {
			TestLog.log.info("verify selection");

			Select visibleRecords = new Select(drpdwnShowEntry);

			TestLog.log.info("get table row count");
			WebElement element = visibleRecords.getFirstSelectedOption();
			String selectedValue = element.getText();
			System.out.println(selectedValue);

			TestLog.log.info("get page number count");
			int pageCount;

			TestLog.log.info("get page count");
			if (rowCount < 10) {
				if (selectedValue == "10") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 10.0));
					System.out.println(pageCount);
				} else if (selectedValue == "25") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 25.0));
					System.out.println(pageCount);
				} else if (selectedValue == "50") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 50.0));
					System.out.println(pageCount);
				} else if (selectedValue == "100") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 100.0));
					System.out.println(pageCount);
				} else {
					System.out.println("No pages appeared");
				}
			}

			if (rowCount < 25) {
				if (selectedValue == "10") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 10.0));
					System.out.println(pageCount);
				} else if (selectedValue == "25") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 25.0));
					System.out.println(pageCount);
				} else if (selectedValue == "50") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 50.0));
					System.out.println(pageCount);
				} else if (selectedValue == "100") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 100.0));
					System.out.println(pageCount);
				} else {
					System.out.println("No pages appeared");
				}
			}

			if (rowCount < 50) {
				if (selectedValue == "10") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 10.0));
					System.out.println(pageCount);
				} else if (selectedValue == "25") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 25.0));
					System.out.println(pageCount);
				} else if (selectedValue == "50") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 50.0));
					System.out.println(pageCount);
				} else if (selectedValue == "100") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 100.0));
					System.out.println(pageCount);
				} else {
					System.out.println("No pages appeared");
				}
			}

			if (rowCount < 100) {
				if (selectedValue == "10") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 10.0));
					System.out.println(pageCount);
				} else if (selectedValue == "25") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 25.0));
					System.out.println(pageCount);
				} else if (selectedValue == "50") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 50.0));
					System.out.println(pageCount);
				} else if (selectedValue == "100") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 100.0));
					System.out.println(pageCount);
				} else {
					System.out.println("No pages appeared");
				}
			}

			if (rowCount > 100) {
				if (selectedValue == "10") {
					if (selectedValue == "10") {
						TestLog.log.info("get page count");
						pageCount = (int) (Math.ceil(rowCount / 10.0));
						System.out.println(pageCount);
					} else if (selectedValue == "25") {
						TestLog.log.info("get page count");
						pageCount = (int) (Math.ceil(rowCount / 25.0));
						System.out.println(pageCount);
					} else if (selectedValue == "50") {
						TestLog.log.info("get page count");
						pageCount = (int) (Math.ceil(rowCount / 50.0));
						System.out.println(pageCount);
					} else if (selectedValue == "100") {
						TestLog.log.info("get page count");
						pageCount = (int) (Math.ceil(rowCount / 100.0));
						System.out.println(pageCount);
					} else {
						System.out.println("No pages appeared");
					}
				}
			}

		} catch (Exception ex) {
			TestLog.log.info("Could not find dropdown" + ex);
		}
	}

	// Page Count verification - Actual page count
	public int pageCount() {
		TestLog.log.info("get actual page count");
		int pageNumbers = 0;
		try {
			pageNumbers = driver.findElements(By.xpath("//span/a")).size();

		} catch (Exception ex) {
			TestLog.log.info("Could not find page count" + ex);
		}
		return pageNumbers;
	}

	// add text to search text box
	public void tableSearch(String searchKey) {
		TestLog.log.info("verify text search");
		try {
			driver.findElement(txtSearch).sendKeys(searchKey);
		} catch (Exception ex) {
			TestLog.log.info("Text search verification fails" + ex);
		}

	}

	// sorting the table according to the column

	public void tableSort(String columnName) {
		TestLog.log.info("sort according to the column ");
		try {
			driver.findElement(By.xpath("//*[contains(text(),'" + columnName + "')]")).click();
			System.out.println("click on " + columnName);
		} catch (Exception ex) {
			TestLog.log.info("sorting fails" + ex);
		}
	}

	// verify sorting the table according to the column

	public void verifyTableSort(String columnName) {
		TestLog.log.info("verification sort according to the colom ");

		int eleCount;
		List<String> expEngagementID = new ArrayList();
		List<String> expEngagementName = new ArrayList();
		List<String> expAccountID = new ArrayList();
		List<String> expDeliveryMethodID = new ArrayList();
		List<String> expContractTypeID = new ArrayList();
		List<String> expYears = new ArrayList();
		List<String> expManaged = new ArrayList();
		List<String> expAction = new ArrayList();

		List<String> actEngagementID = new ArrayList();
		List<String> actEngagementName = new ArrayList();
		List<String> actAccountID = new ArrayList();
		List<String> actDeliveryMethodID = new ArrayList();
		List<String> actContractTypeID = new ArrayList();
		List<String> actYears = new ArrayList();
		List<String> actManaged = new ArrayList();
		List<String> actAction = new ArrayList();

		try {
			TestLog.log.info("find the row count");
			eleCount = driver.findElements(By.xpath("//*[contains(text(),'" + columnName + "')]")).size();

			System.out.println("Element count: " + eleCount);

			for (int i = 0; i < eleCount; i++) {
				TestLog.log.info("capture values");

				expEngagementID.add(driver.findElement(By.xpath("//*[contains(text(),'engagement_id')]")).getText());
				expEngagementName
						.add(driver.findElement(By.xpath("//*[contains(text(),'engagement_name')]")).getText());
				expAccountID.add(driver.findElement(By.xpath("//*[contains(text(),'account_id')]")).getText());
				expDeliveryMethodID
						.add(driver.findElement(By.xpath("//*[contains(text(),'delivery_method_id')]")).getText());
				expContractTypeID
						.add(driver.findElement(By.xpath("//*[contains(text(),'contract_type_id')]")).getText());
				expYears.add(driver.findElement(By.xpath("//*[contains(text(),'years')]")).getText());
				expManaged.add(driver.findElement(By.xpath("//*[contains(text(),'managed')]")).getText());
				expAction.add(driver.findElement(By.xpath("//*[contains(text(),'action')]")).getText());

				actEngagementID.add(driver.findElement(By.xpath("//*[contains(text(),'engagement_id')]")).getText());
				actEngagementName
						.add(driver.findElement(By.xpath("//*[contains(text(),'engagement_name')]")).getText());
				actAccountID.add(driver.findElement(By.xpath("//*[contains(text(),'account_id')]")).getText());
				actDeliveryMethodID
						.add(driver.findElement(By.xpath("//*[contains(text(),'delivery_method_id')]")).getText());
				actContractTypeID
						.add(driver.findElement(By.xpath("//*[contains(text(),'contract_type_id')]")).getText());
				actYears.add(driver.findElement(By.xpath("//*[contains(text(),'years')]")).getText());
				actManaged.add(driver.findElement(By.xpath("//*[contains(text(),'managed')]")).getText());
				actAction.add(driver.findElement(By.xpath("//*[contains(text(),'action')]")).getText());

			}
			TestLog.log.info("sort according to the coloms");
			if (columnName == "engagement_id") {
				Collections.sort(expEngagementID);

				for (int i = 0; i < expEngagementID.size(); i++) {

					if (!(expEngagementID.get(i).equals(actEngagementID.get(i)))) {
						System.out.println("Coloum not sorted: " + i);
						break;

					} else {
						System.out.println("expected value: " + expEngagementID + "actual value:" + actEngagementID);
					}
				}

			} else if (columnName == "engagement_name") {
				Collections.sort(expEngagementName);

				for (int j = 0; j < expEngagementName.size(); j++) {

					if (!(expEngagementName.get(j).equals(actEngagementName.get(j)))) {
						System.out.println("Coloum not sorted: " + j);
						break;

					} else {
						System.out
								.println("expected value: " + expEngagementName + "actual value:" + actEngagementName);
					}
				}
			} else if (columnName == "account_id") {

				Collections.sort(expAccountID);

				for (int k = 0; k < expAccountID.size(); k++) {

					if (!(expAccountID.get(k).equals(actAccountID.get(k)))) {
						System.out.println("Coloum not sorted: " + k);
						break;

					} else {
						System.out.println("expected value: " + expAccountID + "actual value:" + actAccountID);
					}
				}
			} else if (columnName == "delivery_method_id") {
				Collections.sort(expDeliveryMethodID);

				for (int l = 0; l < expDeliveryMethodID.size(); l++) {

					if (!(expDeliveryMethodID.get(l).equals(actDeliveryMethodID.get(l)))) {
						System.out.println("Coloum not sorted: " + l);
						break;

					} else {
						System.out.println(
								"expected value: " + expDeliveryMethodID + "actual value:" + actDeliveryMethodID);
					}
				}
			} else if (columnName == "contract_type_id") {
				Collections.sort(expContractTypeID);

				for (int m = 0; m < expContractTypeID.size(); m++) {

					if (!(expContractTypeID.get(m).equals(actContractTypeID.get(m)))) {
						System.out.println("Coloum not sorted: " + m);
						break;

					} else {

						System.out
								.println("expected value: " + expContractTypeID + "actual value:" + actContractTypeID);
					}
				}
			} else if (columnName == "years") {
				Collections.sort(expYears);

				for (int l = 0; l < expYears.size(); l++) {

					if (!(expYears.get(l).equals(actYears.get(l)))) {
						System.out.println("Coloum not sorted: " + l);
						break;

					} else {
						System.out.println("expected value: " + expYears + "actual value:" + actYears);
					}
				}
			} else if (columnName == "managed") {
				Collections.sort(expManaged);

				for (int l = 0; l < expManaged.size(); l++) {

					if (!(expManaged.get(l).equals(actManaged.get(l)))) {
						System.out.println("Coloum not sorted: " + l);
						break;

					} else {
						System.out.println("expected value: " + expManaged + "actual value:" + actManaged);
					}
				}
			} if (columnName == "action") {
				Collections.sort(expAction);

				for (int l = 0; l < expAction.size(); l++) {

					if (!(expAction.get(l).equals(actAction.get(l)))) {
						System.out.println("Coloum not sorted: " + l);
						break;

					} else {
						System.out.println("expected value: " + expAction + "actual value:" + actAction);
					}
				}
			}else {
				System.out.println("Coloum not sorted ");

			}

		} catch (Exception ex) {
			TestLog.log.info("Coloum not sorted:" + ex);
		}
	}

	
	// method for delete a record
	public void selectDelete() {
		try {
			TestLog.log.info("delete the record");
			btnDelete.click();
			System.out.println("btnDelete is clicked");
			TestLog.log.info("record will delete from the database");
		} catch (Exception ex) {

		}
	}

	// methods for confirm deletion
	public void clickOkay() {
		try {
			TestLog.log.info("select cancel");
			btnOkay.click();
			System.out.println("btnOkay is clicked");
			TestLog.log.info("add new engagement will cancel");

		} catch (Exception ex) {
			TestLog.log.info("Error clicking cancel" + ex);
		}
	}

	public void clickClose() {
		try {
			TestLog.log.info("select submit");
			btnClose.click();
			TestLog.log.info("add new engagement will submit");

		} catch (Exception ex) {
			TestLog.log.info("Error clicking submit" + ex);
		}
	}

	// method for verifying delete confirm message
	public boolean verifyDelete(String lblExpectedTitle) {

		boolean flag = false;

		String popupMessageName = msgDelete.getText();
		if (popupMessageName.contains(lblExpectedTitle)) {
			System.out.println("Navigated to Confirm Delete message " + popupMessageName);
			flag = true;
		} else {
			System.out.println("Not Navigated to Confirm Delete message");
			flag = false;
		}
		return flag;

	}

	// method for verify the record has deleted from the table
	public boolean verifyDeleteRecordHasDeleted(String recordIn) {
		boolean flag = true;
		WebElement tableRecord = driver.findElement(By.xpath("//tbody"));
		List<WebElement> tableRow = tableRecord.findElements(By.tagName("tr"));

		outerloop: {
			for (int i = 0; i < tableRow.size(); i++) {
				WebElement row = tableRow.get(i);

				List<WebElement> tableColumn = row.findElements(By.xpath("//td[1]"));

				for (int j = 0; j < tableColumn.size(); j++) {
					WebElement data = tableColumn.get(j);

					String record = data.getText();
					if (record.contains(recordIn)) {
						System.out.println("not deleted");
						flag = false;
						break outerloop;
					} else {
						System.out.println("deleted");
						break;
					}

				}
			}
		}
		return flag;

	}

	// verify search result is not in there

	public boolean verifyEmptySearch(String emptySearch) {
		boolean flag = false;

		String rowDetails = rowDetail.getText();
		if (rowDetails.contains(emptySearch)) {
			System.out.println("There are no matching records in the table" + rowDetails);
			flag = true;
		} else {
			System.out.println("matching records are there, error");
			flag = false;
		}
		return flag;
	}
	
	// select the table entry count from the drop down using excel data
	WebDriverWait wait = new WebDriverWait(driver, 10);
		
		public void selectDropDown2(String dropDownValue) {
			try {
				Select dropSelectShowEntry = new Select(drpdwnShowEntry);
				wait.until(ExpectedConditions.visibilityOf(drpdwnShowEntry));
				TestLog.log.info("Selecting an entry");
				dropSelectShowEntry.selectByVisibleText(dropDownValue);
				TestLog.log.info("Selected " + dropDownValue + " from the drop down");
			} catch (Exception ex) {
				TestLog.log.info("Unable to select an entry. Due to: " + ex);
			}
		}
}
