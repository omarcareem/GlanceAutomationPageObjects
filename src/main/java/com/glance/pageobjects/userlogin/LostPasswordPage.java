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
	@FindBy(id="user_name")
	 WebElement txtUserName;
	
	@FindBy(id="email_id")
	 WebElement txtEmailAdd;
	
	@FindBy(id="submit")
	 WebElement submitBtn;
	
	@FindBy(id="backButton")
	 WebElement backBtn;
	
	//Popup msg Box
	@FindBy(xpath="	//div/div[3]/div")
	 WebElement lblLostPasswordmsg;
	
	@FindBy(xpath="	//div[4]/button[1]")
	 WebElement btnLostPasswordOkay;
	
	@FindBy(xpath="	//div[4]/button[2]")
	 WebElement btnLostPasswordCancel;
	
	
	
	
	
	//Title
	public boolean getLostPasswordTitle(String lblLostpasswordtTitle) {

		boolean flag = false;

		String popupMessageName = lblLostPasswordTitle.getText();
		if (popupMessageName.contains(lblLostpasswordtTitle)) {
			System.out.println("Navigated to:  " + popupMessageName);
			flag = true;
		} else {
			System.out.println(" navigation is not verified");
			flag = false;
		}
		return flag;

	}
	
	//Form Attributes
	public void enterUserName(String userName){
		try{
    		TestLog.log.info("Entering user Name");
    		txtUserName.clear();
    		txtUserName.sendKeys(userName);
    		TestLog.log.info("Entered User Name" );
    	}
    	 catch(Exception ex){
    		 TestLog.log.info("Could not enter user name "+ex); 
    	 }
    	
    }
	public void enterEmailAdd(String emailAdd){
		try{
    		TestLog.log.info("Entering Email Address");
    		txtEmailAdd.clear();
    		txtEmailAdd.sendKeys(emailAdd);
    		TestLog.log.info("Entered Email Address");
    	}
    	 catch(Exception ex){
    		 TestLog.log.info("Could not enter email address "+ex); 
    	 }
    	
    }
	
	public void clickSubmitBtn(){
    	
    	try{
    		TestLog.log.info("Clicking submit button");
    		submitBtn.click();
    		TestLog.log.info("clicked submit button");
    	}
    	 catch(Exception ex){
    		 TestLog.log.info("Could not Click click on submit botton "+ex); 
    	 }
    	
    }


	public void clickBackBtn(){
	
	try{
		TestLog.log.info("Clicking back button");
		backBtn.click();
		TestLog.log.info("clicked back button");
	}
	 catch(Exception ex){
		 TestLog.log.info("Could not Click on the back button "+ex); 
	 }
	
}

	//For Unsuccess submission 
	public boolean getLostPasswordMsgContent(String lblLostpasswordtmsg) {

		boolean flag = false;

		String popupMessageName = lblLostPasswordmsg.getText();
		if (popupMessageName.contains(lblLostpasswordtmsg)) {
			System.out.println("Invalid lost password request error try is verified:  " + popupMessageName);
			flag = true;
		} else {
			System.out.println("Ivalid lost password request error is not verified");
			flag = false;
		}
		return flag;

	}

	public void clickPopupOkay(){
		
		try{
			TestLog.log.info("Clicking okay button");
			btnLostPasswordOkay.click();
			TestLog.log.info("clicked okay button");
		}
		 catch(Exception ex){
			 TestLog.log.info("Could not Click okay button of msg box. "+ex); 
		 }
		
	}
	
	public void clickPopupCancel(){
		
		try{
			TestLog.log.info("Clicking cacel button");
			btnLostPasswordCancel.click();
			TestLog.log.info("clicked cancel button");
		}
		 catch(Exception ex){
			 TestLog.log.info("Could not Click cancel button of msg box. "+ex); 
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
