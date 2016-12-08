package com.glance.pageobjects.usermanagement;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class ManageAccessPage extends BasePage{

	public ManageAccessPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	
	
	@FindBy(id="group_data")
	WebElement drpSelectGroup;
	
	@FindBy(id="entity_type")
	WebElement drpEntityType;
	
	@FindBy(id="selectEntity_id")
	WebElement drpEntityID;
	
	@FindBy(xpath=("//form[@id='group_access_form']/div[4]/div/input[1]"))
	WebElement optnYes;
	
	@FindBy(xpath=("//form[@id='group_access_form']/div[4]/div/input[2]"))
	WebElement optnNo;
	
	@FindBy(xpath=("//input[@id='submit']"))
	WebElement btnSubmit;
	
	@FindBy(xpath=("//button[@type='button']"))
	WebElement btnCancel;
	
	@FindBy(xpath = ("//button[contains(text(),'Okay')]"))
	WebElement btnok;
	
	@FindBy(xpath = ("//button[@class='btn btn-warning']"))
	WebElement btnokWarning;
	
	
	@FindBy(xpath = ("//button[@class='btn btn-success']"))
	WebElement btnDone;

	@FindBy(xpath = ("//button[contains(text(),'Close')]"))
	WebElement btnClose;
	
	@FindBy(xpath=("//div[@class='x_title']/h2"))
	WebElement pagelbl;
	
	//Verify the Page
			public boolean verifyNavigationToManageAccessPage(String expectedMessage){
				boolean flag = false;
				String actualMessage=pagelbl.getText();
				if (actualMessage.contains(expectedMessage)) {
					flag = true;
					System.out.println("You are in the Manage Access page");
					}
				else {
					System.out.println("You are not in the Manage Access page");
					flag = false;
					}
				return flag;
			}
			
	// or 
	public boolean getTitle(){
		Boolean flag;
		flag= false;
		String title= driver.getPageSource();
		if (title.contains("Manage Access")){
			System.out.println("correct page");
			flag=true;
		}
		return flag;
		
	}
	
	//Select group from drop down menu
		public void selectGroup(String group){
			try{
				TestLog.log.info("Selecting group");
				Select dropdown= new Select(drpSelectGroup);
				dropdown.selectByVisibleText(group);
				
				TestLog.log.info("Group selected");
			
			} catch (Exception ex) {
				
			}
			
		}
	
	//Select entity type from drop down menu
		
		public void selectEntityType(String eType){
			try{
				TestLog.log.info("Selecting entity type");
				//drpJobRole.click();
				Select dropdown= new Select(drpEntityType);
				dropdown.selectByVisibleText(eType);
				
				TestLog.log.info("Entity type selected");
			
			} catch (Exception ex) {
				
			}
			
		}
		
	//Select entity ID from drop down menu
		
		public void selectEntityID(String eId){
			try{
				TestLog.log.info("Selecting ID");
				//drpJobRole.click();
				Select dropdown= new Select(drpEntityID);
				dropdown.selectByVisibleText(eId);
				
				TestLog.log.info("ID selected");
			
			} catch (Exception ex) {
				
			}
			
		}
		
	//Select the access type as yes or no
		
		public void selectAccessType(){
			try{
				TestLog.log.info("Giving access");
					optnYes.click();
					//optnNo.click();
				
				TestLog.log.info("Gave access");
			
			} catch (Exception ex) {
				
			}
			
		}
		
		//Submit
		public void update(){
			try{
				TestLog.log.info("Submitting");
				btnSubmit.click();
				Thread.sleep(5000);
				btnDone.click();
				//btnOk.click();
				TestLog.log.info("Message is displayed");
			
			} catch (Exception ex) {
				
			}
			
		}
		/*public void clickDone(){
			try{
				TestLog.log.info("Select ok in message");
				btnDone.click();
				TestLog.log.info("directed to enter new entry");
			
			} catch (Exception ex) {
				
			}
			
		}*/
		
		//Cancel
			public void cancel(){
				try{
					TestLog.log.info("Canceling");
					btnCancel.click();
					TestLog.log.info("Canceled");
				
				} catch (Exception ex) {
					
				}
				
			}
			
		//Verify message
			public boolean verifyMessage(){
				boolean flag=false;
				String page= driver.getPageSource();
				if(page.contains("Access is given successfully")){
					System.out.println("Message is correct");
					flag=true;
				}
			
				return flag;
				
			}
			
			//Verify alert message when try submitting with empty fields
			public boolean verifyMessageEmptyFields(){
				boolean flag=false;
				String page= driver.getPageSource();
				if(page.contains("Please select all access details!")){
					System.out.println("Message is correct");
					flag=true;
				}
			
				return flag;
				
			}
			
			//click ok to reselect 
			public void clickOk(){
			try{
				TestLog.log.info("Select ok in message");
				btnok.click();
				TestLog.log.info("directed to enter new entry");
			
			} catch (Exception ex) {
				
			}}
			
			//click ok in warning
			public void clickOkInWarning(){
			try{
				TestLog.log.info("Select ok in message");
				btnokWarning.click();
				TestLog.log.info("directed to enter new entry");
			
			} catch (Exception ex) {
				
			}
			
			
		}
}
