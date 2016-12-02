package com.glance.pageobjects.dashboard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

	@FindBy(xpath = "//input[@type='search']")
	WebElement txtSearch;

	@FindBy(xpath = "//a[@id='dataTable_first']")
	WebElement btnFirst;

	@FindBy(xpath = "//a[@id='dataTable_previous']")
	WebElement btnPrevious;

	@FindBy(xpath = "//a[@id='dataTable_next']")
	WebElement btnNext;

	@FindBy(xpath = "//a[@id='dataTable_last']")
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

	// methods for one by one selection
	By dropDownShowEntryValue = By
			.xpath("//div[@id='searchTable_length']/label/select[@name='searchTable_length']/option");

	public void selectValue(String inputShowEntry) {

		List<WebElement> showEntryList = driver.findElements(dropDownShowEntryValue);

		for (WebElement showEntry : showEntryList) {
			String selectShowEntry = showEntry.getText();
			if (selectShowEntry.contains(inputShowEntry)) {
				showEntry.click();
				break;
			} else {
				System.out.println("Error selecting show entry");
			}
		}
	}

	public void enterSearch(String txtSerachValue) {
		try {
			TestLog.log.info("enter value in the search text field");
			txtSearch.sendKeys(txtSerachValue);

			TestLog.log.info("AVA record will appear in the table");
		} catch (Exception ex) {

		}
	}
	//**********************************************
		// Page Navigation - First page
			public void firstPageNavigation() {

				try {
					TestLog.log.info("Check First Button eneble");
					if (btnFirst.isEnabled()) {
						btnFirst.click();
						System.out.println("BtnFirst is clicked");
					} else {
						System.out.println("BtnFirst is not clicked");
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
						btnPrevious.click();
						System.out.println("BtnPrevious is clicked");
					} else {
						System.out.println("BtnPrevious is not clicked");
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
						btnNext.click();
						System.out.println("BtnNext is clicked");
					} else {
						System.out.println("BtnNext is not clicked");
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
						btnLast.click();
						System.out.println("Btnlast is clicked");
					} else {
						System.out.println("Btnlast is not clicked");
					}
				} catch (Exception ex) {
					TestLog.log.info("Could not find page Navigation button" + ex);
				}
			}

			// Page navigation - Middle Pages
			By middlePagination = By.xpath("//div[@id='searchTable_paginate']/span/a");
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

		//**********************************************
	
	public void selectDelete() {
		try {
			TestLog.log.info("delete the record");
			btnDelete.click();

			TestLog.log.info("record will delete from the database");
		} catch (Exception ex) {

		}
	}
	//**********************************************
	
		// methods for confirm deletion
		public void clickOkay() {
			try {
				TestLog.log.info("select cancel");
				btnOkay.click();
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
		
		//method for verify the record has deleted from the table
		public boolean verifyDeleteRecordHasDeleted(String recordIn){
			boolean flag = true;
			WebElement tableRecord = driver.findElement(By.xpath("//tbody"));
			List<WebElement> tableRow = tableRecord.findElements(By.tagName("tr"));
			
		     outerloop: {
			for(int i=0; i<tableRow.size(); i++){
				WebElement row = tableRow.get(i);
				
				List<WebElement> tableColumn = row.findElements(By.xpath("//td[1]"));
				
				for(int j=0; j<tableColumn.size(); j++){
					WebElement data = tableColumn.get(j);
					
					String record = data.getText();
					if(record.contains(recordIn)){
						System.out.println("deleted");
						flag = false;
						break outerloop;
					}else{
						System.out.println("not deleted");
					}
					
				}
			}
			}
			return flag;

		}

		
		//verify delete
	    public boolean verifyDeleted(String userin){
	     boolean flag = true;

	     WebElement tblUser = driver.findElement(By.xpath("//tbody"));
	     List<WebElement> tblRow = tblUser.findElements(By.tagName("tr"));

	     outerloop: {
	            for (WebElement row : tblRow) {

	                  List<WebElement> tblData = row.findElements(By.xpath("//td[1]"));

	                  for (WebElement data : tblData) {

	                         String userName = data.getText();
	                         //System.out.println(userName);
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


		//*********************************************
}
