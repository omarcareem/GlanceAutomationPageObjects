package com.glance.pageobjects.userlogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class LostPasswordPage extends BasePage {

	public LostPasswordPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	//Title
	@FindBy(xpath="	//div[1]/h1")
	 WebElement lblLostPasswordTitle;
	
	//Form Attributes
	@FindBy(id="user_id")
	 WebElement txtUserID;
	
	@FindBy(id="email_id")
	 WebElement txtEmailAdd;
	
	@FindBy(id="submit")
	 WebElement submitBtn;
	
	@FindBy(id="backButton")
	 WebElement backBtn;
	
	//Popup msg Box
	@FindBy(xpath="	//div[3]/div")
	 WebElement lblLostPasswordmsg;
	
	@FindBy(xpath="	//div[4]/button[1]")
	 WebElement btnLostPasswordOkay;
	
	@FindBy(xpath="	//div[4]/button[2]")
	 WebElement btnLostPasswordCancel;
	
	
	
	
	
	//Title
	public String getLostPasswordTitle() {

		return lblLostPasswordTitle.getText();

	}
	
	//Form Attributes
	public void enterUserID(String UserName){
		try{
    		TestLog.log.info("Entering user ID");
    		txtUserID.sendKeys("UserName");
    		TestLog.log.info("Entered UserID" );
    	}
    	 catch(Exception ex){
 	 
    	 }
    	
    }
	public void enterEmailAdd(String EmailAdd){
		try{
    		TestLog.log.info("Entering Email Address");
    		txtEmailAdd.sendKeys("EmailAdd");
    		TestLog.log.info("Entered Email Address");
    	}
    	 catch(Exception ex){
 	 
    	 }
    	
    }
	
	public void clickSubmitBtn(){
    	
    	try{
    		TestLog.log.info("Clicking submit button");
    		submitBtn.click();
    		TestLog.log.info("clicked submit button");
    	}
    	 catch(Exception ex){
    	 
    	 }
    	
    }


	public void clickBackBtn(){
	
	try{
		TestLog.log.info("Clicking back button");
		backBtn.click();
		TestLog.log.info("clicked back button");
	}
	 catch(Exception ex){
	 
	 }
	
}

	//For Unsuccess submission 
	public String getLostPasswordMsgContent() {

		return lblLostPasswordTitle.getText();

	}

	public void clickPopupOkay(){
		
		try{
			TestLog.log.info("Clicking back button");
			btnLostPasswordOkay.click();
			TestLog.log.info("clicked back button");
		}
		 catch(Exception ex){
		 
		 }
		
	}
	
	public void clickPopupCancel(){
		
		try{
			TestLog.log.info("Clicking back button");
			btnLostPasswordCancel.click();
			TestLog.log.info("clicked back button");
		}
		 catch(Exception ex){
		 
		 }
		
	}
	
	//For Success submission
	public void switchtoMsgBoxLostPasswordPage(){
 		Alert simpleAlert = driver.switchTo().alert();
 	    String alertText = simpleAlert.getText();
 	    System.out.println("Alert text is " + alertText);
 	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	    simpleAlert.accept();
 	   
 	}
 
}
