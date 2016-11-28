package com.glance.pageobjects.userlogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class SettingsPage extends BasePage {

	public SettingsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath = "//div[@id='main_body']/div/div[2]/div/div[1]/h2")
    WebElement lblSettingsDashboard;
	
	@FindBy(xpath="//div/a/i[@class='fa fa-institution']")
	WebElement btnAddAccount;
	
	@FindBy(xpath="//div/a/i[@class='fa fa-institution']/../span")
	WebElement countAddAccount;
	
	@FindBy(xpath="//div/a/i[@class='fa fa-suitcase']")
	WebElement btnAddEngagement;
	
	@FindBy(xpath="//div/a/i[@class='fa fa-suitcase']/../span")
	WebElement countAddEngagement;
	
	
	@FindBy(xpath="//div/a/i[@class='fa fa-desktop']")
	WebElement btnAddProject;
	
	@FindBy(xpath="//div/a/i[@class='fa fa-desktop']/../span")
	WebElement countAddProject;
	
	@FindBy(xpath="//div/a/i[@class='fa fa-trash']")
	WebElement btnDeleteRecords;
	
	
		
	
	
	@FindBy(xpath="//i[@class='fa fa-upload']")
	WebElement btnDataUpload;
	

	@FindBy(xpath="//i[@class='fa fa-trash-o']")
	WebElement btnDataDeleteModify;
	
	@FindBy(xpath="//i[@class='fa fa-plug']")
	WebElement btnSockets;
	
	@FindBy(xpath="//i[@class='fa fa-plug']/../span")
	WebElement countSockets;
	
	
	
	
	@FindBy(xpath="//div/a/i[@class='fa fa-user']")
	WebElement btnManageUsers;
	
	@FindBy(xpath="//div/a/i[@class='fa fa-user']/../span")
	WebElement countManageUsers;
	
	@FindBy(xpath="//div/a/i[@class='fa fa-group']")
	WebElement btnManageGroups;
	
	@FindBy(xpath="//div/a/i[@class='fa fa-group']/../span")
	WebElement countManageGroups;
	
	@FindBy(xpath="//div/a/i[@class='fa fa-star']")
	WebElement btnGroupMembership;
	
	@FindBy(xpath="//div/a/i[@class='fa fa-key']")
	WebElement btnManageAccess;
	
	
	@FindBy(xpath="//input[@value='cmonth']")
	WebElement RadioBtnCurrentMonth;
	
	@FindBy(xpath="//input[@value='ldate']")
	WebElement RadioBtnLastSelected;
	
	@FindBy(xpath="//input[@class='btn btn-success']")
	WebElement btnSave;
	
	@FindBy(xpath ="//button[@class='btn btn-info']")
	WebElement btnSaveOK;
	
	@FindBy(xpath ="//button[@class='btn btn-default']")
	WebElement btnSaveClose;
	
	@FindBy(xpath="//a[@class='btn btn-success']")
	WebElement btnProfileUpdate;
	
	
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement btnSessionDump;
	
	@FindBy(xpath="//div[@id='session_dump']/pre/font[16]")
	WebElement SessionDumpUserId;
	
	@FindBy(xpath="//div[@id='session_dump']/pre/font[18]")
	WebElement SessionDumpUserName;
	
	@FindBy(xpath="//div[@id='session_dump']/pre/font[20]")
	WebElement SessionDumpFirstName;
	
	@FindBy(xpath="//div[@id='session_dump']/pre/font[22]")
	WebElement SessionDumpLastName;

	
	// Check settings page title
    public boolean verifyNavigationToSettingPage(String expectedMessage){
           boolean flag = false;
           String actualMessage=lblSettingsDashboard.getText();
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


	//Click on Add Account Button
		public void clickAddAccountBtn(){
			
			try{
				TestLog.log.info("Clicking on Add Account Button");
				btnAddAccount.click();
				TestLog.log.info("Clicked on Add Account Button");
				
				}catch(Exception ex){
					TestLog.log.info("Could not Click on the Add Account button. "+ex);
				
				}
			
			}
	//Get Count of Account 
				public int getCountAddAccount(){
					String Count=null;
					try{
						TestLog.log.info("Getting the Count Of total Accounts");
						Count=countAddAccount.getText();
						TestLog.log.info("Got the Count Of total Accounts");
						
						}catch(Exception ex){
							TestLog.log.info("Could not get the Count Of total Accounts. "+ex);
						
						}
					return (Integer.parseInt(Count));
					
					
					}	
	

	//Click on Add Engagement Button
		public void clickAddEngagementBtn(){
			
			try{
				TestLog.log.info("Clicking on Add Engagement Button");
				btnAddEngagement.click();
				TestLog.log.info("Clicked on Add Engagement Button");
				
				}catch(Exception ex){
					TestLog.log.info("Could not Click on the Add Engagement button. "+ex);
				
				}
			
			}
		
	//Get Count of Engagement 
		public int getCountAddEngagement(){
			String Count=null;
			try{
				TestLog.log.info("Getting the Count Of total Engagements");
				Count=countAddEngagement.getText();
				TestLog.log.info("Got the Count Of total Engagements");
				
				}catch(Exception ex){
					TestLog.log.info("Could not get the Count Of total Engagements. "+ex);
				
				}
			return (Integer.parseInt(Count));
			
			
			}		

	//Click on Add Project Button
		public void clickAddProjectBtn(){
			
			try{
				TestLog.log.info("Clicking on Add Project Button");
				btnAddProject.click();
				TestLog.log.info("Clicked on Add Project Button");
				
				}catch(Exception ex){
					TestLog.log.info("Could not Click on the Add Project button. "+ex);
				
				}
			
			}

	//Get Count of Project 
		public int getCountAddProject(){
			String Count=null;
			try{
				TestLog.log.info("Getting the Count Of total Projects");
				Count=countAddProject.getText();
				TestLog.log.info("Got the Count Of total Projects");
				
				}catch(Exception ex){
					TestLog.log.info("Could not get the Count Of total Projects. "+ex);
				
				}
			return (Integer.parseInt(Count));
			
			
			}	
				
	
	//Click on Delete Records Button
		public void clickDeleteRecordsBtn(){
			
			try{
				TestLog.log.info("Clicking on Delete Records Button");
				btnDeleteRecords.click();
				TestLog.log.info("Clicked on Delete Records Button");
				
				}catch(Exception ex){
					TestLog.log.info("Could not Click on the Delete Records button. "+ex);
				
				}
			
			}	
	
	//Click on Data Upload Button
		public void clickDataUploadBtn(){
			
			try{
				TestLog.log.info("Clicking on Data Upload Button");
				btnDataUpload.click();
				TestLog.log.info("Clicked on Data Upload Button");
				
				}catch(Exception ex){
					TestLog.log.info("Could not Click on the Data Upload button. "+ex);
				
				}
			
			}	
	
	//Click on Data Delete/Modify Button
		public void clickDataDeleteModifyBtn(){
			
			try{
				TestLog.log.info("Clicking on Data Delete/Modify Button");
				btnDataDeleteModify.click();
				TestLog.log.info("Clicked on Data Delete/Modify Button");
				
				}catch(Exception ex){
					TestLog.log.info("Could not Click on the Data Delete/Modify button. "+ex);
				
				}
			
			}	
			
	//Click on Sockets Button
		public void clickSocketsBtn(){
			
			try{
				TestLog.log.info("Clicking on Sockets Button");
				btnSockets.click();
				TestLog.log.info("Clicked on Sockets Button");
				
				}catch(Exception ex){
					TestLog.log.info("Could not Click on the Sockets button. "+ex);
				
				}
			
			}		
		
	//Get Count of Sockets
		public int getCountSockets(){
			String Count=null;
			try{
				TestLog.log.info("Getting the Count Of total Sockets");
				Count=countSockets.getText();
				TestLog.log.info("Got the Count Of total Sockets");
				
				}catch(Exception ex){
					TestLog.log.info("Could not get the Count Of total Sockets. "+ex);
				
				}
			return (Integer.parseInt(Count));
			
			
			}	
	
		
	//Click on Manage Users Button
		public void clickManageUsersBtn(){
			
			try{
				TestLog.log.info("Clicking on Manage Users Button");
				btnManageUsers.click();
				TestLog.log.info("Clicked on Manage Users Button");
				
				}catch(Exception ex){
					TestLog.log.info("Could not Click on the Manage Users button. "+ex);
				
				}
			
			}	
		
	//Get Count of Manage Users
		public int getCountManageUsers(){
			String Count=null;
			try{
				TestLog.log.info("Getting the Count Of total Manage Users");
				Count=countManageUsers.getText();
				TestLog.log.info("Got the Count Of total Manage Users");
				
				}catch(Exception ex){
					TestLog.log.info("Could not get the Count Of total Manage Users. "+ex);
				
				}
			return (Integer.parseInt(Count));
			
			
			}	
	
	//Click on Manage Groups Button
		public void clickManageGroupsBtn(){
			
			try{
				TestLog.log.info("Clicking on Manage Groups Button");
				btnManageGroups.click();
				TestLog.log.info("Clicked on Manage Groups Button");
				
				}catch(Exception ex){
					TestLog.log.info("Could not Click on the Manage Groups button. "+ex);
				
				}
			
			}	
	
	//Get Count of Manage Groups
		public int getCountManageGroups(){
			String Count=null;
			try{
				TestLog.log.info("Getting the Count Of total Manage Groups");
				Count=countManageGroups.getText();
				TestLog.log.info("Got the Count Of total Manage Groups");
				
				}catch(Exception ex){
					TestLog.log.info("Could not get the Count Of total Manage Groups. "+ex);
				
				}
			return (Integer.parseInt(Count));
			
			
			}	
		
	//Click on Group Membership Button
		public void clickGroupMembershipBtn(){
			
			try{
				TestLog.log.info("Clicking on Group Membership Button");
				btnGroupMembership.click();
				TestLog.log.info("Clicked on Group Membership Button");
				
				}catch(Exception ex){
					TestLog.log.info("Could not Click on the Group Membership button. "+ex);
				
				}
			
			}			
		
	//Click on Manage Access Button
		public void clickManageAccessBtn(){
			
			try{
				TestLog.log.info("Clicking on Manage Access Button");
				btnManageAccess.click();
				TestLog.log.info("Clicked on Manage Access Button");
				
				}catch(Exception ex){
					TestLog.log.info("Could not Click on the Manage Access button. "+ex);
				
				}
			
			}	
		
	//Click on Current Month Radio Button
		public void clickCurrentMonthRadioBtn(){
					
			try{
				TestLog.log.info("Clicking on Current Month Radio Button");
				RadioBtnCurrentMonth.click();
				TestLog.log.info("Clicked on Current Month Radio Button");
						
				}catch(Exception ex){
					TestLog.log.info("Could not Click on the Current Month Radio Button. "+ex);
						
				}
					
			}	
	//Click on Last Selected Radio Button
		public void clickLastSelectedRadioBtn(){
					
			try{
				TestLog.log.info("Clicking on Last Selected Radio Button");
				RadioBtnLastSelected.click();
				TestLog.log.info("Clicked on Last Selected Radio Button");
						
				}catch(Exception ex){
					TestLog.log.info("Could not Click on the Last Selected Radio Button. "+ex);
						
				}
					
			}	

	//Click on Save Button
		public void clickSaveBtn(){
					
			try{
				TestLog.log.info("Clicking on Save Button");
				btnSave.click();
				TestLog.log.info("Clicked on Save Button");
						
				}catch(Exception ex){
					TestLog.log.info("Could not Click on the Save Button. "+ex);
						
				}
					
			}	
		
	//Click on Save Ok Button
		public void clickSaveOKBtn(){
					
			try{
				TestLog.log.info("Clicking on Save Ok Button");
				btnSaveOK.click();
				TestLog.log.info("Clicked on Save Ok Button");
						
				}catch(Exception ex){
					TestLog.log.info("Could not Click on the Save Ok Button. "+ex);
						
				}
					
			}
		
	//Click on Save Close Button
		public void clickSaveCloseBtn(){
					
			try{
				TestLog.log.info("Clicking on Save Close Button");
				btnSaveClose.click();
				TestLog.log.info("Clicked on Save Close Button");
						
				}catch(Exception ex){
					TestLog.log.info("Could not Click on the Save Close Button. "+ex);
						
				}
					
			}		
		
	
	//Click on Profile Update Button
		public void clickProfileUpdateBtn(){
					
			try{
				TestLog.log.info("Clicking on Profile Update Button");
				btnProfileUpdate.click();
				TestLog.log.info("Clicked on Profile Update Button");
						
				}catch(Exception ex){
					TestLog.log.info("Could not Click on the Profile Update Button. "+ex);
						
				}
					
			}	
	//Click on Session Dump Button
		public void clickSessionDumpBtn(){
		
		try{
			TestLog.log.info("Clicking on Session Dump Button");
			btnSessionDump.click();
			TestLog.log.info("Clicked on Session Dump Button");
			
			}catch(Exception ex){
				TestLog.log.info("Could not Click on the Session Dump Button. "+ex);
			}
		
		}
		
	//Check on Session Dump User id
		public String checkSessionDumpUserId(){
			String UserId=null;	
		try{
			TestLog.log.info("Checking on Session Dump User Id");
			UserId = SessionDumpUserId.getText();
			TestLog.log.info("Checked on Session Dump User Id");
							
			}catch(Exception ex){
				 TestLog.log.info("Could not Check on the Session Dump User Id. "+ex);
			}
		return UserId;
						
		}		

	//Check on Session Dump User name
		public String checkSessionDumpUserName(){
			String UserName=null;
		try{
			TestLog.log.info("Checking on Session Dump User Name");
			UserName = SessionDumpUserName.getText();
			TestLog.log.info("Checked on Session Dump User Name");
					
			}catch(Exception ex){
					TestLog.log.info("Could not Check on the Session Dump User Name. "+ex);
			}
		return UserName;
				
		}
		
	//Check on Session Dump First name
		public String checkSessionDumpFirstName(){
			String FirstName=null;
		try{
			TestLog.log.info("Checking on Session Dump First Name");
			FirstName = SessionDumpFirstName.getText();
			TestLog.log.info("Checked on Session Dump First Name");
					
			}catch(Exception ex){
					TestLog.log.info("Could not Check on the Session Dump First Name. "+ex);
			}
		return FirstName;
				
		}
		
	//Check on Session Dump Last name
		public String checkSessionDumpLastName(){
			String LastName=null;	
		try{
			TestLog.log.info("Checking on Session Dump Last Name");
			LastName = SessionDumpLastName.getText();
			TestLog.log.info("Checked on Session Dump Last Name");
					
			}catch(Exception ex){
					TestLog.log.info("Could not Check on the Session Dump Last Name. "+ex);
			}
		return LastName;
				
		}
	

}
