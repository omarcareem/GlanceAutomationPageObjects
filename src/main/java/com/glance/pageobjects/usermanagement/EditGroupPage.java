package com.glance.pageobjects.usermanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class EditGroupPage extends BasePage{

	public EditGroupPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	

	@FindBy(xpath="//input[@id='group_name']")
	WebElement txtEditGroupName;
	
	@FindBy(xpath="//a[@id='linkId']")
	WebElement linkChangeImg;
	
	@FindBy(xpath="//input[@id='myFile']")
	WebElement btnChooseFile;

	@FindBy(xpath="//input[@class='btn btn-success']")
	WebElement btnUpdate;
	
	@FindBy(xpath="//div[5]/div/button")
	WebElement btnCancelUpdate;
	
	public void updateGroupName(String newGrpName){
		
		try{
			TestLog.log.info("Typing on Group Name input field");
			txtEditGroupName.sendKeys(newGrpName);
			TestLog.log.info("Typed on funding start input field");
			
		}catch(Exception ex){
			System.out.println("Couldn't update Group name");
		}
		
	} 
	
   public void linkChangeImage(){
		
		try{
			TestLog.log.info("clicking the link to change image");
			linkChangeImg.click();
			TestLog.log.info("clicked the link to change image");
			
		}catch(Exception ex){
			System.out.println("update link to image failed");
		}
		
	}  
   
   public void clickChooseFile(){
		
		try{
			TestLog.log.info("choosing the image");
			btnChooseFile.click();
			TestLog.log.info("chosed the image");
			
		}catch(Exception ex){
			System.out.println("choosing a new image failed");
		}
		
	}  
   
    public void clickUpdateGroup(){
	
	try{
		TestLog.log.info("Updating group");
		btnUpdate.click();
		TestLog.log.info("Update group");
		
	}catch(Exception ex){
		System.out.println("Update Group details Failed");
	}
	
}  

   public void clickCancelUpdate(){
	
	try{
		TestLog.log.info("clicking cancel");
		btnCancelUpdate.click();
		TestLog.log.info("clicked cancel");
		
	}catch(Exception ex){
		
	}
	
}
	
}
