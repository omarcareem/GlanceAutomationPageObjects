package com.glance.pageobjects.userlogin;

<<<<<<< HEAD
import org.openqa.selenium.JavascriptExecutor;
=======
import java.util.List;

import org.openqa.selenium.By;
>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
<<<<<<< HEAD
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
=======
>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class SettingsPage extends BasePage {

	public SettingsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

<<<<<<< HEAD
=======
	@FindBy(xpath = "//div[@id='main_body']/div/div[2]/div/div[1]/h2")
	WebElement lblSettingsDashboard;
	@FindBy(xpath = "//div[@id='main_body']/div/div[3]/div/div[1]/h2")
	WebElement lblSettingsData;
	@FindBy(xpath = "//div[@id='main_body']/div/div[4]/div/div[1]/h2")
	WebElement lblSettingsUser;
	@FindBy(xpath = "//div[@id='main_body']/div/div[5]/div/div[1]/h2")
	WebElement lblSettingsPersonalizations;
	@FindBy(xpath = "//div[@id='main_body']/div/div[6]/div/div[1]/h2")
	WebElement lblSettingsMaintenance;

>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7
	@FindBy(xpath = "//div/a/i[@class='fa fa-institution']")
	WebElement btnAddAccount;

	@FindBy(xpath = "//div/a/i[@class='fa fa-institution']/../span")
	WebElement countAddAccount;

	@FindBy(xpath = "//div/a/i[@class='fa fa-suitcase']")
	WebElement btnAddEngagement;

	@FindBy(xpath = "//div/a/i[@class='fa fa-suitcase']/../span")
	WebElement countAddEngagement;

	@FindBy(xpath = "//div/a/i[@class='fa fa-desktop']")
	WebElement btnAddProject;

	@FindBy(xpath = "//div/a/i[@class='fa fa-desktop']/../span")
	WebElement countAddProject;

	@FindBy(xpath = "//div/a/i[@class='fa fa-trash']")
	WebElement btnDeleteRecords;

	@FindBy(xpath = "//i[@class='fa fa-upload']")
	WebElement btnDataUpload;

	@FindBy(xpath = "//i[@class='fa fa-trash-o']")
	WebElement btnDataDeleteModify;

	@FindBy(xpath = "//i[@class='fa fa-plug']")
	WebElement btnSockets;

	@FindBy(xpath = "//i[@class='fa fa-plug']/../span")
	WebElement countSockets;

	@FindBy(xpath = "//div/a/i[@class='fa fa-user']")
	WebElement btnManageUsers;

	@FindBy(xpath = "//div/a/i[@class='fa fa-user']/../span")
	WebElement countManageUsers;

	@FindBy(xpath = "//div/a/i[@class='fa fa-group']")
	WebElement btnManageGroups;

	@FindBy(xpath = "//div/a/i[@class='fa fa-group']/../span")
	WebElement countManageGroups;

	@FindBy(xpath = "//div/a/i[@class='fa fa-star']")
	WebElement btnGroupMembership;

	@FindBy(xpath = "//div/a/i[@class='fa fa-key']")
	WebElement btnManageAccess;

	@FindBy(xpath = "//input[@value='cmonth']")
	WebElement RadioBtnCurrentMonth;

	@FindBy(xpath = "//input[@value='ldate']")
	WebElement RadioBtnLastSelected;

	@FindBy(xpath = "//input[@class='btn btn-success']")
	WebElement btnSave;

	@FindBy(xpath = "//button[@class='btn btn-info']")
	WebElement btnSaveOK;
<<<<<<< HEAD

	@FindBy(xpath = "//button[@class='btn btn-default']")
	WebElement btnSaveClose;

=======
	
>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7
	@FindBy(xpath = "//a[@class='btn btn-success']")
	WebElement btnProfileUpdate;

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement btnSessionDump;

	@FindBy(xpath = "//div[@id='session_dump']/pre/font[16]")
<<<<<<< HEAD
	WebElement SessionDumpUserId;

	@FindBy(xpath = "//div[@id='session_dump']/pre/font[18]")
	WebElement SessionDumpUserName;

	@FindBy(xpath = "//div[@id='session_dump']/pre/font[20]")
	WebElement SessionDumpFirstName;

	@FindBy(xpath = "//div[@id='session_dump']/pre/font[22]")
	WebElement SessionDumpLastName;

	WebDriverWait wait = new WebDriverWait(driver, 10);

	// Click on Add Account Button
	public void ClickAddAccountBtn() {
=======
	WebElement sessionDumpUserId;

	@FindBy(xpath = "//div[@id='session_dump']/pre/font[18]")
	WebElement sessionDumpUserName;

	@FindBy(xpath = "//div[@id='session_dump']/pre/font[20]")
	WebElement sessionDumpFirstName;

	@FindBy(xpath = "//div[@id='session_dump']/pre/font[22]")
	WebElement sessionDumpLastName;
	
	@FindBy(xpath = "//div[@class='x_title']/h2")
	String lblPageName;

	// Check settings page title
		public boolean verifyNavigationToSettingPage(String expectedMessage){
			boolean flag = false;
			System.out.println("Getting header");
			String actualMessage=lblSettingsDashboard.getText();
			System.out.println(actualMessage);
			if (actualMessage.contains(expectedMessage)) {
				flag = true;
				System.out.println("You are in the settings page");
				}
			else {
				System.out.println("You are not in the settings page");
				flag = false;
				}
			return flag;
			
			
		}

	// Click on Add Account Button
	public void clickAddAccountBtn() {
>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7

		try {
			TestLog.log.info("Clicking on Add Account Button");
			btnAddAccount.click();
			TestLog.log.info("Clicked on Add Account Button");

		} catch (Exception ex) {
			TestLog.log
					.info("Could not Click on the Add Account button. " + ex);

		}

	}

	// Get Count of Account
<<<<<<< HEAD
	public int GetCountAddAccount() {
=======
	public int getCountAddAccount() {
>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7
		String Count = null;
		try {
			TestLog.log.info("Getting the Count Of total Accounts");
			Count = countAddAccount.getText();
			TestLog.log.info("Got the Count Of total Accounts");

		} catch (Exception ex) {
			TestLog.log
					.info("Could not get the Count Of total Accounts. " + ex);

		}
		return (Integer.parseInt(Count));

	}

	// Click on Add Engagement Button
<<<<<<< HEAD
	public void ClickAddEngagementBtn() {
=======
	public void clickAddEngagementBtn() {
>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7

		try {
			TestLog.log.info("Clicking on Add Engagement Button");
			btnAddEngagement.click();
			TestLog.log.info("Clicked on Add Engagement Button");

		} catch (Exception ex) {
			TestLog.log.info("Could not Click on the Add Engagement button. "
					+ ex);

		}

	}

	// Get Count of Engagement
<<<<<<< HEAD
	public int GetCountAddEngagement() {
=======
	public int getCountAddEngagement() {
>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7
		String Count = null;
		try {
			TestLog.log.info("Getting the Count Of total Engagements");
			Count = countAddEngagement.getText();
			TestLog.log.info("Got the Count Of total Engagements");

		} catch (Exception ex) {
			TestLog.log.info("Could not get the Count Of total Engagements. "
					+ ex);

		}
		return (Integer.parseInt(Count));

	}
<<<<<<< HEAD

	// Click on Add Project Button
	public void ClickAddProjectBtn() {

		try {
			TestLog.log.info("Clicking on Add Project Button");
			btnAddProject.click();
			TestLog.log.info("Clicked on Add Project Button");
=======
	// method for verifying add engagement count ************************
			public boolean verifyEngagementCount(int previousCountEngagement, int newCountEngagement) {

				boolean flag = false;

				if (previousCountEngagement < newCountEngagement) {
					System.out.println("new engagement is added " + previousCountEngagement + "and" + newCountEngagement);
					flag = true;
				} else {
					System.out.println("new engagement is not added");
					flag = false;
				}
				return flag;

			}

			// method for verifying settings page ************************
			public boolean verifyPageName(String[] expected) {

				List<WebElement> pageNames = driver.findElements(By.xpath(lblPageName));

				if (expected.length != pageNames.size()) {
					System.out.println("fail, wrong number of elements found");
				}

				for (int i = 0; i < expected.length; i++) {
					String optionValue = pageNames.get(i).getAttribute("h2");
					if (optionValue.equals(expected[i])) {
						System.out.println("passed on: " + optionValue);
					} else {
						System.out.println("failed on: " + optionValue);
					}
				}
				return false;

			}


	// Click on Add Project Button
	public void clickAddProjectBtn() {

		try {
			TestLog.log.info("Clicking on Add Project Button");
			if (btnAddProject.isDisplayed()) {
				btnAddProject.click();
				TestLog.log.info("Clicked on Add Project Button");
			}
>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7

		} catch (Exception ex) {
			TestLog.log
					.info("Could not Click on the Add Project button. " + ex);

		}

	}

	// Get Count of Project
<<<<<<< HEAD
	public int GetCountAddProject() {
=======
	public int getCountAddProject() {
>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7
		String Count = null;
		try {
			TestLog.log.info("Getting the Count Of total Projects");
			Count = countAddProject.getText();
			TestLog.log.info("Got the Count Of total Projects");

		} catch (Exception ex) {
			TestLog.log
					.info("Could not get the Count Of total Projects. " + ex);

		}
		return (Integer.parseInt(Count));

	}

	// Click on Delete Records Button
<<<<<<< HEAD
	public void ClickDeleteRecordsBtn() {
=======
	public void clickDeleteRecordsBtn() {
>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7

		try {
			TestLog.log.info("Clicking on Delete Records Button");
			btnDeleteRecords.click();
			TestLog.log.info("Clicked on Delete Records Button");

		} catch (Exception ex) {
			TestLog.log.info("Could not Click on the Delete Records button. "
					+ ex);

		}

	}

	// Click on Data Upload Button
<<<<<<< HEAD
	public void ClickDataUploadBtn() {
=======
	public void clickDataUploadBtn() {
>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7

		try {
			TestLog.log.info("Clicking on Data Upload Button");
			btnDataUpload.click();
			TestLog.log.info("Clicked on Data Upload Button");

		} catch (Exception ex) {
			TestLog.log
					.info("Could not Click on the Data Upload button. " + ex);

		}

	}

	// Click on Data Delete/Modify Button
<<<<<<< HEAD
	public void ClickDataDeleteModifyBtn() {
=======
	public void clickDataDeleteModifyBtn() {
>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7

		try {
			TestLog.log.info("Clicking on Data Delete/Modify Button");
			btnDataDeleteModify.click();
			TestLog.log.info("Clicked on Data Delete/Modify Button");

		} catch (Exception ex) {
			TestLog.log
					.info("Could not Click on the Data Delete/Modify button. "
							+ ex);

		}

	}

	// Click on Sockets Button
<<<<<<< HEAD
	public void ClickSocketsBtn() {
=======
	public void clickSocketsBtn() {
>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7

		try {
			TestLog.log.info("Clicking on Sockets Button");
			btnSockets.click();
			TestLog.log.info("Clicked on Sockets Button");

		} catch (Exception ex) {
			TestLog.log.info("Could not Click on the Sockets button. " + ex);

		}

	}

	// Get Count of Sockets
<<<<<<< HEAD
	public int GetCountSockets() {
=======
	public int getCountSockets() {
>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7
		String Count = null;
		try {
			TestLog.log.info("Getting the Count Of total Sockets");
			Count = countSockets.getText();
			TestLog.log.info("Got the Count Of total Sockets");

		} catch (Exception ex) {
			TestLog.log.info("Could not get the Count Of total Sockets. " + ex);

		}
		return (Integer.parseInt(Count));

	}

	// Click on Manage Users Button
<<<<<<< HEAD
	public void ClickManageUsersBtn() {

		try {
			TestLog.log.info("Clicking on Manage Users Button");
			//wait.until(ExpectedConditions.visibilityOf(btnManageUsers));
			wait.until(ExpectedConditions.elementToBeClickable(btnManageUsers));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", btnManageUsers);
			//btnManageUsers.click();
=======
	public void clickManageUsersBtn() {

		try {
			TestLog.log.info("Clicking on Manage Users Button");
			btnManageUsers.click();
>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7
			TestLog.log.info("Clicked on Manage Users Button");

		} catch (Exception ex) {
			TestLog.log.info("Could not Click on the Manage Users button. "
					+ ex);

		}

	}

	// Get Count of Manage Users
<<<<<<< HEAD
	public int GetCountManageUsers() {
=======
	public int getCountManageUsers() {
>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7
		String Count = null;
		try {
			TestLog.log.info("Getting the Count Of total Manage Users");
			Count = countManageUsers.getText();
			TestLog.log.info("Got the Count Of total Manage Users");

		} catch (Exception ex) {
			TestLog.log.info("Could not get the Count Of total Manage Users. "
					+ ex);

		}
		return (Integer.parseInt(Count));

	}

	// Click on Manage Groups Button
<<<<<<< HEAD
	public void ClickManageGroupsBtn() {
=======
	public void clickManageGroupsBtn() {
>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7

		try {
			TestLog.log.info("Clicking on Manage Groups Button");
			btnManageGroups.click();
			TestLog.log.info("Clicked on Manage Groups Button");

		} catch (Exception ex) {
			TestLog.log.info("Could not Click on the Manage Groups button. "
					+ ex);

		}

	}

	// Get Count of Manage Groups
<<<<<<< HEAD
	public int GetCountManageGroups() {
=======
	public int getCountManageGroups() {
>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7
		String Count = null;
		try {
			TestLog.log.info("Getting the Count Of total Manage Groups");
			Count = countManageGroups.getText();
			TestLog.log.info("Got the Count Of total Manage Groups");

		} catch (Exception ex) {
			TestLog.log.info("Could not get the Count Of total Manage Groups. "
					+ ex);

		}
		return (Integer.parseInt(Count));

	}

	// Click on Group Membership Button
<<<<<<< HEAD
	public void ClickGroupMembershipBtn() {
=======
	public void clickGroupMembershipBtn() {
>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7

		try {
			TestLog.log.info("Clicking on Group Membership Button");
			btnGroupMembership.click();
			TestLog.log.info("Clicked on Group Membership Button");

		} catch (Exception ex) {
			TestLog.log.info("Could not Click on the Group Membership button. "
					+ ex);

		}

	}

	// Click on Manage Access Button
<<<<<<< HEAD
	public void ClickManageAccessBtn() {
=======
	public void clickManageAccessBtn() {
>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7

		try {
			TestLog.log.info("Clicking on Manage Access Button");
			btnManageAccess.click();
			TestLog.log.info("Clicked on Manage Access Button");

		} catch (Exception ex) {
			TestLog.log.info("Could not Click on the Manage Access button. "
					+ ex);

		}

	}

	// Click on Current Month Radio Button
<<<<<<< HEAD
	public void ClickCurrentMonthRadioBtn() {
=======
	public void clickCurrentMonthRadioBtn() {
>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7

		try {
			TestLog.log.info("Clicking on Current Month Radio Button");
			RadioBtnCurrentMonth.click();
			TestLog.log.info("Clicked on Current Month Radio Button");

		} catch (Exception ex) {
			TestLog.log
					.info("Could not Click on the Current Month Radio Button. "
							+ ex);

		}

	}

	// Click on Last Selected Radio Button
<<<<<<< HEAD
	public void ClickLastSelectedRadioBtn() {
=======
	public void clickLastSelectedRadioBtn() {
>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7

		try {
			TestLog.log.info("Clicking on Last Selected Radio Button");
			RadioBtnLastSelected.click();
			TestLog.log.info("Clicked on Last Selected Radio Button");

		} catch (Exception ex) {
			TestLog.log
					.info("Could not Click on the Last Selected Radio Button. "
							+ ex);

		}

	}

	// Click on Save Button
<<<<<<< HEAD
	public void ClickSaveBtn() {
=======
	public void clickSaveBtn() {
>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7

		try {
			TestLog.log.info("Clicking on Save Button");
			btnSave.click();
			TestLog.log.info("Clicked on Save Button");

		} catch (Exception ex) {
			TestLog.log.info("Could not Click on the Save Button. " + ex);

		}

	}

	// Click on Save Ok Button
<<<<<<< HEAD
	public void ClickSaveOKBtn() {
=======
	public void clickSaveOKBtn() {
>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7

		try {
			TestLog.log.info("Clicking on Save Ok Button");
			btnSaveOK.click();
			TestLog.log.info("Clicked on Save Ok Button");

		} catch (Exception ex) {
			TestLog.log.info("Could not Click on the Save Ok Button. " + ex);

		}

	}

<<<<<<< HEAD
	// Click on Save Close Button
	public void ClickSaveCloseBtn() {

		try {
			TestLog.log.info("Clicking on Save Close Button");
			btnSaveClose.click();
			TestLog.log.info("Clicked on Save Close Button");

		} catch (Exception ex) {
			TestLog.log.info("Could not Click on the Save Close Button. " + ex);

		}

	}

	// Click on Profile Update Button
	public void ClickProfileUpdateBtn() {
=======
	
	// Click on Profile Update Button
	public void clickProfileUpdateBtn() {
>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7

		try {
			TestLog.log.info("Clicking on Profile Update Button");
			btnProfileUpdate.click();
			TestLog.log.info("Clicked on Profile Update Button");

		} catch (Exception ex) {
			TestLog.log.info("Could not Click on the Profile Update Button. "
					+ ex);

		}

	}

	// Click on Session Dump Button
<<<<<<< HEAD
	public void ClickSessionDumpBtn() {
=======
	public void clickSessionDumpBtn() {
>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7

		try {
			TestLog.log.info("Clicking on Session Dump Button");
			btnSessionDump.click();
			TestLog.log.info("Clicked on Session Dump Button");

		} catch (Exception ex) {
			TestLog.log.info("Could not Click on the Session Dump Button. "
					+ ex);
		}

	}

<<<<<<< HEAD
	// Check on Session Dump User id
	public String CheckSessionDumpUserId() {
		String UserId = null;
		try {
			TestLog.log.info("Checking on Session Dump User Id");
			UserId = SessionDumpUserId.getText();
			TestLog.log.info("Checked on Session Dump User Id");

		} catch (Exception ex) {
			TestLog.log.info("Could not Check on the Session Dump User Id. "
					+ ex);
		}
		return UserId;

	}

	// Check on Session Dump User name
	public String CheckSessionDumpUserName() {
		String UserName = null;
		try {
			TestLog.log.info("Checking on Session Dump User Name");
			UserName = SessionDumpUserName.getText();
			TestLog.log.info("Checked on Session Dump User Name");

		} catch (Exception ex) {
			TestLog.log.info("Could not Check on the Session Dump User Name. "
					+ ex);
		}
		return UserName;

	}

	// Check on Session Dump First name
	public String CheckSessionDumpFirstName() {
		String FirstName = null;
		try {
			TestLog.log.info("Checking on Session Dump First Name");
			FirstName = SessionDumpFirstName.getText();
			TestLog.log.info("Checked on Session Dump First Name");

		} catch (Exception ex) {
			TestLog.log.info("Could not Check on the Session Dump First Name. "
					+ ex);
		}
		return FirstName;

	}

	// Check on Session Dump Last name
	public String CheckSessionDumpLastName() {
		String LastName = null;
		try {
			TestLog.log.info("Checking on Session Dump Last Name");
			LastName = SessionDumpLastName.getText();
			TestLog.log.info("Checked on Session Dump Last Name");

		} catch (Exception ex) {
			TestLog.log.info("Could not Check on the Session Dump Last Name. "
					+ ex);
		}
		return LastName;

=======
	
	// Check on Session Dump User id
	public boolean checkSessionDumpUserId(String expectedMessageUserId){
		boolean flag = true;
		String actualMessage=sessionDumpUserId.getText();
		if (actualMessage.contains(expectedMessageUserId)) {
			flag = false;
			System.out.println("Checking on Session Dump User Id");
			}
		else {
			System.out.println("Checked on Session Dump User Id");
			flag = true;
			}
		
		return flag;
	}
	

	// Check on Session Dump User name
	public boolean checkSessionDumpUserName(String expectedMessageUserName){
		boolean flag = true;
		String actualMessage=sessionDumpUserName.getText();
		if (actualMessage.contains(expectedMessageUserName)) {
			flag = false;
			System.out.println("Checking on Session Dump User Name");
			}
		else {
			System.out.println("Checked on Session Dump User Name");
			flag = true;
			}
		
		return flag;
	}

	// Check on Session Dump First name
	public boolean checkSessionDumpFirstName(String expectedMessageFirstName){
		boolean flag = true;
		String actualMessage=sessionDumpFirstName.getText();
		if (actualMessage.contains(expectedMessageFirstName)) {
			flag = false;
			System.out.println("Checking on Session Dump FirstName");
			}
		else {
			System.out.println("Checked on Session Dump FirstName");
			flag = true;
			}
		
		return flag;
>>>>>>> 72f48efed32ada12e35b21552adaeb6d6cc7ebc7
	}

	// Check on Session Dump Last name
	public boolean checkSessionDumpLastName(String expectedMessageLastName){
		boolean flag = true;
		String actualMessage=sessionDumpLastName.getText();
		if (actualMessage.contains(expectedMessageLastName)) {
			flag = false;
			System.out.println("Checking on Session Dump LastName");
			}
		else {
			System.out.println("Checked on Session Dump LastName");
			flag = true;
			}
		
		return flag;
	}
}
