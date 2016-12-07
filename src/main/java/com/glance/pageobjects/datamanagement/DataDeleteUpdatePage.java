
package com.glance.pageobjects.datamanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class DataDeleteUpdatePage extends BasePage {

	public DataDeleteUpdatePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//div[@class='x_title']/h2")
	WebElement lblPageName;

	@FindBy(id = "table_id")
	WebElement drpSelectDataTable;

	@FindBy(xpath = "//button[@id='submit']")
	WebElement btnSubmit;

	@FindBy(xpath = "//button[@id='updateButton']")
	WebElement btnUpdate;

	@FindBy(xpath = "//button[@id='deleteButton']")
	WebElement btnDelete;

	@FindBy(xpath = "//span[@class='title']")
	WebElement deleteConfirmationMessage;

	@FindBy(xpath = "//span[@class='title']")
	WebElement updateConfirmationMessage;

	@FindBy(xpath = "//body/div[6]/div[2]/div/div/div/div/div[4]/button[1]")
	WebElement btnDeleteOkay;

	@FindBy(xpath = "//body/div[6]/div[2]/div/div/div/div/div[4]/button[2]")
	WebElement btnDeleteClose;

	@FindBy(xpath = "//button[@class='btn btn-warning']")
	WebElement btnUpdateOkay;

	@FindBy(xpath = "//button[@class='btn btn-default']")
	WebElement btnUpdateClose;

	@FindBy(xpath = "//div[@class='content']")
	WebElement errorMessage;

	@FindBy(xpath = "//button[@class='btn btn-default']")
	WebElement btnOkay;

	@FindBy(xpath = "//i[@class='fa fa-chevron-up']")
	WebElement clickCollapse;

	@FindBy(xpath = "//i[@class='fa fa-close']")
	WebElement clickClose;

	@FindBy(xpath = "//a[@id='data_table_first']")
	WebElement btnFirst;

	@FindBy(xpath = "//a[@id='data_table_previous']")
	WebElement btnPrevious;

	@FindBy(xpath = "//a[@id='data_table_next']")
	WebElement btnNext;

	@FindBy(xpath = "//a[@id='data_table_last']")
	WebElement btnLast;

	@FindBy(xpath = "//select[@name='data_table_length']")
	WebElement dropDown;

	@FindBy(xpath = "//div[@id='data_table_info']")
	WebElement lblRecordCount;

	By middlePagination = By.xpath("//div[@id='example_paginate']/span/a");
	By txtSearch = By.xpath("//label/input");
	By tblExample = By.xpath("//table[@id='example']");

	// add data delete update page confirmation
	public boolean verifyNavigationToDataDeleteUpdatePage(String expectedMessage) {

		boolean flag;

		String actualMessage = lblPageName.getText();

		if (actualMessage.contains(expectedMessage)) {
			flag = true;
			System.out.println("You are in the delete update page");

		} else {
			System.out.println("You are not in the delete update page");
			flag = false;
		}

		return flag;
	}

	// selecting a table
	public void selectTable(String tableName) {

		try {

			TestLog.log.info("Select a table from drop down list");
			Select dropdown = new Select(drpSelectDataTable);
			dropdown.selectByVisibleText("cdi");
			TestLog.log.info("Selected a table from drop down list");
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

	// clicking update
	public void clickUpdate() {

		try {

			TestLog.log.info("Clicking update button");
			btnUpdate.click();
			TestLog.log.info("Clicked update button");
		}

		catch (Exception ex) {
			TestLog.log.info("Could not click update. " + ex);
		}
	}

	// update confirmation message
	public boolean verifyUpdateConfirmation(String expectedMessage) {

		boolean flag;

		String actualMessage = updateConfirmationMessage.getText();

		if (actualMessage.contains(expectedMessage)) {
			flag = true;
			System.out.println("You are in the delete update page");

		} else {
			System.out.println("You are not in the delete update page");
			flag = false;
		}

		return flag;
	}

	// clicking delete
	public void clickDelete(String userin) {

		try {

			TestLog.log.info("Clicking delete button");
			WebElement selectRow = driver.findElement(By.xpath("//td[text()='" + userin + "']/.."));
			selectRow.click();
			btnDelete.click();
			TestLog.log.info("Clicked delete button");
		}

		catch (Exception ex) {
			TestLog.log.info("Could not click delete. " + ex);
		}
	}

	// delete confirmation message
	public boolean verifydeleteConfirmationMessage(String expectedMessage) {

		boolean flag = false;

		String actualMessage = deleteConfirmationMessage.getText();

		if (actualMessage.contains(expectedMessage)) {
			flag = true;
			System.out.println("You have deleted the record");

		} else {
			System.out.println("You have not deleted the record");
			flag = false;
		}

		return flag;
	}

	// delete confirmation click
	public void clickDeleteOkay() {

		btnDeleteOkay.click();
	}

	public void clickDeleteClose() {

		btnDeleteClose.click();
	}

	// error message
	public void errorMessage() {

		errorMessage.getText();
	}

	// error message accepted
	public void clickOkay() {

		btnOkay.click();
	}

	// clicking collapse
	public void clickCollapse() {

		try {

			TestLog.log.info("Clicking the collapse icon");
			clickCollapse.click();
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

	// verify delete
	public boolean verifyDeleted(String userin) {
		boolean flag = true;

		WebElement tblUser = driver.findElement(By.xpath("//tbody"));
		List<WebElement> tblRow = tblUser.findElements(By.tagName("tr"));

		outerloop: {
			for (WebElement row : tblRow) {

				List<WebElement> tblData = row.findElements(By.xpath("//td[1]"));

				for (WebElement data : tblData) {

					String userName = data.getText();
					// System.out.println(userName);
					if (userName.contains(userin)) {
						System.out.println("Deleted");
						flag = false;
						break outerloop;

					}
				}
			}
		}

		return flag;
	}

	// Page Navigation - First page
	public void firstPageNavigation() {

		try {
			TestLog.log.info("Check First Button eneble");
			if (btnFirst.isEnabled()) {
				TestLog.log.info("Click on First Button");
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
				TestLog.log.info("Click on Previous Button");
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
				TestLog.log.info("Click on Next Button");
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
				TestLog.log.info("Click on Last Button");
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

		} catch (Exception ex) {
			TestLog.log.info("Could not find dropdown" + ex);
		}
		return recordCount;
	}

	// select the table entry count from the drop down
	public void selectDropDuwn(String dropDownValue) {
		try {
			TestLog.log.info("check dropdown exist");
			if (dropDown.isDisplayed()) {
				TestLog.log.info("select from dropdown list");
				Select drpRecords = new Select(dropDown);
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

		Select visibleRecords = new Select(dropDown);

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

		} catch (Exception ex) {
			TestLog.log.info("Could not find table" + ex);
		}
		return actualRawCount;
	}

	// Page count verification - Expected page count
	public void verifyDroDownPageCount(int rowCount) {
		try {
			TestLog.log.info("verify selection");

			Select visibleRecords = new Select(dropDown);

			TestLog.log.info("get table row count");
			WebElement element = visibleRecords.getFirstSelectedOption();
			String selectedValue = element.getText();

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

	// sorting the table according to the colom

	public void tableSort(String colomName) {
		TestLog.log.info("sort according to the colom ");
		try {
			driver.findElement(By.xpath("//*[contains(text(),'" + colomName + "')]")).click();
		} catch (Exception ex) {
			TestLog.log.info("sorting fails" + ex);
		}
	}

	// verify sorting the table according to the colom

	public void verifyTableSort(String colomName) {
		TestLog.log.info("verification sort according to the colom ");

		int eleCount;
		List<String> expcdi_id = new ArrayList();
		List<String> explevel = new ArrayList();
		List<String> expentity_id = new ArrayList();
		List<String> expdate = new ArrayList();
		List<String> expcdi = new ArrayList();

		List<String> actcdi_id = new ArrayList();
		List<String> actlevel = new ArrayList();
		List<String> actentity_id = new ArrayList();
		List<String> actdate = new ArrayList();
		List<String> actcdi = new ArrayList();

		try {
			TestLog.log.info("find the row count");
			eleCount = driver.findElements(By.xpath("//*[contains(text(),'" + colomName + "')]")).size();

			System.out.println("Element count: " + eleCount);

			for (int i = 0; i < eleCount; i++) {
				TestLog.log.info("capture values");

				expcdi_id.add(driver.findElement(By.xpath("//*[contains(text(),'cdi_id')]")).getText());
				explevel.add(driver.findElement(By.xpath("//*[contains(text(),'level')]")).getText());
				expentity_id.add(driver.findElement(By.xpath("//*[contains(text(),'entity_id')]")).getText());
				expdate.add(driver.findElement(By.xpath("//*[contains(text(),'date')]")).getText());
				expcdi.add(driver.findElement(By.xpath("//*[contains(text(),'cdi')]")).getText());

				actcdi_id.add(driver.findElement(By.xpath("//*[contains(text(),'cdi_id')]")).getText());
				actlevel.add(driver.findElement(By.xpath("//*[contains(text(),'level')]")).getText());
				actentity_id.add(driver.findElement(By.xpath("//*[contains(text(),'entity_id')]")).getText());
				actdate.add(driver.findElement(By.xpath("//*[contains(text(),'date')]")).getText());
				actcdi.add(driver.findElement(By.xpath("//*[contains(text(),'cdi')]")).getText());

			}
			TestLog.log.info("sort according to the coloms");
			if (colomName == "cdi_id") {
				Collections.sort(expcdi_id);

				for (int i = 0; i < expcdi_id.size(); i++) {

					if (!(expcdi_id.get(i).equals(actcdi_id.get(i)))) {
						System.out.println("Coloum not sorted: " + i);
						break;

					} else {
						System.out.println("expected value: " + expcdi_id + "actual value:" + actcdi_id);
					}
				}
			} else if (colomName == "level") {
				Collections.sort(explevel);

				for (int j = 0; j < explevel.size(); j++) {

					if (!(explevel.get(j).equals(actlevel.get(j)))) {
						System.out.println("Coloum not sorted: " + j);
						break;

					} else {
						System.out.println("expected value: " + explevel + "actual value:" + actlevel);
					}
				}
			} else if (colomName == "entity_id") {

				Collections.sort(expentity_id);

				for (int k = 0; k < expentity_id.size(); k++) {

					if (!(expentity_id.get(k).equals(actentity_id.get(k)))) {
						System.out.println("Coloum not sorted: " + k);
						break;

					} else {
						System.out.println("expected value: " + expentity_id + "actual value:" + actentity_id);
					}
				}
			} else if (colomName == "date") {
				Collections.sort(expdate);

				for (int l = 0; l < expdate.size(); l++) {

					if (!(expdate.get(l).equals(actdate.get(l)))) {
						System.out.println("Coloum not sorted: " + l);
						break;

					} else {
						System.out.println("expected value: " + expdate + "actual value:" + actdate);
					}
				}
			}
			if (colomName == "cdi") {
				Collections.sort(expcdi);

				for (int m = 0; m < expcdi.size(); m++) {

					if (!(expcdi.get(m).equals(actcdi.get(m)))) {
						System.out.println("Coloum not sorted: " + m);
						break;

					} else {

						System.out.println("expected value: " + expcdi + "actual value:" + actcdi);
					}
				}
			} else {
				System.out.println("Coloum not sorted ");

			}

		} catch (Exception ex) {
			TestLog.log.info("Coloum not sorted:" + ex);
		}
	}
}
