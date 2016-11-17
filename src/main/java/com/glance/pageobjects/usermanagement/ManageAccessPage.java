package com.glance.pageobjects.usermanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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
	
	@FindBy(xpath=("//option[text()='Please select entity type']"))
	WebElement drpEntityType;
	
	@FindBy(xpath=("//option[text()='Please select entity id']"))
	WebElement drpEntityID;
	
	@FindBy(id="access_type")
	WebElement drpAccessType;	
	
	@FindBy(id="submit")
	WebElement btnSubmit;
	
	@FindBy(xpath=("//button[@type='button']"))
	WebElement btnCancel;
	
	@FindBy(xpath=("//div[@class='x_title']/h2"))
	WebElement Pagelbl;
	
	/*@FindBy(xpath=("//input[@id='search']"))
	WebElement txtSearch;
	

	@FindBy(id="frm_submit")
	WebElement btnGo;*/
	
	//Get the heading of the page
	public String getTitle(){
		return Pagelbl.getText();
		
		
	}
	
	//Verify the heading
	public void getlabl(String labl){
		String actual=Pagelbl.getText();
		Assert.assertEquals(labl, actual);
	}
	
	
	
	
	//Select group from drop down menu
		public void SelectGroup(String Group){
			try{
				TestLog.log.info("Selecting group");
				Select dropdown= new Select(drpSelectGroup);
				dropdown.selectByVisibleText(Group);
				
				TestLog.log.info("Group selected");
			
			} catch (Exception ex) {
				
			}
			
		}
	
	
		public void SelectEntityType(String EType){
			try{
				TestLog.log.info("Selecting entity type");
				//drpJobRole.click();
				Select dropdown= new Select(drpEntityType);
				dropdown.selectByVisibleText(EType);
				
				TestLog.log.info("Entity type selected");
			
			} catch (Exception ex) {
				
			}
			
		}
		
		public void SelectEntityID(String EId){
			try{
				TestLog.log.info("Selecting ID");
				//drpJobRole.click();
				Select dropdown= new Select(drpEntityID);
				dropdown.selectByVisibleText(EId);
				
				TestLog.log.info("ID selected");
			
			} catch (Exception ex) {
				
			}
			
		}
		
		public void SelectGiveAccess(String Access){
			try{
				TestLog.log.info("Giving access");
				//drpJobRole.click();
				Select dropdown= new Select(drpAccessType);
				dropdown.selectByVisibleText(Access);
				
				TestLog.log.info("Gave access");
			
			} catch (Exception ex) {
				
			}
			
		}
		
		//Submit
		public void Update(){
			try{
				TestLog.log.info("Submitting");
				btnSubmit.click();
				TestLog.log.info("Submitted");
			
			} catch (Exception ex) {
				
			}
			
		}
		
		//Cancel
			public void Cancel(){
				try{
					TestLog.log.info("Canceling");
					btnCancel.click();
					TestLog.log.info("Canceled");
				
				} catch (Exception ex) {
					
				}
				
			}
			
		/*// Search in the page
			public void SearchManageAccess(String KeyWord){
				try{
					TestLog.log.info("Search within the page");
					txtSearch.sendKeys(KeyWord);
					btnGo.click();
					TestLog.log.info("User name is edited");
				
				} catch (Exception ex) {
					
				}
				
			}*/
}
