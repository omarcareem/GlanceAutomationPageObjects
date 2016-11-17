package com.glance.pageobjects.usermanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class GroupMembershipPage extends BasePage {

	public GroupMembershipPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	@FindBy(id="user_data")
	WebElement drpSelectUser;
	
	@FindBy(id="group_data")
	WebElement drpSelectGroup;
	
	@FindBy(id="submit")
	WebElement btnAddMembership;
	
	@FindBy(xpath=("//button[@type='button']"))
	WebElement btnCancel;
	
	@FindBy(xpath=("//div[@class='x_title']/h2"))
	WebElement Pagelbl;
	
	/*@FindBy(id="frm_submit")
	WebElement btnGo;*/
	
	/*@FindBy(xpath=("//input[@id='search']"))
	WebElement txtSearch;*/
	
	
		

	//Verify the heading
	public void getlabl(String labl){
		String actual=Pagelbl.getText();
		Assert.assertEquals(labl, actual);
	}
	
	public void SelectUser(String User){
		try{
			TestLog.log.info("Selecting user");
	
			drpSelectUser.click();
			Select dropdown= new Select(drpSelectUser);
			dropdown.selectByVisibleText(User);
			TestLog.log.info("User is selected");
		
		} catch (Exception ex) {
			
		}
	}
		
		public void SelectGroup(String Group){
			try{
				TestLog.log.info("Selecting group");
		
				drpSelectGroup.click();
				Select dropdown= new Select(drpSelectGroup);
				dropdown.selectByVisibleText(Group);
				TestLog.log.info("Group is selected");
			
			} catch (Exception ex) {
				
			}
			
	}
		
	//Submit to add member
		public void Submit(){
			try{
				TestLog.log.info("Submitting group membership");
				btnAddMembership.click();
				TestLog.log.info("Group membership is submitted");
			
			} catch (Exception ex) {
				
			}
			
		}
		
	//Canceling
		public void Cancel(){
			try{
				TestLog.log.info("Canceling group membership");
				btnCancel.click();
				TestLog.log.info("canceled and in user details");
					
			} catch (Exception ex) {
						
			}
					
		}
		
	/*// Search in the page
		public void SearchGroupMembership(String KeyWord){
			try{
				TestLog.log.info("Search within the page");
				txtSearch.sendKeys(KeyWord);
				btnGo.click();
				TestLog.log.info("User name is edited");
			
			} catch (Exception ex) {
				
			}
			
		}*/
}
