package com.glance.pageobjects.usermanagement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

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
	
	@FindBy(xpath = "//div[1]/h2")
	WebElement lblEditGroupPage;

	@FindBy(xpath="//input[@id='group_name']")
	WebElement txtEditGroupName;
	
	@FindBy(xpath="//a[@id='linkId']")
	WebElement linkChangeImg;
	
	@FindBy(xpath="//input[@id='myFile']")
	WebElement btnChooseFile;

	@FindBy(xpath="//input[@class='btn btn-success']")
	WebElement btnUpdate;
	
	@FindBy(xpath=("//button[@class='btn btn-success']"))   
	WebElement btnOkayforUpdateGrp;
	
	
	@FindBy(xpath="//div/button[@class='btn btn-primary']")
	WebElement btnCancelUpdate;
	
public void updateGroupName(String grpNameNew){
		
		try{
			TestLog.log.info("Typing on Group Name input field");
							
			txtEditGroupName.clear();
      
			txtEditGroupName.sendKeys(grpNameNew);
		
			Thread.sleep(1000);
			TestLog.log.info("Typed on  Group Name input field");
			
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
   
   public void clickUpdateGroupBtn(){
		
		try{
			TestLog.log.info("Updating group");
			btnUpdate.click();
			Thread.sleep(1000);
			btnOkayforUpdateGrp.click();
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
   
 //verify whether it is Edit Group Page 
   public boolean verifyNavigationToEditGroupPage(String expectedMessageEdit){
		boolean flag = false;
		String actualMessage=lblEditGroupPage.getText();
		if (actualMessage.contains(expectedMessageEdit)) {
			flag = true;
		}
		
		return flag;
		
		
	}
   //verify group details updated
   public boolean verifyUpdated(String grpNameNew) {

       boolean flag = false;

       WebElement tblUser = driver.findElement(By.xpath("//tbody"));
       List<WebElement> tblRow = tblUser.findElements(By.tagName("tr"));

       outerloop: {
              for (WebElement row : tblRow) {

                    List<WebElement> tblData = row
                                  .findElements(By.xpath("//td[3]"));

                    for (WebElement data : tblData) {

                           String groupName = data.getText();
                           System.out.println(groupName);
                           if (groupName.contains(grpNameNew)) {
                                  System.out.println("Successfully Updated the Group Name");
                                  flag = true;
                                  break outerloop;

                           }

                    }

              }
       }
       return flag;
}
	
}

	

